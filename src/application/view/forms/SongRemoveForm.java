package application.view.forms;

import java.util.List;

import application.model.entities.Song;
import application.model.repositories.SongRepository;

public class SongRemoveForm {
	public static void view() {
		System.out.println("Escolha a m�sica que deseja remover");
		
		// Cuidado, essa fun��o pode retornar NULL ou com as m�sicas.
		List<Song> songs = SongRepository.getAllSongs();
		
		// Utilize o id da m�sica para o usu�rio escolher
		(songs.get(0)).getId(); // retorna um n�mero identificador de cada m�sica.
	}
}
