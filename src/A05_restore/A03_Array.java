/*package a0905.a05_restore;

import java.lang.reflect.Array;
import java.util.Scanner;

public class A03_Array {

	public static void main(String[] args) {
	
		/*
		 # 배열이란
		 1. 같은 타입의 데이터를 같은 이름으로 연속된 공간에 저장하는 
		    자료 구조를 말한다.
		 2. 같은 이름이기 때문에 각 구성데이터를 구분하는 구분자는
		 	Index로 0부터 시작하여 처리한다.
		 */
/*
			int num01 = 0;
			int[] array01 = {1000,2000,3000,4000};
			// array01[0] ~ array[3]으로 구분
			System.out.println(array01); //heap의 주소값
			System.out.println(array01[0]);
			String[] array02 = {"사과","바나나","딸기"};
			System.out.println(array02); //heap의 주소값
			System.out.println(array02[0]);
			
			// ex) 좋아하는 영화제목 3개 배열
			String[] array03 = {"바람","바람바람","바람바람바람"};
			System.out.println(array03);
			System.out.println(array03[0]);
			System.out.println(array03[1]);
			System.out.println(array03[2]);
			
			double[] array04 = {3.14,3.1414,3.1414}; 
			System.out.println(array04[0]);
			System.out.println(array04[1]);
			System.out.println(array04[2]);
			
			System.out.println(array04.length);
			// 배열의길이 출력
			
		String[] best = {"국수","국밥","고기","만두","라면"};
		System.out.println("#쩝쩝리스트#");
		for(int num02=0; num02<best.length; num02++) {
			System.out.println("맛집 "+(num02+1)+"번 :"+best[num02]);
		}
		/*
		/*
		 #배열의 처리
		 1. 배열의 선언
		 	 타입[] 변수명;
		 	 타입 변수명[];
		
		 2. 배열의 초기화
			 변수명 = null; //주소는 할당되지 않음.
		 3. 배열의 할당
		 	 1) 값이 할당되지 않았지만 주소는 생성된 경우
		 	 변수명=new 타입[크기];
		 	 2)선언 후 할당.
		 	 타입[] 변수명 = null;
		 	 변수명 = new 타입[]{데이터1, 데이터2, 데이터3};
		 	 타입[] 변수명 = {데이터1, 데이터2, 데이터3};
		 */
		/*
		int[] array10;
		int array11[];
		array10 = null;
		array11 = null;
		
		int[] array12 = null;
		array12 = new int[] {1000,2000,3000,};
		
		int[] array13 = new int[3];
		
		int[] array14 = {3000,4000,5000};
		
		System.out.println(array10);
		System.out.println(array11);
		System.out.println(array12);
		System.out.println(array13);
		System.out.println(array14);
		
		//ex) 도서명 배열, 운동선수 배열, 핸드폰회사배열을 선언,
		// 선언후 할당, 빈배열 3가지
		String[] books = null;
		
		String[] players = null;
		players = new String[] {"농구","야구","축구"};
		
		String[] phone = new String[3];
		
		System.out.println(books);
		System.out.println(players);
		System.out.println(phone);
		
		/*
		 #여러가지 응용 예지 활용하기
		 1. 배열의 index를 랜덤으로 호출하여 출력
		 */
/*
		String[]games = {"가위","바위","보"};
		int rdidx1 = (int)(Math.random()*games.length);
		int rdidx2 = (int)(Math.random()*games.length);
		System.out.println(games[rdidx1]+":"+games[rdidx2]);
		
		//ex 홀/짝 게임을 5회처리 출력
		String[] holjjack = {"홀","짝"};
		for(int num04=0;num04<=5;num04++);{
			int rdidx03 = (int)(Math.random()*holjjack.length);
		System.out.println(holjjack[rdidx03]);
		
		}
		
	
		/*
		 2.초기의 배열의 크기를 설정한 후, 데이터 할당 처리
		 */
		/*
		Scanner scan = new Scanner(System.in);
		System.out.println("등록할 회원 인원을 입력:");
		int cnt = Integer.parseInt(scan.nextLine());
		
		
		String []names = new String[3];
		System.out.println("#회원 3명의 이름을 입력하세요");
		
		for(int idx=0;idx<names.length;idx++) {
			System.out.println(idx+1+"번쨰 회원명: ");
			names[idx] = scan.nextLine();
		}
		System.out.println("#등록한 회원 명단#");
		for(int idx=0;idx<names.length;idx++) {
		System.out.println(idx+1+"번째 회원 = "+names[idx]);
		}
		
		
		// ex) 대출할 책의 수를 입력하고, 도서명을 입력후, 대출도서 리스트를 출력하세요
		
		Scanner scan1 = new Scanner(System.in);
		System.out.println("책 몇개?");
		int bookcnt1 = Integer.parseInt(scan1.nextLine());
		String[] bookname = new String[bookcnt1];
		
		for(int num05=0;num05<bookname.length;num05++) {
			System.out.println(num05+1+"번쨰 책: ");
			bookname[num05] = scan1.nextLine();
		}
		System.out.println("==대출 책명단==");
		for(int num06=0;num06<bookname.length;num06++) {
			System.out.println(num06+1+"번 책 : "+bookname[num06]);
		}
	
		// #포커게임
		String shape[] = {"◆","♥","♣","♠"};
		String[]num2 = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String cards[] = new String [52];
		int cIdX=0;
		for(int idx=0; idx<shape.length;idx++) {
			for(int jdx=0; jdx<num2.length; jdx++) {
				cards[cIdX++]=shape[idx]+""+num2[jdx];
				System.out.println(cards[cIdX]+",");
			}
		}
		System.out.println();
		System.out.println("#임의의 7장 카드#");
		for(int cnt=1; cnt<=7; cnt++) {
			int rIdX = (int)(Math.random()*cards.length);
			System.out.println(cards[rIdX]+",");
			*/
/*
		}
	}

}
*/