
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ApproveMovie extends JFrame{

	//private JFrame frmMovieshareStore;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	String search = "title";
	static boolean useLog = false;
	static boolean modLog = false;
	static boolean adminLog = false;
	static User user;
	static MovieDatabase movies;
	static Movie temp = null;
	static App page;


	//public static DefaultListModel<String> titles = new DefaultListModel<>();

	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		
		//MovieDatabase movies = new MovieDatabase("Movie.txt");
		//for(Movie m : movies.getAllMovies()) {
		//	titles.addElement(m.getTitle());
		//}
		
		//System.out.print(titles);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApproveMovie window = new ApproveMovie(page, movies, user, useLog, modLog, adminLog);
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
	public ApproveMovie(App page, MovieDatabase movies, User user, boolean useLog, boolean modLog, boolean adminLog) throws FileNotFoundException {
		initialize(page, movies, user, useLog, modLog, adminLog);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize(App page, MovieDatabase movies, User user, boolean useLog, boolean modLog, boolean adminLog) throws FileNotFoundException {
		
		/*frmMovieshareStore = new JFrame();
		frmMovieshareStore.setTitle("MovieShare Store");
		frmMovieshareStore.setBounds(100, 100, 770, 719);
		frmMovieshareStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMovieshareStore.getContentPane().setLayout(null);*/
		
		//frmMovieshareStore = new JFrame();
		setTitle("Approve Movies");
		setBounds(100, 100, 770, 719);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
			
		DefaultListModel<Movie> titles = new DefaultListModel<>();
		//MovieDatabase movies = new MovieDatabase("NeedApprovedMovies.txt");
		for(Movie m : movies.getNeedApprovedMovies()) {
			titles.addElement(m);
		}
		
		JLabel lblMovieshareStore = new JLabel("MovieShare Store");
		lblMovieshareStore.setFont(new Font("Eras Medium ITC", Font.BOLD, 40));
		lblMovieshareStore.setBounds(15, 0, 392, 71);
		//frmMovieshareStore.getContentPane().add(lblMovieshareStore);
		getContentPane().add(lblMovieshareStore);
		
		JRadioButton rdbtnTitle = new JRadioButton("Title");
		buttonGroup.add(rdbtnTitle);
		rdbtnTitle.setSelected(true);
		rdbtnTitle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				search = "title";
			}
		});
		rdbtnTitle.setBounds(457, 63, 69, 29);
		//frmMovieshareStore.getContentPane().add(rdbtnTitle);
		getContentPane().add(rdbtnTitle);
		
		JRadioButton rdbtnGenre = new JRadioButton("Genre");
		buttonGroup.add(rdbtnGenre);
		rdbtnGenre.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				search = "genre";
			}
		});
		rdbtnGenre.setBounds(533, 63, 75, 29);
		//frmMovieshareStore.getContentPane().add(rdbtnGenre);
		getContentPane().add(rdbtnGenre);
		
		JRadioButton rdbtnYear = new JRadioButton("Year");
		buttonGroup.add(rdbtnYear);
		rdbtnYear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			search = "year";
			}
		});
		rdbtnYear.setBounds(615, 63, 75, 29);
		//frmMovieshareStore.getContentPane().add(rdbtnYear);
		getContentPane().add(rdbtnYear);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSearch.setBounds(406, 31, 69, 20);
		//frmMovieshareStore.getContentPane().add(lblSearch);
		getContentPane().add(lblSearch);
		
		textField = new JTextField();
		textField.setBounds(466, 29, 211, 26);
		//frmMovieshareStore.getContentPane().add(textField);
		getContentPane().add(textField);

		textField.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<Movie> searches = movies.getMoviesByKey(textField.getText(), search);
				titles.clear();
				for(Movie m : searches) {
					titles.addElement(m);
				}
			}
		});
		btnGo.setBounds(680, 28, 53, 29);
		//frmMovieshareStore.getContentPane().add(btnGo);
		getContentPane().add(btnGo);
		
		JButton btnAction = new JButton("Action");
		btnAction.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<Movie> actions = movies.getMoviesByKey("Action", "genre");
				titles.clear();
				for(Movie m : actions) {
					titles.addElement(m);
				}
			}
		});
		btnAction.setBounds(15, 117, 127, 29);
		//frmMovieshareStore.getContentPane().add(btnAction);
		getContentPane().add(btnAction);
		
		JLabel lblGenre = new JLabel("Genre: ");
		lblGenre.setBounds(15, 87, 69, 20);
		//frmMovieshareStore.getContentPane().add(lblGenre);
		getContentPane().add(lblGenre);
		
		JButton btnAdventure = new JButton("Adventure");
		btnAdventure.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<Movie> adventures = movies.getMoviesByKey("Adventure", "genre");
				titles.clear();
				for(Movie m : adventures) {
					titles.addElement(m);
				}
			}
		});
		btnAdventure.setBounds(15, 149, 127, 29);
		//frmMovieshareStore.getContentPane().add(btnAdventure);
		getContentPane().add(btnAdventure);
		
		JButton btnAnimation = new JButton("Animation");
		btnAnimation.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<Movie> animations = movies.getMoviesByKey("Animation", "genre");
				titles.clear();
				for(Movie m : animations) {
					titles.addElement(m);
				}
			}
		});
		btnAnimation.setBounds(15, 181, 127, 29);
		//frmMovieshareStore.getContentPane().add(btnAnimation);
		getContentPane().add(btnAnimation);
		
		JButton btnComedy = new JButton("Comedy");
		btnComedy.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<Movie> comedies = movies.getMoviesByKey("Comedy", "genre");
				titles.clear();
				for(Movie m : comedies) {
					titles.addElement(m);
				}
			}
		});
		btnComedy.setBounds(15, 214, 127, 29);
		//frmMovieshareStore.getContentPane().add(btnComedy);
		getContentPane().add(btnComedy);
		
		JButton btnDrama = new JButton("Drama");
		btnDrama.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<Movie> dramas = movies.getMoviesByKey("Drama", "genre");
				titles.clear();
				for(Movie m : dramas) {
					titles.addElement(m);
				}
			}
		});

		btnDrama.setBounds(15, 248, 127, 29);
		//frmMovieshareStore.getContentPane().add(btnDrama);
		getContentPane().add(btnDrama);
		
		
