package a06_Object;

public class A08_MethodExp {

	public static void main(String[] args) {
		/*
		 #기능 메서드의 혼합예제 처리..
		 1.메서드의 리턴 처리, 매개변수 데이터
		 	프로세스처리, 실제 리턴값 처리
		    복합 내용을 사용하는 기능이 많다.
		 
		 2. 매개변수로 시작번호, 끝번호를 입력하여 
		 해당 데이터 총합을 return 부분
		 int total01(int start, int end){
		 int tot=0;
		 for(int cnt=start; cnt<=end;cnt++_{
		  system.out.porit(cnt+"+");
		  tot+=cnt;
		  }
		  return tot;
		 }
		 */
		
		MethodCompo mc= new MethodCompo();
		
		int totAll =mc.totAll(1, 10);
		System.out.println("총계: "+totAll);
		// ex) 
		Googoo gg = new Googoo();
		int dan=gg.dan(2,9,2,9);
		
		Googoo gg2= new Googoo();
		gg2.gugu(2);
		MethodCompo2 mc2= new MethodCompo2();
	int lastTot=mc2.prodCalcu("사과", 1200, 15);
//ex)삼각형의 면적(밑면, 높이) 리턴으로 면적
	Semo sm = new Semo();
	System.out.println("면적:"+sm.myen(3, 6));
	
	}
}
class Semo{
	int mit;
	int nob;
	int myen(int mit,int nop) {
		
		return mit*nop/2;
		
	}
}
class MethodCompo2{
	int prodCalcu(String name, int price, int end) {
		int tot=price*end;
		for(int cnt=1;cnt<=end;cnt++) {
			System.out.println(name+"\t");
			System.out.println(cnt+"\t");
			System.out.println(price*cnt+"\t");
		}
		return tot;
	}
}
class Googoo{
	void gugu(int grade) {
		System.out.println("#"+grade+"단#");
		for (int cnt=1;cnt<=9;cnt++) {
			
			System.out.println(grade+"x"+cnt+"="+grade*cnt);
		}
	}
	int dan(int front1, int end1,int front2,int end2) {
		
		System.out.println("구구단 시작!");
		for (int cnt=front1;cnt<=end1;cnt++) {
			System.out.println("#"+cnt+"단 시작#");
			for(int cnt1=front1;cnt1<=end1;cnt1++) {
				int tot=cnt*cnt1;
				System.out.println(cnt+"*"+cnt1+"="+tot);
			}
		}
		return end2;
			
	}
}

class MethodCompo{
	int totAll(int start, int end) {
		int tot=0;
		for(int cnt=start;cnt<=end;cnt++) {
			System.out.print(cnt+(cnt!=end?"+":"\n"));
			tot+=cnt;
		}
		return tot;
	}

	
}
