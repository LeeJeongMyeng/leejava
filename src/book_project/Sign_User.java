package book_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import a13_datebase.DB;
import a13_datebase.vo.Emp;

public class Sign_User {
	static Scanner scan = new Scanner(System.in, "EUC-KR");
	public static Connection con;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static ResultSet rs;
	public static String usernotype, sdiv, sname, saddress, sid, spass, sfrrn, sbrrn, srrn, sfullpnum, sfullpnum2,
			spnum, LoginName, LoginDiv, LoginUserno,UPname,UPrrn,UPpass,UPpass2;
	public static int OLCid, OLCName, srentalcnt, sreturnwarning;
	public static int LoginDivnum;
	
	 public static final String RESET = "\u001B[0m";
	 public static final String YELLOW = "\u001B[33m";
	 public static final String FONT_GREEN = "\u001B[36m"; 
	 public static final String RED      = "\u001B[31m" ;
	static Sign_User SUDao = new Sign_User();

//=================================================================================================================
	public void SignUp_User() { // 회원가입 기능메서드

		String sql = "INSERT INTO BOOKUSER values(?||Muser_seq.nextval,?,?,?,?,?,?,?,?,?)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			// int cnt = pstmt.executeUpdate(sql);

			System.out.println(YELLOW+"<원하시는 가입 유형을 선택해주세요.>  (1.관리자 2.일반회원)"+RESET);
			System.out.print(FONT_GREEN+"번호입력:"+RESET);
			int choiceDiv = scan.nextInt();
			int successDiv = 0;

			if (choiceDiv == 1) {
				sdiv = "관리자";
				usernotype = "MGR-";
				System.out.println("");
				System.out.print(YELLOW+"<관리자 회원가입입니다."+RESET);
				successDiv = 1;
			} else if (choiceDiv == 2) {
				sdiv = "회원";
				usernotype = "Member-";
				System.out.print(YELLOW+"<일반 회원가입입니다."+RESET);
				successDiv = 1;
			} else {
				System.out.println(RED+"!!"+RESET+"해당 선택지는 존재하지않습니다."+RED+"!!"+RESET);
				System.out.println(RED+"!!"+RESET+"처음부터 다시 입력해주세요."+RED+"!!"+RESET);
			}

			int successname = 0;
			if (successDiv == 1) {
				System.out.println(YELLOW+"성함을 입력해주세요.>"+RESET);
				System.out.print(FONT_GREEN+"가입할 이름:"+RESET);
				sname = scan.next();

				System.out.print(FONT_GREEN+"주민번호 입력(-제외):"+RESET);
				sfrrn = scan.next();
				StringBuffer buf = new StringBuffer(sfrrn);
				buf.insert(6, "-");
				srrn = buf.toString();
				System.out.println(YELLOW+("입력하신 주민번호 : " + srrn)+RESET);
				String rrnpat = "^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\-[1-4][0-9]{6}$";
				System.out.println(YELLOW+("주민번호 검증 결과:" + srrn.matches(rrnpat))+RESET);

				if (srrn.matches(rrnpat) == true) {
					SUDao.UsernameOLC(sname, srrn);
					if (OLCName >= 1) {
						System.out.println(RED+"!!"+RESET+"해당 이름/주민번호로 등록된 회원이 있습니다."+RED+"!!"+RESET);
					} else {
						successname = 1;
						scan.nextLine(); // nextLine 버그 방지용
					}
				} else {
					System.out.println(RED+"!!"+RESET+"해당 주민은 사용할수없습니다. 다시 시작해주세요!"+RED+"!!"+RESET);
				}
			}
			int successid = 0;
			if (successname == 1) {
				boolean successidpass = true;
				do {
					System.out.print(FONT_GREEN+"id를 입력해주세요:"+RESET);
					sid = scan.next();
					System.out.print(FONT_GREEN+"비밀번호를 입력해주세요:"+RESET);
					spass = scan.next();
					SUDao.UseridOLC(sid);
					if (OLCid == 1) {
						System.out.println(RED+"!!"+RESET+"같은 아이디가 존재합니다. 다시입력해주세요"+RED+"!!"+RESET);
					} else {
						successid = 1;
						successidpass = false;
					}
				} while (successidpass);
			}
			scan.nextLine(); // nextLine 버그 방지용

			int successaddress = 0;
			if (successid == 1) {
				System.out.println(YELLOW+"<주소를 입력해주세요. 대여 배송신청시, 해당주소로 배달되니 자세히 기입부탁드립니다.>"+RESET);
				System.out.print(FONT_GREEN+"주소입력:"+RESET);
				saddress = scan.nextLine();
				boolean successPhone = true;
				do {
					System.out.print(FONT_GREEN+"전화번호를 입력해주세요(-제외):"+RESET+" 010");
					spnum = scan.next();
					sfullpnum = "010-" + spnum;
					StringBuffer buf = new StringBuffer(sfullpnum);
					buf.insert(8, "-");
					sfullpnum2 = buf.toString();
					// System.out.println(sfullpnum2+"="+sfullpnum2.length());
					if (sfullpnum2.length() == 13) {
						System.out.println(YELLOW+("입력하신 번호: " + sfullpnum2)+RESET);
						successaddress = 1;
						successPhone = false;
					} else {
						System.out.print(RED+"!!"+RESET+"010포함 11자리가 아닙니다. 다시 시작해주세요."+RED+"!!"+RESET);
					}
				} while (successPhone);
			}
			srentalcnt = 0;
			sreturnwarning = 0;
			if (successaddress == 1) {
				pstmt.setString(1, usernotype);
				pstmt.setString(2, sdiv);
				pstmt.setString(3, sname);
				pstmt.setString(4, srrn);
				pstmt.setString(5, saddress);
				pstmt.setString(6, sfullpnum2);
				pstmt.setString(7, sid);
				pstmt.setString(8, spass);
				pstmt.setInt(9, srentalcnt);
				pstmt.setInt(10, sreturnwarning);
				rs = pstmt.executeQuery();
				con.commit();
				System.out.println(YELLOW+"회원가입이 완료되었습니다. 감사합니다!"+RESET);
			}
		} catch (SQLException e) {
			System.out.println("DB처리:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타예외:" + e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
	}
//-----------------------------------------------------------------------------------------------------------------
	public void UsernameOLC(String username, String rrn) { // 회원 가입 진행 도중 이름,주민등록번호 중복검증 메서드
		try {
			String OLCidSQL = "SELECT count(*)  FROM BOOKUSER \r\n" + "WHERE USERNAME  = '" + username + "'\r\n"
					+ "AND rrn = '" + rrn + "'";
			//con.setAutoCommit(false);
			pstmt = con.prepareStatement(OLCidSQL);
			rs = pstmt.executeQuery();
			//rs = stmt.executeQuery(OLCidSQL);
			while (rs.next()) {
				OLCName = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
			System.out.println("중복부분에러입니다.");
		} catch (Exception e) {
			System.out.println("기타에러:" + e.getMessage());
			System.out.println("중복부분에러입니다.");
		}
	}
//-------------------------------------------------------------------------------------------------------------------
	public void UseridOLC(String id) { // 회원가입 진행도중 아이디 중복검증 메서드
		try {
			stmt = con.createStatement();
			String OLCidSQL = "SELECT count(*) FROM BOOKUSER\r\n" + "WHERE id = '" + id + "'";
			rs = stmt.executeQuery(OLCidSQL);
			while (rs.next()) {
				OLCid = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
			System.out.println("중복부분에러입니다.");
		} catch (Exception e) {
			System.out.println("기타에러:" + e.getMessage());
			System.out.println("중복부분에러입니다.");
		}
	}
	//=====================================================================================================================
	public void Login_User() { // 로그인 기능메서드

		System.out.print(FONT_GREEN+"아이디:"+RESET);
		sid = scan.next();
		System.out.print(FONT_GREEN+"패스워드:"+RESET);
		spass = scan.next();
		String LoginSQL = "SELECT USERNO,USERNAME,DIV FROM BOOKUSER\r\n" + "WHERE id='" + sid + "'\r\n"
				+ "AND PASSWORD ='" + spass + "'";
		try {
			con = DB.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(LoginSQL);
			while (rs.next()) {
				System.out.println();
				System.out.print("<'" +YELLOW+(LoginDiv = rs.getString("div"))+RESET+ "' 로그인입니다. ");
				System.out.print(YELLOW+(LoginName = rs.getString("username"))+RESET+ "님 반갑습니다. ");
				System.out.println("회원번호<" +YELLOW+ (LoginUserno = rs.getString("userno"))+RESET + ">>");
			}
			if (LoginDiv.equals("관리자")) {
				LoginDivnum = 1;
			} else if (LoginDiv.equals("회원")) {
				LoginDivnum = 2;
			}
		} catch (SQLException e) {
			System.out.println("(로그인)DB에러:" + e.getMessage());
		} catch (Exception e) {
			// System.out.println("(로그인)기타에러:"+e.getMessage());
			System.out.println(RED+"!!"+RESET+"해당 회원이 없습니다. 다시시도해주세요"+RED+"!!"+RESET);
		} finally {
			DB.close(rs, stmt, con);
		}
	}
//====================================================================================================================
	public void deleteUser() { //회원탈퇴
		System.out.print(FONT_GREEN+"가입자 이름 입력:"+RESET);
		sname = scan.next();
		System.out.print(FONT_GREEN+"가입자 주민번호 입력(-제외):"+RESET);
		sfrrn = scan.next();
		StringBuffer buf = new StringBuffer(sfrrn);
		buf.insert(6, "-");
		srrn = buf.toString();
		// System.out.println("입력하신 주민번호 : "+srrn);
		System.out.print(FONT_GREEN+"가입자 아이디 입력:"+RESET);
		sid = scan.next();
		String sql = "DELETE bookuser\r\n" + "WHERE username = '" + sname + "'\r\n" + "AND rrn = '" + srrn + "'\r\n"
				+ "AND id = '" + sid + "'";
		try {
			con = DB.con();
			
			con.setAutoCommit(false);
			stmt = con.createStatement();
			int delcnt = stmt.executeUpdate(sql);
			if (delcnt >= 1) {
				System.out.println(RED+"!!"+RESET+"삭제 성공"+RED+"!!"+RESET);
			} else if (delcnt >= 0) {
				System.out.println(RED+"!!"+RESET+"일치하는 계정이 존재하지 않습니다. 확인 후 다시 시도해주세요"+RED+"!!"+RESET);
			}
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

	}
//====================================================================================================================
	public void FindPass_NameRrn(String username, String rrn) {// 비밀번호찾기(이름/주민번호 조건)
			try {
				System.out.print(FONT_GREEN+"이름을 입력해주세요:"+RESET);
				sname = scan.next();
				System.out.print(FONT_GREEN+"주민번호 입력(-제외):"+RESET);
				sfrrn = scan.next();
				StringBuffer buf = new StringBuffer(sfrrn);
				buf.insert(6, "-");
				srrn = buf.toString();
				// System.out.println("입력하신 주민번호 : "+srrn);
				con = DB.con();
				String sql = "SELECT password FROM BOOKUSER b \r\n" + "WHERE username = '" + sname + "'\r\n" + "AND rrn = '"
						+ srrn + "'";
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				rs.next();
				System.out.print(sname + "님의 비밀번호" + rs.getString("password"));
				// if(rs.getString("password")=="null") {System.out.println("해당회원은 존재하지않습니다.");}

			} catch (SQLException e) {
				// System.out.println("기타 sql처리 예외:"+e.getMessage());
				System.out.println(RED+"!!"+RESET+"해당회원은 존재하지않습니다."+RED+"!!"+RESET);
			} catch (Exception e) {
				System.out.println("기타예외:" + e.getMessage());
			} finally {
				DB.close(rs, stmt, con);
			}
		}
//=======================================================================================================================
	public void UserPrint_Name() {// 관리자용 회원조회(이름조건)
		try {
			System.out.print(FONT_GREEN+"이름을 입력해주세요:"+RESET);
			sname = scan.next();
			con = DB.con();
			String sql = "SELECT userno,div,username,ADDRESS,PHONE_NUMBER,ID,RENTALCNT,RETURNWARNING FROM BOOKUSER b \r\n"
					+ "WHERE username = '" + sname + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.print("<회원번호:" + rs.getString(1) + " | ");
				System.out.print("구분:" + rs.getString(2) + " | ");
				System.out.print("회원이름:" + rs.getString(3) + " | ");
				System.out.print("주소:" + rs.getString(4) + " | ");
				System.out.print("전화번호:" + rs.getString(5) + " | ");
				System.out.print("아이디:" + rs.getString(6) + " | ");
				System.out.print("대여횟수:" + rs.getInt(7) + " | ");
				System.out.print("연체횟수:" + rs.getInt(8) + ">\n");
			}

		} catch (SQLException e) {
			System.out.println("기타 sql처리 예외:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타예외:" + e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
	}
//================================================================================================================
	public void UserListAllPrint() {// 관리자용 회원조회(전체컬럼)
		try {
			con = DB.con();
			String sql = "SELECT * FROM BOOKUSER b ";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("*==========================회원 목록 전체 조회 결과===================================");
			while (rs.next()) {
				System.out.print("<" + rs.getString(1) + " / ");
				System.out.print(rs.getString(2) + " / ");
				System.out.print(rs.getString(3) + " / ");
				System.out.print(rs.getString(4) + " / ");
				System.out.print(rs.getString(5) + " / ");
				System.out.print(rs.getString(6) + " / ");
				System.out.print(rs.getString(7) + " / ");
				System.out.print(rs.getString(8) + " / ");
				System.out.print(rs.getInt(9) + " / ");
				System.out.print(rs.getInt(10) + ">\n");
			}
			System.out.println("*============================ 결과 출력 종료!!!===================================");
		} catch (SQLException e) {
			// System.out.println("기타 sql처리 예외:"+e.getMessage());
		} catch (Exception e) {
			// System.out.println("기타예외:"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
	}
	//=====================================================================================================================
	public void WarningUserSch() {// 관리자용 연제자조회
		try {
			con = DB.con();
			String sql = "SELECT userno,div,username,phone_number,rentalcnt,returnwarning\r\n" + "FROM BOOKUSER b\r\n"
					+ "WHERE RETURNWARNING >=1";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.print("<회원번호:" + rs.getString(1) + "  |  ");
				System.out.print("구분:" + rs.getString(2) + "  |  ");
				System.out.print("회원이름:" + rs.getString(3) + "  |  ");
				System.out.print("전화번호:" + rs.getString(4) + "  |  ");
				System.out.print("대여횟수:" + rs.getInt(5) + "  |  ");
				System.out.print("연체횟수:" + rs.getInt(6) + ">\n");
			}

		} catch (SQLException e) {
			System.out.println("기타 sql처리 예외:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타예외:" + e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
	}
//============================================================================================
	public void UpdatePass() { // 비밀번호 변경
			
			try {
				con = DB.con();
				// autocommit:false
				con.setAutoCommit(false);
				System.out.println(YELLOW + "<회원님의 비밀번호를 변경합니다.>" + RESET);
				System.out.print(FONT_GREEN + "회원님의 이름:" + RESET);
				UPname = scan.next();
				System.out.print(FONT_GREEN + "회원님의 주민번호(-포함):" + RESET);
				UPrrn = scan.next();
				SUDao.UsernameOLC(UPname,UPrrn);
				if (OLCName >= 1) {
					System.out.print(FONT_GREEN + "변경할 비밀번호:" + RESET);
					UPpass = scan.next();
					System.out.print(FONT_GREEN + "변경할 비밀번호를 한번더 입력:" + RESET);
					UPpass2 = scan.next();
					if(UPpass.equals(UPpass2)) {
					String sql="UPDATE BOOKUSER \r\n"
					+ "SET PASSWORD  ='"+UPpass2+"'\r\n"
					+ "WHERE USERNAME  ='"+UPname+"'\r\n"
					+ "AND RRN ='"+UPrrn+"'";
				
				stmt = con.createStatement();
				int cnt = stmt.executeUpdate(sql);
				System.out.println(YELLOW + "비밀번호가 변경되었습니다. 감사합니다." + RESET);
				con.commit();
					}else{System.out.println("변경할 비밀번호와 재확인 비밀번호가 일치하지않습니다. 다시 시작바랍니다.");}
				}else {System.err.println("이름/주민등록번호가 일치하지 않습니다. 다시 시작바랍니다.");}
				
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
			

	}
//============================================================================================

	public static void main(String[] args) {
		SUDao.UpdatePass();
	}
	
	
	
}
