package application.model.entities;

import java.util.*;

public class Band {
	
	ArrayList <Composer> artistas = new ArrayList<Composer>();
	
	public Band(ArrayList<Composer> artistas) {
		this.artistas = artistas;
	}
	
	public ArrayList<Composer> getArtistas() {
		return artistas;
	}

	public void setArtistas(ArrayList<Composer> artistas) {
		this.artistas = artistas;
	}
	
	
}

