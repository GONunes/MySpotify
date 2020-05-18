package application.view.forms;

import application.model.entities.Song;
import application.model.entities.Album;
import application.model.entities.Composer;
import application.model.repositories.SongRepository;
import application.util.Screen;
import application.view.screen.HomeUserScreen;

import java.util.Scanner;

public class SongRegistrationForm {
	
	public static void view() {
		Song song = new Song();
		Scanner sc = new Scanner(System.in);
		
		Screen.clear();
		
		System.out.println(" Digite o título da musica: ");
		System.out.print(" > ");
		String title = sc.nextLine();
		System.out.println();
		song.setTitulo(title);
		
		System.out.println(" Digite o ano da musica: ");
		System.out.print(" > ");
		int year = sc.nextInt();
		System.out.println();
		song.setAno(year);
		
		System.out.println(" Digite o genêro da musica: ");
		System.out.print(" > ");
		String genre = sc.nextLine();
		genre = sc.nextLine();
		song.setGenero(genre);
		
		System.out.println();
		
		System.out.println(" Digite a duração da musica: ");
		System.out.print(" > ");
		double duration = Double.parseDouble(sc.next().replace(":", "."));
		System.out.println();
		song.setDuracao(duration);
		
		System.out.println(" Digite o nome do compositor: ");
		System.out.print(" > ");
		String songwriter = sc.nextLine();
		songwriter = sc.nextLine();
		System.out.println();
		song.setCompositor(new Composer());
		song.getCompositor().setName(songwriter);
		
		System.out.println(" Digite o nome do album se tiver: ");
		System.out.print(" > ");
		String album = sc.nextLine();
		System.out.println();
		if(album.equals("")) 
			song.setAlbum(null);
		else
			song.setAlbum(new Album(album, null)); 
		
		SongRepository.add(song);
		
		System.out.println("Música cadastrada com sucesso!");
		System.out.println("Pressione enter para continuar");
		
		sc.nextLine();
		
	}

}
