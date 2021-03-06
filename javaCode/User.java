import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class User {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String userCheck;
    private boolean isMod = false;
    private boolean isAdmin = false;
    private static String modPassword = "abc";
    private static String adminPassword = "cba";

    public User(String fN, String lN, String uN, String pS, String userCheck) throws IOException {
        this.firstName = fN;
        this.lastName = lN;
        this.userName = uN;
        this.password = pS;
        this.userCheck = userCheck;
        checkUser();
        loadUser();
    }

    public void checkUser() {
        if (userCheck.equals(modPassword)) {
            isMod = true;
            return;
        }
        if (userCheck.equals(adminPassword)) {
            isAdmin = true;
            isMod = true;
        }
    }

    private void loadUser() throws IOException {
        String userInfo = firstName + "\t" + lastName + "\t" + userName + "\t" + password + "\t" + userCheck;
        if (isNewUser(userInfo)) {
            File log = new File("user.txt");
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append(userInfo + "\n");
            out.close();
        }
    }

    private boolean isNewUser(String userInfo) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("users.txt"));
        boolean inFile = false;
        while (scn.hasNextLine()) {
            String line = scn.nextLine();
            if (line.equals(userInfo)) {
                return false;
            }
        }
        scn.close();
        return true;
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
    
    public String getPassword() {
    	return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserCheck(String userCheck) {
        this.userCheck = userCheck;
    }

    public boolean isMod() {
        return isMod;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void addComment(MovieDatabase m, Comment com) {
        m.getNeedApprovedComments().add(com);
    }

    public void addMovie(MovieDatabase m, Movie mov) {
        m.getNeedApprovedMovies().add(mov);
    }

    public boolean approveMovie(MovieDatabase m, int movieID) throws IOException {
        // approving movie code
        m.addMovie(m.getNeedApprovedMovies().get(movieID));
        m.getNeedApprovedMovies().remove(movieID);
        return true;
    }

    public boolean approveComment(MovieDatabase m, int commentID) {
        // approving comment code
        Comment newCom = m.getNeedApprovedComments().get(commentID);
        m.getMovieList().get(newCom.getMovieID()).addComment(newCom);
        m.getNeedApprovedComments().remove(commentID);
        return true;
    }

    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
                + password + ", userCheck=" + userCheck + "]";
    }

}
