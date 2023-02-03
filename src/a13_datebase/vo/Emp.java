package a13_datebase.vo;

import java.sql.Date;

public class Emp {
private int empno;
private String ename;
private String job;
private int mgr;
private Date hiredate;
private String hiredates;
private double sal;
private double frsal;
private double tosal;
private double comm;
private int deptno;
public Emp() {
}
//등록 시 사용할 생성자
public Emp(String ename, String job, int mgr, String hiredates, double sal, double comm, int deptno) {
	this.ename = ename;
	this.job = job;
	this.mgr = mgr;
	this.hiredates = hiredates;
	this.sal = sal;
	this.comm = comm;
	this.deptno = deptno;
}
//조회리스트 생성자
public Emp(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno) {

	this.empno = empno;
	this.ename = ename;
	this.job = job;
	this.mgr = mgr;
	this.hiredate = hiredate;
	this.sal = sal;
	this.comm = comm;
	this.deptno = deptno;
}
//검색1
public Emp(String ename,String job, double frsal, double tosal) {
	this.ename = ename;
	this.job = job;
	this.frsal = frsal;
	this.tosal = tosal;
}

public Emp(String ename, String job) {
	this.ename = ename;
	this.job = job;
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
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}

public Date getHiredate() {
	return hiredate;
}
public void setHiredate(Date hiredate) {
	this.hiredate = hiredate;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
public double getFrsal() {
	return frsal;
}
public void setFrsal(double frsal) {
	this.frsal = frsal;
}
public double getTosal() {
	return tosal;
}
public void setTosal(double tosal) {
	this.tosal = tosal;
}
public double getComm() {
	return comm;
}
public void setComm(double comm) {
	this.comm = comm;
}
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}
public int getMgr() {
	return mgr;
}
public void setMgr(int mgr) {
	this.mgr = mgr;
}
public String getHiredates() {
	return hiredates;
}
public void setHiredates(String hiredates) {
	this.hiredates = hiredates;
}


}