package br.com.dld.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;
import br.com.dld.model.Dado;

public class TesteDado {

	Dado dados = EasyMock.createMock(Dado.class);
	
	@Before
	public void setUp() throws Exception {

	}

	
	@Test
	public void testGetTipoCerto() {

		EasyMock.expect(dados.getTipo()).andReturn("Tipo");
		assertEquals("Tipo", dados.getTipo());

	}

	@Test
	public void testGetTipoErrado() {
		EasyMock.expect(dados.getTipo()).andReturn("TipoErrado");
		assertEquals("Tipo", dados.getTipo());
	}

	@Test
	public void testGetIdCerto() {
		EasyMock.expect(dados.getId()).andReturn(13);
		assertEquals(13, dados.getId());

	}

	public void testGetIdErrado() {
		EasyMock.expect(dados.getId()).andReturn(45);
		assertEquals(13, dados.getId());

	}

	public void testGetOpcaoCerto() {

		EasyMock.expect(dados.getOpcao()).andReturn("Opcao");
		assertEquals("Opcao", dados.getId());

	}

	public void testGetOpcaoErrado() {

		EasyMock.expect(dados.getOpcao()).andReturn("OpcaoErrado");
		assertEquals("Opcao", dados.getId());

	}

	public void testGetValorCerto() {

		EasyMock.expect(dados.getValor()).andReturn(1123);
		assertEquals(1123, dados.getValor());

	}

	public void testGetValorErrado() {

		EasyMock.expect(dados.getValor()).andReturn(1123);
		assertEquals(1234, dados.getValor());

	}
	

	
	
	
	
	

}

