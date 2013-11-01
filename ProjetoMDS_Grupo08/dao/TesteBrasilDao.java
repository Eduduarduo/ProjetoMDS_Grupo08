package br.com.dld.dao;

public class TesteBrasilDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("---------------- Dados referente ao Brasil ---------------------------");
		BrasilDao brasil = new BrasilDao();
		brasil.buscaBrasil(1981);
		
		System.out.println("------------------Dados referente as UFS -----------------------");
		
		UnidadeFederativaDao uf = new UnidadeFederativaDao();
		uf.buscaUF("Rondonia", 2009);
		
		System.out.println("-----------------Dados referentes as regioes metropolitanas--------------------------");
		
		RegiaoMetropolitanaDao rm = new RegiaoMetropolitanaDao();
		rm.buscaRegiaoMetropolitana("Fortaleza - CE", 2009);

	}

}
