package a03_calcu;

public class A03_incre_des {

	public static void main(String[] args) {
		/*
		  #증감연산자
		  1. 변수명++, 변수명--
		  		1씩 증가 감소처리
		  #증감 대입 연산자
		  		특정한 단위로 증감하는 연산자
		 
		 */
		/*
		int cnt =1;
		System.out.println(cnt++);
		System.out.println(cnt++);
		System.out.println(cnt-=5);
		System.out.println(cnt--);
		System.out.println(cnt--);
		*/
		int count = 3;
		System.out.println(++count);
		System.out.println(++count);
		System.out.println(++count);
		System.out.println(++count);
		System.out.println(++count);
		System.out.println(--count);
		System.out.println(--count);
		System.out.println(--count);
		System.out.println(--count);
		System.out.println(--count);
		//++cnt01+은뭐임?
		// ++cnt01 증가된 내용을 출력
		// cnt01++ 다음호출시 증가된 내용확인
		int count2 =2;
		System.out.println(count2*=3);
		System.out.println(count2*=3);
		System.out.println(count2*=3);
		System.out.println(count2*=3);
		System.out.println(count2*=3);
		
		int count3 = 1;
		System.out.println(count3+=1);
		System.out.println(count3+=2);
		System.out.println(count3+=3);
		System.out.println(count3+=4);
		System.out.println(count3+=5);
		System.out.println(count3+=6);
		System.out.println(count3+=7);
		System.out.println(count3+=8);
		System.out.println(count3+=9);
		System.out.println(count3+=10);
		
	  int count4 = 100;
	  System.out.println(count4-=5);
	  System.out.println(count4-=5);
	  System.out.println(count4-=5);
	}

}
