
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

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
	static MovieDatabase movie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMovie window = new AddMovie(movie);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public AddMovie(MovieDatabase movies) throws FileNotFoundException {
		initialize(movies);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize(MovieDatabase movies) throws FileNotFoundException {
		//MovieDatabase movies = new MovieDatabase("Movie.txt");
		
		//frmLogin = new JFrame();
		setTitle("Add a Movie");
		setBounds(100, 100, 451, 344);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		genre = new JTextField();
		genre.setBounds(153, 118, 217, 26);
		getContentPane().add(genre);
		
		JButton btnAdd = new JButton("Submit");
		btnAdd.setBounds(153, 227, 115, 29);
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				movies.addNewMovie(new Movie(movies.getMovieList().size()+1, title.getText(), Integer.parseInt(year.getText()), genre.getText()));
				//System.out.println(movies.getNeedApprovedMovies());
				dispose();
			}
		});
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
