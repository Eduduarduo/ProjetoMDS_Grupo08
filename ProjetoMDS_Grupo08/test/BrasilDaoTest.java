package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import dao.BrasilDao;

public class BrasilDaoTest {

	private BrasilDao brasilDao;
	
	@Before
	public void init() throws SQLException{
		MockitoAnnotations.initMocks(this);
		brasilDao = new BrasilDao();
		
}
	
	@Test
	public void testaQuantidadeReturonoListaRegiaoMetropolitna() throws SQLException {
		assertEquals(4, brasilDao.buscaBrasilAbsoluto(2001).size());
		
	}
	
	
	//preciso verificar se a lista está vazia? eu acho desnecessário
	@Test
	public void testaSeListaRegiaoMetropolitanaEstaVazia() throws SQLException{
		assertFalse(brasilDao.buscaBrasilAbsoluto(2001).isEmpty());
	}

}
