package a10_api;
class Food{
	public String toString() {
		return "to String():참조변수만 호출";
	}
}
public class A03_toString {

	public static void main(String[] args) {
		Food f = new Food();
		System.out.println("참조변수:"+f);
		// TODO Auto-generated method stub
/*
  #toString()
  1. 클래스의 패키지와 클래스명을 +16진수 주소 리턴
  2. 참조변수만 호출했을 때, 나타나는 데이터와 동일하다.
  3. toString() 재정의하면 참조변수도 동일한 값으로 변경이 된다.
 */
		Player p01 = new Player("홍길동",0.342);
		Player p02 = new Player("홍길동",0.342);
		Player p03 = new Player("김길동",0.342);
		System.out.println(p01);
		System.out.println(p01.toString());
		System.out.println(p02);
		System.out.println(p03);
		System.out.println(p01==p02);
		System.out.println(p01==p03);
		System.out.println(p01.equals(p02));
		System.out.println(p01.equals(p03));
		Music m1 = new Music("귀로","나얼");
		Music m2 = new Music("귀로","나얼");
		Music m3 = new Music("바람기억","나얼");
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
		System.out.println(m1==m2);
		System.out.println(m1==m3);
		
	}

}
class Music{
	private String mname;
	private String sname;
	public Music(String mname, String sname) {
		this.mname = mname;
		this.sname = sname;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.mname+";"+this.sname;
	}
}
class Player{
	private String name;
	private double record;
	public Player(String name, double record) {
		this.name = name;
		this.record = record;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return this.name+":"+this.record;
	}
	
	
	
}
