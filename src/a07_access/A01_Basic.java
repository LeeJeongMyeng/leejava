package a07_access;
// javaexp.a07_access.A01_Basic

import A05_restore.A01_Man;
import a02_.A01_Music;

public class A01_Basic {

	public static void main(String[] args) {
		/*
		 #패키지
		 1. 클래스를 기능별로 묶어서 그룹 이름을 붙여 놓은 것을 말한다.
		 	1)파일들을 관리하기 위해 사용하는 폴드(디렉토리)와 비슷한 개념이다.
		 	2) 패키지의 물리적인 형태는 파일 시스템의 폴드와 같다.
		 2. 클래스 이름의 일부이다.
		 	1) 클래스를 유일하게 만들어주는 식별자이다.
		 	2) 전체 클래스 이름 : 상위패키지.하위패키지.클래스
		 	package javaexp.a07_access.A01_Basic
		 	3) 클래스명이 같아도 패키지명이 다르면 다른 클래스로 취급한다.
		 	cf)같은 패키지에서는 같은 클래스 명으로 선언하지 못하지만(에러)
		 		패키지가 다른 다른곳에 곳은 클래스명이 선언이 가능하다.
		 #import문
		 1. 패키지 내에 같이 포함된 클래스간 클래스 이름으로 사용가능
		 2. 패키지가 다른 클래스를 사용해야 할 경우
		 	1) 패키지명 포함된 전체 클래스 이름으로 사용
		 	2) import문으로 패키지를 지정하고 사용
		 	
		 */
		// 같은 패키지에 있는 클래스는 패키지명 없이 바로 선언 가능.
		//외부에 있는 패키지 클래스를 객체로 생성시.
		// 1. 패키지명.클래스명
			A01_Person p1 = new A01_Person();
		//ex)main()에서나 호출하는 클래스에서 동일한 클래스명 다른 패키지명을 객체 생성할 댸, 사용해야한다.
		// 2.import
			
		// 클래스명
			A01_Man m01=new A01_Man();
	//		cf)  import javaexp.a05_restore.*
	//			해당 패키지 하위에 있는 모든 클래스를 사용할 수 있다.
	//			단, 너무많은 패키지를 참고하기에 메모리를 많이 잡아먹는다.
			
			
			//ctrl+shift+o : import단축키
			//이와 같은 형식으로 외부패키지를 사용하는데, 전제 조건이  public이라는 접근 제어자가
			//선언되어 있을 때, 가능하다.
			// ex) public class A01_Person
			
	//ex) javaexp.a02_primitive패키지 하위에
			// A01_Music.java 클래스를 만들고,
			//import형식과
			// 전체 패키지명.클래스 형식으로 객체를 생성하세요
			A01_Music m1 = new A01_Music();
			A01_Music m2 = new A01_Music();
	}

}
