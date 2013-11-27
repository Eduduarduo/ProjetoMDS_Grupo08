package exception;

import java.sql.SQLException;
import java.util.List;
import model.RegiaoMetropolitana;

public class ExceptionRegiaoMetropolitana {

	public boolean verificaCampoDeParametro(int ano) throws SQLException {

		boolean validacao = true;

		if (ano == 0) {
			validacao = false;
		}

		return validacao;
	}

	public boolean verificaCampoDeParametro(String regiao) throws SQLException {

		boolean validacao = true;

		if (regiao == null) {
			validacao = false;
		}

		return validacao;
	}

	public boolean verificaCampoDeParametro(String regiao, int ano)
			throws SQLException {

		boolean validacao = true;

		if (ano == 0 || regiao == null) {
			validacao = false;
		}

		return validacao;
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

	public boolean validaListBox(List<String> listaRegiao) {
		if (listaRegiao.isEmpty() == true)
			return false;
		else
			return true;
	}

	public boolean validaAnosListBox(List<Integer> anos) {
		if (anos.isEmpty() == true)
			return false;
		else
			return true;
	}

	public boolean validaLista(List<RegiaoMetropolitana> listaData) {
		boolean validacao = true;

		if (listaData.isEmpty() == true) {
			validacao = false;
		}
		return validacao;
	}

	public boolean validaListasGraficos(List<RegiaoMetropolitana> listaData1,
			List<RegiaoMetropolitana> listaData2) {
	
		boolean validacao = true;
		boolean val = validaLista(listaData1);
		boolean val2 = validaLista(listaData2);

		if (val == false || val2 == false) {
			validacao = false;
		}
		return validacao;
	}
}
