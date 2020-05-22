package application.view.screen;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import application.model.entities.Album;
import application.model.repositories.AlbumRepository;
import application.util.Screen;

public class AlbumsScreen {
public static void view() {
		
		Screen.clear();
		Scanner sc = new Scanner(System.in);
	
		 List<Album> albuns = AlbumRepository.getAll();
		 
		 if(albuns == null) {
				System.out.println("Nenhum album registrado");	
				System.out.println();
				System.out.println("Pressione Enter para retornar ao menu principal.");
				sc.nextLine();
		 } else {
			 ListIterator<Album> it = albuns.listIterator();
			 
			 System.out.println("Albuns: ");
			 System.out.println();
			 
			 while(it.hasNext()) {
				for(int i = 0; i < albuns.size(); i++) {
					System.out.println(it.next().toString());
					System.out.println();
				 }
			 	
			 	System.out.println("Pressione Enter para Continuar.");
				sc.nextLine();
			 }
		 }
	}
}