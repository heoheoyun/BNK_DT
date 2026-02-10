package Library;

public class Log {
	private int log;
	private Book book;
	private User user;
	
	Log(int log, Book book, User user) {
		this.log = log;
		this.book = book;
		this.user = user;
	}
	
	public int getLog() {
		return log;
	}
	public Book getBook() {
        return book;
    }
    public User getUser() {
        return user;
    }
	
	@Override
	public String toString() {
		return "[ 책 번호 : " + book.getBno() + ", 이용자 : " + user.getId() + "상황 : " + book.getLoanable();
	}
}
