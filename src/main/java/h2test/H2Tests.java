package h2test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.tools.Server;

public class H2Tests {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		connection.createStatement().execute("drop table if exists person");
		connection.createStatement().execute("create table person(nachname varchar(100))");
		connection.createStatement().execute("insert into person(nachname) values('Trutz')");
		Server.startWebServer(connection);
		connection.close();
	}

}
