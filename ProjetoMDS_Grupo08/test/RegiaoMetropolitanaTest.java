package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.*;

public class RegiaoMetropolitanaTest {
	
	RegiaoMetropolitana rm = new RegiaoMetropolitana();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
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
	
}
