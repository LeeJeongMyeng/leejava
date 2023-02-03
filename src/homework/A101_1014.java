package homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import a13_datebase.DB;
import a13_datebase.vo.Emp;

public class A101_1014 {
	private  Connection con;
	private Statement stmt;
	private ResultSet rs;
	static Scanner scan = new Scanner(System.in);
//	[1단계:확인] 2. 등급테이블의  salgrade1000 테이블을 복사 만들고, 해당 정보를 메서드를 만드세요.
	public void salgradeListAllPrint() { //전체 출력
		//1) 연결객체 메모리 할당 : ex) 통신망, 특정한 상대방과 통화 연결
		//   -SQL 예외 처리 : 기타에러에 대한 try/catch
		try {
			con = DB.con();
			//2) 대화객체 생성 : ex)연결된 내용으로 대화를 시작
			String sql = "SELECT * FROM SALGRADE1000";
			stmt = con.createStatement();
			//3) 결과객체 받기 : ex) 대화의 내용중에 결과 데이터가 있는 경우, select
			//	   -while()통해 결과객체 내용 출력
			rs = stmt.executeQuery(sql);
			while(rs.next()) { //행단위로 커서변경
				//열단위로 컬럼 접근  rs.get데이터유형("컬럼명")
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getInt(2)+"\t");
				System.out.print(rs.getInt(3)+"\n");
			}
			//4.자원해제
			DB.close(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println("기타 sql처리 예외:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("기타예외:"+e.getMessage());
		}
		}
//	[1단계:확인] 3. 사원명과 부서명의 통합테이블 EmpDept100 테이블을 복사 만들고, 해당 정보를 메서드를 만들고 데이터를 입력하세요.
	public void insertEmpdept(Empdept100 insert) {
		String sql = "INSERT INTO EMPDEPT100 VALUES ('"+insert.getEname()+"','"+insert.getDname()+"')";
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
	

//[1단계:확인] 4. member100(아이디, 패스워드, 이름, 권한, 포인트, 등록일) 만들고, 데이터를 등록 후, 조회하는 메서드를 선언 및 출력하세요.	
	public void insertMember(Member100VO insert) {
		String sql = "INSERT INTO member100 values(\r\n"
				+ "'"+insert.getId()+"',\r\n"
				+ "'"+insert.getPass()+"',\r\n"
				+ "'"+insert.getName()+"',\r\n"
				+ "'"+insert.getDiv()+"',\r\n"
				+ insert.getPoint()+",\r\n"
				+ "to_date('"+insert.getDates()+"','yyyy/mm/dd'))";
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
	
	public void MemberListAllPrint() {
		//1) 연결객체 메모리 할당 : ex) 통신망, 특정한 상대방과 통화 연결
		//   -SQL 예외 처리 : 기타에러에 대한 try/catch
		try {
			con = DB.con();
			//2) 대화객체 생성 : ex)연결된 내용으로 대화를 시작
			String sql = "SELECT * FROM MEMBER100";
			stmt = con.createStatement();
			//3) 결과객체 받기 : ex) 대화의 내용중에 결과 데이터가 있는 경우, select
			//	   -while()통해 결과객체 내용 출력
			rs = stmt.executeQuery(sql);
			while(rs.next()) { //행단위로 커서변경
				//열단위로 컬럼 접근  rs.get데이터유형("컬럼명")
				System.out.print(rs.getString("id")+"\t");
				System.out.print(rs.getString("pass")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("div")+"\t");
				System.out.print(rs.getInt("point")+"\t");
				System.out.print(rs.getDate("hiredate")+"\n");
			}
			//4.자원해제
			DB.close(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println("기타 sql처리 예외:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("기타예외:"+e.getMessage());
		}
		}
	
	//[1단계:확인] 5. 위 member100테이블을 기준으로 아이디, 패스워드를 입력(Scanner)받아 select문으로 
//	데이터를 조회하여 로그인 성공 여부를 출력하는 Dao기능메서드를 만드세요.
	public List<Member100VO> getMemberSch(Member100VO sch){
		List<Member100VO> list = new ArrayList<Member100VO>();
		//1.DB연결
		try {
			con = DB.con();
		//2.대화
			
			String sql="SELECT * FROM member100\r\n"
					+ "WHERE  id = '"+sch.getId()+"'\r\n" //where id like '%'||''||'%'
					+ "AND pass = '"+sch.getPass()+"'";    // and pass like '%'||''||'%'
			//ORA-00920:invalid relational operator는
			// 위sql 복사한 구문에 어딘가 에러가있음.띄워쓰기 등.
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
					Member100VO e = new Member100VO(
							rs.getString("id"),
							rs.getString("pass"),
							rs.getString("name"),
							rs.getString("div"),
							rs.getInt("Point"),
							rs.getDate("hiredate")
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
public boolean login (Member100VO sch) {
			boolean isLogin=false;
		//1.DB연결
		try {
			con = DB.con();
		//2.대화
			
			String sql="SELECT * FROM member100\r\n"
					+ "WHERE  id = '"+sch.getId()+"'\r\n" //where id like '%'||''||'%'
					+ "AND pass = '"+sch.getPass()+"'";    // and pass like '%'||''||'%'
			//System.out.println("조회:");
			System.out.println(sql);
			//ORA-00920:invalid relational operator는
			// 위sql 복사한 구문에 어딘가 에러가있음.띄워쓰기 등.
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
				isLogin=rs.next();
			
		} catch (SQLException e) {
			System.out.println("DB관련에러:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return isLogin;
	}
	
	public static void main(String[] args) {
		A101_1014 dao = new A101_1014();
		
/*
[1단계:개념] 1. 데이터 등록/수정/삭제시, 기존 select와 차이가 나는 추가 코드를 기술하고 설명하세요.
	기존 select
		SELECT * 
		FROM EMP01
		WHERE ename LIKE '%'||'A'||'%'
		and job LIKE '%'||'ER'||'%';
	
	DB연동 등록 수정 삭제시
		SELECT * 
		FROM EMP01
		WHERE ename LIKE '%'||'"+ins.get컬럼명+"'||'%'
		and job LIKE '%'||'"+ins.get컬럼명+"'||'%';         */
		
		
		
//[1단계:확인] 2. 등급테이블의  salgrade1000 테이블을 복사 만들고, 해당 정보를 메서드를 만드세요.
		//dao.salgradeListAllPrint();
//[1단계:확인] 3. 사원명과 부서명의 통합테이블 EmpDept100 테이블을 복사 만들고, 해당 정보를 메서드를 만들고 데이터를 입력하세요.
		Empdept100 ins = new Empdept100();
		ins.setEname("김길동");
		ins.setDname("회꼐");
		dao.insertEmpdept(ins);
		
//[1단계:확인] 4. member100(아이디, 패스워드, 이름, 권한, 포인트, 등록일) 만들고, 데이터를 등록 후, 조회하는 메서드를 선언 및 출력하세요.
		dao.insertMember(new Member100VO("aaaa","1111","이정명","관리자",100,"2022/01/01"));
		dao.MemberListAllPrint();
//[1단계:확인] 5. 위 member100테이블을 기준으로 아이디, 패스워드를 입력(Scanner)받아 select문으로 
//				데이터를 조회하여 로그인 성공 여부를 출력하는 Dao기능메서드를 만드세요.
		System.out.print("id입력:");	
		String sname = scan.next();
		System.out.print("pass입력:");	
		String spass = scan.next();
			
		//1번 방법
		List<Member100VO> memList = dao.getMemberSch(new Member100VO(sname,spass));
		for(Member100VO e:memList) {
				System.out.println("로그인 성공");
				System.out.print(e.getName()+"\t");
				System.out.print(e.getPoint()+"\t");
				System.out.print(e.getDiv()+"\t");
				System.out.print(e.getHiredate()+"\n");
	}
		// 2번 방법
		for(Member100VO e2:dao.getMemberSch(new Member100VO(sname,spass))) {
			System.out.println("로그인 성공");
			System.out.print(e2.getName()+"\t");
			System.out.print(e2.getPoint()+"\t");
			System.out.print(e2.getDiv()+"\t");
			System.out.print(e2.getHiredate()+"\n");
		}
		
		Member100VO mLogin = new Member100VO();
		
		
		
		/*
		if(dao.login(mLogin)) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}*/
		boolean isFirst =true;
		do {
			if(!isFirst) {
				System.out.println("로그인 실패 다시입력!");
			}
			System.out.print("아이디입력:");
			String sid = scan.next();
			System.out.print("비번입력:");
			String spass1 = scan.next();
			mLogin.setId(sid);
			mLogin.setPass(spass1);
			isFirst=false;
		}while(!dao.login(mLogin)); //false 일때 계속 반복
		System.out.println("로그인성공!");
	}
		

 

	}


