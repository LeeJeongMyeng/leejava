package a13_datebase.vo2;

import java.sql.Date;

public class Emp04 {
	 private String dname;
	 private String ename;
	 private Date hiredate;
	 private Double sal;
	 private String hireq;
	public Emp04() {}
	
	public Emp04(String dname, String hireq) {
		this.dname = dname;
		this.hireq = hireq;
	}

	public Emp04(String dname, String ename, Date hiredate, Double sal) {
		this.dname = dname;
		this.ename = ename;
		this.hiredate = hiredate;
		this.sal = sal;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public String getHireq() {
		return hireq;
	}
	public void setHireq(String hireq) {
		this.hireq = hireq;
	}



}
