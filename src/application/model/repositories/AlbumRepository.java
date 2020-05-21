package application.model.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import application.config.DatabaseConfig;
import application.model.entities.Album;
import application.model.entities.Composer;
import application.model.entities.Song;

public class AlbumRepository {

	public List<Album> getAll () {
		List<Album> albums = new ArrayList<>();
		String sqlA = "SELECT t1.id, t1.titulo, t2.nome AS 'compositor' FROM albums AS t1 JOIN composers AS t2 ON t1.compositor = t2.id;";
		String sqlS = "SELECT * FROM songs WHERE album = ?;";
		
		try {
			ResultSet rsA = DatabaseConfig.getConnect()
								.createStatement()
								.executeQuery(sqlA);
			
			while(rsA.next()) {
				List<Song> songs = new ArrayList<>();
				Album album = new Album(rsA.getString("titulo"), new Composer(rsA.getString("compositor")));
				
				PreparedStatement ps = DatabaseConfig.getConnect().prepareStatement(sqlS);
				ps.setInt(1, rsA.getInt("id"));

				ResultSet rsS = ps.executeQuery();
				
				while(rsS.next()) {
					Song s = new Song();
					
					s.setTitulo(rsS.getString("titulo"));
					s.setDuracao(rsS.getDouble("duracao"));
					s.setGenero(rsS.getString("genero"));
					
					songs.add(s);
				}
				
				album.setSongs(songs);
				albums.add(album);

			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return albums;
	}
	
}
