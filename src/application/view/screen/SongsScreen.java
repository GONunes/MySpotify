package application.view.screen;

import java.util.*;

import application.model.entities.Song;
import application.model.repositories.SongRepository;

public class SongsScreen {
	public static void view() {	
		Scanner sc = new Scanner(System.in);
	
		List<Song> songs = SongRepository.getAllSongs();
		
		if(SongRepository.getAllSongs() == null) {
			System.out.println("A lista de músicas está vazia!");	
			System.out.println("Volte à tela principal para fazer o cadastro das músicas.");
			System.out.println("Pressione Enter para retornar ao menu principal.");
			sc.nextLine();
			sc.nextLine();
		}
		ListIterator it = songs.listIterator();
		while(it.hasNext()) {
			System.out.println("Músicas Cadastradas: " + it.next());
		}
		
			System.out.println("Pressione Enter para Continuar.");
			sc.nextLine();
			sc.nextLine();
			
	}
}
