package homework;

public class VO1013_1 {
//	--1013_1번)분기별 또는 부서명 조건으로 사원의 이름, 부서명, 급여와 급여등급 출력
//
//	SELECT ename,DNAME, sal, grade
//	FROM emp e, SALGRADE s ,DEPT d 
//	WHERE  sal BETWEEN losal AND hisal
//	AND e.DEPTNO  = d.DEPTNO
//	AND to_char(hiredate,'q') ='1'
//	OR dname ='';
private String ename;
private String dname;
private double sal;
private int grade;
private String hireq;
public VO1013_1() {}
public VO1013_1(String ename, String dname, double sal, int grade) {
	this.ename = ename;
	this.dname = dname;
	this.sal = sal;
	this.grade = grade;
}
public VO1013_1(String dname, String hireq) {
	this.dname = dname;
	this.hireq = hireq;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public String getHireq() {
	return hireq;
}
public void setHireq(String hireq) {
	this.hireq = hireq;
}






}
