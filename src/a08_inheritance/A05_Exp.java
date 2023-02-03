package a08_inheritance;

import java.util.ArrayList;

public class A05_Exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1 = new BasePlayer("이정명");
		p1.trainning(); p1.play(); 
		Player p2 = new SoccerPlayer("이지은");
		p2.trainning(); p2.play(); 
		
		ArrayList<Player> players = new ArrayList<Player>();
		// Player p1 = new SoccerPlayer();
		players.add(new BasePlayer("찌니"));
		players.add(new BasePlayer("벨르"));
		players.add(new SoccerPlayer("룰루"));
		for(Player p12:players) {
			// 공통메서드와 다양한 재정의하는 기능을 처리
			p12.trainning(); p12.play();
		}
		BestPlayer3 bp3 = new BestPlayer3(9);
		bp3.setPlist(new BasePlayer("벨르"));
		bp3.setPlist(new BasePlayer("이정명"));
		bp3.setPlist(new SoccerPlayer("이지은"));
		bp3.showList();
	}

}
class BestPlayer3{
	private int month; // 월별 베스트 플레이어
	private ArrayList<Player> plist;
	public BestPlayer3(int month) {
		this.month = month;
		this.plist= new ArrayList<Player>();
	}
	public void setPlist(Player player) {
		this.plist.add(player);
	}
	public void showList() {
		System.out.println(month+"월 BEST Player");
		int no=0;
		for(Player p:plist) {
			System.out.print(++no+" ");
			System.out.println(p.getKind()+" "+p.getName());
			p.play();
		}
	}
	
	
	
}
// 추상 =  플레이어(선수의 정보)분류 이름
// 팀 play() : 재정의 (추상)
// BasePlayer , SoccerPlayer

abstract class Player{
	private String name;
	private String kind;
	
	

	public Player(String name, String kind) {
		this.name = name;
		this.kind = kind;
	}

	public void trainning() {
		System.out.println(this.name+"선수가 훈련을한다.");
	}

	public String getName() {
		return name;
	}
	

	public String getKind() {
		return kind;
	}

	public abstract void play();
}

class BasePlayer extends Player{

	public BasePlayer(String name) {
		super("야구선수",name);
	}
	public  void play() {
		System.out.println(getKind()+" "+getName());
		System.out.println("방망이질을한다.");
	}
	
}

class SoccerPlayer extends Player{

	public SoccerPlayer(String name) {
		super("축구선수",name);
	}
	public  void play() {
		System.out.println(getKind()+" "+getName());
		System.out.println("골을 넣었다..");
	}
}