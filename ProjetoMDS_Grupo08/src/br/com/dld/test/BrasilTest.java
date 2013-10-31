package br.com.dld.test;

/*
 * @author Attany
 */

import static org.junit.Assert.*;
import org.junit.*;
import br.com.dld.model.*;

public class BrasilTest {
	
	public BrasilTest(){
		
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
		Brasil brasil = new Brasil();
		assertEquals(0, brasil.getId());
		brasil.setId(1234);
		assertEquals(1234, brasil.getId());
		brasil.setId(0);
		assertEquals(0, brasil.getId());
		brasil.setId(555555555);
		assertEquals(555555555, brasil.getId());
	}
	
	@Test
	public void testValor(){
		Brasil brasil = new Brasil();
		assertEquals(0, brasil.getValor());
		brasil.setValor(4321);
		assertEquals(4321, brasil.getValor());
		brasil.setValor(0);
		assertEquals(0, brasil.getValor());
		brasil.setValor(555555555);
		assertEquals(555555555,brasil.getValor());
	}
	
	@Test
	public void testOpcao(){
		Brasil brasil = new Brasil();
		assertNull(brasil.getOpcao());
		brasil.setOpcao("Opcional");
		assertEquals("Opcional", brasil.getOpcao());
		brasil.setOpcao("");
		assertEquals("", brasil.getOpcao());
	}
	
	@Test
	public void testTipo(){
		Brasil brasil = new  Brasil();
		assertNull(brasil.getTipo());
		brasil.setTipo("Tipacional");
		assertEquals("Tipacional", brasil.getTipo());
		brasil.setTipo("");
		assertEquals("", brasil.getTipo());
	}

	@Test
	public void testIdErrado(){
		Brasil brasil = new Brasil();
		brasil.setId(1234);
		assertNotEquals(brasil.getId(), 1234.00);
		assertNotNull(brasil.getId());
	}
	
	@Test
	public void testValorErrado(){
		Brasil brasil = new Brasil();
		brasil.setValor(4321);
		assertNotEquals(brasil.getValor(), 4321.00);
		assertNotNull(brasil.getValor());
	}
	
	@Test
	public void testOpcaoErrado(){
		Brasil brasil = new Brasil();
		brasil.setOpcao("Opcional");
		assertNotEquals(brasil.getOpcao(),"Lanoicpo");
		assertNotNull(brasil.getOpcao());
	}
	
	@Test
	public void testTipoErrado(){
		Brasil brasil = new  Brasil();
		brasil.setTipo("Tipacional");
		assertNotEquals(brasil.getTipo(),"Lanoicapit");
		assertNotNull(brasil.getTipo());
	}
}
