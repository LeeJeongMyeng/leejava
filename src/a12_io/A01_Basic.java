package a12_io;

import java.io.IOException;
import java.io.InputStream;

public class A01_Basic {

	public static void main(String[] args) {
		/*
		 #데이터의 전송을 처리하는 Stream
		 1.자바에서는 Stream이라는 api객체를 통해서, 데이터를 입력하거나 출력을 하는 등
		 	처리를 하고있다.
		 		- 파일의 데이터를 입/출력 또는 파일 자체를 전송
		 2. System.out.println()은 기본적인 자바의 OutputStream의
		    하나의 형태로  console창을 통해 출력을 하게한다.
		 
		 3. System.in : 자바에서 InputStream의 한 형태로 console창에 
		 					데이터를 입력할 때, 사용되는 객체이다.
		 4. 입력 처리를 하는 InputStream!!
		 		데이터 처리과정
		 		정수형->char->문자열->문자열을 모아둔 파일(객체)
		 		1) 주요 메서드
		 			read(): 문자(char) ==>byte code값으로 연결되어
		 					있어서 저장되는 것은 정수형이라고 할 수 있다.
		 					이것은 char로 코드값과 연결되어 있는 문자로 변경되어
		 					표현하고 처리할 수 있다.
		 
		 */
		InputStream is =null;
		System.out.println("문자 한자를 입력하세요:");
		//console창에서 문자 한자를 입력 받기 위해 InputStream 객체 할당
		is = System.in;
		/*
		  입력된 글자 한자를 읽어와서 데이터를 할당하고 할당된 내용을 출력하는
		 	IO(Input output)는 첫시작이 InputStream과 OutputStream이라고 할 수 있다.
		 	그리고, 데이터의 입출력이 일어나는 경우에는 자바에서는 필수 예외 처리를 해주어야 실행을 
		 	할 수 있다.
		 	ex)int num01=is.read(); //read()기는 메서드를 통해  io가 발생하므로
		 	예외처리를한다.
		 */
	
			try {
				int chCode=is.read();
				System.out.println("입력된 문자의 코드번호:"+chCode);
				System.out.println("입력된 문자:"+(char)chCode);
			}catch(IOException e){
				e.printStackTrace();
			}
			
	}

}
