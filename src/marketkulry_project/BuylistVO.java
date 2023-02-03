package marketkulry_project;

public class BuylistVO {
//buylistnum,buynum,isbn,buycount,price
	
private String buylistnum;
private String buynum;
private String isbn;
private String deletepro;
private int buycount;
private int price;
public BuylistVO() {
}

public String getDeletepro() {
	return deletepro;
}

public void setDeletepro(String deletepro) {
	this.deletepro = deletepro;
}

public BuylistVO(String buylistnum, String buynum, String isbn, String deletepro) {
	this.buylistnum = buylistnum;
	this.buynum = buynum;
	this.isbn = isbn;
	this.deletepro = deletepro;
}

public String getBuylistnum() {
	return buylistnum;
}
public void setBuylistnum(String buylistnum) {
	this.buylistnum = buylistnum;
}
public String getBuynum() {
	return buynum;
}
public void setBuynum(String buynum) {
	this.buynum = buynum;
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
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public BuylistVO(String buylistnum, String buynum, String isbn, int buycount, int price) {
	this.buylistnum = buylistnum;
	this.buynum = buynum;
	this.isbn = isbn;
	this.buycount = buycount;
	this.price = price;
}
public BuylistVO(String buylistnum, String buynum) {
	this.buylistnum = buylistnum;
	this.buynum = buynum;
}
public BuylistVO(String buylistnum) {
	this.buylistnum = buylistnum;
}

}
