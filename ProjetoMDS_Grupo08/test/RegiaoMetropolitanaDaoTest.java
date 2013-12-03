package test;



import java.sql.SQLException;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import dao.RegiaoMetropolitanaDao;
import exception.ExceptionRegiaoMetropolitana;

public class RegiaoMetropolitanaDaoTest {
	
	private RegiaoMetropolitanaDao regiaoDao;
	private ExceptionRegiaoMetropolitana exception = mock(ExceptionRegiaoMetropolitana.class);
	
	
	
	@Before
	public void init() throws SQLException{
		regiaoDao = new RegiaoMetropolitanaDao();
		when(this.exception.verificaCampoDeParametro("Belem - PA", 2001)).thenReturn(true);
	}
	
	@Test
	public void deveRetornarQuantidadeListaRegioaoM() throws SQLException {
		assertEquals(4, regiaoDao.buscaRegiaoMetropolitanaAbsoluto("Belem - PA", 2001).size());
		assertNotNull(regiaoDao.buscaRegiaoMetropolitanaAbsoluto("Belem - PA", 2001));
		assertEquals(4, regiaoDao.buscaRegiaoMetropolitanaRelativo("Belem - PA", 2001).size());
		assertNotNull(regiaoDao.buscaRegiaoMetropolitanaRelativo("Belem - PA", 2001));
	}
	
	@Test
	public void deveRetornarQuantidadeListaAnos() throws SQLException{
		assertEquals(9, regiaoDao.getAnosRegiaoMetropolitana().size());
		assertNotNull( regiaoDao.getAnosRegiaoMetropolitana());	
	}
	
	@Test
	public void deveRetornarQuantidadeListaAnosComparacao() throws SQLException{
		assertEquals(8, regiaoDao.getAnosComparacaoRegiaoMetropolitana(2001).size());
		assertNotNull( regiaoDao.getAnosComparacaoRegiaoMetropolitana(2001));	
	}
	
	@Test
	public void deveRetornarQuantidadeListaRegioes() throws SQLException{
		assertEquals(9, regiaoDao.getRegioesRegiaoMetropolitana().size());
		assertNotNull(regiaoDao.getRegioesRegiaoMetropolitana());
	}
	
	@Test
	public void deveRetornarQuantidadeListaRegioesComparacao() throws SQLException{
		assertEquals(9, regiaoDao.getRegioesComparacaoRegiaoMetropolitana("Belem - PA").size());
		assertNotNull(regiaoDao.getRegioesComparacaoRegiaoMetropolitana("Belem - PA"));
	}

	
	@Test
	public void testeException() throws SQLException{
		assertTrue(this.exception.verificaCampoDeParametro("Belem - PA", 2001));
	}
	
	
}
