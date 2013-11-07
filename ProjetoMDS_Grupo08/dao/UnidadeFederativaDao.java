package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.UnidadeFederativa;



public class UnidadeFederativaDao extends Dao{
	
	public UnidadeFederativaDao(){
		
	}
	
	public List<UnidadeFederativa> buscaUF(String uf, int ano){
		
		List<UnidadeFederativa> ufs = new ArrayList<UnidadeFederativa>();
		
		try {
			Connection conexao = this.gerarConexao();
			String query = "select * from dldufabsoluto where regiao = '" + uf + "'and ano ="+ 2006
					+" union select * from dldufrelativo where regiao = '"+ uf +"' and ano ="+ 2006;

			Statement stm = (Statement) conexao.createStatement();
			ResultSet rs = (ResultSet) stm.executeQuery(query);

			
			//varrer toda a tabela e popular o bean
			while(rs.next()){
				
				UnidadeFederativa unidadeFederativa = new UnidadeFederativa();
				unidadeFederativa.setOpcao(rs.getString("opcao"));
				System.out.println("Opcao: " + unidadeFederativa.getOpcao());
				unidadeFederativa.setValor(rs.getInt("valor"));
				System.out.println("Valor: " + unidadeFederativa.getValor());
				
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
