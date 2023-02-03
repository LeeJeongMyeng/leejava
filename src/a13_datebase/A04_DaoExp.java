package a13_datebase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import a13_datebase.vo.Emp;
import a13_datebase.vo.PersonVO;
import a13_datebase.vo2.Emp02;
import a13_datebase.vo2.Emp03;
import a13_datebase.vo2.Emp04;
import a13_datebase.vo2.Emp05;
import a13_datebase.vo2.Emp2;

public class A04_DaoExp {
private  Connection con;
private Statement stmt;
private ResultSet rs;
//================================================================================
public List<Emp2> getSch01(int deptno){
	List<Emp2> list= new ArrayList<Emp2>();
	try {
		con=DB.con();
		String sql = "SELECT deptno, ename, job,sal\r\n"
				+ "FROM EMP e \r\n"
				+ "WHERE deptno = "+deptno;
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		/*
		 ResultSet: 조회결과의 뎅터를 가지고있다.
		 1.next(): 행단위로 이동
		 2. get타입("컬럼명") 또는 get타입(순서) 순서-> select의 순서대로
			  while(rs.next()){ 뎅터가 잇을떄까지 이동
			    rs.getInt("empno")
			    rs.getString("ename")
			    rs.getString(3)
			    rs.getDouble(4)
			  }
		 3. 위반복 프로세스에서 리턴으로 선언한 객체에 단위 데이터를 입력(생성자)하고
		  		new Emp(rs.getInt("empno"), rs.getString("ename"),
		  				 rs.getString(3),rs.getDouble(4))
		 
		 4. List<Emp>에 하나씩 반복문을 통해서 담기
		 	list.add(e);
		 */
		//증요함 while문처리 -이해를 바탕으로 코딩해야함.
		while(rs.next()) {
			Emp2 e = new Emp2(
					rs.getInt("deptno"),
					rs.getString("ename"),
					rs.getString("job"),
					rs.getDouble("sal")
					);
			list.add(e);
		}
		System.out.println("데이터 건수:"+list.size());	
	} catch (SQLException e) {
		System.out.println("DB에러:"+e.getMessage());
	} catch (Exception e) {
		System.out.println("기타에러:"+e.getMessage());
	} finally {
		DB.close(rs, stmt, con);
	}
	return list;
}
//=================================================================================
public List<Emp02> getSch02(Emp02 sch){
	List<Emp02> list= new ArrayList<Emp02>();
	try {
		con = DB.con();
		String sql = "SELECT empno,ename,sal\r\n"
				+ "FROM EMP e \r\n"
				+ "WHERE ename LIKE '%'||'"+sch.getEname()+"'||'%'\r\n"
				+ "AND sal BETWEEN "+sch.getFrsal()+" AND "+sch.getTosal();
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp02 e = new Emp02(
					rs.getInt("empno"),
					rs.getString("ename"),
					rs.getDouble("sal")
					);
			list.add(e);
		}
		
	} catch (SQLException e) {
		System.out.println("DB에러:"+e.getMessage());
	}catch (Exception e) {
		System.out.println("기타에러:"+e.getMessage());
	} finally {
		DB.close(rs, stmt, con);
	}

	return list;
}
//==============================================================================
public List<Emp03> getSch03(Emp03 sch){
	List<Emp03> list= new ArrayList<Emp03>();
	String sql = "SELECT EMPNO, ENAME , JOB , DEPTNO \r\n"
			+ "FROM EMP e \r\n"
			+ "WHERE JOB LIKE '%'||'"+sch.getJob()+"'||'%'\r\n"
			+ "OR deptno = "+sch.getDeptno();
	try {
		con = DB.con();
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			list.add(
			 new Emp03(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4)));
			
		}
	} catch (SQLException e) {
		System.out.println("DB에러:"+e.getMessage());
	}catch (Exception e) {
		System.out.println("기타에러:"+e.getMessage());
	}
	return list;
}
//select * from emp where empno=7000;

