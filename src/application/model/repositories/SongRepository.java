package application.model.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import application.config.DatabaseConfig;
import application.config.UserConfig;
import application.model.entities.Composer;
import application.model.entities.Song;

public class SongRepository {
	
	public static void add(Song song) {
		String sqlSong = "INSERT INTO songs (createdBy, titulo, ano, genero, duracao, compositor) VALUES (?,?,?,?,?,?)";
		String sqlComposer = "INSERT INTO composers (nome) VALUES (?)";
		String sqlComposerSeach = "SELECT * FROM composers WHERE nome = ?";
		
		int idComposer = 0;
		
		try {
			PreparedStatement pscS = DatabaseConfig.getConnect()
												.prepareStatement(sqlComposerSeach);
			pscS.setString(1, song.getCompositor().getName());
			
			ResultSet rscs = pscS.executeQuery();
			if(!rscs.next()) {	
				PreparedStatement pst = DatabaseConfig.getConnect()
													.prepareStatement(sqlComposer);
				
				pst.setString(1, song.getCompositor().getName());
				
				pst.executeUpdate();
				idComposer = DatabaseConfig.getConnect()
								.createStatement()
								.getGeneratedKeys()
								.getInt("last_insert_rowid()");
			} else {
				idComposer = rscs.getInt("id");
			}
				
			PreparedStatement pstS = DatabaseConfig.getConnect()
												.prepareStatement(sqlSong);
			pstS.setInt(1, UserConfig.getUser().getId());
			pstS.setString(2, song.getTitulo());
			pstS.setInt(3, song.getAno());
			pstS.setString(4, song.getGenero());
			pstS.setDouble(5, song.getDuracao());
			pstS.setInt(6, idComposer);
			
			pstS.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static List<Song> getAllSongs() {
		String sql = "SELECT t1.*, t2.nome FROM songs AS t1 JOIN composers AS t2 ON t1.compositor = t2.id WHERE createdBy = ?";
		List<Song> songs = new ArrayList<>();
		
		try {
			PreparedStatement st = DatabaseConfig.getConnect()
									.prepareStatement(sql);
			st.setInt(1, UserConfig.getUser().getId());
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				songs.add(new Song(
							rs.getInt("id"),
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
	
	public static void removeById(int id) {
		String sqlUser = "SELECT * FROM songs WHERE createdby = ? AND id = ?;";
		String sqlPlaylist = "DELETE FROM playlists_songs WHERE song_id = ?;";
		String sqlSong = "DELETE FROM songs WHERE id = ?;";
		
		try {
			
			PreparedStatement psU = DatabaseConfig.getConnect()
												.prepareStatement(sqlUser);
			psU.setInt(1, UserConfig.getUser().getId());
			psU.setInt(2, id);
			ResultSet rs = psU.executeQuery();
			
			if(rs.next()) {
				PreparedStatement psP = DatabaseConfig.getConnect()
													.prepareStatement(sqlPlaylist);
				psP.setInt(1, id);
				psP.executeUpdate();
				
				PreparedStatement psS = DatabaseConfig.getConnect()
													.prepareStatement(sqlSong);
				psS.setInt(1, id);
				psS.executeUpdate();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
