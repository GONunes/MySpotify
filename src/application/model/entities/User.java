package application.model.entities;

import java.util.Date;
import java.util.List;

public class User {
	private String name;
	private Date created;
	private List<Playlist> playlists;
	
	public User() {}
	
	public User(String name, Date created, List<Playlist> playlists) {
		super();
		this.name = name;
		this.created = created;
		this.playlists = playlists;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public List<Playlist> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

}
