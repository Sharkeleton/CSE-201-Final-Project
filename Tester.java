import java.io.FileNotFoundException;
import java.util.Collections;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		MovieDatabase movies = new MovieDatabase("Movie.txt");
		MovieCompareByTitle a = new MovieCompareByTitle();
		movies.sortMovies();
		movies.getAllMovies();
	}

}