package application.view.forms;

import application.model.entities.User;
import application.model.repositories.UserRepository;
import java.util.Scanner;
import java.util.Date;

public class UserRegistrationForm {
	public static void view() {
		User usuario = new User();
		Date data = new Date();
		Scanner sc = new Scanner(System.in);
		
		if(null == null) {
		System.out.println(" Digite o nome de usuário que deseja utilizar:\n");
		System.out.println(" > ");
		String nome = sc.next();
		usuario.setName(nome);
		usuario.setCreated(data);
		}
	}
}
