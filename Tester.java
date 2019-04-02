import java.io.FileNotFoundException;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		MovieDatabase movies = new MovieDatabase("movies_db.txt");
		movies.getAllMovies();
		System.out.println("break");
		System.out.println(movies.getMoviesByKey("20", "year"));
	}

}
