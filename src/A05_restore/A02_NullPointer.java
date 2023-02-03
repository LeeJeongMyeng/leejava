package A05_restore;

public class A02_NullPointer {

	public static void main(String[] args) {
		/*
		 #기본 데이터의 초기값 설정
		  */
		int num01;
		num01 = 10; // 10이라는 변수로 초기화 하지않으면 쓸수없다.
		//초기 데이터를 0 :stack
		System.out.println(num01);
		Person p01;
		//System.out.println(p01); //초기화 하지않아서 사용불가
		p01= null; // 객체는 초기화를 stack영역에 'null'
					// null이라는 것으로 초기화는 되어있지만
					//heap영역의 객체는 생성되지 않았다.
	
		System.out.println(p01);
		//System.out.println(p01.age);
		//객체가 heap영역에 생성되지않았을 때, 고성요소를 호출하면 runtime error 
		//NullPointerException 발생
		//ex) 도서관에 해당 번호에 있어야 할 자리에 책이 없음
		//    그 책의 50페이지를 확인하려는것과 비유가능
		p01= new Person();
		System.out.println(p01);
		p01.age=25;
		System.out.println(p01.age);
		//모든 객체는 객체가 생성됨과 동시에 구성요소들이 초기화된다.
		//숫자는0, 객체(String포함) Null
		
	
	}

}

class Person{
	int age;
	
} //사용정의  class선언

