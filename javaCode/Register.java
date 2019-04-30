import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Register extends JFrame{

	//private JFrame frmLogin;
	private JTextField username;
	private JPasswordField passwordField;
	private JTextField firstName;
	private JTextField lastName;
	private JPasswordField modKey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		//frmLogin = new JFrame();
		setTitle("Register");
		setBounds(100, 100, 450, 475);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		username = new JTextField();
		username.setBounds(153, 68, 217, 26);
		getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(56, 71, 91, 20);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(56, 121, 81, 20);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 118, 217, 26);
		getContentPane().add(passwordField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					if (modKey.getText().equals("")) {
						System.out.println("here");
						User user = new User(firstName.getText(), lastName.getText(), username.getText(), passwordField.getText(), "a");
					}
					else {
						User user = new User(firstName.getText(), lastName.getText(), username.getText(), passwordField.getText(), modKey.getText());
					}
					Login log = new Login();
					log.setVisible(true);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//dispose();
			}
		});
		btnRegister.setBounds(153, 316, 115, 29);
		getContentPane().add(btnRegister);
		
		JLabel lblUserLogin = new JLabel("User Registration");
		lblUserLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserLogin.setBounds(15, 16, 398, 20);
		getContentPane().add(lblUserLogin);
		
		firstName = new JTextField();
		firstName.setBounds(153, 164, 217, 26);
		getContentPane().add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(153, 214, 217, 26);
		getContentPane().add(lastName);
		lastName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(56, 167, 91, 20);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(56, 217, 91, 20);
		getContentPane().add(lblLastName);
		
		modKey = new JPasswordField();
		modKey.setBounds(153, 262, 217, 26);
		getContentPane().add(modKey);
		
		JLabel lblModeratorKey = new JLabel("Key:");
		lblModeratorKey.setBounds(39, 265, 115, 20);
		getContentPane().add(lblModeratorKey);
	}
}
