import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class MoviePage extends JFrame{

	//private JFrame frmMovie;
	static String movieTitle;
	static String movieGenre;
	static int releaseYear;
	static boolean useLog = false;
	static boolean modLog = false;
	static boolean adminLog = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoviePage window = new MoviePage(movieTitle, movieGenre, releaseYear, useLog, modLog, adminLog);
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
	public MoviePage(String title, String genre, int year, boolean useLog, boolean modLog, boolean adminLog) {
		initialize(title, genre, year, useLog, modLog, adminLog);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String title, String genre, int year, boolean useLog, boolean modLog, boolean adminLog) {
		//frmMovie = new JFrame();
		setTitle(title);
		setBounds(100, 100, 770, 719);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblMovieTitle = new JLabel(title);
		lblMovieTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMovieTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieTitle.setBounds(15, 16, 718, 49);
		getContentPane().add(lblMovieTitle);
		
		JLabel lblGenre = new JLabel(genre);
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setBounds(25, 81, 708, 20);
		getContentPane().add(lblGenre);
		
		JLabel lblYear = new JLabel(Integer.toString(year));
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(15, 117, 718, 20);
		getContentPane().add(lblYear);
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setBounds(56, 154, 102, 20);
		getContentPane().add(lblComments);
		
		JScrollPane scrollBar = new JScrollPane();
		scrollBar.setBounds(159, 153, 574, 494);
		getContentPane().add(scrollBar);
		
		JList list = new JList();
		list.setBounds(159, 153, 574, 494);
		getContentPane().add(list);
		
		if (useLog) {
			JButton btnComment = new JButton("Comment");
			btnComment.setBounds(15, 618, 115, 29);
			getContentPane().add(btnComment);
		}
		
		if (modLog) {
			JButton btnApprove = new JButton("Approve");
			btnApprove.setBounds(15, 573, 115, 29);
			getContentPane().add(btnApprove);
		}
		
	}
}

