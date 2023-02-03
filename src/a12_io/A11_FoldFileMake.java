package a12_io;

import java.io.File;
import java.io.IOException;

public class A11_FoldFileMake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			/*
			 ex) z01,2,3_fold 생성
			 		반복문에 경로만들고
			 		a01_code.txt~a09_code.txt각 생성
			 */
		String path = "C:\\a01_javaexp\\eclipse2\\javaexp\\src\\javaexp\\a12_io";
			try {
			// 파일(디렉토리 생성)	
				for(int cnt=1; cnt<=3;cnt++) {
					String subpath = path+"\\z0"+cnt+"_fold";
					File path01 = new File(path+"\\z0"+cnt+"_fold");
					//File p01 = new File(subpath);
					if(!path01.exists()) path01.mkdir();
			//파일 생성..		
					for(int no=1; no<=9; no++) {
						File f02 = new File(subpath, "a0"+no+"_code.txt");
						if(!f02.exists()) f02.createNewFile();
					}
				}
			}catch(IOException e) {
				
			}
	}
}

