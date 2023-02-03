package a07_access.a04_neighbor;

import a07_access.a02_woodhoom.WoodCutter;

public class Uncle {
	public void woodCutter() {
		WoodCutter wc = new WoodCutter();
// # 다른패키지의 클래스는 PUBLIC외에 접근 불가
//		System.out.println("private:"+wc.privSec);
//		System.out.println("default:"+wc.payOurHome);
//		System.out.println("protected:"wc.inheritMoney);
		System.out.println("public:"+wc.announce);
//			public인 경우에서 import만하면 어느 곳에서나 사용가능하다.
	}
}
