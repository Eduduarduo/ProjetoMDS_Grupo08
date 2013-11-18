package exception;

import java.util.List;
import model.RegiaoMetropolitana;


public class RegiaoMetropolitanaExceptions {
	
	List<RegiaoMetropolitana> listaRegiaoMetropolitana;

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

	public boolean validarListasRegiaoMetropolitana(List<RegiaoMetropolitana> listaRelativo,
			List<RegiaoMetropolitana> listaAbsoluto) {
		if (listaAbsoluto.isEmpty() == true && listaRelativo.isEmpty() == true) {
			return false;
		} else
			return true;
	}
	
	
	public boolean validarDatas(int ano1, int ano2){
		
		if(ano1 == ano2){
			
			return false;
			
		} else{
			
			return true;
			
		}
		
	}
	
	
	public boolean validarRegioes(int regiao1, int regiao2){
		
		if(regiao1 == regiao2){
			
			return false;
			
		} else{
			
			return true;
			
		}
		
	}

	
}


