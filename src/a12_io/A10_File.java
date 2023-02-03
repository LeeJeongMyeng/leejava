package a12_io;

import java.io.File;
import java.io.IOException;

public class A10_File {

	public static void main(String[] args) {
		String path = "C:\\a01_javaexp\\eclipse2\\javaexp\\src\\javaexp\\a12_io";
				try {
					String fname = "Z02_Test.txt";
					// new File(경로명,파일명)
					File f01 = new File(path,fname);
					if(!f01.exists()) f01.createNewFile();
					
					//================================
					for(int cnt=1; cnt<=3;cnt++) {
						//path: 경로를 만들 상위 경로를 설정.
						// 반복문을 통한 directory생성
						// - 
						String subpath = path+"\\path"+cnt;
						//반복문을 통한 directory생성
						File path01 = new File(path+"\\path"+cnt);
						File p01 = new File(subpath);
						if(!path01.exists()) path01.mkdir();
						for(int no=0; no<=9; no++) {
							File f02 = new File(subpath, "menuel"+no+".txt");
							if(!f02.exists()) f02.createNewFile();
						}
						
					}
			}catch(IOException e) {
				e.printStackTrace();
			}
	}

}