//		JButton btnLogout = new JButton("Logout");
//		btnLogout.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent e)
//			{
//				try {
//					App newWindow = new App(user, false,false,false);
//					newWindow.setVisible(true);
//					dispose();
//				} catch (FileNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				
//			}
//		});
//		btnLogout.setBounds(15, 618, 115, 29);
		
//		if(useLog) {
//			getContentPane().remove(btnLogin);
//			getContentPane().add(btnLogout);
			
//		}
		
//		if(adminLog) {
//			getContentPane().remove(btnLogin);
//			getContentPane().add(btnLogout);
//			JButton btnApproveMovies = new JButton("Approve");
//			btnApproveMovies.setBounds(15, 538, 115, 29);
//			getContentPane().add(btnApproveMovies);
//		}
		
		
		JButton btnDocumentary = new JButton("Documentary");
		btnDocumentary.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<Movie> documentaries = movies.getMoviesByKey("Documentary", "genre");
				titles.clear();
				for(Movie m : documentaries) {
					titles.addElement(m);
				}
			}
		});
		btnDocumentary.setBounds(15, 282, 127, 29);
		//frmMovieshareStore.getContentPane().add(btnDocumentary);
		getContentPane().add(btnDocumentary);
		
		JButton btnHorror = new JButton("Horror");
		btnHorror.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<Movie> horrors = movies.getMoviesByKey("Horror", "genre");
				titles.clear();
				for(Movie m : horrors) {
					titles.addElement(m);
				}
			}
		});
		btnHorror.setBounds(15, 315, 127, 29);
		//frmMovieshareStore.getContentPane().add(btnHorror);
		getContentPane().add(btnHorror);
		
		JButton btnRomance = new JButton("Romance");
		btnRomance.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<Movie> romances = movies.getMoviesByKey("Romance", "genre");
				titles.clear();
				for(Movie m : romances) {
					titles.addElement(m);
				}
			}
		});
		btnRomance.setBounds(15, 350, 127, 29);
		//frmMovieshareStore.getContentPane().add(btnRomance);
		getContentPane().add(btnRomance);
		
		JButton btnThriller = new JButton("Thriller");
		btnThriller.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<Movie> thrillers = movies.getMoviesByKey("Thriller", "genre");
				titles.clear();
				for(Movie m : thrillers) {
					titles.addElement(m);
				}
			}
		});
		btnThriller.setBounds(15, 384, 127, 29);
		//frmMovieshareStore.getContentPane().add(btnThriller);
		getContentPane().add(btnThriller);
		
		JButton btnScifi = new JButton("Sci-Fi");
		btnScifi.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ArrayList<Movie> scifis = movies.getMoviesByKey("Sci-Fi", "genre");
				titles.clear();
				for(Movie m : scifis) {
					titles.addElement(m);
				}
			}
		});
		btnScifi.setBounds(15, 420, 127, 29);
		//frmMovieshareStore.getContentPane().add(btnScifi);
		getContentPane().add(btnScifi);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				titles.clear();
				for(Movie m : movies.getMovieList()) {
					titles.addElement(m);
				}			
			}
		});
		btnShowAll.setBounds(15, 454, 127, 29);
		//frmMovieshareStore.getContentPane().add(btnShowAll);
		getContentPane().add(btnShowAll);
		
		JScrollPane scrollBar = new JScrollPane();
		//scrollBar.setBounds(707, 117, 26, 530);
		scrollBar.setBounds(157, 118, 576, 529);
		//frmMovieshareStore.getContentPane().add(scrollBar);
		getContentPane().add(scrollBar);
		
		JList<Movie> list = new JList<Movie>(titles);
		list.setBounds(157, 118, 576, 529);
		//frmMovieshareStore.getContentPane().add(list);
		getContentPane().add(list);

		scrollBar.setViewportView(list);
		
		
		
		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				temp = (Movie) list.getSelectedValue();
				
			}
		};
		list.addMouseListener(mouseListener);
		
		JButton btnApprove = new JButton("Approve");
		btnApprove.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					if (temp != null) {
						//System.out.println(temp.getMovieID() + " " + temp.getTitle());
						temp.loadMovie("Movie.txt");
						temp.removeMovie("NeedApprovedMovies.txt");
						page.setVisible(false);
						App window = new App(user, useLog, modLog, adminLog);
						window.setVisible(true);
						dispose();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//temp.removeMovie("NeedApprovedMovies.txt");
				
			}
		});
		btnApprove.setBounds(15, 618, 115, 29);
		//frmMovieshareStore.getContentPane().add(btnLogin);
		getContentPane().add(btnApprove);
		
		JButton btnDisapprove = new JButton("Disapprove");
		btnDisapprove.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (temp != null) {
					try {
						temp.removeMovie("NeedApprovedMovies.txt");
						page.setVisible(false);
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
		btnDisapprove.setBounds(15, 573, 115, 29);
		getContentPane().add(btnDisapprove);
		
	}
}
