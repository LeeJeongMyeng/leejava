/*
 #subquery
 	1.개요
 		하나의 sql명령문의 결과를 다른sql명령문에 전달하기 위해 두 개 이상의
 		sql명령문을 하나의 slq명령문으로 연결하여 처리하는 방법
 	2. 서버쿼리의 필요성
 		1) 사원 'SMITH'와 동일한 부서번호를 가진 사원의 정보를 검색
 			- 사원 테이블에서 'SMITH'라는 사원을 SQL명령문을 통해 검색
 			- 부서번호 20을 확인하여, 동일한 부서번호를 통해 사원 정보를 검색한다.
 			- 위와 같이 2중으로 SQL처리할 내용을 통합하여 하나의 SQL명령문으로 처리한다.
 			- 메인 쿼리 
 				WHERE DEPTNO = (서버쿼리)
 	3. 실행 순서
 		1) main query에 최하단에 있는 부분부터 실행해서 결과를 가지고 사위에 있는 query로 전달한다.
 		     
 */
--SMITH와 동일한 부서의 사원정보를 출력하세요
SELECT *
FROM EMP e 
WHERE DEPTNO = (
	SELECT DEPTNO
	FROM EMP
	WHERE ENAME='SMITH'
				);
-- ex) WARD와 같은 직책에 있는 사원 정보를 출력
SELECT * FROM EMP;
SELECT ENAME,JOB 
FROM EMP e 
WHERE JOB = (
	SELECT JOB
	FROM EMP
	WHERE ENAME  = 'WARD'
			);
-- EX) KING을 간리자로 둔 사원정보 출력
SELECT E.*,M.*
FROM EMP e ,EMP M
WHERE e.MGR =m.EMPNO
		AND M.ENAME =(
		SELECT M.ENAME 
		FROM EMP M
		WHERE M.ENAME = 'KING');

	/*
	 # 서버쿼리의 종류
	 1. 단일행 서버쿼리
	 	-서버의 쿼리의 결과가 하나의 행인 경우를 말한다.
	 	-하나의 행을 조건으로 처리하는 비교 연산자(=, <, >, >=, <=, <>, !=)등을 활용할 수 잇다.
	 	EX) select *
	 		from emp
	 		where sal <= (
	 			select max(sal)
	 			from emp
	 			where deptno = 10 );
	 			부서번호가 10인 사원의 최대 급여보다 적은 급여를 가진 사원 정보
	 			
	 2. 다중행 서버쿼리
	 	- 서버 쿼리의 결과값이 여러행일 때, 활용된다.
	 	- 다중행 비교연산자 : in,any,some,all,exists등을 활용할 수 있다.
	 	ex) select *
	 		from emp
	 		where job in(
	 			select job
	 			from emp
	 			where sal between 1000 and 2000
	 					);
	 		 		
	*/
	SELECT min(sal)
	FROM EMP e 
	WHERE deptno =10;

SELECT * FROM EMP e;

SELECT *
FROM EMP e 
WHERE sal <= ( 
	SELECT min(SAL)
	FROM EMP
	WHERE sal BETWEEN 1000 AND 2000);
--급여가 1000~2000사이의 직책과 같은 사원 정보	

--ex) 부서번호가 20인 사원정보의 편균 급여보다 높은 사원

SELECT *
FROM emp
WHERE sal>(
SELECT avg(SAL)
FROM EMP
WHERE deptno=20
);

--ex) 2사분기에 입사한 사원의 직책과 동일한 사원정보를 출력

SELECT *
FROM emp
WHERE job in(
		 SELECT job
FROM EMP e WHERE TO_CHAR(hiredate,'q')='2'
				);
--ex) 5월에 입사한 사원의 부서와 같은 사원의 정보를 출력하세요

SELECT *
FROM EMP 
WHERE DEPTNO = (
SELECT DEPTNO 
FROM EMP 
WHERE TO_CHAR(hiredate,'mm')='05'
);

/*
 # 다중열이 있는 서브쿼리 
 	1.단일행
 	2.다중행
 	 select
 	 from 
 	 where (조건1컬럼, 조건2컬럼) in(다중열/다중행 sub query)
 */
SELECT deptno, max(sal)
FROM EMP e
GROUP BY deptno;

--SALESMAN 중에서 가장 급여가 낮은 사람
SELECT *
FROM EMP  
WHERE (JOB,SAL) =(
SELECT job,min(sal)
FROM EMP e 
WHERE job = 'SALESMAN'
GROUP BY job
);

--부서별최고 급여자의 사원 정보
SELECT deptno, ename, sal
FROM EMP e 
WHERE (deptno, SAL) IN (
	SELECT deptno, max(SAL)
	FROM EMP
	GROUP BY deptno
);

--ex) 1사분기에 입사한 사람중에 급여가 가장 높은 사원의 정보를 출력(단일행)
SELECT *
FROM EMP  
WHERE (TO_CHAR(HIREDATE,'Q'),SAL)=(
	SELECT TO_CHAR(HIREDATE,'Q'),MAX(SAL) 
	FROM EMP
	WHERE TO_CHAR(HIREDATE,'Q')='1'
	GROUP BY TO_CHAR(HIREDATE,'Q')
	);


--ex)급여가 2000~3000사이의 관리자 정보와 부서정보와 일치하는 사원을 출력(다중행)
SELECT *
FROM EMP e 
WHERE (MGR,DEPTNO) IN (
	SELECT MGR,DEPTNO
	FROM EMP e 
	WHERE SAL BETWEEN 2000 AND 3000
);

--inline view : query를 통해서 하나의 가상의 테이블을 만들고,
-- 그 데이터를 통해서 조인하는것을 말한다.
--부서별 사원의 급여가 가장 높은 사원의 정보

SELECT e.deptno, empno, ename, me.msal
FROM emp e ,(SELECT deptno, max(sal) msal
				FROM emp
				GROUP BY deptno) me
WHERE e.deptno=me.deptno
AND e.sal=me.msal;

--ex) 분기별 최고 급여자의 사원번호,사원명,분기, 급여 출력
-- 1) 분기별 최고 급여자 만들기
SELECT to_char(hiredate,'q') qu, max(sal) msal
FROM EMP e 
GROUP BY to_char(hiredate,'q');
-- 2) 기본 테이블과 조인하기 -(분기,급여)
-- 3) 리스트할 정보 select하기
SELECT empno,ename,qm.qu,SAL  FROM emp e,(
SELECT to_char(hiredate,'q') qu, max(sal) msal
FROM EMP e 
GROUP BY to_char(hiredate,'q')
) qm
WHERE TO_CHAR(e.hiredate,'q')= qu
AND sal =msal;


SELECT (SELECT max(sal)
		FROM EMP e 	
		WHERE deptno=e.DEPTNO ) "부서별 최고 급여", e.*
FROM emp e;
