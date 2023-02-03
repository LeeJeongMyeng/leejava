package marketkulry_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import a13_datebase.DB;

public class Buycart {
	static Scanner scan = new Scanner(System.in, "EUC-KR");
	public static Connection con;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static PreparedStatement pstmt2;
	public static ResultSet rs;
	
	public static final String RESET = "\u001B[0m";
	 public static final String YELLOW = "\u001B[33m";
	 public static final String FONT_GREEN = "\u001B[36m"; 
	 public static final String RED      = "\u001B[31m" ;
	
	public static String deletecart;
	public static int endcart;

	 static Buycart BCDao = new Buycart();  
	 static Product PDDao = new Product();
//==============================================================================================================
	 public void Final_cart(String userno) {
		 System.out.println("<물품을 둘러면서 장바구니에 넣을 수 있습니다. 제품부터 보시겠습니까? (1.예 2.아니오)>" );
		 System.out.print("번호입력:"); int choiceSee = scan.nextInt();
		 if(choiceSee==1) {PDDao.AllprintProduct();}
		 else if(choiceSee==2) {System.out.println("<보기없이, 장바구니에 물품 추가를 진행합니다.>");}
		 do {
		 BCDao.Insert_cart(userno);
		 System.out.println("<장바구니에 물품을 더 담으시겠습니까? (1.예 2.아니오)>");
		 System.out.print("번호입력:"); endcart=scan.nextInt();
		 }while(endcart!=2);
		 System.out.println("이용해 주셔서 감사합니다^^ 장바구니 항목에서 최종구매를 진행해주시길 바랍니다.");
		 
	 }
//==============================================================================================================
	 public void Insert_cart(String userno) { // 장바구니 넣기
		 
		 try {
				con = DB.con();
				con.setAutoCommit(false);	
				
			String sql = "INSERT INTO buycart\r\n"
					+ "SELECT ?||buycart_seq.nextval,?,p.ISBN ,?,p.PRICE*?\r\n"
					+ "FROM PRODUCT p ";
			
				boolean SuccessChoiceCart = true;
				do {
				System.out.println("장바구니에 넣을 물건 입력방식 선택(1.물품이름 2.물품번호)");
				System.out.print("번호입력:");
				int choicecart = scan.nextInt();
					if(choicecart==1) {sql+=" WHERE p.PRODUCTNAME =?"; SuccessChoiceCart = false;}
					else if(choicecart==2) {sql+=" WHERE p.isbn =?"; SuccessChoiceCart = false;}
					else {System.out.println("해당 선택지는 없습니다. 다시입력해주세요.");}
				}while(SuccessChoiceCart);
				scan.nextLine();
				System.out.println("선택하신 방식에 맞게 원하시는 물품을 입력해주세요.");
				System.out.print("입력:");
				String ChoiceProduct = scan.nextLine();
				
				System.out.println("구매하실 갯수를 입력해주세요.");
				System.out.print("입력:");
				int ChoiceCount = scan.nextInt();
				
					
						pstmt = con.prepareStatement(sql);
						
						pstmt.setString(1, userno);
						pstmt.setString(2, userno);
						pstmt.setInt(3, ChoiceCount);
						pstmt.setInt(4, ChoiceCount);
						pstmt.setString(5, ChoiceProduct);


						rs = pstmt.executeQuery();
						con.commit();
						System.out.println(YELLOW+"장바구니에 추가되었습니다!"+RESET);
					} catch (SQLException e) {
						System.out.println("(물건등록)DB에러:" + e.getMessage());
					} catch (Exception e) {
						System.out.println("(물건등록)기타에러:"+e.getMessage());
						
					} finally {
						DB.close(rs, stmt, con);
					}
					
	 }
//==============================================================================================================
	 public void AllprintCart(String userno) {
		 try {
			con = DB.con();
			con.setAutoCommit(false);	
			
			String sql = "SELECT p.PRODUCTNAME, b.BUYCOUNT, b.TOTPRICE  FROM buycart b,PRODUCT p \r\n"
					+ "WHERE b.ISBN =p.ISBN \r\n"
					+ "AND USERNO =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userno);
			rs = pstmt.executeQuery();
			System.out.println("------------<"+userno+"님의 장바구니 목록>------------");
			while(rs.next()) {
				System.out.print("<구매품명:"+rs.getString(1)+" | ");
				System.out.print("구매갯수:"+rs.getInt(2)+" | ");
				System.out.println("총 가격"+rs.getInt(3)+">");
			}
			System.out.println("------------------------------------------------");
			con.commit();
		} catch (SQLException e) {
			System.out.println("(물건등록)DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("(물건등록)기타에러:"+e.getMessage());
			
		} finally {
			DB.close(rs, stmt, con);
		}
			
	 }
//==============================================================================================================
	 public void DeleteCart(String userno) {
		 try {
			con = DB.con();
			con.setAutoCommit(false);	
			do {
			String sql = "SELECT p.PRODUCTNAME, b.BUYCOUNT, b.TOTPRICE  FROM buycart b,PRODUCT p \r\n"
					+ "WHERE b.ISBN =p.ISBN \r\n"
					+ "AND USERNO =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userno);
			rs = pstmt.executeQuery();
			System.out.println("------------<"+userno+"님의 장바구니 목록>------------");
			while(rs.next()) {
				System.out.print("<구매품명:"+rs.getString(1)+" | ");
				System.out.print("선택갯수:"+rs.getInt(2)+" | ");
				System.out.println("총 가격"+rs.getInt(3)+">");
			}
			System.out.println("------------------------------------------------");
			
			System.out.println("삭제를 원하시는 물품명을 입력해주세요('종료'입력 시, 삭제기능을 종료합니다.)");
			System.out.print("물품명입력:");
			deletecart=scan.nextLine();
			
			String sql2 = "DELETE buycart\r\n"
					+ "WHERE userno=?\r\n"
					+ "AND isbn=(SELECT isbn\r\n"
					+ "			FROM PRODUCT p\r\n"
					+ "			WHERE PRODUCTNAME =?)";
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, userno);
			pstmt.setString(2, deletecart);
			rs = pstmt.executeQuery();
			con.commit();
			}while(!deletecart.equals("종료"));
			System.out.println("삭제를 완료하였습니다. 감사합니다.");
		} catch (SQLException e) {
			System.out.println("(물건등록)DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("(물건등록)기타에러:"+e.getMessage());
			
		} finally {
			DB.close(rs, stmt, con);
		}
			
	 }
//==============================================================================================================
	
	public static void main(String[] args) {
		BCDao.DeleteCart("Member-23");
	}

}
