package application.view.screen;

import java.util.Scanner;

import application.config.UserConfig;
import application.util.Screen;

public class HomeUserScreen {
	
	public static void view(){ 
		Scanner sc = new Scanner(System.in);

		boolean open = true;
		int escolha = 0;
		
	  while (open) {
		  Screen.clear();
		  
			System.out.println("bem vindo " + UserConfig.getUser().getName());
			System.out.println("Digite 1 para cadastrar uma musica" + "\n" + "Digite 2 para cadastrar uma playlist" + "\n" + 
			"Digite 3 para apagar uma musica" +"\n" + "Digite 4 para apagar uma playlist" + "n" + "Digite 5 para listar musicas"
					+ "n" + "Digite 6 para listar playlist"+ "n" + "Digite 7 para sair");
			escolha= sc.nextInt();
			switch (escolha) {
			case 1:
				//SongRegistrationForm registrar musica
				break;
			case 2:
				//Registrar PlayList
				break;
			case 3:
				//Apagar musica
				break;
			case 4:
				//Apagar playlist
				break;
			case 5:
				//Listar musica
				break;
			case 6:
				//Listar Playlist
				break;
			case 7:
				System.out.println("Saindo");
				open = false;
		}}
}
}
