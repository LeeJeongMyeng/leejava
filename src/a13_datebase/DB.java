package a13_datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	//연결처리 객체
	//DB.con();
	public static Connection con() throws SQLException {
		Connection con = null;
		//1. 메모리 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("드라이버 로딩성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//System.out.println("드라이버 에러:"+e.getMessage());
		}
		//2.연결 정보처리
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		con= DriverManager.getConnection(info,"scott","tiger");
		//System.out.println("연결성공");
		return con;
	}
	
	//DB.close();
		public static void close(ResultSet rs,Statement stmt,Connection con) {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("연결종료 예외발생:"+e.getMessage());
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("ResultSet:"+e.getMessage());
					}
				}
				if(stmt!=null) {
					try {
						stmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("Statement:"+e.getMessage());
					}
				}
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("Connection:"+e.getMessage());
					}
				}
			}
			
		}
	
}


