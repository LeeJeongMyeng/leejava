package a02_;

public class A03_StringTypeCh {

	public static void main(String[] args) {
		/*
		 # 문자열 데이터에 대한 숫자형 처리
		  1. 문자열 ==> 숫자
		  	1) 정수형
		  		"25" ==> 25
		  		Integer.parseInt("25");
		  		==> 정수형 25로 변환이 된다.
		  		int에 할당도하고, 숫자형과 연산이 가능하다.
		  	
		  	2) 실수형
		  	"3.14" ==> 3.14
		  	Double.parseDouble("3.14")
		  	
		 
		 */
String numStr = "25"; //숫자형 문자열
//전제 조건으로 숫자형인 문자열이어야 처리가 가능하다.
// "이십오" ==> 이건 안댐
System.out.println(30+Integer.parseInt(numStr));
int num01 = Integer.parseInt(numStr);
System.out.println(10+num01);
System.out.println(10 + numStr);

String num02Str = "3.14";
double A = 50.14;
System.out.println(50.14+Double.parseDouble(num02Str));
double num2 = Double.parseDouble(num02Str);
System.out.println(50.15+num2);
System.out.println(A + num2);





	}

}
