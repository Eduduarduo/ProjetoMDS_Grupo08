package exception;

import java.sql.SQLException;
import java.util.List;

import dao.BrasilDao;
import model.Brasil;

public class ExceptionsBrasil {

	BrasilDao brasilDao;
	
	public ExceptionsBrasil(){
		
	}

	// Usada para comparação do parametro ano para Brasil
	public boolean verificaParamentroAno(int ano) throws SQLException {
		brasilDao = new BrasilDao();
		for (int i = 0; i < brasilDao.getDatas().size(); i++) {
			if ((brasilDao.getDatas().get(i).getAno()) == ano)
				return true;
		}
		return false;
	}

	// Usada para comparação de todos os anos em comparação de Brasil em anos
	// diferentes
	public boolean verificaCampoDeParametroComparacao(int ano1, int ano2)
			throws SQLException {
		if (ano1 != ano2)
			{return true;}
		if (verificaParamentroAno(ano1) == false)
		{	return false; }
		if (verificaParamentroAno(ano2) == false)
			{return false;}
		return true;
	}

	// Usada para validar listas de brasil
	public boolean validaListaBrasil(List<Brasil> listaBrasil) {

		Brasil brasil = new Brasil();
		if (listaBrasil.isEmpty() == true)
			return false;
		if (listaBrasil.getClass() == brasil.getClass())
			return false;
		return true;
	}

	public boolean validaListaBrasilTipoAbsoluto(
			List<Brasil> listaBrasilAbsoluto) {

		if (validaListaBrasil(listaBrasilAbsoluto) == false)
			return false;
		if (listaBrasilAbsoluto.get(1).getTipo() != "Absoluto")
			return false;
		return true;
	}

	public boolean validaListaBrasilTipoRelativo(
			List<Brasil> listaBrasilRelativo) {

		if (validaListaBrasil(listaBrasilRelativo) == false)
			return false;
		if (listaBrasilRelativo.get(1).getTipo() != "Relativo")
			return false;
		return true;
	}

	public boolean validaGerarGrafico(List<Brasil> listaAbsoluto,
			List<Brasil> listaRelativo) {

		if (validaListaBrasilTipoAbsoluto(listaAbsoluto) == false) {
			return false;
		}
		if (validaListaBrasilTipoRelativo(listaRelativo) == false) {
			return false;
		}
		return true;
	}

	public boolean validaComparacao(List<Brasil> listaAbsoluto1,
			List<Brasil> listaRelativo1, List<Brasil> listaAbsoluto2,
			List<Brasil> listaRelativo2) {

		if (validaGerarGrafico(listaAbsoluto1, listaRelativo1) == false)
			return false;
		if (validaGerarGrafico(listaAbsoluto2, listaRelativo2) == false)
			return false;
		return true;
	}
}
