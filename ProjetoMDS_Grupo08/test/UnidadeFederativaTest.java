package test;

import static org.junit.Assert.*;
import org.junit.*;
import model.*;

public class UnidadeFederativaTest {

public UnidadeFederativaTest(){

}

		UnidadeFederativa UF = new UnidadeFederativa();
        
		//Testes de Unidade Federativa
        @Test
        public void testRegiaoFederativa(){        
                assertEquals(null, UF.getRegiao());
                UF.setRegiao("São Paulo");
                assertEquals("São Paulo", UF.getRegiao());
                UF.setRegiao("Rio de Janeiro");
                assertEquals("Rio de Janeiro", UF.getRegiao());
                UF.setRegiao("Teste");
                assertEquals("Teste", UF.getRegiao());
        }
        
        @Test
        public void testValor(){
                assertEquals(0, UF.getValor());
                UF.setValor(4321);
                assertEquals(4321, UF.getValor());
                UF.setValor(0);
                assertEquals(0, UF.getValor());
                UF.setValor(555555555);
                assertEquals(555555555,UF.getValor());
        }
        
        @Test
        public void testOpcao(){
                assertNull(UF.getOpcao());
                UF.setOpcao("Opcional");
                assertEquals("Opcional", UF.getOpcao());
                UF.setOpcao("");
                assertEquals("", UF.getOpcao());
        }
        
        @Test
        public void testTipo(){
                assertNull(UF.getTipo());
                UF.setTipo("Tipacional");
                assertEquals("Tipacional", UF.getTipo());
                UF.setTipo("");
                assertEquals("", UF.getTipo());
        }
        
        @Test
        public void testAno(){
                assertNull(UF.getTipo());
                UF.setAno(2000);
                assertEquals(2000, UF.getAno());
                UF.setAno(2001);
                assertEquals(2001, UF.getAno());
        }

        @Test
        public void testRegiaoFederativaErrada(){
                UF.setRegiao("Rio de Janeiro");
                assertNotEquals(UF.getRegiao(), "Rio");
                assertNotNull(UF.getRegiao());
        }
        
        @Test
        public void testValorErrado(){
                UF.setValor(4321);
                assertNotEquals(UF.getValor(), 4321.00);
                assertNotNull(UF.getValor());
        }
        
        @Test
        public void testAnoErrado(){
                UF.setValor(1212);
                assertNotEquals(UF.getAno(), 1212.00);
                assertNotNull(UF.getAno());
        }
        
        @Test
        public void testOpcaoErrado(){
                UnidadeFederativa UF = new UnidadeFederativa();
                UF.setOpcao("Opcional");
                assertNotEquals(UF.getOpcao(),"Lanoicpo");
                assertNotNull(UF.getOpcao());
        }
        
        @Test
        public void testTipoErrado(){
                UnidadeFederativa UF = new  UnidadeFederativa();
                UF.setTipo("Tipacional");
                assertNotEquals(UF.getTipo(),"Lanoicapit");
                assertNotNull(UF.getTipo());
        }
}