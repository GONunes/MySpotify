package application.view.screen;

import java.util.Scanner;

import application.auth.UserAuth;
import application.config.UserConfig;
import application.model.entities.User;
import application.util.Screen;
import application.view.forms.UserRegistrationForm;

public class LoginScreen {
	public static void view() {
		String username = "";
		Scanner sc = new Scanner(System.in);
		boolean err = false;
		
		while(true) {
			Screen.clear();
			
			if(err)
				System.out.println("Usu�rio informado est� incorreto!");
			
			System.out.println("Informe seu usu�rio" + (err ? " correto:" : ":") );
			System.out.println("Caso n�o tenha um usu�rio, digite 0 para se cadastrar!");
			System.out.print("> ");
			username = sc.nextLine();
			
			if(username.equals("0"))
				UserRegistrationForm.view();
			else {
				User u = UserAuth.auth(username);
				
				if (u != null) {
					UserConfig.setUser(u);
					HomeUserScreen.view();
				} else
					err = true;
				
			}
			
		}
	}
}
