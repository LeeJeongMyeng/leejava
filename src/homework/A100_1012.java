package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import a13_datebase.A02_EmpDao;
import a13_datebase.DB;
import a13_datebase.vo.Emp;

public class A100_1012 {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	public void empListPrint() {
		try {
			con=DB.con();
			stmt=con.createStatement();
			String sql = "SELECT DEPTNO ,ENAME ,SAL \r\n"
					+ "           FROM EMP e \r\n"
					+ "           WHERE (DEPTNO,SAL) IN(\r\n"
					+ "           SELECT DEPTNO, max(sal)\r\n"
					+ "           FROM EMP GROUP BY DEPTNO)";
			rs = stmt.executeQuery(sql);
			while(rs.next()) { //행단위로 커서변경
				//열단위로 컬럼 접근  rs.get데이터유형("컬럼명")
				System.out.print(rs.getInt("deptno")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getInt("sal")+"\n");
			}
			DB.close(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println("DB예외:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타예외:"+e.getMessage());
		}
	}
	
//7번문제==========================================================================
	public void salgradeListPrint(int grade) {
		try {
			con = DB.con();
			stmt = con.createStatement();
			String sql ="SELECT * FROM SALGRADE s\r\n"
					+ "WHERE grade="+grade;

			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getInt("grade")+"\t");
				System.out.print(rs.getInt("losal")+"\t");
				System.out.print(rs.getInt("hisal")+"\t");
			}
			DB.close(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println("DB예외:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("기타예외:"+e.getMessage());
		}
	
	}
//====8번문제 ==========================================================
	public List<VO1012> getsalSch(VO1012 sch){
		List<VO1012> sallist = new ArrayList<VO1012>();
		try {
			con = DB.con();
			String sql="select deptno, empno, ename, job, sal \r\n"
					+ "from emp01 \r\n"
					+ "where sal between "+sch.getFrsal()+" and "+sch.getTosal();
			stmt = con.createStatement();
			rs =stmt.executeQuery(sql);
			while(rs.next()) {
				VO1012 vo= new VO1012(rs.getInt(1),
									  rs.getInt(2),
									  rs.getString(3),
									  rs.getString(4),
									  rs.getDouble(5));
				sallist.add(vo);
			}
			DB.close(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}
		return sallist;
	}
	//====================================================================================
	public static void main(String[] args) {
		
		
//		[1단계:개념] 1. 데이터베이스의 연결 공통 객체 생성에 필요한 객체들과 정보를 소스를 통해 설명하세요.
		//연결처리 객체
		//DB.con();
		/*
		public static Connection con() throws SQLException {
			Connection con = null; //초기화

			try {
			//메모리에 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("드라이버 로딩성공");
			} catch (ClassNotFoundException e) {
				// 컴파일에러 예외처리
				System.out.println("드라이버 에러:"+e.getMessage());
			}
		//연결 정보처리 DB연동에 필요한 PATH및 아이디,패스워드 입력 필요
			String info = "jdbc:oracle:thin:@localhost:1521:xe";
			con= DriverManager.getConnection(info,"scott","tiger");
			System.out.println("연결성공");
			return con;
		}*/
		
		
	
//		[1단계:개념] 2. select문을 통해서 데이터를 가져와서 출력할려고 한다. 객체들간의 연관관계를 기술하세요.
			/*
		드라이버 메모리로딩 ==> 특정서버에 접속(DriverManager) ==>
		연결객체Connection ==> 서버와 대화(sql) Statement 
		선택적처리  ==>  등록/수정/삭제의 경우 ==> 서버에 데이터를 처리 ==> (commit/rollback)
		조회(select) ==> 서버에서 sql결과를 ResultSet객체를 통해서 전달한다.
			 */
		
		
//		[1단계:코드] 3. 부서별 최고 급여자를 sql를 만들고 이것을 출력하는 기능메서드를 만들고 출력처리하세요.
		/*
		 --부서별 최고 급여자
SELECT DEPTNO ,ENAME ,SAL 
           FROM EMP e 
           WHERE (DEPTNO,SAL) IN(
           SELECT DEPTNO, max(sal)
           FROM EMP GROUP BY DEPTNO);
		 */
		A100_1012 exp= new A100_1012();
		exp.empListPrint();
//		[1단계:개념] 4. ResultSet 객체의 기능메서드를 기능별로 분류하여 기술하세요.
		/* char/varchar2() ==> String
		number() ==> int/double
		date ==> Date
      ex) getXXXX("컬럼명")
		rs.getInt("empno")
		rs.getString("ename")
		*/
//		[1단계:개념] 5. Dao의 자원해제 순서와 방법을 기술하세요
		/*
		public static void close(ResultSet rs,Statement stmt,Connection con) {
			try {
			//'분해역순'과 같은 느낌으로 연동과 반대 순서로 close()명령문을 시작 
				rs.close();
				stmt.close();
				con.close();
				//이후 close()마다 trycatch문으로 예외처리 해준다.
			} catch (SQLException e) {
				System.out.println("연결종료 예외발생:"+e.getMessage());
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e1) {
						System.out.println("ResultSet:"+e.getMessage());
					}
				}
				if(stmt!=null) {
					try {
						stmt.close();
					} catch (SQLException e1) {
						System.out.println("Statement:"+e.getMessage());
					}
				}
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e1) {
						System.out.println("Connection:"+e.getMessage());
					}
				}
			}
			
		}*/
//		[1단계:순서] 6. 검색조건에 대한 dao 처리를 위하여 처리되는 순서를 기술하세요.
					/*
					 0. 검색조건에 대한 SQL쿼리 작성
					 1.DB연결 및 예외 처리
					 2.결과 처리를 위한 rs = stmt.executeQuery(변수명);의
					   변수명의 내용을 넣기위해
					   String 변수명 ="검색sql쿼리문"; 삽입
					 3. while()를 통해 행단위 결과내용 출력
					 */
		
//		[1단계:코드] 7. salgrade테이블을 등급별, 급여별 데이터를 검색할려고 한다. Dao에 추가하여 처리하세요.
				exp.salgradeListPrint(1);
			
//		[1단계:코드] 8. select deptno, empno, ename, job, sal 
//		         from emp01 where sal between @@@ and @@#
//		      를 처리할려고 한다. VO를 만들고 ArrayList<VO>로 리턴한 결과를 처리하세요.
				A100_1012 dao2= new A100_1012();
				Scanner sc = new Scanner(System.in);
				System.out.print("시작 금액:");
				int frsal= sc.nextInt();
				System.out.print("종료 금액:");
				int tosal= sc.nextInt();
				
				List<VO1012> salList = dao2.getsalSch(new VO1012(frsal,tosal));
				for(VO1012 v:salList) {
					System.out.print(v.getDeptno()+"\t");
					System.out.print(v.getEmpno()+"\t");
					System.out.print(v.getJob()+"\t");
					System.out.print(v.getSal()+"\n");

					
				}
//		== 평가대비(자바) 객관식 문제 ==
//		1. 자바에서 데이터베이스 연결에 필요한 객체가 아닌 것은? 4번_sql은 없다.
//		1) Connection  2) Statement
//		3) Result      4) Sql 
//		정답:4
//		2. 데이터베이스 처리시 처리할 예외 ? 3번
//		1) NullPointerException  2) NumberFormatException
//		3) SQLException      4) 
//		정답:3
	}

}
