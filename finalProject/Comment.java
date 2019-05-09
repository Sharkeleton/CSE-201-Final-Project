import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Comment {

    private String user;
    private String com;
    private int comID;
    private int movieID;
    private static int commentID = 1;

    public Comment(int comID, String comment, String user, int movieID) {
        //user = this.user;
        //comment = this.com;
        //movieID = this.movieID;
        this.user = user;
        this.com = comment;
        this.movieID = movieID;
        this.comID = comID;
    }

    public String getUser() {
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
    
    public int getComID() {
    	return comID;
    }

    @Override
    public String toString() {
        return user;
    }
    
    public void loadComment(String fileName) throws IOException {
        String commentInfo = comID + "\t" + user + "\t" + com + "\t" + movieID;
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
    
    public void removeComment(String fileName) throws IOException {
    	ArrayList<Comment> cList = new ArrayList<Comment>();
    	File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String curLine = sc.nextLine();
            String[] splitted = curLine.split("\t");
            System.out.println(splitted[0]);
            if(Integer.parseInt(splitted[0]) != comID) {
            Comment com = new Comment(	Integer.parseInt(splitted[0]), // movieID
				                    splitted[1], // title
				                    splitted[2], // year
            		Integer.parseInt(splitted[3]) // genre
            );
            cList.add(com);
            }
        }
        sc.close();
        updateFile(cList, fileName);
    }
    private void updateFile(ArrayList<Comment> cList, String fileName) throws IOException {
    	PrintWriter empty = new PrintWriter(new File(fileName));
    	empty.print("");
    	for(Comment c : cList) {
    		c.loadComment(fileName);
    	}
	}

}