package a04_process;

public class A07_DoubleFor {

	public static void main(String[] args) {
		/*
		 # 중첩 반복문
		 1. 반복문 안에 반복을 처리하여,
		 		단위 데이터를 계층적으로 처리할 때, 사용된다.
		 2. 형식
		 	for(;;){//상위단계 반복
		 	   for(;;) {
		 	   //하위단계 반복
		 	    }
		 	 }
		 */
		int total = 0;
		for(int grade=2; grade<=9;grade++) {
			System.out.print(grade+"단 ==> \t");
			for(int cnt=1; cnt<=9;cnt++) {
			total = grade*cnt;	
				System.out.print(total+"\t");
			}
			System.out.println();
		}
		
	}

}
