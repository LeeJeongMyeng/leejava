package a06_Object;

public class A12_ObjVsObjExp {

	public static void main(String[] args) {
		Student st01 = new Student("이정명");
	//	System.out.println(st01); // toString()선언 메서드 호출
		st01.setElementSch(new ElementSch("경남대학교",2019));
		st01.showInfo();
	}

}

//ex) 1:1관계 연습 Student(이름,ElementSch) ElementSch(학교명, 졸업연도 )
class Student{
	private String name;
	private ElementSch elementSch;
	
	public Student(String name) {
		this.name = name;
	}

	public void setElementSch(ElementSch elementSch) {
		this.elementSch = elementSch;
	}
public void showInfo() {
	System.out.println("## "+name+"의 대학교##");
	if(this.elementSch==null) {
		System.out.println("학교 정보 없음");
	}else {
		System.out.println(this.elementSch);
	}
}
	
}

class ElementSch{
	private String schname;
	private int schend;
	public ElementSch(String schname, int schend) {
		this.schname = schname;
		this.schend = schend;
	}
	@Override
	public String toString() {
		return "대학교 [학교이름=" + schname + ", 졸업연도=" + schend + "년]";
	}
}