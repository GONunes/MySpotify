package application.view.screen;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import application.model.entities.Song;
import application.model.repositories.SongRepository;
import application.util.Screen;

public class SongsScreen {
	public static void view() {	
		Screen.clear();
		Scanner sc = new Scanner(System.in);
	
		List<Song> songs = SongRepository.getAllSongs();
		
		if(songs == null) {
			System.out.println("A lista de músicas está vazia!");	
			System.out.println("Volte à tela principal para fazer o cadastro das músicas.");
			System.out.println("Pressione Enter para retornar ao menu principal.");
			
			sc.nextLine();			
		}
		
		ListIterator<Song> it = songs.listIterator();
		System.out.println("Músicas Cadastradas: ");
		
		while(it.hasNext()) {
			System.out.println(it.next());
			System.out.println();
		}
		
		System.out.println("Pressione Enter para Continuar.");
		sc.nextLine();
		
	}
}
