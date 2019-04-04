

import java.util.Comparator;

public class MovieCompareByTitle implements Comparator<Movie> {
	
	@Override
	public int compare(Movie o1, Movie o2) {
		if(o1.getTitle().compareTo(o2.getTitle()) > 0) {
			return 1;
		} else if(o1.getTitle().compareTo(o2.getTitle()) == 0) {
			return 0;
		} else {
			return -1;
		}
	}

}
