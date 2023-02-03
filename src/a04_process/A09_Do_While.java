package a04_process;

import java.util.Scanner;

public class A09_Do_While {

	public static void main(String[] args) {
		/*
		 # do-while문
		 	1. 조건에 따라 반복 계속할지 결정할 때, 사용하는 것은
		 		while문과 동일하다.
		 	2. 하지만, do-while문은 적어도 1번은 반복블럭{}의
		 	내용을 수행시켜준다.
		 	3. 기본 형식 
		 		do{
		 		1번 이상 반복할 구문
		 		}while(반복할 조건);	
		 */
		/*
		int count =1;
		do {
			System.out.println("카운트:"+count++);
		}while(count<=10);
		
		do {
			System.out.println("두번째 do while");
			System.out.println("카운트:"+count++); //조건은 해당 구문아래에 있으므로 1번은 진행됨
		}while(count<=10);
		*/
		
		Scanner sc1 = new  Scanner(System.in, "EUC-KR");
		String menu = "N";
		String totmenu = "";
		do {
			System.out.println("메뉴를 입력하세요, 중단하실려면 N을 입력하세요");
			menu = sc1.nextLine();
			if(!menu.equals("N")) {
				System.out.println("주문한 메유: "+menu);
				totmenu+=" "+menu; // +=2 2씩 더하는거에서 2를 ""+menu라고 생각해라
			}
					
		}while(!menu.equals("N"));
		System.out.println("주문종료!");
		System.out.println("주문하신 전체 메뉴: "+totmenu);
		
		
	}

}
