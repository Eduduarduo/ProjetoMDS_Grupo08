package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BrasilDao;
import exception.ExceptionsServlets;

//Padrão Servlet 3.0 onde o urlpartterns e o nome onde e chamado pela view
@WebServlet(name = "/servletBrasil", urlPatterns = "/buscaBrasil")
public class ServletBrasil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BrasilDao brasilDao;
	RequestDispatcher rd;
	HttpServletRequest request;
	HttpServletResponse response;
	ExceptionsServlets exception;

	public ServletBrasil() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		brasilDao = new BrasilDao();

		try {
			int ano = Integer.parseInt(request.getParameter("ano1"));
			buscaBrasilPorAno(ano, brasilDao, rd, request, response);
		} catch (SQLException e) {
		}

	}

	public void buscaBrasilPorAno(int ano, BrasilDao brasildao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {

		this.rd = rd;
		this.brasilDao = brasildao;
		this.request = request;
		this.response = response;
		this.exception = new ExceptionsServlets();

		boolean verificacao = this.exception.validarListasBrasil(
				this.brasilDao.buscaBrasilRelativo(ano),
				this.brasilDao.buscaBrasilAbsoluto(ano));
		if (verificacao == true) {
			request.setAttribute("listaBrasilAbsolutoAno1",
					this.brasilDao.buscaBrasilAbsoluto(ano));
			request.setAttribute("listaBrasilRelativoAno1",
					this.brasilDao.buscaBrasilRelativo(ano));
			this.rd = this.request.getRequestDispatcher("brasil.jsp");
			this.rd.forward(this.request, this.response);
		} else {
			carregarPaginaErro();
		}
	}

	public void comparacaoPorAno(int ano1, int ano2, BrasilDao brasildao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws SQLException,
			ServletException, IOException {
		{
			this.rd = rd;
			this.brasilDao = brasildao;
			this.request = request;
			this.response = response;
			this.exception = new ExceptionsServlets();
			boolean verificacao = this.exception.validarListasBrasil(
					this.brasilDao.buscaBrasilRelativo(ano1),
					this.brasilDao.buscaBrasilAbsoluto(ano1));
			boolean ObjetoComparacao = this.exception.validarListasBrasil(
					this.brasilDao.buscaBrasilRelativo(ano2),
					this.brasilDao.buscaBrasilAbsoluto(ano2));
			if (verificacao == true && ObjetoComparacao == true) {
				request.setAttribute("listaBrasilAbsolutoAno1",
						this.brasilDao.buscaBrasilAbsoluto(ano1));
				request.setAttribute("listaBrasilRelativoAno1",
						this.brasilDao.buscaBrasilRelativo(ano1));
				request.setAttribute("listaBrasilAbsolutoAno2",
						this.brasilDao.buscaBrasilAbsoluto(ano2));
				request.setAttribute("listaBrasilRelativoAno2",
						this.brasilDao.buscaBrasilRelativo(ano2));
				this.rd = this.request.getRequestDispatcher("brasil.jsp");
				this.rd.forward(this.request, this.response);
			} else {
				carregarPaginaErro();
			}
		}
	}

	public void getAnos(BrasilDao brasildao, RequestDispatcher rd,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		this.rd = rd;
		this.brasilDao = brasildao;
		this.request = request;
		this.response = response;
		this.exception = new ExceptionsServlets();
		
		if (this.exception.validaAnosListBox(this.brasilDao.getDatas()) == true) {
			this.request.setAttribute("listaDatas", this.brasilDao.getDatas());
			this.rd = this.request.getRequestDispatcher("brasil.jsp");
		} else {
			carregarPaginaErro();
		}
	}

	public void getAnosComparacao(int ano, BrasilDao brasildao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {

		this.rd = rd;
		this.brasilDao = brasildao;
		this.request = request;
		this.response = response;
		this.exception = new ExceptionsServlets();
		
		if (this.exception.validaAnosListBox(this.brasilDao.getDatasComparacao(ano)) == true) {
			this.request.setAttribute("listaDatasComparacao",
					this.brasilDao.getDatasComparacao(ano));
			this.rd = this.request.getRequestDispatcher("brasil.jsp");
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
