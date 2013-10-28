package dao;

import java.sql.Connection;


public interface Conexao {
	public Connection gerarConexao();
	public void fecharConexao();
}
