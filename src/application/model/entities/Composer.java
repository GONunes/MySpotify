package application.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Composer extends User {
	
	private int id;
	private List<Album> albuns = new ArrayList<Album>();
	private List<Song> musicas = new ArrayList<Song>();
	
	public Composer() {}

	public Composer(String nome) {
		this.setName(nome);
	}

	public int getId() {
		return id;
	}
	public List<Album> getAlbuns() {
		return albuns;
	}
	public void setAlbuns(ArrayList<Album> albuns) {
		this.albuns = albuns;
	}
	public List<Song> getMusicas() {
		return musicas;
	}
	public void setMusicas(List<Song> list) {
		this.musicas = list;
	}

	@Override
	public String toString() {
		return "";
	}
	
}
