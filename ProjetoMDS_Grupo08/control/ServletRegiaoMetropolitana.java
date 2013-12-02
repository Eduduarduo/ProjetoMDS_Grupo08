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

import dao.RegiaoMetropolitanaDao;
import model.RegiaoMetropolitana;
import exception.ExceptionRegiaoMetropolitana;


@WebServlet(name ="/ServletRegiaoMetropolitana", urlPatterns ="/buscaRegiao")
public class ServletRegiaoMetropolitana extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RegiaoMetropolitanaDao regiaoMetropolitanaDao= new RegiaoMetropolitanaDao();
	RequestDispatcher rd;
	HttpServletRequest request;
	HttpServletResponse response;
	ExceptionRegiaoMetropolitana exceptions= new ExceptionRegiaoMetropolitana();
	
	public ServletRegiaoMetropolitana() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
			try{
				switch(request.getParameter("pg")){
				case "simples":
					getAnosRegiaoMetropolitana(request);
					getRegioesRegiaoMetropolitana(request);
					rd = request.getRequestDispatcher("/regiaoBusca.jsp");
					rd.forward(request, response);
					break;
				case "ano":
					getAnosRegiaoMetropolitana(request);
					getRegioesRegiaoMetropolitana(request);
					rd = request.getRequestDispatcher("/regiaoComparacaoAno.jsp");
					rd.forward(request, response);
					break;
				case "regiao":
					getAnosRegiaoMetropolitana(request);
					getRegioesRegiaoMetropolitana(request);
					rd = request.getRequestDispatcher("/regiaoComparacaoRegiao.jsp");
					rd.forward(request, response);
					break;
				default:
					rd = request.getRequestDispatcher("erro.jsp");
					rd.forward(request, response);
					break;
				
				}
			}catch(Exception e){
				rd = request.getRequestDispatcher("regiaoOpcao.html");
				rd.forward(request, response);
			}
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.regiaoMetropolitanaDao = new RegiaoMetropolitanaDao();
		
		int ano,ano1,ano2;
		String regiao, regiao1, regiao2;
		
			
		try{
			switch (request.getParameter("cmd")) {
			case "busca":
				
				ano = Integer.parseInt(request.getParameter("ano"));
				regiao = request.getParameter("regiao");
				
				buscaRegiaoMetropolitana(regiao,ano,request, response);
				this.rd = request.getRequestDispatcher("regiaoBusca.jsp");
				this.rd.forward(request, response);
				break;
			
			case "comparacaoAno":
				
				ano1 = Integer.parseInt(request.getParameter("ano1"));
				ano2 = Integer.parseInt(request.getParameter("ano2"));
				regiao = request.getParameter("regiao");	
				
				ComparacaoRegiaoMetropolitanaPorAno(regiao, ano1, ano2, request, response);
				this.rd = request.getRequestDispatcher("regiaoComparacaoAno.jsp");
				this.rd.forward(request, response);
				break;
			
			case "comparacaoRegiao":
				
				ano = Integer.parseInt(request.getParameter("ano"));
				regiao1 = request.getParameter("regiao1");
				regiao2 = request.getParameter("regiao2");
				
				ComparacaoRegiaoMetropolitanaPorRegiao(regiao1, ano, regiao2, request, response);
				this.rd = request.getRequestDispatcher("regiaoComparacaoRegiao.jsp");
				this.rd.forward(request, response);
				break;
	
			default:
				rd = request.getRequestDispatcher("erro.jsp");
				rd.forward(request, response);
				break;
			}
		}catch(Exception e){
			rd = request.getRequestDispatcher("erro.jsp");
			rd.forward(request, response);
		}
	}

	public void buscaRegiaoMetropolitana(String regiao, int ano, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		this.regiaoMetropolitanaDao = new RegiaoMetropolitanaDao();
		this.request = request;
		this.response= response;
		this.exceptions = new ExceptionRegiaoMetropolitana();
		
		//exception
		boolean validacaoLista = this.exceptions.validaGerarGraficoBusca(this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano),
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao, ano));
			
		if(this.exceptions.verificaCampoDeParametro(regiao, ano) == true && validacaoLista == true){
			
			List<RegiaoMetropolitana> listaAbsoluto = this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano);
			List<RegiaoMetropolitana> listaRelativo = this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao, ano);
			
			//Obtendo somente uma lista
			List<RegiaoMetropolitana> lista = new ArrayList<>(listaAbsoluto.size() + listaRelativo.size());
			
			lista.addAll(listaAbsoluto);
			lista.addAll(listaRelativo);
			
			request.setAttribute("listaRegiao Metropolitana",lista);
			
			//Passando a lista para o Json
			Gson gson = new Gson();
			String resp = gson.toJson(lista);

			response.getWriter().write(resp);
			response.getWriter().flush();
			response.getWriter().close();	
		}else{
			rd = request.getRequestDispatcher("erro.jsp");
			rd.forward(request, response);
		}
		
	}

	
	public void ComparacaoRegiaoMetropolitanaPorAno(String regiao, int ano1, int ano2, 
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException, SQLException{

			this.regiaoMetropolitanaDao = new RegiaoMetropolitanaDao();
			this.request = request;
			this.response= response;
			this.exceptions = new ExceptionRegiaoMetropolitana();
			
			boolean validacaoList = this.exceptions.validaGerarGraficoComparacao(
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano1),
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano2));
	
			if(this.exceptions.verificaCampoDeParametro(regiao, ano1, ano2) == true && validacaoList == true){
				
				List<RegiaoMetropolitana> listaAbsoluto1 = this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano1);
				List<RegiaoMetropolitana> listaAbsoluto2 = this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano2);
		
				//Obtendo somente uma lista
				List<RegiaoMetropolitana> lista = new ArrayList<>(listaAbsoluto1.size() + listaAbsoluto2.size());
				
				lista.addAll(listaAbsoluto1);
				lista.addAll(listaAbsoluto2);
				
				request.setAttribute("listaComparacaoAno", lista);
				
				
				//Passando a lista para o Json
				Gson gson = new Gson();
				String resp = gson.toJson(lista);

				response.getWriter().write(resp);
				response.getWriter().flush();
				response.getWriter().close();		
				
			}else{
				rd = request.getRequestDispatcher("erro.jsp");
				//rd.forward(request, response);	
			}
			
	}

		
	public void ComparacaoRegiaoMetropolitanaPorRegiao(String regiao1,int ano1, String regiao2, HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException, SQLException{
		
			this.regiaoMetropolitanaDao = new RegiaoMetropolitanaDao();
			this.request = request;
			this.response= response;
			this.exceptions = new ExceptionRegiaoMetropolitana();
			
			boolean validacaoList = this.exceptions.validaGerarGraficoComparacao(
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao1, ano1),
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao2, ano1));
				
			if(this.exceptions.verificaCampoDeParametro(regiao1, regiao2, ano1) == true && validacaoList == true){
				
				List<RegiaoMetropolitana> listaAbsoluto1 = this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao1, ano1);
				List<RegiaoMetropolitana> listaAbsoluto2 = this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao2, ano1);
				
				//Obtendo somente uma lista
				List<RegiaoMetropolitana> lista = new ArrayList<>(listaAbsoluto1.size() + listaAbsoluto2.size());
				
				lista.addAll(listaAbsoluto1);
				lista.addAll(listaAbsoluto2);
				
				request.setAttribute("listaComparacaoRegiao",lista);
				
				//Passando a lista para o Json
				Gson gson = new Gson();
				String resp = gson.toJson(lista);

				response.getWriter().write(resp);
				response.getWriter().flush();
				response.getWriter().close();
				
			}else{
				rd = request.getRequestDispatcher("erro.jsp");
				rd.forward(request, response);
				
			}
	}
	
	public void getAnosRegiaoMetropolitana(HttpServletRequest request) throws ServletException, IOException, SQLException {
		this.exceptions = new ExceptionRegiaoMetropolitana();
		this.regiaoMetropolitanaDao = new RegiaoMetropolitanaDao();
		
		if(this.exceptions.validaListBox(this.regiaoMetropolitanaDao.getAnosRegiaoMetropolitana()) == true ){
			request.setAttribute("listaDatas", this.regiaoMetropolitanaDao.getAnosRegiaoMetropolitana());
		}
				
	}


	public void getRegioesRegiaoMetropolitana(HttpServletRequest request) throws ServletException, IOException, SQLException{
		this.regiaoMetropolitanaDao = new RegiaoMetropolitanaDao();
		this.exceptions = new ExceptionRegiaoMetropolitana();
	
		if(this.exceptions.validaListBox(this.regiaoMetropolitanaDao.getRegioesRegiaoMetropolitana()) == true){
			request.setAttribute("listaRegioes", this.regiaoMetropolitanaDao.getRegioesRegiaoMetropolitana());
		}
		
	}
	
}
