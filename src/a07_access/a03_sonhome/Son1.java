package a07_access.a03_sonhome;
import a07_access.a02_woodhoom.WoodCutter;

public class Son1 extends WoodCutter {
	// 상위 클래스가 다른 패키지에 있는 상속받은 하위 클래스
	public void callWoodCutter() {
		
//		private 접근안됨
//		System.out.println("private:"+privSec);
		//X같은 패키지가 아니기에 접근이안됨
//		접근제어자가 default(X)인 것은 패키지 내에서 클래스간에 자유롭게 사용가능	
//		System.out.println("default:"+payOurHome);
	
		// 다른패키지일지라도 protected라고 붙은 접근제어자의 변수는 접근이 가능하다.
		// 단, 상속받은 경우에만
		System.out.println("protected:"+inheritMoney);
		//상속관계이기 때문에 protected가능
		System.out.println("public:"+announce);
		WoodCutter wc = new WoodCutter();
	//	System.out.println(wc.inheritMoney); 에러남
		//상속관계라는 자기 몸체 사용형식을 사용하지않고,
		// 상속관게임에도 불구하고 참조값으로 외부 객체를 호출하는
		//형식으로 처리할 때는 protected로 접근 할 수 없다.
		
	}

}
