package a12_io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class A17_PathCopy {

	public static void main(String[] args) {
		/*
		 * #Path를 통한 파일 copy
		 */
		// 1. 연습파일만들기..
		String path = "C:\\a01_javaexp\\eclipse2\\javaexp\\src\\javaexp\\a12_io";
		// 2. 폴드만들기..
		File fold01 = new File(path + "\\a01_fold");
		if (!fold01.exists())
			fold01.mkdir();
		File fold02 = new File(path + "\\a02_fold");
		if (!fold02.exists())
			fold02.mkdir();
		File file01 = new File(path + "\\a01_fold", "a01Show.txt");
		if (!fold02.exists())
			fold02.mkdir();

		try {
			if (!file01.exists())
				file01.createNewFile();
				//파일 copy
			String orgFile = path +"\\a01_fold\\a01Show.txt"; //기존파일 존재 주소
			String tarFile = path +"\\a02_fold\\Copy_a01Show.txt"; // 카피할 주소
			Path oriPth = Paths.get(orgFile); //파일의 주소 변수할당
			Path copPath = Paths.get(tarFile); // 카피할 주소의 변수 할당
			//복사 처리
			Files.copy(oriPth, copPath,StandardCopyOption.REPLACE_EXISTING);
			System.out.println("복사 완료.");
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}
}
