package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import dao.ConnectionFactory;

public class ConnectionFactoryTest {

	ConnectionFactory conexao ;
	@Test
	public void testGetConnection() {
		conexao = new ConnectionFactory();
		assertNotNull(conexao);

	}
	@Test
	public void testGetConnectionContrutor() {
		assertNotNull(new ConnectionFactory());

	}

	@Test
	public void testGetConnectionEquals() {
		assertNotSame(new ConnectionFactory(), conexao);
	}
	@Test
	public void testGetConnectionNotNull() throws SQLException {
		conexao = mock(ConnectionFactory.class);
		doCallRealMethod().when(conexao).getConnection();
		assertNotNull(conexao);
	}
	@Test
	public void testGetConnectionConnection() throws SQLException {
		conexao = mock(ConnectionFactory.class);
		when(conexao.getConnection()).thenReturn(DriverManager.getConnection("jdbc:mysql://localhost/dld3","root","root"));
		assertNotNull(conexao);
	}
	
	
	
	
	
}
