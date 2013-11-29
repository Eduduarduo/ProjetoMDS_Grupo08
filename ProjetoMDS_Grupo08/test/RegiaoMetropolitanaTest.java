package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.*;

public class RegiaoMetropolitanaTest {
	
	RegiaoMetropolitana rm;
	RegiaoMetropolitana rm2;

	@Before
	public void setUp() throws Exception {
		rm = new RegiaoMetropolitana();
		rm2 = new RegiaoMetropolitana("Sao Paulo", "Coletado", "Relativo", 2001, 12345);
	}

	@Test
	public void testRegiaoMetropolitana(){
		assertEquals("Sao Paulo", rm2.getRegiao());
		assertEquals("Coletado", rm2.getOpcao());
		assertEquals("Relativo", rm2.getTipo());
		assertEquals(2001, rm2.getAno());
		assertEquals(12345, rm2.getValor());
	}
	@Test
	public void testRegiao(){
		assertNull(rm.getRegiao());
		rm.setRegiao("Tipacional");
		assertEquals("Tipacional", rm.getRegiao());
		rm.setRegiao("");
		assertEquals("", rm.getRegiao());
	}
	
	@Test
	public void testOpcao(){
		assertNull(rm.getOpcao());
		rm.setOpcao("Opcional");
		assertEquals("Opcional", rm.getOpcao());
		rm.setOpcao("");
		assertEquals("", rm.getOpcao());
	}
	
	@Test
	public void testTipo(){
		assertNull(rm.getTipo());
		rm.setTipo("Tipacional");
		assertEquals("Tipacional", rm.getTipo());
		rm.setTipo("");
		assertEquals("", rm.getTipo());
	}

	@Test
	public void testAno(){
		assertEquals(0, rm.getAno());
		rm.setAno(1234);
		assertEquals(1234, rm.getAno());
		rm.setAno(0);
		assertEquals(0, rm.getAno());
		rm.setAno(555555555);
		assertEquals(555555555, rm.getAno());
	}
	
	@Test
	public void testValor(){
		assertEquals(0, rm.getValor());
		rm.setValor(4321);
		assertEquals(4321, rm.getValor());
		rm.setValor(0);
		assertEquals(0, rm.getValor());
		rm.setValor(555555555);
		assertEquals(555555555,rm.getValor());
	}
	
	@Test
	public void testRegiaoErrada(){
		rm.setRegiao("Regional");
		assertNotEquals(rm.getRegiao(),"Lanoicpo");
		assertNotNull(rm.getRegiao());
	}
	
	@Test
	public void testOpcaoErrada(){
		rm.setOpcao("Opcional");
		assertNotEquals(rm.getOpcao(),"Lanoicpo");
		assertNotNull(rm.getOpcao());
	}
	
	@Test
	public void testTipoErrado(){
		rm.setTipo("Tipacional");
		assertNotEquals(rm.getTipo(),"Lanoicapit");
		assertNotNull(rm.getTipo());
	}

	@Test
	public void testAnoErrado(){
		rm.setAno(1234);
		assertNotEquals(rm.getAno(), 1234.00);
		assertNotNull(rm.getAno());
	}
	
	@Test
	public void testValorErrado(){
		rm.setValor(4321);
		assertNotEquals(rm.getValor(), 4321.00);
		assertNotNull(rm.getValor());
	}
}
