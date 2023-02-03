package A05_restore;

public class A01_Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 # 자바의 데이터 타입 분류
		 1. 기본 타입
		 2. 참조 타입
		 - 자바는 정수/실수/boolean형을 바로 선언하여 사용하는
		   기본형 타입과. 배열/열거/클래스/인터페이스에 의해 
		   특성한 메모리를 참조하는 참조타입으로 크게 분류 된다.
		   #변수의 메모리 사용
		   1. 기본 타입 변수 - 실제 값을 변수안에 저장
		   cf) stack영역에 선언하고 실제 데이터를 할당
		   2. 참조 타입 변수 - 줏를 통해 객체 참조
		   cf)heap영역에 저장하고 이 heap영역의 주소값을   stack영역에 저장한다.
		   */
		int num01 = 15; //stack영역에 15할당
		int num02 = 20;
		
		int[] arr01 = new int[25];
		int[] arr02 = new int[25];
		//stack영역과 heap영역에 당할.
		System.out.println(num01+":"+num02);
		System.out.println(arr01+":"+arr02);
		
		int num03 = 15; //stack영역에 15할당
		int num04 = 15;
			//동일한 데이터이므로 동일한 데이터 할당.
		int[] arr03 = {10};
		int[] arr04 = {10};
			// 동일한 데이터 이지만 heap영역의 주소값이 다르기에 다른데이터가 나타난다.
		
		int num05 = num01; //num01;데이터를 num03에 할당
		System.out.println(num01+":"+num05);
		num05 = 20;
		System.out.println(num01+":"+num05);
		
		//#객체의 경우 처리되는 방식
		int[] arr05 = arr01;//메모리의 주소를 할당한다.
		// 같은 위치의 주소에 할당.
		System.out.println(arr05+":"+arr01);
		System.out.println(arr05[0]+":"+arr01[0]);
		arr05[0]=20;
		System.out.println(arr05[0]+":"+arr01[0]);
		// 같은 주소에 있는 데이터를 이름만 달리하고 호출하기에
		//데이터를 동일하게 가지고 있다.
		//비교연산자의 비교
		//기본 유형의비교는 할당된 실제 데이터를 비교
		System.out.println("#기본 유형데이터#");
		System.out.println("num01 == num02"+(num01 == num02));
		System.out.println("num02 == num03"+(num02 == num03));
		System.out.println("객체(배열) 비교#");
		System.out.println("arr01 == arr02"+(arr01 == arr02));
		System.out.println("arr01 == arr02"+(arr01 == arr03));
		// ex) 나이1, 나이2, 나이3 정수형으로 선언하고,
		//		나이1과 나이2에 각각 25를 할당하고, 나이3은 나이1데이터를 할당하여,
		// 각각의 데이터를 비교하세요
		
	int age01 = 25;
	int age02 = 25;
	int age03 = age01;
	System.out.println(age01+""+age02+""+age03);

	int[] train1,train2,train3;
	train1=train2=new int[] {3,3,2};
	train3 = train1;
	System.out.println(train1);
	System.out.println(train2);
	System.out.println(train3);
	train3[0] =10;
	System.out.println(train1[0]);
	System.out.println(train1[0]);
	System.out.println(train1[0]);
		
		
		
	}

}

