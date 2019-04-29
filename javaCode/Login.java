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
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame{

	//private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	private ArrayList<User> users = new ArrayList<User>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.setBounds(153, 179, 115, 29);
		getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
//				File file = new File("user.txt");
//		        Scanner sc;
//				try {
//					sc = new Scanner(file);
//			        while (sc.hasNextLine()) {
//			            String curLine = sc.nextLine();
//			            String[] splitted = curLine.split("\t");
//			            User use;
//						try {
//							use = new User(splitted[0], // movieID
//							        splitted[1], // title
//							        splitted[2], // year
//							        splitted[3],
//							        splitted[4]// genre
//							);
//							users.add(use);
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//			        }
//			        sc.close();
//			        System.out.println(users);
//				} catch (FileNotFoundException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				}
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
					page = new Register();
					page.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(btnRegister);
		
		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setBounds(172, 16, 83, 20);
		getContentPane().add(lblUserLogin);
	}
}
