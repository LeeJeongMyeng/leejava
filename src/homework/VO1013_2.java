package homework;

import java.sql.Date;

public class VO1013_2 {
/*
SELECT  to_char(hiredate,'YY') yy, count(empno) empnoc, max(sal) msal
FROM EMP e 
GROUP BY to_char(hiredate,'YY')
HAVING to_char(hiredate,'YY')='82';
 */
private String yy;
private int empnoc;
private double msal;
public VO1013_2() {}
public VO1013_2(String yy, int empnoc, double msal) {
	this.yy = yy;
	this.empnoc = empnoc;
	this.msal = msal;
}

public String getYy() {
	return yy;
}
public void setYy(String yy) {
	this.yy = yy;
}
public int getEmpnoc() {
	return empnoc;
}
public void setEmpnoc(int empnoc) {
	this.empnoc = empnoc;
}
public double getMsal() {
	return msal;
}
public void setMsal(double msal) {
	this.msal = msal;
}

}
