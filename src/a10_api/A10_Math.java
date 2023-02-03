 package a10_api;

public class A10_Math {

	public static void main(String[] args) {
		
		/*
		 #API내용
		 class Math
		 static double abs(double)
		 static : 객체생성없이 클래스명으로 사용가능
		 	ex)Math.abs(1.14)
		 double : 이 메서드를 호출할 때, 결과값은 어떤 유형
		 abs(double) :매개변수가 어떤 유형을 입력이 가능한지를 선언
		 
		 */
		/*
		 #Math클래스
		 1. 수학 계산에 사용할 수 있는 정적 메소드 제공
		 */
		// int        abs(int a)
		// 리턴값 유형  메소드명(매개변수 유형)
		System.out.println("Math.random():"+Math.random());
		int v01 = Math.abs(-5);
		// 숫자의 값을 절대값으로 출력하는듯
		System.out.println("Math.abs(-5):"+v01);
		//double abs(double a);
		System.out.println("Math.abs(3.14):"+Math.abs(-3.14));
		//double ceil(double a) : 올림값 처리
		System.out.println("Math.ceil(5.3):"+Math.ceil(5.3));
		//double floor(double a): 내림값 처리
		//ceil 및 floor는 리턴값이 실수 이기 때문에
		// 정수로 사용하려면 타입캐스팅이 필요하다.
		System.out.println("Math.floor(5.4):"+Math.floor(5.9));
		//int Math.max(int a,int b) : 둘중 최대값 리턴
		System.out.println("Math.max(3,9):"+Math.max(3, 9));
		//double min(double a, double b) : 둘중 최소값 리턴
		System.out.println("Math.min(3,5):"+Math.min(3, 5));
		//double rint(double 1) : 가까운 정수의 실수값(반올림과 같음..)
		System.out.println("Math.rint(5.5):"+Math.rint(5.5));
		System.out.println("Math.rint(5.5):"+Math.rint(5.4));
		//long round(double 1) : 반올림값
		System.out.println("Math.round(6.445):"+Math.round(6.445));
		System.out.println("Math.round(6.5):"+Math.round(6.5));
		
		//ex) 1~10까지의 임의의 수를 발생해서
		double num01 = ((int)(Math.random()*90+11))/10.0;
		double num02 = ((int)(Math.random()*90+11))/10.0;
		System.out.println("임의수1:"+num01);
		System.out.println("임의수1:"+num02);
		System.out.println("큰수:"+Math.max(num01, num02));
	}	

}
