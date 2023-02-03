package marketkulry_project;

import java.sql.Date;

public class ProductVO {
//isbn, fication, productname, price, information, company, regisdate
 private String isbn;
 private String fication;
 private String productname;
 private int price;
 private String information ;
 private String company ;
 private Date regisdate;
 
public ProductVO() {}



public ProductVO(String isbn, String fication, String productname, int price, String information, String company,
		Date regisdate) {
	this.isbn = isbn;
	this.fication = fication;
	this.productname = productname;
	this.price = price;
	this.information = information;
	this.company = company;
	this.regisdate = regisdate;
}



public ProductVO(String isbn, String fication, String productname, int price, String information, String company) {
	this.isbn = isbn;
	this.fication = fication;
	this.productname = productname;
	this.price = price;
	this.information = information;
	this.company = company;
}

public ProductVO(String fication, String productname) {
	this.fication = fication;
	this.productname = productname;
}

public ProductVO(String productname) {
	this.productname = productname;
}

public ProductVO(int price) {
	this.price = price;
}



public String getIsbn() {
	return isbn;
}



public void setIsbn(String isbn) {
	this.isbn = isbn;
}



public String getFication() {
	return fication;
}



public void setFication(String fication) {
	this.fication = fication;
}



public String getProductname() {
	return productname;
}



public void setProductname(String productname) {
	this.productname = productname;
}



public int getPrice() {
	return price;
}



public void setPrice(int price) {
	this.price = price;
}



public String getInformation() {
	return information;
}



public void setInformation(String information) {
	this.information = information;
}



public String getCompany() {
	return company;
}



public void setCompany(String company) {
	this.company = company;
}



public Date getRegisdate() {
	return regisdate;
}



public void setRegisdate(Date regisdate) {
	this.regisdate = regisdate;
}


 
}


