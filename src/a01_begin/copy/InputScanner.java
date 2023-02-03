package a01_begin.copy;

import java.util.Scanner;

public class InputScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 #외부데이터 입력(Scanner)
		 1. 내장 된 객체를 사용하는 방법
		 		1)import를 통해 선언
		 			import java.util.Scanner;
		 			클래스명 위에 선언.

		 2. 객체의 생성
		 		1) 객체 유형 참조변수 = new객체유형();
				2) 객체 유형에 생성되는 생성자의 매개변수로
				   기본 입력 Stream인 Sysout.in로 전달한다.
				   ps)
				   System.out :  기본출력 객체
				   System.in :  기본입력 객체
				   
		 3. 객체의 메서드를 활용하여 데이터를 입력받기 처리
		  	1) 문자열형 데이터
		  			입력 후, enter를 입력시까지(줄이 바뀌기전까지)
		  			입력처리 메서드 .nextLine()
		  	2) 숫자형 데이터
		  	.nextInt() : 정수형 데이터 입력
		  	.nextDouble() : 실수형데이터 입력		 
		 */
		
		try (Scanner sc01 = new Scanner(System.in)) {
			/*
			System.out.println("데이터를 입력하세요!!");
			String strData01 = sc01.nextLine();
			System.out.println("입력된 문자열 출력:"+strData01);		
*/
			System.out.println("과일의 가격을 입력하세요");
			int fruPrice = sc01.nextInt();
			System.out.println("과일의 중량을 입력하세요");
			double fruWeight = sc01.nextDouble();
			System.out.println("과일의 가격 : " +fruPrice+"원");
			System.out.println("과일의 무게 : " +fruWeight+"kg");
			System.out.println("kg당" +fruPrice/fruWeight);
		}
		
	}

}
