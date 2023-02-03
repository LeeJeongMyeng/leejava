package a08_inheritance;

public class A03_Overriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PoliceMan pm = new PoliceMan();
		pm.working();
		FireMan fm = new FireMan();
		fm.working();
		Programmer pm1= new Programmer();
		pm1.working();
		SmsumEle sm = new SmsumEle();
		sm.earnmoney();
		HyunDea hd = new HyunDea();
		hd.earnmoney();
	}

}
/*
 # 메소드 재정의(override) ps)overloading
 1. 부모 클래스의 상속 메소드를 동일한 이름으로 수정해서 자식 클래스에서
 	재정의하는 것이다.
 2. 목적
 	1) 동일한 이름이지만 여러형태로 자식 클래스에서 기능적 처리를 하고자 할 때,
 		활용된다.
 		- 주로 다형성 (polymorphism)을 위해 사용된다.
 			상위 클래스 = 하위 클래스
 			cf) Object s = 모든 클래스();
 			
 		- 상위 클래스에 메모리에 상속받은 여러가지 하위 클래스가
 			객체를 생성하면 사용할 수 있다.(다형성)
 */

// compant 필드:회사명 , 생성자 (회사명), earnMoney() @@회사 돈을 번다.
// 하위 SmsumEle 오버라이딩-전자제품을 만든다.
//		HyunDea 오버라이딩-배를 건조한다.

class Company{
	private String name;
	// Worker(){}
	public Company(String name) {
		this.name = name;
	}
	public void earnmoney() {
		System.out.println(this.name+"회사 돈을 번다.");
	}
}
class SmsumEle extends Company{

	public SmsumEle() {
		super("삼성전자");
		
	}
	public void earnmoney() {
		super.earnmoney(); //상위에 있는 메서드를 호출 super. : 동일한 이름의 메서드가 있을떄 (재정의시) 구분하기위해 사용
		System.out.println("전자 제품을 만든다.");
	}
}
class HyunDea extends Company{

	public HyunDea() {
		super("현대");
		
	}
	public void earnmoney() {
		super.earnmoney(); //상위에 있는 메서드를 호출 super. : 동일한 이름의 메서드가 있을떄 (재정의시) 구분하기위해 사용
		System.out.println("배를 만든다.");
	}
}

//ex) Programmer  클래스선언 하고 매서드 재정의 하여 출력

class Programmer extends Worker{

	public Programmer() {
		super("프로그래머");
		
	}
	public void working() {
		super.working(); //상위에 있는 메서드를 호출 super. : 동일한 이름의 메서드가 있을떄 (재정의시) 구분하기위해 사용
		System.out.println("소프트 웨어 개발을 하다.");
	}
}

class Worker{
	private String kind;
	// Worker(){}
	public Worker(String kind) {
		this.kind = kind;
	}
	public void working() {
		System.out.println(this.kind+"열심히 일을 한다.");
	}
}

class PoliceMan extends Worker{

	public PoliceMan() {
		super("경찰관");
		
	}
	public void working() { //overriding은 1. 상위와 동일한 이름으로 메서드를 정의
		super.working();
		System.out.println("치안을 위한 일을한다.");
	}
}

class FireMan extends Worker{

	public FireMan() {
		super("소방관");
	}
	public void working() { //overriding은 1. 상위와 동일한 이름으로 메서드를 정의
		super.working();
		System.out.println("불을 끄는 일을한다.");
	}
	
}

