package a06_Object;

public class A09_StaticMember {

	public static void main(String[] args) {
		/*
		 #인스턴스 멤버란?
		 1. 객체(인스턴스)마다 가지고있는 필드와 메소드
		 	- 이들은 각각 인스턴스 필드, 인스턴스 메소드라고 부른다.
		 	객체가 생성된 후에 사용할 수있는 객체 소속 멤버
		 2. 인스턴스 멤버는 객체 소속된 멤버이기 떄문에 객체 없이 사용불가하다.
		 3. this
		  	 객체(인스턴스) 자신의 참조(번지)를 가지는 키워드
		  	 객체 내부에서 인스턴스 멤버임을 명확히 하기위해 this.사용
		  	 매개변수와 필드명이 동일할 때, 인스턴스 필드임을 명확인 하기 위해 사용
		 */
		Car01 c01= new Car01(20);
		c01.gas = 10; //객체별로 다른필드와
		c01.setSpeed(100); //객체별로 다른 메소드의 매개값을 넘긴다.
		// 이것을 인스턴스 멤버라 한다.
		Car01 c02= new Car01(20);
		c01.gas = 20; //객체별로 다른필드와
		c01.setSpeed(200); //객체별로 다른 메소드의 매개값을 넘긴다.
		// 이것을 인스턴스 멤버라 한다.
		
		/*
		 #정적 멤버와 static
		 1. 정적(static) 멤버란?
		 	1) 클래스에 고정된 필드와 메서드 - 정적필드, 정적 메서드
		 		객체의 공유메모리, 클래스 소속 멤버,
		 		객체 생성없이 사용가능 ex)클래스명.멤버 = 데이터;
		 	2) 정적 멤버는 클래스에 소속된 멤버
		 		- 객체 내부에 존재하지 않고, 메소드 영역에 존재
		 		-정적 멤버는 객체를 생성하지 않고 클래스로 바로 접근해 사용
		 
		 2. 정적 멤버선언
		 	1) 필드 또는 메소드 선언 할 때, static 키워드 붙은
		 		class 클래스{
		 		static 타입 필드;
		 		static 리턴타입 메소드명(매개변수){}
		 	cf)클래스를 통해서 만들어지는 객체들은 다른 조소에 실제 메모리를 가지고 사용한다.
		 	비유컨데, 롯데월드타워도면으로 서울,부산,제주도에 빌딩을 짓는다고 가정하면
		 	롯데월드타워도면 : 클래스
		 	각 지역에 실제 만들어진 빌딩: 객체
		 	건축비용 : 도면비용+(자제비용+인건비+부지비용)
		 		*자재비용, 인건비, 부지비용 각위치에 따라 다르게 설정
		 		 ==> 객체의 instance 변수는 다르게 설정할 수있다.
		 		*도면 비용은 건축물의 위치에 상관없이 일정한 비용이 든다.
		 		 ==> 객체의 static변수는 특정한 클래스에서 생선된 객체에서 동일하게 사용할 수 있다.
		 		 	  객체가 동유하는 필드이기에 class변수라고 한다.
		 		 	  참조변수.static변수 ==> 클래스명.static변수
		 		}
		 */
		/*
		BuildingLotte.drawingPay=3000000;
		//객체 생성전에 클래스명.static변수로 사용가능
		BuildingLotte b01 = new BuildingLotte("서울", 100000);
		
		BuildingLotte b02 = new BuildingLotte("부산", 120000);
		b01.showInfo();
		b02.showInfo();
		BuildingLotte.drawingPay+=100000;
		b01.showInfo();
		b02.showInfo();
		*/
		
		BankAccount.totalcost=2000000;//static 변수는 객체 생성없이 객체의 공유 메모리 설정
		BankAccount b03 = new BankAccount("농협",10000);
		BankAccount b04 = new BankAccount("신한",20000);
		BankAccount b05 = new BankAccount("국민",30000);
		b03.savingMoney(1000);
		b04.savingMoney(2000);
		b05.savingMoney(3000);
		
	}

}
/*class BuildingLotte{
	String loc; // instance변수 -위치
	int siteCost; //instance변수 - 부지비용
	static int drawingPay; // static변수 - 도면비용
	
	public BuildingLotte(String loc, int siteCost) {
		this.loc = loc;
		this.siteCost = siteCost;
	}

	void showInfo() {
		System.out.println(loc+"에 있는 롯데원드 타워");
		System.out.println("도면 비용:"+drawingPay);
		System.out.println("부지 비용:"+siteCost);
	}
}
*/
// ex) BankAccount 클래스를 선언하고, 필드(계좌명, 계좌별 잔액)-인스턴스변수,
//		(모든계좌의 총액)Static변수를 선언하여 데이터를 확인하세요

class BankAccount{
	String name;
	int cost;
	static int totalcost;
	public BankAccount(String name, int cost) {
		this.name = name;
		this.cost = cost;
		totalcost+=cost;
		System.out.println(name+"계좌 개설! 초기금액:"+this.cost);
		System.out.println("은행 전계좌 잔액:"+totalcost);
	}
	void savingMoney(int money) {
		this.cost+=money;
		totalcost+=money;
		System.out.println("계좌:"+name);
		System.out.println("잔액:"+this.cost);
		System.out.println("총액:"+totalcost);

	}
	
}


class Car01{
	int gas;
	public Car01(int gas) {
		this.gas = gas;
	}
	void setSpeed(int speed) {}
}
