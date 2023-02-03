package a04_process;

import java.util.Scanner;

public class A08_While {

	public static void main(String[] args) {
		/*
		 #while문 : 조건에 따라 반복을 계속할지 결정할 때 사용
		 	1. 형식
		 	while(반복조건){
		 	 조건이 true일 때, 반복처리...
		 	}
		 	
		 
		 */
		
		int i = 1;
		while (i<=10) {
			System.out.println(i++);
		}
		i=1;
		Scanner sc=new Scanner(System.in);
		while(true) {//무한루프
			System.out.println("카운트:" +(i++));
			System.out.println("계속하실려면 Y:");
			String iscon = sc.nextLine();
			if(!iscon.equals("Y")) {
				break; //반복 중단처리
			}
			}
		System.out.println("프로그램 종료");
		
		
		// ex) while문을 이용해서 100부터 90까지 출력
		/*
		int i2=100;
		while(i2>=90) { //i2가 90보다 클때만 반복!
			System.out.println(i2--);
		}
		*/
		Scanner sc1=new Scanner(System.in);
		int applePay = 1200;
		int count1= 1;
		while(true) { // break를 만나기전까지 계속 반복
			System.out.println("현재"+count1+"개이며, 금액 : "+count1*applePay+"원 입니다. 더 구매하시겠습니까?");
			String yes = sc1.nextLine();
			if(yes.equals("Y")) {
				count1++;
			}else {
				break;
			}
			
		}
		System.out.println("계산끝 감사합니다.");
		
		
		
}
}


