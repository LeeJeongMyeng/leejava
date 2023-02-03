/*
 # 데이터 수정
 1. update 명령문은 테이블에 저장된 데이터 수정을 위한 조작어이다.
 2. 기본형식
  	update 테이블명
    set 컬럼1 = 변경할 데이터,
    	컬럼2 = 변경할데이터
    	...
    where 조건문
 3. 주의사항
  	1) where 절을 생략하면 테이블의 모든 행이 수정된다.
  	2) 조건문과 변경할 데이터 부분을 subquery를 이용하여 처리할 수 있다.
 */
SELECT * FROM emp10;
UPDATE EMP10 
SET empno=1000,
	JOB ='사원'
WHERE empno=7369;

--ex1)emp10 보너스가 null인 데이터르 모두 1000으로 수정처리
UPDATE EMP10 
SET comm=1000
WHERE comm IS NULL;
SELECT * FROM emp10;
--ex2) emp10 1/4 분기에 입사한 사원정보를 협재날짜로 수정하세요
UPDATE EMP10 
SET hiredate=SYSDAT
WHERE TO_CHAR(hiredate,'q')='1'; 
SELECT * FROM emp10;


/*
 #subquery를 이용한 수정처리
 	1.update명령분에 set부분이나 where조건절에 subquery를 이용하여 수정처리하는 것을 말한다.
 	2. 다른 테이블이나 현재 테이블에 정보를 변경할 때, 일단 query를 수행한 결과로 해당 데이터를 수정처리하는 것을 말한다.
 	3. 변경할 컬럼의 타입과 갯수는 반드시 일치하여야한다.
 	4. 유형
 		1) set부분 subquery를 활용
 			- 한개의 컬럼 set컬럼명 = (결과가 1개인 컬럼데이터)
 			- 두개 이상의 컬럼 set(컬럼명,..) = 결과가 두개 이상컬럼럼query
 */
-- 부서번호가 10인 사원정보의 급여를 부서정보 20인 사원의 최고급여로 변경처리
SELECT ename, sal
FROM emp10
WHERE DEPTNO =10;

SELECT max(sal)
FROM EMP10 e WHERE deptno=20;

UPDATE EMP10 
	SET sal =(
	SELECT max(sal)
	FROM EMP10  
	WHERE deptno=20
	);

-- ex) 직책이 salesman인 사람의 평균 급여를 사원번호 7499에 급여로 수정처리하세요
SELECT AVG(sal) aSAL
FROM emp10
WHERE job='SALESMAN';

UPDATE EMP10 
SET sal=(SELECT AVG(sal) aSAL
FROM emp10
WHERE job='SALESMAN')
WHERE empno=7499;

SELECT * FROM emp10;

--ex3) 1사준기 최고급여를 사원명 Allen의 급여로 변경처리
SELECT max(sal)
FROM EMP10 e 
WHERE TO_char(HIREDATE,'q')='2';

UPDATE EMP10 
SET sal=(SELECT max(sal)
FROM EMP10 e 
WHERE TO_char(HIREDATE,'q')='2')
WHERE ENAME = 'ALLEN';

UPDATE EMP10 
SET SAL=(
SELECT MIN(SAL)
FROM EMP10
WHERE JOB='MANAGER')
WHERE ENAME='SMITH';

SELECT * FROM EMP10 e WHERE ENAME='SMITH';

/*
# 데이터 삭제처리
	1. 조회조건 WHERE을 통해 특정한 데이터를 ROW단위로 삭제 처리한다.
	2. ROW단위이기에 삭제구문을 선택하는 컬럼이 없다.
	 DELETE --선택하는 컬럼X
	 FROM 테이블
	 WHERE 조건
	3. 조건은 기존 데이터와 같이 subquery를 이용해서 조건 가능
	ex) 급옂ㅇ웨가 장 낮은 데이터를 삭제처리하세요
*/
SELECT * FROM EMP10;
DELETE 
FROM EMP10 e 
WHERE EMPNO =7369;

--ex) 급여중에 가장 낮은 데이터를 삭제처리하세요
DELETE 
FROM EMP10 e 
WHERE sal=(SELECT min(sal) FROM emp10);
--ex) 부서별로 가장 최근 입사한 사원 삭제처리
CREATE TABLE emp11
AS SELECT * FROM emp;

DELETE 
FROM emp11
WHERE  (deptno,hiredate) IN (
SELECT deptno,max(HIREDATE)
FROM emp11
GROUP BY deptno);