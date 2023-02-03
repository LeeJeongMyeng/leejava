package a08_inheritance;

public class A01_Begin {

	public static void main(String[] args) {
		
		/*
		 #상속이란?
		 1. 현실
		 	1) 부모가 자식에게 물려주는 행위
		 	2) 부모가 자식을 선택해서 물려줌
		 2. 객체 지향 프로그램
		 	1) 자식(하위,파생) 클래스가 부모(상위)클래스의 멤버를 물려받는 것
		 	2) 자식이 부모를 선택해 물려받음
		 	3) 상속대상: 부모의 필드와 메소드
		 	
		 ex) 
		 	class Parent{
		 	String name;
		 	void call(){
		 	system.out.println("이름"+name);
		 		}
		 	}
		 	
		 	class child extends Parent{ //Parent의 필드와 메소드를 물려받음
		 								//(name, call())을 선언한것과 동일한 효과
		 	
		 	String gender;
		 	void showAll(){
		 			call(); // 부모의 매소드를 사용
		 	system.out.println("성별:"+gender);
		 	}
		 	
		 # 상속(ingeritance)개념과 활용
		 1. 상속의 효과
		 	1) 부모 클래스 재사용해 자식 클래스 빨리 개발 가능
		 	2) 반복된 코드 중복을 줄임
		 	3) 유지보수 편리성 제공
		 	4) 객체 다형성 구현가 능
		 2. 상속 대상 제한
		 	1) 부모 클래스의 private접근 갖는 필드와 메소드는 제외
		 	2) 부모클래스가 다른패키지일 경우 default의 필드와 메소드도 제외
		 	ps) super()생성자나 public 기능 메서드를 통해서 간적적으로
		 		필드의 값을 할당하거나, 호출할 수 있다.
		 	3) protected : 상속관계에 있으면 해당 접근제어자로 선언되어 있으면
		 					접근이 가능하다.(필드와메서드)
		 #extends 키워드
		 1. 자식 클래스가 상속할 부모 클래스를 지정하는 키워드
		 	class Child extends Parent{}
		 2. 자바는 단일 상속==> 부모 클래스를 여러개 나열 불가하다.
		 	class Child extends Parent1,Parent2,Parent3...{} ==> X
		 */
	
		Daughter d1 = new Daughter();
		//System.out.println(d1.charac);
		//d1.cooking();
		d1.callTalent();
		son01 s1 = new son01();
		s1.showAll();
	}

}
class Mother{
	String charac ="현명하다";
	void cooking() {
		System.out.println("요리를 잘한다.");
	}
}

class Daughter extends Mother{
	String goodPoint="주위사람을 밝게한다.";
	void callTalent() {
		System.out.println("#딸의 재능#");
		System.out.println(charac);
		cooking();
		System.out.println(goodPoint);
	}
}

//아빠( 모습 통통, running() 빠르게뛴다.
class Father{
	String body = "통통하다.";
	void running() {
		System.out.println("달리기가 빠르다");
	}
}
class son01 extends Father{
	String long1 ="키가 크다.";
	void showAll() {
		System.out.println("아들==");
		System.out.println(long1);
		System.out.println("아빠==");
		running();
		System.out.println(body);
	}
}
//아들(키가 크다,showAll()-부모 구성+키
