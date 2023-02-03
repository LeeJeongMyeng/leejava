--2022-10-04
--[1단계:개념] 1. EQUI join과 NON EQUI join의 차이점을 기술하세요

 	
 		-- equi JOIN 조인 대상 테이블에서 공통 컬럼을 '='equal비교를 통해 같은 값을
 		--	가지는 행을 연결하여 결과를 생성하는 조인 방법
 SELECT ename, sal, dname, e.DEPTNO 
FROM mp e, dept d
WHERE e.DEPTNO = d.DEPTNO 
AND sal>=3000;


-- Non equi join
-- 조인하는 두개의 테이블의 값이 동일하지않고, 범위로서 join하는 경우를 말한다. 
SELECT *
FROM emp, SALGRADE s 
WHERE  sal BETWEEN losal AND hisal
AND GRADE=4;

--[1단계:코드] 2. 직책이 SALESMAN의 급여와 등급을 출력하요
SELECT ENAME,JOB,GRADE 
FROM EMP e ,SALGRADE s
WHERE job ='SALESMAN';

--[2단계:코드] 3. 1사분기에 입사한 사원중, 부서명이 ACCOUNTING인 사원의 이름, 급여와 급여등급 출력하세요.
SELECT ENAME,DNAME, SAL, GRADE
FROM EMP e ,DEPT d,SALGRADE s  
WHERE TO_CHAR(HIREDATE,'Q')='1'
AND DNAME= 'ACCOUNTING';
--[1단계:개념] 4. outer join의 기본 형식과 equi join과의 차이점을 기술하세요.
/*OUTER JOIN
	equi join의 조인 조건에서 양 테이블의 컬럼 값중, 어느 하나라도 null이면
 	'='비교 결과가 거짓이 되어 null값을 가진 행은 조인 결과로 출력불가이지만,
 	OUTER JOIN은 NULL값도 출력이 가능하다.
 	
 	from 테이블1,테이블2
 	where 테이블1.공통컬럼(+)= 테이블2.공통컬럼
 	 * */
SELECT ename,e.deptno, d.deptno,dname
FROM EMP e ,DEPT d 
WHERE e.deptno(+) = d.DEPTNO ;
--[2단계:코드] 5. 부서별 최고급여액을 출력하되 사원정보가 없는 부서는 0으로 표현하여 출력하세요.
SELECT d.DEPTNO , NVL(MAX(E.SAL),0) 
FROM EMP e ,DEPT d 
WHERE e.DEPTNO(+) = d.DEPTNO
GROUP BY D.DEPTNO;
--[1단계:코드] 6. 관리자하위에 포함된 사원을 기준으로 관리자의 하위 직원의 수를 관리자명, 사원수로 출력하세요.
--?
--[1단계:개념] 7. subquery란 무엇인가? 여러가지 유형과 함께 기술하세요.
/*
 하나의 sql명령문의 결과를 다른sql명령문에 전달하기 위해 두 개 이상의
 		sql명령문을 하나의 slq명령문으로 연결하여 처리하는 방법
 		1. 단일행 서버쿼리
 		서버의 쿼리의 결과가 하나의 행인 경우, 하나의 행을 조건으로 처리하는 비교 연산자(=, <, >, >=, <=, <>, !=)등을 활용할 수 잇다.
 		select *
	 	from emp
	 	where sal <= (     -- deptno가10인 사원의 최대 급여보다 이하의 급여를가진 사원 정보
	 			select max(sal)
	 			from emp
	 			where deptno = 10 );
	 			
	 	2. 다중행 서버쿼리
	 		서버 쿼리의 결과값이 여러행일 때 활용,in,any,some,all,exists등을 활용할 수 있다.
	 		elect *
	 		from emp
	 		where job in(     --급여가 1000~2000사이으 직책과 같은 사원 정보
	 			select job
	 			from emp
	 			where sal between 1000 and 2000 
	 					);
 */
--[1단계:코드] 8. JAMES와 같은 입사일의 분기를 가진 사원을 출력하세요.
-- james 4분기
SELECT *
FROM EMP e 
WHERE TO_CHAR(hiredate,'q') IN  (
		SELECT TO_CHAR(hiredate,'q')
		FROM EMP e2 
		WHERE TO_CHAR(hiredate,'q')='4'
		); 
--[1단계:코드] 9. ALLEN과 같은 관리자를 둔 사원을 출력하세요.
-- 7698
SELECT *
FROM EMP e 
WHERE MGR IN (
SELECT mgr
	FROM EMP e 
	WHERE mgr=7698
);
--[1단계:코드] 10. 보너스가 가장 많은 사원정보(사원명, 부서명, 보너스)를 출력하세요.
SELECT ENAME ,dname,COMM 
FROM EMP,DEPT d 
WHERE COMM IN (
SELECT MAX(COMM) 
FROM EMP e 
);


--[1단계:코드] 11. 12월에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.
SELECT *
FROM emp
WHERE (TO_CHAR(hiredate,'mm'),DEPTNO) IN (
SELECT TO_CHAR(hiredate,'mm'),DEPTNO 
FROM EMP e 
WHERE TO_CHAR(hiredate,'mm')='12'
);

--[1단계:개념] 12. 다중행/다중열의 SUBQUERY의 종류와 차이점을 예제를 통해 기술하세요. 

--2. 다중행 서버쿼리 -조건이 하나이나, 출력결과가 여러행일 때 사용한다.
--	  - 다중행 비교연산자 : in,any,some,all,exists등을 활용할 수 있다.
SELECT *
FROM emp
WHERE job in(
		 SELECT job
		 FROM EMP e
		 WHERE TO_CHAR(hiredate,'q')='2'
				);
			
	 		 		
/*
 # 다중열 서브쿼리 - 조건이 두개이상일때 사용한다.
 	 select
 	 from 
 	 where (조건1컬럼, 조건2컬럼) in(다중열/다중행 sub query)
 */
SELECT *
FROM EMP  
WHERE (JOB,SAL) =(
SELECT job,min(sal)
FROM EMP e 
WHERE job = 'SALESMAN'
GROUP BY job
);
/*
== 평가대비(오라클) 객관식 문제 ==
1. 다중행 서버쿼리로 사용되는 구문이 아닌 것은 ? 4번, in/any/some/all/exists가 있다.
1) in 2) any 3) some 4) between
정답:4

2. 사람의 머리로 이해할 수 있는 현실 세계를 모델링은 하는 것은 어느 분류에 해당하는가?  3번
1) 단계적 - 개념적 모델링 -- 현실 세계의 중요데이터를 추출하여 개념세계로 옮기는 것
2) 단계적 - 논리적 모델링 -- 개념세계의 데이터를 데이터베이스에 저장하는 구조로 표현
3) 도구적 - 개념적 모델링  
4) 도구적 - 논리적 모델링 -- 개념적 구조를 논리적 모델링하여 데이터베이스의 논리적 구조로 표현하는 도구
정답:3

3. 개념적 데이터 모델의 도형으로 틀린 것은? 1번. 없음.
1) 엔티티 - 원 
2) 관계 - 마름모
3) 속성 - 타원
4) 개체 - 사각형
정답:1

4. subquery로 사용하는 비교연산자가 아닌 것은? 1번, in/any/some/all/exists 혹은 =,!=,<,>,<=,>=가 있다.
1) both
2) any
3) some
4) exists
정답:1 */