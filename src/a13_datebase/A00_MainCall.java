package a13_datebase;

import java.util.List;

import a13_datebase.vo2.Emp2;

public class A00_MainCall {

	public static void main(String[] args) {
		//Dao를 만들어 놓으면 어느 위치에서든지 해당 객체를 생성해서 사용할 수 있다.
		// 로그인처리 다른 프로그램 해당 항목에서 처리하고,
		// 데이터베이스 연동만 호출해서 처리한다.
		A04_DaoExp dao = new A04_DaoExp();
		List<Emp2> list = dao.getSch01(10);
		for(Emp2 e:list) {
			System.out.print(e.getDeptno()+"\t");
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getJob()+"\t");
			System.out.print(e.getSal()+"\n");
		}

	}

}
