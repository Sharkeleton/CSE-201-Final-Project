import java.io.FileNotFoundException;
import java.io.IOException;

public class Tester {

    public static void main(String[] args) throws IOException {
        MovieDatabase movies = new MovieDatabase();
        movies.loadMovieData("MOCK_DATA.txt");
        System.out.println(movies.checkUserPass("kolivaf@drupal.org", "v8ftLsZajN7", "user.txt"));
    }

}
