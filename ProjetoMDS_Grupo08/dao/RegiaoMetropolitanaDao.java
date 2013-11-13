package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.RegiaoMetropolitana;

public class RegiaoMetropolitanaDao extends ConnectionFactory {


	// Variavel de conexao usada para todos os metodos da classe
	private Connection conexao;

	// Contrutor da classe
	public RegiaoMetropolitanaDao() {
	}

	// Metodo que busca todos os valores Absolutos de Brasil
	public List<RegiaoMetropolitana> buscaRegiaoMetropolitanaAbsolutoPorAno(int ano) throws SQLException {
		//Instancia que será de retorno
		List<RegiaoMetropolitana> regiaoMetropolitana = new ArrayList<RegiaoMetropolitana>();
		// Criando uma conexao com a Classe ConnectionFactory
		this.conexao = new ConnectionFactory().getConnection();
		//Comando query 
		String query = "select * from dldlregiaoabsoluto where ano = ? ";
		java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
		//Parametro de busca 
		stm.setInt(1, ano);
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			//Criando as classe para criação da lista
			RegiaoMetropolitana rm = new RegiaoMetropolitana();
			rm.setRegiao(rs.getString("regiao"));
			rm.setOpcao(rs.getString("opcao"));
			rm.setTipo("Absoluto");
			rm.setAno(rs.getInt("ano"));
			rm.setValor(rs.getInt("valor"));
			regiaoMetropolitana.add(rm);

		}
		stm.close();
		conexao.close();
		//retorno da lista
		return regiaoMetropolitana;
	}
	
	public List<RegiaoMetropolitana> buscaRegiaoMetropolitanaRelativoPorAno(int ano) throws SQLException {
		
		List<RegiaoMetropolitana> regiaoMetropolitana = new ArrayList<RegiaoMetropolitana>();
		// Criando uma conexao com a Classe ConnectionFactory
		this.conexao = new ConnectionFactory().getConnection();
		String query = "select * from dldregiaorelativo where ano = ? ";
		java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
		stm.setInt(1, ano);
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {

			RegiaoMetropolitana rm = new RegiaoMetropolitana();
			rm.setRegiao(rs.getString("regiao"));
			rm.setOpcao(rs.getString("opcao"));
			rm.setTipo("Relativo");
			rm.setAno(rs.getInt("ano"));
			rm.setValor(rs.getInt("valor"));
			regiaoMetropolitana.add(rm);

		}
		stm.close();
		return regiaoMetropolitana;
	}
	
public List<Integer>  getDatasRegiaoMetropolitana() throws SQLException{
	
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

public List<Integer>  getDatasComparaçãoRegiaoMetropolitana(int ano) throws SQLException{
	
	List<Integer> datasRM = new ArrayList<Integer>();
	this.conexao = new ConnectionFactory().getConnection();
	//Comando select faz uma busca e filtra as datas e exclui 
	//a data que ja foi pesquisada, as datas são comuns em ambas tabelas,
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

//Metodos que Falta exclusão por da mesma regiao Metropolitana na comparação por 
//Regiao Metropolitana diferente e Comparação por regioes metropolitanas diferentes
//Verificar como fazer e exibição das listas em conjunto e antes da busca usando a servlet


}

	
