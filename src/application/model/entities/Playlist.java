package application.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	
	private String nome;
	private List<Song> songs = new ArrayList<>();
	
	public Playlist() {}
	
	public Playlist(String nome, List<Song> songs) {
		this.nome = nome;
		this.songs = songs;
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
	
	
		
}
