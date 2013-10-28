package br.com.dld.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dld.model.RegiaoMetropolitana;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class RegiaoMetropolitanaDao extends Dao{
	
	public RegiaoMetropolitanaDao(){
		
	}
	
	public List<RegiaoMetropolitana> buscaRegiaoMetropolitana(String regiao, int ano){
			
		List<RegiaoMetropolitana> regioesMetropolitana = new ArrayList<RegiaoMetropolitana>();
		
		try {
			Connection conexao = this.gerarConexao();
			String query = "select * from RegiaoMetropolitana where ano=" + ano + "and regiao=" + regiao;

			Statement stm = (Statement) conexao.createStatement();
			ResultSet rs = (ResultSet) stm.executeQuery(query);

			
			//varrer toda a tabela e popular o bean
			while(rs.next()){
				
				RegiaoMetropolitana regiaoMetropolitana = new RegiaoMetropolitana();
				regiaoMetropolitana.setId(rs.getInt("id"));
				regiaoMetropolitana.setOpcao(rs.getString("opcao"));
				regiaoMetropolitana.setValor(rs.getInt("valor"));
				regiaoMetropolitana.setTipo(rs.getString("tipo"));
				
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