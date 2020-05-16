package application.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConfig {
	private static Connection conn = null;
	
	private static String DRIVER = "jdbc:sqlite";
	private static String NAME = "objects";
	
	private static void connect() {
		try {
			conn = DriverManager
					.getConnection(DRIVER + ":" + NAME + ".db");			
		} catch (Exception e) {
			System.out.println("ERRO NA CONEXÃƒO COM O BANCO:");
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public static void started() {
		connect();
		
		String[] initialSqls = new String[1];
		initialSqls[0] = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50), created DATETIME); ";
		
		try {
			for(String sql : initialSqls) {
				getConnect().createStatement().execute(sql);							
			}
		} catch (Exception e) {
			System.out.println("Problemas na criação da base de dados");
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public static Connection getConnect() {
		return conn;
	}
}
