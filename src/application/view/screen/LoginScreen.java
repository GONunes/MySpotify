package application.view.screen;

import java.util.Scanner;

import application.auth.UserAuth;
import application.config.UserConfig;
import application.model.entities.User;
import application.view.forms.UserRegistrationForm;

public class LoginScreen {
	public static void view() {
		String username = "";
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Informe seu usu�rio:");
			System.out.println("Caso n�o tenha um usu�rio, digite 0 para se cadastrar!");
			System.out.print(" > ");
			username = sc.nextLine();
			
			if(username.equals("0"))
				UserRegistrationForm.view();
			else {
				User u = UserAuth.auth(username);
				
				if (u != null) {
					UserConfig.setUser(u);
				} else {
					System.out.println("Infelizmente o usu�rio informado est� incorreto");
					System.out.println("Precione qualquer tecla para continuar...");
					sc.nextLine();
				}
				
			}
			
		}
	}
}
