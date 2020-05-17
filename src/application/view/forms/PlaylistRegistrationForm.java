package application.view.forms;

import application.model.entities.Playlist;
import application.model.entities.Song;
import application.model.repositories.PlaylistRepository;
import application.model.repositories.SongRepository;
import java.util.List;
import java.util.Scanner;
import application.util.Screen;
import application.view.screen.HomeUserScreen;


public class PlaylistRegistrationForm {
	public static void view() {
		
		Playlist playlist = new Playlist();
		List<Song> songs = SongRepository.getAllSongs();		
		String ids = "";
		Scanner sc = new Scanner(System.in);
		
		Screen.clear();
		
		if(songs == null) {
			System.out.println("Desculpe, mas voc� ainda n�o cadastrou nenhum m�sica");
			System.out.println("� necess�rio pelo menos uma para criar uma nova playlist");
		} else {
			
			System.out.println("Digite o nome da playlist: ");
			System.out.print("> ");
			String name = sc.nextLine();
			System.out.print("\n");
			playlist.setNome(name);
			
			System.out.println("Lista de M�sicas: ");
			
			for(Song song : songs) {
				System.out.print(song.getId() + ". " + song.getTitulo() + " - " + song.getCompositor().getName() + "\n");
			}
			
			System.out.println();
			System.out.println("Escolha as m�sicas que deseja adicionar a playlist");
			System.out.println("Aten��o: Informe os n�meros de todas as m�sicas, separadas por v�rgula");
			System.out.println("Exemplo: 1,2,3,4,5");
			
			System.out.print(">");
			ids = sc.nextLine();
			
			String[] idsArray = ids.split(",");
			for(String id : idsArray) {
				int idInt = Integer.parseInt(id.trim());
				Song songSelected = songs.stream()
										.filter(s -> s.getId() == idInt)
										.findFirst()
										.get();
				
				if(songSelected != null) {
					playlist.getSongs().add(songSelected);
					System.out.println("M�sica adicionada com sucesso!");
					
				} else 
					System.out.println("O id informado n�o confere com as m�sicas dispon�veis em sua lista");
				
			}
			
			PlaylistRepository.add(playlist);
			System.out.println("Playlist cadastrada com sucesso!");
			System.out.println("Pressione enter para continuar");
			
			sc.nextLine();
			sc.nextLine();
			
			HomeUserScreen.view();
		}
		
	}
}
