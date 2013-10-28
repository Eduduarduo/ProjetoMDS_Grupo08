package br.com.dld.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.dld.model.Brasil;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class BrasilDao extends Dao{

	public BrasilDao() {
	}

	public List<Brasil> buscaBrasil(int ano){

		List<Brasil> brasil = new ArrayList<Brasil>();
		
		try {
			Connection conexao = this.gerarConexao();
			String query = "select * from Brasil where ano=" + ano;

			Statement stm = (Statement) conexao.createStatement();
			ResultSet rs = (ResultSet) stm.executeQuery(query);
			
			//varrer toda a tabela e popular o bean
			while(rs.next()){
				
				Brasil br = new Brasil();
				br.setOpcao(rs.getString("opcao"));
				br.setValor(rs.getInt("valor"));
				br.setTipo(rs.getString("tipo"));
				br.setId(rs.getInt("id"));
				
				brasil.add(br);	
			}
			
			stm.close();
			this.fecharConexao(); //fica aki mesmo ou no finally

		} catch (SQLException  sql) {
			sql.printStackTrace();
		}
		return brasil;
	}
}
