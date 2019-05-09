import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Movie implements Comparable {
    // Private variables -----------------------------------------------------
    private int movieID;
    private String title;
    private int year;
    private String genre;
    private ArrayList<Comment> comments = new ArrayList<Comment>();

    // Constructors ----------------------------------------------------------

    // Constructor for creating a movie
    public Movie(int movieID, String title, int year, String genre) {
        this.movieID = movieID;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    // Default constructor where all values are null/default
    public Movie() {
    }
    
    public void loadMovie(String fileName) throws IOException {
        String movieInfo = movieID + "\t" + title + "\t" + year + "\t" + genre;
        if (isNewMovie(movieInfo, fileName)) {
            File log = new File(fileName);
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append(movieInfo + "\n");
            out.close();
        }
    }

    private boolean isNewMovie(String movieInfo, String fileName) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(fileName));
        while (scn.hasNextLine()) {
            String line = scn.nextLine();
            if (line.equals(movieInfo)) {
                scn.close();
                return false;
            }
        }
        scn.close();
        return true;
    }

    // Methods ---------------------------------------------------------------

    // GETTER methods
    public int getMovieID() {
        return movieID;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    // toString method
    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Object m) {
        return toString().compareTo(m.toString());
    }
    

    public void addComment(Comment com) {
        comments.add(com);
    }
    
    public void removeMovie(String fileName) throws IOException {
    	ArrayList<Movie> mList = new ArrayList<Movie>();
    	File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String curLine = sc.nextLine();
            String[] splitted = curLine.split("\t");
            System.out.println(splitted[0]);
            if(Integer.parseInt(splitted[0]) != movieID) {
            Movie mov = new Movie(	Integer.parseInt(splitted[0]), // movieID
				                    splitted[1], // title
				                    Integer.parseInt(splitted[2]), // year
				                    splitted[3] // genre
            );
            mList.add(mov);
            }
        }
        sc.close();
        updateFile(mList, fileName);
    }
    private void updateFile(ArrayList<Movie> mList, String fileName) throws IOException {
    	PrintWriter empty = new PrintWriter(new File(fileName));
    	empty.print("");
    	for(Movie m : mList) {
    		m.loadMovie(fileName);
    	}
	}

}