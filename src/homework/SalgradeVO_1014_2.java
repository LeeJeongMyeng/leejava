package homework;

public class SalgradeVO_1014_2 {

//SELECT * FROM SALGRADE1000; --grade losal hisal
private int grade;
private int losal;
private int hisal;
public SalgradeVO_1014_2() {
}
public SalgradeVO_1014_2(int grade, int losal, int hisal) {
	this.grade = grade;
	this.losal = losal;
	this.hisal = hisal;
}
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public int getLosal() {
	return losal;
}
public void setLosal(int losal) {
	this.losal = losal;
}
public int getHisal() {
	return hisal;
}
public void setHisal(int hisal) {
	this.hisal = hisal;
}

}
