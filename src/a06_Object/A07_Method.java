package a06_Object;

public class A07_Method {

	public static void main(String[] args) {
		/*
		 #메소드?
		 1. 객체의 동작(기능)
		 2. 호출해서 실행할 수 있는 중괄호{} 블록
		 3. 메소드 호출하면 중괄호{} 블록에 있는 모든 코드들이 일괄실행
		
		#메소드 선언
		1. 핵심 기본 유형
			리턴타입 메소드명(매개변수1,2,...){
			프로세스 처리
			return 실제리턴 데이터;
			}
		 int plus(int num01,int num02) {
		 int sum =num01+num02;
		 return sum;
		 }
		 String getGeet(){
		 return"안녕하세요";
		 }
		1)리턴타입 :
		 	이 메서드를 호출 했을 때, 나오는 데이터의 유형을 선언한다.
		 	마지막에 리턴할 데이터의 유형을 선언한다.
		 	* 리턴없이 없는 경우에는 void를 적고 리턴하지 않는다.
		 	void를 사용하는 경우
		 	- 입력값을 통해서 주로 필드에 저장하는 경우
		 	- system.out.println()화면에 출력만하는 경우
		 	ex) 사람의 귀는 음성 정보를 입력해서 두뇌에 저장
		 
		2)매개변수 :
		 	메서드도 생성자와 동일하게 여러개의 데이터를 단일 또는 다중으로 입력처리
		 	할 수 있다.
		 	cf)메서드 오버로딩
		 	메서드의 이름이 같지만 매개변수의 갯수,유형,순서(유형이다른)에 따라 선언을
		 	할 수 있다.
		 	
		 */
		MethodReturnExp m01 = new MethodReturnExp();
		
		System.out.println("리턴 데이터: "+m01.callString());
		String ret = m01.callString();
		System.out.println(ret+"!반갑습니다.");
		System.out.println(m01.callInt());
		System.out.println(m01.callDouble());
		double num01 = m01.callDouble()+10;
		System.out.println("num01: "+num01);
		System.out.println("호출: "+m01.callName());
		m01.setName("마길동");
		System.out.println("다시호출: "+m01.callName());
		
		//ex) Person 필드 name, age선언
		// 1)이름과 나이를 저장하는 메소드1, 메소드2
		// 2)return으로 이름과 나이를 호출하는 메서드3,4선언
		// main()에서 이를 출력하세요
		Person p1 = new Person();
		p1.name = "이정명";
		p1.age=28;
		System.out.println("이름: "+p1.name+"\t나이: "+p1.age);
		p1.setData(".이지은");
		System.out.println("이름: "+p1.name+"\t나이: "+p1.age);
		p1.setData("찌니");
		System.out.println(p1.getname());
		// ex) Calcu 클래스 num01,num02지정
		// 1) 기능메서드1 num01저장   2) 기능메서드2 num02저장
		// 3) 기능메서드3 num01,02둘다 저장
		// 4) 기능 메서드 4 두개의 변수를 더해서 rerutn
		// 5) 기능메서드 5 두개의 변수를 곱해서 return
		Calcu c1 = new Calcu();
		c1.num01=20;
		c1.num02=4;
		System.out.println(c1.num01);
		System.out.println(c1.num02);
		System.out.println(c1.getsum());
		System.out.println(c1.getgob());
		c1.setnum1(30, 100);//오버로딩
		System.out.println(c1.num01);
		System.out.println(c1.num02);
		System.out.println(c1.getsum());
		System.out.println(c1.getgob());
		//생성자에 의해 초기화
		Calcu c2 = new Calcu(20,50);
		System.out.println(c2.getsum());
		System.out.println(c2.getgob());
	}
}
class Calcu{
	int num01;
	int num02;
	Calcu(){}
	Calcu(int num01, int num02){
		this.num01= num01;
		this.num02= num02;
		
	}
	void setnum01(int num01) {
		this.num01 =num01;
	}
	void setnum02(int num02) {
		this.num02 =num02;
	}
	void setnum1(int num01, int num02) {
		this.num01 =num01;
		this.num02 =num02;
	}
	int getsum() {
		return this.num01+this.num02;
		
	}
	int getgob() {
		return this.num01*this.num02;
	}
}
class Person{
	String name;
	int age;
	void Setname(String name){
		this.name=name;
		}
	
	void SetAge(int age){
		this.age=age;
	}
	//매개변수 없음.
	void setData() {
		name = "없음";
		age= -1;
	}
	//매개변수 1
	void setData(String name) {
		this.setData(); //이 객체가 소속된 기능 메소드 호출.
		this.name=name;
	}
	void setData(int age) {
		this.age=age;
	}
	//매개변수
	void setData(String name, int age) {
		this.setData(name);
		this.age=age;
	}
	void setData(int age,String name) {
		this.setData(name);
		this.age=age;
	}
	String getname() {
		return name;
	}
	int getage() {
		return age;
	}
	
}
class MethodReturnExp{
	String name;
	void setName(String name) {
		this.name=name;
		System.out.println("저장할 데이터:"+name);
		//void를 쓰면 하단에 return을 하지 않아야한다.
	}
	String callName() {
		return name;
	}
	String callString() {
		return"안녕하세요";
	}
	int callInt() {
		return 35;
	}
	double callDouble() {
		return 3.14;
	}
}
