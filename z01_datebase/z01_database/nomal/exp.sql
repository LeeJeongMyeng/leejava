SELECT * FROM emp11;
CREATE TABLE emp01
AS SELECT * FROM emp;

ALTER TABLE emp01
MODIFY (
job varchar2(50),
ename varchar2(50),
empno NUMBER PRIMARY key);

SELECT * FROM emp01;
SELECT * FROM dept;

SELECT * 
FROM EMP01
WHERE ename LIKE '%'||''||'%'
AND job LIKE '%'||''||'%'
AND SAL BETWEEN 1000 AND 2000;
--매개변수에 의해 검색조건을 처리하는 기능메서드 만들기

SELECT *
FROM DEPT d
WHERE DNAME LIKE '%'||'O'||'%'
AND LOC LIKE'%'||''||'%';

SELECT MAX(SAL) 
FROM EMP e 
GROUP BY deptno;

--부서별 최고 급여자
SELECT DEPTNO ,ENAME ,SAL 
           FROM EMP e 
           WHERE (DEPTNO,SAL) IN(
           SELECT DEPTNO, max(sal)
           FROM EMP GROUP BY DEPTNO);

SELECT * FROM SALGRADE s
WHERE grade=1
; 

select deptno, empno, ename, job, sal 
from emp01 
where sal between 0 and 3000;

DROP TABLE emp12;
create table emp12
 		as select * from emp;
 	
 alter table emp12
 modify (
 job varchar2(50),
 ename varchar2(50),
 empno number(4) primary key);

create sequence emp12_seq
 	   	start with 1000
 	   	minvalue 1000
 	   	maxvalue 9999;
 	   
insert into emp12 values(emp12_seq.nextval,'홍길동','사원',7800,
 	 		to_date('2022/01/01','yyyy/mm/dd'), 3500,100,10);
insert into emp12 values(emp12_seq.nextval,'마길동','대리',7800,
 	 		to_date('2022/01/01','yyyy/mm/dd'), 3500,100,10);
 	 	
SELECT * FROM emp12;
SELECT * FROM SALGRADE s2 ;


CREATE TABLE dept100
AS SELECT * FROM dept;

ALTER TABLE DEPT100
MODIFY (dname varchar2(50), loc varchar2(50));

SELECT * FROM dept100;
INSERT INTO dept100 values(11,'인사','서울');
-- 1)sql :insert into dept100 valuse(11,'인사','서울')
-- 2) vo 
-- 3) public void insertDept(Dept ins){}

DROP TABLE person;
CREATE TABLE person(
name varchar2(50),
age NUMBER,
loc varchar2(50) );

INSERT INTO person values('홍길동',25,'서울 신림');

SELECT * FROM person;

--1)분기별 또는 부서명 조건으로 사원의 이름, 부서명, 급여와 급여등급 출력

SELECT ename,DNAME, sal, grade
FROM emp e, SALGRADE s ,DEPT d 
WHERE  sal BETWEEN losal AND hisal
AND e.DEPTNO  = d.DEPTNO
AND to_char(hiredate,'q') ='1'
OR dname ='';


--2) 조건없음. 연도별 사원의 수와 최대급여를 출력하세요.
SELECT  to_char(hiredate,'YY') yy, count(empno) empnoc, max(sal) msal
FROM EMP e 
GROUP BY to_char(hiredate,'YY');




--3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
--		                    조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요

SELECT ENAME, EMPNO, mod(empno, 2) div,sal, 
      decode (mod(empno, 2),0,sal,sal*0.5) bonus, 
      nvl2(NULLIF(mod(empno,2),0),sal+(sal*0.5),sal*2)  totsal
FROM EMP e;


--4) 사원정보의 특정 근무일(YYYY/MM/DD)기준(조건)으로 근무연한/개월 수를 표현하세요 
SELECT * FROM emp;  
SELECT empno,ENAME,floor(months_between(sysdate, hiredate)/12)||'년' yyyy,
      mod(floor(MONTHS_BETWEEN(sysdate, hiredate)),12)||'개월' mmmm
FROM emp;
--------------------------------------------------------------------
SELECT ename,
	floor(mm/12)||'년'||floor(MOD(mm,12))||'개월' workmonth
from(
SELECT ename, MONTHS_BETWEEN(to_date('2001/01/01','yyyy/mm/dd'),hiredate) mm
FROM emp
) ;
--------------------------------------------------------------------
SELECT ename,
	floor(mm/12)||'년'||floor(MOD(mm,12))||'개월' workmonth
from(
SELECT ename, MONTHS_BETWEEN(to_date('2001년01월01일','yyyy"년"mm"월"dd"일"'),hiredate) mm
FROM emp
) ;
/*
 class Exp4{
 private String ename;
 private String workmonth;
 }
 public List<Exp04> getExp04List(String std){}
 */

--5) 사원명을 조건으로 해당 사원과 같은 입사일의 분기를 가진 사원전체 정보를 출력하세요.
SELECT empno,ename,sal
FROM EMP e 
WHERE to_char(hiredate,'q') in(
   SELECT to_char(hiredate,'q') FROM emp 
   WHERE ename  = 'ALLEN');
 
  
--6) 관리자명을 기준(조건)으로 관리자 하위에 포함된 직원정보(직원명, 부서번호, 급여) 출력하세요.
SELECT m.ENAME "관리자",e.ENAME "하위직원", e.EMPNO,e.SAL  
FROM EMP e ,emp m
WHERE e.mgr=m.EMPNO
AND m.ENAME = 'JONES';

--6) 
SELECT ename, deptno, sal
FROM EMP e 
WHERE mgr IN (
	SELECT empno
	FROM EMP
	WHERE ENAME = 'BLAKE');


 --7) 조건(월) 에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.
SELECT ENAME,DEPTNO
FROM EMP  
WHERE DEPTNO IN  (
	SELECT deptno
FROM EMP e 
WHERE to_char(hiredate,'MM')= '12'
GROUP BY DEPTNO);
	


SELECT * FROM emp100;

UPDATE EMP100 
	SET ename='홍길동',
		job = '과장',
		sal = 6000
	WHERE empno =7369;

DELETE emp100
WHERE empno = 7902;

SELECT * FROM dept100;
ALTER TABLE dept100
MODIFY (dname varchar2(50), loc varchar2(50));

SELECT * FROM DEPT100
WHERE DNAME  LIKE '%'||'O'||'%'
AND LOC LIKE '%'||'N'||'%';

SELECT * FROM DEPT100
WHERE DNAME  LIKE '%'||?||'%'
AND LOC LIKE '%'||?||'%'

INSERT INTO dept100 values(20,'회계','3층');
SELECT * FROM dept100;

