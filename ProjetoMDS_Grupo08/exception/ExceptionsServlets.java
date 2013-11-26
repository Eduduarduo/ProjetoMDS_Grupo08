package exception;

import java.util.List;
import model.Brasil;
import model.UnidadeFederativa;

public class ExceptionsServlets {

	List<Brasil> listaBrasil;

	public boolean validaListBox(List<String> listaData) {
		if (listaData.isEmpty() == true)
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

	public boolean validarListasBrasil(List<Brasil> listaRelativo,
			List<Brasil> listaAbsoluto) {
		if (listaAbsoluto.isEmpty() == true && listaRelativo.isEmpty() == true) {
			return false;
		} else
			return true;
	}

	public boolean validarListasUF(List<UnidadeFederativa> listaRelativo,
			List<UnidadeFederativa> listaAbsoluto) {
		if (listaAbsoluto.isEmpty() == true && listaRelativo.isEmpty() == true) {
			return false;
		} else
			return true;
	}
}
