package application.auth;

import application.model.entities.User;
import application.model.repositories.UserRepository;

public class UserAuth {
	public static User auth(String username) {
		return UserRepository.getUserByUsername(username);
	}
}
