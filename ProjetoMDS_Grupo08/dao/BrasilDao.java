package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import model.Brasil;

public class BrasilDao extends Dao{

	public BrasilDao() {
	}

	public List<Brasil> buscaBrasil(int ano){

		List<Brasil> brasil = new ArrayList<Brasil>();
		
		try {
			Connection conexao = this.gerarConexao();
			String query = "select * from dldbrasilabsoluto where ano =" +1981+" union select * from dldbrasilrelativo where ano = "+1981;

			Statement stm = (Statement) conexao.createStatement();
			ResultSet rs = (ResultSet) stm.executeQuery(query);
			
			//varrer toda a tabela e popular o bean
			while(rs.next()){
				
				Brasil br = new Brasil();
				br.setOpcao(rs.getString("opcao"));
				System.out.println("Opcao: " + br.getOpcao());
				br.setValor(rs.getInt("valor"));
				System.out.println("Valor: "+ br.getValor());

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
