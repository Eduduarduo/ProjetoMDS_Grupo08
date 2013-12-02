package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import exception.ExceptionsUF;

import model.UnidadeFederativa;

public class UnidadeFederativaDao {

	public Connection conexao;
	public ExceptionsUF exception = new ExceptionsUF();

	public UnidadeFederativaDao() {
	}

	public List<UnidadeFederativa> buscaUnidadeFederativaAbsoluto(int ano,
			String ufParametro) throws SQLException {
		this.conexao = new ConnectionFactory().getConnection();

		List<UnidadeFederativa> unidadeFederativaList = new ArrayList<UnidadeFederativa>();

		if (exception.verificaParamentroUF(ufParametro) == true) {
		
				String query = "select * from dldufabsoluto where ano =? and regiao =? ";
				java.sql.PreparedStatement stm = this.conexao
						.prepareStatement(query);
				stm.setInt(1, ano);
				stm.setString(2, ufParametro);
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					UnidadeFederativa uf = new UnidadeFederativa();
					uf.setRegiao(rs.getString("regiao"));
					uf.setOpcao(rs.getString("opcao"));
					uf.setTipo(" Absoluto");
					uf.setAno(rs.getInt("ano"));
					uf.setValor(rs.getInt("valor"));
					unidadeFederativaList.add(uf);
				}
				stm.close();
				conexao.close();
				return unidadeFederativaList;
			} else {
				return unidadeFederativaList;
			}
		
	}

	public List<UnidadeFederativa> buscaUnidadeFederativaRelativo(int ano,
			String ufParametro) throws SQLException {

		List<UnidadeFederativa> unidadeFederativaList = new ArrayList<UnidadeFederativa>();
		if (exception.verificaParamentroUF(ufParametro) == true) {
				this.conexao = new ConnectionFactory().getConnection();
				String query = "select * from dldufrelativo where ano = ? and regiao = ? ";
				java.sql.PreparedStatement stm = this.conexao
						.prepareStatement(query);
				stm.setInt(1, ano);
				stm.setString(2, ufParametro);
				ResultSet rs = stm.executeQuery();
				while (rs.next()) {
					UnidadeFederativa uf = new UnidadeFederativa();
					uf.setRegiao(rs.getString("regiao"));
					uf.setOpcao(rs.getString("opcao"));
					uf.setTipo("Relativo");
					uf.setAno(rs.getInt("ano"));
					uf.setValor(rs.getInt("valor"));
					unidadeFederativaList.add(uf);
				}
				stm.close();
				conexao.close();
				return unidadeFederativaList;
			}else return unidadeFederativaList;
		}

	public List<UnidadeFederativa> getAnosUnidadeFederativa()
			throws SQLException {

		List<UnidadeFederativa> datasUF = new ArrayList<UnidadeFederativa>();
		this.conexao = new ConnectionFactory().getConnection();
		String query = "select distinct ano from dldufabsoluto UNION select  distinct ano from dldufrelativo";
		java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			UnidadeFederativa dataUF = new UnidadeFederativa();
			dataUF.setAno(rs.getInt("ano"));
			datasUF.add(dataUF);
		}
		stm.close();
		conexao.close();
		return datasUF;
	}

	public List<UnidadeFederativa> getUnidadeFederativa() throws SQLException {

		List<UnidadeFederativa> datasUF = new ArrayList<UnidadeFederativa>();
		this.conexao = new ConnectionFactory().getConnection();
		String query = "select distinct regiao from dldufabsoluto UNION "
				+ "select distinct regiao from dldufrelativo order by regiao";
		java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			UnidadeFederativa dataUF = new UnidadeFederativa();
			dataUF.setRegiao(rs.getString("regiao"));
			datasUF.add(dataUF);
		}
		stm.close();
		conexao.close();
		return datasUF;
	}

	public List<UnidadeFederativa> getAnosComparacaoUnidadeFederativa(int ano)
			throws SQLException {
		List<UnidadeFederativa> anosUF = new ArrayList<UnidadeFederativa>();

			this.conexao = new ConnectionFactory().getConnection();
			String query = "select  ano from dldufabsoluto where ano != ? UNION select  ano from dldufrelativo where ano != ? ";
			java.sql.PreparedStatement stm = this.conexao.prepareStatement(query);
			stm.setInt(1,ano);
			stm.setInt(2,ano);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				UnidadeFederativa dtUF = new UnidadeFederativa();
				dtUF.setAno(rs.getInt("ano"));
				anosUF.add(dtUF);
			}
			stm.close();
			conexao.close();
			return anosUF;
	}

	public List<UnidadeFederativa> getUFComparacao(String regiao) throws SQLException {

		List<UnidadeFederativa> datasUF = new ArrayList<UnidadeFederativa>();
		if ((exception.verificaParamentroUF(regiao)) == true) {
			conexao = new ConnectionFactory().getConnection();
			String query = "select distinct regiao from dldufabsoluto where regiao !=? UNION select distinct ano from dldufrelativo where regiao != ? ;";
			java.sql.PreparedStatement stm = conexao.prepareStatement(query);
			stm.setString(1,regiao);
			stm.setString(2,regiao);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				UnidadeFederativa dtUF = new UnidadeFederativa();
				dtUF.setRegiao(rs.getString("regiao"));
				datasUF.add(dtUF);
			}
			stm.close();
			conexao.close();
		}
		return datasUF;
	}
}
