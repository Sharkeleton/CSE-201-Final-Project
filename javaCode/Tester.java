import java.io.FileNotFoundException;
import java.util.Collections;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		Movie m = new Movie(1,"A",2000,"Action");
		MovieDatabase movies = new MovieDatabase("Movie.txt");
		movies.addMovie(m);
		movies.getAllMovies();
		movies.getMovieById(2);
		movies.getMoviesByKey("A", "title");
		movies.getMoviesByKey("Action", "genre");
		movies.getMoviesByKey("2000", "year");
		movies.sortMovies();
	}

}
