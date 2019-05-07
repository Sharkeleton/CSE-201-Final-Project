package cse201;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

import cse201.Comment;
import org.junit.Test;
public class UserTest1 {


	private MovieDatabase filePath;
	private MovieDatabase movieList;
	private ArrayList<Comment> needApprovedComments = new ArrayList<Comment>();

	@Test
	 public void testUser() throws IOException {
		User user= new User("a","b","c","d","dd");
		String result = user.getFirstName();
		String result2 = user. getLastName();
		String result3 = user.getUserName();
		String result4 = user.getPassword();
		
		assertTrue("a".equals(result));
		assertTrue("b".equals(result2));
		assertTrue("c".equals(result3));
		assertTrue("d".equals(result4));
	}
	@Test
	public <string> void testAddcomment() throws IOException {
		MovieDatabase movs = new MovieDatabase();
		User user1= new User("a","b","c","d","dd");
		Movie m = new Movie(200,"Little Fockers",2010	,"Comedy");
		Comment c = new Comment("good" , user1 , 200);
		movs.loadUserData("users.txt");
		movs.addMovie(m);
		movs.addComment(c);
		String result = movs.getNeedApprovedComments().get(0).toString();
		assertEquals(c.toString(),result);
		//System.out.println(movs.getNeedApprovedComments().get(0).toString());
		}
	
	@Test
	public <string> void testUserBackend() throws IOException {
		User user1= new User("a","b","c","d","abc");
		MovieDatabase movs = new MovieDatabase();
		movs.loadUserData("users.txt");
		User result = movs.checkUserPass("c", "d", "users.txt");
		assertEquals(result.getUserName(),user1.getUserName());
		assertEquals(result.getPassword(), user1.getPassword());
	}
	
		
	}

