package book_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import a13_datebase.DB;

public class Library {
	static Scanner scan = new Scanner(System.in,"EUC-KR");
	static Library Ly = new Library();
	public static Connection con;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static ResultSet rs;	
	public static final String RESET = "\u001B[0m";
	public static final String FONT_GREEN = "\u001B[32m"; 
	
	public List<LibraryVo> LibraryAllList(LibraryVo libraryvo){ //도서관 목록 리스트에 담기
		List<LibraryVo> Llist = new ArrayList<LibraryVo>();
		String sql = "SELECT * FROM library";
		
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			
			rs= pstmt.executeQuery(); //sql넣지않기 주의!
			while(rs.next()) {
				Llist.add(new LibraryVo(
						rs.getString("local"),
						rs.getString("libraryname")	
						));
			}
			System.out.println("데이터 건수:"+Llist.size());
			//System.out.println(blist);
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return Llist;
	}
	
	public void showLibrary_print() { //도서관 목록 리스트 출력
		System.out.println(FONT_GREEN+"*---------------------------"+RESET+"<도서관 전체목록 조회>"+FONT_GREEN+"-------------------------------*"+RESET);
		for (LibraryVo l : Ly.LibraryAllList(new LibraryVo())) {
			System.out.print(l.getLocal() + "\t");
			System.out.print(l.getLibraryname() + "\n");
		}
		System.out.println(FONT_GREEN+"*---------------------------"+RESET+"<도서관 전체목록 끝!!>"+FONT_GREEN+"-------------------------------*"+RESET);
	}	
//==========================================================================================
	public static void main(String[] args) {
		System.out.println("<도서관 전체목록 조회>");
		for(LibraryVo l: Ly.LibraryAllList(new LibraryVo())) {
			System.out.print(l.getLocal()+"\t");
			System.out.print(l.getLibraryname()+"\n");}
	}

}
