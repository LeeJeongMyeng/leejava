package book_project;

public class BookUser {
/*
CREATE TABLE BookUser(
USERno varchar2(20) PRIMARY KEY, --회원 번호
div varchar2(20) CONSTRAINT BookUser_div_ck check(div IN ('관리자','회원')), -- 구분(관리자/회원)
username varchar2(20), -- 회원이름
address varchar2(100), -- 주소
Phone_Number varchar2(13), --전화번번호/ -까지 포함하여 15자리할지 고민
id varchar2(20), --회원 아이디
password varchar2(20), -- 회원 패스워드
rentalcnt NUMBER -- 대여 횟수
);

 */
private String usernotype;
private String div;
private String username;
private String rrn;
private String address;
private String Phone_number;
private String id;
private String pass;
private int rentalcnt;
private int returnwarning;
public BookUser() {} //기본 생성자




public BookUser(String usernotype, String div, String username, String rrn, String address, String phone_number,
		String id, String pass, int rentalcnt, int returnwarning) {
	this.usernotype = usernotype;
	this.div = div;
	this.username = username;
	this.rrn = rrn;
	this.address = address;
	this.Phone_number = phone_number;
	this.id = id;
	this.pass = pass;
	this.rentalcnt = rentalcnt;
	this.returnwarning = returnwarning;
}




public BookUser(String usernotype, String div, String username, String phone_number, int rentalcnt, int returnwarning) {
	this.usernotype = usernotype;
	this.div = div;
	this.username = username;
	Phone_number = phone_number;
	this.rentalcnt = rentalcnt;
	this.returnwarning = returnwarning;
}




public BookUser(String usernotype, String div, String username, String rrn, String address, String phone_number, String id,
		String pass, int rentalcnt) {
	this.usernotype = usernotype;
	this.div = div;
	this.username = username;
	this.rrn = rrn;
	this.address = address;
	this.Phone_number = phone_number;
	this.id = id;
	this.pass = pass;
	this.rentalcnt = rentalcnt;
}


public BookUser(String id) { //아이디 중복확인용
	this.id = id;
}





public BookUser(String username, String rrn) { // 이름,주민번호 중복
	this.username = username;
	this.rrn = rrn;
}






public String getRrn() {
	return rrn;
}




public void setRrn(String rrn) {
	this.rrn = rrn;
}




public String getUsernotype() {
	return usernotype;
}
public void setUsernotype(String usernotype) {
	this.usernotype = usernotype;
}
public String getDiv() {
	return div;
}
public void setDiv(String div) {
	this.div = div;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone_number() {
	return Phone_number;
}
public void setPhone_number(String phone_number) {
	Phone_number = phone_number;
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
public int getRentalcnt() {
	return rentalcnt;
}
public void setRentalcnt(int rentalcnt) {
	this.rentalcnt = rentalcnt;
}




public int getReturnwarning() {
	return returnwarning;
}




public void setReturnwarning(int returnwarning) {
	this.returnwarning = returnwarning;
}



}
