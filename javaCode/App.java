
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.JList;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;


public class App {

	private JFrame frmMovieshareStore;
	private JTextField textField;

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
					App window = new App();
					window.frmMovieshareStore.setVisible(true);
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
	public App() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException {
		
		frmMovieshareStore = new JFrame();
		frmMovieshareStore.setTitle("MovieShare Store");
		frmMovieshareStore.setBounds(100, 100, 770, 719);
		frmMovieshareStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMovieshareStore.getContentPane().setLayout(null);
		
		JLabel lblMovieshareStore = new JLabel("MovieShare Store");
		lblMovieshareStore.setFont(new Font("Eras Medium ITC", Font.BOLD, 40));
		lblMovieshareStore.setBounds(15, 0, 392, 71);
		frmMovieshareStore.getContentPane().add(lblMovieshareStore);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSearch.setBounds(406, 31, 69, 20);
		frmMovieshareStore.getContentPane().add(lblSearch);
		
		textField = new JTextField();
		textField.setBounds(466, 29, 211, 26);
		frmMovieshareStore.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		btnGo.setBounds(680, 28, 53, 29);
		frmMovieshareStore.getContentPane().add(btnGo);
		
		JRadioButton rdbtnTitle = new JRadioButton("Title");
		rdbtnTitle.setBounds(457, 63, 69, 29);
		frmMovieshareStore.getContentPane().add(rdbtnTitle);
		
		JRadioButton rdbtnGenre = new JRadioButton("Genre");
		rdbtnGenre.setBounds(533, 63, 75, 29);
		frmMovieshareStore.getContentPane().add(rdbtnGenre);
		
		JRadioButton rdbtnYear = new JRadioButton("Year");
		rdbtnYear.setBounds(615, 63, 75, 29);
		frmMovieshareStore.getContentPane().add(rdbtnYear);
		
		JButton btnAction = new JButton("Action");
		btnAction.setBounds(15, 117, 127, 29);
		frmMovieshareStore.getContentPane().add(btnAction);
		
		JLabel lblGenre = new JLabel("Genre: ");
		lblGenre.setBounds(15, 87, 69, 20);
		frmMovieshareStore.getContentPane().add(lblGenre);
		
		JButton btnNewButton = new JButton("Adventure");
		btnNewButton.setBounds(15, 149, 127, 29);
		frmMovieshareStore.getContentPane().add(btnNewButton);
		
		JButton btnAnimation = new JButton("Animation");
		btnAnimation.setBounds(15, 181, 127, 29);
		frmMovieshareStore.getContentPane().add(btnAnimation);
		
		JButton btnComedy = new JButton("Comedy");
		btnComedy.setBounds(15, 214, 127, 29);
		frmMovieshareStore.getContentPane().add(btnComedy);
		
		JButton btnDrama = new JButton("Drama");
		btnDrama.setBounds(15, 248, 127, 29);
		frmMovieshareStore.getContentPane().add(btnDrama);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(15, 618, 115, 29);
		frmMovieshareStore.getContentPane().add(btnLogin);
		
		JButton btnDocumentary = new JButton("Documentary");
		btnDocumentary.setBounds(15, 282, 127, 29);
		frmMovieshareStore.getContentPane().add(btnDocumentary);
		
		JButton btnNewButton_1 = new JButton("Horror");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(15, 315, 127, 29);
		frmMovieshareStore.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Romance");
		btnNewButton_2.setBounds(15, 350, 127, 29);
		frmMovieshareStore.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Thriller");
		btnNewButton_3.setBounds(15, 384, 127, 29);
		frmMovieshareStore.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Sci-fi");
		btnNewButton_4.setBounds(15, 420, 127, 29);
		frmMovieshareStore.getContentPane().add(btnNewButton_4);
		
		DefaultListModel<String> titles = new DefaultListModel<>();
		MovieDatabase movies = new MovieDatabase("Movie.txt");
		for(Movie m : movies.getAllMovies()) {
			titles.addElement(m.getTitle());
		}
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(707, 117, 26, 530);
		frmMovieshareStore.getContentPane().add(scrollBar);
		
		JList<String> list = new JList<String>(titles);
		list.setBounds(157, 118, 576, 529);
		frmMovieshareStore.getContentPane().add(list);
	}
}
