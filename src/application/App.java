package application;

import application.config.DatabaseConfig;
import application.model.entities.Composer;
import application.model.entities.Song;
import application.model.repositories.SongRepository;
import application.view.Console;
import application.view.screen.HomeUserScreen;

public class App {
	public static void main(String[] args) {
		DatabaseConfig.started();
//		Console.start();
//		HomeUserScreen.view();
		
		
		Song s = new Song("Girls of Summer", 1980, "Rock", 3.80, new Composer("Aerosmith"));
		Song st = new Song("Could Have Been Me", 2016, "Rock", 3.80, new Composer("The Struts"));
		
		SongRepository.add(s);
		SongRepository.add(st);
		
	}
}
