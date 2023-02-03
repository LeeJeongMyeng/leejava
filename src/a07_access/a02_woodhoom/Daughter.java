package a07_access.a02_woodhoom;

public class Daughter extends WoodCutter {
	public void callWoodCutter() {
//	System.out.println("private:"+privSec);
		//같은 패키지에서는 private빼고 접근가능
	System.out.println("default:"+payOurHome);
	System.out.println("protected:"+inheritMoney);
	System.out.println("public:"+announce);
}
	}
