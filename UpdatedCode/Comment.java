public class Comment {

    private User user;
    private String com;
    private int myComID;
    private int movieID;
    private static int commentID = 1;

    public Comment(String comment, User user, int movieID) {
        user = this.user;
        comment = this.com;
        movieID = this.movieID;
        myComID = commentID;
        ++commentID;
    }

    public User getUser() {
        return user;
    }

    public String getCom() {
        return com;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setCom(String com) {
        this.com = com;
    }

    @Override
    public String toString() {
        return "Comment [com=" + com + "]";
    }

}