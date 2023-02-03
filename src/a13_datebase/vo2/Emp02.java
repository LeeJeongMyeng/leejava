package a13_datebase.vo2;

public class Emp02 {
private int empno;
private String ename;
private Double sal;
private int frsal;
private int tosal;
	 
	public Emp02() {}
	//조회 리턴
	public Emp02(int empno, String ename, Double sal) {
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
	}
	
	//조건 매개변수
	public Emp02(String ename, int frsal, int tosal) {
		this.ename = ename;
		this.frsal = frsal;
		this.tosal = tosal;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public int getFrsal() {
		return frsal;
	}

	public void setFrsal(int frsal) {
		this.frsal = frsal;
	}

	public int getTosal() {
		return tosal;
	}

	public void setTosal(int tosal) {
		this.tosal = tosal;
	}
	 
}
