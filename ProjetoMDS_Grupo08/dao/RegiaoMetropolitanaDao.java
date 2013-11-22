package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RegiaoMetropolitana;

public class RegiaoMetropolitanaDao extends ConnectionFactory {

	private Connection conexao;

	public RegiaoMetropolitanaDao() {
	}

	public List<RegiaoMetropolitana> buscaRegiaoMetropolitanaAbsoluto(String regiao,int ano) throws SQLException {

		List<RegiaoMetropolitana> regioes = new ArrayList<RegiaoMetropolitana>();
		this.conexao = new ConnectionFactory().getConnection();
		
		String query = "select * from dldregiaoabsoluto where ano = ? and regiao = ?";
		PreparedStatement stm = this.conexao.prepareStatement(query);
		stm.setInt(1,ano);
		stm.setString(2, regiao);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			
			RegiaoMetropolitana rm = new RegiaoMetropolitana();
			rm.setRegiao(rs.getString("regiao"));
			rm.setOpcao(rs.getString("opcao"));
			rm.setTipo("Absoluto");
			rm.setAno(ano);
			rm.setValor(rs.getInt("valor"));
			regioes.add(rm);
		}
		
		stm.close();
		conexao.close();

		return regioes;
	}

	public List<RegiaoMetropolitana> buscaRegiaoMetropolitanaRelativo(String regiao,int ano) throws SQLException {

		List<RegiaoMetropolitana> regioes = new ArrayList<RegiaoMetropolitana>();
		this.conexao = new ConnectionFactory().getConnection();
		
		String query = "select * from dldregiaorelativo where ano = ? and regiao = ?";
		PreparedStatement stm = this.conexao.prepareStatement(query);
		stm.setInt(1,ano);
		stm.setString(2, regiao);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()){
			
			RegiaoMetropolitana rm = new RegiaoMetropolitana();
			rm.setRegiao(rs.getString("regiao"));
			rm.setOpcao(rs.getString("opcao"));
			rm.setTipo("Relativo");
			rm.setAno(ano);
			rm.setValor(rs.getInt("valor"));
			regioes.add(rm);
		}
		
		stm.close();
		conexao.close();

		return regioes;
	}
	public List<Integer>  getAnosRegiaoMetropolitana() throws SQLException{
		
		List<Integer> datasRM = new ArrayList<Integer>();
		this.conexao = new ConnectionFactory().getConnection();
		
		//Faz a distinção das datas que são comuns nas duas tabelas
		String query ="select distinct ano from dldregiaoabsoluto " +
				"UNION select distinct ano from dldregiaorelativo";
		java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			int dataRM;
			dataRM = rs.getInt("ano");

			datasRM.add(dataRM);
		}
		stm.close();
		conexao.close();
		return datasRM;
		
	}	

	public List<Integer>  getAnosComparacaoRegiaoMetropolitana(int ano) throws SQLException{
		
		List<Integer> datasRM = new ArrayList<Integer>();
		this.conexao = new ConnectionFactory().getConnection();
		//faz uma busca e filtra as datas e exclui a data que ja foi pesquisada, as datas são comuns em ambas tabelas,
		//filtra tbm os dados repetidos
		String query ="select distinct ano from dldregiaoabsoluto where ano !=? " +
				"UNION select distinct ano from dldregiaorelativo where ano !=?";
		java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
		stm.setInt(1,ano);
		stm.setInt(2,ano);
		
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			int dtRM;
			dtRM = rs.getInt("ano");

			datasRM.add(dtRM);
		}
		stm.close();
		conexao.close();
		return datasRM;
		
	}	

	public List<String> getRegioesRegiaoMetropolitana() throws SQLException{
			
			List<String> regioes = new ArrayList<String>();
			
			this.conexao = new ConnectionFactory().getConnection();
			
			String query ="select distinct regiao from dldregiaoabsoluto " +
					"UNION select distinct regiao from dldregiaorelativo";
			
			java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				String  regiaoRM;
				regiaoRM = rs.getString("regiao");
				regioes.add(regiaoRM);
			}
			stm.close();
			conexao.close();
			return regioes;
			
		}
		
	public List<String> getRegioesComparacaoRegiaoMetropolitana(String regiao) throws SQLException{
			
			List<String> regioes = new ArrayList<String>();
			
			this.conexao = new ConnectionFactory().getConnection();
			
			String query ="select distinct regiao from dldregiaoabsoluto where regiao != ?" +
					"UNION select distinct regiao from dldregiaorelativo where regiao != ?";
			
			java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
			stm.setString(1, regiao);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				String  regiaoComparacaoRM;
				regiaoComparacaoRM = rs.getString("regiao");
				regioes.add(regiaoComparacaoRM);
			}
			stm.close();
			conexao.close();
			return regioes;
			
		}	
		
	//Verificar como fazer e exibição das listas em conjunto e antes da busca usando a servlet


}