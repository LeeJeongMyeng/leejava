

 SELECT * 
FROM salgrade
WHERE grade BETWEEN 1 AND 5;

SELECT * FROM EMP100 e ;

SELECT * FROM SALGRADE s ;

INSERT INTO SALGRADE VALUES(?,?,?);

INSERT INTO emp100 values(,,,,,);


SELECT * FROM MEMBER
WHERE name LIKE '%'||'이'||'%'
and authority LIKE '%'||'관'||'%';


DROP TABLE MEMBER;
CREATE TABLE MEMBER(
id varchar2(20),
pass varchar2(20),
name varchar2(20),
auth varchar2(20),
point NUMBER,
address varchar2(200)
);

SELECT empno NO, ename name, sal+NVL(comm,0) tot 
FROM emp100;
-- no,name,tot :column
-- empno,ename,sal : Emp안의 property에 할당
-- 1. mapper에서 resultMap 선언 id값을 가져오기

SELECT ename name, mgr manager, sal salaray 
	FROM emp100;
