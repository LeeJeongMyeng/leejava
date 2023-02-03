package a08_inheritance;

public class A05_AbstractClass {

	public static void main(String[] args) {
	//	Comp com = new Comp(); //추상클래스는 하위 클래스의 다형성을 위한 클래스이기에 혼자 객체생성 안됌
		Comp com1 = new Samsung01();
		com1.earnMoney();
		com1.working();
	}

}
abstract class Comp{ //회사 클래스
	public void working() {
		System.out.println("일을 열심히 합니다.");
	}
	public abstract void earnMoney(); // 어떻게 버는지는 하위 클래스에서 반드시 재정의
}
class Samsung01 extends Comp{

	// 상속하는 상위에있는 추상메서드 earnMoney를 반드시 재정의
	@Override
	public void earnMoney() {
		System.out.println("전자 제품을 만들어서 돈을 번다.");
		
		Lar l01 = new Zergglng();	
		Lar l02 = new Hydra();
		Lar l03 = new Myutal();
		
		l01.attack(); l01.move();
		l02.attack(); l02.move();
		l03.attack(); l03.move();
		
		
	}
	
}
/*
 #추상클래스(Abstract Class)
 	1.개념
 		1) 실체들 간의 공통되는 특성을 추출한 것
 		 ex1) 새, 곤충, 물고기 ==> 동물(추상)
 		 ex2) 삼성, 현대, LG ==> 회사
 	
 		2) 자바의 추상클래스란?
 			실제 클래스들의 공통되는 필드와 메소드 정의한 클래스 
 			추상 클래스는 실체 클래스의 부모클래스 역할(단독으로 객체 생성을 하지 못한다)
 			cf) 실체 클래스: 객체를 만들어 사용할 수 있는 클래스
 			 Animal.class  (추상 클래스)
 			 	(상속)
 			 Bird.class Insect.class Fish.class(실제클래스)
 	
 	2. 추상클래스의 용도
 		1) 실체 클래스의 공통된 필드와 메소드의 이름 통일할 목적
 			- 실체 클래스를 설계자가 여러 사람일 경우,
 			- 실체 클래스마다 필드와 메소드가 제각기 다른 이름을 가질 수 있음
 		2) 실체 클래스를 작성할 때, 시간 절약
 			- 실체 클래스는 추가적인 필드와 메소드만 선언
 		3) 실체 클래스 설계 규격을 만들고자 할 때
 			- 실체 클래스가 가져야 할 필드와 메소드를 추상 클래스에 미리 정의
 			- 실체 클래스는 추상 클래스를 무조건 상속 받아 작성.
*/

// 애벌레 ==> 실제 객체.
abstract class Lar{
	private String kind;
	public Lar(String kind) {
		this.kind=kind;
	}
	// 공통 클래스
	public void move() {
		System.out.println(this.kind+"이동하다");
	}
	
	public String getKind() {
		return kind;
	}
	//추상 메서드
	public abstract void attack();
		
}

class Zergglng extends Lar{
	public  Zergglng() {
		super("저글링");
	}
	public void attack() {
		System.out.println(getKind()+"빠른 근접 공격을 한다.");
	}

}

class Hydra extends Lar{
	public  Hydra() {
		super("히드라");
	}
	public void attack() {
		System.out.println(getKind()+"원거리 공격을 한다.");
	}

}
class Myutal extends Lar{
	public  Myutal() {
		super("뮤탈");
	}
	public void attack() {
		System.out.println(getKind()+"공중에서 원거리 공격을 한다.");
	}

}