//================================================================================
public List<Emp04> getSch04(Emp04 sch){
	List<Emp04> list= new ArrayList<Emp04>();
	String sql ="SELECT DNAME , ENAME , HIREDATE , SAL \r\n"
			+ "FROM EMP e ,DEPT d \r\n"
			+ "WHERE e.DEPTNO  = d.DEPTNO\r\n"
			+ "AND d.DNAME LIKE '%'||'"+sch.getDname()+"'||'%'\r\n"
			+ "AND TO_char(HIREDATE,'q')= '"+sch.getHireq()+"'";
	try {
		con=DB.con();
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			Emp04 e = new Emp04(
					rs.getString("dname"),
					rs.getString("ename"),
					rs.getDate("hiredate"),
					rs.getDouble("sal")
					);
			list.add(e);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
}
//===========================================================
// 결과가 한개이 row일 떄는 객체를 선언
// pk로 검색할때 좋을듯
public Emp05 getEmpSch05(int empno) {
	Emp05 emp= null;
	String sql = "SELECT *\r\n"
			+ "FROM EMP e \r\n"
			+ "WHERE empno= "+empno;
	try {
		con =DB.con();
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		//단일데이터의 경우 한번만 호출 while ==>if
		while(rs.next()) {
			emp = new Emp05(
					rs.getInt("empno"),
					rs.getString("ename"),
					rs.getString("job"),
					rs.getInt("mgr"),
					rs.getDate("hiredate"),
					rs.getDouble("sal"),
					rs.getDouble("comm"),
					rs.getInt("deptno"));
					}
	} catch (SQLException e1) {
		System.out.println("DB에러:"+e1.getMessage());
	}catch (Exception e1) {
		System.out.println("기타에러:"+e1.getMessage());
	}finally {
		DB.close(rs, stmt, con);
	}
	return emp;
}

//삽입
public void insertPerson(PersonVO insert) {
	String sql = "INSERT INTO person values('"+insert.getName()+"',"+insert.getAge()+",'"+insert.getLoc()+"')";
	try {
		con=DB.con();
		//autocommit:false
		con.setAutoCommit(false);
		stmt = con.createStatement();
		System.out.println("등록건수:"+stmt.executeLargeUpdate(sql));
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
public void PersonListAllPrint() { //전체 출력
	//1) 연결객체 메모리 할당 : ex) 통신망, 특정한 상대방과 통화 연결
	//   -SQL 예외 처리 : 기타에러에 대한 try/catch
	try {
		con = DB.con();
		//2) 대화객체 생성 : ex)연결된 내용으로 대화를 시작
		String sql = "SELECT * FROM person";
		stmt = con.createStatement();
		//3) 결과객체 받기 : ex) 대화의 내용중에 결과 데이터가 있는 경우, select
		//	   -while()통해 결과객체 내용 출력
		rs = stmt.executeQuery(sql);
		while(rs.next()) { //행단위로 커서변경
			//열단위로 컬럼 접근  rs.get데이터유형("컬럼명")
			System.out.println(rs.getString(1));
			System.out.print(rs.getInt(2));
			System.out.println(rs.getString("loc"));
		}
		//4.자원해제
		DB.close(rs, stmt, con);
	} catch (SQLException e) {
		System.out.println("기타 sql처리 예외:"+e.getMessage());
	} catch(Exception e) {
		System.out.println("기타예외:"+e.getMessage());
	}
	}
//===========================================================
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			A04_DaoExp dao = new A04_DaoExp();
			/*	List<Emp2> list = dao.getSch01(10);
			for(Emp2 e:list) {
				System.out.print(e.getDeptno()+"\t");
				System.out.print(e.getEname()+"\t");
				System.out.print(e.getJob()+"\t");
				System.out.print(e.getSal()+"\n");
			}
//===========================================================
			List<Emp02> list2 = dao.getSch02(new Emp02("A",1000,2000));
			for(Emp02 e:list2) {
				System.out.print("2==>"+e.getEmpno()+"\t");
				System.out.print(e.getEname()+"\t");
				System.out.print(e.getSal()+"\n");
			}
//============================================================
			List<Emp04> list3 = dao.getSch04(new Emp04("A","1"));
			for(Emp04 e:list3) {
				System.out.print("3==>"+e.getDname()+"\t");
				System.out.print("3==>"+e.getEname()+"\t");
				System.out.print("3==>"+e.getHireq()+"\t");
				System.out.print("3==>"+e.getSal()+"\n");
			}
			
			Emp05 empOne = dao.getEmpSch05(7369);
			if(empOne!=null) {
				System.out.print(empOne.getEmpno()+"\t");
				System.out.print(empOne.getEname()+"\t");
				System.out.print(empOne.getJob()+"\n");
			}
			else {
				System.out.println("데이터 없음.");
			}*/
			/*
			PersonVO ins = new PersonVO();
			ins.setName("이정명");
			ins.setAge(28);
			ins.setLoc("강서등촌");
			dao.insertPerson(ins);
			*/
			//dao.insertPerson(new PersonVO("김길동",27,"부산"));

			
		dao.PersonListAllPrint();

	}


}
