package homework;

public class VO1013_5 {
/*
SELECT empno,ename,sal
FROM EMP e 
WHERE to_char(hiredate,'q') in(
   SELECT to_char(hiredate,'q') FROM emp 
   WHERE ename  = 'ALLEN');
 */
private int empno;
private String ename;
private double sal;
public VO1013_5() {
}
public VO1013_5(int empno, String ename, double sal) {
	this.empno = empno;
	this.ename = ename;
	this.sal = sal;
}
public VO1013_5(String ename) {
	this.ename = ename;
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
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}

}
