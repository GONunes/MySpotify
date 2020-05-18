package application.model.entities;


import java.util.*;

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
		return "Detalhes da Playlist: " + "\n" +
						"Nome: " + nome + "\n" +
						 "M�sicas na Lista: " + songs;
	}

}
