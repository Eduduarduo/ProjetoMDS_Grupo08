package test;

import static org.junit.Assert.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;

import sun.security.jca.GetInstance;
import static org.easymock.EasyMock.*; 
import control.servletRegiaoMetropolitana;
import dao.RegiaoMetropolitanaDao;

public class ServletRegiaoMetropolitanaTest {

	@Before
	public void setUp() throws Exception {
		
		servletRegiaoMetropolitana servletRegiaoMetropolitana = EasyMock.createMock(servletRegiaoMetropolitana.class);
		
	}

	@Test
	public void testServletRegiaoMetropolitana() {
		
		servletRegiaoMetropolitana servletRegiaoMetropolitanaLocal = new servletRegiaoMetropolitana();
		assertEquals(servletRegiaoMetropolitanaLocal.getClass(), servletRegiaoMetropolitana.class );
		
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {		
		fail("Not yet implemented");
	}

	@Test
	public void testBuscaRegiaoMetropolitana() {
		fail("Not yet implemented");
	}

	@Test
	public void testComparacaoRegioaMetropolitanaPorAno() {
		fail("Not yet implemented");
	}

	@Test
	public void testComparacaoRegioaMetropolitanaPorRegiao() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAnosRegiaoMetropolitana() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAnosComparacaoRegiaoMetropolitana() {
		fail("Not yet implemented");
	}

}
