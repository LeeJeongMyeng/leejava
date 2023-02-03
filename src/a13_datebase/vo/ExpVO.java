package a13_datebase.vo;

public class ExpVO {
/*
SELECT empno,ename,qm.qu||'/4',SAL  FROM emp e,(
SELECT to_char(hiredate,'q') qu, max(sal) msal
FROM EMP e 
GROUP BY to_char(hiredate,'q')
) qm
WHERE TO_CHAR(e.hiredate,'q')= qu
AND sal =msal
AND qu = ?
AND sal BETWEEN ? AND ? 
 */
private int empno;
private String ename;
private String qu;
private double sal;
private double frSal;
private double toSal;
public ExpVO() {
}
public ExpVO(String qu, double frSal, double toSal) {
	this.qu = qu;
	this.frSal = frSal;
	this.toSal = toSal;
}
public ExpVO(int empno, String ename, String qu, double sal) {
	this.empno = empno;
	this.ename = ename;
	this.qu = qu;
	this.sal = sal;
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
public String getQu() {
	return qu;
}
public void setQu(String qu) {
	this.qu = qu;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
public double getFrSal() {
	return frSal;
}
public void setFrSal(double frSal) {
	this.frSal = frSal;
}
public double getToSal() {
	return toSal;
}
public void setToSal(double toSal) {
	this.toSal = toSal;
}


}
