package homework;

public class VO1012 {

private int deptno;
private int empno;
private String ename;
private String job;
private Double sal;
private int frsal;
private int tosal;

public VO1012() {}

public VO1012(int deptno, int empno, String ename, String job, Double sal) {
	this.deptno = deptno;
	this.empno = empno;
	this.ename = ename;
	this.job = job;
	this.sal = sal;
}


public VO1012(int frsal, int tosal) {
	this.frsal = frsal;
	this.tosal = tosal;
}

public int getDeptno() {
	return deptno;
}

public void setDeptno(int deptno) {
	this.deptno = deptno;
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
