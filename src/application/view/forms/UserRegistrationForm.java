package application.view.forms;

import application.model.entities.User;
import application.model.repositories.UserRepository;
import java.util.Scanner;
import java.util.Date;

public class UserRegistrationForm {
	public static void view() {
		User user = new User();
		Date date = new Date();
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println(" Digite o nome de usu�rio que deseja utilizar:");
		System.out.print(" > ");
		String name = sc.next();
		
		if(UserRepository.getUserByUsername(name) == null) {
			user.setName(name);
			user.setCreated(date);
			UserRepository.add(user);
			System.out.println("Usu�rio Cadastrado com Sucesso!");
		}
		else System.out.println("Esse usu�rio j� est� cadastrado! Escolha outro\n");
	}
}
