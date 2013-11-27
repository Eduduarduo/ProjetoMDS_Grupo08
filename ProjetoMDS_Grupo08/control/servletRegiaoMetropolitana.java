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
import exception.ExceptionRegiaoMetropolitana;


@WebServlet(name ="/servletRegiaoMetropolitana", urlPatterns = "/buscaRegiao")
public class ServletRegiaoMetropolitana extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RegiaoMetropolitanaDao regiaoMetropolitanaDao;
	private RequestDispatcher rd;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ExceptionRegiaoMetropolitana exceptions = new ExceptionRegiaoMetropolitana();
	
		

	public ServletRegiaoMetropolitana() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {}

	// O metodo doPost recebe as requisicoes vindas do submit de formularios pelo metodo POST vindo da view
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		this.regiaoMetropolitanaDao = new RegiaoMetropolitanaDao();
		int ano1 = Integer.parseInt(request.getParameter("ano1"));
		String regiao1 = request.getParameter("regiao1");
		
		
		switch (request.getParameter("cmd")) {
		case "busca":
			buscaRegiaoMetropolitana(regiao1, ano1, this.regiaoMetropolitanaDao, request);
			this.rd = request.getRequestDispatcher("comparacao.jsp");
			this.rd.forward(request, response);
			break;
		case "comparacaoAno":
			int ano2 = Integer.parseInt(request.getParameter("ano2"));
			ComparacaoRegiaoMetropolitanaPorAno(regiao1, ano1, ano2, this.regiaoMetropolitanaDao, request);
			this.rd = this.request.getRequestDispatcher("comparacao.jsp");
			this.rd.forward(request, response);
			break;
		case "comparacaoRegiao":
			String regiao2 = request.getParameter("regiao2");
			ComparacaoRegiaoMetropolitanaPorRegiao(regiao1, ano1, regiao2,this.regiaoMetropolitanaDao, request);
			this.rd = this.request.getRequestDispatcher("comparacao.jsp");
			this.rd.forward(request, response);
			break;

		default:
			carregarPaginaErro();

			break;
		}
	}

	public void buscaRegiaoMetropolitana(String regiao, int ano,RegiaoMetropolitanaDao regiaoMetropolitanaDao, HttpServletRequest request) throws ServletException, IOException {
		
		this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
		this.request = request;
		this.exceptions = new ExceptionRegiaoMetropolitana();
	
		try {
			boolean validacaoLista = this.exceptions.validaListasGraficos(this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano),
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao, ano));
			
			if(this.exceptions.verificaCampoDeParametro(regiao, ano) == true && validacaoLista == true){
				this.request.setAttribute("listaAbsolutoBusca",
									this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano));
					this.request.setAttribute("listaRelativoBusca",
									this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaRelativo(regiao, ano));
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	public void ComparacaoRegiaoMetropolitanaPorAno(String regiao, int ano1, int ano2,
			RegiaoMetropolitanaDao regiaoMetropolitanaDao, HttpServletRequest request) throws ServletException, IOException{

			this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
			this.request = request;
			try {
				boolean validacaoList = this.exceptions.validaListasGraficos(
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano1),
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano2));
	
				if(this.exceptions.verificaCampoDeParametro(regiao, ano1, ano2) == true && validacaoList == true){
					
					this.request.setAttribute("listaAbsolutoComparacao", this.regiaoMetropolitanaDao
												.buscaRegiaoMetropolitanaAbsoluto(regiao, ano1));
					this.request.setAttribute("listaAbsolutoComparacao2", 
								this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao, ano2));
					
				}else{
					carregarPaginaErro();
				}
					
			}catch (SQLException e) {
					e.printStackTrace();
			}
	}

	public void ComparacaoRegiaoMetropolitanaPorRegiao(String regiao1,int ano1, String regiao2,
			RegiaoMetropolitanaDao regiaoMetropolitanaDao, HttpServletRequest request) throws ServletException, IOException{
		
			this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
			this.request = request;
			try {
				boolean validacaoList = this.exceptions.validaListasGraficos(
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao1, ano1),
						this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao2, ano1));
				
				if(this.exceptions.verificaCampoDeParametro(regiao1, regiao2, ano1) == true && validacaoList == true){
				
					this.request.setAttribute("listaAbsolutoComparacao",
							this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao1, ano1));
					
					this.request.setAttribute("listaAbsolutoComparacao2",
							this.regiaoMetropolitanaDao.buscaRegiaoMetropolitanaAbsoluto(regiao2, ano1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				carregarPaginaErro();
			}		
	}
	
	public void getAnosRegiaoMetropolitana(RegiaoMetropolitanaDao regiaoMetropolitanaDao,RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.rd = rd;
		this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
		this.request = request;
		this.response = response;
		
		try {
			
			if(this.exceptions.validaAnosListBox(this.regiaoMetropolitanaDao.getAnosRegiaoMetropolitana()) == true ){
				this.request.setAttribute("listaDatas", this.regiaoMetropolitanaDao.getAnosRegiaoMetropolitana());
				this.rd = this.request.getRequestDispatcher("regiaoMetropolitana.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			carregarPaginaErro();
		}		
	}

	public void getAnosComparacaoRegiaoMetropolinata(int ano, RegiaoMetropolitanaDao regiaoMetropolitanaDao, RequestDispatcher rd, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{

		this.rd = rd;
		this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
		this.request = request;
		this.response = response;
		
		try {
			boolean validarListBox = this.exceptions.validaAnosListBox(this.regiaoMetropolitanaDao.getAnosComparacaoRegiaoMetropolitana(ano));
	
			if (this.exceptions.verificaCampoDeParametro(ano) == true && validarListBox == true) {
	
				
					this.request.setAttribute("listaDatasComparacao", this.regiaoMetropolitanaDao
									.getAnosComparacaoRegiaoMetropolitana(ano));
				
		
				this.rd = this.request
						.getRequestDispatcher("regiaoMetropolitana.jsp");
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			carregarPaginaErro();
		}
	}

	public void getRegioesRegiaoMetropolitana(RegiaoMetropolitanaDao regiaoMetropolitanaDao,RequestDispatcher rd, 
			HttpServletRequest	request, HttpServletResponse response) throws ServletException, IOException{

		this.rd = rd;
		this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
		this.request = request;
		this.response = response;
		
		try {
			if(this.exceptions.validaListBox(this.regiaoMetropolitanaDao.getRegioesRegiaoMetropolitana()) == true){
			
				this.request.setAttribute("listaDatas", this.regiaoMetropolitanaDao.getRegioesRegiaoMetropolitana());

				this.rd = this.request.getRequestDispatcher("unidadeFederativa.jsp");
			}else {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			carregarPaginaErro();
		}	
}
	
	public void getRegioesComparacaoRegiaoMetropolinata(String regiao, RegiaoMetropolitanaDao regiaoMetropolitanaDao,RequestDispatcher rd, 
			HttpServletRequest	request, HttpServletResponse response) throws ServletException, IOException{
		this.rd = rd;
		this.regiaoMetropolitanaDao = regiaoMetropolitanaDao;
		this.request = request;
		this.response = response;
		
		try {
			boolean validarListBox;
			validarListBox = this.exceptions.validaListBox(this.regiaoMetropolitanaDao.getRegioesComparacaoRegiaoMetropolitana(regiao));
			
			if (this.exceptions.verificaCampoDeParametro(regiao) == true && validarListBox == true) {
				
				this.request.setAttribute("listaDatas", this.regiaoMetropolitanaDao.getRegioesRegiaoMetropolitana());
				this.rd = this.request.getRequestDispatcher("unidadeFederativa.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			carregarPaginaErro();
		}
	}
	
	public void carregarPaginaErro() throws ServletException, IOException {
 
     	String msg = " Nós desculpe ocorreu um erro,prometemos que vamos corrigir <br> "
        	 + "esse problema , tente novamente daqui alguns segundos ";
     	this.request.setAttribute("msg", msg);
    	 this.rd = request.getRequestDispatcher("comparacao.jsp");
    	 this.rd.forward(request, response);
 
   }
}
