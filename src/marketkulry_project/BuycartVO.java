package marketkulry_project;

public class BuycartVO {
//buyno,userno,isbn,buycount,totprice
	
private String buyno;
private String userno;
private String isbn;
private int buycount;
private int totprice;
private String productname;
private String deletename1;
private String deletename2;
public BuycartVO() {
}




public BuycartVO(String isbn, int buycount, int totprice) {
	this.isbn = isbn;
	this.buycount = buycount;
	this.totprice = totprice;
}




public String getProductname() {
	return productname;
}




public void setProductname(String productname) {
	this.productname = productname;
}




public String getDeletename1() {
	return deletename1;
}




public void setDeletename1(String deletename1) {
	this.deletename1 = deletename1;
}




public String getDeletename2() {
	return deletename2;
}




public void setDeletename2(String deletename2) {
	this.deletename2 = deletename2;
}




public BuycartVO(String buyno, String userno, String productname, String deletename1, String deletename2) {
	this.buyno = buyno;
	this.userno = userno;
	this.productname = productname;
	this.deletename1 = deletename1;
	this.deletename2 = deletename2;
}




public BuycartVO(String userno, String isbn, int buycount, int totprice, String productname) {
	this.userno = userno;
	this.isbn = isbn;
	this.buycount = buycount;
	this.totprice = totprice;
	this.productname = productname;
}


public BuycartVO(String buyno, String userno, String isbn, int buycount, int totprice) {
	this.buyno = buyno;
	this.userno = userno;
	this.isbn = isbn;
	this.buycount = buycount;
	this.totprice = totprice;
}
public String getBuyno() {
	return buyno;
}
public void setBuyno(String buyno) {
	this.buyno = buyno;
}
public String getUserno() {
	return userno;
}
public void setUserno(String userno) {
	this.userno = userno;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public int getBuycount() {
	return buycount;
}
public void setBuycount(int buycount) {
	this.buycount = buycount;
}
public int getTotprice() {
	return totprice;
}
public void setTotprice(int totprice) {
	this.totprice = totprice;
}


}
