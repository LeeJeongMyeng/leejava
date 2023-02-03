package a04_process;

public class A05_ForIf {

	public static void main(String[] args) {
		/*
		  #for문안에 if문사용하기
		  	1. for문을 통한 변수는 조건문으로 여러가지 처리를 할 수 있다.
		  	2. 처리형식
		  		1)출력 형성 변경 처리
		  			조건문에 따라 탭간격 또는 줄바꿈 처리
		  			연산자의 형태 처리
		  
		 */
		/*
		for(int cnt=1; cnt<=20; cnt++) {
			if(cnt%3==0) {
				System.out.println("짝"); //if 3으로 나눠서 나머지가 0이면 줄바꿈처리
			} else {
				System.out.println(cnt+"\t");
			}
		}
		*/
		int tot1 = 0;
		int tot2 = 0;
		for(int cnt2=1; cnt2<=100; cnt2++) {
				System.out.println(cnt2+(cnt2%5==0?"\n":"\t"));
				if(cnt2%2==0) {
					tot2+=cnt2;
					
				}else tot1+=cnt2;
			}
		System.out.println(tot2);
		System.out.println(tot1);
		}
		
		}	

	


