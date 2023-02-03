package a13_datebase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import a13_datebase.vo.Dept;
import a13_datebase.vo.Emp;
import a13_datebase.vo.ExpVO;

public class A06_PreparedDao {
//전역 변수 선언
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	//조회처리
	public List<Dept> getDeptList(Dept sch){
		List<Dept> dlist = new ArrayList<Dept>();
		String sql = "SELECT * FROM DEPT100\r\n"
				+ "WHERE DNAME  LIKE '%'||?||'%'\r\n"
				+ "AND LOC LIKE '%'||?||'%'";
		
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			//위 sql의 ?에 해당하는 문자열을 mapping해서 데이터를 전달
			//1. 위 형태로 ?로 설정하는 해당 데이터 형태만 입력이 되지,
			// sql injection이 처리되지 않는다.
			// 2. ?로 같은 유형을 sql을 먼저 서버에 전달되기에 한번 컴파일 이후로는
			// 빠르게 수행될 수 있다.
			//pstmt.setString(1번부터 ? 에 해당하는 순서,데이터);
			pstmt.setString(1, sch.getDname());
			pstmt.setString(2, sch.getLoc());
			
			rs= pstmt.executeQuery(); //sql넣지않기 주의!
			while(rs.next()) {
				dlist.add(new Dept(rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc")));
			}
			System.out.println("데이터 건수:"+dlist.size());
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
return dlist;
	}
public void insertDept(Dept insert) {
		String sql = "INSERT INTO dept100 values(?,?,?)";
		try {
			con=DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, insert.getDeptno());
			pstmt.setString(2, insert.getDname());
			pstmt.setString(3, insert.getLoc());
			
			System.out.println("등록건수"+pstmt.executeQuery());
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("DB에러"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("롤백에러:"+e.getMessage());
			}
		}catch (Exception e) {
			System.out.println("기타에러"+e.getMessage());
		} finally {DB.close(rs, pstmt, con);}
		
	}
	
public void updateDept(int deptno, Dept update) {
	String sql = "UPDATE DEPT100\r\n"
			+ "SET deptno=?,\r\n"
			+ "	dname =?,\r\n"
			+ "	loc = ?\r\n"
			+ "WHERE deptno = ?";
	try {
		con=DB.con();
		con.setAutoCommit(false);
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, update.getDeptno());
		pstmt.setString(2, update.getDname());
		pstmt.setString(3, update.getLoc());
		pstmt.setInt(4, deptno);
		
		System.out.println("등록건수"+pstmt.executeQuery());
		con.commit();
		
	} catch (SQLException e) {
		System.out.println("DB에러"+e.getMessage());
		try {
			con.rollback();
		} catch (SQLException e1) {
			System.out.println("롤백에러:"+e.getMessage());
		}
	}catch (Exception e) {
		System.out.println("기타에러"+e.getMessage());
	} finally {DB.close(rs, pstmt, con);}
	
}

public void deleteDept(int deptno) {
	String sql = "DELETE FROM DEPT100\r\n"
			+ "WHERE deptno = ?";
	try {
		con=DB.con();
		con.setAutoCommit(false);
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, deptno);
		
		System.out.println("삭제건수"+pstmt.executeQuery());
		con.commit();
		
	} catch (SQLException e) {
		System.out.println("DB에러"+e.getMessage());
		try {
			con.rollback();
		} catch (SQLException e1) {
			System.out.println("롤백에러:"+e.getMessage());
		}
	}catch (Exception e) {
		System.out.println("기타에러"+e.getMessage());
	} finally {DB.close(rs, pstmt, con);}
	
}
	//조회처리
