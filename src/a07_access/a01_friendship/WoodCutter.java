package a07_access.a01_friendship;

public class WoodCutter {
	private String hiddenCloth = "날개옷은 뒷동산 바위 밑";
	// private :현재클래스에서 전역변수로 사용가능
	// 외부클래스에서 호출 불가
	String hiddenDeer="사슴 뒸쪽 덤불 속에 있음"; // 접근제어자 X(default)
	//같은 패키지에서만 접근 가능, 다른패키지에서 접근 불가
	
	public String introMyself = "나는 나무꾼입니다.";
}
