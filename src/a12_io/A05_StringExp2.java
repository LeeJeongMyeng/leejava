package a12_io;

import java.io.IOException;
import java.io.InputStream;

public class A05_StringExp2 {

	public static void main(String[] args) {
		//ex) 검색할 물건명(영문)으로 입력하고, "apple"와 동일하면
		// 		검색되었습니다 아니면 없습니다.
		InputStream is = System.in;
		byte[] inArr = new byte[5];
		System.out.print("검색할 물건명: ");
		try {
			is.read(inArr);
			String inputth = new String(inArr);
			System.out.println("입력한 물건: "+inputth);
			if(inputth.equals("apple")){
				System.out.println("검색되었습니다.");
			
			}else {
				System.out.println("없습니다.");
			}
		}catch(IOException e){
			
		}
	}

}
