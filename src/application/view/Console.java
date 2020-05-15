package application.view;

import java.util.Date;

import application.model.entities.User;
import application.model.repositories.UserRepository;

public class Console {
	public static void start() {
		User u = new User();
		
		u.setName("Guilherme");
		u.setCreated(new Date(System.currentTimeMillis()));
		
		UserRepository.add(u);
		UserRepository.getAll();
		
		System.out.println("ARQUIVO GRAVADO!");
	}
}
