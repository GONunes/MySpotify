package application.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Album {
	
	private String titulo;
	private Composer compositores;
	private List<Song> songs = new ArrayList<>();
	
	public Album() {}
	
	public Album(String titulo, Composer compositor) {
		this.titulo = titulo;
		this.compositores = compositor;
	}

	public Composer getCompositor() {
		return compositores;
	}

	public void setCompositor(Composer compositor) {
		this.compositores = compositor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Song> getSongs() {
		return songs;
	}
	
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	public String toString() {
		String album = "Nome: " + titulo 			+ System.lineSeparator() +
						"Compositor: " + getCompositor().getName() + System.lineSeparator() +
						  "Músicas do Album: " 		+ System.lineSeparator();
		
		for(Song song : songs) {
			album += " - " + song.getId() + ". " + song.getTitulo() + " - " + song.getCompositor().getName();
			album += System.lineSeparator();
		}
		
		return album;
	
}
}