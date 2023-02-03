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
import a13_datebase.vo.Emp;

public class Books {
	static Scanner scan = new Scanner(System.in, "EUC-KR");
	static Books Bks = new Books();
	public static Connection con;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static ResultSet rs;
	public static String sisbn, sbname, sgenre, srrspublishern, swriter, srentalwhether, sregistdate, upbname, upgenre,
			uppublisher, upwriter, UpBookCheckWhe,selecGenre;
	public static int sprice, upprice, genrenum, upgenrenum;
	public static final String RESET = "\u001B[0m";
	public static final String YELLOW = "\u001B[33m";
	public static final String FONT_GREEN = "\u001B[36m";
	public static final String RED = "\u001B[31m";
	static Rental RDao = new Rental();
	static Ship sh = new Ship();

//=======================================================================================================================	
	public void registBook() { // 도서등록
		String sql = "INSERT INTO bookinfo values(?||to_char(Books_seq.nextval),?\r\n" + ",?,?\r\n" + ",?,?\r\n"
				+ ",SYSDATE,?)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			// System.out.println("등록 데이터:"+cnt);
			System.out.println(YELLOW+"<도서등록을 시작합니다. 아래 내용을 차례대로 입력해주세요>"+RESET);
			System.out.print(FONT_GREEN + "도서이름 입력:" + RESET);
			sbname = scan.nextLine();
			System.out.println();
			boolean bgenre = true;
			do {
				System.out.println("<아래 분류에 맞는 번호를 입력해주세요.");
				System.out.print("1.총류   2.철학   3.종교   4.사회과학\t");
				System.out.print("5.자연과학   6.기술과학   7.예술   8.언어\t");
				System.out.print("9.문학   10.역사\n");
				System.out.print(FONT_GREEN + "번호 입력:" + RESET);
				genrenum = scan.nextInt();
				if (genrenum == 1) {sgenre = "총류";sisbn = "000-";bgenre = false;} 
				else if (genrenum == 2) {sgenre = "철학";sisbn = "100-";bgenre = false;} 
				else if (genrenum == 3) {sgenre = "종교";sisbn = "200-";bgenre = false;} 
				else if (genrenum == 4) {sgenre = "사회과학";sisbn = "300-";bgenre = false;} 
				else if (genrenum == 5) {sgenre = "자연과학";sisbn = "400-";bgenre = false;} 
				else if (genrenum == 6) {sgenre = "기술과학";sisbn = "500-";bgenre = false;} 
				else if (genrenum == 7) {sgenre = "예술";sisbn = "600-";bgenre = false;} 
				else if (genrenum == 8) {sgenre = "언어";sisbn = "700-";bgenre = false;} 
				else if (genrenum == 9) {sgenre = "문학";sisbn = "800-";bgenre = false;} 
				else if (genrenum == 10) {sgenre = "역사";sisbn = "900-";bgenre = false;} 
				else {System.out.println(RED + "!!" + RESET + "입력가능한 분류가 아닙니다." + RED + "!!" + RESET);}
			} while (bgenre);
			System.out.print(FONT_GREEN + "출판사 입력:" + RESET);
			srrspublishern = scan.next();
			System.out.print(FONT_GREEN + "저자 입력:" + RESET);
			swriter = scan.next();
			System.out.print(FONT_GREEN + "가격 입력:" + RESET);
			sprice = scan.nextInt();
			srentalwhether = "대여가능";

			pstmt.setString(1, sisbn);
			pstmt.setString(2, sbname);
			pstmt.setString(3, sgenre);
			pstmt.setString(4, srrspublishern);
			pstmt.setString(5, swriter);
			pstmt.setInt(6, sprice);
			pstmt.setString(7, srentalwhether);
			rs = pstmt.executeQuery();
			con.commit();
			System.out.println(YELLOW + "도서등록완료. 감사합니다!" + RESET);
		} catch (SQLException e) {
			System.out.println("DB처리:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기다예외:" + e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		scan.nextLine();
	}

//=======================================================================================================================
	public void SchBookName_ISBN(String isbn) { // 도서 수정/삭제 전 확인용,도서정보 조건 조회
		try {
			con = DB.con();
			String sql = "SELECT * FROM BOOKINFO b \r\n" + "WHERE ISBN ='" + isbn + "'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			System.out.println(YELLOW + "------------------------------------------" + RESET + "<해당 도서 정보>" + YELLOW
					+ "------------------------------------------" + RESET);
			System.out.print("<도서번호:" + rs.getString("isbn") + " | ");
			System.out.print("도서제목:" + rs.getString("bname") + " | ");
			System.out.print("분류:" + rs.getString("genre") + " | ");
			System.out.print("출판사:" + rs.getString("publisher") + " | ");
			System.out.print("저자:" + rs.getString("writer") + " | ");
			System.out.print("가격:" + rs.getInt("price") + " | ");
			System.out.print("대여상태:" + rs.getString("rentalwhether") + "\n");
			System.out.println(YELLOW
					+ "-----------------------------------------------------------------------------------------------"
					+ RESET);
			UpBookCheckWhe = rs.getString("rentalwhether");

			DB.close(rs, stmt, con);
		} catch (SQLException e) {
			// System.out.println("DB처리예외:"+e.getMessage());
		} catch (Exception e) {
			// System.out.println("기타예외:"+e.getMessage());
		}
	}

//--------------------------------------------------------------------------------------------------------------	
	public void updateBook() { // 도서수정
		// 책이름뜨게하기..
		System.out.println(YELLOW+"수정을 위해, 아래 내용을 입력해주세요."+RESET);
		System.out.print(FONT_GREEN + "수정할 책의 도서등록번호:" + RESET);
		sisbn = scan.next();
		Bks.SchBookName_ISBN(sisbn);
		if (UpBookCheckWhe.equals("대여가능")) {
			System.out.println(YELLOW + "<도서 정보 수정 시작합니다.>" + RESET);
			System.out.print(FONT_GREEN + "도서 이름:" + RESET);
			upbname = scan.next();
			System.out.print(FONT_GREEN + "출판사:" + RESET);
			uppublisher = scan.next();
			System.out.print(FONT_GREEN + "저자 이름:" + RESET);
			upwriter = scan.next();
			System.out.print(FONT_GREEN + "도서 가격:" + RESET);
			upprice = scan.nextInt();
			
			String sql="UPDATE BOOKINFO \r\n"
					+ "SET BNAME ='"+upbname+"',\r\n"
					+ "	publisher='"+uppublisher+"',\r\n"
					+ "	writer='"+upwriter+"',\r\n"
					+ "	price="+upprice+",\r\n"
					+ "	registdate=SYSDATE  \r\n"
					+ "WHERE isbn='"+sisbn+"'";
			try {
				con = DB.con();
				// autocommit:false
				con.setAutoCommit(false);
				stmt = con.createStatement();
				int cnt = stmt.executeUpdate(sql);
				System.out.println(YELLOW + "수정완료 되었습니다. 감사합니다." + RESET);
				con.commit();
			} catch (SQLException e) {
				System.out.println("DB처리:" + e.getMessage());
				try {
					con.rollback();
				} catch (SQLException e1) {
					System.out.println("rollback에러:" + e1.getMessage());
				}
			} catch (Exception e) {
				System.out.println("기다예외:" + e.getMessage());
			} finally {
				DB.close(rs, stmt, con);
			}
		} else {
			System.out.println(RED + "!!" + RESET + "해당 도서는 대여중이므로, 정보 수정이 불가합니다." + RED + "!!" + RESET);
		}
	}

//========================================================================================================================
	public void deleteBook() { // 도서삭제
		System.out.print(FONT_GREEN + "삭제할 도서의 ISBN 입력:" + RESET);
		sisbn = scan.next();
		Bks.SchBookName_ISBN(sisbn);
		String sql = "DELETE BOOKINFO\r\n" + "WHERE isbn = '" + sisbn + "'";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			int delcnt = stmt.executeUpdate(sql);
			if (delcnt >= 1) {
				System.out.println(YELLOW + "삭제가 성공적으로 처리되었습니다!" + RESET);
			} else if (delcnt >= 0) {
				System.out.println(RED + "!!" + RESET + "해당 도서가 존재하지 않습니다. 확인 후 다시 시도해주세요" + RED + "!!" + RESET);
			}
			con.commit();
		} catch (SQLException e) {
			// System.out.println("DB처리:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기다예외:" + e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
	}

//=======================================================================================================================
	public List<BookVO> schBook_Name(String name) { // 단어로 도서찾기
		List<BookVO> dlist = new ArrayList<BookVO>();
		String sql = "SELECT * FROM BOOKINFO\r\n" + "WHERE bname LIKE '%'||?||'%'";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery(); // sql넣지않기 주의!
			while (rs.next()) {
				dlist.add(new BookVO(rs.getString("isbn"), rs.getString("bname"), rs.getString("genre"),
						rs.getString("publisher"), rs.getString("writer"), rs.getInt("price"),
						rs.getString("rentalwhether")));
			}
		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return dlist;
	}

