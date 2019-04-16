import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
	
private String firstName;
private String lastName;
private String userName;
private String password;
private FileWriter writer = new FileWriter("Users.txt");
private BufferedWriter out = new BufferedWriter(writer);
private Scanner in = new Scanner(new File("Users.txt"));

	public User(String fN, String lN,String uN,String pS) throws IOException {
		this.firstName = fN;
		this.lastName = lN;
		this.userName = uN;
		this.password = pS;
		loadUser();
	}

	private void loadUser() throws IOException {
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

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + "]";
	}

}
