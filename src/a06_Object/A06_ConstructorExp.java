package a06_Object;

public class A06_ConstructorExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 # 아래 필드 값을 초기화 하는생성자 선언하고 필드값 출력하는 클래스를 정의 및 호출
		과일(종류,갯수)
		도서(도서명,출판사)
		마우스(이름, 제조사)
		택시(지역,차종)
		 
		 */
		Fruit f1 = new Fruit("딸기");
		
		Fruit f2 = new Fruit("딸기",10);
		System.out.println("=========================");
		
		Book99 b1 = new Book99("");
		System.out.println(b1.book99);
		Book99 b2 = new Book99("키키","이정명");
		System.out.println(b2.book99);
		System.out.println(b2.maker);
		
		System.out.println("=========================");
		
		Mouse m1 = new Mouse("지프로");
		System.out.println(m1.name);
		Mouse m2 = new Mouse("지슈라","로지텍");
		System.out.println(m2.name);
		System.out.println(m2.maker1);
		
		System.out.println("=========================");
		
		Taxi t1 = new Taxi("창원");
		System.out.println(t1.where);
		Taxi t2 = new Taxi("서울","포르쉐");
		System.out.println(t2.where);
		System.out.println(t2.car);
	}

}
class Fruit {
	String furit;
	int count;
	Fruit (String furit){
		this.furit=furit;
		System.out.println("과일이름은 : "+furit);
	}
	Fruit (String furit, int count){
		this(furit); //생성자내부의 모든것을 가져오네~~
		//thi는 이 클래스의 (형식)과 같은 놈의 모든것을 가져오고 순서는 상관없다.
		this.count = count;
		
		System.out.println("개수 : "+count);
}
}
class Book99 {
	String book99 = "쿠쿠";
	String maker;
	Book99 (String book99){
		
	}
	Book99 (String book99, String maker){
		this.book99 = "까까";
		this.maker =maker;
}
}
class Mouse {
	String name;
	String maker1;
	
	Mouse (String name){
		this.name= "홍길동";
	}
	Mouse (String name, String maker){
		this(name);
		this.maker1 =maker;
}
}
class Taxi {
	String where;
	String car;
	Taxi (String where){
		this.where=where;
	}
	Taxi (String where, String car){
		this(where);
		this.car =car;
}
}