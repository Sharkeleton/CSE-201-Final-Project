
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class User {
	
private String firstName;
private String lastName;
private String userName;
private String password;
private static int userID = 1;

	public User(String fN, String lN,String uN,String pS) throws IOException {
		this.firstName = fN;
		this.lastName = lN;
		this.userName = uN;
		this.password = pS;
		loadUser();
	}

	private void loadUser() throws IOException {
		File log = new File("Users.txt");
		PrintWriter out = new PrintWriter(new FileWriter(log , true));
		out.append(userID + "\t" + firstName + "\t" + lastName + "\t" + userName + "\t" + password + "\n");
		out.close();
		++ userID;
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
