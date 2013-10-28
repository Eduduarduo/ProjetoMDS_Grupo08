package br.com.dld.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.dld.model.UnidadeFederativa;



public class UnidadeFederativaDao extends Dao{
	
	public UnidadeFederativaDao(){
		
	}
	
	public List<UnidadeFederativa> buscaUF(String uf, int ano){
		
		List<UnidadeFederativa> ufs = new ArrayList<UnidadeFederativa>();
		
		try {
			Connection conexao = this.gerarConexao();
			String query = "select * from UnidadeFederativa where ano=" + ano + "and uf=" + uf;

			Statement stm = (Statement) conexao.createStatement();
			ResultSet rs = (ResultSet) stm.executeQuery(query);

			
			//varrer toda a tabela e popular o bean
			while(rs.next()){
				
				UnidadeFederativa unidadeFederativa = new UnidadeFederativa();
				unidadeFederativa.setId(rs.getInt("id"));
				unidadeFederativa.setOpcao(rs.getString("opcao"));
				unidadeFederativa.setValor(rs.getInt("valor"));
				unidadeFederativa.setTipo(rs.getString("tipo"));
				
				ufs.add(unidadeFederativa);	
			}
			
			stm.close();
			this.fecharConexao();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ufs;
	}

}
