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
				System.out.println("Usuário informado está incorreto!");
			
			System.out.println("Informe seu usuário" + (err ? " correto:" : ":") );
			System.out.println("Caso não tenha um usuário, digite 0 para se cadastrar!");
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
