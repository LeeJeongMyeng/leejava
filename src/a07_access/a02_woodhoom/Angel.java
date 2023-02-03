package a07_access.a02_woodhoom;

public class Angel {
public void woodCutter() {
	WoodCutter wc = new WoodCutter();
//	System.out.println("private:"+wc.privSec);
	System.out.println("default:"+wc.payOurHome);
System.out.println("protected:"+wc.inheritMoney);
	System.out.println("public:"+wc.announce);
}
}
