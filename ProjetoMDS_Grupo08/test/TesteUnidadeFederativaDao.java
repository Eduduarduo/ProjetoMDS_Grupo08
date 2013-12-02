package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.ConnectionFactory;
import dao.UnidadeFederativaDao;

import exception.ExceptionsUF;
import model.UnidadeFederativa;

public class TesteUnidadeFederativaDao {

	UnidadeFederativaDao ufDao = new UnidadeFederativaDao();
	UnidadeFederativaDao uft = mock(UnidadeFederativaDao.class);

	ExceptionsUF exception = mock(ExceptionsUF.class);
	ConnectionFactory conexao =  mock(ConnectionFactory.class);

	List<UnidadeFederativa> listUF;
	int ano = 2001;
	String uf = "Para";

	@Test
	public void testContrutor() {
		assertNotNull(new UnidadeFederativa());
	}

	@Test
	public void testBuscaUnidadeFederativaAbsoluto() throws SQLException {
		when(exception.verificaParamentroAnoUF(ano)).thenReturn(true);
		when(exception.verificaParamentroUF(uf)).thenReturn(true);
		assertNotNull(ufDao.buscaUnidadeFederativaAbsoluto(ano, uf));
		assertNotSame(listUF, ufDao.buscaUnidadeFederativaAbsoluto(ano, uf));
	}

	@Test
	public void testBuscaUnidadeFederativaAbsolutoAnoFalse()
			throws SQLException {
		when(exception.verificaParamentroAnoUF(ano)).thenReturn(false);
		when(exception.verificaParamentroUF(uf)).thenReturn(true);
		doCallRealMethod().when(conexao).getConnection();
		assertNotNull(ufDao.buscaUnidadeFederativaAbsoluto(ano, uf));
		assertNotSame(listUF, ufDao.buscaUnidadeFederativaAbsoluto(ano, uf));
	}

	@Test
	public void testBuscaUnidadeFederativaAbsolutoUFFalse() throws SQLException {
		when(exception.verificaParamentroAnoUF(ano)).thenReturn(true);
		when(exception.verificaParamentroUF("kk")).thenReturn(false);
		doCallRealMethod().when(conexao).getConnection();
		assertNotNull(ufDao.buscaUnidadeFederativaAbsoluto(ano, "kkk"));
		assertNotSame(listUF, ufDao.buscaUnidadeFederativaAbsoluto(ano, "kkk"));
	}
	@Test
	public void testBuscaUnidadeFederativaAbsolutoAnoUFFalse()
			throws SQLException {
		when(exception.verificaParamentroAnoUF(ano)).thenReturn(false);
		when(exception.verificaParamentroUF(uf)).thenReturn(false);
		doCallRealMethod().when(conexao).getConnection();
		assertNotNull(ufDao.buscaUnidadeFederativaAbsoluto(ano, uf));
		assertNotSame(listUF, ufDao.buscaUnidadeFederativaAbsoluto(ano, uf));
	}
	
