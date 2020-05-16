package application.model.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import application.config.DatabaseConfig;
import application.model.entities.Composer;
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
	
	public static List<Song> getAllSongs() {
		String sql = "SELECT t1.*, t2.nome FROM songs AS t1 JOIN composers AS t2 ON t1.compositor = t2.id";
		List<Song> songs = new ArrayList<>();
		
		try {
			ResultSet rs = DatabaseConfig.getConnect()
									.createStatement()
									.executeQuery(sql);
			
			while(rs.next()) {
				songs.add(new Song(
							rs.getString("titulo"),
							rs.getInt("ano"),
							rs.getString("genero"),
							rs.getDouble("duracao"),
							new Composer(rs.getString("nome"))
						));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(songs.size() > 0)
			return songs;
		else
			return null;
	}
	
}
