package application.view.forms;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import application.model.entities.Song;
import application.model.repositories.SongRepository;

public class SongRemoveForm {
	public static void view() {
		System.out.println("Escolha a m�sica que deseja remover");
		List<Song> songs = SongRepository.getAllSongs();
		
		
		Scanner sc = new Scanner(System.in);
		int escolha = 0;
		int confirm = 0;
		
		if (songs != null) {
		ListIterator <Song> it= songs.listIterator();
		while (it.hasNext()) {
			it.next();
			System.out.print(songs.listIterator().next().getId()+" ");
			System.out.print(songs.listIterator().next().getTitulo()+" ");
			System.out.print(songs.listIterator().next().getCompositor().getName()+"\n");
		}
		System.out.println("Continuar com remo��o de musica?");
		System.out.println("1 PARA SIM");
		System.out.println("2 PARA N�O");
		System.out.println("ATEN��O: a musica removida tamb�m ser� removida de qualquer playlist presente");
		confirm = sc.nextInt();
		   if (confirm == 1) {
		System.out.println("ID da musica para remo��o");
		escolha = sc.nextInt();
		   }
		SongRepository.removeById(escolha);
		   if (confirm == 2) {
			   System.out.println( "Opera��o cancelada");
			   }
	  }
		else {
			System.out.println( "SONGS NULO");
		}
	}
}