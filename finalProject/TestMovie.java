
import static org.junit.Assert.*;

import org.junit.Test;

//import Movie;

public class TestMovie {

	@Test // Test ID of movie
	public void testMovieID() {
	
		Movie test = new Movie(20,"Little Fockers",2010	,"Comedy");
		int output = test.getMovieID();
		assertEquals(20,output);
		
	}
	@Test // Test title
	public void testMovieTitle() {
		Movie test = new Movie(20,"Little Fockers",2010	,"Comedy");
		String output = test.getTitle();
		assertEquals("Little Fockers",output);
	}
	
	@Test // Test Year
	public void testMovieYear() {
		Movie test = new Movie(20,"Little Fockers",2010	,"Comedy");
		int output = test.getYear();
		assertEquals(2010,output);
	}
	
	@Test // Test Genre
	public void testMovieGenre() {
		Movie test = new Movie(20,"Little Fockers",2010	,"Comedy");
		String output = test.getGenre();
		assertEquals("Comedy",output);
	}}