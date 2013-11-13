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


@WebServlet("/servletUnidadeFederativa")
public class servletUnidadeFederativa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	UnidadeFederativaDao unidadeFederativaDao;
	RequestDispatcher rd;
	HttpServletRequest request;
	HttpServletResponse response;


	
	
    public servletUnidadeFederativa() {
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
    		this.unidadeFederativaDao = new UnidadeFederativaDao();

    		// Metodo switch busca o parametro de comando passado da view
    		switch (request.getParameter("cmd")) {
    		case "busca":

    			int ano = Integer.parseInt(request.getParameter("ano1"));
    			// Caso Busca Simples recebe os parametros para fazer
    			// uma simples e retorna duas listas uma para
    			// relativo e absoluto
    			buscaUnidadeFederativaPorAno(ano, this.unidadeFederativaDao, rd, request, response);

    			break;
    		case "comparacao":
    			// Quando o comando requisita a comparação
    			// Captura de parametros passados para a comparação
    			int ano1 = Integer.parseInt(request.getParameter("ano1"));
    			int ano2 = Integer.parseInt(request.getParameter("ano2"));
    			ComparacaoUnidadeFederativaPorAno(ano1, ano2, this.unidadeFederativaDao, rd, request,
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

    	public void buscaUnidadeFederativaPorAno(int ano,UnidadeFederativaDao unidadeFederativaDao, RequestDispatcher rd,
    			HttpServletRequest request, HttpServletResponse response)
    			throws ServletException, IOException {

    		this.rd = rd;
    		this.unidadeFederativaDao = unidadeFederativaDao;
    		this.request = request;
    		this.response = response;

    		try {
    			// Busca simples de Brasil
    			if (this.unidadeFederativaDao.buscaUnidadeFederativaAbsolutoPorAno(ano) != null
    					&& this.unidadeFederativaDao.buscaUnidadeFederativaRelativoPorAno(ano) != null) {

    				request.setAttribute("listaAbsoluto",
    						this.unidadeFederativaDao.buscaUnidadeFederativaAbsolutoPorAno(ano));
    				request.setAttribute("listaRelativo",
    						this.unidadeFederativaDao.buscaUnidadeFederativaRelativoPorAno(ano));
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
    			this.rd = request.getRequestDispatcher("erro.jsp");
    			this.rd.forward(request, response);

    		}

    	}

    	public void ComparacaoUnidadeFederativaPorAno(int ano1, int ano2,UnidadeFederativaDao unidadeFederativaDao,
    			RequestDispatcher rd, HttpServletRequest request,
    			HttpServletResponse response) throws ServletException, IOException {
    		{
    			this.rd = rd;
    			this.unidadeFederativaDao = unidadeFederativaDao;
    			this.request = request;
    			this.response = response;

    			try {
    				if ((this.unidadeFederativaDao.buscaUnidadeFederativaAbsolutoPorAno(ano1) != null && 
    						this.unidadeFederativaDao.buscaUnidadeFederativaRelativoPorAno(ano1) != null) && 
    								(this.unidadeFederativaDao.buscaUnidadeFederativaAbsolutoPorAno(ano2) != null && 
    								this.unidadeFederativaDao.buscaUnidadeFederativaRelativoPorAno(ano2) != null)) {
    					this.request.setAttribute("listaAbsoluto",
    							this.unidadeFederativaDao.buscaUnidadeFederativaAbsolutoPorAno(ano1));
    					this.request.setAttribute("listaRelativo",
    							this.unidadeFederativaDao.buscaUnidadeFederativaRelativoPorAno(ano1));
    					this.request.setAttribute("listaAbsolutoComparacao",
    							this.unidadeFederativaDao.buscaUnidadeFederativaAbsolutoPorAno(ano2));
    					this.request.setAttribute("listaRelativoComparacao",
    							this.unidadeFederativaDao.buscaUnidadeFederativaRelativoPorAno(ano2));

    					this.rd = this.request.getRequestDispatcher("brasil.jsp");
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
    				this.rd = this.request.getRequestDispatcher("brasil.jsp");
    				this.rd.forward(this.request, this.response);
    			}
    		}
    	}

    	public void getAnos(int ano,UnidadeFederativaDao unidadeFederativaDao , RequestDispatcher rd,
    			HttpServletRequest request, HttpServletResponse response)
    			throws ServletException, IOException, SQLException {

    		this.rd = rd;
    		this.unidadeFederativaDao = unidadeFederativaDao;
    		this.request = request;
    		this.response = response;

    		if (this.unidadeFederativaDao.getDatasUnidadeFederativa() != null) {

    			this.request.setAttribute("listaDatas", this.unidadeFederativaDao.getDatasUnidadeFederativa());
    			// Pagina de interface com o tratamento das listagens
    			this.rd = this.request.getRequestDispatcher("unidadeFederativa.jsp");

    		} else {
    			// Redirecionamento pra pagina de erro
    			String msg = "Mensagem de errro";
    			this.request.setAttribute("msg", msg);
    			// Pagina de interface com o tratamento das listagens
    			this.rd = this.request.getRequestDispatcher("erro.jsp");

    		}

    	}

    	public void getAnosComparacaoUnidadeFederativa(int ano, UnidadeFederativaDao unidadeFaderativa,
    			RequestDispatcher rd, HttpServletRequest request,
    			HttpServletResponse response) throws ServletException, IOException,
    			SQLException {

    		this.rd = rd;
    		this.unidadeFederativaDao = unidadeFaderativa;
    		this.request = request;
    		this.response = response;

    		if (this.unidadeFederativaDao.getDatasComparaçãoUnidadeFederativa(ano)!= null) {

    			this.request.setAttribute("listaDatasComparacao",
    					this.unidadeFederativaDao.getDatasComparaçãoUnidadeFederativa(ano));
    			// Pagina de interface com o tratamento das listagens para
    			// comparação
    			this.rd = this.request.getRequestDispatcher("unidadesFederativa.jsp");

    		} else {
    			// Redirecionamento pra pagina de erro
    			String msg = "Mensagem de errro";
    			this.request.setAttribute("msg", msg);
    			// Pagina de interface com o tratamento das listagens
    			this.rd = this.request.getRequestDispatcher("eerro.jsp");

    		}

    	}
    }
