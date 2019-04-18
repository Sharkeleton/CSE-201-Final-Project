package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cse201.Movie;

public class TestMovie {

	@Test
	public void testMovieID() {
	
		Movie test = new Movie(1,"a",00,"comedy");
		int output = test.getMovieID();
		assertEquals(1,output);
		
	}
	@Test
	public void testMovieYear() {
		Movie test = new Movie(1,"a",00,"comedy");
		int output = test.getYear();
		assertEquals(00,output);
	}
	
	@Test
	public void testMovieGenre() {
		Movie test = new Movie(1,"a",00,"comedy");
		String output = test.getGenre();
		assertEquals("comedy",output);
	}
	
	@Test
	public void testMovieTitle() {
		Movie test = new Movie(1,"a",00,"comedy");
		String output = test.getTitle();
		assertEquals("a",output);
	}

}
