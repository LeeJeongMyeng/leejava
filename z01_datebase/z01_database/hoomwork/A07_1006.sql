
--[1단계:개념] 1. 테이블의 구조 변경형식(추가, 삭제, 수정)을 기본예제를 통해 기술하세요.
DROP TABLE emp14;
CREATE TABLE emp14
AS SELECT empno, ename, job, sal FROM EMP
WHERE 1=0;
-- 추가
ALTER TABLE emp14
ADD address varchar2(20);
-- 삭제
ALTER TABLE emp14 DROP COLUMN job;
--수정
-- 날짜유형에서 문자열 유형으로 변경 : 데이터 없으로 가능
ALTER TABLE emp14
MODIFY hiredate varchar(14);
--데이터가 존재하더라도 같은 데이터 유형을 기존보다 크게 변경하는것은 가능하다.
ALTER TABLE emp14
MODIFY ename varchar2(50); 
--[1단계:코드] 2. 부서테이블을 dept12 복사테이블을 만들고, 부서관리자명, 부서생성일을 추가하세요.
CREATE TABLE dept12
AS SELECT ename FROM EMP
WHERE 1=0; --생성
SELECT * FROM dept12; --확인
ALTER TABLE dept12
ADD mkdept date;--추가
SELECT * FROM dept12;--확인


--[1단계:코드] 3. 사원테이블과 등급테이블을 조인해서 복사테이블 emp17만들고, losal, hisal을 삭제 처리하세요.
DROP TABLE emp17;
CREATE TABLE emp17
AS SELECT *
FROM EMP e ,SALGRADE s 
WHERE 1=0; --복사
ALTER TABLE emp17 DROP COLUMN losal; --삭제
ALTER TABLE emp17 DROP COLUMN hisal; --삭제

--[1단계:코드] 4. emp20 복사테이블을 만들고, 사원명의 최대 byte크기를 확인한 후, char(최대크기)로 변경하세요.
CREATE TABLE emp20
AS SELECT *
FROM EMP e WHERE 1=0;
SELECT max(ename) FROM emp20;

--[1단계:개념] 5. 무결성 제약 조건의 장점과 종류를 예시를 통해서 기술하세요.
/*
 데이터 무결성 제약조건의 장점
 	1) 테이블 생성시 무결성 제약조건을 정의 가능
 		- 생성후 제약 조건 설정도 테이블 구조변경 명령을 통해 가능
 	2) 테이블에 대한 정의, 데이터 딕션너리에 저장되므로 응용프로그램에서
 		입력된 모든 데이터에 대해 동일하게 적용가능
 	3) 제약조건을 확성화/비활성화 할 수 있는 융통성을 가지고있다.
 */
 DROP TABLE student01;
CREATE TABLE student01(
stunum NUMBER(6) CONSTRAINT student01_stunum_pk PRIMARY KEY, --해당 컬럼 값은 반드시 존재해야하며, 유일해야한다.
name varchar2(50) CONSTRAINT student01_name_nn NOT NULL,--해당 컬럼이 null을 포함할 수 없음.
pnum varchar2(14) CONSTRAINT student01_pnum_uq UNIQUE,--테이블의 모든 행에서 고유한 값을 갖는 열 또는 열조합을 지정해야한다.즉, 중복x
gender varchar2(1) CONSTRAINT student01_gender_ck check(gender IN ('F','M')) --해당 컬럼에 저장 가능한 데이터 값의 범위나 조건을 지정처리
);
DROP TABLE BUYPRODUCT11;
CREATE TABLE buyproduct11(
	pnum NUMBER PRIMARY key,
	pname varchar2(50),
	price NUMBER
	);
INSERT INTO buyproduct11 values(1010,'핸드폰',100);
CREATE TABLE buy11(
	bnum varchar2(50),
 	cnt NUMBER,
 	pnum NUMBER CONSTRAINT buy11_pnum_fk REFERENCES buyproduct11(pnum) -- buyproduct11테이블의 값을 참조한다.
);
--[1단계:코드] 6. 물품정보테이블(물품번호, 물건명, 가격, 재고량)을 만들되, 물품번호, 물건명을 not null 제약 조건을 선언하여 생성하고, 생성된 여부를 메타테이블을 통해 확인하세요.
CREATE table product1006(
pnum NUMBER NOT NULL,
pname varchar2(50) NOT NULL,
price NUMBER,
cnt number
);

INSERT INTO product1006 VALUES ('111101','핸드폰',10000,3);
INSERT INTO product1006 VALUES (null,'핸드폰',10000,3); --에러
INSERT INTO product1006 VALUES ('111101',null,10000,3); --에러
--[1단계:코드] 7. 도서대여시스템의 테이블 (도서, 대여, 회원)에서 대여 테이블의 회원아이디와 도서일련번호 두개 컬럼을 primary key로 설정하세요.
--[1단계:코드] 8. 회원테이블(회원아이디, 패스워드, 이름, 권한, 포인트) 권한이 관리자, 일반사용자, 방문객만 입력가능, 포인트가 0이상 입력가능하게 제약사항을 처리해서 테이블을 생성하세요.
--[1단계:코드] 9. 캡쳐로 제시 화면의 ERD의 실제테이블을 제약사항을 적용하여 테이블을 생성하고, 데이터를 입력 확인하세요.
DROP TABLE MEMBER;
DROP TABLE buybook;
DROP TABLE book;

CREATE TABLE member(
id varchar(50) PRIMARY KEY,
authority varchar2(50) CONSTRAINT member_authority_ck check(authority IN ('관리자','일반사용자','방문객')),
name varchar(50),
pass NUMBER,
point NUMBER check(point>=0)
);

