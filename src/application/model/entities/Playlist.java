package application.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	
	private int id;
	private String nome;
	private List<Song> songs = new ArrayList<>();
	
	public Playlist() {}
	
	public Playlist(String nome, List<Song> songs) {
		this.nome = nome;
		this.songs = songs;
	}
	
	public Playlist(int id, String nome, List<Song> songs) {
		this(nome, songs);
		this.id = id;
	}

	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		String playlist = "Detalhes da Playlist: " + "\n" +
						  "Nome: " + nome + "\n" +
						  "Músicas na Lista: " + "\n";
		
		for(Song song : songs) {
			playlist += " - " + song.getId() + ". " + song.getTitulo() + " - " 
					+ song.getAlbum().getTitulo() 
					+ "\n";
		}
		
		return playlist;
				
	}

}
