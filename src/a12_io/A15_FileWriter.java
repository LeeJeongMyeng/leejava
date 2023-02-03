package a12_io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class A15_FileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//ex) Z02-Test.txt 파일에 문자 문자배열 문자열 선언 할당
		String file02 = "C:\\a01_javaexp\\eclipse2\\javaexp\\src\\javaexp\\a12_io\\Z02_Test.taxt";
	
	try {
		Writer writer02 = new FileWriter(file02);
		writer02.write(70);
		char b = '명';
		writer02.append('\n');
		writer02.append(b);
		char[] d = {'점','심','시','간'};
		writer02.write(d);
		writer02.write("배고파요");
		
		writer02.flush();
		writer02.close();
		
	} catch (IOException e) {
		
		e.printStackTrace();
	} catch(Exception e) {
		e.printStackTrace();
	}
	 
	
	}

}
