package application.view.forms;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import application.model.entities.Playlist;
import application.model.entities.Song;
import application.model.repositories.PlaylistRepository;
import application.model.repositories.SongRepository;
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
			System.out.println("Desculpe, mas voc� ainda n�o cadastrou nenhuma m�sica");
			System.out.println("� necess�rio pelo menos uma para criar uma nova playlist");
		} else {
			
			System.out.println("Digite o nome da playlist: ");
			System.out.print("> ");
			String name = sc.nextLine();
			playlist.setNome(name);
			
			System.out.println();
			System.out.println("Lista de M�sicas: ");
			
			for(Song song : songs) {
				System.out.print(song.getId() + ". " + song.getTitulo() + " - " + song.getCompositor().getName() + "\n");
			}
			
			System.out.println();
			System.out.println("Escolha as m�sicas que deseja adicionar a playlist");
			System.out.println("Aten��o: Informe os n�meros de todas as m�sicas, separadas por v�rgula");
			System.out.println("Exemplo: 1,2,3,4,5");
			
			System.out.print("> ");
			ids = sc.nextLine();
			
			String[] idsArray = ids.split(",");
			for(String id : idsArray) {
				int idInt = Integer.parseInt(id.trim());
				List<Song> songsFilter = songs.stream()
											.filter(s -> s.getId() == idInt)
											.collect(Collectors.toList());
				
				boolean err = true;
				if(songsFilter != null)
					if(songsFilter.size() > 0) {
						playlist.getSongs().add(songsFilter.get(0));
						err = false;
					}
				
				if(err) {
					System.out.println("ATEN��O: O c�digo '"
									+ idInt 
									+ "' informado n�o � de uma m�sica v�lida");
					System.out.println("Por isso n�o foi cadastrado na playlist");
				}
				
			}
			
			PlaylistRepository.add(playlist);
			
			System.out.println();
			System.out.println("Playlist cadastrada com sucesso!");
			System.out.println("Pressione enter para continuar");
			
			sc.nextLine();
			
			HomeUserScreen.view();
		}
		
		System.out.println("Pressione Enter para Continuar.");
		sc.nextLine();
		
	}
}
