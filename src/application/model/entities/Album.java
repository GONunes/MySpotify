package application.model.entities;

public class Album {
	
	Composer compositor;
	
	public Album(Composer compositor) {
		this.compositor = compositor;
	}

	public Composer getCompositor() {
		return compositor;
	}

	public void setCompositor(Composer compositor) {
		this.compositor = compositor;
	}

	
}