	public void showBook_Name_print() { // 단어로 도서목록검색 출력
		System.out.println(YELLOW+"입력 단어로 도서 제목을를 검색합니다."+RESET);
		System.out.print(FONT_GREEN + "입력:" + RESET);
		String bb = scan.next();
		for (BookVO b : Bks.schBook_Name(bb)) {
			System.out.print("<도서번호:" + b.getIsbn() + " | ");
			System.out.print("도서제목:" + b.getBname() + " | ");
			System.out.print("장르:" + b.getGenre() + " | ");
			System.out.print("출판사:" + b.getPublisher() + " | ");
			System.out.print("저자:" + b.getWriter() + " | ");
			System.out.print("가격:" + b.getPrice() + " | ");
			System.out.print("대여여부:" + b.getRentalwhether() + ">\n");
		}
	}

//==========================================================================================================================
	public List<BookVO> SchBookAllList(BookVO bookVO) { // 도서목록 전체 조회
		List<BookVO> blist = new ArrayList<BookVO>();
		String sql = "SELECT * FROM BOOKINFO";

		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery(); // sql넣지않기 주의!
			while (rs.next()) {
				blist.add(new BookVO(rs.getString("isbn"), rs.getString("bname"), rs.getString("genre"),
						rs.getString("publisher"), rs.getString("writer"), rs.getInt("price"),
						rs.getString("rentalwhether")));
			}
		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return blist;
	}

