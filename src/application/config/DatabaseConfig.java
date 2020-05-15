package application.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {
	private static Connection conn = null;
	
	private static String DRIVER = "jdbc:sqlite";
	private static String NAME = "test";
	
	public static void connect() {
		try {
			conn = DriverManager
					.getConnection(DRIVER + ":" + NAME + ".db");			
		} catch (Exception e) {
			System.out.println("ERRO NA CONEXÃO COM O BANCO:");
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public static Connection getConnect() {
		return conn;
	}
}
