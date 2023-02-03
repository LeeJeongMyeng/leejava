package a06_Object;

public class A11_ObjVsObj {

	public static void main(String[] args) {
		/*
		 # 1:1관계 클래스의 선언과 객체 생성
		 1. 1:1관계에 있는 현실의 요구사항에서 많이 있을뿐아니라, 실제 프로그래밍에서도
		 	많이 발생하여 처리해야 한다.
		 	ex)사람이 가지고있는 핸드폰, 연필과 지우개, 학생과 성적표, 학생과 전공지도교수
		 		TV와 리모콘, 결혼할 커플(남/여)
		 
		 2. 선언 방식
		 	1) 종속될 클래스 선언
		 	2) 포함할 클래스 선언
		 */
		Hperson h01 = new Hperson("홍길동");
		h01.checkMyPocket();
		h01.buyphone(new HandPhone01("010-0000-9999","삼성전자"));
		h01.checkMyPocket();
	}

}
class HandPhone01{//종속될 클래스
	private String number;
	private String company;
	public HandPhone01(String number, String company) {
		this.number = number;
		this.company = company;
	}
	public void info() {
		System.out.println("#핸드폰정보#");
		System.out.println("번호:"+this.number);
		System.out.println("제조사:"+this.company);
	}
}
class Hperson{
	private String name;
	private HandPhone01 phone;
	// 1:1관계 설정시, 필드로 객체를 선언하여 사용한다.
	public Hperson(String name) {
		super();
		this.name = name;
	}
	//public void setCnt(int cnt){} hp.setCnt(5); int cnt =5;
	//
	public void buyphone(HandPhone01 phone) {
		//HandPhone01 phone ==> public HandPhone01(String number, String company)이다.
		this.phone = phone;
		// 객체가 필드에 할당이됨
		
	}
	public void checkMyPocket() {
		System.out.println(name+" 주머니속에 핸드폰을 확인합니다.");
		if(this.phone==null) { //위 기능메서드 buyPhone로 핸드폰이 할당되어있지 않음.
			//메서드를 호출하여 객체가 할당되지않는 초기상태..
			System.out.println("핸드폰이 없습니다.");
		}else {
			phone.info();
		}
	}
}