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

		boolean validacao = true;

		if (ano == 0 || regiao == null || ano2 == 0) {
			validacao = false;
		}

		return validacao;
	}

	public boolean verificaCampoDeParametro(String regiao, String regiao2,
			int ano) throws SQLException {

		boolean validacao = true;

		if (ano == 0 || regiao == null || regiao2 == null) {
			validacao = false;
		}

		return validacao;
	}

	public boolean validaListBox(List<RegiaoMetropolitana> listaRegiao) {
		
		if (listaRegiao.isEmpty() == true){
			return false;}
		
		return true;
	}

	public boolean validaListBoxAbsoluto(List<RegiaoMetropolitana> listaRegiao) {
		if (validaListBox(listaRegiao) == false){
			return false;}
		if (listaRegiao.get(1).getTipo() != "Absoluto"){
			return false;}
		return true;
	}

	public boolean validaListBoxRelativo(List<RegiaoMetropolitana> listaRegiao) {
		
		if (validaListBox(listaRegiao) == false)
			return false;
		if (listaRegiao.get(1).getTipo() != "Relativo")
			return false;
		return true;
	}

	//usado no metodo Busca
	public boolean validaGerarGraficoBusca(List<RegiaoMetropolitana> listaRegiaoAbsoluto,
			List<RegiaoMetropolitana> listaRegiaoRelativo) {
		if (validaListBoxAbsoluto(listaRegiaoAbsoluto) == false){
			return false;}
		if(validaListBoxRelativo(listaRegiaoRelativo) == false) {
			return false;
		}
		return true;
	}
	
	//usado no metodo comparacao
	public boolean validaGerarGraficoComparacao(List<RegiaoMetropolitana> listaRegiaoAbsoluto,
			List<RegiaoMetropolitana> listaRegiaoAbsoluto2) {
		
		

		if (validaListBoxAbsoluto(listaRegiaoAbsoluto) == false){
			return false;
		}
		if(validaListBoxAbsoluto(listaRegiaoAbsoluto2) == false){
			return false;
		}
		return true;
	}	
}
