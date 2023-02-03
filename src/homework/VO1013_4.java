package homework;

public class VO1013_4 {
/*
SELECT empno,ENAME,floor(months_between(sysdate, hiredate)/12)||'년' yyyy,
      mod(floor(MONTHS_BETWEEN(sysdate, hiredate)),12)||'개월' mmmm
FROM emp;
 */
private int empno;
private String ename;
private double yyyy;
private double mmmm;
public VO1013_4() {
}
public VO1013_4(int empno, String ename, double yyyy, double mmmm) {
	this.empno = empno;
	this.ename = ename;
	this.yyyy = yyyy;
	this.mmmm = mmmm;
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
public double getYyyy() {
	return yyyy;
}
public void setYyyy(double yyyy) {
	this.yyyy = yyyy;
}
public double getMmmm() {
	return mmmm;
}
public void setMmmm(double mmmm) {
	this.mmmm = mmmm;
}


}
