package test;



import java.sql.SQLException;


import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import dao.RegiaoMetropolitanaDao;

public class RegiaoMetropolitanaDaoTest {
	
	private RegiaoMetropolitanaDao regiaoDao;
	
	@Before
	public void init() throws SQLException{
		MockitoAnnotations.initMocks(this);
		regiaoDao = new RegiaoMetropolitanaDao();
		
}
	
	@Test
	public void deveRetornarQuantidadeListaRegioaoM() throws SQLException {
		assertEquals(4, regiaoDao.buscaRegiaoMetropolitanaAbsoluto("Belem - PA", 2001).size());
		assertNotNull(regiaoDao.buscaRegiaoMetropolitanaAbsoluto("Belem - PA", 2001));
	}
	
	
	@Test
	public void deveRetornarQuantidadeListaAnos() throws SQLException{
		assertEquals(9, regiaoDao.getAnosRegiaoMetropolitana().size());
		assertNotNull( regiaoDao.getAnosRegiaoMetropolitana());
		
	}
	
	@Test
	public void deveRetornarQuantidadeListaAnosComparacao() throws SQLException{
		assertEquals(8, regiaoDao.getAnosComparacaoRegiaoMetropolitana(2001).size());
		assertNotNull(regiaoDao.getAnosComparacaoRegiaoMetropolitana(2001));
	}
	
	@Test
	public void deveRetornarQuantidadeListaRegioes() throws SQLException{
		assertEquals(9, regiaoDao.getRegioesRegiaoMetropolitana().size());
		assertNotNull(regiaoDao.getAnosComparacaoRegiaoMetropolitana(2001));
	}
	
	@Test
	public void deveRetornarQuantidadeListaRegioesComparacao() throws SQLException{
		assertEquals(8, regiaoDao.getRegioesComparacaoRegiaoMetropolitana("Belem - PA").size());
		assertNotNull(regiaoDao.getRegioesComparacaoRegiaoMetropolitana("Belem - PA"));
	}
	

}
