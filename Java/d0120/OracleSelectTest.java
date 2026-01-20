package d0120;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleSelectTest {
	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:oracle:thin:@//localhost:1521/testdb";
		String user = "green";
		String password = "1234";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT id, name FROM testTbl");
		
		while(rs.next()) {
			System.out.println(
					rs.getInt("id" ) + " " + 
					rs.getString("name")
			);
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
