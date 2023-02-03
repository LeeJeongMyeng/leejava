package book_project;

import java.util.Date;

public class ShipVO {
private String shipno;
private Date shipdate;
private String rentalno;
private String userno;
public ShipVO(String shipno, Date shipdate, String rentalno, String userno) {
	this.shipno = shipno;
	this.shipdate = shipdate;
	this.rentalno = rentalno;
	this.userno = userno;
}

public ShipVO(String rentalno) {
	this.rentalno = rentalno;
}

public ShipVO(String rentalno, String userno) {
	this.rentalno = rentalno;
	this.userno = userno;
}

public ShipVO(Date shipdate, String rentalno, String userno) {
	this.shipdate = shipdate;
	this.rentalno = rentalno;
	this.userno = userno;
}

public ShipVO() {
}
public String getShipno() {
	return shipno;
}
public void setShipno(String shipno) {
	this.shipno = shipno;
}
public Date getShipdate() {
	return shipdate;
}
public void setShipdate(Date shipdate) {
	this.shipdate = shipdate;
}
public String getRentalno() {
	return rentalno;
}
public void setRentalno(String rentalno) {
	this.rentalno = rentalno;
}
public String getUserno() {
	return userno;
}
public void setUserno(String userno) {
	this.userno = userno;
}

}
