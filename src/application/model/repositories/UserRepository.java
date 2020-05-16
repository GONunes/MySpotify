package application.model.repositories;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import application.config.DatabaseConfig;
import application.model.entities.User;

public class UserRepository {
	
	public static void add(User user) {
		
		String sql = "INSERT INTO users(name, created) VALUES(?,?)";
		
		try {
			PreparedStatement pst = DatabaseConfig
									.getConnect()
									.prepareStatement(sql);
			
			pst.setString(1, user.getName());
			pst.setDate(2, new Date(user.getCreated().getTime()) );
			
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static User getUserByUsername(String username) {
		String sql = "SELECT * FROM users WHERE name = ? LIMIT 1";
		
		try {
			PreparedStatement pst = DatabaseConfig
										.getConnect()
										.prepareStatement(sql);
			pst.setString(1, username);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				return new User(
							rs.getString("name"),
							rs.getDate("created"),
							null
						);
			}

			return null;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static List<User> getAll() {
		List<User> users = new ArrayList<>();
		
		try {
			ResultSet rq = DatabaseConfig
							.getConnect()
							.createStatement()
							.executeQuery("SELECT * FROM users");
			
			while(rq.next()) {
				users.add(
						new User(rq.getString("name"),
								 rq.getDate("created"),
								 null
						));
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return users;
	}
	
}
