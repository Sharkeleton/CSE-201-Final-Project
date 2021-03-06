import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

public class MovieDatabase {

	// Private variables -----------------------------------------------------

	// List to hold the current movies of the database
	private ArrayList<Movie> movieList = new ArrayList<Movie>();
	private ArrayList<User> userList = new ArrayList<User>();
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
	public void loadMovieData(String filePath) throws FileNotFoundException {
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

	public void loadUserData(String filePath) throws IOException {
		// Creating the file and scanner to read from the file (skips first line)
		File file = new File(filePath);
		Scanner sc = new Scanner(file);

		while (sc.hasNextLine()) {
			String curLine = sc.nextLine();
			String[] splitted = curLine.split("\t");
			User user = new User(splitted[0], splitted[1], splitted[2], splitted[3], splitted[4]);
			userList.add(user);
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
	public void addMovie(Movie m) throws IOException {
		movieList.add(m);
		addMovieToDatabase(m);
	}

	public void addMovieToDatabase(Movie m) throws IOException {
		String movieInfo = m.getMovieID() + "\t" + m.getTitle() + "\t" + m.getYear() + "\t" + m.getGenre();
		if (isNewMovie(m)) {
			File log = new File("Mock_Data.txt");
			PrintWriter out = new PrintWriter(new FileWriter(log, true));
			out.append(movieInfo + "\n");
			out.close();
		}
	}

	private boolean isNewMovie(Movie m) throws FileNotFoundException {
		String movieInfo = m.getMovieID() + "\t" + m.getTitle() + "\t" + m.getYear() + "\t" + m.getGenre();
		Scanner scn = new Scanner(new File("Mock_Data.txt"));
		boolean inFile = false;
		while (scn.hasNextLine()) {
			String line = scn.nextLine();
			if (line.equals(movieInfo)) {
				return false;
			}
		}
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
				if (m.getTitle().contains(key)) {
					movies.add(m);
				}
			}
			// if user is looking for genre
			if (type.equals("genre")) {
				if (m.getGenre().contains(key)) {
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
	public void sortMovies() {
		Collections.sort(movieList);
	}

	public User checkUserPass(String u, String p, String filePath) throws IOException {
		for (User user : userList) {
			if (user.getUserName().equals(u) && user.getPassword().equals(p)) {
				return user;
			}
		}
		return null;
	}
}
