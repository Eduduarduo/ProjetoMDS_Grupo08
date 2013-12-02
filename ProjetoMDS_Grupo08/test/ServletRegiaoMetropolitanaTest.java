package test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import control.ServletBrasil;
import control.ServletRegiaoMetropolitana;



public class ServletRegiaoMetropolitanaTest{
	
	private HttpServletRequest request = mock(HttpServletRequest.class);
	private HttpServletResponse response = mock(HttpServletResponse.class);	
	private String regiao;
	private int ano;
	private ServletRegiaoMetropolitana servlet;
	
	@Before
	public void init() throws ServletException{
		servlet = new ServletRegiaoMetropolitana();
		regiao = "Belem - PA";
		ano = 2001;
	}
	//@Test
	public void testConstrutor(){
		assertNotNull(new ServletRegiaoMetropolitana());
	}
	
	//@Test //não entra por causa do response
	public void testBuscaRegiaoMetropolitana() throws ServletException, IOException, SQLException{
		servlet.buscaRegiaoMetropolitana(regiao, ano, request, response);
	} 
	
	
	//@Test //não entra por causa do response
	public void testComparacaoRegiaoMetropolitanaPorAno() throws ServletException, IOException, SQLException{
		int ano2 = 2002;
		servlet.ComparacaoRegiaoMetropolitanaPorAno(regiao, ano, ano2, request, response);
	}
	//@Test // tbm não funciona por causa do foward()
	public void testComparacaoRegiaoMetropolitanaPorAnoFalso() throws ServletException, IOException, SQLException{
		int ano2 = 3000;
		servlet.ComparacaoRegiaoMetropolitanaPorAno(regiao, ano, ano2, request, response);
	}
	
	//@Test// tbm não funciona por causa do response
	public void testComparacaoRegiaoMetropolitanaPorRegiao() throws ServletException, IOException, SQLException{
		String regiao2 = "Fortaleza";
		servlet.ComparacaoRegiaoMetropolitanaPorRegiao(regiao, ano, regiao2, request, response);
	}
	
	@Test
	public void testGetAnosRegiaoMetropolitana() throws ServletException, IOException, SQLException{
		servlet.getAnosRegiaoMetropolitana(request);
	}

	
	@Test
	public void testgetRegioesRegiaoMetropolitana() throws ServletException, IOException, SQLException{
		servlet.getRegioesRegiaoMetropolitana(request);
	}	
}
