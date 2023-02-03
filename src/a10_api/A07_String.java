package a10_api;

import java.util.Scanner;
import java.util.StringTokenizer;

public class A07_String {

	public static void main(String[] args) {
		/*
		 #String 기능 메서드
		 1. replace("찾는 문자열","변경할 문자열")
		 */
		String target="자바는 객체지향프로그램입니다.\n"+
		 "자바는 풍부한 api를 지원합니다.~~";
		String newStr = target.replace("자바", "JAVA");
		System.out.println("기존문자열:"+target);
		System.out.println("변경한 문자열:"+newStr);
		
		/*
		 2. substring("추출할시작위치(0~), 추출할 마지막 위치(1~))
		 특정한 문자열에서 문자열을 추출하여 문자를 만들떄, 사용한다.
		 */
//		Scanner sc = new Scanner(System.in);
//		System.out.println("주민번호 앞 6자리를 입력하세요");
//		String civilNum = sc.nextLine();
//		if(civilNum.length()==6) {
//			String yyyy = "19"+civilNum.substring(0,2);
//			String mmmm = civilNum.substring(2,4);
//			String dddd = civilNum.substring(4,6);
//			System.out.println(yyyy+"년"+mmmm+"월"+dddd+"일");
//		}else {
//			System.out.println("입력 형식은 6자리입니다. 정확하게 입력해주세요");
//		}
		
		/*
		 3. split("구분자") : 특정문자열을 구분자에 의해 구문하여 구분된 데이터를 배열로 할당처리
		 */
			String[] fruits="사과&바나나&딸기".split("&");
			//{"사과","바나나","딸기"}
			System.out.println("#과일#");
			for(String fruit:fruits) {
				System.out.println(fruit);
			}

		//ex) 서울-대전-대구-부산과 같이 나열된 문자열을 split구문을 이용해서 배열로 만들어
		// 		향상된 for문을 통하여 출력하세요
			String data02="서울-대전-대구-부산";
			String[] locs=  data02.split("-");
			System.out.println("#목적지#");
			for(String loclist:locs) {
				System.out.println(loclist);
			}
			/*
			 #StringTokenizeer("문자열","구분자") 객체활용
			 1. 기능메서드
			  countTOKENS():구분자를 통해 나온 데이터의 건수
			  nextToken() : 구분자를 통해서 나온 각 데이터 하나씩, 
			  				호출시 마다 하나씩 데이터를 가져온다.
			  hasMoreTokens():해당 데이터가 있을때, true
			 */
			StringTokenizer st = new StringTokenizer("오렌지&수박&딸기","&");
			int count = st.countTokens();
			System.out.println("#token#");
			for(int cnt1=1;cnt1<=count;cnt1++) {
				String token = st.nextToken();
				System.out.println(token);
			}
			st = new StringTokenizer("홍길동/김길동/신길동","/");
			while(st.hasMoreElements()) {
				System.out.println(st.nextToken());
			}
			
			//ex) StringTokenizer 객체를 이용하여 사과@3000@2 개를 for/while문 하나씩
			// 예제를 통하여 출력
			StringTokenizer apple = new StringTokenizer("사과@3000@2","@");
			int count2 = apple.countTokens();
			System.out.println("#사과 구매#");
			for(int cnt1=1;cnt1<=countTokens();cnt1++) {
				//바로 입력시 , countToken()갯수까지 줄어들어
				//3번까지 처리못함
				String token2 = apple.nextToken();
				System.out.println(token2);
			}
			//데이터 초기화처리가 필요하
			apple = new StringTokenizer("망고@4000@3","@");
			System.out.println("#망고구매#");
			while(apple.hasMoreElements()) {
				System.out.println(apple.nextToken());
			}
	}

	private static int countTokens() {
		// TODO Auto-generated method stub
		return 0;
	}

}
