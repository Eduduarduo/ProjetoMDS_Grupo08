package test;

import static org.junit.Assert.*;

import model.Brasil;

import org.junit.Before;
import org.junit.Test;

public class BrasilTest {
	
	Brasil brasil;
	Brasil brasil2;
	
	@Before
	public void setUp() throws Exception {
		brasil = new Brasil();
		brasil2 = new Brasil("Brasil", "Coletadp", "Relativo", 1981, 12345);
	}
	
	@Test
	public void testBrasil(){
		assertEquals("Brasil", brasil2.getRegiao());
		assertEquals("Coletado", brasil2.getOpcao());
		assertEquals("Relativo", brasil2.getTipo());
		assertEquals(2001, brasil2.getAno());
		assertEquals(12345, brasil2.getValor());
	}
	
	@Test
	public void testRegiao(){
		assertNull(brasil.getRegiao());
		brasil.setRegiao("Tipacional");
		assertEquals("Tipacional", brasil.getRegiao());
		brasil.setRegiao("");
		assertEquals("", brasil.getRegiao());
	}
	
	@Test
	public void testOpcao(){
		assertNull(brasil.getOpcao());
		brasil.setOpcao("Opcional");
		assertEquals("Opcional", brasil.getOpcao());
		brasil.setOpcao("");
		assertEquals("", brasil.getOpcao());
	}
	
	@Test
	public void testTipo(){
		assertNull(brasil.getTipo());
		brasil.setTipo("Tipacional");
		assertEquals("Tipacional", brasil.getTipo());
		brasil.setTipo("");
		assertEquals("", brasil.getTipo());
	}
	
	@Test
	public void testAno(){
		assertEquals(0, brasil.getAno());
		brasil.setAno(1234);
		assertEquals(1234, brasil.getAno());
		brasil.setAno(0);
		assertEquals(0, brasil.getAno());
		brasil.setAno(555555555);
		assertEquals(555555555, brasil.getAno());		
	}

	@Test
	public void testValor(){
		assertEquals(0, brasil.getValor());
		brasil.setValor(4321);
		assertEquals(4321, brasil.getValor());
		brasil.setValor(0);
		assertEquals(0, brasil.getValor());
		brasil.setValor(555555555);
		assertEquals(555555555,brasil.getValor());
	}
	
	@Test
	public void testRegiaoErrada(){
		brasil.setRegiao("Regional");
		assertNotEquals(brasil.getRegiao(),"Lanoicpo");
		assertNotNull(brasil.getRegiao());
	}
	
	@Test
	public void testOpcaoErrada(){
		brasil.setOpcao("Opcional");
		assertNotEquals(brasil.getOpcao(),"Lanoicpo");
		assertNotNull(brasil.getOpcao());
	}
	
	@Test
	public void testTipoErrado(){
		brasil.setTipo("Tipacional");
		assertNotEquals(brasil.getTipo(),"Lanoicapit");
		assertNotNull(brasil.getTipo());
	}
	
	@Test
	public void testAnoErrado(){
		brasil.setAno(1234);
		assertNotEquals(brasil.getAno(), 1234.00);
		assertNotNull(brasil.getAno());
	}
	
	@Test
	public void testValorErrado(){
		brasil.setValor(4321);
		assertNotEquals(brasil.getValor(), 4321.00);
		assertNotNull(brasil.getValor());
	}

}
