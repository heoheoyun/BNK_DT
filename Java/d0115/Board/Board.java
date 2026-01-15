package d0115.Board;

public class Board {
	static int board_count = 0;
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	
	public Board(String title, String content, String writer) {
		board_count++;
		bno = board_count;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	public Integer getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "번호 : " + bno + " ㅣ  제목 : " + title + " ㅣ  작성자 : " + writer;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!obj.getClass().equals(Board.class)) {
			System.out.println("게시글이 아닙니다.");
			return false;
		} 
		Board board = (Board) obj;
		if (board.equals(null)) {
			System.out.println("게시글이 비어있습니다.");
		}
		return  bno == board.getBno() && title.equals(board.getTitle()) && content.equals(board.getTitle()) && writer.equals(board.getWriter());
	}
	
}
