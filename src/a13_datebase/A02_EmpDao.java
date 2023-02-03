package a13_datebase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import a13_datebase.vo.Dept;
import a13_datebase.vo.Emp;

public class A02_EmpDao {
// 1. 필드선언
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
// 2. 사원정보 조회 기능메서드(전체조회 및 출력)
	public void empListAllPrint() {
		//1) 연결객체 메모리 할당 : ex) 통신망, 특정한 상대방과 통화 연결
		//   -SQL 예외 처리 : 기타에러에 대한 try/catch
		try {
			con = DB.con();
			//2) 대화객체 생성 : ex)연결된 내용으로 대화를 시작
			String sql = "SELECT * FROM emp12";
			stmt = con.createStatement();
			//3) 결과객체 받기 : ex) 대화의 내용중에 결과 데이터가 있는 경우, select
			//	   -while()통해 결과객체 내용 출력
			rs = stmt.executeQuery(sql);
			while(rs.next()) { //행단위로 커서변경
				//열단위로 컬럼 접근  rs.get데이터유형("컬럼명")
				System.out.print(rs.getInt("empno")+":");
				System.out.println(rs.getString("ename"));
			}
			//4.자원해제
			DB.close(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println("기타 sql처리 예외:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("기타예외:"+e.getMessage());
		}
		}
	
public void empSchList2(Dept sch) {
//		1.연결 - 예외처리1
		try {
			con = DB.con();
//			2.대화
			String sql = "SELECT *\r\n"
					+ "FROM DEPT d\r\n"
					+ "WHERE DNAME LIKE '%'||'"+sch.getDname()+"'||'%'\r\n"
					+ "AND LOC LIKE'%'||'"+sch.getLoc()+"'||'%'";
			stmt = con.createStatement();
//			3.결과
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getString("dname")+"\t");
				System.out.print(rs.getString("loc")+"\n");

			}
//			4.자원해제 - 예외처리2
			DB.close(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println("DB처리예외:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("기타예외:"+e.getMessage());
		}
	}





// 객체로 검색처리
// 1.Emp만들고 - ename, job선언 후, 처리하기.
	
// 4. 사원정보 List<Emp> 검색(검색조건 처리 및 List로 리턴처리)
	// 3. 사원정보 검색조건(검색조건 조회 및 출력)
	public void empSchList2(String dname, String loc) {
		//		1.연결 - 예외처리1
				try {
					con = DB.con();
		//			2.대화
					String sql = "SELECT *\r\n"
							+ "FROM DEPT d\r\n"
							+ "WHERE DNAME LIKE '%'||''||'%'\r\n"
							+ "AND LOC LIKE'%'||''||'%'";
					stmt = con.createStatement();
		//			3.결과
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						System.out.print(rs.getString("dname")+"\t");
						System.out.print(rs.getString("loc")+"\n");
		
					}
		//			4.자원해제 - 예외처리2
					DB.close(rs, stmt, con);
				} catch (SQLException e) {
					System.out.println("DB처리예외:"+e.getMessage());
				} catch(Exception e) {
					System.out.println("기타예외:"+e.getMessage());
				}
			}

	// 3. 사원정보 검색조건(검색조건 조회 및 출력)
	
		public void empSchList(Emp sch) {
	//		1.연결 - 예외처리1
			try {
				con = DB.con();
	//			2.대화
				String sql = "SELECT * \r\n"
								+ "FROM emp12\r\n"
								+ "WHERE ename LIKE '%'||''||'%'\r\n"
								+ "and job LIKE '%'||''||'%'";
				stmt = con.createStatement();
	//			3.결과
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					System.out.print(rs.getInt("empno")+"\t");
					System.out.print(rs.getString("ename")+"\t");
					System.out.print(rs.getString("job")+"\t");
					System.out.print(rs.getInt("mgr")+"\t");
					System.out.print(rs.getDate("hiredate")+"\t");
					System.out.print(rs.getDouble("sal")+"\t");
					System.out.print(rs.getDouble("comm")+"\t");
					System.out.print(rs.getInt("deptno")+"\n");
				}
	//			4.자원해제 - 예외처리2
				DB.close(rs, stmt, con);
			} catch (SQLException e) {
			System.out.println("DB처리예외:"+e.getMessage());
			} catch(Exception e) {
				System.out.println("기타예외:"+e.getMessage());
			}
		}

	// 3. 사원정보 검색조건(검색조건 조회 및 출력)
			public void empSchList(String ename, String job) {
		//		1.연결 - 예외처리1
				try {
					con = DB.con();
		//			2.대화
					String sql = "SELECT * \r\n"
									+ "FROM emp12\r\n"
									+ "WHERE ename LIKE '%'||'"+ename+"'||'%'\r\n"
									+ "and job LIKE '%'||'"+job+"'||'%'";
					stmt = con.createStatement();
		//			3.결과
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						System.out.print(rs.getInt("empno")+"\t");
						System.out.print(rs.getString("ename")+"\t");
						System.out.print(rs.getString("job")+"\t");
						System.out.print(rs.getInt("mgr")+"\t");
						System.out.print(rs.getDate("hiredate")+"\t");
						System.out.print(rs.getDouble("sal")+"\t");
						System.out.print(rs.getDouble("comm")+"\t");
						System.out.print(rs.getInt("deptno")+"\n");
					}
		//			4.자원해제 - 예외처리2
					DB.close(rs, stmt, con);
				} catch (SQLException e) {
				System.out.println("DB처리예외:"+e.getMessage());
				} catch(Exception e) {
					System.out.println("기타예외:"+e.getMessage());
				}
			}
