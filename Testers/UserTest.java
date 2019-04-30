import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testUser() throws IOException {
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
	

}
