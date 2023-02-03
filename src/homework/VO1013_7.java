package homework;

public class VO1013_7 {
/*
 SELECT ENAME,DEPTNO
FROM EMP  
WHERE DEPTNO = (
	SELECT deptno
FROM EMP e 
WHERE to_char(hiredate,'MM')= '04'
GROUP BY DEPTNO);
 */
private String ename;
private int deptno;
private String mmmm;

public VO1013_7() {
}

public VO1013_7(String ename, int deptno) {
	this.ename = ename;
	this.deptno = deptno;
}

public VO1013_7(String mmmm) {
	this.mmmm = mmmm;
}

public String getEname() {
	return ename;
}

public void setEname(String ename) {
	this.ename = ename;
}

public int getDeptno() {
	return deptno;
}

public void setDeptno(int deptno) {
	this.deptno = deptno;
}

public String getMmmm() {
	return mmmm;
}

public void setMmmm(String mmmm) {
	this.mmmm = mmmm;
}

}
