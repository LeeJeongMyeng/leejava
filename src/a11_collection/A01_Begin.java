package a11_collection;

import java.util.ArrayList;
import java.util.List;

public class A01_Begin {

	public static void main(String[] args) {
		/*
		 #컬렉션 프레임 워크
		 1. 컬렉션 : 사전적 의미로 요소(객체)를 수집해 저장하는 것
		 2. 배열의 문제점
		 	1) 저장할 수 있는 객체수가 배열을 생성시 미리 결정됨
		 		==> 불특정 다수의 객체를 저장하기에는 부적합
		 	2) 객체 삭제 시, 해당 인덱스가 비게 된다.
		 		==> 낱알빠진 옥수수 같은 배열
		 		==> 객체를 저장하려면 어디가 비어있는지 확인해야한다.
		 
		 3. 객체들을 효율적으로 추가, 삭제, 검색할 수 있도록
		 	제공되는 컬렉션 라이브러리
		 4. java.util 패키지에 포함
		 5. 인터페이스를 통해서 정형화된 방법으로 다양한 컬렉션
		 	클래스 이용
		 
		 # 컬렉션 프레임워크의 주요 인터페이스
		 	1. 인터페이스
		 		List - ArrayList,Vector,LinkedList
		 		Set - HashSet, TreeSet
		 		Map- HashMap, Hashtable, TreeMap, Properties
		 	
		 	2. 주요 기능
		 	 	List - 순서를 유지하고 저장
		 	 		 - 중복 저장 가능
		 	 	Set - 순서를 유지하지않고 저장
		 	 		- 중복저장안됨
		 	 	Map - 키와 값의 쌍으로 저장
		 	 		- 키는 중복 저장 안됨
		 	 
		 	 #List컬렉션
		 	 1. 특징
		 	 		인덱스로 관리
		 	 		중복해서 객체 저장가능
		 	 2. 구현 실제 클래스
		 	 		ArrayList
		 	 		Vector
		 	 		LinkedList
		 	 3.주요 메서드
		 	 		boolean add()
		 	 		void add(int index, 추가객체)
		 	 		set(int index, 변경 객체)
		 	 		
		 	 		boolean contains(요소객체) : 요소객체 있는지 여부 확인
		 	 		get(int index);특정 위치에 있는 요소 객체 가져오기
		 	 		isEmpty() : 컬렉션이 비어있는지 확인
		 	 		int size():크기
		 	 		
		 	 		if(!list.isEmpty()){
		 	 		}
		 	 		
		 	 		if(list.size()>0){
		 	 		}
		 	 		
		 	 		void clear():포함된 모든 객체를 삭제
		 	 		remove9int index) : 해당 위치의 객체를 삭제
		 	 		boolean remove(Object o): 주어진 객체를 삭제
		 */
		//인터페이스 = 실제객체
		List<String> slist = new ArrayList<String>();
		slist.add("사과");
		slist.add("오렌지");
		slist.add("수박");
		System.out.println(slist);
		slist.add(0,"바나나"); //0버(맨첫번째)에 끼워넣고 기존것들은 뒤로 밀려남
		System.out.println(slist);
		slist.set(1,"키위"); //덮어씌우기
		//slist.removeAll(slist);
		slist.clear();
		System.out.println(slist);
		
		//ex) slist2로 List객체를 생성
		List<String> slist2 = new ArrayList<String>();
		slist2.add("그래픽카드");
		slist2.add("ssd");
		slist2.add("cpu");
		slist2.add("RAM");
		System.out.println(slist2);
		slist2.add(1,"모니터");
		slist2.set(0,"키보드"); //덮어씌우기
		System.out.println(slist2);
		
		//객체형 VO를 넣고 처리하는 List
		List<Product> buyList = new ArrayList<Product>();
		buyList.add(new Product("사과",3,1300));
		buyList.add(new Product("바나나",2,2300));
		buyList.add(new Product("오렌지",4,3300));
		Product p= buyList.get(0);
		System.out.println("객체 등록여부:"+buyList.contains(p));
		
		Product p2 = new Product("오렌지",4,3300);
		System.out.println("객체 등록여부2:"+buyList.contains(p2));
		System.out.println("크기:"+buyList.size());
		System.out.println("비워져있는지?:"+buyList.isEmpty());
		buyList.remove(0); //0번째 삭제
		System.out.println("크기:"+buyList.size());
		buyList.clear(); // 다 삭제
		System.out.println("크기:"+buyList.size());
		System.out.println("비워져있는지?:"+buyList.isEmpty());
		
		//ex) Member(이름/나이) class 선언
		// mlist로 회원3명 등록, 마지막 데이터 삭제
		// 회원 목록 확인, 전체 삭제, 크기확인
		
		List<Member> mList = new ArrayList<Member>();
		mList.add(new Member("이정명"));
		mList.add(new Member("이지은"));
		mList.add(new Member("찌니"));
		// 리트스 확인 방법 1
		for(Member m:mList) {
			System.out.println(m.getName());
		}
		// 리트스 확인 방법 2
		for(int idx=0;idx<mList.size();idx++) {
			//단위책게 = .get(인덱스번호)
			Member m = mList.get(idx);
			System.out.println(m.getName());
		}
		mList.size();
		//마지막 데이터의 index번호 => size추출후 -1
		mList.remove(0);
		System.out.println(mList.size());
		mList.clear();
		System.out.println(mList.size());
		
		//회원명 검색
		//회원의 나이에 해당되는 데이터 검색..
		
		/*
		 #Vector
		 1. List<E> list = new Vector<E>();
		 2. 특징
		 	1) 쓰레드 동기화
		 	2) 복수의 쓰레드가 동시에 Vector에 접근해 객체를
		 		추가, 삭제하더라도 스레드에 인정
		 		==> 스레드가 안정성이 부족하여 추가/삭제시 Thread
		 		안정성 기능이 지원되지 않으면 생략되는 경우가 있다.
		 
		 #LinkedList
		 1. List<E> list = new LinkedList<E>();
		 2. 특징
		 	1) 인접 참조를 링크해서 체인처럼 관리
		 	2) 특정 인덱스에서 객체를 제거하거나 추가하게 되면
		 		바로 앞뒤 링크만 변경
		 	3) 빈번한 객체 삭제와 삽입이 일어나는 고셍서는
		 		ArrayList보다 좋은 성능
		 		 */
		
	}
}
class Member{
	private String name;

	public Member(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
class Product{
	private String name;
	private int cnt;
	private int price;
	public Product(String name, int cnt, int price) {
		this.name = name;
		this.cnt = cnt;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
