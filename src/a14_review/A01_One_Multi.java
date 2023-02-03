package a14_review;

import java.util.ArrayList;
import java.util.List;

public class A01_One_Multi {

	public static void main(String[] args) {
		

	}

}
/*
 * 
 # 1대 다 관계 처리
 	1. 하나의 클래스 안에 여러개의 클래스가 선언되는 것을 말한다.
 	2. 단계별로이해
 		1) 배열형 리스트 객체에 대한 이해
 			List<Emp> : Emp클래스가 어려객체를 추가할때 사용되는 메서드
 			list.add(new Emp()); 여러개 객체를 추가 할떄 사용되는 메서드
 			Emp e = list.get(0); index번호로 하나씩 객체를 가져올 수 있다.
 			for(Emp e:list){
 			e.getEname()반복문을 통해서 단위객체를 가져올 수 있다.
 			}
 		2) 1:1객체에 대한 이해
 			클래스로 하나의 클래스를 포함관계로 설정하는 경우를 말한다.
 			class Woman{
 			private Man man;
 			public void setMna(Man man){
 			this.man=man;
 			}
 			}
 			main()
 			Woman w = new woman();
 			w.setMan(new Man()); //선언된 객체에 기능메서드로 객체를 생성/할당처리
 		3) 1:다관계 객체
 		 	class Mart{
 		 	List<Product> p;
 		 	Mart(){
 		 		p = new ArrayList<Product>(); // 생성자에 의해 초기화
 		 		}
 		 		public void buyProduct(Product p){
 		 			plist.add(p); //물건을 하나씩 추가하는 기능 메서드 처리..
 		 		
 		 		public void showBuyList(){
 		 			for(Product p:plist){
 		 			p.getName(); p.getPrice(); p.getCnt();
 		 			}
 		 		}
 		 		}
 		 	Mart m  = new Mart()
 		 	m.buyProduct(new Product("사과",3000,2))
 		 	m.buyProduct(new Product("바나나",4000,3))
 		 	m.buyProduct(new Product("딸기",12000,4))
 		 	m.showBuyList();
 		 
 		4) 추상클래스에 대한 이해.
 			추상 개념 : 실제 객체의 공통부분을 가진 개념을 나타낸다.
 			ex) 삼성, 현대, LG(실제회사) ==> 회사(추상)
 				개,고양이,말 ==> 동물(추상)
 			위 개념에 의해 추상클래스는 독립적으로 객체를 생성하지 못하지만
 			공통적인 기능과 재정의를 목적으로 선언한다.
 			abstract class Company{
 			public void working(){
 			회사가 일을하다.
 			}
 			public abstract void earnMoney();
 			}
 			class Samsung extends Company{
 			public void earnMoney(){ //반드시 재저으이 해야함(메서드 통일성 유지)
 			전자제품을만들어 돈을 번다.
 			}
 			}
 			class Hyundai extends Company{
 			public void earnMoney(){
 				배를 건조하여 돈을 번다...
 			}
 			}
 			Company com = new Samsung(); 다형성 처리를 통해 상위 클래스가
 			여러형태의 다양한 하위 객체를 사용한다.
 			com.working(); 공통 기능메서드
 			com.earnMoney(); 다양한 하위 기능메서드(재정의된 메서드)
 			
  # 1대 다관계 객체구조
   1. 하나의 클래스안에 여러개의 선언된 클래스의 갹체를 호출하여, 궁극적으로 하나의 객체안에
   		여러개의 객체를 사용할 수 있는 구조로 처리하는 형태를 말한다.
   2. 단계별 구조에 대한 이해
   		1) 단순 1:다관계
   			ex)마트에 파는 여러가지 물건
   		2) 여러개의 다중 객체가 포함되어 있는 경우
   			ex)온라인 쇼핑몰의 여러회원과 여러가지 상품
   		3) 추상클래스를 상속받은 클래스에 생성되는 다중의 객체를 선언하여 사용하는 경우
   			ex) 컴퓨터에서 부품이라는 추상클래스에서 상속받은 하위의 여러 실제 클래스를 관계로
   				선언하여 할당하는 경우
 */
class Mart{
	private String mname;
	private List<Product> list;
	public Mart() {
	}
	public Mart(String mname) {
		this.mname = mname;
		list = new ArrayList<Product>();
	}
	public void addCart(Product prod) {
		System.out.println("장바구니 담기:"+prod.getName());
		list.add(prod);
		System.out.println("현재 담기 물건 갯수:"+list.size());
	}
	public void calcuList() {
		System.out.println(mname+"의 계산대에서!!");
		int tot=0;
		for(Product p:list) {
			tot+=p.showInfo();;
		}
		System.out.println("총비용:"+tot);
	}
	
}
class Product{
private String name;
private int price;
private int cnt;

public Product() {
}

public Product(String name, int price, int cnt) {
	this.name = name;
	this.price = price;
	this.cnt = cnt;
}
public int showInfo() {
	System.out.print(name+"\t");
	System.out.print(price+"\t");
	System.out.print(cnt+"\t");
	System.out.println(price*cnt+"\n");
	return price*cnt;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getCnt() {
	return cnt;
}

public void setCnt(int cnt) {
	this.cnt = cnt;
}

}
class Team{
	private String tname;
	private List<Player> plist;
	public Team(String tname) {
		this.tname = tname;
		plist = new ArrayList<Player>();
	}
	public void addPlayer(Player p) {
		System.out.println(p.getName()+"선수등록");
		plist.add(p);
		System.out.println("팀의 순수수:"+plist.size());
	}
	public void showPlayerList() {
		System.out.println("팀명:"+tname);
		for(Player p:plist) {
			System.out.print(p.getName()+"\t");
			System.out.print(p.getRecord()+"\n");

		}
	}
}


class Player{
	private String name;
	private double record;
	public Player() {}
	public Player(String name, double record) {
		this.name = name;
		this.record = record;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRecord() {
		return record;
	}
	public void setRecord(double record) {
		this.record = record;
	}
	
}