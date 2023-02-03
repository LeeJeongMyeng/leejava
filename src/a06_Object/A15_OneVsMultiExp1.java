package a06_Object;

import java.util.ArrayList;

public class A15_OneVsMultiExp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OnTrain ot = new OnTrain("코레알");
		ot.showtlist();
		ot.setTlist(new Ticketing("창원","1번좌석",15000));
		ot.setTlist(new Ticketing("서울","2번좌석",10000));
		ot.setTlist(new Ticketing("마산","3번좌석",20000));
		ot.showtlist();
	}

}
// ex) 코레인 예매 시스템
// OnTrain 시스템 명 ArrayList<Ticketing>

//Ticketing(구간,좌석, 비용)
class OnTrain{
	private String sysname;
	private ArrayList<Ticketing> tlist;
	public OnTrain(String sysname) {
		this.sysname = sysname;
		this.tlist = new ArrayList<Ticketing>();
	}
	
	public void setTlist(Ticketing t) {
		this.tlist.add(t);
		System.out.println(t.getLoc()+"으로 가는 티켓 추가 예매");
	}
	public void showtlist() {
		System.out.println("예매 어플:"+sysname);
		if(tlist.size()==0) {
			System.out.println("현재 예매 내역이 없습니다.");
		}else {
			System.out.println("현재 예매 리스트");
			for(Ticketing t:tlist) {
				t.ticketInfo();
			}
		}
		
	}
}
class Ticketing{
	private String loc;
	private String seet;
	private int cost;
	public Ticketing(String loc, String seet, int cost) {
		this.loc = loc;
		this.seet = seet;
		this.cost = cost;
	}
	public void ticketInfo() {
		System.out.print(this.loc+"\t");
		System.out.print(this.seet+"\t");
		System.out.print(this.cost+"\n");
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getSeet() {
		return seet;
	}
	public void setSeet(String seet) {
		this.seet = seet;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}