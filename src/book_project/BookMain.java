package book_project;

import java.time.LocalDate;
import java.util.Scanner;

import book_project.Sign_User;

public class BookMain {
	static Scanner scan = new Scanner(System.in, "EUC-KR");
	static LocalDate now = LocalDate.now();

	static Ship sh = new Ship();
	static Program pg = new Program();
	static Sign_User SUDao = new Sign_User();
	static Books BDao = new Books();
	static Library Ly = new Library();
	static Rental RDao = new Rental();
	static QnA qa = new QnA();

	public static String shipwhether;
	public static int returndate;
	public static final String RESET = "\u001B[0m";
	public static final String FONT_GREEN = "\u001B[36m"; 
	public static final String YELLOW = "\u001B[33m";
	 public static final String RED      = "\u001B[31m" ;
	public static String ShortBar = YELLOW+"*----------------------------------------------------------*"+RESET;
	public static String LongShortBar = YELLOW+"*------------------------------------------------------------------------------------*"+RESET;
	public static String munuipryck = FONT_GREEN+"메뉴번호입력:"+RESET;
	public static void main(String[] args) {

		boolean end = true;
		do {
			System.out.println(ShortBar);
			System.out.println(" <안녕하세요. 원하시는 메뉴가 있으시다면, 해당 숫자를 입력해주세요>");
			System.out.println("  1.회원가입  2.로그인   3.회원탈퇴  4.비밀번호 찾기 5.종료 ");
			System.out.println(ShortBar);
			System.out.print(munuipryck);
			int selecMenu = scan.nextInt();
			if (selecMenu == 1) {SUDao.SignUp_User();} // 회원 가입 기능메서드
			else if (selecMenu == 2) {SUDao.Login_User(); // 로그인 기능메서드
		//================== 로그인 완료시, '관리자'일 경우 메뉴출력===================================================
				    if (SUDao.LoginDivnum == 1) {
					boolean end2 = true;
					do {
						System.out.println(LongShortBar);
						System.out.println("1.도서목록조회 2.도서작업 3.공지사항 4.대여 정보 5.도서관 위치확인 6.회원 조회 7.문의답변기능 8.로그아웃");
						System.out.println(LongShortBar);
						System.out.print(munuipryck);
						int selecMenu2 = scan.nextInt();
						
						if (selecMenu2 == 1) { //관리자 큰 메뉴에서 '도서목록조회'
							System.out.println(ShortBar);
							System.out.println("1.도서목록 전체 조회 2.이름으로 검색 3.분류별 도서 조회 4.뒤로가기");
							System.out.println(ShortBar);
							System.out.print(munuipryck);
							int selecMenu7 = scan.nextInt();
							if (selecMenu7 == 1) {BDao.showBookAllList();} 
							else if (selecMenu7 == 2) {BDao.showBook_Name_print();}
							else if (selecMenu7 == 3) {BDao.showBook_Genre_print();}
							else {System.out.println("이전 페이지로 이동합니다.");}
							
						} else if (selecMenu2 == 2) {
							boolean Menu2 = true;
							do {
							System.out.println(ShortBar);
							System.out.println("1.도서 등록 2.도서 수정 3.도서 삭제 4.뒤로가기");
							System.out.println(ShortBar);
							System.out.print(munuipryck);
							int selecMenu3 = scan.nextInt();
							if (selecMenu3 == 1) {BDao.registBook();} 
							else if (selecMenu3 == 2) {BDao.updateBook();} 
							else if (selecMenu3 == 3) {BDao.deleteBook();} 
							else if (selecMenu3 == 4){System.out.println("이전페이지로 이동합니다."); Menu2 = false;}
							else {System.out.println(RED+"!!"+RESET+"메뉴에 없는 번호입니다. 다시입력해주세요"+RED+"!!"+RESET);}
							}while(Menu2);
						} 
						else if (selecMenu2 == 3) {
							System.out.println(ShortBar);
							System.out.println("1.주간프로그램 등록 2.주간 프로그램 삭제 3.주간프로그램 정보조회 4.독서왕이벤트 5.뒤로가기");
							System.out.println(ShortBar);
							System.out.print(munuipryck);
							int selecMenu4 = scan.nextInt();
							if (selecMenu4 == 1) {pg.insertPro(SUDao.LoginUserno);} // 주간프로그램 등록
							else if (selecMenu4 == 2) {pg.DeleteProgramAll();} // 주간프로그램 삭제
							else if (selecMenu4 == 3) {pg.ProgramAllPrint();} // 주간프로그램 목록 조회
							else if (selecMenu4 == 4) {pg.BookKing_Top3();} // 독서왕 top3조회
							else {System.out.println("이전페이지로 이동합니다.");}

						} 
						else if (selecMenu2 == 4) {
							System.out.println(ShortBar);
							System.out.println("1. 반납여부 갱신 2.대여 목록 확인하기 3.뒤로가기");
							System.out.println(ShortBar);
							System.out.print(munuipryck);
							int selecMenu8 = scan.nextInt();
							if (selecMenu8 == 1) {RDao.UpdateRentWhe();} // 대여여부 갱신하기
							else if (selecMenu8 == 2) {RDao.PrintRentalList();} // 대여목록 전체 출력
							else {System.out.println("이전페이지로 이동합니다.");}
							} 
						else if (selecMenu2 == 5) {Ly.showLibrary_print();//도서관 목록 출력
						}  
						else if (selecMenu2 == 6) {
							System.out.println(ShortBar);
							System.out.println("1.회원 전체 조회 2.이름 검색조회 3.연체자 목록 조회 4.뒤로가기");
							System.out.println(ShortBar);
							System.out.print(munuipryck);
							int selecMenu6 = scan.nextInt();
							if (selecMenu6 == 1) {SUDao.UserListAllPrint();}  //회원목록 전체 출력
							else if (selecMenu6 == 2) {SUDao.UserPrint_Name();} // 이름으로 회원 정보 조회
							else if (selecMenu6 == 3) {SUDao.WarningUserSch();} // 연체횟수1회이상 회원조회
							else {System.out.println("이전페이지로 이동합니다.");}
						} 
						
						else if (selecMenu2 == 7) {
							boolean menu10 = true;
							do {
								System.out.println(ShortBar);
								System.out.println("1.문의목록 전체 조회  2.답변하지않은 목록조회  3.문의답변하기 4.뒤로가기");
								System.out.println(ShortBar);
								System.out.print(munuipryck);
								int selecMenu10 = scan.nextInt();
								if (selecMenu10 == 1) {qa.QnA_AllPrint();} // 문의하기 전체 출력
								else if (selecMenu10 == 2) {qa.QnA_NoAnswerPrint();} // 답변되지않은 목록 출력
								else if (selecMenu10 == 3) {qa.updateAnswer();} // 문의 답변하기
								else if (selecMenu10 == 4){menu10 = false;}
								else {System.out.println(RED+"!!"+RESET+"메뉴에 없는 번호입니다. 다시입력해주세요"+RED+"!!"+RESET);}
							} while (menu10);
							} 
						
						else if (selecMenu2 == 8) {System.out.println("로그인 화면으로 이동합니다..");end2 = false;}
					} while (end2);

				} else if (SUDao.LoginDivnum == 2) {
					boolean end3 = true;
					do {
						System.out.println(LongShortBar);
						System.out
								.println("1.도서 목록 조회  2.대여하기  3.반납하기 4.연장하기  5.도서관 위치확인  6.공지사항  7.문의하기 8.비밀번호변경 9.로그아웃");
						System.out.println(LongShortBar);
						System.out.print(munuipryck);
						int selecMenu5 = scan.nextInt();
						
						if (selecMenu5 == 1) {
							System.out.println(ShortBar);
							System.out.println("1.도서목록 전체 조회 2.이름으로 검색 3.분류별 도서 조회 4.본인이 대여중인 목록조회 5.뒤로가기");
							System.out.println(ShortBar);
							System.out.print(munuipryck);
							int selecMenu9 = scan.nextInt();
							if (selecMenu9 == 1) {BDao.showBookAllList();}
							else if (selecMenu9 == 2) {BDao.showBook_Name_print();}
							else if (selecMenu9 == 3) {BDao.showBook_Genre_print();}
							else if (selecMenu9 == 4) {RDao.RentalList_Userno(SUDao.LoginUserno);}
							else  {System.out.println("이전 페이지로 이동합니다.");}
						}
						
						else if (selecMenu5 == 2) {RDao.totalRent(SUDao.LoginUserno);} 
						else if (selecMenu5 == 3) {RDao.totalreturn(SUDao.LoginUserno);} 
						else if (selecMenu5 == 4) {RDao.updateReturnDate(SUDao.LoginUserno);} 
						else if (selecMenu5 == 5) {Ly.showLibrary_print();} 
						else if (selecMenu5 == 6) {pg.ProgramAllPrint();} // 주간프로그램 목록 조회
						else if (selecMenu5 == 7) {
							System.out.println(ShortBar);
							System.out.println("1.본인 문의목록 조회  2.문의하기  3.뒤로가기");
							System.out.println(ShortBar);
							System.out.print(munuipryck);
							int selecMenu11 = scan.nextInt();
							if (selecMenu11 == 1) {qa.QnA_Print_Userno(SUDao.LoginUserno);} 
							else if (selecMenu11 == 2) {qa.insertQnA(SUDao.LoginUserno);} 
							else {System.out.println("이전페이지로 이동합니다.");}
						}
						else if (selecMenu5 == 8) {SUDao.UpdatePass();}
						else if (selecMenu5 == 9) {System.out.println("로그인 화면으로 이동합니다.");end3 = false;}
						else {System.out.println(RED+"!!"+RESET+"메뉴에 없는 번호입니다. 다시입력해주세요"+RED+"!!"+RESET);}
					} while (end3);
				}
			} else if (selecMenu == 3) { SUDao.deleteUser();}// 회원 탈퇴(삭제) 
			else if (selecMenu == 4) { SUDao.FindPass_NameRrn(SUDao.sname, SUDao.srrn);} // 비밀전호 찾기
			else if (selecMenu == 5) {end = false;System.out.println("이용해주셔서 감사합니다.");}
			else {System.out.println(RED+"!!"+RESET+"메뉴에 없는 번호입니다. 다시입력해주세요"+RED+"!!"+RESET);}
		} while (end);

	}
}
