package controller;

import controller.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import view.LoginView;
import view.RegistrationView;

import model.*;

public class LoginController {

	private LoginView loginView;
	private UserDAO userDAO;
	
	public LoginController(LoginView loginView) {
		this.loginView = loginView;
		this.userDAO = new UserDAO();
		
		loginView.getBtnLogin().addActionListener(new LoginListener());
		loginView.getBtnRegister().addActionListener(e -> showRegistrationView());
	}
	
	private class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// JOptionPane.showMessageDialog(null, "Login button clicked");
			String email = loginView.getTxtEmail().getText().trim();
			String password = new String(loginView.getTxtPassword().getPassword());
			
			// Validate inputs
			if(email.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(loginView, 
					"Please enter both email and password", 
					"Login Error", 
					JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			try {
				User user = userDAO.authenticateUser(email, password); // Check database against input
				if (user != null) {
					// success
					JOptionPane.showMessageDialog(loginView, 
							"Welcome " + user.getUsername() + "!\nRole: " + user.getRole(), 
							"Login Successful", 
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					// fail login
					JOptionPane.showMessageDialog(loginView, 
							"Invalid email or password. Please try again.", 
							"Login Failed", 
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(loginView, ex.getMessage());
			}
		}
	}
	
	private void showRegistrationView() {
		RegistrationView rv = new RegistrationView();
		new RegistrationController(rv);
		rv.setVisible(true);
	}
}
