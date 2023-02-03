package marketkulry_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import a13_datebase.DB;

public class Product {
	static Scanner scan = new Scanner(System.in, "EUC-KR");
	public static Connection con;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static PreparedStatement pstmt2;
	public static ResultSet rs;
	
	public static String isbn,fication,pname,company;
	public static String totinformation ="";
	public static int pprice,endinformation;
	
	
	public static final String RESET = "\u001B[0m";
	 public static final String YELLOW = "\u001B[33m";
	 public static final String FONT_GREEN = "\u001B[36m"; 
	 public static final String RED      = "\u001B[31m" ;
	 
	 static Product PDDao = new Product();

//=======================================================================================================
	 public void Insert_Product() { // 물품등록
		 
			String sql = "INSERT INTO product values(?||product_seq.nextval,?,?,?,?,?,sysdate)";
			
				try {
					con = DB.con();
					con.setAutoCommit(false);
					pstmt = con.prepareStatement(sql);
					
					System.out.println("제품등록을 진행합니다. 아래 내용에 맞게 입력해주세요.");
					System.out.println();
					System.out.println("등록할 제품의 분류를 정해주세요.");
					System.out.println("<1.야채> <2.과일> <3.일반음식> <4.의류> <5.가전제품> <6.주방/욕실용품> <7.기타>");
					System.out.print("번호입력:");
					int seleceFication = scan.nextInt();
					boolean SuccessFication =true;
					do {
					if(seleceFication==1) {isbn="V-"; fication="야채"; SuccessFication=false;}
					else if(seleceFication==2) {isbn="F-"; fication="과일"; SuccessFication=false;}
					else if(seleceFication==3) {isbn="Fd-"; fication="일반음식"; SuccessFication=false;}
					else if(seleceFication==4) {isbn="C-"; fication="의류"; SuccessFication=false;}
					else if(seleceFication==5) {isbn="HA-"; fication="가전제품"; SuccessFication=false;}
					else if(seleceFication==6) {isbn="N-"; fication="주방/욕실용품"; SuccessFication=false;}
					else if(seleceFication==7) {isbn="ETC-"; fication="기타"; SuccessFication=false;}
					else {}
					}while(SuccessFication);
					scan.nextLine();//입력버그 방지
					
					System.out.println("제품명을 입력해주세요.의류인 경우, 사이즈도 함께 적어주세요.(ex.남성용 청바지(32)");
					System.out.print("입력:");
					pname = scan.nextLine();
					System.out.print("판매가격 입력:");
					pprice = scan.nextInt();
					scan.nextLine();//입력버그 방지
					
					do {
					System.out.println("제품 설명을 적어주시고, 입력 종료시에는 '종료'를 입력해주세요.");
					String information = "N";
					
					do {
						System.out.print("입력:");
						information = scan.nextLine();
						if(!information.equals("종료"))
					totinformation +=""+information;
					}while(!information.equals("종료"));
					System.out.println("------------------------------------------------------------------------------------");
					System.out.println("내용확인:"+totinformation);
					System.out.println("------------------------------------------------------------------------------------");		
					System.out.println("해당 내용이 맞으시면"+YELLOW+"1번"+RESET+", 다시입력하실 경우"+YELLOW+"2번"+RESET+"을 눌러주세요.");
					System.out.print("번호입력:");
					endinformation = scan.nextInt();
					}while(endinformation!=1);
					
					scan.nextLine();
					
					System.out.println("제조사를 입력:");
					company=scan.nextLine();
					
					pstmt.setString(1, isbn);
					pstmt.setString(2, fication);
					pstmt.setString(3, pname);
					pstmt.setInt(4, pprice);
					pstmt.setString(5, totinformation);
					pstmt.setString(6, company);

					
					rs = pstmt.executeQuery();
					con.commit();
					System.out.println(YELLOW+"물품등록이 완료 되었습니다!"+RESET);
				} catch (SQLException e) {
					System.out.println("(물건등록)DB에러:" + e.getMessage());
				} catch (Exception e) {
					System.out.println("(물건등록)기타에러:"+e.getMessage());
					
				} finally {
					DB.close(rs, stmt, con);
				}
			
			
	 }
//=======================================================================================================
	 public void AllprintProduct() { // 물건검색
		 
		 	boolean endprintproduct = true;
		 	do {
		 		
		 	
			String sql = "SELECT * FROM PRODUCT ";
			System.out.println("1.전체 물품조회 2.물건명으로 검색 3.가격 검색 4.분류로 검색 5.종료 ");
			System.out.print("번호입력:");
			int ChoicePrintProduct=scan.nextInt();
			
			if(ChoicePrintProduct==1) {}
			else if(ChoicePrintProduct==2) {System.out.println("물건 단어를 입력해주세요.");
			System.out.print("입력:");
			String FindUsername=scan.next();
			sql += " WHERE productname LIKE '%"+FindUsername+"%'";}
			else if(ChoicePrintProduct==3) {
				System.out.println("원하시는 금액대를 입력해주세요.");
				System.out.print("최저금액(상관없으면 0입력):");
				int bottomprice=scan.nextInt();
				System.out.print("최고금액(상관없으면 0입력):");
				int topprice=scan.nextInt();
				if(topprice==0) {topprice=2147483647;}
				sql += " WHERE price BETWEEN  "+bottomprice+" and "+topprice;}
			else if(ChoicePrintProduct==4) {
				boolean SelectFication = true;
				do {
				System.out.println("보고싶은 물품의 분류를 선택해주세요.");
				System.out.println("<1.야채> <2.과일> <3.일반음식> <4.의류> <5.가전제품> <6.주방/욕실용품> <7.기타> <8.종료> ");
				System.out.print("번호입력:");
				int selectPrintFication=scan.nextInt();
				if(selectPrintFication==1) {sql += " WHERE FICATION = '야채'";SelectFication = false;}
				else if(selectPrintFication==2) {sql += " WHERE FICATION = '과일'";SelectFication = false;}
				else if(selectPrintFication==3) {sql += " WHERE FICATION = '일반음식'";SelectFication = false;}
				else if(selectPrintFication==4) {sql += " WHERE FICATION = '의류'";SelectFication = false;}
				else if(selectPrintFication==5) {sql += " WHERE FICATION = '가전제품'";SelectFication = false;}
				else if(selectPrintFication==6) {sql += " WHERE FICATION = '주방/욕실용품'";SelectFication = false;}
				else if(selectPrintFication==7) {sql += " WHERE FICATION = '기타'";SelectFication = false;}
				else if(selectPrintFication==8) {sql += " WHERE FICATION = '종료'"; SelectFication = false;}
				else if(selectPrintFication>=9) {System.out.println("없는 선택지입니다. 다시 입력해 주세요.");}
				}while(SelectFication);
			}
			else { sql +=" where productname = '종료'";
			System.out.println("물건 찾기를 종료합니다. 감사합니다.");
			endprintproduct=false;}
			try {
				con = DB.con();
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				System.out.println("--------------------------------------------------------------------------------------");
				while(rs.next()) {	
					System.out.print("<물품번호:" + rs.getString(1) + ">  ");
					System.out.print("<물품분류:" + rs.getString(2) + ">  ");
					System.out.print("<물품명:" + rs.getString(3) + ">  ");
					System.out.print("<가격:" + rs.getInt(4) + ">   ");
					System.out.print("<제조사:" + rs.getString(6) + "> ");
					System.out.print("<물품설명:" + rs.getString(5) + ">\n ");
				}
				System.out.println("-------------------------------------------------------------------------------------");
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
		 	}while(endprintproduct);
		}
//=======================================================================================================
	 public void deleteProduct() { //물품삭제
			try {
			con = DB.con();
			con.setAutoCommit(false);
			System.out.print(FONT_GREEN+"삭제할 물품번호 입력:"+RESET);
			String DeletePname = scan.next();

		
			 String OLCPnameSQL = "SELECT count(*) FROM product WHERE isbn='"+DeletePname+"'";
				pstmt2 = con.prepareStatement(OLCPnameSQL);
				rs = pstmt2.executeQuery();
				rs.next(); 
					int OLCpName = rs.getInt(1);
					System.out.println("검사 결과:"+OLCpName);
			 
			 if(OLCpName>=1) {
			String sql = "DELETE product WHERE isbn=?";
			
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, DeletePname);
				rs = pstmt.executeQuery();
				System.out.println("삭제가 완료되었습니다. 감사합니다.");}
			 else if(OLCpName==0) {System.out.println("해당 품번은 존재하지 않습니다.");}
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
//=================================================================================================================

	 
	public static void main(String[] args) {
		PDDao.deleteProduct();

	}

}
