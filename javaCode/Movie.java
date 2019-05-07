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
    	String ret = "Movie [title=" + title + ", year=" + year + ", genre=" + genre + "]" + "\n";
        for (Comment comment : comments) {
        	ret += comment.toString() + "\n";
        }
        return ret;
    }

    @Override
    public int compareTo(Object m) {
        return toString().compareTo(m.toString());
    }

    public void addComment(Comment com) {
        comments.add(com);
    }

}
