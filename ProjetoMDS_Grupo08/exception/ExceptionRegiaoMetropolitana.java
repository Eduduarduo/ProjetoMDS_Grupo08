package exception;

import java.sql.SQLException;
import java.util.List;

import dao.RegiaoMetropolitanaDao;
import model.RegiaoMetropolitana;

public class ExceptionRegiaoMetropolitana {
	private RegiaoMetropolitanaDao  regiaoDao;
	public boolean verificaCampoDeParametro(int ano) throws SQLException {
		regiaoDao = new RegiaoMetropolitanaDao();
		
		for(int i = 0; i < regiaoDao.getAnosRegiaoMetropolitana().size(); i++)
			if(regiaoDao.getAnosRegiaoMetropolitana().get(i).getAno() == ano)
				return true;

		return false;
	}

	public boolean verificaCampoDeParametro(String regiao) throws SQLException {
		regiaoDao = new RegiaoMetropolitanaDao();
		
		for(int i = 0; i < regiaoDao.getRegioesRegiaoMetropolitana().size(); i++)
			if(regiaoDao.getRegioesRegiaoMetropolitana().get(i).getRegiao().equals(regiao))
				return true;

		return false;
	}

	//
	public boolean verificaCampoDeParametro(String regiao, int ano)
			throws SQLException {
		
		if(verificaCampoDeParametro(ano) == false)
			return false;
		if(verificaCampoDeParametro(regiao) == false)
			return false;
		
		return true;
	}

	public boolean verificaCampoDeParametro(String regiao, int ano, int ano2)
			throws SQLException {

		if(ano == ano2)
			return false;
		if(verificaCampoDeParametro(ano) == false)
			return false;
		if(verificaCampoDeParametro(ano2) == false)
			return false;
		if(verificaCampoDeParametro(regiao) == false)
			return false;
		
		return true;
	}

	public boolean verificaCampoDeParametro(String regiao, String regiao2,
			int ano) throws SQLException {
		if(regiao == regiao2)
			return false;
		if(verificaCampoDeParametro(ano) == false)
			return false;
		if(verificaCampoDeParametro(regiao2) == false)
			return false;
		if(verificaCampoDeParametro(regiao) == false)
			return false;
		
		return true;
	}

	public boolean validaListBox(List<RegiaoMetropolitana> listaRegiao) {
		
		if (listaRegiao.isEmpty() == true){
			return false;}
		
		return true;
	}

	//usado no metodo Busca
	public boolean validaGerarGrafico(List<RegiaoMetropolitana> listaRegiaoAbsoluto,
			List<RegiaoMetropolitana> listaRegiaoRelativo) {
		if (validaListBox(listaRegiaoAbsoluto) == false){
			return false;}
		if(validaListBox(listaRegiaoRelativo) == false) {
			return false;
		}
		return true;
	}
		
}
