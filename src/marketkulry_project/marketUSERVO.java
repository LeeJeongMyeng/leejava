package marketkulry_project;

public class marketUSERVO {
//	userno,div,username,rrn,address,phonenumber,id,password,point
	
	private String userno;
	private String div;
	private String username;
	private String rrn;
	private String address;
	private String phonenumber;
	private String id;
	private String password;
	private int point;
	public marketUSERVO() {
	}
	
	public marketUSERVO(String userno, String div, String username, String rrn, String address, String phonenumber,
			String id, String password, int point) {
		this.userno = userno;
		this.div = div;
		this.username = username;
		this.rrn = rrn;
		this.address = address;
		this.phonenumber = phonenumber;
		this.id = id;
		this.password = password;
		this.point = point;
	}

	public marketUSERVO(String userno, String div, String username, String rrn, String address, String phonenumber,
			String id, String password) {
		this.userno = userno;
		this.div = div;
		this.username = username;
		this.rrn = rrn;
		this.address = address;
		this.phonenumber = phonenumber;
		this.id = id;
		this.password = password;
	}
	public marketUSERVO(String username, String rrn) {
		this.username = username;
		this.rrn = rrn;
	}
	public marketUSERVO(String id) {
		this.id = id;
	}
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
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
	public String getRrn() {
		return rrn;
	}
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
