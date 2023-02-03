package book_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import a13_datebase.DB;
import a13_datebase.vo.Emp;

public class Sign_User2 {
	static Scanner scan = new Scanner(System.in,"EUC-KR");
	private static Connection con;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private String usernotype,sdiv,sname,saddress,sid,spass,sfrrn,sbrrn,srrn,sfullpnum,sfullpnum2,spnum,Loginip;
	private int OLCid,OLCName,srentalcnt;
	private static int LoginDiv=0;;
	static Sign_User2 SUDao = new Sign_User2();
	
	/*
	public void MUserSeqIns() {
		try {
			stmt = con.createStatement();
			String MUserSeq = "";
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			System.out.println("스퀀스부분에러입니다.");
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
			System.out.println("스퀀스부분에러입니다.");
		}
	}*/
	
	public void UsernameOLC(String username, String rrn) { // 이름,주민등록번호 중복검증 메서드
		try {
			stmt = con.createStatement();
			String OLCidSQL = "SELECT count(*)  FROM BOOKUSER \r\n"
					+ "WHERE USERNAME  = '"+username+"'\r\n"
					+ "AND rrn = '"+rrn+"'";
			rs = stmt.executeQuery(OLCidSQL);			
			while(rs.next()) {			
				System.out.println(OLCName=rs.getInt(1));
				}			
		} 
			catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			System.out.println("중복부분에러입니다.");
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
			System.out.println("중복부분에러입니다.");
		}
	}
	
	public void UseridOLC(String id) { // 아이디 중복검증 메서드
		try {
			stmt = con.createStatement();
			String OLCidSQL = "SELECT count(*) FROM BOOKUSER\r\n"
					+ "WHERE id = '"+id+"'";
			rs = stmt.executeQuery(OLCidSQL);			
			while(rs.next()) {			
				System.out.println(OLCid=rs.getInt(1));
				}			
		} 
			catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			System.out.println("중복부분에러입니다.");
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
			System.out.println("중복부분에러입니다.");
		}
	}
	
	
	
	public void SignUp_User() { // 회원가입 기능메서드
		
		String sql = "INSERT INTO BOOKUSER values(?||Muser_seq.nextval,?,?,?,?,?,?,?,?)";
		try {
			con=DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			//int cnt = 	pstmt.executeUpdate(sql);
			
			System.out.print("원하시는 가입 유형을 선택해주세요.\n");
			System.out.print("\t1.관리자 2.일반회원");
			int choiceDiv = scan.nextInt();
			int successDiv = 0;
			
			if(choiceDiv==1) {
				sdiv = "관리자";
				usernotype = "Mgr";
				System.out.println("관리자 회원가입입니다.");
				successDiv=1;
			} else if (choiceDiv==2) {
				sdiv = "회원";
				usernotype = "Member";
				System.out.println("일반 회원가입입니다.");
				successDiv=1;
			} else {
				System.out.println("해당 선택지는 존재하지않습니다.");
				System.out.println("처음부터 다시 입력해주세요.");
			}

			int successname = 0;
			if(successDiv==1) {
				System.out.print("성함을 입력해주세요:");
				sname = scan.next();
				System.out.println("주민번호 앞자리 입력:");
				sfrrn = scan.next();
				System.out.println("뒷자리 입력:");
				sbrrn = scan.next();
				srrn = sfrrn+"-"+sbrrn;
				String rrnpat = "^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\-[1-4][0-9]{6}$";
				System.out.println(srrn);
				System.out.println(srrn.matches(rrnpat));
				
				if(srrn.matches(rrnpat)==true) {
					System.out.println("주민등록번호 검증 확인");
					SUDao.UsernameOLC(sname,srrn);
				} else {
					System.out.println("매치실패");
				}
				
			}
			if(OLCName<=1) {
			System.out.println("해당 이름/주민번호로 등록된 회원이 있습니다.");
			} else {
						successname = 1;
						scan.nextLine(); // nextLine 버그 방지용
			}
			int successid=0;
			if(successname==1) {
				System.out.print("id를 입력해주세요:");
				sid = scan.next();
				System.out.print("비밀번호를 입력해주세요:");
				spass = scan.next();
				SUDao.UseridOLC(sid);
				if(OLCid==1) {
					System.out.println("같은 아이디가 존재합니다. 다시 시작바랍니다.");
				} else {
					successid = 1;
					scan.nextLine(); // nextLine 버그 방지용
				}
			}

			int successaddress = 0;
			if(successid==1) {
				System.out.print("주소를 입력해주세요:");
				saddress = scan.nextLine();
				System.out.println("입력주소:"+saddress);
				System.out.print("전화번호를 입력해주세요:\n");
				System.out.print("010-");
				spnum = scan.next();
				sfullpnum = "010-"+spnum;
				StringBuffer buf = new StringBuffer(sfullpnum);
				buf.insert(8, "-");
				sfullpnum2 = buf.toString();
				System.out.println(sfullpnum2+"="+sfullpnum2.length());
				if(sfullpnum2.length()==13) {
					System.out.println("입력하신 번호: "+sfullpnum2);
					successaddress = 1;
					//spass = scan.next();
				} else {
					System.out.print("010포함 11자리가 아닙니다. 다시 시작해주세요.");
				}
			}
			srentalcnt = 0;
			if(successaddress==1) {
			pstmt.setString(1, usernotype);
			pstmt.setString(2, sdiv);
			pstmt.setString(3,sname);
			pstmt.setString(4,srrn);
			pstmt.setString(5,saddress);
			pstmt.setString(6,sfullpnum2);
			pstmt.setString(7,sid);
			pstmt.setString(8,spass);
			pstmt.setInt(9,srentalcnt);
			rs = pstmt.executeQuery();
			con.commit();
			System.out.println("회원가입 완료!");
			}
		} catch (SQLException e) {
			System.out.println("DB처리:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:"+e1.getMessage());
			}
		}catch(Exception e) {
			System.out.println("기타예외:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		
	}
	public void Login_User() { // 로그인 기능메서드
		
		System.out.println("아이디:");
		sid = scan.next();
		System.out.println("패스워드:");
		spass = scan.next();
		String LoginSQL = "SELECT DIV FROM BOOKUSER\r\n"
							+ "WHERE id='"+sid+"'\r\n"
							+ "AND PASSWORD ='"+spass+"'";
		try {
			con=DB.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(LoginSQL);
			while(rs.next()) {			
				System.out.println(Loginip=rs.getString("div"));
				}
			if(Loginip.equals("관리자")) {
				
				LoginDiv = 1;
				System.out.println(LoginDiv);
			} else if(Loginip.equals("회원")) {
				
				LoginDiv = 2;
				System.out.println(LoginDiv);
			}
		} catch (SQLException e) {
			System.out.println("(로그인)DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("(로그인)기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		
	}
	public static void main(String[] args) {
		
	//	SUDao.SignUp_User(); //회원 가입 기능메서드
		SUDao.Login_User();
		if(LoginDiv == 1) {
			System.out.println("관리자 로그인입니다.");
			System.out.println("1.메뉴 2.메뉴 3.메뉴 4.메뉴");
		} else if(LoginDiv==2) {
			System.out.println("회원 로그인입니다.");
			System.out.println("1.메뉴투 2.메뉴투 3.메뉴투 4.메뉴투");
		}
	
	}

}
