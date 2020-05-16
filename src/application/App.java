package application;

import application.config.DatabaseConfig;
import application.view.Console;
import application.view.forms.UserRegistrationForm;

public class App {
	public static void main(String[] args) {
		DatabaseConfig.started();
		//Console.start();
		UserRegistrationForm.view();
	}
}
