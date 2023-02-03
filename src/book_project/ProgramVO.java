package book_project;

import java.util.Date;

public class ProgramVO {
//prono, proname, prodate , userno, proexplan
private String prono;
private String proname;
private String prodate;
private String userno;
private String proexplan;
public ProgramVO() {
}
public ProgramVO(String prono, String proname, String prodate, String userno, String proexplan) {
	this.prono = prono;
	this.proname = proname;
	this.prodate = prodate;
	this.userno = userno;
	this.proexplan = proexplan;
}

public ProgramVO(String userno) {
	this.userno = userno;
}
public String getProno() {
	return prono;
}
public void setProno(String prono) {
	this.prono = prono;
}
public String getProname() {
	return proname;
}
public void setProname(String proname) {
	this.proname = proname;
}
public String getProdate() {
	return prodate;
}
public void setProdate(String prodate) {
	this.prodate = prodate;
}
public String getUserno() {
	return userno;
}
public void setUserno(String userno) {
	this.userno = userno;
}
public String getProexplan() {
	return proexplan;
}
public void setProexplan(String proexplan) {
	this.proexplan = proexplan;
}

}
