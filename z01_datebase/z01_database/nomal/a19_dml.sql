/*
#데이터 조작어 (Data Manipulation Language)
1. 테이블에 새로운 데이터를 입력하거나 기존 데이터를 수정또는 삭제하기 위한 명령어이다.
2. 종류
	insert : 입력처리
	update : 수정처리
	delete : 삭제처리
	merge : 병합처리 명령어(논리적 테이블의 병합/수정과 동시에 입력)
3. 트랜잭션
	여러개의 명령문을 하나의 논리적인 작업단위로 처리하는 기능을 말한다.
	명령어 종류 :  
	COMMIT(정상종료) :트랜잭션의 정상적인 종료를 위한 명령어
	ROLLBACK(비정장종료 복구) : 트랜잭션의 비정상적인 종료를 위한 명령어
	ex) DB클라이언트가 접속해서 변경을 했을 때, 본인 계정으로만
	변경된 데이터가 보인다(다른 계정으로 접근하면 변경되지 않는 데이터가 조임)
	이 때, COMMIT하는 순간 현재 클라이언트뿐만아니라 다른 계정으로 접속하더라도 변경되게 처리한다.

 #데이터 입력처리
 1. 테이블에 데이터를 입력하기 위한 명령어 INSERT구문을 말한다.
 2. 입력방법
 	1) 단일행 입력 : 한번에 하나의 행을 테이블에 입력하는 구문
 		insert into 테이블명(컬럼명1, 컬럼명2)
 		select 컬럼1,컬럼2
 		from 테이블명
 		
 		위 선언된 테이블의 컬럼명 type과, 순서와 갯수가 맞을때
 		조회된 다중 행의 데이터가 한번에 입력된다.
 		
 		
 	2) 다중행 입력: 서버 쿼리(SUBQUERY)를 이용하여 한번에 여러행을 동시에 입력하는 구문
 3. 다중행 입력
 	1) 데이터를 하나의 테이블에 여러행을 한번에 입력하는 QUERY를 말한다.
 	2) 형식
 		- insert명령문에서 서버쿼리로 다른 테이블에 조회해 와서 입력처리
 		- insert명령문에 의해 한번에 여러행을 동시에 입력
 		- 기타형식
 			insert all
 			first insert	  
 */

/*
 # 전체 컬럼 입력
 	 insert into 테이블명
 	 subquery - 해당테이블에 맞는 행의 갯수로 입력
 1.지정된 컬럼 입력
 insert into 테이블
 subquery
 */
DROP TABLE emp12;
CREATE TABLE emp12
AS SELECT empno, ename, job, deptno FROM emp WHERE 1=0;
SELECT * FROM emp12;

--테이블의 전체컬럼에 맞게 subquery를 선언하여 데이터를 한번에 엽력
INSERT INTO emp12
SELECT empno, ename, job, deptno
FROM EMP 
WHERE sal BETWEEN 1000 AND 3000;

--테이블의 지정된 컬럼에 맞게  subquery를 선언하여 데이터를 한번에 입력
INSERT INTO emp12(empno,ename)
SELECT empno, ename
FROM EMP WHERE to_char(hiredate,'mm') in('01','05','12');
--ex) 사원번호, 부서명, 급여가 있는 
DROP TABLE emp13;

CREATE TABLE emp13
AS SELECT empno,dname,sal
FROM emp e,DEPT d
WHERE e.deptno = d.deptno AND 1=0;

INSERT INTO emp13
SELECT empno, dname, sal
FROM emp e, dept d
WHERE e.deptno=d.DEPTNO 
AND (e.deptno,sal) IN (
SELECT deptno, max(sal)
FROM EMP 
GROUP BY deptno);

---------------------------------------------------------------------------------
CREATE TABLE emp10 AS SELECT * FROM emp;
DROP TABLE emp10;
SELECT * FROM emp10;
INSERT INTO emp10(empno) values(9002);
--transaction기능에 의해 commit하기전에 rollback에 의해 원복가능
--commit전에 접속 종료나 외부에 다른 곳에서 계정 접속하면 dml처리가 되지않는것을 확인할 수 있다.