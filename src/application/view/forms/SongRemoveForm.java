package application.view.forms;

import java.util.List;

import application.model.entities.Song;
import application.model.repositories.SongRepository;

public class SongRemoveForm {
	public static void view() {
		System.out.println("Escolha a música que deseja remover");
		
		// Cuidado, essa função pode retornar NULL ou com as músicas.
		List<Song> songs = SongRepository.getAllSongs();
		
		// Utilize o id da música para o usuário escolher
		(songs.get(0)).getId(); // retorna um número identificador de cada música.
	}
}
