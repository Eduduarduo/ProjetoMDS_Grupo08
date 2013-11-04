package br.com.dld.test;

/*
 * @author Attany
 */

import static org.junit.Assert.*;
import org.junit.*;
import br.com.dld.model.*;

public class UnidadeFederativaTest {

public UnidadeFederativaTest(){
		
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

	//Testes de Unidade Federativa
	@Test
	public void testId(){
		UnidadeFederativa UF = new UnidadeFederativa();
		assertEquals(0, UF.getId());
		UF.setId(1234);
		assertEquals(1234, UF.getId());
		UF.setId(0);
		assertEquals(0, UF.getId());
		UF.setId(555555555);
		assertEquals(555555555, UF.getId());
	}
	
	@Test
	public void testValor(){
		UnidadeFederativa UF = new UnidadeFederativa();
		assertEquals(0, UF.getValor());
		UF.setValor(4321);
		assertEquals(4321, UF.getValor());
		UF.setValor(0);
		assertEquals(0, UF.getValor());
		UF.setValor(555555555);
		assertEquals(555555555,UF.getValor());
	}
	
	@Test
	public void testOpcao(){
		UnidadeFederativa UF = new UnidadeFederativa();
		assertNull(UF.getOpcao());
		UF.setOpcao("Opcional");
		assertEquals("Opcional", UF.getOpcao());
		UF.setOpcao("");
		assertEquals("", UF.getOpcao());
	}
	
	@Test
	public void testTipo(){
		UnidadeFederativa UF = new  UnidadeFederativa();
		assertNull(UF.getTipo());
		UF.setTipo("Tipacional");
		assertEquals("Tipacional", UF.getTipo());
		UF.setTipo("");
		assertEquals("", UF.getTipo());
	}

	@Test
	public void testIdErrado(){
		UnidadeFederativa UF = new UnidadeFederativa();
		UF.setId(1234);
		assertNotEquals(UF.getId(), 1234.00);
		assertNotNull(UF.getId());
	}
	
	@Test
	public void testValorErrado(){
		UnidadeFederativa UF = new UnidadeFederativa();
		UF.setValor(4321);
		assertNotEquals(UF.getValor(), 4321.00);
		assertNotNull(UF.getValor());
	}
	
	@Test
	public void testOpcaoErrado(){
		UnidadeFederativa UF = new UnidadeFederativa();
		UF.setOpcao("Opcional");
		assertNotEquals(UF.getOpcao(),"Lanoicpo");
		assertNotNull(UF.getOpcao());
	}
	
	@Test
	public void testTipoErrado(){
		UnidadeFederativa UF = new  UnidadeFederativa();
		UF.setTipo("Tipacional");
		assertNotEquals(UF.getTipo(),"Lanoicapit");
		assertNotNull(UF.getTipo());
	}
}

