package a12_io;

import java.io.IOException;
import java.io.OutputStream;

public class A12_OutputStream {

	public static void main(String[] args) {
		/*
		 #OutputStream
		 1. 바이트기반 출력 스트림의 최상위 클래스로 추상 클래스
		  			OutputStream
		  #하위 객체들
		  FileOutputStream
		  PrintStream
		  BufferedOutputStream
		  DataOutputStream
		 
		 2. 주요 기능 메서드
		  write(int b) 출력 스트림으로 1바이트를 보낸다.
		  write(byte[]b) 출력 스트림으로 매개값으로 주어진 바이트 배열b의 모든 바이트를 보낸다.
		  write(byte[]b, int off, int len)
		  flush(): 버퍼에 잔류하는 모든 바이트를 출력한다.
		  close() : 사용한 시스템을 반납하고, 출력 스트림을 닫는다.
		 */
		OutputStream os = System.out;
		try {
			os.write(65); //code로 'A'출력
			byte[] b = {66,67,68,69,70}; //Code로 'BCDEF'출력
			os.write(b);
			os.flush();
			os.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
