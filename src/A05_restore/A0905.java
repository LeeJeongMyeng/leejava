package A05_restore;

import java.util.Scanner;

public class A0905 {

	public static void main(String[] args) {
		/*
		 switch문과 if문의 차이점
		 1 매개값()에 들어가 데이터가 변수와  boolean값으로 구별한다.
		 2. 조건문은 boolean에 의해서 데이트의 범위를 지정할 수 있다.
		  하지만 switch문은 단일한 데이터를 지정하여 처리할 떄 주로 활용된다.
		  
		 */
		/*
		 * Scanner scan = new Scanner(System.in);
		 * 
		 * int sno = 0; int tot = 0; while(true) {
		 * System.out.println(++sno+"번째 과목 점수입력"); int pt = scan.nextInt();
		 * 
		 * if(pt==-1) { sno--; break; } tot+=pt; } System.out.println("입력한 과목수:"+sno);
		 * System.out.println("총 점수:"+tot); System.out.println("평균:"+tot/(double)sno);
		 */
		
		int bread = 2;
	    int day=0;
	    int total=0;
	    for(day = 1; day<=10; day++) {
	    	int totbread = bread*day;
	    	total+=totbread;
	    	 //   1일차 2개 2개
	        //   2일차 4개 6개
	        //   3일차 6개 12개
	    	
	    	System.out.println(day+"일째\t"+totbread+"개\t"+"오늘까지해서 총 "+total+"개");
	    }
	}

}
