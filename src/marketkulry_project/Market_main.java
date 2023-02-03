package marketkulry_project;

import java.time.LocalDate;
import java.util.Scanner;

public class Market_main {
	static Scanner scan = new Scanner(System.in, "EUC-KR");
	static LocalDate now = LocalDate.now();

	public static String ShortBar = "*----------------------------------------------------------*";
	public static String LongShortBar = "*------------------------------------------------------------------------------------*";
	public static String munuipryck = "메뉴번호입력:";

	static Marketuser2 MarketDao2 = new Marketuser2();
	static Product PDDao = new Product();
	static Buycart BCDao = new Buycart();
	static Buylist BLDao=new Buylist();
	public static void main(String[] args) {

		
		
		

		boolean EndMainMenu = true;
		do {
			System.out.println(ShortBar);
			System.out.println(" <안녕하세요 마켓컬리입니다.>");
			System.out.println(" <원하시는 메뉴가 있으시다면, 해당 숫자를 입력해주세요>");
			System.out.println("  1.회원가입  2.로그인   3.회원탈퇴  4.비밀번호 찾기 5.종료 ");
			System.out.println(ShortBar);
			System.out.print(munuipryck);
			int selecMainMenu = scan.nextInt();
			if(selecMainMenu==1) {MarketDao2.SignUp_User();}
			if(selecMainMenu==2) {MarketDao2.Login_User();
			if (MarketDao2.LoginDivnum == 1) {
				boolean selectMgrMenu = true;
				do {
					System.out.println(LongShortBar);
					System.out.println("1.물품조회 2.물품작업 3.공지사항 4.구매 정보 5.회원 조회 6.문의답변기능 7.로그아웃");
					System.out.println(LongShortBar);
					System.out.print(munuipryck);
					int selectMgrMainMenu = scan.nextInt();
					if(selectMgrMainMenu==1) {PDDao.AllprintProduct();}
					else if(selectMgrMainMenu==2) {
						boolean ProductMenu=true;
						do {
						System.out.println(LongShortBar);
						System.out.println("1.물품등록 2.물품삭제 3.물품정보수정 4.뒤로가기");
						System.out.println(LongShortBar);
						int SelectProductMenu = scan.nextInt();
						if(SelectProductMenu==1) {PDDao.Insert_Product();}
						else if(SelectProductMenu==2) {PDDao.deleteProduct();}
						else if(SelectProductMenu==3) {System.out.println("물품수정만드는중");}
						else{System.out.println("이전페이지로 이동합니다."); ProductMenu=false;}
						}while(ProductMenu);
					}
					else if(selectMgrMainMenu==3) {System.out.println("공지사항만드는중");}
					else if(selectMgrMainMenu==4) {System.out.println("구매 정보만드는중");}
					else if(selectMgrMainMenu==5) {MarketDao2.AllprintUser();}
					else if(selectMgrMainMenu==6) {System.out.println("문의답변기능만드는중");}
					else if(selectMgrMainMenu==7) {System.out.println("로그아웃, 메인화면으로 돌아갑니다.");selectMgrMenu=false; }
				}while(selectMgrMenu);
			}
			if (MarketDao2.LoginDivnum == 2) {
				boolean selectMemberMenu = true;
				do {
				System.out.println(LongShortBar);
				System.out.println("1.물품조회 2.쇼핑하기 3.장바구니  4.주문하기 5.결제하기 6.주문 취소하기 7.로그아웃");
				System.out.println(LongShortBar);
				System.out.print(munuipryck);
				int selectMemberMainMenu = scan.nextInt();
				if(selectMemberMainMenu==1) {PDDao.AllprintProduct();}
				else if(selectMemberMainMenu==2) {BCDao.Final_cart(MarketDao2.LoginUserno);}
				else if(selectMemberMainMenu==3) {
					System.out.println(LongShortBar);
					System.out.println("1.장바구니 목록확인 2.장바구니 물품삭제 3.뒤로가기");
					System.out.println(LongShortBar);
					int SelectCartMenu = scan.nextInt();
					if(SelectCartMenu==1) {BCDao.AllprintCart(MarketDao2.LoginUserno);}
					else if(SelectCartMenu==2) {BCDao.DeleteCart(MarketDao2.LoginUserno);}
					else if(SelectCartMenu==3) {}
				}
				else if(selectMemberMainMenu==4) {BLDao.Insert_buy(MarketDao2.LoginUserno);}
				else if(selectMemberMainMenu==5) {BLDao.Payment(MarketDao2.LoginUserno);}
				else if(selectMemberMainMenu==6) {BLDao.DeleteBuyList(MarketDao2.LoginUserno);}
				else if(selectMemberMainMenu==7){System.out.println("로그아웃, 메인화면으로 돌아갑니다.");selectMemberMenu=false; }
				}while(selectMemberMenu);
				}}
			
			if(selecMainMenu==3) {MarketDao2.deleteUser();}
			if(selecMainMenu==4) {MarketDao2.FindPass_NameRrn();}
			if(selecMainMenu==5) {EndMainMenu=false; }

		}while(EndMainMenu);System.out.println("지금까지 마켓컬리였습니다. 이용해주셔서 감사합니다~^^ ");

	}

}
