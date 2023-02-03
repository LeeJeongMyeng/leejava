package a13_datebase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import a13_datebase.vo.Dept;
import a13_datebase.vo.Emp;

public class A03_DeptDao {
	// 공통필드 선언
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	//출력 기능메서드
	public void showDeptAll() {
		//연결객체
		try {
			con = DB.con();
			String sql = "SELECT * FROM dept100";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getInt("DEPTNO")+",");
				//System.out.print(rs.getString("DEPTNO")+",");
				// String s = ""+25; 가능 :문자열로 표현하는건 가능하다.
				// int num = "홍길동";
				//데이터유형은 가능한한 맞게 처리해야한다.
				
				System.out.print(rs.getString("DNAME")+",");
				System.out.println(rs.getString("LOC"));
			}
			//자원해제: 제일 마지막에 생성 ==> 가장 최초생성 ex)분해역순
		DB.close(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println("기타 sql처리 예외:"+e.getMessage());
		} catch(Exception e) {
			
		}finally {//예외 여부 산관없이 처리할 내용
			if(rs!=null) rs = null;
			if(stmt!=null) stmt=null;
			if(con!=null) con=null;
		} System.out.println("종료!");
		//대화객체
		
		//결과객체
		//while문처리 부서번호
	}
	public void insertDept(Dept insert) {
		String sql = "INSERT INTO dept100 values("+insert.getDeptno()+",'"+insert.getDname()+"','"+insert.getLoc()+"')";
		try {
			con=DB.con();
			//autocommit:false
			con.setAutoCommit(false);
			stmt = con.createStatement();
			int cnt = stmt.executeUpdate(sql);
			System.out.println("등록 데이터:"+cnt);
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB처리:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:"+e1.getMessage());
			}
		}catch(Exception e) {
			System.out.println("기다예외:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		
	}

	
	public static void main(String[] args) {
		A03_DeptDao dao3 = new A03_DeptDao();
		/*
		Dept ins = new Dept();
		ins.setDeptno(10);
		ins.setDname("인사");
		ins.setLoc("경기");
		dao3.insertDept(ins);
		*/
		dao3.showDeptAll();
		
		dao3.insertDept(new Dept(12,"회계","대전"));
	

	}

}
