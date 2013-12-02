package exception;

import java.sql.SQLException;

import dao.UnidadeFederativaDao;

public class ExceptionsUF {
	UnidadeFederativaDao UFDao;

	public ExceptionsUF() {
	}

	// Verifica Parametro Ano para UF
	public boolean verificaParamentroAnoUF(int ano) throws SQLException {
		UFDao = new UnidadeFederativaDao();
		for (int i = 0; i < UFDao.getAnosUnidadeFederativa().size(); i++) {
			if ((UFDao.getAnosUnidadeFederativa().get(i).getAno() == ano)) {
				return true;
			}
		}
		return false;
	}

	// Verifica Campo tipo String de UF que e passado como parametro
	public boolean verificaParamentroUF(String uf) throws SQLException {
		UFDao = new UnidadeFederativaDao();
		for (int i = 0; i < UFDao.getUnidadeFederativa().size(); i++) {
			if ((UFDao.getUnidadeFederativa().get(i).getRegiao().equals(uf))){
				return true;
			}	
		}
		return false;
	}

}
