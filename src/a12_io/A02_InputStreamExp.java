package a12_io;

import java.io.IOException;
import java.io.InputStream;

public class A02_InputStreamExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A02_InputStreamExp.java를 만들고, InputStream에 의해서
		//정답을 입력하세요 (1~4):를 통해 입력받고 정답이  3이면 정답 기외는 
		// 오답을 처리하세요
		
		InputStream exp =null;
		System.out.println("문자 한자를 입력하세요(1~4):");
		exp = System.in;
		
		try {
			int chCode=exp.read(); 
			char inDATA = (char)chCode;
			System.out.println("입력된 문자의 코드번호:"+chCode);
			System.out.println("입력된 문자:"+(char)chCode);
			
			//!!!!!!!!!!!!입력된 코드값으로 확인받는방법!!!!!!!!!!!!!
			if(chCode==50||chCode==49||chCode==52) { //받은 문자의 코드값으로 비교연산자를 실행해야함
				System.out.println("오답입니다.");
			}else if(chCode<49||chCode>52) {
				System.out.println("선택지 범위를 벗어났습니다.다시 입력해주세요.");
			} else {
				System.out.println("정답입니다.");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		// !!!!!!!!!!!입력값으로 확인받는방법!!!!!!!!!!!!!!
		try {
			int chCode=exp.read(); 
			char inDATA = (char)chCode;
			System.out.println(inDATA);
			System.out.println("입력된 문자의 코드번호:"+chCode);
			System.out.println("입력된 문자:"+(char)chCode);
			char corNum = '3'; //문자로 선언해줘야함
			//입력된 코드값으로 확인받는방법
			if(inDATA==corNum) { //받은 문자의 코드값으로 비교연산자를 실행해야함
				System.out.println("정답입니도.");
			}else {
				System.out.println("오답입니도.");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		//문자(char)를 숫자로 바꾸고 싶으면 문자열로 바꾼다음
		// Integer.parseInt()등의 함수를 이용해서 처리해야한다.
		// 1) 문자->문자열   ""+'A'
		// 2) Character.valueOf('안').toString()
		char corNum ='3';
	
		
	}

}
