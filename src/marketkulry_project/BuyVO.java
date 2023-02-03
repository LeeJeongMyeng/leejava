package marketkulry_project;

import java.util.Date;

public class BuyVO {
private String buyno;
private String userno;
private Date buydate;
private String patment_status;
private int OLCpayment;
public BuyVO() {
}

public int getOLCpayment() {
	return OLCpayment;
}

public BuyVO(String userno, int oLCpayment) {
	this.userno = userno;
	OLCpayment = oLCpayment;
}

public void setOLCpayment(int oLCpayment) {
	OLCpayment = oLCpayment;
}

public BuyVO(int oLCpayment) {
	OLCpayment = oLCpayment;
}

public BuyVO(String userno) {
	this.userno = userno;
}

public BuyVO(String buyno, String userno) {
	this.buyno = buyno;
	this.userno = userno;
}
public BuyVO(String buyno, String userno, Date buydate, String patment_status) {
	this.buyno = buyno;
	this.userno = userno;
	this.buydate = buydate;
	this.patment_status = patment_status;
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
public Date getBuydate() {
	return buydate;
}
public void setBuydate(Date buydate) {
	this.buydate = buydate;
}
public String getPatment_status() {
	return patment_status;
}
public void setPatment_status(String patment_status) {
	this.patment_status = patment_status;
}


}
