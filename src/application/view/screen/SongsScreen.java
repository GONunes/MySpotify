package application.view.screen;

import java.util.List;

import application.model.entities.Song;
import application.model.repositories.SongRepository;

public class SongsScreen {
	public static void view() {
		
		// Aten��o, essa fun��o pode retornar NULL.
		List<Song> songs = SongRepository.getAllSongs();
		// A fun��o assim retorna uma lista das m�sicas do usu�rio.
		
		System.out.println("M�sicas Cadastradas: ");
		
		//...
	}
}
