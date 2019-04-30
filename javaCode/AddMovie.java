
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AddMovie extends JFrame {

	//private JFrame frmLogin;
	private JTextField title;
	private JTextField genre;
	private JTextField year;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMovie window = new AddMovie();
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
	public AddMovie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frmLogin = new JFrame();
		setTitle("Add a Movie");
		setBounds(100, 100, 451, 344);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		title = new JTextField();
		title.setBounds(153, 68, 217, 26);
		getContentPane().add(title);
		title.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(56, 71, 91, 20);
		getContentPane().add(lblTitle);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setBounds(56, 121, 81, 20);
		getContentPane().add(lblGenre);
		
		genre = new JPasswordField();
		genre.setBounds(153, 118, 217, 26);
		getContentPane().add(genre);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(153, 227, 115, 29);
		getContentPane().add(btnAdd);
		
		JLabel lblAdd = new JLabel("Add a Movie");
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBounds(15, 16, 398, 20);
		getContentPane().add(lblAdd);
		
		year = new JTextField();
		year.setBounds(153, 164, 217, 26);
		getContentPane().add(year);
		year.setColumns(10);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(56, 167, 91, 20);
		getContentPane().add(lblYear);
	}
}