// 사원정보 List<Emp>검색
//	1)sql ==>VO

//	2)메서드 선언 리턴유형, 매개변수, 초기 리턴할 객체선언
	public List<Emp> getEmpSch(Emp sch){
		List<Emp> list = new ArrayList<Emp>();
		//1.DB연결
		try {
			con = DB.con();
		//2.대화
			String sql="SELECT * \r\n"
					+ "FROM emp12\r\n"
					+ "WHERE ename LIKE '%'||'"+sch.getEname()+"'||'%'\r\n"
					+ "AND job LIKE '%'||'"+sch.getJob()+"'||'%'\r\n"
					+ "AND SAL BETWEEN "+sch.getFrsal()+" AND "+sch.getTosal();
			//ORA-00920:invalid relational operator는
			// 위sql 복사한 구문에 어딘가 에러가있음.띄워쓰기 등.
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Emp e = new Emp(
						rs.getInt("empno"),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getDate(5),
						rs.getDouble(6),
						rs.getDouble(7),
						rs.getInt(8)
						);
				list.add(e);
			}
			System.out.println("데이터 건수:"+list.size());
			DB.close(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println("DB관련에러:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}
		
		return list;
	}
	//데이터 생성(삽입)
public void insertEmp(Emp insert) {
	String sql = "insert into emp12 values(emp12_seq.nextval,'"+insert.getEname()+"','"+insert.getJob()+"',"+insert.getMgr()+",\r\n"
			+ " to_date('"+insert.getHiredates()+"','yyyy/mm/dd'), "+insert.getSal()+","+insert.getComm()+","+insert.getDeptno()+")";
	try {
		con=DB.con();
		//autocommit:false
		con.setAutoCommit(false);
		stmt = con.createStatement();
		int cnt =stmt.executeUpdate(sql);
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
/* main()
 Emp upt = new Emp();
 upt.setEname("오길동");
 upt.setJob("대리"); 
 upt.setSal(4200);
 upt.setEmpno(7369);
 dao.updateEmp(upt);
 
 dao.deleteEmp(7902);
 
 */
public void updateEmp(Emp upt) { // 수정
	String sql = "UPDATE EMP100 \r\n"
			+ "	SET ename='"+upt.getEname()+"',\r\n"
			+ "		job = '"+upt.getJob()+"',\r\n"
			+ "		sal = "+upt.getSal()+"\r\n"
			+ "	WHERE empno ="+upt.getEmpno();
	try {
		con=DB.con();
		//autocommit:false
		con.setAutoCommit(false);
		stmt = con.createStatement();
		int cnt =stmt.executeUpdate(sql);
		System.out.println("수정 데이터:"+cnt);
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
public void deleteEmp(int empno) { //삭제
	String sql = "DELETE emp100\r\n"
			+ "WHERE empno = "+ empno;
	System.out.println("삭제sql");
	System.out.println(sql);
	try {
		con=DB.con();
		//autocommit:false
		con.setAutoCommit(false);
		stmt = con.createStatement();
		int cnt =stmt.executeUpdate(sql);
		System.out.println("삭제데이터:"+cnt);
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
		A02_EmpDao dao= new A02_EmpDao();
		Emp ins = new Emp();
		ins.setComm(100);
		ins.setDeptno(10);
		ins.setEname("등록맨");
		ins.setHiredates("2022/10/14");
		ins.setJob("사원");
		ins.setSal(3700);
		ins.setMgr(7900);
		dao.insertEmp(ins);
		//검색
		List<Emp> empList = dao.getEmpSch(new Emp("A","A",1000,5000));
			for(Emp e:empList) {
					System.out.print(e.getEmpno()+"\t");
					System.out.print(e.getEname()+"\t");
					System.out.print(e.getJob()+"\t");
					System.out.print(e.getSal()+"\n");
		}
//		//dao.empSchList("A", "MAN");
//		//dao.empSchList(new Emp("","MAN"));
//		//dao.empSchList2(new Dept("", ""));
//		Scanner sc = new Scanner(System.in);
//		System.out.println("검색할 사원명:");
//		String ename= sc.next();
//		System.out.println("검색할 직책명:");
//		String job= sc.next();
//		System.out.println("검색할 급여시작범위:");
//		double frsal= sc.nextDouble();
//		System.out.println("검색할 급여종료범위:");
//		double tosal= sc.nextDouble();
//		System.out.println("#검색내용#");
//		System.out.println("사원명:"+ename);
//		System.out.println("직책명:"+job);
//		System.out.println("급여범위:"+frsal+"~"+tosal);
//		
//		List<Emp> empList = dao.getEmpSch(new Emp(ename,job,frsal,tosal));
//		for(Emp e:empList) {
//			System.out.print(e.getEmpno()+"\t");
//			System.out.print(e.getEname()+"\t");
//			System.out.print(e.getJob()+"\t");
//			System.out.print(e.getSal()+"\n");
//			
//		}
			 Emp upt = new Emp();
			 upt.setEname("오길동");
			 upt.setJob("대리"); 
			 upt.setSal(4200);
			 upt.setEmpno(7369);
			 dao.updateEmp(upt);
			 
			 dao.deleteEmp(7902);
	}

}
