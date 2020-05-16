package application.model.repositories;

import java.sql.PreparedStatement;

import application.config.DatabaseConfig;
import application.model.entities.Song;

public class SongRepository {
	
	public static void add(Song song) {
		String sqlSong = "INSERT INTO songs (titulo, ano, genero, duracao, compositor) VALUES (?,?,?,?,?)";
		String sqlComposer = "INSERT INTO composers (nome) VALUES (?)";
		int idComposer = 0;
		
		try {
			PreparedStatement pst = DatabaseConfig.getConnect()
												.prepareStatement(sqlComposer);
			
			pst.setString(1, song.getCompositor().getName());
			
			pst.executeUpdate();
			idComposer = DatabaseConfig.getConnect()
							.createStatement()
							.getGeneratedKeys()
							.getInt("last_insert_rowid()");
			
			PreparedStatement pstS = DatabaseConfig.getConnect()
												.prepareStatement(sqlSong);
			pstS.setString(1, song.getTitulo());
			pstS.setInt(2, song.getAno());
			pstS.setString(3, song.getGenero());
			pstS.setDouble(4, song.getDuracao());
			pstS.setInt(5, idComposer);
			
			pstS.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
