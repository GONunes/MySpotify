package application.model.entities;

public class Album {
	
	private String titulo;
	private Composer compositores;
	
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

}
