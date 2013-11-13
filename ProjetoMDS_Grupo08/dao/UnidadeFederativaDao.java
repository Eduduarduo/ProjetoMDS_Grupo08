package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.UnidadeFederativa;

public class UnidadeFederativaDao {

	
	// Variavel de conexao usada para todos os metodos da classe
		private Connection conexao;

		// Contrutor da classe
		public UnidadeFederativaDao() {
		}

		// Metodo que busca todos os valores Absolutos de Brasil
		public List<UnidadeFederativa> buscaUnidadeFederativaAbsolutoPorAno(int ano) throws SQLException {
			//Instancia que será de retorno
			List<UnidadeFederativa> unidadeFederativa = new ArrayList<UnidadeFederativa>();
			// Criando uma conexao com a Classe ConnectionFactory
			this.conexao = new ConnectionFactory().getConnection();
			//Comando query 
			String query = "select * from dldlufoabsoluto where ano = ? ";
			java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
			//Parametro de busca 
			stm.setInt(1, ano);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				//Criando as classe para criação da lista
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
			//retorno da lista
			return unidadeFederativa;
		}
		
		public List<UnidadeFederativa> buscaUnidadeFederativaRelativoPorAno(int ano) throws SQLException {
			
			List<UnidadeFederativa> unidadeFederativa = new ArrayList<UnidadeFederativa>();
			// Criando uma conexao com a Classe ConnectionFactory
			this.conexao = new ConnectionFactory().getConnection();
			String query = "select * from dldufrelativo where ano = ? ";
			java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
			stm.setInt(1, ano);
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
		//Faz a distinção das datas que são comuns nas duas tabelas
		String query ="select distinct ano from dldufbsoluto " +
				"UNION select distinct ano from dldufrelativo";
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

	public List<Integer>  getDatasComparaçãoUnidadeFederativa(int ano) throws SQLException{
		
		List<Integer> datasUF = new ArrayList<Integer>();
		this.conexao = new ConnectionFactory().getConnection();
		//Comando select faz uma busca e filtra as datas e exclui 
		//a data que ja foi pesquisada, as datas são comuns em ambas tabelas,
		//filtra tbm os dados repetidos
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

	//Metodos que Falta exclusão por da mesma regiao Unidade federativa na comparação por 
	//unidade federativa diferente e Comparação por unidades federativas diferentes
	//Verificar como fazer e exibição das listas em conjunto e antes da busca usando a servlet
	
}
