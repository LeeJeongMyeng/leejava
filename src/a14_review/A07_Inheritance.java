package a14_review;

import java.util.ArrayList;
import java.util.List;

public class A07_Inheritance {

	public static void main(String[] args) {
		 Worker w1 = new PoliceMan(); w1.working(); w1.goWork(); // 상위클래스가 상속을 하면 다양한 형태로 메모리할당 가능
		 Worker w2 = new FireMan(); w2.working();
		 
		 //상위클래스에 리스트형 선언을 하고, 하위클래스에 대한 객체생성이 다형성에 의해서 가능
		 //1:다 관계의 마지막 단계인 추상화 클래스에 의한 다중의 객체 생성가능
		 List<Worker> wlist = new ArrayList<Worker>();
		 wlist.add(new PoliceMan());
		 wlist.add(new FireMan());
		 for(Worker w:wlist) {
			 w.working(); //for반복문을 통해서 각각의 기능메서드를 처리 가능
		 }
		 // 1:다관계에서 핵심클래스의 코드를 변경하지않고 , 상속받는 하위 클래스만 선언하면
		 // 확장적인 프로그램을 할 수 있는 처리를 할 수 있다.
		 
		// Larba l1 = new Dron();
		// Larba l2 = new Hydra();
	}

}
/*
#상속
 1. 다형성
 	같은타입이지만 실행결과가 다양한 객체를 대입할 수 있는 성질
 		-부모타입에는 모든 자식 객체가 대입
 		- 인터페이스 타입에는 모든 구현 객체가 대입
 		효과
 		-객체를 부품화 시키는것이 가능
 		- 유지보수가 용이하다.
 2. 추상클래스
 3. 인터페이스
 */
//Main() 상위객체= 하위객체
// 상위객체.메서드() :  하위객체의 재정의된 내용이 처리된다.
// Worker w1 = new PoliceMan(); w1.working(); 다양한 하위 형태를 변형하여 처리
// Worker w1 = new FireMan(); w2.working(); 
abstract class Worker{
/*
 상위클래스에 대한 생성은 필요가없고,
 다형성에 의해서 하위 객체를 통해서만 사용할 때, 즉! 상위 클래스가 추상화 될때..
 재정의 메서드 실제 ==> 추상메서드 변환
 추상메서드가 하나라도 있으면 ==> 추상클래스를 선언하여야한다.
 추상클래스를 상속받은 하위 클래스는 반드시 추상메서드를 재정의 해야한다.
   ==>컴파일에러 ==> 메서드명 통일을 유지 가능하다.
 */
	public void goWork() {
		System.out.println("출근하다.");
	}
	abstract void working();
	// void call(); -- 하위메서드에서 정의하지않았기에 해당 메서드가 실행되지않는다.
}
// PoliceMan p = new PoliceMan();
// p.call(); //0 하위에 추가적인 메서드는 하위 객체를 선언, 객체생성일떄가능

// Worker w1 = new PoliceMan(); // 상위클래스가 상속을 하면 다양한 형태로 메모리할당 가능
// w1.working();
class PoliceMan extends Worker{
	void working() {
		System.out.println("경찰이 도둑을 잡습니다.");
	}
}
//Worker w2 = new FireMan();
// w2.working(); 상위클래스에 정의된 메서드를 재정의
class FireMan extends Worker{
	void working() {
		System.out.println("소방관이 화재진압을 합니다.");
	}
}

/*
 추상메서드
  1. 기본 상속 구조
  2. 재정의 메서드
  3. 다형성 처리
  4. 추상클래스 필요성
  		- 하위 객체만 활용하는 경우
  		- 반드시 기능메서드 재정의 필요
 
 */

//==============숙제===================

abstract class Larba{
	private String ukind;
	
	public Larba(String ukind) { //매개변수 1개의 생성자
		this.ukind=ukind;
	}
	void moving() { //공통메서드
		System.out.println(ukind+"이(가) 이동합니다.");
	}
	
	public String getUkind() {
		return ukind;
	}
	abstract void attack();
}


class Dron extends Larba{

	public Dron(String ukind) {//상속은 상위에 생성자를 반드시 호출해야한다.
		super("드론"); //super는 첫라인에 선언한다. 상위클래스에서 선언한 생성자 호출을한다.
	}
	
	void attack() { // 추상클래스의 경우 추상메서드를 재정의해야한다.
		System.out.println(getUkind()+"아주 미약하게 원거리 공격을 한다.");
	}
}

class Hydra extends Larba{

	public Hydra(String ukind) {//상속은 상위에 생성자를 반드시 호출해야한다.
		super("히드라"); //super는 첫라인에 선언한다. 상위클래스에서 선언한 생성자 호출을한다.
	}
	
	void attack() { // 추상클래스의 경우 추상메서드를 재정의해야한다.
		System.out.println(getUkind()+" 보통 원거리 공격을 한다.");
	}
}