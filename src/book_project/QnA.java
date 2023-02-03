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

public class QnA {
	static Scanner scan = new Scanner(System.in,"EUC-KR");
	public static Connection con;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static ResultSet rs;
	public static String QnAUserno,Question,fAnswer, QnAno,bAnswer;
	 public static final String RESET = "\u001B[0m";
	 public static final String YELLOW = "\u001B[33m";
	 public static final String FONT_GREEN = "\u001B[36m"; 
	 public static final String RED      = "\u001B[31m" ;
	static QnA qa = new QnA();
	
	
	public void insertQnA(String userno) { // 회원용 문의하기 기능
		System.out.println();
		System.out.println(YELLOW+"<질문내용을 입력하시면 회원님의 회번번호로 등록이 완료됩니다.>"+RESET);
		System.out.print(FONT_GREEN+"질문:"+RESET);
		Question=scan.nextLine();
		fAnswer = "답변전입니다.";

		
		String sql = "INSERT INTO qna values('qna-'||qna_seq.nextval,?,?,?)";
		try {
			con=DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,userno);
			pstmt.setString(2,Question);
			pstmt.setString(3,fAnswer);

			
			pstmt.executeQuery();
			System.out.println(YELLOW+"문의해주셔서 감사드립니다."+YELLOW);
			System.out.println(RED+"!!"+RESET+"문의하기 목록에 등록이 되지않은 경우, 회원번호가 일치하지않는 것이오니 확인후 다시 이용바랍니다."+RED+"!!"+RESET);
			System.out.println();
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
	
//================================================================================================================
	public void updateAnswer() { //관리자용 답변하기 기능
		String sql = "UPDATE QNA SET answer = ? WHERE qnano = ?";
		try {
			con=DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			System.out.println(YELLOW+"답변하기 기능입니다."+RESET);
			System.out.print(FONT_GREEN+"답변할 문의번호 입력:"+RESET);
			QnAno=scan.next();
			scan.nextLine();
			System.out.print(FONT_GREEN+"답변:"+RESET);
			bAnswer =scan.nextLine();
			pstmt.setString(1, bAnswer);
			pstmt.setString(2, QnAno);
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
//============================================================================================================
	public List<QnAVO> QnA_No_AllList(QnAVO sch){ //답변하지않은 문의목록 검색
		List<QnAVO> qnalist = new ArrayList<QnAVO>();
		String sql = "SELECT * FROM QNA WHERE answer = '답변전입니다.'";
		
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			
			
			rs= pstmt.executeQuery(); //sql넣지않기 주의!
			while(rs.next()) {
				qnalist.add(new QnAVO(
						rs.getString("qnano"),
						rs.getString("userno_member"),
						rs.getString("question"),
						rs.getString("answer")
							));
			}
			//System.out.println("데이터 건수:"+qnalist.size());
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}return qnalist;}
//============================================================================================================
	public void QnA_NoAnswerPrint() { //답변하지않은 문의목록 출력
		for(QnAVO rv:qa.QnA_No_AllList(new QnAVO())) {
			System.out.print("<문의번호:"+rv.getQnano()+"  |  ");
			System.out.print("문의회원번호:"+rv.getUserno()+"  |  ");
			System.out.print("문의내용:"+rv.getQuestion()+"  |  ");
			System.out.print("답변:"+rv.getAnswer()+">\n");
			System.out.println();	
		}
		}
//============================================================================================================
	public List<QnAVO> QnA_AllList(QnAVO sch){ //문의목록 전체 리스트에담기
		List<QnAVO> qnalist = new ArrayList<QnAVO>();
		String sql = "SELECT * FROM QNA ";
		
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			
			
			rs= pstmt.executeQuery(); //sql넣지않기 주의!
			while(rs.next()) {
				qnalist.add(new QnAVO(
						rs.getString("qnano"),
						rs.getString("userno_member"),
						rs.getString("question"),
						rs.getString("answer")
							));
			}
			//System.out.println("데이터 건수:"+qnalist.size());
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}return qnalist;}
//------------------------------------------------------------------------------------------------------------
	public void QnA_AllPrint() { //문의목록  전체출력
		for(QnAVO rv:qa.QnA_AllList(new QnAVO())) {
			System.out.print("<문의번호:"+rv.getQnano()+"  |  ");
			System.out.print("문의회원번호:"+rv.getUserno()+"  |  ");
			System.out.print("문의내용:"+rv.getQuestion()+"  |  ");
			System.out.print("답변:"+rv.getAnswer()+">\n");
			System.out.println();	
		}
		}
//=====================================================================================================
	public void QnA_Print_Userno(String userno) {// 회원용 자신의 문의목록 전체 출력
		System.out.println(YELLOW+"회원님의 문의내역입니다"+RESET);
		try {
			con = DB.con();
			String sql = "SELECT * FROM QNA WHERE USERNO_MEMBER  = '"+userno+"'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) { 
				System.out.print("<문의번호:"+rs.getString(1)+"  |  ");
				System.out.print("회원번호:"+rs.getString(2)+"  |  ");
				System.out.print("문의내용:"+rs.getString(3)+"  |  ");
				System.out.print("답변내용:"+rs.getString(4)+">\n");
			}
			
		} catch (SQLException e) {
			System.out.println("기타 sql처리 예외:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("기타예외:"+e.getMessage());
		}finally {DB.close(rs, stmt, con);}
		}
//===========================================================================================================
	public static void main(String[] args) {

	}

}
