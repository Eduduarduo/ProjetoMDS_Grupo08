package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UnidadeFederativaDao;
import exception.ExceptionsUF;

@WebServlet("/servletUnidadeFederativa")
public class ServletUnidadeFederativa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UnidadeFederativaDao unidadeFederativaDao;
	RequestDispatcher rd;
	HttpServletRequest request;
	HttpServletResponse response;
	ExceptionsUF exceptions;

	public ServletUnidadeFederativa() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
				}else{}
			}else{}
		}else{}
	}

	public void ComparacaoUnidadeFederativaPorAno(int ano1, int ano2,
			String uf, HttpServletRequest request) throws ServletException,
			IOException, SQLException {
		this.unidadeFederativaDao = new UnidadeFederativaDao();
		this.request = request;

				this.request.setAttribute("listaUFAbsoluto1",
						this.unidadeFederativaDao
								.buscaUnidadeFederativaAbsoluto(ano1, uf));
				this.request.setAttribute("listaUFRelativo1",
						this.unidadeFederativaDao
								.buscaUnidadeFederativaRelativo(ano1, uf));
				this.request.setAttribute("listaUFAbsoluto2",
						this.unidadeFederativaDao
								.buscaUnidadeFederativaAbsoluto(ano2, uf));
				this.request.setAttribute("listaUFRelativo",
						this.unidadeFederativaDao
								.buscaUnidadeFederativaRelativo(ano2, uf));
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
						unidadeFederativaDao
								.buscaUnidadeFederativaAbsoluto(ano1, uf1));
				request.setAttribute("listaUFRelativo1",
						unidadeFederativaDao
								.buscaUnidadeFederativaRelativo(ano1, uf1));
				request.setAttribute("listaUFAbsoluto2",
						unidadeFederativaDao
								.buscaUnidadeFederativaAbsoluto(ano1, uf2));
				request.setAttribute("listaUFRelativo",
						unidadeFederativaDao
								.buscaUnidadeFederativaRelativo(ano1, uf2));
		}
	

	public void getAnosComparacaoUnidadeFederativa(int ano, HttpServletRequest request)
			throws ServletException, IOException, SQLException {

		
			request.setAttribute("listaDatasComparacao",unidadeFederativaDao.getAnosComparaçãoUnidadeFederativa(ano));
		

	}

}
