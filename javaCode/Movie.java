import java.util.ArrayList;

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
        return "Movie [title=" + title + ", year=" + year + ", genre=" + genre + "]";
    }

    @Override
    public int compareTo(Object m) {
        return toString().compareTo(m.toString());
    }

    public void addComment(Comment com) {
        comments.add(com);
    }

}
