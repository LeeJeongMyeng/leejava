package a12_io;

import java.io.IOException;
import java.io.InputStream;

public class A04_StringExp {

	public static void main(String[] args) {
		//위 형식으로 byte[]에 사용할 id를 입력받아서 출력하세요
		// new String(byte[])을 이용하여 "himan"인경우 와 비교하여 동일 여부를
		// 나타내세요 (영문으로만)
		
		/*
		 # Stream 데이터 처리 순서
		 1. 입력을 위한 InputStream객체 생성 및 java의 콘솔창 입력을
		 	위한 객체 System.in 할당 받는다.
		 2. 문자열을 입력 받기 위한 byte[] 선언..
		 3. InputStream의 read(byte[])통해서 데이터를 입력처리
		 	- IO 예외처리(try catch)
		 4. id = new String(byte[])를 통해서 입력한 문자열 String에할당
		 5. regMember ="himan"과 문자열 비교
		 	if(id.equals("himan")){
		 	등록된 아이디가 있습니다.
		 	}else{
		 	아이디를 등록하세요.
		 	}
		 	
		 */
//		System.out.println("13:"+((char)13));
//		System.out.println("10:"+((char)10));
		//입력 후 enter를 처리해서 2개 정도는 13,10입력된다.
//		System.out.println("0:"+((char)0));
		//1. 입력하는 inputstream객체 할당.
		InputStream is = System.in;
		//2. 입력하는 id를 할당할 byte[]배열선언
		byte[] inArr = new byte[5];
		//3. 입력 처리 메서드 read(byte[])호출
		System.out.print("등록할 아이디: ");
		try {
			//위 선언한 배열의 크기만큼. 리턴
			//{'A','B','C',null,null} 
			is.read(inArr);
			for(byte b:inArr) {
				System.out.println((int)b+";"+(char)b);
			}
				
			
			//갯수보다 작게들어오면 빈공간에 null추가
			//크기들어오면 잘려서 출력됨
			is.read(inArr);
			String inputId = new String(inArr); //byte[]==>char[] ==>String
			System.out.println("입력한 id:"+inputId);
			String str="himan   "; //공백도 문자열 포함이기에 himan과 동일하지 않다.
			if(inputId.endsWith("himan")) {
				System.out.println("등록된 아이디가 있습니다.");
			}else {
				System.out.println("등록가능한 아이디입니다.");
			}
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

}
