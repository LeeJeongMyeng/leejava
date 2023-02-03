package a03_calcu;

public class A02_RestoreCal {

	public static void main(String[] args) {
	
	/*
	 #대입연산자
	 1. = : 데이터를 오른쪽에서 왼쪽으로 대입하여 할당하는 연산자
	 */
		int num01=25;
		int num02, num03, num04;
		//한번에 정수형 데이터를 3개 선언
		num02 = num03 = num04 =5;
		int num05=6; double num06 = 1.4; float num07 =4.7F;
		//한번에 3개를 5로 선언
		System.out.println(num02);
		System.out.println(num03);
		System.out.println(num04);
		
		String id1,id2,id3;
		id1 = "aoddl"; id2 = "sandy"; id3 = "Jjinea";
		
		int pt1,pt2,pt3; 
		pt1 = pt2 = pt3 = 10000;
		
		System.out.println(id1+"의 point는 "+pt1+"점");
		System.out.println(id2+"의 point는 "+pt2+"점");
		System.out.println(id3+"의 point는 "+pt3+"점 입니다.");
				
		
		String student1= "wjdaud";
		String student2= "wldms";
		String student3= "찌니";
		
		int k1 = 10; int k2 = 20; int k3 = 30;
		int e1 = 40; int e2 = 50; int e3 = 60; 
		int m1 =70; int m2 =80; int m3 =90;
		int total1= k1+e1+m1;
		int total2= k2+e2+m2;
		int total3= k3+e3+m3;
	System.out.println(total1);
	System.out.println(total2);
	System.out.println(total3);
	
		int rever1 = total1/3;
		int rever2 = total2/3;
		int rever3 = total3/3;
		System.out.println(rever1);
		System.out.println(rever2);
		System.out.println(rever3);
		
		System.out.println("이름\t\t국어\t영어\t수학\t평균");
		System.out.println(student1+"\t "+k1+"\t "+e1+"\t "+m1+"\t "+rever1);
		System.out.println(student2+"\t\t "+k1+"\t "+e1+"\t "+m1+"\t "+rever2);
		System.out.println(student3+"\t\t "+k1+"\t "+e1+"\t "+m1+"\t "+rever3);
		
	
		
	}

}
