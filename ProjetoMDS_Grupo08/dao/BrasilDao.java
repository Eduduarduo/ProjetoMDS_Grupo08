package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Brasil;

public class BrasilDao extends ConnectionFactory {

	// Variavel de conexao usada para todos os metodos da classe
	private Connection conexao;

	// Contrutor da classe
	public BrasilDao() {
	}

	// Metodo que busca todos os valores Absolutos de Brasil
	public List<Brasil> buscaBrasilAbsoluto(int ano) throws SQLException {
		//Instancia que será de retorno
		List<Brasil> brasil = new ArrayList<Brasil>();
		// Criando uma conexao com a Classe ConnectionFactory
		this.conexao = new ConnectionFactory().getConnection();
		//Comando query 
		String query = "select * from dldbrasilabsoluto where ano = ? ";
		java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
		//Parametro de busca 
		stm.setInt(1, ano);
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			//Criando as classe para criação da lista
			Brasil br = new Brasil();
			br.setRegiao(rs.getString("regiao"));
			br.setOpcao(rs.getString("opcao"));
			br.setTipo("Absoluto");
			br.setAno(rs.getInt("ano"));
			br.setValor(rs.getInt("valor"));
			brasil.add(br);

		}
		stm.close();
		conexao.close();
		//retorno da lista
		return brasil;
	}
	
	public List<Brasil> buscaBrasilRelativo(int ano) throws SQLException {
		
		List<Brasil> brasil = new ArrayList<Brasil>();
		// Criando uma conexao com a Classe ConnectionFactory
		this.conexao = new ConnectionFactory().getConnection();
		String query = "select * from dldbrasilrelativo where ano = ? ";
		java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
		stm.setInt(1, ano);
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {

			Brasil br = new Brasil();
			br.setRegiao(rs.getString("regiao"));
			br.setOpcao(rs.getString("opcao"));
			br.setTipo("Relativo");
			br.setAno(rs.getInt("ano"));
			br.setValor(rs.getInt("valor"));
			brasil.add(br);

		}
		stm.close();
		return brasil;
	}
	
public List<Integer>  getDatas() throws SQLException{
	
	List<Integer> datas = new ArrayList<Integer>();
	this.conexao = new ConnectionFactory().getConnection();
	//
	String query ="select distinct ano from dldbrasilabsoluto " +
			"UNION select distinct ano from dldbrasilrelativo";
	java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
	ResultSet rs = stm.executeQuery();

	while (rs.next()) {
		int dt;
		dt = rs.getInt("ano");

		datas.add(dt);
	}
	stm.close();
	conexao.close();
	return datas;
	
}	

public List<Integer>  getDatasComparação(int ano) throws SQLException{
	
	List<Integer> datas = new ArrayList<Integer>();
	this.conexao = new ConnectionFactory().getConnection();
	//Comando select faz uma busca e filtra as datas e exclui 
	//a data que ja foi pesquisada, as datas são comuns em ambas tabelas,
	//filtra tbm os dados repetidos
	String query ="select distinct ano from dldbrasilabsoluto where ano !=? " +
			"UNION select distinct ano from dldbrasilrelativo where ano !=?";
	java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
	stm.setInt(1,ano);
	stm.setInt(2,ano);
	
	ResultSet rs = stm.executeQuery();

	while (rs.next()) {
		int dt;
		dt = rs.getInt("ano");

		datas.add(dt);
	}
	stm.close();
	conexao.close();
	return datas;
	
}	




}
