package application.model.entities;

public class Music {
	String titulo;
	int ano;
	String genero;
	double duracao;
	Composer compositor;
	
	public void exibir() {
		System.out.println("T�tulo da M�sica: " + titulo + "\n" +
							"Ano: " + ano + "\n" +
							"G�nero: " + genero + "\n" +
							"Dura��o: " + duracao + "\n" +
							"Compositor: " + compositor);
	}

}
