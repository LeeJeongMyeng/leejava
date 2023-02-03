select d.*,s.* from dept d,salgrade s;
SELECT * FROM EMP e ;
select id user99, pass password99,authority auth  from MEMBER;
SELECT * FROM dept WHERE deptno=20;

SELECT * FROM member100;

INSERT INTO member100 VALUES('aoddl56','','','',0,sysdate);

SELECT * FROM PRODUCT p ;

SELECT m.NAME, b.productname,p.price FROM product p ,member100 m , buyinfo b
WHERE m.name=b.name
AND p.PRODUCTNAME = b.productname;


DROP TABLE PRODUCT100;


CREATE TABLE product111(
 pid varchar2(100) PRIMARY KEY,
 name varchar2(100),
 price NUMBER,
 cnt number
);

CREATE TABLE member111(
mid varchar2(100) PRIMARY KEY,
pass varchar2(100),
name varchar2(100),
auth varchar2(100)
);
CREATE TABLE buyinfo111(
pid varchar2(100) PRIMARY KEY,
mid varchar2(100) PRIMARY KEY,
);

SELECT * FROM member111;
