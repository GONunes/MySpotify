package application.model.repositories;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import application.config.DatabaseConfig;
import application.model.entities.Composer;
import application.model.entities.Song;

public class ComposerRepository {
	public static List<Composer> getAll() {
		
		List<Composer> composers = new ArrayList<>();
		List<Song> songs = SongRepository.getAllSongs();
		
		String sql = "SELECT * FROM composers";
		
		try {
			
			ResultSet rs = DatabaseConfig.getConnect().createStatement().executeQuery(sql);
			
			while (rs.next()) {
				Composer composer = new Composer();
				int composerId = rs.getInt("id");
				
				composer.setName(rs.getString("nome"));
				composer.setMusicas(
							songs.stream()
								.filter(s -> s.getCompositor().getId() == composerId)
								.collect(Collectors.toList())
						);
				
				composers.add(composer);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return composers;
	}
}
