SELECT *
FROM emp;
--ex) 부서를 조건으로 부서번호, 사원명, 직책명, 급여를 출력하세요
-- sql==>vo==>기능메서드(A04_DaoExp.java)

SELECT deptno, ename, job,sal
FROM EMP e 
WHERE deptno=10;


--사원명(키워드검색),급여(시작~끝)으로 조건으로하여
-- 사원번호, 사원명, 급여를 출력하세요.
SELECT empno,ename,sal
FROM EMP e 
WHERE ename LIKE '%'||'A'||'%'
AND sal BETWEEN 1000 AND 2000;

/* -- select 조건, where조건 만들수있음.
 private int empno;
 private String ename;
 private Doubld sal;
 private int frsal;
 private int tosal;
 
 기능 메서드
 1. 리턴유형
 2. 매개변수
 private List<Emp02> getSch02<Emp02 sch>{
  List<Emp02> list = new ArrayList<Emp02>();
  
  return list;
 }
 */

--ex) 직책(키워드검색) 또는 부서번호 조건으로 출력
SELECT EMPNO, ENAME , JOB , DEPTNO 
FROM EMP e 
WHERE JOB LIKE '%'||'A'||'%'
OR deptno =20;

/*
private int empno;
private String ename;
private String job;
private int deptno; 
 */

--ex) dept와 조건을 통해서 부서명(키워드)와
SELECT DNAME , ENAME , HIREDATE , SAL 
FROM EMP e ,DEPT d 
WHERE e.DEPTNO  = d.DEPTNO
AND d.DNAME LIKE '%'||''||'%'
AND TO_char(HIREDATE,'q')= '2'; 

/*
 private String dname;
 private String ename;
 private Date hiredate;
 private Double sal;
 private String hireq;
 * */

SELECT * FROM emp;
private int empno;
private String ename;
private String job;
private int 
private
private
private
private

SELECT *
FROM EMP e 
WHERE empno=7000;

SELECT DEPTNO , ename, job, SAL 
FROM EMP e 
WHERE deptno=10;


