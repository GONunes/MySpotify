package application.view.screen;

import java.util.*;

import application.model.entities.Playlist;
import application.model.repositories.PlaylistRepository;

public class PlaylistScreen {
	public static void view() {
	Scanner sc = new Scanner(System.in);
	
	 List<Playlist> playlists = PlaylistRepository.getAllPlaylists();
	 
	 if(PlaylistRepository.getAllPlaylists() == null) {
			System.out.println("A playlist est� vazia!");	
			System.out.println("Volte � tela principal para montar a sua playlist.");
			System.out.println("Pressione Enter para retornar ao menu principal.");
			sc.nextLine();
			sc.nextLine();
	 }
	 
	 ListIterator it = playlists.listIterator();
	 while(it.hasNext()) {
		 System.out.println("Playlists Dispon�veis: " + it.next());
		 System.out.println(playlists.toString());
		 //como chamar o toString dentro de screen?
		 
	 }
	 
	 
	 
	

	}
}