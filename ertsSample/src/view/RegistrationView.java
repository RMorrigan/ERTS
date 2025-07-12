package view;

import javax.swing.*;
import java.awt.*;

public class RegistrationView extends JFrame {
	
	// Declare Components
	private JTextField txt_username = new JTextField(20);
	private JTextField txt_email = new JTextField(20);
	private JPasswordField txt_password = new JPasswordField(20);
	private JPasswordField txt_confirmPassword = new JPasswordField(20);
	private JButton btn_Register = new JButton("Register");
	private JButton btn_Return = new JButton("Return");
	
	// CONSTRUCTOR
	public RegistrationView() {
		setTitle("Register");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450, 275);
		setLocationRelativeTo(null);
		
		JPanel form = new JPanel(new GridLayout(4,2,5,5));
		form.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
		
		form.add(new JLabel("Username")); form.add(txt_username);
		form.add(new JLabel("Email")); form.add(txt_email);
		form.add(new JLabel("Password")); form.add(txt_password);
		form.add(new JLabel("Confirm Password")); form.add(txt_confirmPassword);
		
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		buttonsPanel.add(btn_Return);
		buttonsPanel.add(btn_Register);
		
		add(form, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}

	public JTextField getTxt_Username() {
		return txt_username;
	}

	public void setTxt_Username(JTextField txt_Username) {
		this.txt_username = txt_Username;
	}

	public JTextField getTxt_email() {
		return txt_email;
	}

	public void setTxt_email(JTextField txt_email) {
		this.txt_email = txt_email;
	}

	public JPasswordField getTxt_password() {
		return txt_password;
	}

	public void setTxt_password(JPasswordField txt_password) {
		this.txt_password = txt_password;
	}

	public JPasswordField getTxt_confirmPassword() {
		return txt_confirmPassword;
	}

	public void setTxt_confirmPassword(JPasswordField txt_confirmPassword) {
		this.txt_confirmPassword = txt_confirmPassword;
	}

	public JButton getBtn_Register() {
		return btn_Register;
	}

	public void setBtn_Register(JButton btn_Register) {
		this.btn_Register = btn_Register;
	}

	public JButton getBtn_Return() {
		return btn_Return;
	}

	public void setBtn_Return(JButton btn_Return) {
		this.btn_Return = btn_Return;
	}

}
