package a10_api;



public class A04_System {

	public static void main(String[] args) {
		
		/*
		 #System 클래스
		 1.System 클래스용도
		 	1) 운영체제의 기능 일부 이용가능
		 	2) 프로그램 종료, 키보드로부터 입력, 모니터로부터 출력
		 		메모리 정리, 현재시간 읽기
		 	3) 시스템 프로퍼터 읽기, 환경 변수 읽기
		 2. 프로그램 종료(exit)
		 	1) 기능 - 강제적 jvm종료 system.exit(0)
		 		   - int 매개값을 지정하도록 - 종료 상태값
		 		   	정상종료일 경우 0, 비정상 종료일 경우 0이외 다른값
		 		   	어떤 값 주더라도 종료
		 		  - 만약 특정 상태값이 입력되었을 경우에만 종료하고
		 		  	자바의 보안 관리자 설정
		 */
		// System.err: 에러에 대한 처리 내용을 console창에 출력
		try {
			int value=Integer.parseInt("열개");
		}catch(NumberFormatException e){
			System.out.println("[에러내용]");
			System.out.println(e.getMessage());
			System.out.println("[에러내용]");
			System.out.println(e.getMessage());
		} 
		//제일 상단에선언하고 다른 코드 진행여부 확인.
		for(int cnt=1; cnt<=10;cnt++) {
			System.out.println("번호:"+cnt);
			if(cnt ==8) {
				System.out.println("프로세스 강제 종료");
				//System.exit(0);
			}
		}
	System.out.println("코드1");
	System.out.println("코드2");
	System.out.println("코드3");
	System.out.println("코드4");
	//운영체제와 사용자정의 출력
	String osName = System.getProperty("os.name");
	String userName = System.getProperty("user.name");
	String userHome = System.getProperty("user.Home");
	System.out.println("osName:"+osName);
	System.out.println("user.name:"+userName);
	System.out.println("user.Home:"+userHome);
	
	//시간 정보 처리
	long start = System.currentTimeMillis();
	System.out.println("시간:"+start);
	long sum=0;
	for(long cnt=1; cnt<10000000l;cnt++) {
		sum+=cnt;
		System.out.println(cnt+":"+sum);
	}
	long end = System.currentTimeMillis();
	System.out.println("종료:"+end);
	long time = end-start;
	System.out.println("결과:"+sum);
	System.out.println(time);
	System.out.println(time/1000+"초");
	System.out.println(time/1000/60+"분");
	System.out.println(time/1000/60/60+"시");;
	}

}
