package application.model.repositories;

import java.sql.PreparedStatement;
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
		
		String sql 	= "SELECT * FROM composers";
		String sqlS = "SELECT * FROM songs WHERE compositor = ?";
		
		try {
			
			ResultSet rs = DatabaseConfig.getConnect().createStatement().executeQuery(sql);
			
			while (rs.next()) {
				List<Song> songs = new ArrayList<>();
				
				Composer composer = new Composer();
				composer.setName(rs.getString("nome"));
				
				int composerId = rs.getInt("id");
				
				PreparedStatement ps = DatabaseConfig.getConnect().prepareStatement(sqlS);
				ps.setInt(1, composerId);
				
				ResultSet rsS = ps.executeQuery();

				while(rsS.next()) {
					
				}
				
				System.out.println(songs.size());
				composer.setMusicas(songs);
				composers.add(composer);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return composers;
	}
}
