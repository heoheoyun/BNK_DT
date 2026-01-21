package d0121;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBAccess {
	
	private String url = "jdbc:oracle:thin:@//localhost:1521/testdb";
	private String user = "green";
	private String pw = "1234";
	private Connection con;
	private PreparedStatement pstmt;
	private String sql;
	
	public DBAccess() throws Exception {
		
		con = DriverManager.getConnection(url, user, pw);
	}
	
	public void insert(Member member) throws Exception {
		sql ="INSERT INTO Member (id, pw, name) Values (?, ?, ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		pstmt.setString(3, member.getName());
		pstmt.executeUpdate();
	}
	
	public boolean check(Member member) throws Exception {
		sql = "Select Count(*) as cnt from Member where id = ? and pw = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		return rs.getInt("cnt") > 0;
	}
	
	public ResultSet searchAll() throws Exception {
		sql = "Select * From Member order by id";
		pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.close();
		return rs;
	}
	public ResultSet search(String id) throws Exception {
		sql = "Select * From Member where id = ? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeQuery();
	}
	
	public void update(Member member) throws Exception {
		sql = "Update Member set name = ?, pw = ? where id = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, member.getName());
		pstmt.setString(2, member.getPw());
		pstmt.setString(3, member.getId());
		pstmt.executeUpdate();
	}
	
	public void close() throws Exception{
	    if (pstmt != null) pstmt.close();
	    if (con != null) con.close();
	}
}
