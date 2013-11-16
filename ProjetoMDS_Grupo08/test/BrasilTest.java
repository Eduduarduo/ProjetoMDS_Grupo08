package test;

import static org.junit.Assert.*;

import model.Brasil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BrasilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAno(){
	    Brasil dados = new Brasil();
		assertEquals(0, dados.getAno());
		dados.setAno(1234);
		assertEquals(1234, dados.getAno());
		dados.setAno(0);
		assertEquals(0, dados.getAno());
		dados.setAno(555555555);
		assertEquals(555555555, dados.getAno());		
	}
	
	@Test
	public void testValor(){
		Brasil dados = new Brasil();
		assertEquals(0, dados.getValor());
		dados.setValor(4321);
		assertEquals(4321, dados.getValor());
		dados.setValor(0);
		assertEquals(0, dados.getValor());
		dados.setValor(555555555);
		assertEquals(555555555,dados.getValor());
	}
	
	@Test
	public void testOpcao(){
		
	}
	
	@Test
	public void testTipo(){
		
	}

	@Test
	public void testIdErrado(){
		
	}
	
	@Test
	public void testValorErrado(){
		
	}
	
	@Test
	public void testOpcaoErrado(){
		
	}
	
	@Test
	public void testTipoErrado(){
		
	}

}
