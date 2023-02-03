package a06_Object;

import java.util.ArrayList;

public class A15_OneVsMultiExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SchClass sc = new SchClass(3);
		sc.showAllStudentList();
		sc.addStudent(new SchStudent("이정명",10));
		sc.addStudent(new SchStudent("이지은",11));
		sc.showAllStudentList();
		ArrayList<SchStudent> studentlist = new ArrayList<SchStudent>();
		studentlist.add(new SchStudent("찌니",12));
		studentlist.add(new SchStudent("벨르",13));
		studentlist.add(new SchStudent("룰루",14));
		sc.regdateStudentAll(studentlist);
		sc.showAllStudentList();
	}

}
//ex) SchClass(반/ArrayList<SchStudent>)
//	  SchStudent(번호,이름) 1:다 관계를 설정하여 출력처리하세요

class SchClass{
	private int classroom;
	private ArrayList<SchStudent> studentlist;
	public SchClass(int classroom) {
		this.classroom = classroom;
		this.studentlist = new ArrayList<SchStudent>();
	}
	
	public void addStudent(SchStudent S) {
		this.studentlist.add(S);
		System.out.println(S.getName()+"학생이 입학했습니다.");
	}
	public void regdateStudentAll(ArrayList<SchStudent> studentlist) {
		this.studentlist.addAll(studentlist);
		System.out.println(studentlist.size()+"명 입학");
	}
	public void showAllStudentList() {
		System.out.println("# "+classroom+"반 인원 목록#");
		if(this.studentlist.size()>0) {
			for(SchStudent s:this.studentlist) {
				System.out.println("이름:"+s.getName());
				System.out.println("번호:"+s.getNum01());
			} 
		} else {
			System.out.println("아직 입학 전입니다.");
		}
	}
}

class SchStudent{
	private String name;
	private int num01;
	public SchStudent(String name, int num01) {
		this.name = name;
		this.num01 = num01;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum01() {
		return num01;
	}
	public void setNum01(int num01) {
		this.num01 = num01;
	}
	
}