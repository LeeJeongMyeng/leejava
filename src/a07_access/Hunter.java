package a07_access;

import a07_access.a01_friendship.WoodCutter;

public class Hunter {
	public void callWoodCutter() {
		// public으로 클래스 선언과 생성자 선언은 가능
		WoodCutter w1 = new WoodCutter();
		//접근제어자가 default(X)때문에 외부패키지에 있는
		//Hunter클래스는 접근할 수 없다.
//		System.out.println(w1.hiddenDeer);
//		System.out.println(w1.hiddenCloth);
		System.out.println(w1.introMyself);
		//public이라 접근이 가능하다.
	}
}
