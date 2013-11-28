package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;

import control.ServletUnidadeFederativa;
import dao.UnidadeFederativaDao;
import exception.ExceptionsUF;

public class TesteServletUnidadeFederativa {

	private HttpServletRequest request = mock(HttpServletRequest.class);
	private ExceptionsUF exception ; //= mock(ExceptionsBrasil.class); 
	private ServletUnidadeFederativa servletUF;
	private UnidadeFederativaDao unidadeFederativaDao;
	private int ano1;
	private int ano2;
	private int anofalse;
	String uf,uf2,ufFalse;
	
	@Before
	public void init() throws ServletException{
		servletUF = new ServletUnidadeFederativa();
		unidadeFederativaDao = new UnidadeFederativaDao();
		exception = new ExceptionsUF();
		ano1 = 2001;
		ano2 = 2004;
		anofalse = 2030;
		uf = "Para";
		uf2="Acre";
		ufFalse= "kkk";
		
	}
	
	@Test 
	public void testeContrutor(){
		assertNotNull(new ServletUnidadeFederativa());
	}
	@Test 
	public void testeContrutorNotSame(){
		assertNotSame(new ServletUnidadeFederativa(),exception);
	}
	
	@Test 
	public void testBuscaUnidadeFederartiva() throws ServletException, IOException, SQLException{
		servletUF.buscaUnidadeFederativa(ano1,uf, unidadeFederativaDao, exception, request);
	}
	@Test 
	public void testBuscaUnidadeFederartiva1() throws ServletException, IOException, SQLException{
		servletUF.buscaUnidadeFederativa(ano2,uf, unidadeFederativaDao, exception, request);
	}
	
	@Test 
	public void testBuscaUnidadeFederartivaAnoFalse() throws ServletException, IOException, SQLException{
		servletUF.buscaUnidadeFederativa(anofalse,uf, unidadeFederativaDao, exception, request);
	}
	@Test 
	public void testBuscaUnidadeFederartivaUFFalse() throws ServletException, IOException, SQLException{
		servletUF.buscaUnidadeFederativa(ano1,ufFalse, unidadeFederativaDao, exception, request);
	}
	@Test 
	public void testBuscaUnidadeFederartivaAmbosFalse() throws ServletException, IOException, SQLException{
		servletUF.buscaUnidadeFederativa(anofalse,ufFalse, unidadeFederativaDao, exception, request);
	}
	
	@Test
	public void testComparacaoUniadeFederativaPorAno() throws ServletException, IOException, SQLException{
		
		servletUF.ComparacaoUnidadeFederativaPorAno(ano1, ano2, uf, request);
	}
	@Test
	public void testComparacaoUniadeFederativaPorAno1False() throws ServletException, IOException, SQLException{
		
		servletUF.ComparacaoUnidadeFederativaPorAno(anofalse, ano2, uf, request);
	}
	@Test
	public void testComparacaoUniadeFederativaPorAmbosFalse() throws ServletException, IOException, SQLException{
		servletUF.ComparacaoUnidadeFederativaPorAno(anofalse, anofalse, uf, request);
	}
	
	@Test
	public void testComparacaoUniadeFederativaPorano2False() throws ServletException, IOException, SQLException{
		servletUF.ComparacaoUnidadeFederativaPorAno(ano1, anofalse, uf, request);
	}
	@Test
	public void testComparacaoUniadeFederativaPorUfFalse() throws ServletException, IOException, SQLException{
		servletUF.ComparacaoUnidadeFederativaPorAno(ano1, ano2, ufFalse, request);
	}
	@Test
	public void testComparacaoUniadeFederativaPorAllFalse() throws ServletException, IOException, SQLException{
		servletUF.ComparacaoUnidadeFederativaPorAno(anofalse, anofalse, ufFalse, request);
	}
	
	
	@Test
	public  void testGetAnos() throws ServletException, IOException, SQLException{
		servletUF.getAnos(unidadeFederativaDao, request);
	}
	
	@Test
	public  void testGetUnidadeFederativa() throws ServletException, IOException, SQLException{
		servletUF.getUnidadesFederativas(unidadeFederativaDao, request);
	}
	
	@Test
	public void testComparacaoPorUF() throws ServletException, IOException, SQLException{
		servletUF.ComparacaoPorUF(ano1, uf , uf2, unidadeFederativaDao, request);
	}
	@Test
	public void testComparacaoPorUFAno1False() throws ServletException, IOException, SQLException{
		servletUF.ComparacaoPorUF(anofalse, uf , uf2, unidadeFederativaDao, request);
	}
	@Test
	public void testComparacaoPorUFAnoUf1False() throws ServletException, IOException, SQLException{
		servletUF.ComparacaoPorUF(anofalse, ufFalse , uf2, unidadeFederativaDao, request);
	}
	@Test
	public void testComparacaoPorUAllFalse() throws ServletException, IOException, SQLException{
		servletUF.ComparacaoPorUF(anofalse, ufFalse , ufFalse, unidadeFederativaDao, request);
	}
	@Test
	public void testComparacaoPorUuf1False() throws ServletException, IOException, SQLException{
		servletUF.ComparacaoPorUF(ano1, ufFalse , uf2, unidadeFederativaDao, request);
	}
	@Test
	public void testComparacaoPorUuf2False() throws ServletException, IOException, SQLException{
		servletUF.ComparacaoPorUF(ano1, uf , ufFalse, unidadeFederativaDao, request);
	}
	
	@Test 
	public void testGetAnosComparacaoUnidadeFederativa() throws ServletException, IOException, SQLException{
		servletUF.getAnosComparacaoUnidadeFederativa(ano2,request);
		
	}
	
	

	
	}
	
	


