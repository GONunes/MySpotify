package application.view.screen;

import java.util.Scanner;

import application.config.UserConfig;
import application.util.Screen;
import application.view.forms.PlaylistRegistrationForm;
import application.view.forms.PlaylistRemoveForm;
import application.view.forms.SongRegistrationForm;
import application.view.forms.SongRemoveForm;

public class HomeUserScreen {
	
	public static void view(){ 
		Scanner sc = new Scanner(System.in);

		boolean open = true;
		int escolha = 0;
		
	  while (open) {
		  Screen.clear();
		  
			System.out.println("Bem Vindo " + UserConfig.getUser().getName());
			System.out.println();
			System.out.println("Digite 1 para cadastrar uma musica");
			System.out.println("Digite 2 para cadastrar uma playlist");
			System.out.println();
			System.out.println("Digite 3 para apagar uma musica");
			System.out.println("Digite 4 para apagar uma playlist");
			System.out.println();
			System.out.println("Digite 5 para listar musicas");
			System.out.println("Digite 6 para listar playlist");
			System.out.println();
			System.out.println("Digite 7 para sair");
			
			System.out.print("> ");
			escolha = sc.nextInt();
			
			switch (escolha) {
				case 1:
					SongRegistrationForm.view();
					break;
				case 2:
					PlaylistRegistrationForm.view();
					break;
				case 3:
					SongRemoveForm.view();
					break;
				case 4:
					PlaylistRemoveForm.view();
					break;
				case 5:
					SongsScreen.view();
					break;
				case 6:
					PlaylistsScreen.view();
					break;
				case 7:
					System.out.println("Saindo");
					open = false;
			}
		}
	}
}
