package test;


import static org.junit.Assert.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import control.ServletBrasil;
import dao.BrasilDao;
import exception.ExceptionsBrasil;

public class ServletBrasilTest {

	private HttpServletRequest request = mock(HttpServletRequest.class);
	private ExceptionsBrasil exception ; //= mock(ExceptionsBrasil.class); 
	private ServletBrasil servletBrasil;
	private BrasilDao brasildao;
	private int ano1;
	private int ano2;
	private int anofalse;
	@Before
	public void init() throws ServletException{
		servletBrasil = new ServletBrasil();
		brasildao = new BrasilDao();
		exception = new ExceptionsBrasil();
		ano1 = 1981;
		ano2 = 2004;
		anofalse = 2030;
	}
	
	
	
	@Test 
	public void TesteConstrutor(){
		assertNotNull(new ServletBrasil());
	}
	@Test 
	public void TesteConstrutorVlida(){
		assertNotSame(new ServletBrasil(), exception);
		
	}
	@Test
	public void testGetAnosBrasil() throws ServletException, IOException, SQLException{
		servletBrasil.getAnos(brasildao, request);
		
	}
	@Test
	public void testGetAnosBrasilComparacao() throws ServletException, IOException, SQLException{
		servletBrasil.getAnosComparacao(ano1,brasildao, request);
	}
	@Test
	public void testComparacaoPorAno() throws ServletException, IOException, SQLException{
		servletBrasil.comparacaoPorAno(ano1, ano2, brasildao, request, exception);
	}
	@Test
	public void testComparacaoPorAno2False() throws ServletException, IOException, SQLException{
		
		servletBrasil.comparacaoPorAno(ano1,anofalse, brasildao, request, exception);
		
	}
	@Test
	public void testComparacaoPorAno1False() throws ServletException, IOException, SQLException{
		
		servletBrasil.comparacaoPorAno(anofalse,ano2, brasildao, request, exception);
		
	}
	@Test
	public void testComparacaoPorAmbosFalse() throws ServletException, IOException, SQLException{
		
		servletBrasil.comparacaoPorAno(anofalse,anofalse, brasildao, request, exception);
		
	}
	@Test
	public void testBuscaBrasilPorAno() throws ServletException, IOException, SQLException{
		servletBrasil.buscaBrasilPorAno(ano1, brasildao, request, exception);
	}
	@Test
	public void testBuscaBrasilPorAnoFalse() throws ServletException, IOException, SQLException{
		servletBrasil.buscaBrasilPorAno(anofalse, brasildao, request, exception);
	}
	
}
