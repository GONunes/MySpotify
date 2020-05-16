package application.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Composer extends User {
	
	private int id;
	private ArrayList<Album> albuns = new ArrayList<Album>();
	private ArrayList<Song> musicas = new ArrayList<Song>();
	
	public Composer() {}

	public Composer(String nome) {
		this.setName(nome);
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