INSERT INTO MEMBER VALUES('aoddl56','관리자','이정명',1111,1);
INSERT INTO MEMBER VALUES('aoddl57','일반사용자','이정명1',1111,1);
INSERT INTO MEMBER VALUES('aoddl59','방문객','이정명2',1111,1);
INSERT INTO MEMBER VALUES('aoddl56','일반사용자','이정명3',1111,1); --PRIMARY key 에러
INSERT INTO MEMBER VALUES('aoddl60','일반인','이정명4',1111,1); -- check에러
INSERT INTO MEMBER VALUES('aoddl61','일반사용자','이정명5',1111,0);
INSERT INTO MEMBER VALUES('aoddl62','일반사용자','이정명6',1111,-1); --check에러
SELECT * FROM MEMBER;



CREATE TABLE book(
isbn varchar(50) PRIMARY KEY,
title varchar(50),
writer varchar(50),
price number);

INSERT INTO book VALUES('SS001','별 해는 밤','홍길동',10000);
INSERT INTO book VALUES('SS002','동백꽃 필 무렵','마길동',20000);

CREATE TABLE buybook(
id varchar2(50) CONSTRAINT buybook_id_fk REFERENCES member(id),
isbn varchar2(50) CONSTRAINT buybook_isbn_fk REFERENCES book(isbn)
);
SELECT * FROM BUYBOOK;
INSERT INTO buybook values('aoddl56','SS001');
INSERT INTO buybook values('aoddl57','SS002');

SELECT *
FROM member m,book b, buybook
WHERE m.id=buybook.id
AND b.isbn=buybook.isbn


--[1단계:개념] 10. 시퀀스의 기본 생성 형식과 호출 속성을 정리해보세요.
/*
 create sequence 시퀸스명
		increment by 증가단위
		start with 시작번호
		maxvalue 최대값|nomaxvalue
		minvalue 최소값|nominvalue
		cycle|nocycle - 반복여부 설정
		cache n |nocache --속도 개선을 위해 메모리 캐시 시퀸스 수
 */

--[1단계:코드] 11. 아래의 여러가지 시퀀스를 생성해보세요.
--                1) 9999~1000 2씩 감소  2) 5000~9999 1씩 증가 3) 0~21 3씩 증가 반복 4) 5~1000 5씩 증가
DROP SEQUENCE seq_01;
CREATE SEQUENCE seq_01
START WITH 9999
INCREMENT BY -2
	MINVALUE 1000
	MAXVALUE 9999
	CYCLE 
	cache  10;

DROP SEQUENCE seq_02;
CREATE SEQUENCE seq_02
START WITH 5000
INCREMENT BY 1
	MINVALUE 5000
	MAXVALUE 9999
	CYCLE 
	cache 10;

DROP SEQUENCE seq_03;
CREATE SEQUENCE seq_03
START WITH 0
INCREMENT BY 3
	MINVALUE 0
	MAXVALUE 21
	CYCLE 
	cache 1;

DROP SEQUENCE seq_04;
CREATE SEQUENCE seq_04
START WITH 5
INCREMENT BY 5
	MINVALUE 5
	MAXVALUE 1000
	CYCLE 
	cache 10;
--[1단계:코드] 12. 게시판테이블(번호, 내용)을 만들고, sequence를 만들어 1부터 시작하여 번호가 증가되어 입력되게 처리하세요.
DROP TABLE NOTEBOARD;
CREATE TABLE noteBoard(
num NUMBER PRIMARY key,
name varchar2(50)
);


SELECT * FROM noteBoard;
INSERT INTO noteBoard values(1,null);

DROP SEQUENCE seq_05;
CREATE SEQUENCE board_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 99999;
INSERT INTO noteBoard values(board_seq.nextval,'내용'||board_seq.currval);
SELECT * FROM noteBoard;
--[1단계:개념] 13. DML의 종류를 기술하세요.
/*
#데이터 조작어 (Data Manipulation Language)
테이블에 새로운 데이터를 입력하거나 기존 데이터를 수정또는 삭제하기 위한 명령어이다.
종류
	insert : 입력처리
	update : 수정처리
	delete : 삭제처리
	merge : 병합처리 명령어(논리적 테이블의 병합/수정과 동시에 입력)
	*/
/*
== 평가대비(오라클) 객관식 문제 ==
1. 테이블의 구조를 변경하는 명령어는? 2번
1) alter table 테이블명  
2) update  table 테이블명 ??
3) create table 테이블명  테이블 생성
4) drop table 테이블명  테이블 삭제
정답:1

2. 무결성 제약 조건의 종류가 아닌 것은? 3번
1) not null -null불가
2) unique - 고유 값 지정
3) second key ??
4) foreign key 다른 테이블의 값 참조
정답:3

3. 아래 설명중 틀린 것은 무엇인가? 2번
1) 테이블 생성시 무결성 제약조건을 정의 가능
2) not null 제약은 기존 데이터를 NULL로 수정하는 경우에는 가능 (불가하다)
3) 테이블레벨이 아닌 열 레벨로만 지정가능하다 
4) 제약조건을 활성화, 비활성화 할 수 있는 융통성애 있음
정답:2

4. 데이터 무결성 제약조건의 장점이 아닌 것은?1번
1) 테이블 생성시만 제약조건이 가능하므로 일관성을 확보 - 생성후에도 제약 가능함 
2) 응용 프로그램에서 입력된 모든 데이터에 대해 동일하게 적용
3) 제약조건을 활성화, 비활성화 할 수 있는 융통성
4) 테이블 생성시 무결성 제약조건을 정의 가능
정답:1

5. 시퀀스의 속성 아닌 것은? 4번
1) increment by
2) start with
3) minvalue
4) circle -cycle이다.
정답:4 */
