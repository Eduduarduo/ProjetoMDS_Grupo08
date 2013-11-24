package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import dao.UnidadeFederativaDao;

public class UnidadeFederativaDaoTest {

	private UnidadeFederativaDao ufDao;
	
	@Before
	public void init() throws SQLException{
		MockitoAnnotations.initMocks(this);
		ufDao = new UnidadeFederativaDao();
		
}
	
	@Test
	public void testaQuantidadeReturonoUF() throws SQLException {
		assertEquals(4, ufDao.buscaUnidadeFederativaAbsoluto(2001, "Acre").size());
		
	}
	
	
	//preciso verificar se a lista está vazia? eu acho desnecessário
	@Test
	public void testaSeListaRegiaoMetropolitanaEstaVazia() throws SQLException{
		assertFalse(ufDao.buscaUnidadeFederativaAbsoluto(2001, "Acre").isEmpty());
	}

}
