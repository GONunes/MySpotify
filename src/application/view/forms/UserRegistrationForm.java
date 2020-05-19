package application.view.forms;

import application.config.UserConfig;
import application.model.entities.User;
import application.model.repositories.UserRepository;
import application.util.Screen;
import application.view.screen.HomeUserScreen;

import java.util.Scanner;
import java.util.Date;

public class UserRegistrationForm {
	public static void view() {
		
		Scanner sc = new Scanner(System.in);
		User user = new User();
		user.setCreated(new Date());
		
		Screen.clear();
		System.out.println("Digite o nome de usuário que deseja utilizar:");
		
		System.out.print("> ");
		String name = sc.next();
		
		
		if(UserRepository.getUserByUsername(name) == null) {
			user.setName(name);
			
			UserRepository.add(user);
			UserConfig.setUser(user);
			
			System.out.println("Usuário cadastrado com sucesso!");
			System.out.println("Pressione enter para continuar");
			
			sc.nextLine();
			sc.nextLine();
			
			UserConfig.setUser(user);
			HomeUserScreen.view();
		}
		else {
 			System.out.println("Esse usuário já está cadastrado!");
 			System.out.println("Pressione enter para continuar...");
 			
 			sc.nextLine();
			sc.nextLine();
		}
		
	}
}
