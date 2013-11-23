package test;



import java.sql.SQLException;


import org.junit.Before;
import org.junit.Test;
//import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

import dao.RegiaoMetropolitanaDao;

public class RegiaoMetropolitanaDaoTest {
	
	private RegiaoMetropolitanaDao regiaoDao;
	
	@Before
	public void init() throws SQLException{
		MockitoAnnotations.initMocks(this);
		regiaoDao = new RegiaoMetropolitanaDao();
		
}
	
	@Test
	public void testaQuantidadeReturonoListaRegiaoMetropolitna() throws SQLException {
		assertEquals(4, regiaoDao.buscaRegiaoMetropolitanaAbsoluto("Belem - PA", 2001).size());
		
	}
	
	
	//preciso verificar se a lista está vazia? eu acho desnecessário
	@Test
	public void testaSeListaRegiaoMetropolitanaEstaVazia() throws SQLException{
		assertFalse(regiaoDao.buscaRegiaoMetropolitanaAbsoluto("Belem - PA", 2001).isEmpty());
	}

}
