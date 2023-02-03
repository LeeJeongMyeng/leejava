package homework;

import java.util.Date;

public class Member100VO {
/*
 CREATE TABLE MEMBER100(
id varchar2(50),
pass varchar2(50),
name varchar2(50),
div varchar2(50),
point NUMBER,
hiredate DATE
);

INSERT INTO member100 values(
'id',
'pass',
'name',
'div',
100,
to_date('2022/01/01','yyyy/mm/dd'));
 */
	
private String id;
private String pass;
private String name;
private String div;
private int point;
private Date hiredate;
private String dates;

public Member100VO(String id, String pass) {
	this.id = id;
	this.pass = pass;
}

public Member100VO(String id, String pass, String name, String div, int point, Date hiredate) {
	this.id = id;
	this.pass = pass;
	this.name = name;
	this.div = div;
	this.point = point;
	this.hiredate = hiredate;


}

public Member100VO(String id, String pass, String name, String div, int point, String dates) {
	this.id = id;
	this.pass = pass;
	this.name = name;
	this.div = div;
	this.point = point;
	this.dates = dates;
}

public Member100VO() {
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDiv() {
	return div;
}

public void setDiv(String div) {
	this.div = div;
}

public int getPoint() {
	return point;
}

public void setPoint(int point) {
	this.point = point;
}

public Date getHiredate() {
	return hiredate;
}

public void setHiredate(Date hiredate) {
	this.hiredate = hiredate;
}

public String getDates() {
	return dates;
}

public void setDates(String dates) {
	this.dates = dates;
}



}
