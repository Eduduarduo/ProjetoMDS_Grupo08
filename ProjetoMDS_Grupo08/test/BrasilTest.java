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
		Brasil dados = new Brasil();
		assertNull(dados.getOpcao());
		dados.setOpcao("Opcional");
		assertEquals("Opcional", dados.getOpcao());
		dados.setOpcao("");
		assertEquals("", dados.getOpcao());
	}
	
	@Test
	public void testTipo(){
		Brasil dados = new Brasil();
		assertNull(dados.getTipo());
		dados.setTipo("Tipacional");
		assertEquals("Tipacional", dados.getTipo());
		dados.setTipo("");
		assertEquals("", dados.getTipo());
	}

	@Test
	public void testIdErrado(){
		Brasil dados = new Brasil();
		dados.setAno(1234);
		assertNotEquals(dados.getAno(), 1234.00);
		assertNotNull(dados.getAno());
	}
	
	@Test
	public void testValorErrado(){
		Brasil dados = new Brasil();
		dados.setValor(4321);
		assertNotEquals(dados.getValor(), 4321.00);
		assertNotNull(dados.getValor());
	}
	
	@Test
	public void testOpcaoErrado(){
		Brasil dados = new Brasil();
		dados.setOpcao("Opcional");
		assertNotEquals(dados.getOpcao(),"Lanoicpo");
		assertNotNull(dados.getOpcao());
	}
	
	@Test
	public void testTipoErrado(){
		Brasil dados = new Brasil();
		dados.setTipo("Tipacional");
		assertNotEquals(dados.getTipo(),"Lanoicapit");
		assertNotNull(dados.getTipo());
	}

}
