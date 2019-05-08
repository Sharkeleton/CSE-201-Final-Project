import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame{

	//private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	static ArrayList<User> users;
	static User user;
	static App window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login page = new Login(window, user);
					page.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login(App window, User user) {
		initialize(window, user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(App window, User user) {
		//frmLogin = new JFrame();
		setTitle("Login");
		setBounds(100, 100, 450, 364);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(153, 68, 217, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(56, 71, 91, 20);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(56, 121, 81, 20);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 118, 217, 26);
		getContentPane().add(passwordField);
		
		JLabel lblUserLogin = new JLabel("Login");
		lblUserLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserLogin.setBounds(15, 16, 398, 20);
		getContentPane().add(lblUserLogin);
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.setBounds(153, 179, 115, 29);
		getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					MovieDatabase movies = new MovieDatabase("Movie.txt");
					try {
						if (textField.getText().equals("") || passwordField.getText().equals("")) {
							lblUserLogin.setText("Invalid username/password");
						}
						else if (movies.checkUserPass(textField.getText(), passwordField.getText(), "user.txt").isAdmin()) {
							App home = new App(user, true,true,true);
							home.setVisible(true);
							window.dispose();
							dispose();
						}
						else if (movies.checkUserPass(textField.getText(), passwordField.getText(), "user.txt").isMod()) {
							App home = new App(user, true,true,false);
							home.setVisible(true);
							window.dispose();
							dispose();
						}
						else if (movies.checkUserPass(textField.getText(), passwordField.getText(), "user.txt").equals(null)) {
							lblUserLogin.setText("Invalid username/password.");
						}
						else {
							App home = new App(user, true,false,false);
							home.setVisible(true);
							window.dispose();
							dispose();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(153, 240, 115, 29);
		btnRegister.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Register page;
				try {
					page = new Register(window);
					page.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(btnRegister);
	
	}
}
