import java.io.FileNotFoundException;
import java.io.IOException;

public class Tester {

	public static void main(String[] args) throws IOException {
		
		Movie m = new Movie(1000, "zzzzz", 2019, "Comedy");
		MovieDatabase movies = new MovieDatabase();
		movies.addMovie(m);
		movies.addMovie("MOCK_DATA (2).txt");
		
		
		movies.getAllMovies();
		System.out.println("break");
		System.out.println("break");
		System.out.println("break");
		System.out.println("break");
		System.out.println(movies.getMoviesByKey("20", "year"));
		System.out.println("break");
		System.out.println("break");
		System.out.println("break");
		System.out.println("break");
		System.out.println(movies.getMoviesByKey("2000", "year"));
		System.out.println("break");
		System.out.println("break");
		System.out.println("break");
		System.out.println("break");
		System.out.println(movies.getMoviesByKey("the", "title"));
		System.out.println("break");
		System.out.println("break");
		System.out.println("break");
		System.out.println("break");
		movies.sortMovies();
		movies.getAllMovies();
		
		User user1 = new User("Adam", "b", "c", "pass");
		User user2 = new User("Adam", "b", "c", "pas");
		User user3 = new User("Adam", "b", "c", "pass");
		User user = new User("Adam", "b", "c", "passsss");
	}

}
