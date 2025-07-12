package model;

import util.*;
import java.sql.*;

public class UserDAO {
	
	public boolean createUser(User newUser, String plainPassword) throws SQLException{
		
		// sql query
		String sqlQuery = "INSERT INTO tb_users (username, password, email, role) VALUES ( ?, ?, ?, ?)";
		
		try(Connection con = DatabaseUtil.getConnection();
				PreparedStatement stm = con.prepareStatement(sqlQuery)){
			
			stm.setString(1, newUser.getUsername());
			stm.setString(2, SecurityUtil.hashPassword(plainPassword));
			stm.setString(3,  newUser.getEmail());
			stm.setString(4,  newUser.getRole().name());
			
			
			//execute the insert query which returns true if exactly 1 row is inserted
			return stm.executeUpdate() == 1;
		}
	}
	
	// authenticate user
	public User authenticateUser(String email, String plainPassword) throws SQLException {
		String sqlQuery = "SELECT id, username, email, password, role FROM tb_users WHERE email = ?";
		
		try(Connection con = DatabaseUtil.getConnection();
				PreparedStatement stm = con.prepareStatement(sqlQuery)) {
			
			stm.setString(1, email);
			ResultSet rs = stm.executeQuery(); // gets the results
			
			while(rs.next()) {
				String storedPassword = rs.getString("password");
				String hashedInput = SecurityUtil.hashPassword(plainPassword);
				
				// Check if passwords match
				if(storedPassword.equals(hashedInput)) {
					// Create and return user object
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setEmail(rs.getString("email"));
					user.setPassword(storedPassword);
					user.setRole(User.Role.valueOf(rs.getString("role")));
					
					return user;
				}
				//rs.close();
			}
		}
		return null; // Authentication failed
	}
	
	// check if user already exists
	public boolean userExists(String email, String username) throws SQLException {
		String sqlQuery = "SELECT COUNT(*) FROM tb_users WHERE email = ? OR username = ?";
		
		try(Connection con = DatabaseUtil.getConnection();
				PreparedStatement stm = con.prepareStatement(sqlQuery)) {
			
			stm.setString(1, email);
			stm.setString(2, username);
			
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) > 0;
			}
		}
		
		return false;
	}

}
