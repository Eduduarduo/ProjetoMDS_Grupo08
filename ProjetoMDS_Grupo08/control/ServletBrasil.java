package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Brasil;
import dao.BrasilDao;
import exception.ExceptionsBrasil;

@WebServlet(name = "/ServletBrasil", urlPatterns = "/buscaBrasil")
public class ServletBrasil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BrasilDao brasilDao= new BrasilDao();
	RequestDispatcher rd;
	HttpServletRequest request;
	HttpServletResponse response;
	ExceptionsBrasil exception;

	public ServletBrasil() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			switch (request.getParameter("pg")) {
			case "simples":
				getAnos(this.brasilDao, request);
				rd = request.getRequestDispatcher("/brasilBusca.jsp");
				rd.forward(request, response);
				break;
			case "composto":
				getAnos(this.brasilDao, request);
				rd = request.getRequestDispatcher("brasilComparacao.jsp");
				rd.forward(request, response);
		default:
				rd = request.getRequestDispatcher("erro.jsp");
				rd.forward(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			rd = request.getRequestDispatcher("erro.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		request.getParameter("cmd");
		
		int ano = Integer.parseInt(request.getParameter("ano1"));
		int ano2=0;
		try {
			ano2 = Integer.parseInt(request.getParameter("ano2"));
			
		} catch (Exception e) {
			System.out.println("n�o tem o ano 2");
		}
		
		
		ExceptionsBrasil exception = new ExceptionsBrasil();
		try {
			switch (request.getParameter("cmd")) {
			case "busca":
				buscaBrasilPorAno(ano, brasilDao, request,response ,exception);
				
				rd = request.getRequestDispatcher("brasilBusca.jsp");
				break;
			case "Comparacao":
				comparacaoPorAno(ano, ano2, brasilDao, request,response);
				rd = request.getRequestDispatcher("brasilComparacao.jsp");
			default:
				rd = request.getRequestDispatcher("erro.jsp");
				rd.forward(request, response);
				break;
			}
		} catch (Exception e) {
			rd = request.getRequestDispatcher("erro.jsp");
			rd.forward(request, response);
		}
	}
	
	public void buscaBrasilPorAno(int ano, BrasilDao brasildao,
			HttpServletRequest request,HttpServletResponse response ,ExceptionsBrasil exception)
			throws ServletException, IOException, SQLException {

		this.brasilDao = brasildao;
		this.request = request;
		this.exception = exception;
		this.response = response;

		if (exception.verificaParamentroAno(ano) == true) {
				
				
				System.out.println("estou na busca brasil e vou gerar as listas");
				List<Brasil> lista1=this.brasilDao.buscaBrasilAbsoluto(ano);
				
				List<Brasil> lista2=this.brasilDao.buscaBrasilRelativo(ano);
			
				List<Brasil> lista= new ArrayList<>(lista1.size()+ lista2.size()); 
				
				lista.addAll(lista1);
				lista.addAll(lista2);
				
				request.setAttribute("listaBrasil",lista);
				
				Gson gson = new Gson();
				String resp = gson.toJson(lista);
				response.getWriter().write(resp);
				response.getWriter().flush();
				response.getWriter().close();
			
			}else{
			rd = request.getRequestDispatcher("erro.jsp");
	}}
	
	
	
	public void comparacaoPorAno(int ano1, int ano2, BrasilDao brasildao,
			HttpServletRequest request,HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		this.brasilDao = brasildao;
		this.request = request;
		this.exception = new ExceptionsBrasil();

		if ( exception.verificaParamentroAno(ano1)== true && exception.verificaParamentroAno(ano2) == true){
					
				List<Brasil> lista1=this.brasilDao.buscaBrasilAbsoluto(ano1);
				List<Brasil> lista2=this.brasilDao.buscaBrasilAbsoluto(ano2);
				List<Brasil> lista= new ArrayList<>(lista1.size()+ lista2.size()); 
				lista.addAll(lista1);
				lista.addAll(lista2);
				//request.setAttribute("listaBrasil",lista);
				//Gson gson = new Gson();
				//String resp = gson.toJson(lista);
				//response.getWriter().write(resp);
				 //response.getWriter().flush();
				//response.getWriter().close();
			
			} else{
				rd = request.getRequestDispatcher("erro.jsp");
	}
		}
	
	
	public void getAnos(BrasilDao brasildao, HttpServletRequest request)
			throws ServletException, IOException, SQLException {
		this.brasilDao = brasildao;
		this.request = request;
		this.request.setAttribute("listaDatas", this.brasilDao.getDatas());
	}


	public void getAnosComparacao(int ano, BrasilDao brasildao,
			HttpServletRequest request) throws ServletException, IOException,
			SQLException {
		this.brasilDao = brasildao;
		this.request = request;
		
		
				this.request.setAttribute("listaDatasComparacao",
					this.brasilDao.getDatasComparacao(ano));
		}
		
			}


