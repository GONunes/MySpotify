package application.model.entities;

import application.model.entities.Composer;

public class Song {
	private int id;
	private String titulo;
	private int ano;
	private String genero;
	private double duracao;
	private Composer compositor;
	private Album album;
	
	public Song() {}
	
	public Song(String titulo, int ano, String genero, double duracao, Composer compositor) {
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.duracao = duracao;
		this.compositor = compositor;
	}
	
	public Song(int id, String titulo, int ano, String genero, double duracao, Composer compositor) {
		this(titulo, ano, genero, duracao, compositor);
		this.id = id;
	}
	
	public Song(int id, String titulo, int ano, String genero, double duracao, Composer compositor, Album album) {
		this(id, titulo, ano, genero, duracao, compositor);
		this.album = album;
	}

	public int getId() {
		return id;
	}
	
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
	
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		if(this.album == null) this.album = new Album(); // Para evitar um NullPointerException
		
		return "Código da Música: " + id + "\n" +
				"Título da Música: " + titulo + "\n" +
				(album.getTitulo() == null ? "" : "Album: " + album.getTitulo() + "\n") +
				"Ano: " + ano + "\n" +
				"Gênero: " + genero + "\n" +
				"Duração: " + String.format("%.2f", duracao)
								.replace(".", ":")
								.replace(",", ":") 
							+ "\n" +
				"Compositor: " + compositor.getName();
	}
	
}
