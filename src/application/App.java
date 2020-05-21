package application;

import application.config.DatabaseConfig;
import application.model.repositories.ComposerRepository;
import application.view.Console;

public class App {
	public static void main(String[] args) {
		DatabaseConfig.started();
		
		ComposerRepository.getAll();
		
//		Console.start();
	}
}