public List<ExpVO> getExpVOList(ExpVO sch){
    List<ExpVO> dlist = new ArrayList<ExpVO>();
    String sql = "SELECT empno, ename, qm.qu||'/4' qu, sal \r\n"
          + "FROM emp e, (\r\n"
          + "   SELECT to_char(hiredate, 'Q') qu, max(sal) msal\r\n"
          + "   FROM emp \r\n"
          + "   GROUP BY to_char(hiredate,'Q')\r\n"
          + ") qm\r\n"
          + "WHERE to_char(e.hiredate,'Q') = qu\r\n"
          + "AND sal = msal\r\n"
          + "AND sal BETWEEN ? AND ?";
    
    /*
     1) 조건문에 따른 내용은 sql조건도 처리해야하고
     	select *
     	from emp
     	where 1=1
     	if(sch.getEname()!=null){
     		and ename like '%'||?||'%'
     	}
     	if(sch.getEname()!=null){
     		and job like '%'||?||'%'
     	}
     	if(sch.getEname()!=null) pstmt.setString(++cnt,..)
     	if(sch.getJob()!=null) pstmt.setString(++cnt,..)
     2) pstmt부분도 조건처리해야한다.
     3) 특히, 동적 sql이 복잡해질떄는 순서 index부분도 변수를 선언해서 처리해야한다.
     	int cnt=0;
     	if(sch.getXXX()!=null) pstmt.setString(++cnt,..)
     	if(sch.getXXX()!=null) pstmt.setString(++cnt,..)
     	if(sch.getXXX()!=null) pstmt.setString(++cnt,..)
     */
    if(sch.getQu()!=null)
       sql   += "AND qu =?\r\n";
          
    System.out.println(sql);
    try {
       con = DB.con();
       pstmt = con.prepareStatement(sql); //중요 앞에 먼저 sql넘겨주기
       // 위 sql의 ?에 해당하는 문자열을 mapping해서 데이터를 전달 
       //1. 위 형태로 ?로 설정하는 해당 데이터 형태만 입력이 되지,
       // sql injection이 처리되지 않는다. 
       //2. ?로 같은 유형을 sql을 먼저 서버에 전달되기에 한번 컴파일된 이후로는
       //    빠르게 수행될 수 있다. 
       //pstmt.setString(1번부터 ?에 해당하는 순서, 데이터);
       pstmt.setDouble(1, sch.getFrSal());//
       pstmt.setDouble(2, sch.getToSal());
       if(sch.getQu()!=null) {
          pstmt.setString(3, sch.getQu());
          
       }
       rs = pstmt.executeQuery(); //sql을 넣지 않는다. 
       while(rs.next()) {
          dlist.add(new ExpVO(
                rs.getInt("empno"),
                rs.getString("ename"),
                rs.getString("qu"),
                rs.getDouble("sal")
                )
                );
       }
       System.out.println("데이터 건수:"+dlist.size());
       
    } catch (SQLException e) {
       System.out.println("DB에러:"+e.getMessage());
    } catch(Exception e) {
       System.out.println("일반에러:"+e.getMessage());
    }finally {
       DB.close(rs, pstmt, con);
    }
    
    return dlist;
 }

	public static void main(String[] args) {
		A06_PreparedDao dao = new A06_PreparedDao();
//		Dept ins = new Dept();
//		ins.setDeptno(30);
//		ins.setDname("회계");
//		ins.setLoc("3층");
//		dao.insertDept(ins);
//		
//		dao.insertDept(new Dept(11,"총무","부산"));
		for(Dept d: dao.getDeptList(new Dept("",""))) {
			System.out.print(d.getDeptno()+"\t");
			System.out.print(d.getDname()+"\t");
			System.out.print(d.getLoc()+"\n");
		}
//				
//		dao.updateDept(10, new Dept(55,"인사","부산"));
//		for(Dept d: dao.getDeptList(new Dept("",""))) {
//			System.out.print(d.getDeptno()+"\t");
//			System.out.print(d.getDname()+"\t");
//			System.out.print(d.getLoc()+"\n");
//		}
	//	dao.deleteDept(55);
		for(ExpVO eq:dao.getExpVOList(new ExpVO(null,1000,5000))) {
			System.out.print(eq.getEmpno()+"\t");
			System.out.print(eq.getEname()+"\t");
			System.out.print(eq.getQu()+"\t");
			System.out.print(eq.getSal()+"\n");
		}
		
		}
		
	}


