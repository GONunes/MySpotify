package application.model.entities;

public class Song {
	String titulo;
	int ano;
	String genero;
	double duracao;
	Composer compositor;
	
	@Override
	public String toString() {
		return "T�tulo da M�sica: " + titulo + "\n" +
							"Ano: " + ano + "\n" +
							"G�nero: " + genero + "\n" +
							"Dura��o: " + duracao + "\n" +
							"Compositor: " + compositor;
	}

}
