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

//Padrão Servlet 3.0 onde o urlpartterns e o nome onde e chamado pela view
@WebServlet(name = "/servletBrasil", urlPatterns = "/buscaBrasil")
public class servletBrasil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BrasilDao brasilDao;
	RequestDispatcher rd;
	HttpServletRequest request;
	HttpServletResponse response;

	public servletBrasil() {
		super();
	}

	// O metodo doGet recebe as requisições vindas do submit de formularios pelo
	// metodo GET vindo da view
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	// O metodo doPost recebe as requisições vindas do submit de formularios
	// pelo metodo POST vindo da view
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Instância para uso em toda classe
		this.brasilDao = new BrasilDao();

		// Metodo switch busca o parametro de comando passado da view
		switch (request.getParameter("cmd")) {
		case "busca":

			int ano = Integer.parseInt(request.getParameter("ano1"));
			// Caso Busca Simples recebe os parametros para fazer
			// uma simples e retorna duas listas uma para
			// relativo e absoluto
			buscaBrasil(ano, this.brasilDao, rd, request, response);

			break;
		case "comparacao":
			// Quando o comando requisita a comparação
			// Captura de parametros passados para a comparação
			int ano1 = Integer.parseInt(request.getParameter("ano1"));
			int ano2 = Integer.parseInt(request.getParameter("ano2"));
			buscaBrasilComparacao(ano1, ano2, this.brasilDao, rd, request,
					response);
			break;

		default:
			String erro = "Ocorreu um erro";
			request.setAttribute("erro", erro);
			this.rd = this.request.getRequestDispatcher("brasil.jsp");

			break;
		}
	}

	// Metodos usados para as buscas

	public void buscaBrasil(int ano, BrasilDao brasildao, RequestDispatcher rd,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.rd = rd;
		this.brasilDao = brasildao;
		this.request = request;
		this.response = response;

		try {
			// Busca simples de Brasil
			if (this.brasilDao.buscaBrasilAbsoluto(ano) != null
					&& this.brasilDao.buscaBrasilRelativo(ano) != null) {

				request.setAttribute("listaAbsoluto",
						this.brasilDao.buscaBrasilAbsoluto(ano));
				request.setAttribute("listaRelativo",
						this.brasilDao.buscaBrasilRelativo(ano));
				// Enviar a lista para pagina de exibição do gráfico
				this.rd = this.request.getRequestDispatcher("brasil.jsp");
				this.rd.forward(this.request, this.response);
			} else {
				// Redirecionar para pagina de erro
				this.rd = this.request.getRequestDispatcher("index.html");
				this.rd.forward(this.request, this.response);
			}
		} catch (Exception e) {
			// Redireciona para pagina de erro
			String mes = "Ocorreu um erro =   :" + e.getStackTrace()
					+ " ;  CAUSA  :" + e.getCause() + "; Na CLASSE   ;"
					+ e.getClass() + ";   MENSAGEM  :" + e.getMessage();

			request.setAttribute("erro", mes);
			this.rd = request.getRequestDispatcher("brasil.jsp");
			this.rd.forward(request, response);

		}

	}

	public void buscaBrasilComparacao(int ano1, int ano2, BrasilDao brasildao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		{
			this.rd = rd;
			this.brasilDao = brasildao;
			this.request = request;
			this.response = response;

			try {
				if ((this.brasilDao.buscaBrasilAbsoluto(ano1) != null && this.brasilDao
						.buscaBrasilRelativo(ano1) != null)
						&& (this.brasilDao.buscaBrasilAbsoluto(ano2) != null && this.brasilDao
								.buscaBrasilRelativo(ano2) != null)) {
					this.request.setAttribute("listaAbsoluto",
							this.brasilDao.buscaBrasilAbsoluto(ano1));
					this.request.setAttribute("listaRelativo",
							this.brasilDao.buscaBrasilRelativo(ano1));
					this.request.setAttribute("listaAbsolutoComparacao",
							this.brasilDao.buscaBrasilAbsoluto(ano2));
					this.request.setAttribute("listaRelativoComparacao",
							this.brasilDao.buscaBrasilRelativo(ano2));

					this.rd = this.request.getRequestDispatcher("brasil.jsp");
					this.rd.forward(request, response);
				} else {
					// Redirecionar para pagina de erro
					this.rd = this.request.getRequestDispatcher("index.html");
					this.rd.forward(this.request, this.response);
				}

			}

			catch (Exception e) {
				String mes = "Ocorreu um erro =   :" + e.getStackTrace()
						+ " ;  CAUSA  :" + e.getCause() + "; Na CLASSE   ;"
						+ e.getClass() + ";   MENSAGEM  :" + e.getMessage();

				// Redireciona para pagina de erro
				this.request.setAttribute("erro", mes);
				this.rd = this.request.getRequestDispatcher("brasil.jsp");
				this.rd.forward(this.request, this.response);
			}
		}
	}

	public void getAnos(int ano, BrasilDao brasildao, RequestDispatcher rd,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		this.rd = rd;
		this.brasilDao = brasildao;
		this.request = request;
		this.response = response;

		if (this.brasilDao.getDatas() != null) {

			this.request.setAttribute("listaDatas", this.brasilDao.getDatas());
			// Pagina de interface com o tratamento das listagens
			this.rd = this.request.getRequestDispatcher("brasil.jsp");

		} else {
			// Redirecionamento pra pagina de erro
			String msg = "Mensagem de errro";
			this.request.setAttribute("msg", msg);
			// Pagina de interface com o tratamento das listagens
			this.rd = this.request.getRequestDispatcher("brasil.jsp");

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

		if (this.brasilDao.getDatasComparação(ano) != null) {

			this.request.setAttribute("listaDatasComparacao",
					this.brasilDao.getDatasComparação(ano));
			// Pagina de interface com o tratamento das listagens para
			// comparação
			this.rd = this.request.getRequestDispatcher("brasil.jsp");

		} else {
			// Redirecionamento pra pagina de erro
			String msg = "Mensagem de errro";
			this.request.setAttribute("msg", msg);
			// Pagina de interface com o tratamento das listagens
			this.rd = this.request.getRequestDispatcher("brasil.jsp");

		}

	}
}
