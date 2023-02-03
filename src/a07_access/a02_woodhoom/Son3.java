package a07_access.a02_woodhoom;

public class Son3 extends WoodCutter {
	public void callWoodCtuuer() {
	//	private이외 접근이 가능하다 )상속관계)
	//	System.out.println("private:"+privSec);
		System.out.println("default:"+payOurHome);
		System.out.println("protected:"+inheritMoney);
		System.out.println("public:"+announce);
	}

}
