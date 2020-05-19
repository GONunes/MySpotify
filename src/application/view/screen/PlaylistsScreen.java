package application.view.screen;

import java.util.*;

import application.model.entities.Playlist;
import application.model.repositories.PlaylistRepository;
import application.util.Screen;

public class PlaylistsScreen {
	public static void view() {
		
		Screen.clear();
		Scanner sc = new Scanner(System.in);
		
		 List<Playlist> playlists = PlaylistRepository.getAllPlaylists();
		 
		 if(playlists == null) {
				System.out.println("A playlist está vazia!");	
				System.out.println();
				
				System.out.println("Volte à tela principal para montar a sua playlist.");
				System.out.println("Pressione Enter para retornar ao menu principal.");
				sc.nextLine();
				sc.nextLine();
		 } else {
			 ListIterator<Playlist> it = playlists.listIterator();
			 System.out.println("Playlists Disponíveis: ");
			 System.out.println();
			 
			 while(it.hasNext()) {
				for(int i = 0; i < playlists.size(); i++) {
					System.out.println(it.next().toString());
					System.out.println();
				 }
			 	
			 	System.out.println("Pressione Enter para Continuar.");
				sc.nextLine();
			 }
		 }
	}
}