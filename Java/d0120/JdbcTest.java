package d0120;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@//localhost:1521/testdb";
		String user = "green";
		String password = "1234";
		
		Connection conn = null;
		
		try {
			//Java 6버전 (JDBC 4.0) 이상부터 생략가능
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("Oracle DB 연결 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle JDBC 드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					System.out.println("DB 연결 종료");
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
