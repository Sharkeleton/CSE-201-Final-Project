import java.util.ArrayList;

public class Movie implements Comparable<Movie> {
	// Private variables -----------------------------------------------------
	private int movieID;
	private String title;
	private int year;
	private String genre;

	// Constructors ----------------------------------------------------------
	
	// Constructor for creating a movie
	public Movie(int movieID, String title, int year, String genre) {
		this.movieID = movieID;
		this.title = title;
		this.year = year;
		this.genre = genre;
	}
	
	// Default constructor where all values are null/default
	public Movie() {}

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
	
	// toString method
	public String toString() {
		return "Movie [movieID=" + movieID + ", title=" + title + ", year=" + year + ", genre=" + genre + "]";
	}

	public int compareTo(Movie movie) {
		return (this.getMovieID() < movie.getMovieID() ? -1:
			(this.getMovieID() == movie.getMovieID() ? 0 : 1));
	}
	
}