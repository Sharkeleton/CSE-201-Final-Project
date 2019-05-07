
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

public class AddComment extends JFrame {

	//private JFrame frmLogin;
	private JTextField comment;
	static User user;
	static int movieID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddComment window = new AddComment(user, movieID);
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
	public AddComment(User user, int movieID) throws FileNotFoundException {
		initialize(user, movieID);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize(User user, int movieID) throws FileNotFoundException {
		MovieDatabase movies = new MovieDatabase("Movie.txt");
	
		setTitle("Add a Comment");
		setBounds(100, 100, 450, 391);
		
		getContentPane().setLayout(null);
		
		comment = new JTextField();
		comment.setBounds(110, 68, 260, 188);
		getContentPane().add(comment);
		comment.setColumns(10);
		
		JLabel lblComment = new JLabel("Comment:");
		lblComment.setBounds(15, 71, 91, 20);
		getContentPane().add(lblComment);
		
		JButton btnAdd = new JButton("Submit");
		btnAdd.setBounds(155, 286, 115, 29);
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				movies.addComment(new Comment(comment.getText(), user, movieID));
				dispose();
			}
		});
		getContentPane().add(btnAdd);
		
		JLabel lblAddComm = new JLabel("Add a Comment");
		lblAddComm.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddComm.setBounds(15, 16, 398, 20);
		getContentPane().add(lblAddComm);

	}
}
