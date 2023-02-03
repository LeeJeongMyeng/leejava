package a06_Object;

import java.util.ArrayList;

public class A13_List {

	public static void main(String[] args) {
	/*
	 # 객체형 정적배열
	 1. 고정된 배열안에 객체를 담는 처리
	 2. 크기가 고정되어서 추가나 삭제 불가능
	 */
		int[] arry= {1000,2000,3000};
		for(int idx=0;idx<arry.length;idx++) {
			System.out.println(idx+":"+arry[idx]);
		}
		
		
		Food01[] obArray = {new Food01("짜장면",6000),
							new Food01("짬뽕",7000),
							new Food01("탕수욕",15000)};

		for(int idx=0;idx<obArray.length;idx++) {
				//참조변수는 소문자로 시작해야한다.
			System.out.print(idx+":"+obArray[idx]+":"); //stack영역 데이터
			Food01 f01 = obArray[idx];
			System.out.println(f01.getName()+":"+f01.getPrice());
		}
		
		/*1 . 클래스 선언
		 		필드, 생성,get/set
		 2. 객체형 배열 선언 및 할당
		 3. for배열처리 기본방식
		 4. 
		 */
		Student01[] stArray = {new Student01("이정명",90,80),
							new Student01("이지은",70,60),
							new Student01("찌니",50,40),};
		for(int idx=0;idx<obArray.length;idx++) {
			Student01 st01 = stArray[idx];
			System.out.println("이름:"+st01.getName()+"국어점수:"+st01.getKor()+"영어점수:"+st01.getEng());
		}
		/*
	 #객체형 동적배열
	 1. 데이터 타입이 List, ArrayList선형 형식으로 선언된다.
	 2. 크기가 동적으로 변경이 가능하다.
	 
	 */
		ArrayList list =new ArrayList();
		//Object
		Object ob; //자바의 모든 객체의 상속관계 최상위 객체
		// 모든 객체를 할당할 수 있다.
		ob="홍길동";
		ob = new Student01("홍길동",70,90);
		//ArrayList<Object>list; default로 된거나 다름없음
		// .add추가할 데이터
		list.add("사과");
		list.add("바나나");
		list.add("딸기");
		System.out.println("크기:"+list.size());
		// .size(); 동적배열의 크기
		for(int idx=0;idx<list.size();idx++) {
			//list,get(인덱스)
			System.out.println(idx+":"+list.get(idx));
		}
			
			ArrayList song =new ArrayList();	
		// add(), get(), remove(), size()
			song.add("키");
			song.add("키키");
			//삭제 처리
			song.remove(0);
			song.add("키키키");
			System.out.println("크기:"+song.size());
			for(int idx1=0;idx1<song.size();idx1++) {
				System.out.println(idx1+1+"번째 :"+song.get(idx1));
			}
			//향상된 반복문
			//for(단위데이터:배열형객체)
			System.out.println("#향상된 반복문 처리#");
			//ArrayList는 기본유형으로 Object가 담긴다.
			for(Object music:song) {
				System.out.println(music);
			}
/*
# 동적배열(ArrayList)에 객체할당하여 처리하기.
	1. 유형의 선언
		ArrayList list; : 기본 Object형 데이터 선언
	2. 특정한 객체의 유형의 데이터 처리.
		ArrayList<클래스명> list = new
			ArrayList<클래스명>();
			<> : generic
				해당 유형의 동적배열을 선언한다는 의미이다.
*/
			ArrayList<Student01> stList = new ArrayList<Student01>();
			// Student01 클래스를 배열식으로 담음
			stList.add(new Student01("홍길동",70,90));
			stList.add(new Student01("김길동",80,86));
			stList.add(new Student01("박길동",100,100));
			for(int idx=0; idx<stList.size();idx++) {
				Student01 st = stList.get(idx);
				System.out.println(idx+":"+st);
				System.out.println("	"+st.getName());
				System.out.println(":"+st.getKor());
				System.out.println(":"+st.getEng());
				}
			ArrayList<Food01> fdList = new ArrayList<Food01>();
			fdList.add(new Food01("사과",1000));
			fdList.add(new Food01("딸기",1500));
			fdList.add(new Food01("수박",3000));
			for(int idx1=0; idx1<stList.size();idx1++) {
				Food01 fd = fdList.get(idx1);
				System.out.println("이름:"+fd.getName());
				System.out.println("가격:"+fd.getPrice());
			}
		}
	}


class Student01{
	private String name;
	private int kor;
	private int eng;
	public Student01(String name, int kor, int eng) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
}

class Food01{
	private String name;
	private int price;
	public Food01(String name, int price) {
		this.name = name;
		this.price = price;
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
	
}