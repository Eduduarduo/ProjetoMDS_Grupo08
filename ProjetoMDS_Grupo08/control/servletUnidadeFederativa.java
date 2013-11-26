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
import exception.ExceptionsServlets;

@WebServlet("/servletUnidadeFederativa")
public class servletUnidadeFederativa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UnidadeFederativaDao unidadeFederativaDao;
	RequestDispatcher rd;
	HttpServletRequest request;
	HttpServletResponse response;
	ExceptionsServlets exceptions;

	public servletUnidadeFederativa() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	public void buscaUnidadeFederativa(int ano, String uf,
			UnidadeFederativaDao unidadeFederativaDao, RequestDispatcher rd,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		this.rd = rd;
		this.unidadeFederativaDao = unidadeFederativaDao;
		this.request = request;
		this.response = response;
		this.exceptions = new ExceptionsServlets();

		boolean validacao = this.exceptions.validarListasUF(
				this.unidadeFederativaDao.buscaUnidadeFederativaRelativo(ano,uf),
				this.unidadeFederativaDao.buscaUnidadeFederativaAbsoluto(ano, uf));

		if (validacao == true) {

			request.setAttribute("listaUFAbsoluto1", this.unidadeFederativaDao
					.buscaUnidadeFederativaAbsoluto(ano, uf));
			request.setAttribute("listaUFRelativo1", this.unidadeFederativaDao
					.buscaUnidadeFederativaRelativo(ano, uf));
			this.rd = this.request.getRequestDispatcher("brasil.jsp");
			this.rd.forward(this.request, this.response);
		} else {
			carregarPaginaErro();
		}
	}

	public void ComparacaoUnidadeFederativaPorAno(int ano1, int ano2,String uf,
			UnidadeFederativaDao unidadeFederativaDao, RequestDispatcher rd,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		{
			this.rd = rd;
			this.unidadeFederativaDao = unidadeFederativaDao;
			this.request = request;
			this.response = response;
			this.exceptions = new ExceptionsServlets();

			
			boolean validacao = this.exceptions.validarListasUF(
					this.unidadeFederativaDao.buscaUnidadeFederativaRelativo(ano1,uf),
					this.unidadeFederativaDao.buscaUnidadeFederativaAbsoluto(ano1, uf));
			
			boolean comparacao = this.exceptions.validarListasUF(
					this.unidadeFederativaDao.buscaUnidadeFederativaRelativo(ano2,uf),
					this.unidadeFederativaDao.buscaUnidadeFederativaAbsoluto(ano2, uf));

			
			
			if (validacao == true && comparacao == true) {
	
				this.request.setAttribute("listaUFAbsoluto1",
						this.unidadeFederativaDao
								.buscaUnidadeFederativaAbsoluto(ano1,uf));
				this.request.setAttribute("listaUFRelativo1",
						this.unidadeFederativaDao
								.buscaUnidadeFederativaRelativo(ano1,uf));
				this.request.setAttribute("listaUFAbsoluto2",
						this.unidadeFederativaDao
								.buscaUnidadeFederativaAbsoluto(ano2,uf));
				this.request.setAttribute("listaUFRelativo",
						this.unidadeFederativaDao
								.buscaUnidadeFederativaRelativo(ano2,uf));
				this.rd = this.request.getRequestDispatcher("brasil.jsp");
				this.rd.forward(request, response);
			} else {
				carregarPaginaErro();
			}
		}
	}

	public void getAnos(UnidadeFederativaDao unidadeFederativaDao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {

		this.rd = rd;
		this.unidadeFederativaDao = unidadeFederativaDao;
		this.request = request;
		this.response = response;

		if (this.unidadeFederativaDao.getDatasUnidadeFederativa() != null) {
			this.request.setAttribute("listaDatas",
					this.unidadeFederativaDao.getDatasUnidadeFederativa());
			this.rd = this.request
					.getRequestDispatcher("unidadeFederativa.jsp");
		} else {
			String msg = "Mensagem de errro";
			this.request.setAttribute("msg", msg);
			this.rd = this.request.getRequestDispatcher("erro.jsp");
		}
	}
		
	public void getUnidadesFederativas(UnidadeFederativaDao unidadeFederativaDao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {

		this.rd = rd;
		this.unidadeFederativaDao = unidadeFederativaDao;
		this.request = request;
		this.response = response;

		if (this.unidadeFederativaDao.getUnidadeFederativa() != null) {
			this.request.setAttribute("listaDatas",
					this.unidadeFederativaDao.getDatasUnidadeFederativa());
			this.rd = this.request
					.getRequestDispatcher("unidadeFederativa.jsp");
		} else {
			String msg = "Mensagem de errro";
			this.request.setAttribute("msg", msg);
			this.rd = this.request.getRequestDispatcher("erro.jsp");
		}
	}

	
	
	
	
	
	public void ComparacaoPorUF(int ano1,String uf1,String uf2,
			UnidadeFederativaDao unidadeFederativaDao, RequestDispatcher rd,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		{
			this.rd = rd;
			this.unidadeFederativaDao = unidadeFederativaDao;
			this.request = request;
			this.response = response;
			this.exceptions = new ExceptionsServlets();

			
			boolean validacao = this.exceptions.validarListasUF(
					this.unidadeFederativaDao.buscaUnidadeFederativaRelativo(ano1,uf1),
					this.unidadeFederativaDao.buscaUnidadeFederativaAbsoluto(ano1, uf1));
			
			boolean comparacao = this.exceptions.validarListasUF(
					this.unidadeFederativaDao.buscaUnidadeFederativaRelativo(ano1,uf2),
					this.unidadeFederativaDao.buscaUnidadeFederativaAbsoluto(ano1, uf2));
			
			if (validacao == true && comparacao == true) {
	
				this.request.setAttribute("listaUFAbsoluto1",
						this.unidadeFederativaDao
								.buscaUnidadeFederativaAbsoluto(ano1,uf1));
				this.request.setAttribute("listaUFRelativo1",
						this.unidadeFederativaDao
								.buscaUnidadeFederativaRelativo(ano1,uf1));
				this.request.setAttribute("listaUFAbsoluto2",
						this.unidadeFederativaDao
								.buscaUnidadeFederativaAbsoluto(ano1,uf2));
				this.request.setAttribute("listaUFRelativo",
						this.unidadeFederativaDao
								.buscaUnidadeFederativaRelativo(ano1,uf2));
				this.rd = this.request.getRequestDispatcher("brasil.jsp");
				this.rd.forward(request, response);
			} else {
				carregarPaginaErro();
			}
		}
	}

	
	
	
	public void getAnosComparacaoUnidadeFederativa(int ano,
			UnidadeFederativaDao unidadeFaderativa, RequestDispatcher rd,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		this.rd = rd;
		this.unidadeFederativaDao = unidadeFaderativa;
		this.request = request;
		this.response = response;
		this.exceptions = new ExceptionsServlets();
		if (exceptions.validaAnosListBox(
				this.unidadeFederativaDao.getDatasComparaçãoUnidadeFederativa(ano)) == true) {

			this.request.setAttribute("listaDatasComparacao",
					this.unidadeFederativaDao
							.getDatasComparaçãoUnidadeFederativa(ano));
			this.rd = this.request
					.getRequestDispatcher("unidadesFederativa.jsp");

		} else {
			carregarPaginaErro();
		}
	}

	public void carregarPaginaErro() throws ServletException, IOException {

		String msg = " Nós desculpe ocorreu um erro,prometemos que vamos corrigir <br> "
				+ "esse problema , tente novamente daqui alguns segundos ";
		request.setAttribute("msg", msg);
		rd = request.getRequestDispatcher("/erro.jsp");
		rd.forward(request, response);

	}

}
