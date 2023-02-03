
--[1단계:코드] 1. 직책별 최저급여의 사원정보(사원명, 직책명, 급여)를 inline view(sql을 통해 만든 가상테이블)를 통해서 출력하세요. 

SELECT job,min(sal) msal
FROM EMP11 e 
GROUP BY job;

SELECT *
FROM emp e,(SELECT job,min(sal) msal
			FROM EMP11 e 
			GROUP BY job) me
WHERE e.job=me.job
AND e.SAL = me.msal;
--inline view : 테이블선언대신 sql을 통해서 가상의 테이블을 만들어서
-- 				기존 테이블 또는 다른  inline view를 만들어 조인을하여 데이터를 처리하는 목적으로 사용된다.

--[1단계:개념] 2. 수정의 기본형식과 SUBQUERY(단일열/다중열) 형식을 예제를 통하여 기술하세요.
/*  --a13.subquery 참조.
 update 테이블명
    set 컬럼1 = 변경할 데이터,
    	컬럼2 = 변경할데이터
    	...
    where 조건문
 */
--단일열 수정처리
/*
 update 테이블명
 set 컬럼명 =(select 컬럼 from 테이블명)
 where 조건
 ex)subquery를 통해 얻어진 데이터를 기준으로 해당 컬럼의 값을 변경
 */
SELECT * FROM emp10;
UPDATE EMP10 
SET empno=1000,
	JOB ='사원'
WHERE empno=7369;


UPDATE EMP11 
SET sal=(SELECT max(SAL)
			FROM emp)
WHERE empno=7369;
-- 해당 데이터는 항상 입력/수정/삭제에 의해 바뀌고있는 상황에서 통계치를 처리할려면
-- subquery가 필요로하다.

--다중열 수정처리
/*
 update 테이블명
 set(컬럼1,컬럼2)in(select 컬럼1,컬럼2 from 테이블명)
 where 조건
 ex) subquery의 두개이상 컬럼의 내용을 기준으로 검색된 내용으로 변경처리
 */
-- ex) 특정 부서의 평균급여를 해당 부서와 급여로 변경처리
--	직책이 SALESMAN의 부서와 급여를 10번 부서와 평균 급여로 변경.
SELECT DEPTNO, ROUND(AVG(SAL)) 
FROM EMP11
WHERE DEPTNO = 10
GROUP BY DEPTNO;

-- update 구문의 쿼리 작성

UPDATE EMP11 
SET (DEPTNO,SAL) = (
SELECT DEPTNO, ROUND(AVG(SAL)) 
FROM EMP11
WHERE DEPTNO = 10
GROUP BY DEPTNO)
WHERE JOB='SALESMAN';



--다중열(삭제처리)
DELETE 
FROM emp11
WHERE  (deptno,hiredate) IN (
SELECT deptno,max(HIREDATE)
FROM emp11
GROUP BY deptno);




--[1단계:코드] 3. EMP10의 3/4분기 최고급여를 7521 사원의 급여로 수정하세요.
UPDATE EMP11
SET SAL = (
SELECT MAX(SAL)
FROM EMP11 e 
WHERE TO_CHAR(HIREDATE,'Q')='3')
WHERE EMPNO=7521;



--[1단계:코드] 4. emp10 부서별 최저 급여자를 삭제 처리하세요.
DELETE 
FROM emp11
WHERE  (deptno,SAL) IN (
SELECT deptno,MIN(SAL)
FROM emp11
GROUP BY deptno);



--[1단계:개념] 5. DB 서버 접속을 위한 프로젝트(자바프로그램단위) 설정할 내용에 대하여 기술하세요.
--  1) jdbc 드라이버 다운로드.
--	2) 메모리 로딩을 위한 build path설정 : classpath



--[1단계:개념] 6. jdbc(Java DataBase Connection)는 어떤 역할을 하는지 기술하세요. 
-- 각 밴더(소프트웨어 회사)에서 DB서버를 위해 만들어진 공통프로그램을 컴파일된 class만 패키지별로 압축해서
-- 지원하는 프로그램이다.
-- DB연결시 프로그램밍이나 툴에서 사용한다.
-- @@.jar은 jre환경이 설정된 곳에서 여러 프로그램을 실행할수 있다.
-- 윈도우 프로그램의 vc++의 exe,bat파일과유사하다.




--[1단계:개념] 7. 자바의 DB처리 순서를 코드와 함께 기술하세요.
/*
// 1. 드라이버 메모리 로딩 : 직접적으로 예외 처리(연결할때 1번만 필요하기 때문에)
      try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      System.out.println("드라이버 연결 성공");
      } catch (ClassNotFoundException e) {
         System.out.println("드라이버연결오류(오타확인):"+e.getMessage());
      }
      
//// 2. 측정 서버 접속처리 info(주소,port,DB명)/아이디/비밀번호 순으로 설정
      String info = "jdbc:oracle:thin:@localhost:1521:xe";
      con = DriverManager.getConnection(info,"scott","tiger");
   }
// 3.이후 메인메서드에서 trycatch문으로 에러잡으면서 실행확인
      try {
         setConnection();
         System.out.println("접속성공!");
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         System.out.println("접속에러:"+e.getMessage());
      }
      
      
      
      
--[1단계:개념] 8. DB 접속시, 필요한 예외 처리의 내용 처리방법을 기술하세요.
   1) Class.forName() : 컴파일예외 처리
      직접적으로 예외 처리(연결할때 1번만 필요하기 때문에) try{}catch
   2) DriverManager.getConnection(info,"scott","tiger");
      연결정보 SQLException : 컴파일예외 처리, throws로 예외를 위임처리한다.
      
--[1단계:실습] 9. javaexp2프로젝트를 만들어, javaexp2.a01_database 패키지와 A01_Dao.java를 만들어 연결처리하세요. 
--                처리한 내용캡쳐하시고, java 소스 코드를 text를 붙여주세요.
/*
 package a01_datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A01_Dao {
	private static Connection con;

	public static void setConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버연결오류(오타확인):" + e.getMessage());
		}
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(info, "scott", "tiger");
	}

	public static void main(String[] args) {
		try {
			setConnection();
			System.out.println("접속성공!");
		} catch (SQLException e) {
			System.out.println("접속에러:" + e.getMessage());
		}

	}

}
 
 */
