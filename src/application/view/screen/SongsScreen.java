package application.view.screen;

import java.util.List;

import application.model.entities.Song;
import application.model.repositories.SongRepository;

public class SongsScreen {
	public static void view() {
		
		// Atenção, essa função pode retornar NULL.
		List<Song> songs = SongRepository.getAllSongs();
		// A função assim retorna uma lista das músicas do usuário.
		
		System.out.println("Músicas Cadastradas: ");
		
		//...
	}
}
