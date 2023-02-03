package marketkulry_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import a13_datebase.DB;
import a13_datebase.vo.ExpVO;

public class Marketuser2 {
	static Scanner scan = new Scanner(System.in, "EUC-KR");
	public static Connection con;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static PreparedStatement pstmt2;
	public static ResultSet rs;
	
	public static String sdiv, usernotype,sname,sfrrn,srrn,sid,spass,saddress,spnum,sfullpnum,sfullpnum2,LoginDiv,LoginName,LoginUserno;
	public static int OLCid,OLCName,spoint,LoginDivnum;
	
	 public static final String RESET = "\u001B[0m";
	 public static final String YELLOW = "\u001B[33m";
	 public static final String FONT_GREEN = "\u001B[36m"; 
	 public static final String RED      = "\u001B[31m" ;
	
	static Marketuser2 MarketDao2 = new Marketuser2();
	
	//=================================================================================================================
			public void SignUp_User() { // 회원가입 기능메서드
				String sql = "INSERT INTO MARKETUSER values(to_char(?||marketuser_seq.nextval),?,?,?,?,?,?,?,?)";
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
							String OLCidSQL = "SELECT COUNT(*) FROM  MARKETUSER WHERE username='"+sname+"' AND rrn='"+srrn+"'";
							pstmt2 = con.prepareStatement(OLCidSQL);
							rs = pstmt2.executeQuery();
							rs.next(); 
								OLCName = rs.getInt(1);
								System.out.println("이름중복검사 결과:"+OLCName);
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
							
							String OLCidSQL = "SELECT count(*) FROM MARKETUSER WHERE id='"+sid+"'";
							pstmt2 = con.prepareStatement(OLCidSQL);
							rs = pstmt2.executeQuery();
							rs.next(); 
								OLCid = rs.getInt(1);
							System.out.println("아이디중복검사 결과:"+OLCid);
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
					int point=1000;
					if (successaddress == 1) {
						pstmt.setString(1, usernotype);
						pstmt.setString(2, sdiv);
						pstmt.setString(3, sname);
						pstmt.setString(4, srrn);
						pstmt.setString(5, saddress);
						pstmt.setString(6, sfullpnum2);
						pstmt.setString(7, sid);
						pstmt.setString(8, spass);
						pstmt.setInt(9, point);
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
//=================================================================================================================
		public void Login_User() { // 로그인 기능메서드

			System.out.print(FONT_GREEN+"아이디:"+RESET);
			sid = scan.next();
			System.out.print(FONT_GREEN+"패스워드:"+RESET);
			spass = scan.next();
			String LoginSQL = "SELECT USERNO,USERNAME,DIV FROM marketuser \r\n" + "WHERE id='" + sid + "'\r\n"
					+ "AND PASSWORD ='" + spass + "'";
			try {
				con = DB.con();
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(LoginSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					System.out.println();
					System.out.print("<'" +YELLOW+(LoginDiv = rs.getString(3))+RESET+ "' 로그인입니다. ");
					System.out.print(YELLOW+(LoginName = rs.getString(2))+RESET+ "님 반갑습니다. ");
					System.out.println("회원번호<" +YELLOW+ (LoginUserno = rs.getString(1))+RESET + ">>");
				}
				if (LoginDiv.equals("관리자")) {
					LoginDivnum = 1;
				} else if (LoginDiv.equals("회원")) {
					LoginDivnum = 2;
				}
				
			} catch (SQLException e) {
				System.out.println("(로그인)DB에러:" + e.getMessage());
			} catch (Exception e) {
				//System.out.println("(로그인)기타에러:"+e.getMessage());
				
			} finally {
				DB.close(rs, stmt, con);
			}
		}
//=================================================================================================================
		public void deleteUser() { //회원탈퇴
			try {
			con = DB.con();
			con.setAutoCommit(false);
			System.out.print(FONT_GREEN+"가입자 이름 입력:"+RESET);
			sname = scan.next();
			System.out.print(FONT_GREEN+"가입자 주민번호 입력(-제외):"+RESET);
			sfrrn = scan.next();
			StringBuffer buf = new StringBuffer(sfrrn);
			buf.insert(6, "-");
			srrn = buf.toString();
			 System.out.println("입력하신 주민번호 : "+srrn);
		
			 String OLCidSQL = "SELECT COUNT(*) FROM  MARKETUSER WHERE username='"+sname+"' AND rrn='"+srrn+"'";
				pstmt2 = con.prepareStatement(OLCidSQL);
				rs = pstmt2.executeQuery();
				rs.next(); 
					OLCName = rs.getInt(1);
					System.out.println("이름중복검사 결과:"+OLCName);
			 
			 if(OLCName>=1) {
			System.out.print(FONT_GREEN+"가입자 아이디 입력:"+RESET);
			sid = scan.next();
			String sql = "DELETE marketuser\r\n"
					+ "WHERE username = ?\r\n"
					+ "AND rrn = ?\r\n"
					+ "AND id = ?";
			
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sname);
				pstmt.setString(2, srrn);
				pstmt.setString(3, sid);
				rs = pstmt.executeQuery();
				System.out.println("삭제가 완료되었습니다. 감사합니다.");}
			 else if(OLCName==0) {System.out.println("등록된 회원이 존재하지 않습니다.");}
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
//=================================================================================================================\
		public void FindPass_NameRrn() {// 비밀번호찾기(이름/주민번호 조건)
			try {
				con = DB.con();
				con.setAutoCommit(false);
				System.out.print(FONT_GREEN+"이름을 입력해주세요:"+RESET);
				sname = scan.next();
				System.out.print(FONT_GREEN+"주민번호 입력(-제외):"+RESET);
				sfrrn = scan.next();
				StringBuffer buf = new StringBuffer(sfrrn);
				buf.insert(6, "-");
				srrn = buf.toString();
				 System.out.println("입력하신 주민번호 : "+srrn);
				 
				 String OLCidSQL = "SELECT COUNT(*) FROM  MARKETUSER WHERE username='"+sname+"' AND rrn='"+srrn+"'";
					pstmt2 = con.prepareStatement(OLCidSQL);
					rs = pstmt2.executeQuery();
					rs.next(); 
						int chechName = rs.getInt(1);	
					if(chechName>=1) {
					String sql = "SELECT password FROM MARKETUSER WHERE USERNAME = ? AND rrn = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, sname);
					pstmt.setString(2, srrn);
					rs = pstmt.executeQuery();
					rs.next();
					System.out.print(sname + "님의 비밀번호:" + rs.getString("password"));
					}else {System.out.println(RED+"!!"+RESET+"해당회원은 존재하지않습니다."+RED+"!!"+RESET);}
				
			} catch (SQLException e) {
				 e.getMessage();
				//System.out.println(RED+"!!"+RESET+"해당회원은 존재하지않습니다."+RED+"!!"+RESET);
			} catch (Exception e) {
				System.out.println("기타예외:" + e.getMessage());
			} finally {
				DB.close(rs, stmt, con);
			}
		}
//=================================================================================================================
		public void AllprintUser() { // 전체유저 확인(관리자용)
			String sql = "SELECT * FROM MARKETUSER ";
			System.out.println("1.전체 회원조회 2.관리자 조회 3.일반회원조회 4.이름으로 조회 5. 취소");
			System.out.print("번호입력:");
			int ChoicePrintUser=scan.nextInt();
			if(ChoicePrintUser<5) {
			if(ChoicePrintUser==1) {}
			if(ChoicePrintUser==2) {sql += " WHERE DIV ='관리자'";}
			if(ChoicePrintUser==3) {sql += " WHERE DIV ='회원'";}
			if(ChoicePrintUser==4) {
				System.out.println("조회 할 회원의 이름을 입력해주세요.");
				System.out.print("이름입력:");
				String FindUsername=scan.next();
				sql += " WHERE USERNAME LIKE '%"+FindUsername+"%'";}
			try {
				con = DB.con();
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.print("<회원번호:" + rs.getString(1) + "  |  ");
					System.out.print("구분:" + rs.getString(2) + "  |  ");
					System.out.print("회원이름:" + rs.getString(3) + "  |  ");
					System.out.print("주민번호:" + rs.getString(4) + "  |  ");
					System.out.print("주소:" + rs.getString(5) + "  |  ");
					System.out.print("전화번호:" + rs.getString(6) + "  |  ");
					System.out.print("아이디:" + rs.getString(7) + "  |  ");
					System.out.print("비밀번호:" + rs.getString(8) + "  |  ");
					System.out.print("포인트:" + rs.getInt(9) + ">\n");	
				}
			} catch (SQLException e) {
				System.out.println("DB에러" + e.getMessage());
				try {
					con.rollback();
				} catch (SQLException e1) {
					System.out.println("롤백에러:" + e.getMessage());
				}
			} catch (Exception e) {
				System.out.println("기타에러" + e.getMessage());
			} finally {
				DB.close(rs, pstmt, con);
			}
			}else  {System.out.println("회원확인을 취소합니다.");}
		}
//=================================================================================================================
//=================================================================================================================
//=================================================================================================================
	public static void main(String[] args) {
		MarketDao2.FindPass_NameRrn();

	}

}
