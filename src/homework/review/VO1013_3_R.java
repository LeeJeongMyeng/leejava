package homework.review;

public class VO1013_3_R {
/*
SELECT e.*, DECODE(div,0,'짝','홀') div2,
		decode(div,0,'100%','50%') bonus_per,
		round(decode(div,0,1,0.5)*sal) bonus,
		sal+round(decode(div,0,1,0.5)*sal) totpay
FROM (
SELECT empno, MOD(empno,2) div,
		ename, sal
FROM emp) e
WHERE div in(0,1)
 */
private String ename;
private int empno;
private String div2;
private double sal;
private String bonus_per;
private int bonus;
private int totpay;
public VO1013_3_R() {}

public VO1013_3_R(String ename, int empno, String div2, double sal, String bonus_per, int bonus, int totpay) {
	this.ename = ename;
	this.empno = empno;
	this.div2 = div2;
	this.sal = sal;
	this.bonus_per = bonus_per;
	this.bonus = bonus;
	this.totpay = totpay;	
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
public String getDiv2() {
	return div2;
}
public void setDiv2(String div2) {
	this.div2 = div2;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
public String getBonus_per() {
	return bonus_per;
}
public void setBonus_per(String donus_per) {
	this.bonus_per = donus_per;
}
public int getBonus() {
	return bonus;
}
public void setBonus(int bonus) {
	this.bonus = bonus;
}
public int getTotpay() {
	return totpay;
}
public void setTotpay(int totpay) {
	this.totpay = totpay;
}

}
