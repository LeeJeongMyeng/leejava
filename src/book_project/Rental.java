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
import a13_datebase.vo.ExpVO;
import a13_datebase.vo2.Emp02;

public class Rental {
	static Scanner scan = new Scanner(System.in, "EUC-KR");
	public static Connection con;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static ResultSet rs;
	public static String SRuserno, SRisbn, SRshipwhether, SRreturnwhether,updatereturnisbn,successship,checkreturnisbn;
	public static int SRrentladate, selectship, selectdate, shipnumber, checkrentnum, checkreturnnum, WarningCnt,updatereturn;
	static Rental RDao = new Rental();
	static Books BDao = new Books();
	static Ship sh = new Ship();
	 public static final String RESET = "\u001B[0m";
	 public static final String YELLOW = "\u001B[33m";
	 public static final String FONT_GREEN = "\u001B[36m"; 
	 public static final String RED      = "\u001B[31m" ;
	
//==============================================================================================================
public void totalRent(String userno) {// 대여기능 총집합
			RDao.checkWarning(userno); //해당 회원의 연체경고횟수 확인 
			if (WarningCnt < 5) {
				System.out.println(YELLOW+"<도서 대여를 진행합니다. 원하시는 도서번호를 입력해주세요!>"+RESET);
				System.out.print(FONT_GREEN+"도서번호 입력:"+RESET);
				String SRisbn = scan.next();
				RDao.UserIsbnCheck(SRisbn); //해당도서가 대여가능 상태인지 확인
				int checknumren = RDao.checkrentnum;
				if (checknumren == 1) {
							System.out.println(YELLOW+"해당 도서는 대여가능합니다. 다음 단계로 진행합니다."+RESET);
							RDao.insertRental(userno, SRisbn); // 대여하기 나머지 부분 기능메서드
							RDao.updateRentwhether(SRisbn); // 등록완료후, 해당 도서번호로 도서테이블의 해당도서 대여상태를 '대여중'으로변경처리
							System.out.println(YELLOW+"대여횟수가 1점 증가했습니다."+RESET);
							RDao.PlusRentCnt(userno); // 이후 스캔으로 받은 회원번호로 해당 회원의 대여횟수 카운트1 증가
							System.out.println(YELLOW+"도서 대여가 완료되었습니다 감사합니다!!"+RESET);
							RDao.getshipwhe(SRisbn); // 해당 대여로 등록된 대여 테이블에서 해당 도서번호의 정보중 배송여부를 확인함
							String successships = RDao.successship;
							if (successships.equals("배송신청")) { // 배송여부가 배송신청이라면?
								sh.insertShip(SRisbn); // 배송테이블에 해당정보들이 자동으로 들어가게됨 (배송날짜는 sysdate+2 고정)
							}
					System.out.println(YELLOW+"영수증을 출력하시겠습니까? (1.예 2.아니오)"+RESET);
					System.out.print(FONT_GREEN+"번호로 입력:"+RESET);
					int pricenum = scan.nextInt();
					if (pricenum == 1) {
						RDao.priceInfo_Ship(userno, SRisbn);
					} else {
						System.out.println(YELLOW+"영수증 출력하지않습니다. 이용해주셔서 감사합니다."+RESET);
					}
				} else {
					System.out.println(RED+"!!"+RESET+"해당 도서가 존재하지않거나 대여중입니다. 다음에 다시 이용바랍니다."+RED+"!!"+RESET);
				}
			} else {System.out.println(RED+"!!"+RESET+"회원님은 연체횟수가 5회이상으로 대여가 불가합니다. 관리자에게 문의바랍니다."+RED+"!!"+RESET);}
		}
//-------------------------------------------------------------------------------------------------------------------------
public void checkWarning(String userno) { // 해당 회원 연체횟수 확인
			String sql = "SELECT returnwarning FROM BOOKUSER\r\n" + "WHERE userno =?";
			try {
				con = DB.con();
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, userno);

				rs = pstmt.executeQuery();
				rs.next();
				WarningCnt = rs.getInt(1);

				pstmt.executeQuery();
				con.commit();

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

		}
//-------------------------------------------------------------------------------------------------------------------------
public void UserIsbnCheck(String isbn) { // 대여하기 기능 전 해당 도서가 존재 및 대여가능상태인지 확인
			try {
				con = DB.con();
				stmt = con.createStatement();
				String OLCidSQL = "SELECT count(*) FROM BOOKINFO b\r\n"
						+ "WHERE isbn = '"+isbn+"'\r\n"
						+ "AND RENTALWHETHER = '대여가능'";
				rs = stmt.executeQuery(OLCidSQL);
				while (rs.next()) {
					checkrentnum = rs.getInt(1);
				}
			} catch (SQLException e) {
				System.out.println("DB에러:" + e.getMessage());
				System.out.println("중복부분에러입니다.");
			} catch (Exception e) {
				System.out.println("기타에러:" + e.getMessage());
				System.out.println("중복부분에러입니다.");
			}
		}
//-------------------------------------------------------------------------------------------------------------------------
public void insertRental(String userno, String srisbn) { // 대여기능
			try {
				String sql = "INSERT INTO rental values('Rent-'||rental_seq.nextval,?,?,?,sysdate,sysdate+?,?)";
				con = DB.con();
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(sql);
				boolean successship = true;
				do {
					System.out.println("배송신청 하시겠습니까? (1.배송신청 2.배송미신청)");
					System.out.print(FONT_GREEN+"번호로 입력:"+RESET);
					selectship = scan.nextInt();
					if (selectship == 1) {
						SRshipwhether = "배송신청";
						successship = false;
					} else if (selectship == 2) {
						SRshipwhether = "배송미신청";
						successship = false;
					} else {
						System.out.println(RED+"!!"+RESET+"선택사항이 아닙니다. 다시입력해주세요"+RED+"!!"+RESET);
					}
				} while (successship);

				boolean successdate = true;
				do {
					System.out.println("대여기간을 선택해주세요( 1.7일 2.14일 3.21일 )");
					System.out.print(FONT_GREEN+"번호로 입력:"+RESET);
					selectdate = scan.nextInt();
					if (selectdate == 1) {
						SRrentladate = 7;
						successdate = false;
					} else if (selectdate == 2) {
						SRrentladate = 14;
						successdate = false;
					} else if (selectdate == 3) {
						SRrentladate = 21;
						successdate = false;
					} else {
						System.out.println(RED+"!!"+RESET+"선택사항이 아닙니다. 다시입력해주세요"+RED+"!!"+RESET);
					}
				} while (successdate);
				SRreturnwhether = "대여중";

				pstmt.setString(1, userno);
				pstmt.setString(2, srisbn);
				pstmt.setString(3, SRshipwhether);
				pstmt.setInt(4, SRrentladate);
				pstmt.setString(5, SRreturnwhether);

				pstmt.executeQuery();
				con.commit();
			} catch (SQLException e) {
				System.out.println("DB에러" + e.getMessage());
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("기타에러" + e.getMessage());
			} finally {
				DB.close(rs, pstmt, con);
			}
		}
//-------------------------------------------------------------------------------------------------------------------------
public void updateRentwhether(String isbn) { //대여하기 기능의 추가기능, 해당 도서의 대여상태를 '대여중'으로 변경
		String sql = "UPDATE BOOKINFO SET RENTALWHETHER ='대여중'\r\n"
				+ "WHERE ISBN=?";
		try {
			con=DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, isbn);

			
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
//-------------------------------------------------------------------------------------------------------------------------
public void PlusRentCnt(String username) { // 대여하기 다음의 추가 기능, 해당 회원의 대여횟수 1증가
		String sql = "UPDATE BOOKUSER \r\n"
				+ "SET RENTALCNT  =  NVL(RENTALCNT, 0)+ 1\r\n"
				+ "WHERE USERNO = ?";
		try {
			con=DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, username);
			
			
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
//-------------------------------------------------------------------------------------------------------------------------
public void getshipwhe(String userno) {  // 대여 완료 후, 해당 대여정보의 배송신청여부확인
	String sql = "SELECT SHIPWHETHER  FROM rental \r\n"
			+ "WHERE isbn = ?\r\n"
			+ "AND RETURNWHETHER ='대여중'";
	try {
		con = DB.con();
		con.setAutoCommit(false);
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, userno);
		rs = pstmt.executeQuery();
		rs.next();			
		successship=rs.getString("shipwhether");
		con.commit();
	} catch (SQLException e) {
		System.out.println("배달인 DB에러:"+e.getMessage());
	}catch (Exception e) {
		System.out.println("베달인 기타에러:"+e.getMessage());
	}finally {
		DB.close(rs, pstmt, con);
	}	
}
//-------------------------------------------------------------------------------------------------------------------------
public void priceInfo_Ship(String userno, String isbn) { // 영수증쿼리
		String sql = "SELECT b.USERNAME , b2.BNAME ,r.RETURNDATE,r.SHIPWHETHER,b.ADDRESS,SYSDATE+2 s2,b2.PRICE \r\n"
				+ "FROM BOOKUSER b , BOOKINFO b2 ,RENTAL r \r\n"
				+ "WHERE b.USERNO = r.USERNO \r\n"
				+ "AND b2.ISBN = r.ISBN \r\n"
				+ "AND b.USERNO = ?\r\n"
				+ "AND b2.ISBN =?\r\n"
				+ "AND r.RETURNWHETHER = '대여중'";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, userno);
			pstmt.setString(2, isbn);

			rs = pstmt.executeQuery();
			System.out
					.println(YELLOW+"========================================대여확인증=========================================="+RESET);
			rs.next();
			System.out.print("<대여자:" + rs.getString(1) + ">\t");
			System.out.print("<대여 도서명:" + rs.getString(2) + ">\t  ");
			System.out.print("<반납일자:" + rs.getDate(3) + ">\t");
			System.out.print("<배송여부:" + rs.getString(4) + ">\n");
			System.out.print("<배송주소:" + rs.getString(5) + ">\t");
			System.out.print("<배송날짜:" + rs.getDate(6) + ">\t");
			System.out.print("<대여금액:" + rs.getInt(7) + ">\n");
			pstmt.executeQuery();
			System.out
					.println(YELLOW+"========================================감사합니다!!========================================"+RESET);
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
	}
//==============================================================================================================
public void totalreturn(String userno) {// 반납하기기능 총집합
	RDao.RentalList_Userno(userno);// 반납전 해당 회원이 대여중인 도서 목록확인
		if(checkreturnisbn!=null) {
			System.out.println("반납하실 도서 번호입력해주세요.");
			System.out.print(FONT_GREEN+"입력:"+RESET);
			String returnisbn = scan.next();
			RDao.returnCheck(userno, returnisbn); //반납하기 기능을 위해, 대여 이력이있는지 체크(잘못입력 했을 경우 방지)
			int checkreturn = RDao.checkreturnnum;
			if (checkreturn == 1) {
				RDao.updateWarning(userno, returnisbn); // 반납전 반납날짜를 확인하여 연체카운트 1증가
				RDao.deleteShip(userno); // 해당 배송테이블의 정보삭제(fk키때문)
				RDao.returnBook(returnisbn); // 해당 도서상태 '대여가능'으로 변경, 대여테이블의 상태를 '반납완료"
			} else {
				System.out.println(RED+"!!"+RESET+"확인되는 대여 목록이 없습니다. 확인 후, 다시 이용바랍니다."+RED+"!!"+RESET);
			}
		}else {System.out.println(RED+"!!"+RESET+"확인되는 대여 목록이 없습니다. 확인 후, 다시 이용바랍니다."+RED+"!!"+RESET);}
		}
//--------------------------------------------------------------------------------------------------------------
public void returnCheck(String userno, String isbn) { // 반납하기 기능전, 대여테이블에 존재하는지 여부확인
	try {
		con = DB.con();
		stmt = con.createStatement();
		String OLCidSQL = "SELECT COUNT(*) FROM RENTAL \r\n"
				+ "WHERE ISBN ='"+isbn+"'\r\n"
				+ "AND userno='"+userno+"'\r\n"
				+ "AND RETURNWHETHER ='대여중'\r\n"
				+ "OR returnwhether='미반납 및 연체'";
		rs = stmt.executeQuery(OLCidSQL);
		while (rs.next()) {
			checkreturnnum = rs.getInt(1);
		}
	} catch (SQLException e) {
		System.out.println("DB에러:" + e.getMessage());
		System.out.println("중복부분에러입니다.");
	} catch (Exception e) {
		System.out.println("기타에러:" + e.getMessage());
		System.out.println("중복부분에러입니다.");
	}finally {DB.close(rs, pstmt, con);}
}
//--------------------------------------------------------------------------------------------------------------
public void RentalList_Userno(String userno) { // 회원등록번호로 대여목록확인
	try {
		con = DB.con();
		String sql = "SELECT isbn,returndate,returnwhether FROM RENTAL\r\n"
				+ "WHERE RETURNWHETHER ='대여중'\r\n"
				+ "OR  returnwhether = '미반납 및 연체'\r\n"
				+ "AND userno = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userno);
		rs = pstmt.executeQuery(); // sql넣지않기 주의!
		System.out.println("[<회원번호 " + userno + ">의 대여중인 목록 확인]");

		while (rs.next()) {
			System.out.print("<도서번호:" + (checkreturnisbn = rs.getString(1)) + " | ");
			System.out.print("반납일자:" + rs.getDate(2) + " | ");
			System.out.print("반납 및 대여상태: " + rs.getString(3) + "\n");
		}
	} catch (SQLException e) {
		System.out.println("DB처리예외:" + e.getMessage());
	} catch (Exception e) {
		System.out.println("기타예외:" + e.getMessage());
	} finally {
		DB.close(rs, stmt, con);
	}
	System.out.println(
			"-----------------------------------------------------------------------------------------------------");
}
//--------------------------------------------------------------------------------------------------------------
public void updateWarning(String userno, String isbn) { // 반납하기로 해당 데이터 삭제전, 반납날짜확인으로 연체카운트 1증가
	String sql = "UPDATE BOOKUSER \r\n"
			+ "			SET returnwarning  = returnwarning+ 1\r\n"
			+ "			WHERE USERNO = ?\r\n"
			+ "			AND SYSDATE > (SELECT RETURNDATE FROM rental\r\n"
			+ "			WHERE isbn = ?\r\n"
			+ "			AND returnwhether ='대여중'\r\n"
			+ "			OR returnwhether='미반납 및 연체')";
	try {
		con = DB.con();
		con.setAutoCommit(false);
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, userno);
		pstmt.setString(2, isbn);
		pstmt.executeQuery();
		con.commit();

	} catch (SQLException e) {
		System.out.println("연체카운트 DB에러" + e.getMessage());
		try {
			con.rollback();
		} catch (SQLException e1) {
			System.out.println("연체 롤백에러:" + e.getMessage());
		}
	} catch (Exception e) {
		System.out.println("연체 기타에러" + e.getMessage());
	} finally {
		DB.close(rs, pstmt, con);
	}

}
//--------------------------------------------------------------------------------------------------------------
public void deleteShip(String userno) { //해당 대여번호의 배송테이블데이터 삭제
	String sql = "DELETE ship\r\n" + "WHERE userno = ?";
	try {
		con = DB.con();
		con.setAutoCommit(false);
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, userno);

		pstmt.executeQuery();
		con.commit();

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

}
//--------------------------------------------------------------------------------------------------------------
public void returnBook(String isbn) { //대여테이블의 해당 도서번호의 데이터를 대여중에서 반납완료로 변경

	String sql = "UPDATE RENTAL\r\n"
			+ "SET RETURNWHETHER =\r\n"
			+ "CASE\r\n"
			+ "WHEN RETURNDATE-SYSDATE  >=0 THEN '반납완료'\r\n"
			+ "WHEN RETURNDATE -SYSDATE  <0 THEN '반납완료(연체)'\r\n"
			+ "END\r\n"
			+ "WHERE ISBN  = ?\r\n"
			+ "AND RETURNWHETHER ='대여중'\r\n"
			+ "OR returnwhether ='미반납 및 연체'";
	try {
		con = DB.con();
		con.setAutoCommit(false);
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, isbn);
		pstmt.executeQuery();
		con.commit();

		String sql2 = "UPDATE BOOKINFO SET RENTALWHETHER ='대여가능'\r\n" + "WHERE ISBN=?";
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1, isbn);
		pstmt.executeQuery();
		con.commit();

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
 System.out.println(YELLOW+"반납이 완료되었습니다!! 감사합니다!! \n"+RESET);
}
//==============================================================================================================
	public void UpdateRentWhe() { // 대여여부 갱신하기
		String sql = "UPDATE RENTAL\r\n" + "SET RETURNWHETHER =\r\n" + "CASE\r\n"
				+ "WHEN RETURNDATE-SYSDATE  >=0 THEN '대여중'\r\n" + "WHEN RETURNDATE  -SYSDATE  <0 THEN '미반납 및 연체'\r\n"
				+ "END\r\n" + "WHERE RETURNWHETHER != '반납완료'\r\n" + "OR RETURNWHETHER  is NULL\r\n"
				+ "OR RETURNWHETHER != '반납완료(연체)'";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.executeQuery();
			con.commit();

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

	}
