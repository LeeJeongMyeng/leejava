package a10_api;

import java.util.Random;

public class A11_Random {

	public static void main(String[] args) {
		/*
		 #Random클래스
		 1. boolean, int, long,float,double난수 입수 가능
		 2. 난수를 만드는 알고리즘에 사용되는 종자값(seed)설정 가능
		 	종자값이 같은 난수: 종자값을 설정하면 한번 결과값이
		 	나오면 동일한 결과가 출력된다.
		 	
		 */
		
		Random r1 = new Random();
		Random r2 = new Random(100);
		System.out.println(r1.nextBoolean()+":"+r2.nextBoolean());
		System.out.println(r1.nextDouble()+":"+r2.nextDouble());
		System.out.println(r1.nextInt()+":"+r2.nextInt());
		//r1.nextInt(경우의수)+시작수 :정수값 리턴
		System.out.println(r1.nextInt()+":"+r2.nextInt(6));
		
		//주사위
		System.out.println(r1.nextInt(6)+1);
		//점수
		System.out.println(r1.nextInt(101)); //+0은 숨길수있다.
		/*
		 ps) 랜덤이 균등으로 처리 : 데이터를 동일한 확률로 처리
		 		정규화 분포: 중앙값을 기준으로비율을 가장 높이 나오게 하여 랜덤 데이터를 처리하는 경우
		 */
		
		

	}

}



