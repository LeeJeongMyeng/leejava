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
import a13_datebase.vo.Dept;

public class Program {
	static Scanner scan = new Scanner(System.in,"EUC-KR");
	public static Connection con;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static ResultSet rs;
	public static String Programname,Programdate,ProgramManager,ProgramExplan,Prouserno,Programno;
	 public static final String RESET = "\u001B[0m";
	 public static final String YELLOW = "\u001B[33m";
	 public static final String FONT_GREEN = "\u001B[36m"; 
	 public static final String RED      = "\u001B[31m" ;
	static Program pg=new Program();
	
//========================================================================================================
	public void insertPro(String userno) { //주간프로그램 등록
		System.out.println("주간프로그램 등록을 위해 아래 내용들을 작성해주세요.");
		System.out.print(FONT_GREEN+"주간프로그램 이름:"+RESET);
		Programname=scan.next();
		System.out.println("프로그램 진행 날짜(2000-01-01)형식으로 입력해주세요.)");
		System.out.print(FONT_GREEN+"입력:"+RESET);
		Programdate=scan.next();
		scan.nextLine(); 
		System.out.print(FONT_GREEN+"프로그램 설명:"+RESET);
		ProgramExplan=scan.nextLine();

		
		String sql = "INSERT INTO PROGRAM VALUES ('P'||program_seq.nextval,?,to_date(?,'yyyy-mm-dd'),?,?)";
		try {
			con=DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,Programname);
			pstmt.setString(2,Programdate);
			pstmt.setString(3,userno);
			pstmt.setString(4,ProgramExplan);
			
			
			pstmt.executeQuery();
			System.out.println(YELLOW+"주간프로그램 공지 등록이 완료되었습니다. 감사합니다"+RESET);
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("DB에러"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("롤백에러:"+e.getMessage());
			}
		}catch (Exception e) {
			System.out.println("기타에러"+e.getMessage());
		} finally {DB.close(rs, pstmt, con);}
		
	}
//=============================================================================================================
	public void DeleteProgramAll() { //삭제 전체기능
		pg.ProgramAllPrint();
		System.out.println("해당목록중 삭제할 프로그램이 있습니까? (1.예 2.아니오)");
		System.out.print(FONT_GREEN+"번호로 입력:"+RESET);
		int selectDelete = scan.nextInt();
		if(selectDelete==1) {
			System.out.print(FONT_GREEN+"삭제할 프로그램번호 입력(P는 만드시 대문자):"+RESET);
			String DeleteProNum = scan.next();
			pg.deletePro(DeleteProNum);
			System.out.println(RED+"!!"+RESET+"해당 주간프로그램이 목록에서 삭제되었습니다."+RED+"!!"+RESET);
		}else {System.out.println(RED+"!!"+RESET+"삭제를 취소합니다."+RED+"!!"+RESET);}
	}
//-------------------------------------------------------------------------------------------------------------
	public void deletePro(String userno) { //주간프로그램 공지 삭제
		String sql = "DELETE PROGRAM WHERE PRONO =?";
		try {
			con=DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userno);
			
			pstmt.executeQuery();
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("DB에러"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("롤백에러:"+e.getMessage());
			}
		}catch (Exception e) {
			System.out.println("기타에러"+e.getMessage());
		} finally {DB.close(rs, pstmt, con);}
		
	}
//-------------------------------------------------------------------------------------------------------------
	public List<ProgramVO> ProgramAllList(ProgramVO sch){ //공지사항 전체 조회처리
		List<ProgramVO> prolist = new ArrayList<ProgramVO>();
		String sql = "SELECT * FROM PROGRAM p ";
		
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			
			
			rs= pstmt.executeQuery(); //sql넣지않기 주의!
			while(rs.next()) {
				prolist.add(new ProgramVO(
						rs.getString("prono"),
						rs.getString("proname"),
						rs.getString("prodate"),
						rs.getString("userno"),
						rs.getString("proexplan")
							));
			}
			System.out.println("데이터 건수:"+prolist.size());
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}return prolist;}
//-------------------------------------------------------------------------------------------------------------	
	public void ProgramAllPrint() { //공지사항 전체 출력
		for(ProgramVO rv:pg.ProgramAllList(new ProgramVO())) {
			System.out.print("<프로그램번호:"+rv.getProno()+"  |  ");
			System.out.print("프로그램이름:"+rv.getProname()+"  |  ");
			System.out.print("프로그램 진행날짜:"+rv.getProdate()+"  |  ");
			System.out.print("담당매니저:"+rv.getUserno()+">\n");
			System.out.print("<프로그램 내용:"+rv.getProexplan()+">\n");
			System.out.println();
		}
	}
//=============================================================================================================	
	public void BookKing_Top3() { //독서왕 top3조회
		try {
			con = DB.con();
			String sql = "SELECT USERNO ,USERNAME ,RENTALCNT,RETURNWARNING\r\n"
					+ "FROM (\r\n"
					+ "SELECT USERNO ,USERNAME ,RENTALCNT,RETURNWARNING  FROM BOOKUSER \r\n"
					+ "WHERE RETURNWARNING < 5\r\n"
					+ "AND div = '회원'\r\n"
					+ "ORDER BY RENTALCNT DESC)\r\n"
					+ "WHERE rownum<=3";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // sql넣지않기 주의!
			System.out.println(YELLOW+"-----------------<[독서왕] 3명 목록 입니다.>--------------------"+RESET);
			
			for(int cnt=1;cnt<4;cnt++) {
			rs.next();
				System.out.print(cnt+"등!! <회원번호:" + rs.getString(1) + " | ");
				System.out.print("회원이름:" + rs.getString(2) + " | ");
				System.out.print("대여횟수:" + rs.getInt(3) + " | ");
				System.out.print("연체경고횟수: " + rs.getInt(4) + "\n");
			}
		} catch (SQLException e) {
			System.out.println("DB처리예외:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타예외:" + e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		} System.out.println(YELLOW+"----------------------!!!축하합니다!!!-----------------------"+RESET);
	}
	public static void main(String[] args) {
		//pg.insertPro();
		pg.BookKing_Top3();
	}

}
