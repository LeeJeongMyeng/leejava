package homework;

public class Empdept100 {
/*
CREATE TABLE empdept100
AS SELECT ename,dname FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO 

INSERT INTO EMPDEPT100 VALUES ('이정명','연구소')
 */
private String ename;
private String dname;
public Empdept100(String ename, String dname) {
	this.ename = ename;
	this.dname = dname;
}
public Empdept100() {
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

}
