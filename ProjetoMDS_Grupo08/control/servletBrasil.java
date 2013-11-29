package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Brasil;
import model.UnidadeFederativa;
import dao.BrasilDao;
import exception.ExceptionsBrasil;

@WebServlet(name = "/servletBrasil", urlPatterns = "/buscaBrasil")
public class ServletBrasil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BrasilDao brasilDao = new BrasilDao();;
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

		brasilDao = new BrasilDao();
		int ano = Integer.parseInt(request.getParameter("ano1"));
		int ano2 = Integer.parseInt(request.getParameter("ano1"));

		ExceptionsBrasil exception = new ExceptionsBrasil();
		try {
			switch (request.getParameter("cmd")) {
			case "busca":
				buscaBrasilPorAno(ano, brasilDao, request, exception);
				getAnos(this.brasilDao, request);
				getAnosComparacao(ano, brasilDao, request);
				rd = request.getRequestDispatcher("brasilBusca.jsp");
				break;
			case "Comparacao":
				buscaBrasilPorAno(ano, brasilDao, request, exception);
				getAnos(this.brasilDao, request);
				getAnosComparacao(ano, brasilDao, request);
				comparacaoPorAno(ano, ano2, brasilDao, request, exception);
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
			HttpServletRequest request, ExceptionsBrasil exception)
			throws ServletException, IOException, SQLException {

		this.brasilDao = brasildao;
		this.request = request;
		this.exception = exception;

		if (this.exception.verificaParamentroAno(ano) == true) {
			if (this.exception.validaGerarGrafico(
					this.brasilDao.buscaBrasilAbsoluto(ano),
					this.brasilDao.buscaBrasilRelativo(ano)) == true) {
				
				
				request.setAttribute("listaBrasilAbsolutoAno1",
						this.brasilDao.buscaBrasilAbsoluto(ano));
				request.setAttribute("listaBrasilRelativoAno1",
						this.brasilDao.buscaBrasilRelativo(ano));
			
				List<Brasil> lista = null;
				
				lista.addAll(this.brasilDao.buscaBrasilAbsoluto(ano));
				lista.addAll(this.brasilDao.buscaBrasilRelativo(ano));
				
				Gson gson = new Gson();
				String resp = gson.toJson(lista);
				response.getWriter().write(resp);
				response.getWriter().flush();
				response.getWriter().close();
			
			}
			rd = request.getRequestDispatcher("erro.jsp");
		}
		rd = request.getRequestDispatcher("erro.jsp");
	}

	public void comparacaoPorAno(int ano1, int ano2, BrasilDao brasildao,
			HttpServletRequest request, ExceptionsBrasil exception)
			throws SQLException, ServletException, IOException {
		this.brasilDao = brasildao;
		this.request = request;
		this.exception = exception;

		if (this.exception.verificaCampoDeParametroComparacao(ano1, ano2) == true) {
			if (this.exception.validaComparacao(
					this.brasilDao.buscaBrasilAbsoluto(ano1),
					this.brasilDao.buscaBrasilRelativo(ano1),
					this.brasilDao.buscaBrasilAbsoluto(ano2),
					this.brasilDao.buscaBrasilRelativo(ano2)) == true) {
				request.setAttribute("listaBrasilAbsolutoAno1",
						this.brasilDao.buscaBrasilAbsoluto(ano1));
				request.setAttribute("listaBrasilRelativoAno1",
						this.brasilDao.buscaBrasilRelativo(ano1));
				request.setAttribute("listaBrasilAbsolutoAno2",
						this.brasilDao.buscaBrasilAbsoluto(ano2));
				request.setAttribute("listaBrasilRelativoAno2",
						this.brasilDao.buscaBrasilRelativo(ano2));
			
				List<Brasil> lista = null;
				lista.addAll(this.brasilDao.buscaBrasilAbsoluto(ano1));
				lista.addAll(this.brasilDao.buscaBrasilRelativo(ano1));
				lista.addAll(this.brasilDao.buscaBrasilAbsoluto(ano2));
				lista.addAll(this.brasilDao.buscaBrasilRelativo(ano2));
				
				Gson gson = new Gson();
				String resp = gson.toJson(lista);
				response.getWriter().write(resp);
				response.getWriter().flush();
				response.getWriter().close();
			
			
			} else
				rd = request.getRequestDispatcher("erro.jsp");
		} else
			rd = request.getRequestDispatcher("erro.jsp");
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
				this.brasilDao.getDatasComparacaoo(ano));
	}

}
