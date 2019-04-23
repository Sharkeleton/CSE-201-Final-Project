import java.io.BufferedWriter;
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
private int myID;
private boolean isMod = false;
private static int userID = 1;
private static String modPassword = "abc";

// not implemented yet
private FileWriter writer = new FileWriter("Users.txt");
private BufferedWriter out = new BufferedWriter(writer);
private Scanner in = new Scanner(new File("Users.txt"));

	public User(String fN, String lN,String uN,String pS, String modCheck) throws IOException {
		this.firstName = fN;
		this.lastName = lN;
		this.userName = uN;
		this.password = pS;
		myID = userID;
        ++ userID;
		if (modCheck.equals(modPassword)) {
		    isMod = true;
		}
		
		loadUser();
	}
	
	
    private void loadUser() throws IOException {
        File log = new File("Users.txt");
        PrintWriter out = new PrintWriter(new FileWriter(log , true));
        out.append(userID + "\t" + firstName + "\t" + lastName + "\t" + userName + "\t" + password + "\n");
        out.close();
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
	
	public void addComment(MovieDatabase m, int id, Comment com) {
		m.getNeedApprovedComments().add(com);
	}
	
	public void addMovie(MovieDatabase m, Movie mov) {
	    m.getNeedApprovedMovies().add(mov);
	}
	
	public boolean approveMovie(MovieDatabase m, int movieID) {
	    if (!isMod) {
	        return false;
	    }
	    // approving movie code
	    m.addMovie(m.getNeedApprovedMovies().get(movieID));
	    return true;
 	}
	
   public boolean approveComment(MovieDatabase m, int commentID) {
        if (!isMod) {
            return false;
        }
        // approving comment code
        Comment newCom = m.getNeedApprovedComments().get(commentID);
        m.getMovieList().get(newCom.getMovieID()).addComment(newCom);
        return true;
    }

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + "]";
	}

}