	@Test
	public void testbuscaUnidadeFederativaRelativoUFAnoFalse() throws SQLException{
		doCallRealMethod().when(conexao).getConnection();
		when(exception.verificaParamentroAnoUF(ano)).thenReturn(false);
		when(exception.verificaParamentroUF(uf)).thenReturn(false);
		assertNotNull(ufDao.buscaUnidadeFederativaRelativo(ano, uf));
		assertNotSame(listUF,ufDao.buscaUnidadeFederativaRelativo(ano, uf));
	}
	@Test
	public void testbuscaUnidadeFederativaRelativo() throws SQLException{
		doCallRealMethod().when(conexao).getConnection();
		when(exception.verificaParamentroAnoUF(ano)).thenReturn(true);
		when(exception.verificaParamentroUF(uf)).thenReturn(true);
		assertNotNull(ufDao.buscaUnidadeFederativaRelativo(ano, uf));
		assertNotSame(listUF,ufDao.buscaUnidadeFederativaRelativo(ano, uf));
		assertEquals(ufDao.buscaUnidadeFederativaAbsoluto(ano,uf).get(0).getAno(),ano);
	}
	@Test
	public void testbuscaUnidadeFederativaRelativoAnoFalse() throws SQLException{
		doCallRealMethod().when(conexao).getConnection();
		when(exception.verificaParamentroAnoUF(ano)).thenReturn(false);
		when(exception.verificaParamentroUF(uf)).thenReturn(true);
		assertNotNull(ufDao.buscaUnidadeFederativaRelativo(ano, uf));
		assertNotSame(listUF,ufDao.buscaUnidadeFederativaRelativo(ano, uf));
	}
	@Test
	public void testbuscaUnidadeFederativaRelativoUFFalse() throws SQLException{
		doCallRealMethod().when(conexao).getConnection();
		when(exception.verificaParamentroAnoUF(ano)).thenReturn(true);
		when(exception.verificaParamentroUF("kkk")).thenReturn(false);
		assertNotNull(ufDao.buscaUnidadeFederativaRelativo(ano, uf));
		assertNotSame(listUF,ufDao.buscaUnidadeFederativaRelativo(ano, "kkk"));
	}
	
	@Test 
	public void testGetAnosComparacaoUnidadeFederativa1() throws SQLException{
		doCallRealMethod().when(conexao).getConnection();
		when(exception.verificaParamentroAnoUF(ano)).thenReturn(true);
		assertNotNull(ufDao.getAnosComparacaoUnidadeFederativa(ano));
		assertNotSame(listUF,ufDao.getAnosComparacaoUnidadeFederativa(ano));
		assertEquals(ufDao.getAnosComparacaoUnidadeFederativa(2005).get(1).getAno(),2002);
	}
	@Test 
	public void testGetAnosComparacaoUnidadeFederativaAnoFalse() throws SQLException{
	doCallRealMethod().when(conexao).getConnection();
	when(exception.verificaParamentroAnoUF(300)).thenReturn(false);
		assertNotNull(ufDao.getAnosComparacaoUnidadeFederativa(3004444));
		assertNotSame(listUF,ufDao.getAnosComparacaoUnidadeFederativa(300444));
	}
	
