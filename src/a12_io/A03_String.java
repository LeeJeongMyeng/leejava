package a12_io;

import java.io.IOException;
import java.io.InputStream;

public class A03_String {

	public static void main(String[] args) throws IOException {
		/*
		 #InputStream
		 1. 바이트 기반 입력 스트림의 최상위 클래스로 추상클래스이다.
		 2. 주요 메서드
		 	1) int read() : 입력 시트림으로부터 1byte를 읽고, 읽은 바이트를 리턴한다.
		 	2) int read(byte[] b) : 입력스트림으로 부터 읽은 바이트들을 매개값으로 주어진
		 				바이트 배열 b에 저장하고 실제로 읽은 바이트 수를 리턴
		 	2) int read(byte[]b, int off, int len) : 입력스트림으로부터 len개 qkdlxm
		 		만큼 읽고 매개값으로 주어진 바이트배열 b[off]부터 len까지 저장한다.
		 		그리고 실제로 읽은 바이트 수인 len개를 리턴한다.
		 		만약, len개를 모두 읽지 못하면 실제로 읽은 바이트 수를 리턴한다.
		 	4) void close():사용한 시스템 자원을 반납하고 입력스트림을 닫는다.
		 */
		
		// 1. 입력스트림 객체 System.in 통해 객체 생성
		InputStream is = System.in;
		// 2. 여러개의 문자열을 입력할 수 있게 지정(영문)
		byte [] brr = new byte[10];
		// 3. read(byte[] : 해당 배열의 갯수만큼 문자열을 받을 수 있음.
		
		System.out.println("입력할 문자열: ");
		try {
	//	int cod = is.read(); //문자 한자를 받아서
	//	System.out.println((char)cod); //문자 한자를 가지고 출력
		int n = is.read(brr);
		String inStr = new String(brr);
		inStr.equals("Hello");;  // brr은 10개의 배열이라 남은 5개 공백이  nuill로할당되어
								//false발생함
		// cf) new String[byte[]), new String(char[])
		//n : 입력한 문자의 갯수
		//byte[] brr : 입력한 문자의 코드배열을 할당
		//ABC ==> byte[] brr ={65,66,67}
		System.out.println("문자의 갯수:"+n);
		System.out.println("입력된 문자!!");
		// brr[] : 입력된 데이터는 매개변수로 넘길 byte[]에 쌓인다.
		for(byte b:brr) {
			//brr ={65,66,67}
			//(char)brr[0]
			// 'A','B','C'
			System.out.println((char)b);
		}
		System.out.println();

		//4.자원의 해제
		is.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		

	}

}
