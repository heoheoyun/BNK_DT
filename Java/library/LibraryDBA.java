package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LibraryDBA {
	
	private String url = "jdbc:oracle:thin:@//192.168.0.88:1521/testdb";
	private String user = "green";
	private String pw = "1234";
	private Connection con;
	private PreparedStatement pstmt;
	private String sql;
	
	public LibraryDBA() throws Exception {
		con = DriverManager.getConnection(url, user, pw);
	}

	// ---------------- [ 회원 관련 기능 ] ----------------
	
	//회원 등록 기능(회원 가입 기능에 사용)
	public void userInsert(User user) throws Exception {
		sql ="INSERT INTO luser (u_id, u_pw, u_name) Values (?, ?, ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPw());
		pstmt.setString(3, user.getName());
		pstmt.executeUpdate();
	}
	
	//입력 받은 id와 pw를 테이블 내의 데이터와 대조하는 기능(로그인 기능에서 사용)
	public boolean check(User user) throws Exception {
		sql = "Select Count(*) as cnt from luser where u_id = ? and u_pw = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPw());
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		return rs.getInt("cnt") > 0;
	}
	
	//회원 정보 조회 기능 -1인- (회원 가입 기능, 로그인 기능, 탈퇴 처리 기능에서 사용)
	public User uSearch(String id) throws Exception {
		sql = "Select * From luser where u_id = ? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (!rs.next()) return null;
		return new User(rs.getString("u_id"),
						rs.getString("u_pw"),
						rs.getString("u_name"));
	}

	//비밀번호 변경 기능 (비밀번호 변경 기능에서 사용)
    public void updatePw(String id, String newPw) throws Exception {
        sql = "UPDATE luser SET u_pw = ? WHERE u_id = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, newPw);
        pstmt.setString(2, id);
        pstmt.executeUpdate();
    }

	//탈퇴 요청 기능 (탈퇴 요청 기능에서 사용)
    public void requestWithdrawal(String id, String reason) throws Exception {
        sql = "UPDATE luser SET u_reason = ? WHERE u_id = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, reason);
        pstmt.setString(2, id);
        pstmt.executeUpdate();
    }

	//회원 삭제 기능 (관리자용) (탈퇴 처리 기능에서 사용)
    public void userDelete(String uid) throws Exception {
        //정보 삭제 없이 실행하면 무결성 제약 조건 에러 발생함
        //해당 회원의 대출/반납 이력(Loan_Record)을 먼저 모두 삭제
        //대출 중이든 반납 완료든, 이 사람과 관련된 모든 기록 삭제
        String sql1 = "DELETE FROM Loan_Record WHERE u_id = ?";
        pstmt = con.prepareStatement(sql1);
        pstmt.setString(1, uid);
        pstmt.executeUpdate();
        pstmt.close();

        //이력이 깨끗해졌으므로 회원 정보 삭제
        String sql2 = "DELETE FROM luser WHERE u_id = ?";
        pstmt = con.prepareStatement(sql2);
        pstmt.setString(1, uid);
        pstmt.executeUpdate();
    }

    // 전체 회원 조회 기능 (관리자용 - 탈퇴 사유 포함) (회원 정보 확인 기능, 탈퇴 정보 확인 기능에서 사용)
    public ArrayList<User> getAllUsers() throws Exception {
        sql = "SELECT * FROM luser ORDER BY u_id";
        pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        ArrayList<User> list = new ArrayList<>();
        
        while(rs.next()){
            String id = rs.getString("u_id");
            String pw = rs.getString("u_pw");
            String name = rs.getString("u_name");
            String reason = rs.getString("u_reason"); // 탈퇴 사유가 없으면 null

            User u = new User(id, pw, name, reason);
            
            list.add(u);
        }
        return list;
    }

	// ---------------- [ 도서 관련 기능 ] ----------------

	//도서 검색 기능(1권) (도서 삭제, 등록, 대출 기능에서 사용)
	public Book bSearch(String bno) throws Exception {
        sql = "Select * from Books where b_no = ? ";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, bno);
        ResultSet rs = pstmt.executeQuery();
        Book book = null;
        if(rs.next()) {
            // DB의 b_inLibrary("Y" or "N") 값을 가져와서 Book 생성자에 전달
            book = new Book(rs.getString("b_no"), 
                            rs.getString("b_name"), 
                            rs.getString("b_publish"), 
                            rs.getString("b_author"), 
                            rs.getInt("b_cno"),
                            rs.getString("b_inLibrary"));
        }
        return book;
    }
	
	//도서리스트 출력 기능 (도서 검색 기능에서 사용)
	public ArrayList<Book> bSqlSearch(String sql) throws Exception {
        pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        ArrayList<Book> books = new ArrayList<Book>();
        while(rs.next()) {
            Book book = new Book(rs.getString("b_no"), 
                                 rs.getString("b_name"), 
                                 rs.getString("b_publish"),
                                 rs.getString("b_author"), 
                                 rs.getInt("b_cno"),
                                 rs.getString("b_inLibrary"));
            books.add(book);
        }
        return books;
    }

	//신규 도서 추가 기능(관리자용) (도서 등록 기능에서 사용)
	public void bookInsert(Book book) throws Exception {
		// b_inLibrary를 기본 값을 Y로 지정
		sql ="Insert into Books (b_no, b_name, b_publish, b_author, b_cno, b_inLibrary) Values(?,?,?,?,?,'Y')";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBno());
		pstmt.setString(2, book.getB_name());
		pstmt.setString(3, book.getPublish());
		pstmt.setString(4, book.getAuthor());
		pstmt.setInt(5, book.getCno());
		
		pstmt.executeUpdate();
	}
	
	//기존 도서를 삭제하는 기능(관리자용) (도서 삭제 기능에서 사용)
	public void bookDelete(Book book) throws Exception {
		sql ="Delete from Books where b_no = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBno());
		pstmt.executeUpdate();
	}
	
	// ---------------- [ 대출/반납 관련 기능 ] ----------------
	

	// 대출 실행 기능 (도서 대출 기능에서 사용)
    public void insertLoan(String uid, String bno) throws Exception {
        
        // 사용할 대출 번호(log)에서 가장 마지막 번호를 조회해서 +1을 해줍니다.
        sql = "SELECT Count(*) FROM Loan_Record";
        pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        int nextLogId = 1;
        if(rs.next()){
			// 가장 큰 번호(MAX)를 가져와서 1을 더함
			nextLogId += rs.getInt(1); 
		}
        rs.close();

        // 대출 기록 저장
        sql = "INSERT INTO Loan_Record (log, b_no, u_id, state) VALUES (?, ?, ?, '대출중')";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, nextLogId);
        pstmt.setString(2, bno);
        pstmt.setString(3, uid);
        pstmt.executeUpdate();

        // 책 상태를 '대출중(N)'으로 변경
        sql = "UPDATE Books SET b_inLibrary = 'N' WHERE b_no = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, bno);
        pstmt.executeUpdate();
    }

	// 반납 실행 기능 (도서 반납 기능에서 사용)
    public void returnBook(String uid, String bno) throws Exception {
        
        // Loan_Record의 상태를 '반납완료'로 수정
        // 조건: 내 아이디 + 해당 책 + 현재 '대출중'인 상태
        sql = "UPDATE Loan_Record SET state = '반납완료' " +
              "WHERE u_id = ? AND b_no = ? AND state = '대출중'";
              
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, uid);
        pstmt.setString(2, bno);
        
        int result = pstmt.executeUpdate(); // 수정 성공 갯수
        pstmt.close();

		// [디버깅용 출력] 이 값이 0이 나오면, 조건에 맞는 대출 기록을 못 찾은 것입니다.
    	// System.out.println("[DEBUG] 반납 처리된 행 개수: " + result);

        // 책 테이블 상태를 'Y'(대출가능)로 변경
        if(result > 0) {
            sql = "UPDATE Books SET b_inLibrary = 'Y' WHERE b_no = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bno);
            pstmt.executeUpdate();
        }
    }

	// 특정 책이 현재 대출 중인지 확인 ('N'이면 대출중) (도서 대출 기능에서 사용)
    public boolean isLoaned(String bno) throws Exception {
        sql = "SELECT b_inLibrary FROM Books WHERE b_no = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, bno);
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()) {
            String status = rs.getString("b_inLibrary");
            // "N"이랑 같으면 대출중이므로 true 반환
            rs.close();
            return "N".equals(status); 
        }
        rs.close();
        return false; 
    }

	//내가 현재 빌리고 있는 책인지 확인하는 기능 (도서 반납 기능에서 사용)
    public boolean checkMyLoan(String uid, String bno) throws Exception {
        // state가 '대출중'인 것만 카운트
        sql = "SELECT count(*) FROM Loan_Record WHERE u_id = ? AND b_no = ? AND state = '대출중'";
        
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, uid);
        pstmt.setString(2, bno);
        ResultSet rs = pstmt.executeQuery();
        
        rs.next();
        int i = rs.getInt(1);
        rs.close();
        return i > 0;
    }

	// 대출 기록(번호, 책, 유저) 조회 기능 (도서 반납 내역 및 조회 기능에서 사용)
    public ArrayList<Log> selectAllLogs() throws Exception {
        sql = "SELECT log, b_no, u_id FROM Loan_Record ORDER BY log DESC";
        pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<Log> logs = new ArrayList<>();
        
        while(rs.next()) {
            int logNo = rs.getInt("log");
            String bno = rs.getString("b_no");
            String uid = rs.getString("u_id");
            
            // 책과 유저 정보를 ID로 찾아서 객체로 만듦
            Book b = bSearch(bno); 
            User u = uSearch(uid);
            
            // 삭제된 책이나 회원이 아닐 경우에만 리스트에 추가
            if(b != null && u != null) {
                logs.add(new Log(logNo, b, u));
            }
        }
        rs.close();
        return logs;
    }

	//대출 도서 목록 출력 기능 (사용자 정보 출력 기능에서 사용)
	public ArrayList<Book> lbSearch(User user) throws Exception {
		sql = "Select b_no as no from Loan_Record where u_id = ? AND state = '대출중' order by b_no";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Book> books = new ArrayList<Book>();
		while(rs.next()) {
			books.add((bSearch(rs.getString("no"))));
		}
		rs.close();
		return books;
	}

    // 현재 회원이 대출 중인 도서 권수를 확인하는 기능
    public int getLoanCount(String uid) throws Exception {
        // 내 아이디(u_id)이면서, 현재 상태(state)가 '대출중'인 것의 개수(count)를 세라
        sql = "SELECT count(*) FROM Loan_Record WHERE u_id = ? AND state = '대출중'";
        
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, uid);
        ResultSet rs = pstmt.executeQuery();
        
        rs.next();
        int count = rs.getInt(1); // 숫자(개수)를 가져옴
        rs.close();
        
        return count; // 0, 1, 2, 3... 등의 숫자 반환
    }
	
	public void close() throws Exception{
	    if (pstmt != null) pstmt.close();
	    if (con != null) con.close();
	}
}
