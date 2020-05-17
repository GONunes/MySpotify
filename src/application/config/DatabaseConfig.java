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
			System.out.println("ERRO NA CONEXÃO COM O BANCO:");
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public static void started() {
		connect();
		
		String[] initialSqls = new String[5];
		initialSqls[0] = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50), created DATETIME); ";
		initialSqls[1] = "CREATE TABLE IF NOT EXISTS songs (id INTEGER PRIMARY KEY AUTOINCREMENT, createdBy integer, titulo VARCHAR(250), ano integer, genero VARCHAR(50), duracao DOUBLE, compositor INTEGER);"; 
		initialSqls[2] = "CREATE TABLE IF NOT EXISTS composers (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(250));"; 
		initialSqls[3] = "CREATE TABLE IF NOT EXISTS playlists (id INTEGER PRIMARY KEY AUTOINCREMENT, createdBy integer, nome VARCHAR(250));";
		initialSqls[4] = "CREATE TABLE IF NOT EXISTS playlists_songs (id INTEGER PRIMARY KEY AUTOINCREMENT, playlist_id INTEGER, song_id INTEGER);";
		
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
