package application.model.entities;

import java.util.ArrayList;

public class Composer extends User{
	
	ArrayList<Album> albuns = new ArrayList<Album>();
	ArrayList<Song> musicas = new ArrayList<Song>();
	
	public Composer(ArrayList<Album> albuns, ArrayList<Song> musicas) {
		this.albuns = albuns;
		this.musicas = musicas;
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
