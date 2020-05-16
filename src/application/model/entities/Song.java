package application.model.entities;

public class Song {
	String titulo;
	int ano;
	String genero;
	double duracao;
	Composer compositor;
	
	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public int getAno() {
		return ano;
	}



	public void setAno(int ano) {
		this.ano = ano;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public double getDuracao() {
		return duracao;
	}



	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}



	public Composer getCompositor() {
		return compositor;
	}



	public void setCompositor(Composer compositor) {
		this.compositor = compositor;
	}


	public String toString() {
		return "T�tulo da M�sica: " + titulo + "\n" +
							"Ano: " + ano + "\n" +
							"G�nero: " + genero + "\n" +
							"Dura��o: " + duracao + "\n" +
							"Compositor: " + compositor;
	}

}
