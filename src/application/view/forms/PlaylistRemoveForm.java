package application.view.forms;

import java.util.List;
import java.util.Scanner;

import application.model.entities.Playlist;
import application.model.entities.Song;
import application.model.repositories.PlaylistRepository;
import application.model.repositories.SongRepository;
import application.view.screen.HomeUserScreen;

public class PlaylistRemoveForm {
	public static void view() {
		Scanner sc = new Scanner(System.in);
		List<Playlist> playlists = PlaylistRepository.getAllPlaylists();
		String ids = "";
		int confirm;
		
		
		System.out.println("Verifique na lista qual playlist remover:");
		
		for(Playlist playlist : playlists) {
			System.out.print(playlist.getId() + ". " + playlist.getNome() + "\n");
		}
		
		System.out.println();
		System.out.println("Escolha as playlists que deseja remover");
		System.out.println("Aten��o: Informe os n�meros de todas as playlists, separadas por v�rgula");
		System.out.println("Exemplo: 1,2,3,4,5");
		
		System.out.print(">");
		ids = sc.nextLine();
		
		System.out.println("Apos removida, a playlist ser� perdida permanentemente");
		System.out.println("Continuar?");
		System.out.println("1. Sim");
		System.out.println("2. N�o");
		System.out.print("> ");
		confirm = sc.nextInt();
		
		if(confirm == 1) {
		
			String[] idsArray = ids.split(",");
			for(String id : idsArray) {
				int idInt = Integer.parseInt(id.trim());
				Playlist playlistSelected = playlists.stream()
										.filter(s -> s.getId() == idInt)
										.findFirst()
										.get();
				
				if(playlistSelected != null)
					/*PlaylistRepository.remove(playlistSelected)*/;
				else 
					System.out.println("O ID '"
									+ idInt 
									+ "' informado n�o � uma playlist v�lida");
			
		}
			
			System.out.println();
			System.out.println("Playlist exclu�da com sucesso!");
			System.out.println("Pressione enter para continuar...");
			
			sc.nextLine();
			
	}
		else if (confirm == 2) {
			
			System.out.println();
			System.out.println("Opera��o cancelada");
			System.out.println();
			
			System.out.println("Pressione enter para continuar...");
			sc.nextLine();
			sc.nextLine();
		}
		
		else {
			
			System.out.println();
			System.out.println("Opera��o inv�lida");
			System.out.println();
			
			System.out.println("Pressione enter para continuar...");
			sc.nextLine();
			sc.nextLine();
		}
		
	}
}
