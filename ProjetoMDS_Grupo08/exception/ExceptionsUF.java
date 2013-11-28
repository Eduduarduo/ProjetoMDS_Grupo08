package exception;

import java.sql.SQLException;
import java.util.List;


import model.UnidadeFederativa;
import dao.UnidadeFederativaDao;

public class ExceptionsUF {
	UnidadeFederativaDao UFDao;
	
	public ExceptionsUF() {
	}
	//Verifica Parametro Ano para UF
	public boolean verificaParamentroAnoUF(int ano) throws SQLException {
		UFDao = new UnidadeFederativaDao();
		for (int i = 0; i < UFDao.getAnosUnidadeFederativa().size(); i++) {
			if ((UFDao.getAnosUnidadeFederativa().get(i).getAno() == ano ))
				{System.out.println(i);
				return true;}
		}{
		return false;
		}}
	//Verifica Campo tipo String de UF que e passado como parametro
	public boolean verificaParamentroUF(String uf) throws SQLException {
		UFDao = new UnidadeFederativaDao();
		for (int i = 0; i < UFDao.getUnidadeFederativa().size(); i++) {
			if ((UFDao.getUnidadeFederativa().get(i).getRegiao().equals(uf)))
				return true;
		}
		return false;
	}
	
	public boolean verificaComparacaoUFAno(int ano1, int ano2)
			throws SQLException {
		if (ano1 != ano2)
			{return true;}
		if (verificaParamentroAnoUF(ano1) == false)
		{	return false; }
		if (verificaParamentroAnoUF(ano2) == false)
			{return false;}
		return true;
	}
	
	
	public boolean verificaComparacaoUF(String uf1, String  uf2)
			throws SQLException {
		if (uf1 != uf2)
			{return true;}
		if (verificaParamentroUF(uf1) == false)
		{	return false; }
		if (verificaParamentroUF(uf2) == false)
			{return false;}
		return true;
	}
	public boolean validaListaUF(List<UnidadeFederativa> listaUF) {
		
		UnidadeFederativa uf = new UnidadeFederativa();
		if (listaUF.isEmpty() == true)
			return false;
		if (listaUF.getClass() == uf.getClass())
			return false;
		return true;
	}
	
	public boolean validaListaUFTipoAbsoluto(
			List<UnidadeFederativa> listaUFAbsoluto) {

		if (validaListaUF(listaUFAbsoluto) == false)
			return false;
		if (listaUFAbsoluto.get(1).getTipo() != "Absoluto")
			return false;
		return true;
	}
	public boolean validaListaUFTipoRelativo(
			List<UnidadeFederativa> listaUFRelativo) {

		if (validaListaUF(listaUFRelativo) == false)
			return false;
		if (listaUFRelativo.get(1).getTipo() != "Relativo")
			return false;
		return true;
	}
	public boolean validaGerarGraficoUF(List<UnidadeFederativa> listaUFAbsoluto,
			List<UnidadeFederativa> listaUFRelativo) {

		if (validaListaUFTipoAbsoluto(listaUFAbsoluto) == false) {
			return false;
		}
		if (validaListaUFTipoRelativo(listaUFRelativo) == false) {
			return false;
		}
		return true;
	}
	public boolean validaComparacaoUF(List<UnidadeFederativa> listaUFAbsoluto1,
			List<UnidadeFederativa> listaUFRelativo1, List<UnidadeFederativa> listaUFAbsoluto2,
			List<UnidadeFederativa> listaUFRelativo2) {

		if (validaGerarGraficoUF(listaUFAbsoluto1, listaUFRelativo1) == false)
			return false;
		if (validaGerarGraficoUF(listaUFAbsoluto2, listaUFRelativo2) == false)
			return false;
		return true;
	}

	


}
