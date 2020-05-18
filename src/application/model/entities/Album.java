package application.model.entities;

public class Album {
	
	private String titulo;
	private Composer compositor;
	
	public Album() {}
	
	public Album(String titulo, Composer compositor) {
		this.titulo = titulo;
		this.compositor = compositor;
	}

	public Composer getCompositor() {
		return compositor;
	}

	public void setCompositor(Composer compositor) {
		this.compositor = compositor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
