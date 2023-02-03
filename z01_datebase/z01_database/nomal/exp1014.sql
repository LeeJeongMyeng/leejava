--[1단계:확인] 2. 등급테이블의  salgrade1000 테이블을 복사 만들고, 해당 정보를 메서드를 만드세요.
CREATE TABLE SALGRADE1000
AS SELECT * FROM SALGRADE s ;

SELECT * FROM SALGRADE1000; --grade losal hisal

--[1단계:확인] 3. 사원명과 부서명의 통합테이블 EmpDept100 테이블을 복사 만들고, 해당 정보를 메서드를 만들고 데이터를 입력하세요.

DROP TABLE empdept100;

CREATE TABLE empdept100
AS SELECT e.*,dname,loc
FROM EMP e ,DEPT d 
WHERE e.DEPTNO = d.DEPTNO ;

INSERT INTO EMPDEPT100 VALUES ('이정명','연구소');


--[1단계:확인] 4. member100(아이디, 패스워드, 이름, 권한, 포인트, 등록일) 만들고, 데이터를 등록 후, 조회하는 메서드를 선언 및 출력하세요.
CREATE TABLE MEMBER100(
id varchar2(50),
pass varchar2(50),
name varchar2(50),
div varchar2(50),
point NUMBER,
hiredate DATE
);


INSERT INTO member100 values(
'id',
'pass',
'name',
'div',
100,
to_date('2022/01/01','yyyy/mm/dd'));

DROP TABLE member1111;
SELECT * FROM MEMBER111;

SELECT * FROM member100
WHERE  id = 'aaaa'
AND pass = '1111';


