package controller;

import model.*;
import model.User.Role;
import javax. swing.*;
import view.*;
import java.sql.*;


public class RegistrationController {
	
	private RegistrationView registerView;
	private UserDAO dao = new UserDAO();
	
	// constructor
	public RegistrationController(RegistrationView registerView) {
		this.registerView = registerView;
		
		registerView.getBtn_Return().addActionListener(e -> goBack());
		registerView.getBtn_Register().addActionListener(E -> register());
	}

	private void goBack() {
		registerView.dispose();
		new LoginController(new LoginView());
	}
	
	private void register() {
		/*
		 * User newUser = new User(); newUser.setEmail("test@email.com");
		 * newUser.setUsername("test_username"); newUser.setRole(Role.ATTENDEE);
		 */
		// get values from view
		String username = registerView.getTxt_Username().getText().trim();
		String email = registerView.getTxt_email().getText().trim();
		String password = new String(registerView.getTxt_password().getPassword());
		String confirmPassword = new String(registerView.getTxt_confirmPassword().getPassword());
		
		// Validate inputs
		if(!validateInputs(username, email, password, confirmPassword)) {
			return;
		}
		
		// Make new user
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setEmail(email);
		newUser.setRole(Role.ATTENDEE); // Default role
		
		try {
			if(dao.createUser(newUser, password)) {
				JOptionPane.showMessageDialog(registerView,"User signed up successfully");
			}
			else {
				JOptionPane.showMessageDialog(registerView, "User sign up failure");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(registerView, e.getMessage());
		}
		
	}
	
	private boolean validateInputs(String username, String email, String password, String confirmPassword) {
		// Check if fields are empty
		if(username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
			JOptionPane.showMessageDialog(registerView,
				"Please fill in all fields",
				"Validation Error",
				JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		// Check if passwords match
		if(!password.equals(confirmPassword)) {
			JOptionPane.showMessageDialog(registerView,
				"Passwords do not match",
				"Validation Error",
				JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}

}
