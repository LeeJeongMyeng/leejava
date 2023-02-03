package a12_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class A07_BufferedReader {

	public static void main(String[] args) {
		Reader rd = new InputStreamReader(System.in);
		BufferedReader bf =new BufferedReader(rd);
		try {
			System.out.println("좋아하는 음악명: ");
			String music = bf.readLine();
			System.out.println("좋아하는 가수명: ");
			String singer = bf.readLine();
			System.out.println("입력한 음악명: "+music);
			System.out.println("입력한 가수명: "+singer);
			bf.close();
//			rd.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
