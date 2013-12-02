package test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import model.Brasil;

import dao.BrasilDao;
import exception.ExceptionsBrasil;

public class TesteBrasilDao {

	private BrasilDao brasilDao = new BrasilDao();
	private ExceptionsBrasil exceptionBrasil = mock(ExceptionsBrasil.class);
	private List<Brasil> brasil;


	@Test
	public void testeContrutor(){
		assertNotNull(new TesteBrasilDao());
	}
	@Test
	public void testeContrutorNotSame(){
		assertNotNull(new TesteBrasilDao());
		assertNotSame(exceptionBrasil,brasilDao);
	}
	
	@Test
	public void testBuscaBrasilAbsolutoNãoNulo() throws SQLException {
		int ano = 1981;
		when(exceptionBrasil.verificaParamentroAno(ano)).thenReturn(true);
		brasilDao.buscaBrasilAbsoluto(ano);
		assertNotNull(brasilDao.buscaBrasilAbsoluto(ano));
	}

	@Test
	public void testBuscaBrasilAbsolutoPorAnoFalse() throws SQLException {
		int ano = 1981;
		when(exceptionBrasil.verificaParamentroAno(ano)).thenReturn(false);
		brasilDao.buscaBrasilAbsoluto(ano);
		assertNotSame(brasilDao.buscaBrasilAbsoluto(ano), brasil);
	}
	@Test
	public void testBuscaBrasilAbsolutoPorAnoTrue() throws SQLException {
		int ano = 1981;
		when(exceptionBrasil.verificaParamentroAno(ano)).thenReturn(true);
		brasilDao.buscaBrasilAbsoluto(ano);
		assertNotSame(brasilDao.buscaBrasilAbsoluto(ano), brasil);
	}
	@Test
	public void testeBuscaBrasilAbsoluto() throws SQLException{
		int ano = 3002;
		assertNotSame(brasilDao.buscaBrasilAbsoluto(ano), brasil);
	}
	@Test
	public void testeBuscaBrasilRelativo() throws SQLException{
		int ano = 3002;
		assertNotSame(brasilDao.buscaBrasilRelativo(ano), brasil);
	}
	@Test
	public void testeGeDatasComparacao() throws SQLException{
		int ano = 3002;
		assertNotSame(brasilDao.getDatasComparacao(ano), brasil);
	}
	
	
	
	
	
	@Test
	public void testBuscaBrasilAbsolutoPorAno() throws SQLException {
		int ano = 1981;
		when(exceptionBrasil.verificaParamentroAno(ano)).thenReturn(true);
		brasilDao.buscaBrasilAbsoluto(ano);
		assertEquals(brasilDao.buscaBrasilAbsoluto(1981).get(3).getAno(), 1981);
	}

	@Test
	public void testBuscaBrasilRelativoNãoNulo() throws SQLException {
		int ano = 1981;
		when(exceptionBrasil.verificaParamentroAno(ano)).thenReturn(true);
		assertNotNull(brasilDao.buscaBrasilRelativo(ano));
	}

	@Test
	public void testBuscaBrasilRelativoPorAno() throws SQLException {
		int ano = 1981;
		when(exceptionBrasil.verificaParamentroAno(ano)).thenReturn(true);
		assertEquals(brasilDao.buscaBrasilRelativo(ano).get(3).getAno(), 1981);
	}
	
	
	@Test
	public void testBuscaBrasilRelativoPorAnoFalse() throws SQLException {
		int ano = 1981;
		when(exceptionBrasil.verificaParamentroAno(ano)).thenReturn(false);
		assertNotSame(brasilDao.buscaBrasilRelativo(ano).get(3).getAno(), 1981);
	}
	
	
	@Test
	public void testGetDatasNãoNulo() throws SQLException {
		assertNotNull(brasilDao.getDatas());
	}

	@Test
	public void testGetDatasNãoNuloDiferente() throws SQLException {
		assertNotSame(brasilDao.getDatas(), brasil);

	}

	@Test
	public void testGetDatas() throws SQLException {
		assertNotSame(brasilDao.getDatas(), brasil);
	}

	@Test
	public void testGetDatasPorAno() throws SQLException {
		assertEquals(brasilDao.getDatas().get(0).getAno(), 1981);
	}

	@Test
	public void testGetDatasComparacao() throws SQLException {
		int ano = 1981;
		when(exceptionBrasil.verificaParamentroAno(ano)).thenReturn(true);
		assertNotNull(brasilDao.getDatasComparacao(ano));
	}

	@Test
	public void testGetDatasComparacaooDiferente() throws SQLException {
		int ano = 1981;
		when(exceptionBrasil.verificaParamentroAno(ano)).thenReturn(true);
		assertNotSame(brasilDao.getDatasComparacao(ano), brasil);
	}

	@Test
	public void testGetDatasComparacaooDiferenteFalse() throws SQLException {
		int ano = 1981;
		when(exceptionBrasil.verificaParamentroAno(ano)).thenReturn(false);
		assertNotSame(brasilDao.getDatasComparacao(ano).get(1).getAno(),ano);
	}
	@Test
	public void testBrasilDao() {
		assertNotNull(new BrasilDao());
	}
	@Test
	public void testBrasilDaoNotSame() {
		assertNotSame(new BrasilDao(),exceptionBrasil);
	}
	@Test
	public void testBrasilDaoEquals() throws SQLException {
		assertNotSame(new BrasilDao().getDatas(),brasilDao.getDatas());
		
	}
	
	
}
