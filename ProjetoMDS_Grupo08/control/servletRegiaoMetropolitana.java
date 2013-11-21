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
import exception.ExceptionsServlets;

@WebServlet("/servletRegiaoMetropolitana")
public class servletRegiaoMetropolitana extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RegiaoMetropolitanaDao regiaoMetropolitanaDao;
	RequestDispatcher rd;
	HttpServletRequest request;
	HttpServletResponse response;
	ExceptionsServlets exceptions;

	public servletRegiaoMetropolitana() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	// O metodo doPost recebe as requisicoes vindas do submit de formularios pelo metodo POST vindo da view
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		this.regiaoMetropolitanaDao = new RegiaoMetropolitanaDao();
		int ano1 = Integer.parseInt(request.getParameter("ano1"));
		int ano2 = Integer.parseInt(request.getParameter("ano2"));
		String regiao1 = request.getParameter("regiao1");
		String regiao2 = request.getParameter("regiao2");
		

		// Metodo switch busca o parametro de comando passado da view
		switch (request.getParameter("cmd")) {
		case "busca":
			
			buscaRegiaoMetropolitana(regiao1, ano1, this.regiaoMetropolitanaDao,rd, request, response);
			break;
		case "comparacaoAno":
			
			ComparacaoRegiaoMetropolitanaPorAno(regiao1, ano1, ano2, this.regiaoMetropolitanaDao, rd, request, response);
			break;

		case "comparacaoRegiao":
			
			ComparacaoRegiaoMetropolitanaPorRegiao(regiao1, ano1, regiao2,this.regiaoMetropolitanaDao, rd, request, response);
			break;

		default:
			carregarPaginaErro();

			break;
		}
	}


	public void buscaRegiaoMetropolitana(String regiao, int ano,RegiaoMetropolitanaDao regiaoMetropolitanaDao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.rd = rd;
		this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
		this.request = request;
		this.response = response;
		this.exceptions = new ExceptionsServlets();

		try{
			boolean validacao = this.exceptions.validarListasRegiaoMetropolitana(
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano), this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao, ano));
	
			if(validacao == true){	
				request.setAttribute("listaAbsolutoBusca",
								this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano));
				request.setAttribute("listaRelativoBusca",
								this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao, ano));
						
				// Enviar a lista para pagina de exibição do gráfico
				this.rd = this.request.getRequestDispatcher("RegiaoMetropolitana.jsp");
				this.rd.forward(this.request, this.response);
			}else{
				carregarPaginaErro();
			}
		}catch (SQLException e) {
			
			e.getStackTrace();
			
		}

	}

	
	public void ComparacaoRegiaoMetropolitanaPorAno(String regiao, int ano1, int ano2,
			RegiaoMetropolitanaDao regiaoMetropolitanaDao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		{
			this.rd = rd;
			this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
			this.request = request;
			this.response = response;

			try {
				boolean validacao = this.exceptions.validarListasRegiaoMetropolitana(
				this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano1), this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano2));

				if(validacao == true){
					this.request.setAttribute("listaAbsolutoComparacaoAno", this.regiaoMetropolitanaDao
											.buscaRegiaoMetropolitanaAbsoluto(regiao, ano1));

					this.request.setAttribute("listaAbsolutoComparacaoAno2", 
							this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano2));
					

					//testando
					this.rd = this.request.getRequestDispatcher("comparacao.jsp");
					this.rd.forward(request, response);
				}else{
					carregarPaginaErro();
				}

			}

			catch (SQLException e) {
				e.getStackTrace();

			}
		}
	}

	public void ComparacaoRegiaoMetropolitanaPorRegiao(String regiao1,int ano1, String regiao2,
			RegiaoMetropolitanaDao regiaoMetropolitanaDao,
			RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
			this.rd = rd;
			this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
			this.request = request;
			this.response = response;
			
			try{

				boolean validacao = this.exceptions.validarListasRegiaoMetropolitana(
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao1, ano1),
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao2, ano1));
				
				if(validacao == true){
					
					this.request.setAttribute("listaAbsolutoComparacaoRegiao1",
							this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao1, ano1));
					
					this.request.setAttribute("listaAbsolutoComparacaoRegiao2",
									this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao2, ano1));
				

					this.rd = this.request.getRequestDispatcher("regiaoMetropolitana.jsp");
					this.rd.forward(request, response);
				} else 
					carregarPaginaErro();
			}catch(SQLException sql){
				sql.getStackTrace();
			}
	}
	
	public void getAnosRegiaoMetropolitana(RegiaoMetropolitanaDao regiaoMetropolitanaDao,RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,SQLException {

		this.rd = rd;
		this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
		this.request = request;
		this.response = response;

		boolean validarListBox = exceptions.validaAnosListBox(this.regiaoMetropolitanaDao.getAnosRegiaoMetropolitana());
		
		if (validarListBox == true){

			this.request.setAttribute("listaDatas",this.regiaoMetropolitanaDao.getAnosRegiaoMetropolitana());
			
			// Pagina de interface com o tratamento das listagens
			this.rd = this.request.getRequestDispatcher("regiaoMetropolitana.jsp");

		} else {
			carregarPaginaErro();
		}

	}

	public void getAnosComparacaoRegiaoMetropolinata(int ano, RegiaoMetropolitanaDao regiaoMetropolitanaDao, RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,SQLException {

		this.rd = rd;
		this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
		this.request = request;
		this.response = response;
		
		boolean validarListBox = exceptions.validaAnosListBox(this.regiaoMetropolitanaDao.
				getAnosComparacaoRegiaoMetropolitana(ano));

		if (validarListBox == true) {

			this.request.setAttribute("listaDatasComparacao", this.regiaoMetropolitanaDao
							.getAnosComparacaoRegiaoMetropolitana(ano));
	
			this.rd = this.request
					.getRequestDispatcher("regiaoMetropolitana.jsp");

		} else {
			carregarPaginaErro();
		}

	}

	public void getRegioesRegiaoMetropolitana(RegiaoMetropolitanaDao regiaoMetropolitanaDao,RequestDispatcher rd, 
			HttpServletRequest	request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		this.rd = rd;
		this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
		this.request = request;
		this.response = response;
		
		
		boolean validarListBox = this.exceptions.validaListBox(this.regiaoMetropolitanaDao.getRegioesRegiaoMetropolitana());
		
		if (validarListBox == true) {
			
			this.request.setAttribute("listaDatas", this.regiaoMetropolitanaDao.getRegioesRegiaoMetropolitana());
			this.rd = this.request.getRequestDispatcher("unidadeFederativa.jsp");
		} else {
			carregarPaginaErro();
		}
}
	
	public void getRegioesComparacaoRegiaoMetropolinata(String regiao, RegiaoMetropolitanaDao regiaoMetropolitanaDao,RequestDispatcher rd, 
			HttpServletRequest	request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		this.rd = rd;
		this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
		this.request = request;
		this.response = response;
		
		
		boolean validarListBox = this.exceptions.validaListBox(this.regiaoMetropolitanaDao.getRegioesComparacaoRegiaoMetropolitana(regiao));
		
		if (validarListBox == true) {
			
			this.request.setAttribute("listaDatas", this.regiaoMetropolitanaDao.getRegioesRegiaoMetropolitana());
			this.rd = this.request.getRequestDispatcher("unidadeFederativa.jsp");
		} else {
			carregarPaginaErro();
		}
	}
	
	public void carregarPaginaErro() throws ServletException, IOException {
 
     	String msg = " N�s desculpe ocorreu um erro,prometemos que vamos corrigir <br> "
        	 + "esse problema , tente novamente daqui alguns segundos ";
     	this.request.setAttribute("msg", msg);
    	 this.rd = request.getRequestDispatcher("/erro.jsp");
    	 this.rd.forward(request, response);
 
   }	
	

}
