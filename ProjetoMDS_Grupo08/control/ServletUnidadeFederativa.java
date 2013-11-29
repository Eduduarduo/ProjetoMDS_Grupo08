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

import model.UnidadeFederativa;
import dao.UnidadeFederativaDao;
import exception.ExceptionsUF;

@WebServlet("/servletUnidadeFederativa")
public class ServletUnidadeFederativa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UnidadeFederativaDao unidadeFederativaDao;
	RequestDispatcher rd;
	HttpServletRequest request;
	HttpServletResponse response;
	ExceptionsUF exception;

	public ServletUnidadeFederativa() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			switch (request.getParameter("sg")) {
			case "simples":
				getAnos(unidadeFederativaDao, request);
				rd = request.getRequestDispatcher("ufBusca.jsp");
				rd.forward(request, response);
				break;
			case "ano":
				getAnos(unidadeFederativaDao, request);
				rd = request.getRequestDispatcher("ufComparacaoAno.jsp");
				rd.forward(request, response);
				break;
			case "uf":
				getAnos(unidadeFederativaDao, request);
				rd = request.getRequestDispatcher("ufComparacaoUF.jsp");
				rd.forward(request, response);
				break;
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int ano1 = Integer.parseInt(request.getParameter("ano1"));
		int ano2 = Integer.parseInt(request.getParameter("ano2"));
		String uf1 = request.getParameter("uf1");
		String uf2 = request.getParameter("uf2");

		try {
			switch (request.getParameter("cmd")) {
			case "busca":
				buscaUnidadeFederativa(ano1, uf1, unidadeFederativaDao,
						exception, request);
				rd = request.getRequestDispatcher("brasilBusca.jsp");
				rd.forward(request, response);
				break;
			case "ComparacaoAno":
				ComparacaoUnidadeFederativaPorAno(ano1, ano2, uf1, request);
				rd = request.getRequestDispatcher("brasilComparacaoAno.jsp");
				rd.forward(request, response);
				break;
			case "ComparacaoUF":
				ComparacaoPorUF(ano1, uf1, uf2, unidadeFederativaDao, request);
				rd = request.getRequestDispatcher("brasilComparacaoUF.jsp");
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
			UnidadeFederativaDao unidadeFederativaDao, ExceptionsUF exception,
			HttpServletRequest request) throws ServletException, IOException,
			SQLException {

		this.unidadeFederativaDao = unidadeFederativaDao;
		this.request = request;

		if (exception.verificaParamentroUF(uf) == true) {
			if (exception.validaListaUFTipoAbsoluto(this.unidadeFederativaDao
					.buscaUnidadeFederativaAbsoluto(ano, uf)) == true) {
				if (exception
						.validaListaUFTipoRelativo(this.unidadeFederativaDao
								.buscaUnidadeFederativaRelativo(ano, uf)) == true) {
					request.setAttribute("listaUFAbsoluto1",
							this.unidadeFederativaDao
									.buscaUnidadeFederativaAbsoluto(ano, uf));
					request.setAttribute("listaUFRelativo1",
							this.unidadeFederativaDao
									.buscaUnidadeFederativaRelativo(ano, uf));
				
					//Obtendo somente uma lista
					List<UnidadeFederativa> lista;
					lista.addAll(this.unidadeFederativaDao
							.buscaUnidadeFederativaAbsoluto(ano, uf));
					lista.addAll(this.unidadeFederativaDao
							.buscaUnidadeFederativaRelativo(ano, uf));
					
					//Passando a lista para o Json
					Gson gson = new Gson();
					String resp = gson.toJson(lista);

					response.getWriter().write(resp);
					response.getWriter().flush();
					response.getWriter().close();

				} else {rd = request.getRequestDispatcher("erro.jsp");
				rd.forward(request, response);
				}
			} else {rd = request.getRequestDispatcher("erro.jsp");
			rd.forward(request, response);
			}
		} else {rd = request.getRequestDispatcher("erro.jsp");
		rd.forward(request, response);
		}
	}

	public void ComparacaoUnidadeFederativaPorAno(int ano1, int ano2,
			String uf, HttpServletRequest request) throws ServletException,
			IOException, SQLException {
		this.unidadeFederativaDao = new UnidadeFederativaDao();
		this.request = request;

		this.request.setAttribute("listaUFAbsoluto1", this.unidadeFederativaDao
				.buscaUnidadeFederativaAbsoluto(ano1, uf));
		this.request.setAttribute("listaUFRelativo1", this.unidadeFederativaDao
				.buscaUnidadeFederativaRelativo(ano1, uf));
		this.request.setAttribute("listaUFAbsoluto2", this.unidadeFederativaDao
				.buscaUnidadeFederativaAbsoluto(ano2, uf));
		this.request.setAttribute("listaUFRelativo", this.unidadeFederativaDao
				.buscaUnidadeFederativaRelativo(ano2, uf));
		
		//Criando uma lista só
		List<UnidadeFederativa> lista;
		lista.addAll(this.unidadeFederativaDao
				.buscaUnidadeFederativaAbsoluto(ano1, uf));
		lista.addAll(this.unidadeFederativaDao
				.buscaUnidadeFederativaRelativo(ano1, uf));
		lista.addAll(this.unidadeFederativaDao
				.buscaUnidadeFederativaAbsoluto(ano2, uf));
		lista.addAll(this.unidadeFederativaDao
				.buscaUnidadeFederativaRelativo(ano2, uf));
		
		//Passando a lista para o Json
		Gson gson = new Gson();
		String resp = gson.toJson(lista);

		response.getWriter().write(resp);
		response.getWriter().flush();
		response.getWriter().close();
	
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

		request.setAttribute("listaDatas",
				unidadeFederativaDao.getUnidadeFederativa());
	}

	public void ComparacaoPorUF(int ano1, String uf1, String uf2,
			UnidadeFederativaDao unidadeFederativaDao,
			HttpServletRequest request) throws ServletException, IOException,
			SQLException {

		request.setAttribute("listaUFAbsoluto1",
				unidadeFederativaDao.buscaUnidadeFederativaAbsoluto(ano1, uf1));
		request.setAttribute("listaUFRelativo1",
				unidadeFederativaDao.buscaUnidadeFederativaRelativo(ano1, uf1));
		request.setAttribute("listaUFAbsoluto2",
				unidadeFederativaDao.buscaUnidadeFederativaAbsoluto(ano1, uf2));
		request.setAttribute("listaUFRelativo",
				unidadeFederativaDao.buscaUnidadeFederativaRelativo(ano1, uf2));
	
		List<UnidadeFederativa> lista;
		//Montando somente uma lista
		lista.addAll(unidadeFederativaDao.buscaUnidadeFederativaAbsoluto(ano1, uf1));
		lista.addAll(unidadeFederativaDao.buscaUnidadeFederativaRelativo(ano1, uf1));
		lista.addAll(unidadeFederativaDao.buscaUnidadeFederativaAbsoluto(ano1, uf2));
		lista.addAll(unidadeFederativaDao.buscaUnidadeFederativaRelativo(ano1, uf2));
	
		Gson gson = new Gson();
		String resp = gson.toJson(lista);
		response.getWriter().write(resp);
		response.getWriter().flush();
		response.getWriter().close();

			
	}

	public void getAnosComparacaoUnidadeFederativa(int ano,
			HttpServletRequest request) throws ServletException, IOException,
			SQLException {

		request.setAttribute("listaDatasComparacao",
				unidadeFederativaDao.getAnosComparaçãoUnidadeFederativa(ano));

	}

}
