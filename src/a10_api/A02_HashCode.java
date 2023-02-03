package a10_api;

public class A02_HashCode {

	public static void main(String[] args) {
		/*
		 # hashCode로 객체 동등 여부 체크
		 */
		Person p01 = new Person();
		Person p02 = new Person();
		Person p03 = p01;
		System.out.println("p01.hashCode():"+p01.hashCode());
		System.out.println("p02.hashCode():"+p02.hashCode());
		System.out.println("p03.hashCode():"+p03.hashCode());
		//주소값이 같은 때 확인..
		
		Student s1 = new Student(1,"홍길동");
		Student s2 = new Student(1,"홍길동");
		Student s3 = new Student(2,"마길동");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println("주소값 동일 여부: "+(s1==s2));
		System.out.println("속성 동일 여부s1,s2: "+(s1.hashCode()==s2.hashCode()));
		System.out.println("속성 동일 여부s1,s3: "+(s1.hashCode()==s3.hashCode()));
		//Product로 물건명 가격을 설정
		// 	hashCode를 재정의 하여 값이 동일하면 true로처리되게
		
		//	
		Product pb1 = new Product("사과",1000);
		Product pb2 = new Product("사과",1000);
		Product pb3 = new Product("딸기",2000);
		Product pb4 = new Product("사과",1000);
		System.out.println(pb1.hashCode());
		System.out.println(pb2.hashCode());
		System.out.println(pb3.hashCode());
		System.out.println(pb4.hashCode());
		System.out.println(pb1.hashCode()==pb2.hashCode());
		
		
	}

}
class Prodbuy{}
class Product{
	private String name;
	private int price;
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	@Override
	public int hashCode() {
		int code1 = name.hashCode()+price;
		// TODO Auto-generated method stub
		return code1;
	}
  	
}
class Person{}
class Student{
	private int no;
	private String name;
	public Student(int no, String name) {
		this.no = no;
		this.name = name;
	}
	@Override
	public int hashCode() {
		int code = no+name.hashCode();
		return code;
	}
	
}