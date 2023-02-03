package book_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import a13_datebase.DB;
import a13_datebase.vo.Dept;
import a13_datebase.vo2.Emp04;

public class Ship {
	static Scanner scan = new Scanner(System.in,"EUC-KR");
	public static Connection con;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static ResultSet rs;
	public static String successship;
	static Rental RDao = new Rental();
	static Ship sh = new Ship();

	public void insertShip(String isbn) { // 대여 진행 시, 배송신청이면 배송테이블에 해당 정보 삽입
		String sql = "INSERT INTO ship \r\n"
				+ "SELECT 'Ship-'||ship_seq.nextval,sysdate+2,RENTALNO,USERNO FROM RENTAL\r\n"
				+ "WHERE isbn = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, isbn);

			
			pstmt.executeQuery();
			con.commit();
		} catch (SQLException e) {
			System.out.println("배달인 DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("베달인 기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}	
	}
	
//====================================================================================================================
	
	
	public static void main(String[] args) {
		
		
		
		
	}

}
