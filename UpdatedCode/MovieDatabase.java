import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class MovieDatabase {

    // Private variables -----------------------------------------------------

    // List to hold the current movies of the database
    private ArrayList<Movie> movieList = new ArrayList<Movie>();
    private ArrayList<Movie> needApprovedMovieList = new ArrayList<Movie>();
    private ArrayList<Comment> needApprovedComments = new ArrayList<Comment>();

    // Constructors ----------------------------------------------------------

    // Constructor for a Movie Database that already has a list of movies
    public MovieDatabase(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    // Constructor for a Movie Database from a text file
    public MovieDatabase(String filePath) throws FileNotFoundException {
        loadMovieData(filePath);
    }

    // Default constructor for a Movie database
    public MovieDatabase() {
    }

    // Methods ---------------------------------------------------------------

    // Loads data from a file into a Movie database
    private void loadMovieData(String filePath) throws FileNotFoundException {
        // Creating the file and scanner to read from the file (skips first line)
        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String curLine = sc.nextLine();
            String[] splitted = curLine.split("\t");
            Movie mov = new Movie(Integer.parseInt(splitted[0]), // movieID
                    splitted[1], // title
                    Integer.parseInt(splitted[2]), // year
                    splitted[3] // genre
            );
            movieList.add(mov);
        }
        sc.close();
    }

    // Returns all movies in the database
    public void getAllMovies() {
        for (Movie m : movieList) {
            System.out.println(m.toString());
        }
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public ArrayList<Movie> getNeedApprovedMovies() {
        return needApprovedMovieList;
    }

    public ArrayList<Comment> getNeedApprovedComments() {
        return needApprovedComments;
    }

    // Adds a movie to the database
    public void addMovie(Movie m) {
        movieList.add(m);
    }

    public void addMovie(String name) throws FileNotFoundException {
        loadMovieData(name);
    }
    
    public void addComment(Comment com) {
        getNeedApprovedComments().add(com);
    }

    public void addNewMovie(Movie mov) {
        getNeedApprovedMovies().add(mov);
    }

    public boolean approveMovie(int movieID) {
        // approving movie code
        movieList.add(getNeedApprovedMovies().get(movieID));
        getNeedApprovedMovies().remove(movieID);
        return true;
    }

    public boolean approveComment(MovieDatabase m, int commentID) {
        // approving comment code
        Comment newCom = m.getNeedApprovedComments().get(commentID);
        m.getMovieList().get(newCom.getMovieID()).addComment(newCom);
        m.getNeedApprovedComments().remove(commentID);
        return true;
    }

    // Returns a movie by its ID
    public Movie getMovieById(int id) {
        Movie mov = null;
        for (Movie m : movieList) {
            if (m.getMovieID() == id) {
                mov = m;
                break;
            }
        }
        return mov;
    }

    // Returns movies that have a keyword in its title
    public ArrayList<Movie> getMoviesByKey(String key, String type) {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for (Movie m : movieList) {
            // if user is looking for title
            if (type.equals("title")) {
                if (m.getTitle().toUpperCase().contains(key.toUpperCase())) {
                    movies.add(m);
                }
            }
            // if user is looking for genre
            if (type.equals("genre")) {
                if (m.getGenre().toUpperCase().contains(key.toUpperCase())) {
                    movies.add(m);
                }
            }
            if (type.equals("year")) {
                if (m.getYear() == Integer.parseInt(key)) {
                    movies.add(m);
                }
            }
        }
        return movies;
    }

    // Returns the list of movies sorted alphabetically
    public ArrayList<Movie> sortMovies() {
        Collections.sort(movieList);
        return movieList;
    }

    public void addUsers(String string) {
        // TODO Auto-generated method stub
        
    }
    
    public User checkUserPass(String u, String p, String filePath) throws IOException {
        Scanner scn = new Scanner(new File(filePath));
        while (scn.hasNextLine()) {
            String line = scn.nextLine();
            if (line.contains("\t" + u + "\t")) {
                int passIndex = line.indexOf(u) + u.length() + 1;
                String passCheck = line.substring(passIndex, line.indexOf("\t", passIndex));
                if (passCheck.equals(p)) {
                    String[] words = line.split("\\s+");
                    User correctUser = new User(words[0], words[1], words[2], words[3], words[4]);
                    correctUser.checkUser();
                    return correctUser;
                }
            }
        }
        return null;
    }

}