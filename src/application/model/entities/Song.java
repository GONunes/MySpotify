package application.model.entities;

public class Song {
	String titulo;
	int ano;
	String genero;
	double duracao;
	Composer compositor;
	
	@Override
	public String toString() {
		return "Título da Música: " + titulo + "\n" +
							"Ano: " + ano + "\n" +
							"Gênero: " + genero + "\n" +
							"Duração: " + duracao + "\n" +
							"Compositor: " + compositor;
	}

}
