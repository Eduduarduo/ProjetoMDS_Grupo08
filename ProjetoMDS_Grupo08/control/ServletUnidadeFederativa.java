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



import model.UnidadeFederativa;
import dao.UnidadeFederativaDao;
import exception.ExceptionsUF;

@WebServlet(name = "/ServletUnidadeFederativa", urlPatterns = "/buscaUf")
public class ServletUnidadeFederativa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UnidadeFederativaDao unidadeFederativaDao = new UnidadeFederativaDao();
	RequestDispatcher rd;
	HttpServletRequest request;
	HttpServletResponse response;
	ExceptionsUF exception = new ExceptionsUF();

	public ServletUnidadeFederativa() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			switch (request.getParameter("pg")) {
			case "simples":
				getAnos(unidadeFederativaDao, request);
				getUnidadesFederativas(unidadeFederativaDao, request);
				rd = request.getRequestDispatcher("/ufBusca.jsp");
				rd.forward(request, response);
				break;
			case "ano":
				getAnos(unidadeFederativaDao, request);
				getUnidadesFederativas(unidadeFederativaDao, request);
				rd = request.getRequestDispatcher("/ufComparacaoAno.jsp");
				rd.forward(request, response);
				break;
			case "uf":
				getAnos(unidadeFederativaDao, request);
				getUnidadesFederativas(unidadeFederativaDao, request);
				rd = request.getRequestDispatcher("/ufComparacaoUf.jsp");
				rd.forward(request, response);
				break;
			default:

				rd = request.getRequestDispatcher("erro.jsp");
				rd.forward(request, response);
				break;
			}
		} catch (Exception e) {
			System.out.println("ta danso erro");
			rd = request.getRequestDispatcher("erro.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int ano, ano1, ano2;
		String uf, uf1, uf2;

		try {
			switch (request.getParameter("cmd")) {
			case "busca":
				ano = Integer.parseInt(request.getParameter("ano"));
				uf = request.getParameter("uf");

				buscaUnidadeFederativa(ano, uf, unidadeFederativaDao,
						request, response);
				rd = request.getRequestDispatcher("ufBusca.jsp");
				rd.forward(request, response);
				break;
			case "ComparacaoAno":
				ano1 = Integer.parseInt(request.getParameter("ano1"));
				ano2 = Integer.parseInt(request.getParameter("ano2"));
				uf = request.getParameter("uf");

				ComparacaoUnidadeFederativaPorAno(ano1, ano2, uf, request,
						response);
				rd = request.getRequestDispatcher("ufComparacaoAno.jsp");
				rd.forward(request, response);
				break;
			case "ComparacaoUF":

				ano = Integer.parseInt(request.getParameter("ano"));

				uf1 = request.getParameter("uf1");
				uf2 = request.getParameter("uf2");

				ComparacaoPorUF(ano, uf1, uf2, request,
						response);
				rd = request.getRequestDispatcher("ufComparacaoUf.jsp");
				rd.forward(request, response);
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

	public void buscaUnidadeFederativa(int ano, String uf,
			UnidadeFederativaDao unidadeFederativaDao,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		this.unidadeFederativaDao = unidadeFederativaDao;
		this.request = request;
		this.response = response;
		exception =new ExceptionsUF();

		if (exception.verificaParamentroUF(uf) == true) {
			if (exception.verificaParamentroAnoUF(ano) == true) {
					List<UnidadeFederativa> lista1 = this.unidadeFederativaDao
							.buscaUnidadeFederativaAbsoluto(ano, uf);
					List<UnidadeFederativa> lista2 = this.unidadeFederativaDao
							.buscaUnidadeFederativaRelativo(ano, uf);
					// Obtendo somente uma lista
					List<UnidadeFederativa> lista = new ArrayList<>(
							lista1.size() + lista2.size());
					lista.addAll(lista1);
					lista.addAll(lista2);

					request.setAttribute("listaUnidadeFederativa", lista);

					// Passando a lista para o Json
					Gson gson = new Gson();
					String resp = gson.toJson(lista);
					response.getWriter().write(resp);
					response.getWriter().flush();
					response.getWriter().close();

				} else {
					rd = request.getRequestDispatcher("erro.jsp");
				}
			} else {
				rd = request.getRequestDispatcher("erro.jsp");

			}			}

	public void ComparacaoUnidadeFederativaPorAno(int ano1, int ano2,
			String uf, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		this.unidadeFederativaDao = new UnidadeFederativaDao();
		this.request = request;
		this.response = response;

		if (exception.verificaParamentroAnoUF(ano1)==true  && exception.verificaParamentroAnoUF(ano2) == true) {
			if (exception.verificaParamentroUF(uf) == true) {
				System.out.println("criando listas de uniades federativas"
						+ ano1 + ano2 + uf);
				List<UnidadeFederativa> lista1 = this.unidadeFederativaDao
						.buscaUnidadeFederativaAbsoluto(ano1, uf);
				List<UnidadeFederativa> lista2 = this.unidadeFederativaDao
						.buscaUnidadeFederativaAbsoluto(ano2, uf);
				// Criando uma lista
				List<UnidadeFederativa> lista = new ArrayList<>(lista1.size()
						+ lista2.size());
				lista.addAll(lista1);
				lista.addAll(lista2);

				request.setAttribute("listaUnidadeFederativa", lista);
				System.out.println("concatenei e mandei para o gson");
				// Passando a lista para o Json
				 Gson gson = new Gson();
				 String resp = gson.toJson(lista);
				 response.getWriter().write(resp);
				 response.getWriter().flush();
				 response.getWriter().close();
			} else {
				rd = request.getRequestDispatcher("erro.jsp");
			}
		} else {
			rd = request.getRequestDispatcher("erro.jsp");
		}
	}

	public void getAnos(UnidadeFederativaDao unidadeFederativaDao,
			HttpServletRequest request) throws ServletException, IOException,
			SQLException {

		request.setAttribute("listaDatas",
				unidadeFederativaDao.getAnosUnidadeFederativa());
	}

	public void getUnidadesFederativas(
			UnidadeFederativaDao unidadeFederativaDao,
			HttpServletRequest request) throws ServletException, IOException,
			SQLException {

		request.setAttribute("listaRegioes",
				unidadeFederativaDao.getUnidadeFederativa());
	}

	public void ComparacaoPorUF(int ano, String uf1, String uf2,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		this.unidadeFederativaDao =  new UnidadeFederativaDao();
		this.request = request;
		this.response = response;

		if(exception.verificaParamentroAnoUF(ano)== true){
		if (exception.verificaParamentroUF(uf1)== true && exception.verificaParamentroUF(uf2) == true) {
				List<UnidadeFederativa> lista1 = this.unidadeFederativaDao
						.buscaUnidadeFederativaAbsoluto(ano, uf1);
				List<UnidadeFederativa> lista2 = this.unidadeFederativaDao
						.buscaUnidadeFederativaAbsoluto(ano, uf2);
				List<UnidadeFederativa> lista = new ArrayList<>(lista1.size()
						+ lista2.size());
				// Montando somente uma lista
				lista.addAll(lista1);
				lista.addAll(lista2);
				request.setAttribute("listaUnidadeFederativa", lista);
				Gson gson = new Gson();
				String resp = gson.toJson(lista);
				response.getWriter().write(resp);
				response.getWriter().flush();
				response.getWriter().close();
		
		} else {
			rd = request.getRequestDispatcher("erro.jsp");
		}
		}else {
			rd = request.getRequestDispatcher("erro.jsp");}

	}

	public void getAnosComparacaoUnidadeFederativa(int ano,HttpServletRequest request)
			throws ServletException, IOException, SQLException {
		if (exception.verificaParamentroAnoUF(ano) == true) {
			request.setAttribute("listaDatasComparacao",
					unidadeFederativaDao.getAnosComparacaoUnidadeFederativa(ano));
		}else {
			rd = request.getRequestDispatcher("erro.jsp");
		}
		
	}

}
