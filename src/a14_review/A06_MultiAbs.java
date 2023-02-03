package a14_review;

import java.util.ArrayList;
import java.util.List;







public class A06_MultiAbs {

	public static void main(String[] args) {
		
//			List<Robot> rb = new ArrayList<Robot>();
//			rb.add(new Mz("로켓포 발사"));
//			rb.add(new Tv("발차기"));
//			rb.add(new Dagan("변신"));
//			for(Robot r: rb) {
//				r.Attack();
//			}
		RobotWar rbw = new RobotWar("로봇 1차대전");
		rbw.addPart(new Mz("주먹공격"));
		rbw.addPart(new Tv("발차기"));
		rbw.addPart(new Dagan("레이저공격"));

		rbw.showComInfo();
		}

	}


abstract class Robot{
	private String kind;
	private String Attack;
	public Robot(String kind,String Attack) {
		this.kind = kind;
		this.Attack = Attack;
	}
	public String getKind() {
		return kind;
	}
	public abstract void Attack();
	//public abstract void partFun2(String perFrm2);
	public String getPerFrm() {
		return Attack;
	}
}

class Mz extends Robot{

	public Mz(String Attack) {
		super("마징가",Attack);
		
	}
	public void Attack() {
		System.out.println(getKind()+"는 "+getPerFrm()+"을 할 수있다..");
		System.out.println("약하다.");
		
	}
	
}

class Tv extends Robot{

	public Tv(String Attack) {
		super("태권브이",Attack);
		
	}
	public void Attack() {
		System.out.println(getKind()+"는 "+getPerFrm()+"을 한다.");
		System.out.println("조금쎄다.");
		
	}
	
}
class Dagan extends Robot{

	public Dagan(String Attack) {
		super("다간",Attack);
		
	}
	public void Attack() {
		System.out.println(getKind()+"은 "+getPerFrm()+"을한다.");
		System.out.println("더 강하다.");
		
	}
	
}

class RobotWar{
	private String War;
	private List<Robot> rb;
	public RobotWar(String war) {
		this.War=war;
		rb = new ArrayList<Robot>();
	}
	//부품을 하나씩 추가/장착할 수 있는 기능 메서드
	public void addPart(Robot part) {
		System.out.println(part.getKind()+"참전");
		rb.add(part);
		}
	public void showComInfo() {
		System.out.println(War+" 전쟁");
		if(rb.size()>0) {
			System.out.println("참여로봇 공격정보");
			for(Robot r:rb) {
				r.Attack();
			}
		}else {
			System.out.println("참전 로봇이 없음.");
		}
		
		
	}
}