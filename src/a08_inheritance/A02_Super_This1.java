package a08_inheritance;

public class A02_Super_This1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 #super와 this
		 1. this
		 	1) 인스턴스 필드/메서드를 호출할 떄 사용 ex) this.필드명
		 	2) this() 다른 생성자를 호출할 때 사용 ex) this(),this(name)
		 
		 2. super
		 	1) 상속관계에서 상위/하위 클래스에서 동일한 멤버을 사용할 때
		 		구분하기 위해 활용된다.
		 	2) 생성자
		 	- 하위객체는 상위객체의 생성자를 생성하면서 처리가 된다.
		 		default생성자에 의해서 기본적으로 호출된다.
		 		
		 		class Father{
		 		public Father(){super();} default 생성자 포함
		 		Father(String s){
		 		}
		 		Father(String s, int age){
		 		this.
		 		}
		 		
		 		class Son extends Father{
		 		public Son(){
		 		super(); // default 상위생서자를 호출
		 		}
		 		//객체 생성자를 통해서 상위에 있는 매개변수가 있는 생성자를
		 		  반드시 호출하여야 하기 때문에 기본 선언으로 에러가 발생.
		 		  public Son(){
		 		  super("홍길동"); //super()생성자 첫라인에 선언
		 		  } 
		 		}
		 		//상속 관계로 인하여 객체를 사용할려면 상위에 있는
		 		//필드와 메서드를 활용해야하는데, 상위에 있는 선언된
		 		// 생성자를 호출하지 않고는 사용할 수 없기에
		 		// 반드시 선언된 생성자 1개라도 호출해야 한다.
		 		
		 		  cf) 자바는 모든 클래스가 상위/하위 상속관계로 설정
		 		  	- Object(내장)가 최상위 클래스로 선언되어있다.
		 		  	ArrayList li = new ArrayList();
		 		  	ArrayList<Object> li = new ArrayList<Object>();
		 		  	동일하고..
		 		  	
		 		  	//Object는 모든 객체를 다형성으로 할당이 가능..
		 		  	Object ob = new Person();
		 		  	li.add(new Person());
		 		  	li.add("안녕하세요");
		 		  	li.add(25); //Wrapper(Integer)로 자동 변환되어 할당
		 		  	
		 		  	for(Object ob:li2){
		 		  	system.out.println(ob);
		 		  	// 주소값/String은 문자열의 toString()문자열 자체를 가지고 있다.
		 		  	// 때문에 그대로 문자열이 나온다.
		 		  	}
		 		  	
		 		  	
		 		  	
		 	3) 메서드에 사용하는 super.메서드()
		 	-오버라이딩
		 		상위에 있는 기능 메서드를 하위 클래스에서 다양한 기능을 처리하기 위해
		 		동일한 메서드 메서드명을 재정의하는 것을 말한다.
		 		이떄, 상위의 메서드 내용도 호출해서 사용할려면, 현재 정의된 메서드와
		 		구분하기 위헤super.메서드명()으로 호출하여 처리한다.
		 	3) 메서드
		 		#명시적 부모 생성자 호출
		 		 1. 부모 객체 생성할 떄, 부모 생상자 성택 호출
		 		 	자식 클래스(매개변수 선언){
		 		 	super(매개값)
		 		 	}
		 		 2. super(매개값)
		 		 	- 매개값과 동일한 타입, 갯수, 순서에 맞는 부모 생성자 호출
		 		 3. 부모 생성자가 없다면 컴파일 오류 발생
		 		 4. 반드시 자식 생성자의 첫 줄에 위치
		 		 5. 부모 클래스 기본(매개변수없는)생성자 없다면 필수 작성.
		 		 
		 */

		
		
		
		
		Son02 s1 = new Son02();
		System.out.println(s1.getName());
		Daugther02 d2 = new Daugther02();
		System.out.println(d2.getCook()+"를 만드는 곳은 "+d2.getRoom());
	}

}

class Father01{
	private String name;
	
	Father01(String s){
	this.name=s;
	}
	public String getName() {
		return name;
	}
}

class Son02 extends Father01{
	Son02(){
		super("홍길동"); // 하위에서는 반드시 상위 클래스의 생성자를 호출하여야 한다.
	} //default로써, 보이지 않지만 처리가 되어있기에 에러가 나지 않는다.
}
class Daugther02 extends Mather{
	Daugther02(){
		super("김치 찌개","주방");
	}
	} 

class Mather{
	private String cook;
	private String room;

	public Mather(String cook, String room) {
		this.cook = cook;
		this.room=room;
	}

	public String getCook() {
		return cook;
	}

	

	public String getRoom() {
		return room;
	}

	
}