//==============================================================================================================
	public List<RentalVO> RentalAllPrint(RentalVO sch) { // 대여목록 전체 확인
		List<RentalVO> rlist = new ArrayList<RentalVO>();
		String sql = "SELECT * FROM RENTAL";

		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery(); // sql넣지않기 주의!
			while (rs.next()) {
				rlist.add(new RentalVO(rs.getString("rentalno"), rs.getString("userno"), rs.getString("isbn"),
						rs.getString("shipwhether"), rs.getDate("rentdate"), rs.getDate("returndate"),
						rs.getString("returnwhether")));
			}
			System.out.println("데이터 건수:" + rlist.size());
		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return rlist;
	}
//------------------------------------------------------------------------------------------------------
	public void PrintRentalList() { //대여목록 전체 출력
		for (RentalVO rv : RDao.RentalAllPrint(new RentalVO())) {
			System.out.print(rv.getRentalno() + "\t");
			System.out.print(rv.getUserno() + "\t");
			System.out.print(rv.getIsbn() + "\t");
			System.out.print(rv.getShipwhether() + "\t");
			System.out.print(rv.getRentdate() + "\t");
			System.out.print(rv.getReturndate() + "\t");
			System.out.print(rv.getReturnwhether() + "\n");
		}
	}
//==============================================================================================================

	public void updateReturnDate(String userno) { //도서 연장하기
		RDao.RentalList_Userno(userno);// 반납전 해당 회원이 대여중인 도서 목록확인
		System.out.println(YELLOW+"도서 연장하기입니다. '반납완료'혹은'미반납연체'의 경우는 사용할수없으니 참고바랍니다."+RESET);
		System.out.println(YELLOW+"연장을 원하는 대여중인 도서번호를 입력해주세요."+RESET);
		System.out.print(FONT_GREEN+"입력:"+RESET);
		updatereturnisbn = scan.next();
		RDao.returnCheck(userno,updatereturnisbn);
		int checkrenum = RDao.checkreturnnum;
		if(checkrenum==1) {
		System.out.println("연장기간을 선택해주세요. (1.7일 2.14일 3.21일)");
		System.out.print(FONT_GREEN+"번호로 입력:"+RESET);
		boolean SucUpReturn = true;
		do {
		int selectupreturn = scan.nextInt();
		if(selectupreturn==1) {updatereturn=7; SucUpReturn = false;}
		else if(selectupreturn==2) {updatereturn=14; SucUpReturn = false;}
		else if(selectupreturn==3) {updatereturn=21; SucUpReturn = false;}
		else {System.out.println(RED+"!!"+RESET+"없는 선택지입니다. 다시 입력해주세요."+RED+"!!"+RESET);}
		}while(SucUpReturn);
		
		String sql = "UPDATE RENTAL\r\n"
				+ "SET RETURNDATE = returndate+?\r\n"
				+ "WHERE ISBN = ?\r\n"
				+ "AND USERNO =?\r\n"
				+ "AND RETURNWHETHER = '대여중'";
		try {
			con=DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, updatereturn);
			pstmt.setString(2, updatereturnisbn);
			pstmt.setString(3, userno);
			
			pstmt.executeQuery(); 
			con.commit();
			System.out.println(YELLOW+"도서연장이 완료되었습니다. 조회에서 확인부탁드립니다."+RESET);
			
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
		}else {System.out.println(RED+"!!"+RESET+"해당도서가 없습니다. 확인 후, 다시 이용바랍니다."+RED+"!!"+RESET);}
	}

//==============================================================================================================

	

	public static void main(String[] args) {
		// RDao.returnCheck("Member-25","200-51");
		// int checkreturn = RDao.checkreturnnum;
		// RDao.insertRental("Member-25", "000-49");
		//RDao.updateReturnWhether("Member-25");
	}

}
