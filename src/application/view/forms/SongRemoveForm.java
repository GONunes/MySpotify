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
		System.out.println("Escolha a música que deseja remover:");
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
			System.out.println("ATENÇÃO: a musica removida também será sairá de qualquer playlist que estiver");
			System.out.println();
			System.out.println("Deseja continuar com a remoção de musica?");
			System.out.println("1. Sim");
			System.out.println("2. Não");
			System.out.print("> ");
			
			confirm = sc.nextInt();
			if (confirm == 1) {
				System.out.println();
			   	System.out.println("Informe o número da música que será removida: ");
			   	System.out.print("> ");
			   	escolha = sc.nextInt();
			   	
			   	SongRepository.removeById(escolha);	
			   	System.out.println("Música removida!");
			   	System.out.println();
			   	
			   	System.out.println("Pressione enter para continuar...");
				sc.nextLine();
				sc.nextLine();
			}
			if (confirm == 2) {
				System.out.println();
				System.out.println("Operação cancelada");
				System.out.println();
				
				System.out.println("Pressione enter para continuar...");
				sc.nextLine();
				sc.nextLine();
		   }
	  } else {
			System.out.println("Você ainda não cadastrou nenhuma música");
			System.out.println("então não existem músicas para apagar");
			System.out.println();
			
			System.out.println("Pressione enter para continuar...");
			sc.nextLine();
		}
	}
}