package homework;

public class VO1013_6 {
/*
 --1013_6번관리자명을 기준(조건)으로 관리자 하위에 포함된 직원정보(직원명, 부서번호, 급여) 출력하세요.

SELECT m.ENAME "관리자",e.ENAME "하위직원", e.EMPNO,e.SAL  
FROM EMP e ,emp m
WHERE e.mgr=m.EMPNO
AND m.ENAME = 'JONES';
 */
private String enameM;
private String enameE;
private int empno;
private double sal;
public VO1013_6() {}

public VO1013_6(String enameM, String enameE, int empno, double sal) {
	this.enameM = enameM;
	this.enameE = enameE;
	this.empno = empno;
	this.sal = sal;
}

public VO1013_6(String enameM) {
	this.enameM = enameM;
}

public String getEnameM() {
	return enameM;
}

public void setEnameM(String enameM) {
	this.enameM = enameM;
}

public String getEnameE() {
	return enameE;
}

public void setEnameE(String enameE) {
	this.enameE = enameE;
}

public int getEmpno() {
	return empno;
}

public void setEmpno(int empno) {
	this.empno = empno;
}

public double getSal() {
	return sal;
}

public void setSal(double sal) {
	this.sal = sal;
}


}
