package a10_api;

public class A05_String {

	public static void main(String[] args) {
		/*
		 #String 클래스 메소드
		 	1. 문자열의 추출, 비교, 찾기, 분리, 변환 등과 같은 다양한
		 		메소드를 가진다.
		 	2. 사용빈도가 높은 메소드
		 		1) charAt(int idx) : 문자열중 특정(n번째) 위치에 있는 문자리턴
		 */
		String str01= "EMP1061521";
		System.out.println("첫번 째 문자: "+str01.charAt(0));
		System.out.println("마지막번 째 문자: "+str01.charAt(9));
		
		//ex) 주민번호로 생년월일의 문자를 charAt로 추출하여 출력하세요.
		String civilNum = "901212-1702618";
		System.out.println("3번째 문자 리턴:"+civilNum.charAt(2));
		System.out.println("10번째 문자 리턴:"+civilNum.charAt(6));
		System.out.println("마지막 문자 리턴:"+civilNum.charAt(civilNum.length()-1));
			//앞으로는 년월로 추출해보기
		
		//String 생성자로 매개값을 처리할 수 있는 데이터 유형
		// 1. 문자열 자체: new String("안녕하세요");
		// 2. 문자배열: new String({'안','녕','하','세','요'});
		// 2. byte배열: new String({1,2,3,4,5});
		// 65 -->'A' ==>"A..."
		String str100 = new String();
	}

}
