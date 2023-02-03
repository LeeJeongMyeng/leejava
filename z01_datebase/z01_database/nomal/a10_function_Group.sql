
/*
 # 그룹함수란?
 	1. 테이블의 전체 행을 하나 이상의 컬럼을 기준으로 그룹화하여 그룹별로 
 		결과를 출력하는 함수이다.
 		그룹 함수는 통계적인 결과를 출력하는데 주로 사용한다.
 	2. 사용법
 	 select 기준컬럼, 그룹함수(컬럼)
 	 from 테이블명
 	 [where]
 	 group by 그룹 컬럼
 	 having그룹 함수를 적용한 결과를 조건처리 
 	3. 그룹 함수의 종류
 		1) count(): 데이터의 건수, 행의 갯수
 		2) max() : null을 제외한 모든 행의 최대값
 		3) min() :      "  최소값
 		4) sum() : null을 제외한 모든 행의 함
 		5) avg() : null을 제외한 모든 행의 평균 값
 		6) stddev() : null을 제외한 모든 행의 표준편차
 		7) variance() : null을 제외한 모든 행의 분산값
 */
SELECT deptno, sal FROM emp ORDER BY deptno, sal;
SELECT max(sal),min(sal), count(*) FROM emp;
SELECT deptno, max(sal),min(sal), count(*)
FROM EMP e 
GROUP BY DEPTNO 
ORDER BY deptno;

SELECT DISTINCT JOB, COUNT(job), TRUNC(AVG(SAL))  
FROM EMP e 
GROUP BY job;

-- 날짜형 데이터 min,max()는 최근 데이터, 가장만저 데이터
SELECT deptno, MIN(hiredate)"가장 먼저", MAX(hiredate) "가장 나중"
FROM EMP e
GROUP BY deptno;

-- 부서별로 별균읍겨 중에 조건검색
SELECT DEPTNO, AVG(SAL)
FROM EMP e GROUP BY DEPTNO
HAVING AVG(SAL)>=2000;
--적용한 그룹함수의 조건을 처리할 떄는 HAVING을 활용한다.

--ex) 부서별로 최대값이 3000이상인 사원을 검색하세요
SELECT deptno,MAX(SAL) 
FROM EMP e GROUP BY DEPTNO 
HAVING MAX(sal)>=3000 ;

/*
 함수를 적용한 그룹 데이터 처리.
 1. 그룹 데이터를 함수를 적용해서 변경한 데이터를 기준으로 처리 할 수 있다.
 2. 기본형식
 	select 함수(데이터), 그룹함수()
 	from 테이블
 	group by 함수(데이터)
 	having 그룹함수() >=0;
 		having은 그룹함수에 비교, 조건/논리 연산식을 붙여 처리한다.
 */
-- 분기별 최대 급여액 출력
SELECT TO_CHAR(hiredate,'Q') 분기, MAX(SAL)
FROM EMP e 
GROUP BY TO_CHAR(hiredate,'Q') 
ORDER BY TO_CHAR(hiredate,'Q'); --차순 정렬

SELECT * FROM EMP;
--ex) 연도별 사원의 수와 최대 급여를 출력하세요.
SELECT TO_CHAR(hiredate,'yyyy'), count(HIREDATE), MAX(SAL) 
FROM emp
GROUP BY TO_CHAR(hiredate,'yyyy')
ORDER BY 연도; --ORDER by는 alias이름이로 지원처리



	