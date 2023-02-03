package a08_inheritance;

import java.util.ArrayList;

public class A04_Polymorphism {

	public static void main(String[] args) {
		/*
		 # 다형성 (Polymorphism)
		 	1. 같은 타입이지만 실행 결과가 다양한 객체 대입(이용)가능한 성질
		 		1) 부모 타입에는 모든 자식 객체가 대입 가능
		 			- 자식 타입은 부모 타입으로 자동 타입 변환
		 	
		 	2. 자동 타입 변환(Promotion)
				1) 형식
					부모클래스 변수 = 자식클래스 타입
					class Animal{}
					class Cat extends Animal{}
					
					Cat cat = new Cat();
					Animal anim = cat;
					Animal anim2 = new Cat();
					Animal anim3 = new Bird();
					
		 */
		Larva l1 = new Dron();
		l1.attack(); //다형성에 의해서 첫 번째 라바는 Dron으로 변형 되었기에 Dron에서 정의된
					 // attack()을 처리한다.
		Larva l2 = new Zerggling();
		l2.attack();
		Animal an01 = new Cat();
		an01.sound();
		Animal an02 = new Dog();
		an02.sound();
		Animal an03 = new Tiger();
		an03.sound();
		Animal[] arr = {new Cat(),new Dog(),new Tiger()};
		for(Animal an:arr) {
			an.sound();
		}
		ArrayList<Animal> alist = new ArrayList<Animal>();
		alist.add(new Cat());
		alist.add(new Dog());
		alist.add(new Tiger());
		for(Animal an:alist) {
			an.sound();
		}
	}

}

//ex) Animal 동물종류,sound(), Cat,Dog, Tiger
// 	다형성에 의해서 객체 생성을하고 재정의 된 sound() 호출

class Animal{
	private String sounding;

	public Animal(String sounding) {
		this.sounding = sounding;
	}
	public void sound() {
		System.out.println("깡총깡총한다.");
	}
	public String getsound() {
		return this.sounding;
	}
}

class Cat extends Animal{

	public Cat() {
		super("고양이");
	}
	public void sound() {
		System.out.println(getsound()+"냐용 냐용.");
	}
	
}
class Dog extends Animal{

	public Dog() {
		super("강아지");
	}
	public void sound() {
		System.out.println(getsound()+"멍멍멍");
	}
	
}
class Tiger extends Animal{

	public Tiger() {
		super("호랭이");
	}
	public void sound() {
		System.out.println(getsound()+"어흥 어흥.");
	}
	
}
class Larva{
	private String kind;

	public Larva(String kind) {
		this.kind = kind;
	}
	public void attack() {
		System.out.println("전혀 공격을 하지 못 한다..");
	}
	public String getKind() {
		return this.kind;
	}
}

class Dron extends Larva{

	public Dron() {
		super("드론"); // 31,32번 코드를 사용하는 것
	}
	public void attack() {
		System.out.println(getKind()+"약한 근접 공격을 한다.");
		
	}
}
class Zerggling extends Larva{

	public Zerggling() {
		super("저글링"); // 31,32번 코드를 사용하는 것
	}
	public void attack() {
		System.out.println(getKind()+"빠른 근접 공격을 한다.");
	}
	}
