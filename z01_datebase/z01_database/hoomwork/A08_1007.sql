/*
#다음 내용을 모두 포함하는 데이터베이스를 설계하세요
(설계-erd+테이블생성(제약사항 포함) + 데이터 입력
1. 회사는 4개의 부서를 운영한다.
	-부서(부서번호,부서이름)을 저장한다.
2. 부서는 1명 이상의 직원(직원번호, 직원이름, 직책)을 두고있다.
	각직원은 하나의 부서에 소속된다.
3. 직원은 부양가족(이름,나이)이 있을수 있다.
4. 각직원은 근무했던 부서에 대한 근무기록(기간,직책)이 있다.



* 부서 부서번호-직원의 부서번호(
 	- 비식별관계 : 부서의 pk인부서번호를 직원의 일반속성으로 fk받기때문
* 직원 직원번호(pk)-부양 직원번호(pk,fk) (empno1007.empno=family.empno)
	- 비식별관계..
* 직원 직책-근무기록직책
	==> 직책은 사원정보를 통해서 가져올 수 있기때문에 설정하지않는다. 기간(startDate, endDate)
	==> 근무기록(근무기록번호, 사원번호, 부서버놓, 시작일, 마지막일)
	==> hisno, empno, deptno, startDate, endDate / empno,deptno 비식별자
	ex) 1000홍길동, 10(인사), 2022/01/01, 2022/01/31
	ex) 1000홍길동, 20(총수), 2022/02/01, 2022/02/28
	ex) 1000홍길동, 10(총수), 2022/03/01, 2022/02/31

*/

-- 부서테이블(부서번호 pk,부서이름)
DROP TABLE dept1007;
CREATE TABLE dept1007(
deptno NUMBER PRIMARY key,
dname varchar2(20));

INSERT INTO dept1007 VALUES(7001,'회계팀');
INSERT INTO dept1007 VALUES(7002,'연구소');
INSERT INTO dept1007 VALUES(7003,'총무팀');
INSERT INTO dept1007 VALUES(7004,'생산팀');
SELECT * FROM dept1007;



-- 직원테이블(직원번호pk,직원이름,직책)
DROP TABLE emp1007;
CREATE TABLE emp1007(
empno NUMBER PRIMARY KEY,
ename varchar2(20),
job varchar2(20)
);
INSERT INTO EMP1007 values(1000,'홍길동','대리');
INSERT INTO EMP1007 values(1002,'구마적','과장');
INSERT INTO EMP1007 values(1003,'이순신','차장');
INSERT INTO EMP1007 values(1004,'김영실','부장');
SELECT * FROM emp1007;


--근무기록(근무기록번호,시작일,마지막일,부서번호fk,직원번호fk)
--기간 => 입사일 기준 현재날짜로 한다.
DROP TABLE workrecord;
CREATE TABLE workrecord(
recordno NUMBER PRIMARY KEY,
startdate DATE,
enddate DATE,
deptno NUMBER REFERENCES dept1007(deptno),
empno NUMBER REFERENCES emp1007(empno));
INSERT INTO workrecord values(1,to_date('2202/01/01','yyyy/mm/dd'),to_date('2202/01/31','yyyy/mm/dd'),7001,1000);
INSERT INTO workrecord values(2,to_date('2202/02/01','yyyy/mm/dd'),to_date('2202/02/28','yyyy/mm/dd'),7002,1000);
INSERT INTO workrecord values(3,to_date('2202/03/01','yyyy/mm/dd'),to_date('2202/03/31','yyyy/mm/dd'),7003,1000);
SELECT * FROM workrecord;


--부양가족 (부양가족번호, 이름,나이,직원번호fk)
DROP table family;
CREATE TABLE family(
fno NUMBER PRIMARY KEY,
fname varchar2(20),
age NUMBER,
empno NUMBER REFERENCES emp1007(empno));

INSERT INTO family values(1,'홍사경',67,1000);
INSERT INTO family values(2,'구이',6,1002);
INSERT INTO family values(3,'이발소',40,1003);
INSERT INTO family values(4,'김말이',14,1004);



-- 4개 테이블 합쳐서 출력
SELECT * FROM emp1007 e;
SELECT * FROM dept1007 d;
SELECT * FROM workrecord w;
SELECT * FROM FAMILY f ;

SELECT * FROM emp1007 e, dept1007 d, workrecord w,family f
WHERE e.empno = w.EMPNO
AND w.deptno=d.deptno
AND e.empno=f.empno;
