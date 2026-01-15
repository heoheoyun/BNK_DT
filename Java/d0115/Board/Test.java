package d0115.Board;

public class Test {
	
	public static void main(String[] args) {
		
		Board board1 = new Board("test제목1", "test내용1", "admin");
		Board board2 = new Board("test제목2", "test내용2", "admin");
		Board board3 = new Board("test제목3", "test내용3", "admin");
		
		BoardDB db = new BoardDB();
		BoardCRUD crud = new BoardCRUD();
		
		crud.insert(db, board1);
		crud.insert(db, board2);
		crud.insert(db, board3);
		crud.selectList(db);
		
		System.out.println(crud.select(db,1, 2));
	}
}
