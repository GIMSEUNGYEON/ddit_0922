package HotelHDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HotelUtil {
	static ResourceBundle bundle;
	
	static {
		bundle = ResourceBundle.getBundle("db");
		
		try {
			Class.forName(bundle.getString("driver"));
			
			System.out.println("드라이버 로딩 완료!");

		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!!!");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(bundle.getString("url"), 
					   bundle.getString("username"), 
					   bundle.getString("userpass"));
			} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) try {rs.close();} catch(SQLException e){e.printStackTrace();}
		if(stmt != null) try {stmt.close();} catch(SQLException e){e.printStackTrace();}
		if(pstmt != null) try {pstmt.close();} catch(SQLException e){e.printStackTrace();}
		if(conn != null) try {conn.close();} catch(SQLException e){e.printStackTrace();}
	}
	public static void main(String[] args) {
		
	}
}
