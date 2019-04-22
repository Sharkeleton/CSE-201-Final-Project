public class Comment {
    
	private User user;
	private String com;
	
	
	public Comment(String comment, User user) {
		user = this.user;
		comment = this.com;
	}


	public User getUser() {
		return user;
	}

	public String getCom() {
		return com;
	}


	public void setCom(String com) {
		this.com = com;
	}


	@Override
	public String toString() {
		return "Comment [com=" + com + "]";
	}
	
	
}
