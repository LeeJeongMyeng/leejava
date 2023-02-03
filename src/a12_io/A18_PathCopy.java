package a12_io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class A18_PathCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\a01_javaexp\\eclipse2\\javaexp\\src\\javaexp\\a12_io";
		File fold03 = new File(path + "\\a03_fold");
		if (!fold03.exists())
			fold03.mkdir();
		try {

			String orgfile03 = path+"\\a02_fold\\Copy_a01Show.txt";
			String copfile03 = path+"\\a03_fold\\Copy_Copy_a01Show.txt";
			Path orgpath03 = Paths.get(orgfile03);
			Path coppath03 = Paths.get(copfile03);
			
			Files.copy(orgpath03,coppath03,StandardCopyOption.REPLACE_EXISTING);
			System.out.println("2->3으로 복사완료");
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
