package homework;

public class VO1013_3 {

/*
SELECT ENAME, EMPNO, mod(empno, 2) div,sal, 
      decode (mod(empno, 2),0,sal,sal*0.5) bonus, 
      nvl2(NULLIF(mod(empno,2),0),sal+(sal*0.5),sal*2)  totsal
FROM EMP e;

 */
private String ename;
private int empno;
private int div;
private double sal;
private double bonus;
private double totsal;
public VO1013_3() {}
public VO1013_3(String ename, int empno, int div, double sal, double bonus, double totsal) {
	this.ename = ename;
	this.empno = empno;
	this.div = div;
	this.sal = sal;
	this.bonus = bonus;
	this.totsal = totsal;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public int getEmpno() {
	return empno;
}
public void setEmpno(int empno) {
	this.empno = empno;
}
public int getDiv() {
	return div;
}
public void setDiv(int div) {
	this.div = div;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
public double getBonus() {
	return bonus;
}
public void setBonus(double bonus) {
	this.bonus = bonus;
}
public double getTotsal() {
	return totsal;
}
public void setTotsal(double totsal) {
	this.totsal = totsal;
}

}
