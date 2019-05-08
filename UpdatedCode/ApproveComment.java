import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JList;

public class ApproveComment extends JFrame{

	//private JFrame frmMovie;
	static String movieTitle;
	static String movieGenre;
	static int movieID;
	static int releaseYear;
	static boolean useLog = false;
	static boolean modLog = false;
	static boolean adminLog = false;
	static User user;
	static Movie movie;
	static Comment temp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApproveComment window = new ApproveComment(user, movie, useLog, modLog, adminLog);
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
	public ApproveComment(User user, Movie movie, boolean useLog, boolean modLog, boolean adminLog) throws FileNotFoundException {
		initialize(user, movie, useLog, modLog, adminLog);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize(User user, Movie movie, boolean useLog, boolean modLog, boolean adminLog) throws FileNotFoundException {
		//frmMovie = new JFrame();
		setTitle(movie.getTitle());
		setBounds(100, 100, 770, 719);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		DefaultListModel<Comment> titles = new DefaultListModel<>();
		MovieDatabase movies = new MovieDatabase("Movie.txt");
		for(Comment c : movies.getNeedApprovedComments()) {
			if (c.getMovieID() == movie.getMovieID()) {
				titles.addElement(c);
			}
			
		}
		
		JLabel lblMovieTitle = new JLabel(movie.getTitle());
		lblMovieTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMovieTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieTitle.setBounds(15, 16, 718, 49);
		getContentPane().add(lblMovieTitle);
		
		JLabel lblGenre = new JLabel(movie.getGenre());
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setBounds(25, 81, 708, 20);
		getContentPane().add(lblGenre);
		
		JLabel lblYear = new JLabel(Integer.toString(movie.getYear()));
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(15, 117, 718, 20);
		getContentPane().add(lblYear);
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setBounds(56, 154, 102, 20);
		getContentPane().add(lblComments);
		
		JScrollPane scrollBar = new JScrollPane();
		scrollBar.setBounds(159, 153, 574, 494);
		getContentPane().add(scrollBar);
		
		JList<Comment> list = new JList<Comment>(titles);
		list.setBounds(159, 153, 574, 494);
		getContentPane().add(list);
		scrollBar.setViewportView(list);
		
		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				temp = (Comment) list.getSelectedValue();
				
			}
		};
		list.addMouseListener(mouseListener);

		
//		if (useLog) {
			JButton btnDisapprove = new JButton("Disapprove");
			btnDisapprove.setBounds(15, 618, 115, 29);
			btnDisapprove.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (temp != null) {
						try {
							temp.removeComment("NeedApprovedComments.txt");
							//page.setVisible(false);
							App window = new App(user, useLog, modLog, adminLog);
							window.setVisible(true);
							dispose();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
			});
			getContentPane().add(btnDisapprove);
//		}
		
//		if (modLog) {
			JButton btnApprove = new JButton("Approve");
			btnApprove.setBounds(15, 573, 115, 29);
			btnApprove.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try {
						if (temp != null) {
							//System.out.println(temp.getMovieID() + " " + temp.getTitle());
							temp.loadComment("Comment.txt");
							temp.removeComment("NeedApprovedComments.txt");
							//page.setVisible(false);
							App window = new App(user, useLog, modLog, adminLog);
							window.setVisible(true);
							dispose();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			getContentPane().add(btnApprove);
//		}
		
	}
}
