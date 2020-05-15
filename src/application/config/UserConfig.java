package application.config;

import application.model.entities.User;

public class UserConfig {
	private static User user = null;
	
	public static void setUser(User user) {
		UserConfig.user = user;
	}
	
	public static User getUser() {
		return user;
	}
	
}
