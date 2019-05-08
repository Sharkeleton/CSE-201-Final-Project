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
        user = this.user;
        comment = this.com;
        movieID = this.movieID;
        myComID = commentID;
        ++commentID;
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
    
    public void loadComment(String fileName) throws IOException {
        String commentInfo = myComID + "\t" + user + "\t" + com + "\t" + movieID;
        if (isNewComment(commentInfo, fileName)) {
            File log = new File(fileName);
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append(commentInfo + "\n");
            out.close();
        }
    }
    
    private boolean isNewComment(String commentInfo, String fileName) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(fileName));
        while (scn.hasNextLine()) {
            String line = scn.nextLine();
            if (line.equals(commentInfo)) {
                scn.close();
                return false;
            }
        }
        scn.close();
        return true;
    }

}