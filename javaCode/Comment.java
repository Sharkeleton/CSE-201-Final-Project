public class Comment {
    
	private Person person;
	private String com;
	
	
	public Comment(String comment, Person person) {
		person = this.person;
		comment = this.com;
	}


	public User getPerson() {
		return person;
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
