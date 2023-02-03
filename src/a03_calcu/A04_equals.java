package a03_calcu;

import java.util.Scanner;

public class A04_equals {

	public static void main(String[] args) {
		/*
		 #비교연산자
		 1. 두개의 피연산자의 값을 비교하여 동일한지(==)
		  	같지 않는지(!=), 큰지(>), 작은지(<), 등을
		  	boolean(true/false)값으로 결과를 처리하는 연산자를 말한다.
		  
		  2. 종류
		  ==, !=, >+, <=, >, <
		  
		  3. 활용
		  	조건문이나 반복문에 처리할 때, 사용된다.
		 
		 */
			int num01 =25;
			int num02 = 5;
			System.out.println("#비교 연산 결과#");
			System.out.println(num01+" == "+num02+" = "+(num01==num02));
			System.out.println(num01+" != "+num02+" = "+(num01!=num02));
			System.out.println(num01+" >= "+num02+" = "+(num01>=num02));
			System.out.println(num01+" <= "+num02+" = "+(num01<num02));
			System.out.println(num01+" < "+num02+" = "+(num01<num02));
			System.out.println(num01+" > "+num02+" = "+(num01>num02));

			Scanner exp = new Scanner(System.in);
			System.out.println("몇점이고?");
			int exp1 = exp.nextInt();
			Scanner goal = new Scanner(System.in);
			System.out.println("커트라인은 몇이고?");
			int goal1 = goal.nextInt();
			
			System.out.println("당신은"+(goal1<=exp1)+"입니다.");
			
			int num5 = 1;
			int num6 = 2;
			int num7 = 3;
			int num8 = 4;
			
			Scanner ok1 = new Scanner(System.in);
			System.out.println("몇번이고");
			int ok2 = ok1.nextInt();
			System.out.println((ok2==num7)+"입니다.");
	}
	
}