	@Test
	public void testGetUFComparacao() throws SQLException{
		doCallRealMethod().when(conexao).getConnection();
		when(exception.verificaParamentroUF(uf)).thenReturn(true);
		assertNotNull(ufDao.getUFComparacao(uf));
		assertNotSame(ufDao.getUFComparacao(uf),listUF);
		equals(ufDao.getUFComparacao(uf).get(1).getRegiao().equals(uf) );
		assertNotSame(ufDao.getUFComparacao(uf).get(1).getRegiao(),uf);
		
	}
	@Test
	public void testGetUFComparacaoAnoFalse() throws SQLException{
		doCallRealMethod().when(conexao).getConnection();
		when(exception.verificaParamentroUF("CASA")).thenReturn(false);
		assertNotNull(ufDao.getUFComparacao("CASA"));
		assertNotSame(ufDao.getUFComparacao("CASA"),listUF);
		
	}
	@Test
	public void testGetAnosUnidadeFederativa() throws SQLException{
		assertNotNull(ufDao.getAnosUnidadeFederativa());
		assertNotSame(listUF,ufDao.getAnosUnidadeFederativa());
	}
	
	

///----------------------------------
	
	
	@Test
	public void testUnidadeFederativaDaoConstrutor() {
	assertNotNull(new UnidadeFederativaDao() );	
	}
	@Test
	public void testUnidadeFederativaDaoConstrutornotSame() {
	assertNotSame(new UnidadeFederativaDao(),exception );	
	}
	
	
	
	
	@Test
	public void testBuscaUnidadeFederativaAbsoluto1() throws SQLException {
		
		assertNotNull(ufDao.buscaUnidadeFederativaAbsoluto(2001,"Rondonia"));
		assertNotSame(listUF, ufDao.buscaUnidadeFederativaAbsoluto(2001, "Rondonia"));
	}
	@Test
	public void testBuscaUnidadeFederativaAbsolutoEquals() throws SQLException {
		List<UnidadeFederativa> listUF = null;
		when(exception.verificaParamentroAnoUF(2001)).thenReturn(true);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(true);
		assertNotNull(ufDao.buscaUnidadeFederativaAbsoluto(2001,"Rondonia"));
		equals(ufDao.buscaUnidadeFederativaAbsoluto(2001,"Rondonia").equals(listUF));
	}
	@Test
	public void testBuscaUnidadeFederativaAbsolutoEqualsFalseAno() throws SQLException {
		List<UnidadeFederativa> listUF = null;
		when(exception.verificaParamentroAnoUF(2001)).thenReturn(false);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(true);
		assertNotNull(ufDao.buscaUnidadeFederativaAbsoluto(2001,"Rondonia"));
		equals(ufDao.buscaUnidadeFederativaAbsoluto(2001,"Rondonia").equals(listUF));
	}
	@Test
	public void testBuscaUnidadeFederativaAbsolutoEqualsFalseUF() throws SQLException {
		List<UnidadeFederativa> listUF = null;
		when(exception.verificaParamentroAnoUF(2001)).thenReturn(true);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(false);
		assertNotNull(ufDao.buscaUnidadeFederativaAbsoluto(2001,"Rondonia"));
		equals(ufDao.buscaUnidadeFederativaAbsoluto(2001,"Rondonia").equals(listUF));
	}
	@Test
	public void testBuscaUnidadeFederativaAbsolutoEqualsFalseAmbos() throws SQLException {
		List<UnidadeFederativa> listUF = null;
		when(exception.verificaParamentroAnoUF(2001)).thenReturn(false);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(false);
		assertNotNull(ufDao.buscaUnidadeFederativaAbsoluto(2001,"Rondonia"));
		equals(ufDao.buscaUnidadeFederativaAbsoluto(2001,"Rondonia").equals(listUF));
	}
	
	@Test
	public void testBuscaUnidadeFederativaAbsolutoAnoErrado() throws SQLException {
		when(exception.verificaParamentroAnoUF(2001)).thenReturn(false);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(true);
		assertNotNull(ufDao.buscaUnidadeFederativaAbsoluto(2001,"Rondonia"));
	}
	
	@Test
	public void testBuscaUnidadeFederativaAbsolutoUFErrado() throws SQLException {
		when(exception.verificaParamentroAnoUF(2001)).thenReturn(true);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(false);
		assertNotNull(ufDao.buscaUnidadeFederativaAbsoluto(2001,"Rondonia"));
	}@Test
	public void testBuscaUnidadeFederativaAbsolutoUFAnoErrado() throws SQLException {
		when(exception.verificaParamentroAnoUF(2001)).thenReturn(false);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(false);
		assertNotNull(ufDao.buscaUnidadeFederativaAbsoluto(2001,"Rondonia"));
	}
	
	
	//Acrescentar outros paramentros
	

