package a04_process;

import java.util.Scanner;

public class A04_For {

	public static void main(String[] args) {
		
/*
  # 반복문
  	1.  중괄호 블럭 내용을 반복적으로 실행할떄 사용한다.
 	2. 종류 : for문, while문, do-while문'
 	3. for문 : 반복 횟수를 알고 있을 때, 주로 사용
 			for(초기값설정1; 반복조건2; 증/감연산자4){
 			    반복처리 할 내용..3
 			    }
 			    1. 처리순서
 			    1,2,3,4,2,3,4,2,3,4...
 */
		/*
		System.out.println("반복문(카운트1~10");
	for(int cnt=1; cnt<=10; cnt++) {
		System.out.println(cnt+"번째 안녕하세요!!");
	}
		System.out.println("디스카운드(10~1");
		for(int cnt2 =10; cnt2>=0; cnt2--) {
			System.out.println("카운트다운"+ cnt2);
		}
		System.out.println("10부터 2씩증가");
		for(int cnt3 =10; cnt3<=50; cnt3+=2) {
			System.out.println("번호"+ cnt3);
		}
		*/
		//예제1
		/*
		for(int cnt4 =0; cnt4<=20; cnt4++) {
			System.out.println("번호"+ cnt4);
		}
			//예제2
			for(int cnt5 =100; cnt5>=80; cnt5--) {
				System.out.println("번호"+ cnt5);
			}
				//예제3
				for(int cnt6 =3; cnt6<=21; cnt6+=3) {
					System.out.println("번호"+ cnt6);
				}
				
				/*
				 #for문 밖 전역변후 활용
				 1. 누적된 변수를 사용해야할 경우, 반복문 밖에 선언하여
				 처리한다.
				 ex) 1~10의 총합구하기, 문자열 연결데이터 누적처리하기
				 */
				/*
				int tot = 0;
				for(int cnt7=1;cnt7<=10;cnt7++) {
					System.out.print(cnt7);
					if(cnt7!=10)System.out.print(" + ");
				tot+=cnt7; //cnt가 증가하면서 누적처리
	}
				System.out.println("="+tot);
				*/
				/*int tot2 = 2500;
				int tot3 = 0;
				for(int cnt8=1;cnt8<=20;cnt8++) {
					System.out.println("김밥 "+cnt8+"개의 가격은 "+cnt8*tot2+"원");
					tot3+=cnt8*tot2; //앞에 int tot3 변수 적용해줘야함
				}
				System.out.println("누적 총 "+tot3+"원 입니다.");
				
				*/
		/*
				for(int cnt9=2;cnt9<=9;cnt9++) {
					 for(int cnt10=1;cnt10<=9;cnt10++) {
						 System.out.println(cnt9*cnt10);
					 }
				}
				*/
		/*
				Scanner sc3 = new Scanner(System.in);
				System.out.println("단을 입력하세요");
				int googoo = sc3.nextInt();
				System.out.println(googoo+"단의 내용은");
				for(int cnt9=1;cnt9<=9;cnt9++) {
					System.out.println(cnt9*googoo);
				}
				System.out.println("입니다.");
				*/
		
		int num03 = 0;
		for(int cnt10=1;cnt10<=50;cnt10+=2) {
			System.out.println(cnt10);
			num03 +=cnt10;
		}
				System.out.println(num03);
		}
		
	}


