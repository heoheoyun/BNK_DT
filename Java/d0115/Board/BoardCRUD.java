package d0115.Board;

public class BoardCRUD {
	
	public void insert(BoardDB db , Board board) {
		db.getDB().add(board);
	}
	
	public void selectList(BoardDB db) {
		for(int i=0; i<db.getDB().size(); i++) {
			System.out.println(db.getDB().get(i).toString());
			System.out.println("===========================================================");
		}
	}
	
	public Board select(BoardDB db, int select, Object obj) {
		switch(select) {
			case 1 : 
				for(int i=0; i<db.getDB().size(); i++) {
					if(db.getDB().get(i).getBno().equals(obj)) return db.getDB().get(i);
				}
				break;
			case 2 : 
				for(int i=0; i<db.getDB().size(); i++) {
					if(db.getDB().get(i).getTitle().equals(obj)) return db.getDB().get(i);
				}
				break;
			case 3 :
				for(int i=0; i<db.getDB().size(); i++) {
					if(db.getDB().get(i).getContent().equals(obj)) return db.getDB().get(i);
				}
				break;
			case 4 :
				for(int i=0; i<db.getDB().size(); i++) {
					if(db.getDB().get(i).getWriter().equals(obj)) return db.getDB().get(i);
				}
				break;
			default :
				System.out.println(select + "의 검색 조건은 지원하지 않습니다.");
				return null;
		}
		System.out.println(obj + "의 해당하는 게시글이 없습니다.");
		return null;
	}
	
	
	public void modify(BoardDB db, Board board, Board board2) {
		for(int i=0; i<db.getDB().size(); i++) {
			if(db.getDB().get(i).equals(board)) {
				db.getDB().set(i, board2);
				return;
			}
		}
		System.out.println("수정할 내용을 찾지 못했습니다.");
	}
	
	public void delete(BoardDB db, Board board) {
		db.getDB().remove(board);
	}
}
