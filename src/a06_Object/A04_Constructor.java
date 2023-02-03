package a06_Object;

public class A04_Constructor {

	public static void main(String[] args) {
/*
	* # 다른 생성자 호출(this())
		 1. 생성자 오버로딩되면 생성자 간의 중복된 코드가 발생한다.
		 2. 초기화 내용이 비슷한 생성자들에서 이러한 현상을 많이 볼수 있음
		 	1) 초기화 내용을 한 생성자에 몰아 작성
		 	2) 다른 생성자는 초기화 내용을 작성한 생성자를
		 		this(..)로 호출
*/
Player p01 = new Player("홍길동","LG트윈스",0.304);
System.out.println(p01.tname);
System.out.println(p01.name);
System.out.println(p01.record);
 //ex
Music m1 = new Music();
System.out.println("1");
System.out.println(m1.title);
System.out.println(m1.singer);
System.out.println(m1.album);
Music m2 = new Music("블랙베놈");
System.out.println("2");
System.out.println(m2.title);
System.out.println(m2.singer);
System.out.println(m2.album);
Music m3 = new Music("블랙베놈","블랙핑크");
System.out.println("3");
System.out.println(m3.title);
System.out.println(m3.singer);
System.out.println(m3.album);
Music m4 = new Music("블랙베놈","블랙핑크","블베");
System.out.println("4");
System.out.println(m4.title);
System.out.println(m4.singer);
System.out.println(m4.album);
	}

}
class Music {
	String title;
	String singer;
	String album;
	Music(){
		this.title="까까";
		this.singer="무명";
		this.album="꾸꾸";
	}
	Music(String title){
		this();
		this.title =title;
	}
	Music(String title, String singer){
		this(title);
		this.singer = singer;
	}
	Music(String title, String singer,String album){
		this(title,singer);
		this.album = album;
	}
	
		
	
	
}
class Player {
	String name;
	String tname;
	double record;
	Player(){
		this.name = "무명";
		tname = "팀 할당 안됨"; //자바에선 허용
		this.record=0.0;
	}
	Player(String name){
		this(); //상위에 선언된 생성자를 호출해서 아래 defaulf 자동설정
		//반드시 생성라인의 첫번째 줄에 호출해야함
		this.name =name;
//		tname = "팀할당안됨"; //위 this()로 생략가능
//		this.record=0.0;
	}
	Player(String name,String tname){
		this(name); // 매개변수가 있는 생성자 호출
		//반드시 생성라인의 첫번째 줄에 호출해야함
		this.tname=tname;
	}
	Player(String name,String tname, double record){
		//반드시 생성라인의 첫번째 줄에 호출해야함
		this(name,tname);
		this.record=record;
	}
}
