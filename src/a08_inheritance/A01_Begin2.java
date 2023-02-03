package a08_inheritance;

public class A01_Begin2 {

	public static void main(String[] args) {
		/*
		 # 상속 관계 내열화(a04_inheritance)
		 	1. 상속관계의 사용 목적 이해
		 		재활용성
		 		응집성 :  하나의 기능이 추가되더라도 다른 기존의 기능에 영향이 없고
		 				효과적으로 기능 추가를 할 수 있는 성질
		 				
		 	2. 상속관계의 기본형식
		 		하위실제클래스 extends 상위클래스1, 상위클래스2(X){}
		 		하위실제클래스 implments 상위인터페이스1, 상위인터페이스2(O)..{}
		 	
		 	3. 상속에서 사용되는 주요 용어
		 		오버라이딩(overiding) 
		 		 	재정의로 상위에 있는 클래스(추상/인터페이스 포함)의 메서드을 
		 			하위클래스에서 재정의하여 사용하는 것
				다형성(polymorphism)
					상위클래스에 상속받은 하위클래스가 선언되어 있으면
					상위클래스 = 하위클래스 형태로 여러개의 하위클래스의 내용을
					다양한 객체 생성을 할 수 있는 것을 말한다.
		 		추상클래스
		 			하위 클래스의 메서드 통일(기능적 선언 통일)을 위해
		 			상위에 추상 메서드를 선언하여 상속받은 하위 클래스는 반드시
		 			상위 추상메서드를 재정의하도록 강제화하는 클래스를 말한다. 
		 			추상이란 개념에서도 나타나듯이 실제 객체를 생설할 수 없다.
		 			- 추상메서드(다양한 형태의 기능구현)
		 			- 구상(실제)메서드 (공통적인 기능활용)
		 		인터페이스 
		 		
		 	4. 상속관계단계별 특징
		 		1) 구상(실제클래스)vs 구상(실제클래스) : 주로 재활용 목적
		 		2) 추상클래스 vs 실제클래스 : 하위 메서드 통일 + 재활용
		 		3) 인터페이스 vs 실제 클래스 : 응집성이 강력한 구조로 클래스 설계 목적
		 		4) 복합적인 상속 관계 설정
		 			인터페이스 vs 인터페이스
		 			추상 + 인터페이스 + 실제클래스
		 */

	}

}