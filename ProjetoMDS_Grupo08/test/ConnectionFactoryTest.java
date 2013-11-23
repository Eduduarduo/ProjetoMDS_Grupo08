package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import dao.ConnectionFactory;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Statement;

public class ConnectionFactoryTest {

	ConnectionFactory connection;
   
	@Before
    public void setUp() throws Exception {
            connection = new ConnectionFactory();
    }

    //Testando a instância
    @Test
    public void test() {
            assertNotNull(connection);
    } 
    
    @Test
    public void test1() {            
           assertNotNull(connection.getConnection());
    }
    
}
