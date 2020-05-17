package application.view.forms;

import application.model.entities.Song;
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
		System.out.print("\n");
		song.setTitulo(title);
		
		System.out.println(" Digite o ano da musica: ");
		System.out.print(" > ");
		int year = sc.nextInt();
		System.out.print("\n");
		song.setAno(year);
		
		System.out.println(" Digite o genêro da musica: ");
		System.out.print(" > ");
		String genre = sc.nextLine();
		System.out.print("\n");
		song.setGenero(genre);
		
		System.out.println(" Digite a duração da musica: ");
		System.out.print(" > ");
		double duration = Double.parseDouble(sc.next().replace(":", "."));
		System.out.print("\n");
		song.setDuracao(duration);
		
		System.out.println(" Digite o nome do compositor: ");
		System.out.print(" > ");
		String songwriter = sc.nextLine();
		song.setCompositor(new Composer());
		System.out.print("\n");
		song.getCompositor().setName(songwriter);
		
		SongRepository.add(song);
		
		System.out.println("Música cadastrada com sucesso!");
		System.out.println("Pressione enter para continuar");
		
		sc.nextLine();
		sc.nextLine();
		
		HomeUserScreen.view();
		
	}

}