	@Test
	public void testBuscaUnidadeFederativaRelativo() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(true);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(true);
		assertNotNull(ufDao.buscaUnidadeFederativaRelativo(2001,"Rondonia"));
	}
	@Test
	public void testBuscaUnidadeFederativaRelativoAnoErrado() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(false);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(true);
		assertNotNull(ufDao.buscaUnidadeFederativaRelativo(2001,"Rondonia"));
	}
	@Test
	public void testBuscaUnidadeFederativaRelativoUFErrado() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(true);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(false);
		assertNotNull(ufDao.buscaUnidadeFederativaRelativo(2001,"Rondonia"));
	}
	@Test
	public void testBuscaUnidadeFederativaRelativoUFAnoErrado() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(false);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(false);
		assertNotNull(ufDao.buscaUnidadeFederativaRelativo(2001,"Rondonia"));
	}	
	@Test
	public void testBuscaUnidadeFederativaRelativoEquals() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(true);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(true);
		equals(ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia").equals(listUF));
		assertNotSame(listUF,ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia"));
		
	}
	@Test
	public void testBuscaUnidadeFederativaRelativoAnoFalse() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(false);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(true);
		equals(ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia").equals(listUF));
		assertNotSame(listUF,ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia"));
		
	}
	@Test
	public void testBuscaUnidadeFederativaRelativoUFFalse() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(true);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(false);
		equals(ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia").equals(listUF));
		assertNotSame(listUF,ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia"));
		
	}
	@Test
	public void testBuscaUnidadeFederativaRelativoUFAnoFalse() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(false);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(false);
		equals(ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia").equals(listUF));
		assertNotSame(listUF,ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia"));
		
	}
	@Test
	public void testBuscaUnidadeFederativaRelativoEquals2() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(true);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(true);
		equals(ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia"));
		assertNotSame(listUF,ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia"));
		
	}
	@Test
	public void testBuscaUnidadeFederativaRelativoEquals2AnoFalse() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(false);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(true);
		equals(ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia"));
		assertNotSame(listUF,ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia"));
		
	}
	@Test
	public void testBuscaUnidadeFederativaRelativoEquals2UFFalse() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(true);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(false);
		equals(ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia"));
		assertNotSame(listUF,ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia"));
		
	}
	@Test
	public void testBuscaUnidadeFederativaRelativoEquals2AmbosFalse() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(false);
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(false);
		equals(ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia"));
		assertNotSame(listUF,ufDao.buscaUnidadeFederativaRelativo(2002,"Rondonia"));
	}
	
	//acrescentar mais metodos de diferentes asserts
	@Test
	public void testGetAnosUnidadeFederativa1() throws SQLException {
	assertNotNull(ufDao.getAnosUnidadeFederativa());
	}
	@Test
	public void testGetAnosUnidadeFederativaNotSame() throws SQLException {
	assertNotSame(ufDao.getAnosUnidadeFederativa(), exception);
	}
	@Test
	public void testGetAnosUnidadeFederativaSame() throws SQLException {
	equals(ufDao.getAnosUnidadeFederativa().equals(listUF));
	}
	@Test
	public void testGetUnidadeFederativa() throws SQLException {
	assertNotNull(ufDao.getUnidadeFederativa());	
	}

	@Test
	public void testGetAnosComparacaoUnidadeFederativa() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(true);
		assertNotNull(ufDao.getAnosComparacaoUnidadeFederativa(2002));
		
	}
	@Test
	public void testGetAnosComparacaoUnidadeFederativaparametroErrado() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(true);
		assertNotNull(ufDao.getAnosComparacaoUnidadeFederativa(2030));
	}
	
	@Test
	public void testGetAnosComparacaoUnidadeFederativaAnoErrado() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(false);
		assertNotNull(ufDao.getAnosComparacaoUnidadeFederativa(2002));
		
	}
	@Test
	public void testGetAnosComparacaoUnidadeFederativaAnoErradoParametro() throws SQLException {
		when(exception.verificaParamentroAnoUF(2002)).thenReturn(false);
		assertNotNull(ufDao.getAnosComparacaoUnidadeFederativa(2030));
		
	}
	@Test
	public void testGetUFComparacao1() throws SQLException {
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(true);
		ufDao.getUFComparacao("Rondonia");
		assertNotNull(ufDao.getUFComparacao("Rondonia"));
	}
	@Test
	public void testGetUFComparacaoFalse() throws SQLException {
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(false);
		ufDao.getUFComparacao("Rondonia");
		assertNotNull(ufDao.getUFComparacao("Rondonia"));
	}
	@Test
	public void testGetUFComparacaoParamentro() throws SQLException {
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(false);
		ufDao.getUFComparacao("Rondonia");
		assertNotNull(ufDao.getUFComparacao("Acre"));
	}
	@Test
	public void testGetUFComparacaoExceptio() throws SQLException {
		when(exception.verificaParamentroUF("Rondonia")).thenReturn(false);
		ufDao.getUFComparacao("Acre");
		assertNotNull(ufDao.getUFComparacao("Para"));
	}
	
	

	
	
	
	
	
	
}
