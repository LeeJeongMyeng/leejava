package homework.review;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
// import java.sql.*  해당 패키지 하위클래스 모두 import

import a13_datebase.DB;
import homework.VO1013_3;
import homework.VO1013_5;
import homework.VO1013_7;

public class A00_1014 {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
// 1) 분기별 또는 부서명 조건으로 사원의 이름, 부서명, 급여와 급여등급 출력
//2) 조건없음. 연도별 사원의 수와 최대급여를 출력하세요. <정답>
//3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
//   조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여를 출력하세요.
	public List<VO1013_3_R> VOsch03_R(String div) {
		if(div!=null) {
			if(div.equals("") || div.equals("전체")) {
				div ="0,1";
			}
			if(div.equals("짝")) div="0";
			if(div.equals("홀")) div="1";
			
		}else {
			div="0,1";
		}

		List<VO1013_3_R> list= new ArrayList<VO1013_3_R>();
		try {
			con = DB.con();
			stmt = con.createStatement();
			String sql="SELECT e.*, DECODE(div,0,'짝','홀') div2,\r\n"
					+ "		decode(div,0,'100%','50%') bonus_per,\r\n"
					+ "		round(decode(div,0,1,0.5)*sal) bonus,\r\n"
					+ "		sal+round(decode(div,0,1,0.5)*sal) totpay\r\n"
					+ "FROM (\r\n"
					+ "SELECT empno, MOD(empno,2) div,\r\n"
					+ "		ename, sal\r\n"
					+ "FROM emp) e\r\n"
					+ "WHERE div in("+div+") ";
			System.out.println(sql);
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(
				new VO1013_3_R(
						rs.getString("ename"),
						rs.getInt("empno"),
						rs.getString("div2"),
						rs.getDouble("sal"),
						rs.getString("bonus_per"),
						rs.getInt("bonus"),
						rs.getInt("totpay")
						));
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
// 4) 사원정보의 특정 근무일(YYYY/MM/DD)기준(조건)으로 근무연한/개월 수를 표현하세요   

	public List<Exp04> VOsch04_R(String std) {
		List<Exp04> list= new ArrayList<Exp04>();
		if(std==null || std.equals("")) std="2022/10/14";
		try {
			con = DB.con();
			stmt = con.createStatement();
			String sql=" SELECT ename,\r\n"
					+ "	floor(mm/12)||'년'||floor(MOD(mm,12))||'개월' workmonth\r\n"
					+ "from(\r\n"
					+ "SELECT ename, MONTHS_BETWEEN(to_date('"+std+"','yyyy/mm/dd'),hiredate) mm\r\n"
					+ "FROM emp\r\n"
					+ ")";
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(
				new Exp04(
						rs.getString("ename"),
						rs.getString("workmonth")
						));
			}
			System.out.println("#기준일:"+std);
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}	
//                5) 사원명을 조건으로 해당 사원과 같은 입사일의 분기를 가진 사원전체 정보를 출력하세요.
//                6) 관리자명을 기준(조건)으로 관리자 하위에 포함된 직원정보(직원명, 부서번호, 급여) 출력하세요.
//                7) 조건(월) 에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.

	public static void main(String[] args) {
		A00_1014 dao = new A00_1014();
// 2022-10-13
//[1단계:개념] 1. sql을 통한 데이터 처리(dao)의 핵심 단계와 핵심 소스를 기술하세요.
//[1단계:코드] 2. 다음의 내용을 dao 처리를 하세요
//                1) 분기별 또는 부서명 조건으로 사원의 이름, 부서명, 급여와 급여등급 출력
//                2) 조건없음. 연도별 사원의 수와 최대급여를 출력하세요.
//                3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
//                    조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요

			for(VO1013_3_R e:dao.VOsch03_R("0,1")) { // 짝,홀,전체,null
					System.out.print(e.getEname()+"\t");
					System.out.print(e.getBonus_per()+"\t");
					System.out.print(e.getSal()+"\t");
					System.out.print(e.getTotpay()+"\n");
				}
			for(Exp04 e:dao.VOsch04_R("2001/01/01")) { 
				System.out.print(e.getEname()+"\t");
				System.out.print(e.getWorkmonth()+"\n");

			}
//                4) 사원정보의 특정 근무일(YYYY/MM/DD)기준(조건)으로 근무연한/개월 수를 표현하세요    
//                5) 사원명을 조건으로 해당 사원과 같은 입사일의 분기를 가진 사원전체 정보를 출력하세요.
//                6) 관리자명을 기준(조건)으로 관리자 하위에 포함된 직원정보(직원명, 부서번호, 급여) 출력하세요.
//                7) 조건(월) 에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.
//
//[1단계:개념] 3. 액터와 유스케이스와의 관계를 기술하세요.
//[1단계:개념] 4. 유스케이스의 종류에 대하여 기술하세요.
//[1단계:개념] 5. 유스케이스의 확장관계와 포함관계의 차이점을 기술하세요
//[1단계:실습] 6. actor로 회원/비회원/쇼핑몰 관리자, 유즈케이스로 로그인, 회원가입, 회원관리, 물건조회, 구매, 물품등록
//               유즈케이스를 작성하세요.
 

	}

}
