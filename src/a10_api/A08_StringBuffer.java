package a10_api;

public class A08_StringBuffer {

	public static void main(String[] args) {
		/*
		 #String 객체의 메모리 문제
		 1.String 문자열은 + 를 통해서 새롭게 heap영역에 만들어 지기에
		 	반복문을 활용하면 많은 객체가 만들어지게 된다.
		 2. 가능한한 문자열은 +를 통해서 만들면 새로운 메모리가 만들어지므로
		 특히, 반복문 안에서 사용하는 것은 자제하여야한다.
		 */
		String name="홍";
		for(int idx=0;idx<100;idx++) {
			name+=idx;
			//+를 통해서 하나의 메모리 name에 문자열 추가하는 것이 아님
			//새로운 메모리를 만들어 name이란 이름으로 처리되기에
			//반복문에 문자열 +연산자를 쓰는것은 메모리효율화에 위험하다.
			System.out.println(idx+":"+name.hashCode()+":"+name);
		}
		/*
		 * #StringBuffer, StringBuilder
		  1. 버퍼(buffer:데이터를 임시로저장하는 메모리)에 문자열 저장
		  2. 버퍼 내부에서 추가,수정,삭제 작업가능
		  3. 멀티쓰레드 환경:StringBuffer사용
		  		1초 0.0~0.1 ==>사용자1
		  		1초 0.1~0.2 ==>사용자2
		  		1초 0.3~0.4 ==>사용자3
		  		2초 1.0~1.1 ==>사용자1
		  		순서확보를 정확하게 할 수 없다.
		  		그렇지만 한번에 여러 사용자를 처리가 가능하다.
		  4. 단일쓰레드 환경 : StringBuilder사용
		  		1초 사용자1이 모든것을 다 처리할 떄까지 기다리고
		  		2초 사용자2..
		  5. 주요메서드
		  	1) append(...)
		  	2) insert(int offset,...)
		  	3) delete(int start,int end) :범위를 정해서 삭제
		  	4) deleteCharAt(int index) : 특정한 위치 문자 삭제
		  	5) replace(int start, int end, String str) : 특정한 문자열 위치를 대체
		  			"안녕하세요 hi! 반갑습니다. hi!"
		  			첫번째 hi!를 "안녕"으로 바꿀 때..
		  	6) reverse() : 문자열을 뒤집어 사용
		  	7) setCharAt(int ixdex, char ch) : 특정한 위치의 문자하나를 대체
		  		"안녕하세요 hi! 반갑습니다. hi!"
		  			h==>g특정한 위치 index 문자 하나로 변경..
		 */
		StringBuffer sbf=new StringBuffer("안녕하세요");
		for(int idx=0;idx<100;idx++) {
			sbf.append(""+idx);
			System.out.println(idx+":"+sbf.hashCode()+":"+sbf.toString());
		}
		System.out.println(sbf.reverse().toString());
		
		//ex)배열로 가위바위보로 문자열로 선언하고, 반복문으로 1~100회 임의의 가위바위보를
		// 		추가하여 StringBuffer에 할당하여 출력하세요
		String[] games = {"가위","바위","보"};
		StringBuffer sbf2 = new StringBuffer("#가위바위보 100회#\n");
		for(int cnt=1;cnt<=100;cnt++) {
			int rIdx=(int)(Math.random()*games.length);
			sbf2.append(cnt+"\t"+games[rIdx]+"\n");
		}
		System.out.println(sbf2.toString());
	}

}
