package br.com.dld.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.dld.model.RegiaoMetropolitana;


public class RegiaoMetropolitanaDao extends Dao{
	
	public RegiaoMetropolitanaDao(){
		
	}
	
	public List<RegiaoMetropolitana> buscaRegiaoMetropolitana(String regiao, int ano){
			
		List<RegiaoMetropolitana> regioesMetropolitana = new ArrayList<RegiaoMetropolitana>();
		
		try {
			Connection conexao = this.gerarConexao();
			String query = "select * from dldregiaoabsoluto where regiao = '"+ regiao +"' and ano = "+2006+" union select * from dldregiaorelativo where regiao = '"+ regiao +"' and ano = "+2006;

			Statement stm = (Statement) conexao.createStatement();
			ResultSet rs = (ResultSet) stm.executeQuery(query);

			
			//varrer toda a tabela e popular o bean
			while(rs.next()){
				
				RegiaoMetropolitana regiaoMetropolitana = new RegiaoMetropolitana();
				regiaoMetropolitana.setOpcao(rs.getString("opcao"));
				System.out.println("Opcao: " + regiaoMetropolitana.getOpcao());
				regiaoMetropolitana.setValor(rs.getInt("valor"));
				System.out.println("Valor: "+ regiaoMetropolitana.getValor());
				
				regioesMetropolitana.add(regiaoMetropolitana);	
			}
			
			stm.close();
			this.fecharConexao();


		} catch (SQLException sql) {
			sql.printStackTrace();
		}
		return regioesMetropolitana;
	}

}