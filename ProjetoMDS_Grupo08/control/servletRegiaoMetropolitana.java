package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.RegiaoMetropolitanaDao;

@WebServlet("/servletRegiaoMetropolitana")
public class servletRegiaoMetropolitana extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RegiaoMetropolitanaDao regiaoMetropolitanaDao;
	RequestDispatcher rd;
	HttpServletRequest request;
	HttpServletResponse response;

	public servletRegiaoMetropolitana() {
		super();
	}

	// O metodo doGet recebe as requisições vindas do submit de formularios
	// pelo
	// metodo GET vindo da view
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	// O metodo doPost recebe as requisições vindas do submit de formularios
	// pelo metodo POST vindo da view
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Instância para uso em toda classe
		this.regiaoMetropolitanaDao = new RegiaoMetropolitanaDao();

		// Metodo switch busca o parametro de comando passado da view
		switch (request.getParameter("cmd")) {
		case "busca":

			int ano = Integer.parseInt(request.getParameter("ano"));
			String regiao = request.getParameter("regiao");
			// Caso Busca Simples recebe os parametros para fazer
			// uma simples e retorna duas listas uma para
			// relativo e absoluto
			buscaRegiaoMetropolitana(regiao, ano, this.regiaoMetropolitanaDao,
					rd, request, response);

			break;
		case "comparacaoAno":
			// Quando o comando requisita a comparação
			// Captura de parametros passados para a comparação
			int ano1 = Integer.parseInt(request.getParameter("ano1"));
			int ano2 = Integer.parseInt(request.getParameter("ano2"));
			String regiaoMetropole = request.getParameter("regiao");
			ComparacaoRegioaMetropolitanaPorAno(regiaoMetropole, ano1, ano2,
					this.regiaoMetropolitanaDao, rd, request, response);
			break;

		case "comparacaoRegiao":
			// Quando o comando requisita a comparação
			// Captura de parametros passados para a comparação
			int anoComparacao = Integer.parseInt(request.getParameter("ano"));
			String regiao1 = request.getParameter("regiao1");
			String regiao2 = request.getParameter("regiao2");
			ComparacaoRegioaMetropolitanaPorRegiao(regiao1, anoComparacao, regiao2,
					this.regiaoMetropolitanaDao, rd, request, response);
	
			break;

		default:
			String erro = "Ocorreu um erro";
			request.setAttribute("erro", erro);
			this.rd = this.request.getRequestDispatcher("erro.jsp");

			break;
		}
	}

	// Metodos usados para as buscas

	public void buscaRegiaoMetropolitana(String regiao, int ano,RegiaoMetropolitanaDao regiaoMetropolitanaDao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.rd = rd;
		this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
		this.request = request;
		this.response = response;

		try {
			// Busca simples de Brasil
			if (this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano) != null
					&& this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao, ano) != null) {

				request.setAttribute("listaAbsolutoBusca",
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano));
				request.setAttribute("listaRelativoBusca",
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao, ano));
				
				// Enviar a lista para pagina de exibição do gráfico
				this.rd = this.request.getRequestDispatcher("RegiaoMetropolitana.jsp");
				this.rd.forward(this.request, this.response);
			} else {
				// Redirecionar para pagina de erro
				this.rd = this.request.getRequestDispatcher("erro.html");
				this.rd.forward(this.request, this.response);
			}
		} catch (Exception e) {
			// Redireciona para pagina de erro
			String mes = "Ocorreu um erro =   :" + e.getStackTrace()
					+ " ;  CAUSA  :" + e.getCause() + "; Na CLASSE   ;"
					+ e.getClass() + ";   MENSAGEM  :" + e.getMessage();

			request.setAttribute("erro", mes);
			this.rd = request.getRequestDispatcher("erro.jsp");
			this.rd.forward(request, response);

		}

	}

	public void ComparacaoRegioaMetropolitanaPorAno(String regiao, int ano1, int ano2,
			RegiaoMetropolitanaDao regiaoMetropolitanaDao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		{
			this.rd = rd;
			this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
			this.request = request;
			this.response = response;

			try {
				if ((this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano1) != null && this.regiaoMetropolitanaDao
						.buscaRegiaoMetropolitanaRelativo(regiao, ano1) != null && this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano2) != null
						&& this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao, ano2) != null)){
						

					this.request.setAttribute("listaAbsolutoComparacaoAno", this.regiaoMetropolitanaDao
											.buscaRegiaoMetropolitanaAbsoluto(regiao, ano1));
					this.request.setAttribute("listaRelativoComparacaoAno",
									this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao, ano1));
					
					
					this.request.setAttribute("listaAbsolutoComparacaoAno2", 
							this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano2));
					this.request.setAttribute("listaRelativoComparacaoAno2",
									this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao, ano2));

					this.rd = this.request.getRequestDispatcher("regiaoMetropolitana.jsp");
					this.rd.forward(request, response);
					
				} else {
					// Redirecionar para pagina de erro
					this.rd = this.request.getRequestDispatcher("erro.html");
					this.rd.forward(this.request, this.response);
				}

			}

			catch (Exception e) {
				String mes = "Ocorreu um erro =   :" + e.getStackTrace()
						+ " ;  CAUSA  :" + e.getCause() + "; Na CLASSE   ;"
						+ e.getClass() + ";   MENSAGEM  :" + e.getMessage();

				// Redireciona para pagina de erro
				this.request.setAttribute("erro", mes);
				this.rd = this.request.getRequestDispatcher("erro.jsp");
				this.rd.forward(this.request, this.response);
			}
		}
	}

	// compara��o por regiao metropolitana
	public void ComparacaoRegioaMetropolitanaPorRegiao(String regiao1,int ano1, String regiao2,
			RegiaoMetropolitanaDao regiaoMetropolitanaDao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		{
			this.rd = rd;
			this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
			this.request = request;
			this.response = response;

			try {
				if(this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao1, ano1) != null && 
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto( regiao1, ano1 ) != null &&
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao2, ano1) != null && 
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao2, ano1) != null){

					this.request.setAttribute("listaAbsolutoComparacaoRegiao1",
							this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao1, ano1));
					this.request.setAttribute("listaRelativoComparacaoRegiao1", 
							this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao1, ano1));
					
					this.request.setAttribute("listaAbsolutoComparacaoRegiao2",
									this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao2, ano1));
					this.request.setAttribute("listaRelativoComparacaoRegiao2",
									this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao2, ano1));

					this.rd = this.request.getRequestDispatcher("regiaoMetropolitana.jsp");
					this.rd.forward(request, response);
					
				} else {
					// Redirecionar para pagina de erro
					this.rd = this.request.getRequestDispatcher("erro.html");
					this.rd.forward(this.request, this.response);
				}

			}

			catch (Exception e) {
				String mes = "Ocorreu um erro =   :" + e.getStackTrace()
						+ " ;  CAUSA  :" + e.getCause() + "; Na CLASSE   ;"
						+ e.getClass() + ";   MENSAGEM  :" + e.getMessage();

				// Redireciona para pagina de erro
				this.request.setAttribute("erro", mes);
				this.rd = this.request.getRequestDispatcher("erro.jsp");
				this.rd.forward(this.request, this.response);
			}
		}
	}

	public void getAnosRegiaoMetropolitana(int ano,
			RegiaoMetropolitanaDao regiaoMetropolitanaDao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {

		this.rd = rd;
		this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
		this.request = request;
		this.response = response;

		if (this.regiaoMetropolitanaDao.getDatasRegiaoMetropolitana() != null) {

			this.request.setAttribute("listaDatas",
					this.regiaoMetropolitanaDao.getDatasRegiaoMetropolitana());
			// Pagina de interface com o tratamento das listagens
			this.rd = this.request
					.getRequestDispatcher("regiaoMetropolitana.jsp");

		} else {
			// Redirecionamento pra pagina de erro
			String msg = "Mensagem de errro";
			this.request.setAttribute("msg", msg);
			// Pagina de interface com o tratamento das listagens
			this.rd = this.request.getRequestDispatcher("erro.jsp");

		}

	}

	public void getAnosComparacaoRegiaoMetropolinata(int ano,
			RegiaoMetropolitanaDao regiaoMetropolitanaDao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {

		this.rd = rd;
		this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
		this.request = request;
		this.response = response;

		if (this.regiaoMetropolitanaDao
				.getDatasComparacaoRegiaoMetropolitana(ano) != null) {

			this.request.setAttribute("listaDatasComparacao",
					this.regiaoMetropolitanaDao
							.getDatasComparacaoRegiaoMetropolitana(ano));
			// Pagina de interface com o tratamento das listagens para
			// comparação
			this.rd = this.request
					.getRequestDispatcher("regiaoMetropolitana.jsp");

		} else {
			// Redirecionamento pra pagina de erro
			String msg = "Mensagem de errro";
			this.request.setAttribute("msg", msg);
			// Pagina de interface com o tratamento das listagens
			this.rd = this.request.getRequestDispatcher("brasil.jsp");

		}

	}

}
