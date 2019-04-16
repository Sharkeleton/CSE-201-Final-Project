import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User {
	
private String firstName;
private String lastName;
private String userName;
private String password;

	public User(String fN, String lN,String uN,String pS) throws FileNotFoundException {
		fN = this.firstName;
		lN = this.lastName;
		uN = this.userName;
		pS = this.password;
		loadUser(this);
	}

	private void loadUser(User user) throws FileNotFoundException {
		Scanner writer = new Scanner(new File("Users.txt"));
		writer.close();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addComment(MovieDatabase m, int id, String com) {
		m.getMovieById(id).addComment(com, this);
	}

}
