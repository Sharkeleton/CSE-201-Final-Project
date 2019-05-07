import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Comment {

    private User user;
    private String com;
    private int myComID;
    private int movieID;
    private static int commentID = 1;

    public Comment(String comment, User user, int movieID) {
    	comment = this.com;
    	user = this.user;
        movieID = this.movieID;
        myComID = commentID;
        ++commentID;
    }
    
    public void loadCom(String fileName) throws IOException {
        String comInfo = commentID + "\t" + com + "\t" + user + "\t" + movieID;
        if (isNewCom(comInfo, fileName)) {
            File log = new File(fileName);
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append(comInfo + "\n");
            out.close();
        }
    }

    private boolean isNewCom(String comInfo, String fileName) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(fileName));
        while (scn.hasNextLine()) {
            String line = scn.nextLine();
            if (line.equals(comInfo)) {
                scn.close();
                return false;
            }
        }
        scn.close();
        return true;
    }
    public User getUser() {
        return user;
    }

    public String getCom() {
        return com;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setCom(String com) {
        this.com = com;
    }

    @Override
    public String toString() {
        return "Comment [com=" + com + "]";
    }

}