	public void showBookAllList() { // 도서목록 전체 조회 출력
		List<BookVO> BookList = Bks.SchBookAllList(new BookVO());
		for (BookVO e : BookList) {
			System.out.print("<도서번호:" + e.getIsbn() + " | ");
			System.out.print("도서제목:" + e.getBname() + " | ");
			System.out.print("장르:" + e.getGenre() + " | ");
			System.out.print("출판사:" + e.getPublisher() + " | ");
			System.out.print("저자:" + e.getWriter() + " | ");
			System.out.print("가격:" + e.getPrice() + " | ");
			System.out.print("대여여부:" + e.getRentalwhether() + ">\n");
		}
	}

//=====================================================================================================================
	public List<BookVO> schBook_Genre(String genre) { //분류별 도서목록 저장
		List<BookVO> dlist = new ArrayList<BookVO>();
		String sql = "SELECT * FROM BOOKINFO b \r\n"
				+ "WHERE GENRE = ?";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, genre);
			rs = pstmt.executeQuery(); // sql넣지않기 주의!
			while (rs.next()) {
				dlist.add(new BookVO(rs.getString("isbn"), rs.getString("bname"), rs.getString("genre"),
						rs.getString("publisher"), rs.getString("writer"), rs.getInt("price"),
						rs.getString("rentalwhether")));
			}
		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return dlist;
	}
//------------------------------------------------------------------------------------------------------------------------
	public void showBook_Genre_print() { // 분류별 도서목록 출력
		
		System.out.println(YELLOW+"원하는 도서 장르번호를 입력해주세요."+RESET);
		System.out.print("<1.총류   2.철학   3.종교   4.사회과학\t");
		System.out.print("5.자연과학   6.기술과학   7.예술   8.언어  ");
		System.out.print("9.문학   10.역사>\n");
		boolean showGenre = true;
		do {
		System.out.print(FONT_GREEN + "입력:" + RESET);
		int selecGenrenum= scan.nextInt();
		if (selecGenrenum == 1) {selecGenre = "총류";showGenre = false;} 
		else if (selecGenrenum == 2) {selecGenre = "철학";showGenre = false;} 
		else if (selecGenrenum == 3) {selecGenre = "종교";showGenre = false;} 
		else if (selecGenrenum == 4) {selecGenre = "사회과학";showGenre = false;} 
		else if (selecGenrenum == 5) {selecGenre = "자연과학";showGenre = false;} 
		else if (selecGenrenum == 6) {selecGenre = "기술과학";showGenre = false;} 
		else if (selecGenrenum == 7) {selecGenre = "예술";showGenre = false;} 
		else if (selecGenrenum == 8) {selecGenre = "언어";showGenre = false;} 
		else if (selecGenrenum == 9) {selecGenre = "문학";showGenre = false;} 
		else if (selecGenrenum == 10) {selecGenre = "역사";showGenre = false;} 
		else {System.out.println(RED + "!!" + RESET + "입력가능한 분류가 아닙니다." + RED + "!!" + RESET);}
		}while(showGenre);
		for (BookVO b : Bks.schBook_Genre(selecGenre)){
			System.out.print(b.getIsbn() + "\t");
			System.out.print(b.getBname() + "\t");
			System.out.print(b.getGenre() + "\t");
			System.out.print(b.getPublisher() + "\t");
			System.out.print(b.getWriter() + "\t");
			System.out.print(b.getPrice() + "\t");
			System.out.print(b.getRentalwhether() + "\n");
		}
	}

//========================================================================================================================
	public static void main(String[] args) {
		Bks.showBook_Genre_print();

	}
}
