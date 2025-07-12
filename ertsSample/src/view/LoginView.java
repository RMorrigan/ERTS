package view;

import java.awt.*;
import javax.swing.*;

public class LoginView extends JFrame {

	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JButton btnRegister, btnLogin;
	
	public LoginView() {
		setTitle("ERTS - Login");
		setSize(350, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(3, 2));
		
		txtEmail = new JTextField(20);
		txtPassword = new JPasswordField(20);
		btnRegister = new JButton("Register");
		btnLogin = new JButton("Login");
		
		add(new JLabel("Enter email"));
		add(txtEmail);
		add(new JLabel("Enter password"));
		add(txtPassword);
		add(btnRegister);
		add(btnLogin);
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JButton getBtnRegister() {
		return btnRegister;
	}

	public void setBtnRegister(JButton btnRegister) {
		this.btnRegister = btnRegister;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}
}
