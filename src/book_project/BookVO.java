package book_project;

import java.sql.Date;

public class BookVO {
/*
 CREATE TABLE BookInfo(
isbn number(13) PRIMARY KEY, --도서등록번호1
bname varchar2(100), --책이름2
genre varchar2(20), --장르3
publisher varchar2(20), --출판사4
writer varchar2(20), --저자5
price number, --가격6
registdate date, -- 등록일자7
rentalwhether varchar2(20) -- 대여여부9
);
 */
private String isbn;
private String bname;
private String genre;
private String publisher;
private String writer;
private int price;
private String rentalwhether;



public BookVO() {}


public BookVO(String rentalwhether) {
	this.rentalwhether = rentalwhether;
}










public String getIsbn() {
	return isbn;
}



public void setIsbn(String isbn) {
	this.isbn = isbn;
}



public String getBname() {
	return bname;
}



public void setBname(String bname) {
	this.bname = bname;
}



public String getGenre() {
	return genre;
}



public void setGenre(String genre) {
	this.genre = genre;
}



public String getPublisher() {
	return publisher;
}



public void setPublisher(String publisher) {
	this.publisher = publisher;
}



public String getWriter() {
	return writer;
}



public void setWriter(String writer) {
	this.writer = writer;
}



public int getPrice() {
	return price;
}



public void setPrice(int price) {
	this.price = price;
}






public BookVO(String isbn, String bname, String genre, String publisher, String writer, int price,
		String rentalwhether) {
	this.isbn = isbn;
	this.bname = bname;
	this.genre = genre;
	this.publisher = publisher;
	this.writer = writer;
	this.price = price;
	this.rentalwhether = rentalwhether;
}







public String getRentalwhether() {
	return rentalwhether;
}



public void setRentalwhether(String rentalwhether) {
	this.rentalwhether = rentalwhether;
}



}
