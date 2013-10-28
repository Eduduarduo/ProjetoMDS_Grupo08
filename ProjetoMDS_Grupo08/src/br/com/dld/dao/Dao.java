package dao;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	public class Dao implements Conexao{

		protected static final String SQL_DRIVER = "com.mysql.jdbc.Driver";
		protected static final String SQL_URL = "jdbc:mysql://127.0.0.1/dld3";
		protected static final String SQL_USER = "root";
		protected static final String SQL_PASS = "root";
		protected Connection conn = null;
		

		public Dao() {
			
		}

		
		//refatorar isso aki
		@Override
		public Connection gerarConexao(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASS);
				
			} catch (SQLException e) {
				e.printStackTrace();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return conn;
		}

		@Override
		public void fecharConexao(){
			try {
				conn.close();
			} catch (SQLException  sql) {
				sql.printStackTrace();

			}
			
		}

}
