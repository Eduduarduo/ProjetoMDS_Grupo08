package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.UnidadeFederativa;

public class UnidadeFederativaDao {

	private Connection conexao;

		public UnidadeFederativaDao() {
		}
	
	public List<UnidadeFederativa> buscaUnidadeFederativaAbsoluto(int ano,String UF) throws SQLException {
	
			List<UnidadeFederativa> unidadeFederativa = new ArrayList<UnidadeFederativa>();
			this.conexao = new ConnectionFactory().getConnection();
			String query = "select * from dldlufoabsoluto where ano = ? and regiao = ? ";
			java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
			stm.setInt(1, ano);
			stm.setString(2,UF);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
			
				UnidadeFederativa uf = new UnidadeFederativa();
				uf.setRegiao(rs.getString("regiao"));
				uf.setOpcao(rs.getString("opcao"));
				uf.setTipo("Absoluto");
				uf.setAno(rs.getInt("ano"));
				uf.setValor(rs.getInt("valor"));
				unidadeFederativa.add(uf);

			}
			stm.close();
			conexao.close();
			return unidadeFederativa;
		}
		
	public List<UnidadeFederativa> buscaUnidadeFederativaRelativo(int ano,String UF) throws SQLException {
			
			List<UnidadeFederativa> unidadeFederativa = new ArrayList<UnidadeFederativa>();
			this.conexao = new ConnectionFactory().getConnection();
			String query = "select * from dldufrelativo where ano = ? and regiao = ? ";
			java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
			stm.setInt(1, ano);
			stm.setString(2,UF);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {

				UnidadeFederativa uf = new UnidadeFederativa();
				uf.setRegiao(rs.getString("regiao"));
				uf.setOpcao(rs.getString("opcao"));
				uf.setTipo("Relativo");
				uf.setAno(rs.getInt("ano"));
				uf.setValor(rs.getInt("valor"));
				unidadeFederativa.add(uf);

			}
			stm.close();
			conexao.close();
			return unidadeFederativa;
		}
		
	public List<Integer>  getDatasUnidadeFederativa() throws SQLException{
		
		List<Integer> datasUF = new ArrayList<Integer>();
		this.conexao = new ConnectionFactory().getConnection();
		String query ="select distinct ano from dldufbsoluto UNION select distinct ano from dldufrelativo";
		java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			int dataUF;
			dataUF = rs.getInt("ano");

			datasUF.add(dataUF);
		}
		stm.close();
		conexao.close();
		return datasUF;
		
	}	
	 
	public List<String>  getUnidadeFederativa() throws SQLException{
		
		List<String> datasUF = new ArrayList<String>();
		this.conexao = new ConnectionFactory().getConnection();
		String query ="select distinct regiao from dldufbsoluto UNION select distinct regiao from dldufrelativo";
		java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			String dataUF;
			dataUF = rs.getString("regiao");

			datasUF.add(dataUF);
		}
		stm.close();
		conexao.close();
		return datasUF;
		
	}	

	
	
	
	public List<Integer>  getDatasComparacaoUnidadeFederativa(int ano) throws SQLException{
		
		List<Integer> datasUF = new ArrayList<Integer>();
		this.conexao = new ConnectionFactory().getConnection();
		String query ="select distinct ano from dldufabsoluto where ano !=? " +
				"UNION select distinct ano from dldufrelativo where ano !=?";
		java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
		stm.setInt(1,ano);
		stm.setInt(2,ano);
		
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			int dtUF;
			dtUF = rs.getInt("ano");

			datasUF.add(dtUF);
		}
		stm.close();
		conexao.close();
		return datasUF;
		
	}	

public List<String>  getUFComparacao(String regiao) throws SQLException{
		
		List<String> datasUF = new ArrayList<String>();
		this.conexao = new ConnectionFactory().getConnection();
		String query ="select distinct ano from dldufabsoluto where regiao !=? " +
				"UNION select distinct ano from dldufrelativo where regiao !=?";
		java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
		stm.setString(1,regiao);
		stm.setString(2,regiao);
		
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			String dtUF;
			dtUF = rs.getString("regiao");

			datasUF.add(dtUF);
		}
		stm.close();
		conexao.close();
		return datasUF;
		
	}	

	
	
	
}
