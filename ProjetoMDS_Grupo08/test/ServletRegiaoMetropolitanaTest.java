package test;

import static org.easymock.EasyMock.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import control.ServletRegiaoMetropolitana;
import dao.RegiaoMetropolitanaDao;


public class ServletRegiaoMetropolitanaTest{
	
	private HttpServletRequest request = createNiceMock(HttpServletRequest.class);
	private HttpServletResponse response = createNiceMock(HttpServletResponse.class);	
	private RequestDispatcher rd = createNiceMock(RequestDispatcher.class);
	private String regiao;
	private int ano;
	
	private ServletRegiaoMetropolitana servlet;
	private RegiaoMetropolitanaDao regiaoDao;
	
	@Before
	public void init() throws ServletException{
		servlet = new ServletRegiaoMetropolitana();
		regiaoDao = new RegiaoMetropolitanaDao();
		regiao = "Belem - PA";
		ano = 2001;
	}
	
	@Test
	public void testServletRegiaoMetropolitana(){  
		ServletRegiaoMetropolitana servletRegiaoMetropolitanaLocal = new ServletRegiaoMetropolitana();
		assertEquals(servletRegiaoMetropolitanaLocal.getClass(), ServletRegiaoMetropolitana.class); 
	}
	
	@Test 
	public void testBuscaRegiaoMetropolitana() throws ServletException, IOException, SQLException{
		replay(request, response, rd);
		servlet.buscaRegiaoMetropolitana(regiao, 2001, request, response);
		verify(request, response, rd);	
	} 

	@Test
	public void testBucaRegiaoMetropolitanaPorAno() throws ServletException, IOException, SQLException{
		int ano2 = 2002;
		replay(request, response, rd);
		servlet.ComparacaoRegiaoMetropolitanaPorAno(regiao, ano, ano2, request, response);
		verify(request, response, rd);	
	}
	
	@Test
	public void testBucaRegiaoMetropolitanaPorRegiao() throws ServletException, IOException, SQLException{
		String regiao2 = "Fortaleza - CE";
		replay(request, response, rd);
		servlet.ComparacaoRegiaoMetropolitanaPorRegiao(regiao, ano, regiao2, request, response);
		verify(request, response, rd);	
	}
	
	@Test
	public void testGetAnosRegiaoMetropolitana() throws ServletException, IOException, SQLException{

		replay(request, response, rd);
		servlet.getAnosRegiaoMetropolitana(request);
		verify(request, response, rd);	
	}

	
	@Test
	public void testgetRegioesRegiaoMetropolitana() throws ServletException, IOException, SQLException{

		replay(request, response, rd);
		servlet.getRegioesRegiaoMetropolitana(request);
		verify(request, response, rd);	
	}
	
	//verificar se as funções getAnosComparação e getRegiaoComparação vão ser usadas

	
}
