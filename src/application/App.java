package application;

import application.config.DatabaseConfig;
import application.view.Console;

public class App {
	public static void main(String[] args) {
		DatabaseConfig.connect();
		Console.start();
	}
}
