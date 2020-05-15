package application.model.entities;

public class Music {
	String titulo;
	int ano;
	String genero;
	double duracao;
	Composer compositor;
	
	public void exibir() {
		System.out.println("Título da Música: " + titulo + "\n" +
							"Ano: " + ano + "\n" +
							"Gênero: " + genero + "\n" +
							"Duração: " + duracao + "\n" +
							"Compositor: " + compositor);
	}

}
