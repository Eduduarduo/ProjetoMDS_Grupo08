package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;


import dao.UnidadeFederativaDao;

public class UnidadeFederativaDaoTest {

	private UnidadeFederativaDao ufDao;
	
	@Before
	public void init() throws SQLException{
		ufDao = new UnidadeFederativaDao();	
	}
	
	@Test
	public void deveRetornarQuantidadeListaUF() throws SQLException {
		assertEquals(4, ufDao.buscaUnidadeFederativaAbsoluto(2001, "Acre").size());
		assertNotNull(ufDao.buscaUnidadeFederativaAbsoluto(2001, "Acre"));
		assertEquals(4, ufDao.buscaUnidadeFederativaRelativo(2001, "Acre").size());
		assertNotNull(ufDao.buscaUnidadeFederativaRelativo(2001, "Acre"));
	}
	
	@Test
	public void deveRetornarQuantidadeListaAnos() throws SQLException{
		assertEquals(9, ufDao.getAnosUnidadeFederativa().size());
		assertNotNull(ufDao.getAnosUnidadeFederativa());
	}
	
	@Test
	public void deveRetornarQuantidadeListaAnosComparacao() throws SQLException{
		assertEquals(8, ufDao.getAnosComparacaoUnidadeFederativa(2009).size());
		assertNotNull(ufDao.getAnosComparacaoUnidadeFederativa(2009));
	}
 	
	@Test
	public void deveRetornarQuantidadeListaUFs() throws SQLException{
		assertEquals(27, ufDao.getUnidadeFederativa().size());
		assertNotNull(ufDao.getUnidadeFederativa());
	}
	
	@Test
	public void deveRetornarQuantidadeListaUFsComparacao() throws SQLException{
		assertNotNull(ufDao.getUFComparacao("Acre"));
	}

}
