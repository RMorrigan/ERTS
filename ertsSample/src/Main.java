import controller.LoginController;
import view.LoginView;

public class Main {
	
	public static void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.setVisible(true);
		new LoginController(loginView);
	}
}
