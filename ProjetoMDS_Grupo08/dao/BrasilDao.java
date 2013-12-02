package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.ExceptionsBrasil;

import model.Brasil;

public class BrasilDao extends ConnectionFactory {

	private Connection conexao;
	public ExceptionsBrasil exception = new ExceptionsBrasil();

	public BrasilDao() {
	}

	public List<Brasil> buscaBrasilAbsoluto(int ano) throws SQLException {
		List<Brasil> brasil = new ArrayList<Brasil>();
		if (exception.verificaParamentroAno(ano) == true) {
			this.conexao = new ConnectionFactory().getConnection();
			String query = "select * from dldbrasilabsoluto where ano = ? ";
			java.sql.PreparedStatement stm = this.conexao
					.prepareStatement(query);
			stm.setInt(1, ano);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
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
			return brasil;
		}else
		return brasil;
	}

	public List<Brasil> buscaBrasilRelativo(int ano) throws SQLException {
		List<Brasil> brasil = new ArrayList<Brasil>();
		if (exception.verificaParamentroAno(ano) == true) {
			this.conexao = new ConnectionFactory().getConnection();
			String query = "select * from dldbrasilrelativo where ano = ? ";
			java.sql.PreparedStatement stm = this.conexao
					.prepareStatement(query);
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
			conexao.close();
			stm.close();
		}
		return brasil;
	}

	public List<Brasil> getDatas() throws SQLException {
		List<Brasil> datas = new ArrayList<Brasil>();
		this.conexao = new ConnectionFactory().getConnection();
		String query = "select distinct ano from dldbrasilabsoluto "
				+ "UNION select distinct ano from dldbrasilrelativo";
		java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			Brasil dt = new Brasil();
			dt.setAno(rs.getInt("ano"));
			datas.add(dt);
		}
		stm.close();
		conexao.close();
		return datas;
	}

	public List<Brasil> getDatasComparacao(int ano) throws SQLException {
		List<Brasil> datas = new ArrayList<Brasil>();
		if (exception.verificaParamentroAno(ano) == true) {
			this.conexao = new ConnectionFactory().getConnection();
			String query = "select distinct ano from dldbrasilabsoluto where ano !=? "
					+ "UNION select distinct ano from dldbrasilrelativo where ano !=?";
			java.sql.PreparedStatement stm = this.conexao
					.prepareStatement(query);
			stm.setInt(1, ano);
			stm.setInt(2, ano);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Brasil dt = new Brasil();
				dt.setAno(rs.getInt("ano"));
				datas.add(dt);
			}
			stm.close();
			conexao.close();
		}
		return datas;
	}
}
