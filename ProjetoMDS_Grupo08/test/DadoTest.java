package test;

import static org.junit.Assert.*;

import org.junit.*;

import model.*;

public class DadoTest {
	Dado dados;
	Dado dados2;
	
	@Before
	public void setUp(){
		dados = new Dado();
		dados2 = new Dado("Brasil", "Coletado", "Relativo", 1981, 84122);
	}
	
	@Test 
	public void testDado(){
		assertEquals("Brasil", dados2.getRegiao());
		assertEquals("Coletado", dados2.getOpcao());
		assertEquals("Relativo", dados2.getOpcao());
		assertEquals(1981, dados2.getAno());
		assertEquals(84122, dados2.getValor());
	}
	
	@Test
	public void testRegiao(){
		assertNull(dados.getRegiao());
		dados.setRegiao("Tipacional");
		assertEquals("Tipacional", dados.getRegiao());
		dados.setRegiao("");
		assertEquals("", dados.getRegiao());
	}
	
	@Test
	public void testOpcao(){
		assertNull(dados.getOpcao());
		dados.setOpcao("Opcional");
		assertEquals("Opcional", dados.getOpcao());
		dados.setOpcao("");
		assertEquals("", dados.getOpcao());
	}
	
	@Test
	public void testTipo(){
		assertNull(dados.getTipo());
		dados.setTipo("Tipacional");
		assertEquals("Tipacional", dados.getTipo());
		dados.setTipo("");
		assertEquals("", dados.getTipo());
	}

	@Test
	public void testAno(){
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
		assertEquals(0, dados.getValor());
		dados.setValor(4321);
		assertEquals(4321, dados.getValor());
		dados.setValor(0);
		assertEquals(0, dados.getValor());
		dados.setValor(555555555);
		assertEquals(555555555,dados.getValor());
	}
	
	@Test
	public void testRegiaoErrada(){
		dados.setRegiao("Regional");
		assertNotEquals(dados.getRegiao(),"Lanoicpo");
		assertNotNull(dados.getRegiao());
	}
	
	@Test
	public void testOpcaoErrado(){
		dados.setOpcao("Opcional");
		assertNotEquals(dados.getOpcao(),"Lanoicpo");
		assertNotNull(dados.getOpcao());
	}
	
	@Test
	public void testTipoErrado(){
		dados.setTipo("Tipacional");
		assertNotEquals(dados.getTipo(),"Lanoicapit");
		assertNotNull(dados.getTipo());
	}
	
	@Test
	public void testAnoErrado(){
		dados.setAno(1234);
		assertNotEquals(dados.getAno(), 1234.00);
		assertNotNull(dados.getAno());
	}
	
	@Test
	public void testValorErrado(){
		dados.setValor(4321);
		assertNotEquals(dados.getValor(), 4321.00);
		assertNotNull(dados.getValor());
	}
}

