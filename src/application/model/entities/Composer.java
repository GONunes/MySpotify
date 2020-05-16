package application.model.entities;

import java.util.ArrayList;

public class Composer extends User {
	
	private int id;
	private ArrayList<Album> albuns = new ArrayList<Album>();
	private ArrayList<Song> musicas = new ArrayList<Song>();
	
	public Composer() {}
	
	public Composer(ArrayList<Album> albuns, ArrayList<Song> musicas, int id) {
		this.id = id;
		this.albuns = albuns;
		this.musicas = musicas;
	}

	public int getId() {
		return id;
	}
	public ArrayList<Album> getAlbuns() {
		return albuns;
	}
	public void setAlbuns(ArrayList<Album> albuns) {
		this.albuns = albuns;
	}
	public ArrayList<Song> getMusicas() {
		return musicas;
	}
	public void setMusicas(ArrayList<Song> musicas) {
		this.musicas = musicas;
	}

}
