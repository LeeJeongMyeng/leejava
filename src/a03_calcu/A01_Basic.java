package a03_calcu;

import java.util.Scanner;

public class A01_Basic {
	/*
	 #연산이란?
	 1. 데이터를 처리하여 결과를 산출하는 것
	 2. 연산자(operations)
	  	연산에 사용되는 표시나 기호
	  	=, _, *, /, %, =, !=, ........
	 3. 피연산자(operand)
	 	연산 대상이되는 데이터(리터럴, 변수)
	 4. 연산식(expressions)
	 	연산자와 피연산자를 이용하여 연산의 과정을 기술한 것
	 	ex) 25+2, num01+num02
	 
	 #연산자의 종류
	 1. 산술연산자 : +,-,*,/,%
	 
	 2. 부호: +, - ex)int num01 =25;        -num01; = -25
	 
	 3. 문자열: + 문자열과 문자열을 이어주는 역할
	 
	 4. 대입 : =
	 		왼쪽데이터에서 오른쪽 변수에 할당.
	 		int num01 = 25;
	 		증감대입 연산자
	 		num01 = num01+2;
	 		num01 += 2;
	 		num01 *= 2;
	 		
	 5. 증감 : ++, --
	 			변수를 1씩 증가 혹은 감소
	 			
	 6. 비교 : true/false인 boolean 값을 리턴처리
	 ==, !=(같지 않다)
	 int point=30;
	 system.out.println(point==20); false
	 system.out.println(point!=20); true
	 >, <, >=, <=
	 instanceof 객체참조
	 */
	//	 # (비교 연사자, 논리연산자)?true일때, false일때
	// 	 조건1?처리1:(조건2?저리2:조건3?처리3:그외처리))
	//  * 그외처리 조건1 조건2 조건3이 다 아닐때
	
	//point>=90?"A":(poing>=80?"B":
		//(point>=70?"C":(point>=60?"D":"F")));
	 
	 //ex
	 /*
	 7.논리
	 	비교 연산식이 2개이상 또는 not(1)를 처리시 사용.
	 	age>=14 && age<=18 두가지 비교 연산자가 모두 true
	 	일때, ture
	 	age>=14 || age<=18 두가지 비교 연산자중 하나라도  true 일때
	 	true
	 	
	 	ex) !(age>=14|| age<==18)
	 	!(age==13)
	 	
	 	#연산의 방향과 우선 순위
	 	1. 연산자의 방향은 기본적으로
	 			비교 연산자 : 왼쪽에서 오른쪽으로 처리된다.
	 			age>=14 & age<=18
	 			age가 14미만이더라도 age<=18을 체크한다.
	 			age>=14 && age<=18
	 			age가 14미만이면 age<=18을 체크하지않는다.
	 			
	 			대입 연산자 : 오른쪽에서 왼쪽으로 처리된다.
	 			age=10;
	 			
	 	2. 산술연산자 우선순위
	 			1. () 최상위 연산자  (2+5)*7 = 49
	 			2. 기본 사칙연산대로 곱,나눗셈부터 우선
	 			3. 덧셈 뺄셈
	 			
	 			ps) ()소괄호	{}중괄호	[]대괄호
	 			
	 	
	 			    
	 			
	 */
	public static void main(String[] args) {
	Scanner scan1 = new Scanner(System.in);
	System.out.println("오늘 날짜를 입력해주세요");
	int year = scan1.nextInt();
	int month = scan1.nextInt();
	int day = scan1.nextInt();
	
	Scanner scan2 = new Scanner(System.in);
	System.out.println("오늘 구매물건을 입력해주세요");
	String thing = scan2.nextLine();
	
	
	Scanner scan3 = new Scanner(System.in);
	System.out.println("금액은얼마인가요");
	int cost = scan3.nextInt();
	
	
	Scanner scan4 = new Scanner(System.in);
	System.out.println("수입은얼마인가요");
	int in1 = scan1.nextInt();
    int total = in1-cost;
	Scanner scan5 = new Scanner(System.in);
	System.out.println("오늘은"+year+"년 "+month+"월 "+day+"일 입니다.");
	System.out.println("오늘의 수입은 총 "+in1+"원이며");
	System.out.println("총 이익은 "+total+"원입니다.");
	
	//System.out.println("무엇을 구매했는지요?");
	//String thing = scan.nextLine();
	//System.out.println(thing);
		
		/*
		 #부호 연산자
		 피연산자에 부호 기호(+,-)를 붙여 양수와 음수를 처리하는 것을 말한다. 
		 
		 */
		/*
		int num =25;
		int num01 = -5;
		int num02 = -num;
		int num03 = -num01;
		System.out.println(num02);
		System.out.println(num03);
		*/

	}

}
