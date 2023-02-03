package a04_process;

public class A06_Break_Continue {

	public static void main(String[] args) {
		/*
		 # break
		 1. 반복문 중단 처리
		 #continue
		 1. 특정 step의 반복
		 */
		/*
		for(int cnt1=1; cnt1<=10; cnt1++) {
			if(cnt1==5) break;
			System.out.print(cnt1+",");
			
		}
		
		for(int cnt1=1; cnt1<=10; cnt1++) {
			if(cnt1==5) continue;
			System.out.print(cnt1+",");
			
		}
		*/
		
	//ex 1~12월까지 전기요금
		int num01 = 120000;
		int total = 0;
		for(int cnt1=1; cnt1<=12; cnt1++) {
			if(cnt1==5) continue;
		int	total1 = num01*cnt1;
		total+=total1;
			System.out.print(total1+"\t");
			if(total>=1500000) break;
		}
		System.out.println("\n"+total);
	}

}

