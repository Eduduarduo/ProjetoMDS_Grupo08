package br.com.dld.test;

import static org.junit.Assert.*;
import org.junit.*;
import br.com.dld.model.*;

public class DadoTest {
	
	public DadoTest(){
		
	}
	
	@BeforeClass
	public static void setUpClass() throws Exception{
		
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception{
		
	}
	
	@Before
	public void setUp(){
		
	}
	
	@After
	public void tearDown(){
		
	}

	@Test
	public void testId(){
		Dado dados = new Dado();
		assertEquals(0, dados.getId());
		dados.setId(1234);
		assertEquals(1234, dados.getId());
		dados.setId(0);
		assertEquals(0, dados.getId());
		dados.setId(555555555);
		assertEquals(555555555, dados.getId());
	}
	
	@Test
	public void testValor(){
		Dado dados = new Dado();
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
		Dado dados = new Dado();
		assertNull(dados.getOpcao());
		dados.setOpcao("Opcional");
		assertEquals("Opcional", dados.getOpcao());
		dados.setOpcao("");
		assertEquals("", dados.getOpcao());
	}
	
	@Test
	public void testTipo(){
		Dado dados = new  Dado();
		assertNull(dados.getTipo());
		dados.setTipo("Tipacional");
		assertEquals("Tipacional", dados.getTipo());
		dados.setTipo("");
		assertEquals("", dados.getTipo());
	}

	@Test
	public void testIdErrado(){
		Dado dados = new Dado();
		dados.setId(1234);
		assertNotEquals(1234.00, dados.getId());
		assertNotNull(dados.getId());
	}
	
	@Test
	public void testValorErrado(){
		Dado dados = new Dado();
		dados.setValor(4321);
		assertNotEquals(4321.00, dados.getValor());
		assertNotNull(dados.getValor());
	}
	
	@Test
	public void testOpcaoErrado(){
		Dado dados = new Dado();
		dados.setOpcao("Opcional");
		assertNotEquals("Lanoicpo", dados.getOpcao());
		assertNotNull(dados.getOpcao());
		dados.setOpcao(" ");
		assertNotEquals("", dados.getOpcao());
		assertNotNull(dados.getOpcao());
	}
	
	@Test
	public void testTipoErrado(){
		Dado dados = new  Dado();
		dados.setTipo("Tipacional");
		assertNotEquals("Lanoicapit", dados.getTipo());
		assertNotNull(dados.getTipo());
		dados.setTipo(" ");
		assertNotEquals("", dados.getTipo());
		assertNotNull(dados.getTipo());
	}
}
