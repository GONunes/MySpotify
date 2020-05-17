package application.model.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import application.config.DatabaseConfig;
import application.config.UserConfig;
import application.model.entities.Composer;
import application.model.entities.Playlist;
import application.model.entities.Song;

public class PlaylistRepository {
	
	public static void add(Playlist playlist) {
		String sqlPlaylist = "INSERT INTO playlists (createdBy, nome) VALUES (?,?) ";
		String sqlPlaylistSong = "INSERT INTO playlists_songs (playlist_id, song_id) VALUES (?,?)";
		int idPlaylist = 0;
		
		try {
			PreparedStatement psp = DatabaseConfig.getConnect()
												.prepareStatement(sqlPlaylist);
			psp.setInt(1, UserConfig.getUser().getId());
			psp.setString(2, playlist.getNome());
			
			psp.executeUpdate();
			idPlaylist = DatabaseConfig.getConnect()
							.createStatement()
							.getGeneratedKeys()
							.getInt("last_insert_rowid()");
			
			for (Song song : playlist.getSongs()) {
				PreparedStatement pss = DatabaseConfig.getConnect()
												.prepareStatement(sqlPlaylistSong);

				pss.setInt(1, idPlaylist);
				pss.setInt(2, song.getId());
				
				pss.executeUpdate();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static List<Playlist> getAllPlaylists() {
		List<Playlist> playlists = new ArrayList<>();
		List<Song> songs = new ArrayList<>();
		int idPlaylist = 0;
		
		String sql = "SELECT * FROM playlists WHERE createdBy = ?";
		String sqlSongs = "SELECT t2.*, t3.nome FROM playlists_songs AS t1 JOIN songs AS t2 ON t1.song_id = t2.id JOIN composers AS t3 ON t2.compositor = t3.id WHERE playlist_id = ?;;";
		
		try(PreparedStatement ps = DatabaseConfig.getConnect().prepareStatement(sql)) {
			
			ps.setInt(1, UserConfig.getUser().getId());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				idPlaylist = rs.getInt("id");
				
				PreparedStatement pss = DatabaseConfig.getConnect().prepareStatement(sqlSongs);
				pss.setInt(1, idPlaylist);
				
				ResultSet rss = pss.executeQuery();
				songs = new ArrayList<>();
				
				while(rss.next()) {
					songs.add(new Song(
								rss.getInt("id"),
								rss.getString("titulo"),
								rss.getInt("ano"),
								rss.getString("genero"),
								rss.getDouble("duracao"),
								new Composer(rss.getString("nome"))
							));
				}
				
				playlists.add(new Playlist(
								idPlaylist,
								rs.getString("nome"),
								songs
						));
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(playlists.size() > 0)
			return playlists;
		else
			return null;
	}
	
}
