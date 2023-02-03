SELECT * FROM emp;
-- 주석 ctrl+/ 하면 주석처리바로됨
-- 커서를 명령문에 위치 시키고 ctrl+enter(실행)
/*블럭주석 마찬가지 ctrl+shift+/
 
 #데이터 초죄하기
 데이터는 select 구문을 이용하여 저장된 데이터를 호출 할 수 있다.
 
 1. 기본형식
 	select * | 컬럼1, 컬럼2
 	from 테이블명
 	where 조건
 */
SELECT  *
FROM emp;
-- emp 테이블의 전체 컬럼(*)을 검색

SELECT ename, job, deptno
FROM emp;
-- emp 테이블의 ename, job, deptno 컬럼을 검색

-- ex1) dept 테이블의 전체 컬럼 검색
-- ex2) emp 테이블의 empno,mgtr,hiredate, deptno 검색

SELECT * FROM dept;

SELECT empno,mgr,hiredate,deptno
FROM emp;

/*
 2. 테이블명과 컬럼명의 별칭(alias) 처리하기
 	 테이블명과 컬럼명에는 as라는 키워드를 쓰거나 공백을 통해서
 	 별칭을 선언하여, 컬럼명이나 테이블명으로 활용할 수 있다.
 */
SELECT empno, empno AS NO, ENAME AS name,
	hiredate birthdate, deptno dno
FROM emp;

SELECT empno AS eno, ename name, MGR  management, sal AS salary
FROM emp;

/*
 # 기본적인 테이블 처리 문법은 여러 테이블과 함께 사용할 때, 활용된다.
 	동일한 컬럼이 있을 경우 구분하기 위한 내용이다.
 	테이블이 하나밖에 없을 때는 테이블명을 생략해도된다.
*/
SELECT  * FROM emp;
SELECT  * FROM dept;
SELECT emp.DEPTNO , dept.DEPTNO 
FROM emp, dept dept;
SELECT e.deptno, ename, d.deptno, loc
FROM emp e, dept d;
SELECT deptno, ename
FROM emp;
SELECT deptno, dname
FROM dept;
-- 그런데, 특정 컬럼을 나타내고 전체 컬럼을 나타낼 때는 alias를
-- 하나의 테이블인 경우도 처리하여야한다.
SELECT empno NO, e.*
FROM emp e;

--SELECT empno NO, *
--FROM emp; 에러발생함

/*
 # alias의 공백과 특수 문자 사용
 	1. alias명으로 공백이나 특수문자를 사용할 때는 ""로 양옆에 
 		쌍따옴표를 처리한다.
 	2. 한글이라도 붙여서 처리하는 경우에는 필요없다.
 */
SELECT ename "사 원 정 보", ENAME "@ 사원 정보 #",
sal 급여
FROM  emp;

--ex) 해당 컬럼alias로 처리하여 출력
-- empno("사 원 번 호") ename("!!@사원명@!!")
-- sal("급!!!여")
SELECT empno "사 원 번 호", ename "!!@사원명@!!",
sal "급!!!여"
FROM emp;

/*
#데이터의 산출 연산 처리와 문자 연결
 	1. 숫자형/날짜형 데이터가 있는 컬럼은 연산처리가 가능하다.
 		1) 일반 숫자
 			사칙 연산자(+,-,*,/), %(지원하지않음 - mod(데이터1,데이터2) -함수파트에서 나머지 연산 지원
*/
SELECT empno, empno + 10 "사원번호+10",
	sal*05 "급여의 50%", deptno,
	sal*(deptno/10) "급여와 부서 연산",
	mod(sal, deptno) "나머지"
FROM emp;

-- ex)  사원 번호(empno)를 만단위체제로 10000을 더하여 처리하고,
-- 		sal와 comm을 합산하여 아래의 컬럼형태로 나타내세요.

-- 사원번호(만단위) 급여(sal) 보너스(comm) 합산(sal+comm)

SELECT empno+10000 "사원번호(만단위)", sal "급여", comm"보너스",
	sal+comm "합산", sal+nvl(comm,0) "합산2(sal+comm)"
FROM emp;
--comm 값이 없는 경우 합산 시, null로 처리된다.
-- 연산을 처리하는 경우 피연산자중 하나라도 데이터가 null이면, 연산이 되지 않고 null로 처리가 된다. 
-- nvl(컬럼,null인 경우 초기값) null인 경우 특정한 값으로 초기화
-- 위의 comm이 null인 경우 0으로 처리하여 연산을 처리할 수 있다.

/*
  2. 컬럼과 문자열 연결 처리 : 문자열 || 문자열
  	- 데이터 베이스는 문자열 + 문자열을 처리하지 않는다.
  	1) 기본형식
  		select 컬럼명 || '연결할 문자열', 컬럼명1||컬럼명2
 */
SELECT empno ||'번' 사원번호,
	empno ||'/'||deptno "사원번호/부서번호",
	empno || ename "사원번호와 이름"
	FROM emp;
-- 사원정보(emp)의 컬럼 내용
-- empno(사원 번호), ename(사원명), job(직책), mgr(관리자번호)
-- hiredate(입사일), sal(급여), comm(보너스), deptno(부서번호)
-- ex1)
-- ##사원 정보/부서정보 ##
-- 사원명 @@@의 사원 번호는 @@@입니다.
SELECT '사원명'||ename||'의 사원 번호는 '||empno||'입니다.' "#사원 정보#"
FROM emp;