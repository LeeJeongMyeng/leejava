package a12_io;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
public class A14_StringWriter {

	public static void main(String[] args) {
		
		String file01 = "C:\\a01_javaexp\\eclipse2\\javaexp\\src\\javaexp\\a12_io\\Z01_Test.taxt";
	
		try {
			Writer writer01 = new FileWriter(file01);
			writer01.write(65);
			char c = '홍';
			//기존 문자열에 추가 처리..
			writer01.append(c);
			char []arrc = {'안','녕','하','세','요'};
			writer01.write(arrc);
			writer01.write("해당문자열 입니다!!");
;			//버퍼에 잔류하고 있는 문자들을 출력하고, 버퍼를 비움
			writer01.flush();
			writer01.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	
	
	}

}
