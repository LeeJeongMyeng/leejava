package book_project;

import java.util.Date;

public class RentalVO {
	public RentalVO(String rentalno, String userno,Date rentdate, String isbn, String shipwhether,Date returndate, int rentaltime) {
		this.rentalno = rentalno;
		this.userno = userno;
		this.isbn = isbn;
		this.shipwhether = shipwhether;
		this.rentaltime = rentaltime;
		this.rentdate = rentdate;
		this.returndate = returndate;
	}



/*
	CREATE TABLE rental(

			userno varchar2(20) CONSTRAINT rental_userno_fk REFERENCES bookuser(userno),
			isbn varchar2(20) CONSTRAINT rental_isbn_fk REFERENCES bookinfo(isbn),
			shipwhether varchar2(20) CONSTRAINT rental_shipwhether_ck check(shipwhether IN ('배송신청','배송미신청')),
			rentDate DATE,
			returndate DATE,
			returnwhether varchar2(20) 
			) */
private String rentalno;
private String userno;
private String isbn;
private String shipwhether;
private int rentaltime;
private Date rentdate;
private Date returndate;
private String returnwhether;
public RentalVO() {
}



public RentalVO(String rentalno, String shipwhether) {
	this.rentalno = rentalno;
	this.shipwhether = shipwhether;
}



public RentalVO(String rentalno, String userno, Date rentdate) {
	this.rentalno = rentalno;
	this.userno = userno;
	this.rentdate = rentdate;
}



public RentalVO(String rentalno, String userno, String isbn, Date returndate) {
	this.rentalno = rentalno;
	this.userno = userno;
	this.isbn = isbn;
	this.returndate = returndate;
}



public RentalVO(String rentalno, String userno, String isbn, String shipwhether, Date rentdate, Date returndate,
		String returnwhether) {
	this.rentalno = rentalno;
	this.userno = userno;
	this.isbn = isbn;
	this.shipwhether = shipwhether;
	this.rentdate = rentdate;
	this.returndate = returndate;
	this.returnwhether = returnwhether;
}



public RentalVO(String userno, String isbn, String shipwhether, int rentaltime, String returnwhether) {
	this.userno = userno;
	this.isbn = isbn;
	this.shipwhether = shipwhether;
	this.rentaltime = rentaltime;
	this.returnwhether = returnwhether;
}

public RentalVO(String userno, String isbn, String shipwhether, String returnwhether) {
	this.userno = userno;
	this.isbn = isbn;
	this.shipwhether = shipwhether;
	this.returnwhether = returnwhether;
}




public RentalVO(String returnwhether) {
	this.returnwhether = returnwhether;
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
public String getShipwhether() {
	return shipwhether;
}
public void setShipwhether(String shipwhether) {
	this.shipwhether = shipwhether;
}
public String getReturnwhether() {
	return returnwhether;
}
public void setReturnwhether(String returnwhether) {
	this.returnwhether = returnwhether;
}

public int getRentaltime() {
	return rentaltime;
}

public void setRentaltime(int rentaltime) {
	this.rentaltime = rentaltime;
}

public String getRentalno() {
	return rentalno;
}

public void setRentalno(String rentalno) {
	this.rentalno = rentalno;
}



public Date getRentdate() {
	return rentdate;
}



public void setRentdate(Date rentdate) {
	this.rentdate = rentdate;
}



public Date getReturndate() {
	return returndate;
}



public void setReturndate(Date returndate) {
	this.returndate = returndate;
}



}
