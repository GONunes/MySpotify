package application.view.forms;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import application.model.entities.Song;
import application.model.repositories.SongRepository;
import application.util.Screen;

public class SongRemoveForm {
	public static void view() {
		List<Song> songs = SongRepository.getAllSongs();
		int escolha = 0;
		int confirm = 0;
		
		Screen.clear();
		System.out.println("Escolha a m�sica que deseja remover:");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		
		if (songs != null) {
			ListIterator<Song> it = songs.listIterator();
			while (it.hasNext()) {
				Song song = it.next();
				
				System.out.print(song.getId() + ". ");
				System.out.print(song.getTitulo() + " - ");
				System.out.print(song.getCompositor().getName() + "\n");
			}
			
			System.out.println();
			System.out.println("ATEN��O: a musica removida tamb�m ser� sair� de qualquer playlist que estiver");
			System.out.println();
			System.out.println("Deseja continuar com a remo��o de musica?");
			System.out.println("1. Sim");
			System.out.println("2. N�o");
			System.out.print("> ");
			
			confirm = sc.nextInt();
			if (confirm == 1) {
				System.out.println();
			   	System.out.println("Informe o n�mero da m�sica que ser� removida: ");
			   	System.out.print("> ");
			   	escolha = sc.nextInt();
			   	
			   	SongRepository.removeById(escolha);	
			   	System.out.println("M�sica removida!");
			   	System.out.println();
			   	
			   	System.out.println("Pressione enter para continuar...");
				sc.nextLine();
				sc.nextLine();
			}
			if (confirm == 2) {
				System.out.println();
				System.out.println("Opera��o cancelada");
				System.out.println();
				
				System.out.println("Pressione enter para continuar...");
				sc.nextLine();
				sc.nextLine();
		   }
	  } else {
			System.out.println("Voc� ainda n�o cadastrou nenhuma m�sica");
			System.out.println("ent�o n�o existem m�sicas para apagar");
			System.out.println();
			
			System.out.println("Pressione enter para continuar...");
			sc.nextLine();
		}
	}
}