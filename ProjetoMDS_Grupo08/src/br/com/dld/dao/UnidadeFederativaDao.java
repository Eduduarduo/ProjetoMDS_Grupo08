package br.com.dld.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

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
				
				UnidadeFederativa uf = new UnidadeFederativa();
				uf.setID(rs.getInt("id"));
				uf.setOpcao(rs.getString("opcao"));
				uf.setValor(rs.getInt("valor"));
				uf.setTipo(rs.getString("tipo"));
				
				ufs.add(uf);	
			}
			
			stm.close();
			this.fecharConexao();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ufs;
	}

}
