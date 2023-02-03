package homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import a13_datebase.A04_DaoExp;
import a13_datebase.DB;
import a13_datebase.vo2.Emp03;
import a13_datebase.vo2.Emp2;

public class A101_1013 {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
//1) 분기별 또는 부서명 조건으로 사원의 이름, 부서명, 급여와 급여등급 출력
	public List<VO1013_1> VOsch01(String dname, String hireq) {
		List<VO1013_1> list= new ArrayList<VO1013_1>();
		try {
			con = DB.con();
			stmt = con.createStatement();
			String sql="SELECT ename,DNAME, sal, grade\r\n"
					+ "FROM emp e, SALGRADE s ,DEPT d \r\n"
					+ "WHERE  sal BETWEEN losal AND hisal\r\n"
					+ "AND e.DEPTNO  = d.DEPTNO\r\n"
					+ "AND to_char(hiredate,'q') ='"+hireq+"'\r\n"
					+ "OR dname = '"+dname+"'";
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(
				new VO1013_1(
						rs.getString("ename"),
						rs.getString("dname"),
						rs.getDouble("sal"),
						rs.getInt("grade")));
			}
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}
//    2) 조건없음. 연도별 사원의 수와 최대급여를 출력하세요.
	public List<VO1013_2> VOsch02() {
		List<VO1013_2> list= new ArrayList<VO1013_2>();
		try {
			con = DB.con();
			stmt = con.createStatement();
			String sql="SELECT  to_char(hiredate,'YY') yy, count(empno) empnoc, max(sal) msal\r\n"
					+ "FROM EMP e \r\n"
					+ "GROUP BY to_char(hiredate,'YY')";
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(
				new VO1013_2(
						rs.getString(1),
						rs.getInt(2),
						rs.getDouble(3)));
			}
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}
//    3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
//    조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요.
	public List<VO1013_3> VOsch03() {
		List<VO1013_3> list= new ArrayList<VO1013_3>();
		try {
			con = DB.con();
			stmt = con.createStatement();
			String sql=" SELECT ENAME, EMPNO, mod(empno, 2) div,sal, \r\n"
					+ "      decode (mod(empno, 2),0,sal,sal*0.5) bonus, \r\n"
					+ "      nvl2(NULLIF(mod(empno,2),0),sal+(sal*0.5),sal*2)  totsal\r\n"
					+ "FROM EMP e";
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(
				new VO1013_3(
						rs.getString(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getDouble(4),
						rs.getDouble(5),
						rs.getDouble(6)));
			}
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}
//4) 사원정보의 특정 근무일(YYYY/MM/DD)기준(조건)으로 근무연한/개월 수를 표현하세요
	public List<VO1013_4> VOsch04() {
		List<VO1013_4> list= new ArrayList<VO1013_4>();
		try {
			con = DB.con();
			stmt = con.createStatement();
			String sql="SELECT empno,ENAME,floor(months_between(sysdate, hiredate)/12) yyyy,\r\n"
					+ "      mod(floor(MONTHS_BETWEEN(sysdate, hiredate)),12) mmmm\r\n"
					+ "FROM emp";
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(
				new VO1013_4(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getDouble(4)));
			}
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}
//5) 사원명을 조건으로 해당 사원과 같은 입사일의 분기를 가진 사원전체 정보를 출력하세요.
	public List<VO1013_5> VOsch05(String ename) {
		List<VO1013_5> list= new ArrayList<VO1013_5>();
		try {
			con = DB.con();
			stmt = con.createStatement();
			String sql="SELECT empno,ename,sal\r\n"
					+ "FROM EMP e \r\n"
					+ "WHERE to_char(hiredate,'q') in(\r\n"
					+ "   SELECT to_char(hiredate,'q') FROM emp \r\n"
					+ "   WHERE ename  = '"+ename+"')";
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(
				new VO1013_5(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3)));
			}
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}
//6) 관리자명을 기준(조건)으로 관리자 하위에 포함된 직원정보(직원명, 부서번호, 급여) 출력하세요.
	public List<VO1013_6> VOsch06(String enameM) {
		List<VO1013_6> list= new ArrayList<VO1013_6>();
		try {
			con = DB.con();
			stmt = con.createStatement();
			String sql="SELECT m.ENAME \"관리자\",e.ENAME \"하위직원\", e.EMPNO,e.SAL  \r\n"
					+ "FROM EMP e ,emp m\r\n"
					+ "WHERE e.mgr=m.EMPNO\r\n"
					+ "AND m.ENAME = '"+enameM+"'";
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(
				new VO1013_6(
						rs.getString(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getDouble(4)));
			}
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}
//    7) 조건(월) 에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.
	public List<VO1013_7> VOsch07(String mmmm) {
		List<VO1013_7> list= new ArrayList<VO1013_7>();
		try {
			con = DB.con();
			stmt = con.createStatement();
			String sql=" SELECT ENAME,DEPTNO\r\n"
					+ "FROM EMP  \r\n"
					+ "WHERE DEPTNO IN (\r\n"
					+ "	SELECT deptno\r\n"
					+ "FROM EMP e \r\n"
					+ "WHERE to_char(hiredate,'MM')= '"+mmmm+"'\r\n"
					+ "GROUP BY DEPTNO)";
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(
				new VO1013_7(
						rs.getString(1),
						rs.getInt(2)));
			}
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}	
	public static void main(String[] args) {
//		[1단계:개념] 1. sql을 통한 데이터 처리(dao)의 핵심 단계와 핵심 소스를 기술하세요.
		/*
		 * 해당은 전역 필드로 만든다.
					Connection con; 
					기존에 Class를 통해 작성해야함 해당 클래스를 통해 DB와 연동시켜줌
					private Statement stmt;    연동한 DB와 대화를 위한 객체
					private ResultSet rs;     대화 후, 결과객체
					
			이후
					try {
							con = DB.con();
							stmt = con.createStatement();
							rs = stmt.executeQuery(sql);
					}catch(SQLException e){
					System.out.println("DB에러:"+e.getMessage());
					}
		
		*/
//		[1단계:코드] 2. 다음의 내용을 dao 처리를 하세요

//1) 분기별 또는 부서명 조건으로 사원의 이름, 부서명, 급여와 급여등급 출력
		A101_1013 dao2 = new A101_1013();
		List<VO1013_1> list = dao2.VOsch01("","2");
		for(VO1013_1 e:list) {
			System.out.print("1==>"+e.getEname()+"\t");
			System.out.print(e.getDname()+"\t");
			System.out.print(e.getSal()+"\t");
			System.out.print(e.getGrade()+"\n");
		}
//2) 조건없음. 연도별 사원의 수와 최대급여를 출력하세요.
		for(VO1013_2 e:dao2.VOsch02()) {
			System.out.print("2==>"+e.getYy()+"\t");
			System.out.print(e.getEmpnoc()+"\t");
			System.out.print(e.getMsal()+"\n");
		}
//3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
//조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요
		List<VO1013_3> list3 = dao2.VOsch03();
		for(VO1013_3 e:list3) {
			System.out.print("3==>"+e.getEname()+"\t");
			System.out.print(e.getEmpno()+"\t");
			System.out.print(e.getDiv()+"\t");
			System.out.print(e.getSal()+"\t");
			System.out.print(e.getBonus()+"\t");
			System.out.print(e.getTotsal()+"\n");
		}
//4) 사원정보의 특정 근무일(YYYY/MM/DD)기준(조건)으로 근무연한/개월 수를 표현하세요  
		List<VO1013_4> list4 = dao2.VOsch04();
		for(VO1013_4 e:list4) {
			System.out.print("4==>"+e.getEmpno()+"\t");
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getYyyy()+"\t");
			System.out.print(e.getMmmm()+"\n");
		}
// 5) 사원명을 조건으로 해당 사원과 같은 입사일의 분기를 가진 사원전체 정보를 출력하세요.
		List<VO1013_5> list5 = dao2.VOsch05("ALLEN");
		for(VO1013_5 e:list5) {
			System.out.print("5==>"+e.getEmpno()+"\t");
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getSal()+"\n");
		}
//6) 관리자명을 기준(조건)으로 관리자 하위에 포함된 직원정보(직원명, 부서번호, 급여) 출력하세요.
		List<VO1013_6> list6 = dao2.VOsch06("JONES");
		for(VO1013_6 e:list6) {
			System.out.print("6==>"+e.getEnameM()+"\t");
			System.out.print(e.getEnameE()+"\t");
			System.out.print(e.getEmpno()+"\t");
			System.out.print(e.getSal()+"\n");
		}
//7) 조건(월) 에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.
		List<VO1013_7> list7= dao2.VOsch07("12");
		for(VO1013_7 e:list7) {
			System.out.print("7==>"+e.getEname()+"\t");
			System.out.print(e.getDeptno()+"\n");
		}
//
//		[1단계:개념] 3. 액터와 유스케이스와의 관계를 기술하세요.
		/*
		1. 액터와 유스케이스
		1) 액터 
		개발할 시스템 외부에 존재, 이벤트 흐름을 시작하는 객체
		2) 유스케이스
		시스템 내부에 해당되는 단위기능, 사용자 관점에서 시스템을 모델링
		actor1 usercase
		3) 일반적인 연관 관계외에 다양한 관계가 존재할 수 있음. */
		
//		[1단계:개념] 4. 유스케이스의 종류에 대하여 기술하세요.
		/*
		 1. 연관관계(Association)는 유스케이스와 액터간의 상호작용이 있음을 표현한다.
			유스케이스와 액터를 실선으로 연결한다.
		2. 포함 관계(Include)는 하나의 유스케이스가 다른 유스케이스의 실행을 전제로 할 때 형성되는 관계이다./ include점선
			포함되는 유스케이스는 포함하는 유스케이스를 실행하기 위해 반드시 실행되어야 하는 경우에 적용한다.
		3. 확장 관계(Extend)는 확장 기능 유스케이스와 확장 대상 유스케이스 사이에 형성 되는 관계이다. /exclude점선
			확장 대상 유스케이스를 수행 할 때 특정 조건에 따라 확장 기능 유스케이스를 수행하는 경우에 적용한다.
		4.일반화 관계(Generalization)는 유사한 유스케이스 또는 액터를 
			모아 추상화한 유스케이스 또는 액터와 연결시켜 그룹을 만들어 이해도를 높이기 위한 관계이다.
		 */
//		[1단계:개념] 5. 유스케이스의 확장관계와 포함관계의 차이점을 기술하세요
		/*
		1.확장 관계
			1) 기준 유스케이스 이후의 이벤트 흐름은 확장 윳케이스의 수행 결과에 의존한다.
			2) 기준 유스케이스에 부가적으로 추가된 기능을 표현하기위해 사용된다.	
		2.포함관계
			1) 포함 유스케이스의 수행 결과에 따라서 기준 유스케이스의 이벤트 흐름이 영향을 받음
			2) 여러 유스케이스에 공통적인 기능을 표현하기위해 사용된다.
		 */
//		[1단계:실습] 6. actor로 회원/비회원/쇼핑몰 관리자, 유즈케이스로 로그인, 회원가입, 회원관리, 물건조회, 구매, 물품등록
//		               유즈케이스를 작성하세요.
	}

}
