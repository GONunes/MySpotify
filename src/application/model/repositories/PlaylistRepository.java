package application.model.repositories;

import java.sql.PreparedStatement;

import application.config.DatabaseConfig;
import application.config.UserConfig;
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
	
}
