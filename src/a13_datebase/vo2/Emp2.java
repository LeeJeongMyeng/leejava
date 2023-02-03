package a13_datebase.vo2;

public class Emp2 {
private int deptno;
private String ename;
private String job;
private Double sal;

public Emp2() {
}
public Emp2(int deptno, String ename, String job, Double sal) {
	this.deptno = deptno;
	this.ename = ename;
	this.job = job;
	this.sal = sal;
}
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
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
public Double getSal() {
	return sal;
}
public void setSal(Double sal) {
	this.sal = sal;
}


}
