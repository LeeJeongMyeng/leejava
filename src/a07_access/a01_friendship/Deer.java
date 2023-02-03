package a07_access.a01_friendship;

public class Deer {
	public void callWoodCutter() {
		WoodCutter w1 = new WoodCutter();
		System.out.println(w1.hiddenDeer);
//		System.out.println(w1.hiddenCloth);
// 		같은 패키지라도, 접근제어자가 private면 외부클래스에서 접근이 불가하다.
	}
}
