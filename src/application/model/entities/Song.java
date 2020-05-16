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

	public Song(String titulo, int ano, String genero, double duracao, Composer compositor) {
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.duracao = duracao;
		this.compositor = compositor;
	}

	public String toString() {
		return "Título da Música: " + titulo + "\n" +
							"Ano: " + ano + "\n" +
							"Gênero: " + genero + "\n" +
							"Duração: " + duracao + "\n" +
							"Compositor: " + compositor;
	}
	
}
