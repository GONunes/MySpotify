package application.view.screen;

import java.util.*;

import application.model.entities.Playlist;
import application.model.repositories.PlaylistRepository;

public class PlaylistsScreen {
	public static void view() {
		Scanner sc = new Scanner(System.in);
		
		 List<Playlist> playlists = PlaylistRepository.getAllPlaylists();
		 
		 if(playlists == null) {
				System.out.println("A playlist est� vazia!");	
				System.out.println("Volte � tela principal para montar a sua playlist.");
				System.out.println("Pressione Enter para retornar ao menu principal.");
				sc.nextLine();
				sc.nextLine();
		 } else {
		 
		 ListIterator<Playlist> it = playlists.listIterator();
		 System.out.println("Playlists Dispon�veis: ");
		 
		 while(it.hasNext()) {
			for(int i = 0; i < playlists.size(); i++) {
				System.out.println(it.next().toString());
				System.out.println();
				 }
			 }
		 	
		 	System.out.println("Pressione Enter para Continuar.");
			sc.nextLine();
		 }
	}
}