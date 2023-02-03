package a08_inheritance;

import java.util.ArrayList;

public class A06_Interface {

	public static void main(String[] args) {
		
		Mz m01 = new Mz();
		m01.flying();
		m01.setWing(new Wing01());
		m01.flying();
		m01.setWing(new Wing02());
		m01.flying();
		m01.setWing(new Wing03());
		m01.flying();
		m01.setAttackWay(new Attack01());
		m01.attack01();
		m01.setAttackWay(new Attack02());
		m01.attack01();
		m01.setAttackWay(new Attack03());
		m01.attack01();
		m01.setAttackWay(new Attack04());
		m01.attack01();
		m01.attack02();
		
	}

}


// ex) 인터페이스로 AttackWay attack()여러가지 공격형태를 선언


interface AttackWay{
	void attack();
}

class Attack01 implements AttackWay{

	@Override
	public void attack() {
		System.out.println("1단계 공격 : 그냥 주먹으로 때린다.");
	}
	
}
class Attack02 implements AttackWay{

	@Override
	public void attack() {
		System.out.println("2단계 공격 : 레이저 빔을쏜다.");
	}
	
}
class Attack03 implements AttackWay{

	@Override
	public void attack() {
		System.out.println("3단계 공격 : 원거리 주먹을 날린다");
	}
	
}
class Attack04 implements AttackWay{

	@Override
	public void attack() {
		System.out.println("4단계 공격 : 필살기를 쓴다.");
	}
	
}
interface Wing{
	void fly();//public abstract가 생략될 수있다.
}
// 실제 객체 날개 1호 구현
//인터페이스는 implements를 통해 상속
class Wing01 implements Wing{
	@Override
	public void fly() {
		System.out.println("날개를 통해 동네를 날다.");
	}
	
}
class Wing02 implements Wing{
	@Override
	public void fly() {
		System.out.println("진화 된 날개로 전세계를 누비다");
	}
}
class Wing03 implements Wing{

	@Override
	public void fly() {
		System.out.println("3단계 날개로 우주로 날아갈 수있다!");
		
	}
	
}
class Mz{
	private Wing wing;
	
	public void setWing(Wing wing) {
		this.wing=wing;
	}
	public void flying() {
		if(this.wing!=null) {
			this.wing.fly();//실제 객체가 할당
			//하위 실제 객체가 overriding한 내용 처리
		} else {
			System.out.println("날개가 장착되지 않았습니다.");
		}
	}
	private AttackWay attackway;
	private ArrayList<AttackWay> attackList;
	public void setAttackWay(AttackWay attackway) {
		this.attackway=attackway;
	}
	public void addAttackWAY(AttackWay attackway) {
		if(attackList!=null)
			attackList = new ArrayList<AttackWay>();
		this.attackList.add(attackway);
			
	}
	public void attack01() {
		this.attackway.attack();
	}
	public void attack02(){
		if(attackList!=null) {
			int rIdx = (int)(Math.random()*attackList.size());
			attackList.get(rIdx).attack();
		}
}
}


/*
 #인터페이스란?
  1. 개발 코드와 객체가 서로 통신하는 접점
  	- 개발 코드는 인터페이스의 메소드만 알고있으면 ok
  2. 인터페이스의 역할
  	- 개발 코드가 객체에 종속되지 않게
  		==> 객체 교체할수 있도록 하는 역할
  	- 개발코드 변경없이 리턴갑ㅆ또는 실행 나용이 다양해 질 수 있음
  		(다형성)
  
  ex) MZ	간단접점(인터페이스) : 날개와 통신(접점, 인식 할 수 있는 중앙처리)
  			날개(실제 객체) - 박사가 계속 개발하면서 Update
  			인터페이스(기능적 접점만 선언)
  				기능적 접점을 연결시킬수 있는 날개1, 날개2..
  				지속적 upgrade되는 실제객체를 만들어감..
  # 인터페이스의 선언
  	1. 인터페이스 이름 - 자바 식별자 작성 규칙에 의해서 대문자로 시작
  	2. 소스파일 생성 - 인터페이스 이름과 대소문자가 동일한 소스 파일 생성
  	3. 인터페이스 선언
  		public interface 인터페이스명{...}
  	4. 인터페이스 구성 멤버
  	 	interface 인터페이스명{
  	 	// 상수
  	 	 타입 상수명 = 값;
  	 	 ex)
  	 	 [public static final] String FUN01="저장 기능";
  	 	 // 추상 메소드
  	 	   타입메소드(매개변수,...) 
  	 	 [public adstract] void show();
  	 	 
  	 	 //디폴트메소드
  	 	   default 타입 메소드(매개변수...){}
  	 	  [public] default String getName(){
  	 	  retrun"홍길동"ㅣ
  	 	  }
  	 	  
		 //정적메소드
		  static 타입 메소드명 (매개변수){}
		  [public] static void show(){
		  	System.out.println("기능 내용 출력");
		  }
  	 	}
  	
 */
