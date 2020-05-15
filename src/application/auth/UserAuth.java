package application.auth;

import java.util.List;
import java.util.stream.Collectors;

import application.model.entities.User;
import application.model.repositories.UserRepository;

public class UserAuth {
	public static User auth(String username) {
		List<User> users = UserRepository.getAll();
		
		if (users != null) {
			for(User u : users) {
				if(u.getName().equals(username))
					return u;
			}
			return null;
		}
		
		return null;
	}
}
