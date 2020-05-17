package application.view.forms;

import java.util.List;
import java.util.Scanner;

import application.model.entities.Playlist;
import application.model.entities.Song;
import application.model.repositories.PlaylistRepository;
import application.model.repositories.SongRepository;

public class PlaylistRemoveForm {
	public static void view() {
		Scanner sc = new Scanner(System.in);
		int escolha = 0;
		int confirm = 0;
		
		System.out.println("Verifique qual playlist remover:");
		System.out.println(PlaylistRepository.getAllPlaylists());
		System.out.print(">");
		escolha= sc.nextInt();
		System.out.println("Apos removida, a playlist será perdida permanentemente");
		System.out.println("Continuar?");
		System.out.println("1. Sim");
		System.out.println("2. Não");
		System.out.print("> ");
		confirm= sc.nextInt();
		if (confirm==1) {
			//PlaylistRepository.remove(escolha);
			System.out.println("Playlist deletada");
		}
		if (confirm==2) {
			System.out.println();
			System.out.println("Operação cancelada");
			System.out.println();
			
			System.out.println("Pressione enter para continuar...");
			sc.nextLine();
			sc.nextLine();
		}
	}
}
