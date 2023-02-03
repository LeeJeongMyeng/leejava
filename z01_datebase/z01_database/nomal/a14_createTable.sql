/*
  #데이터베이스 테이블 생성과 활용
  	1. 기본 형식
  		create table 테이블명(
  			컬럼명 데이터유형 제약조건
  		);
  	ex) 회원테이블
  		create table member(
  			if varchar2(20) primary key, --중복 및 null방지
  			pass varchar2(20) not null, -- 반드시 입력되야함
  			name varchar2(50) not null,
  			point number,
  			grade char(1) --등급 정보로 고정형 A,B,C
  			);
  # 데이터 유형
  	1. 문자열
  		1) 고정형 문자열 : char(크기)
  			크기가 일정한 문자 데이터 유형
  			최대 크기: 2000바이트
  			ex) char(10) : 10byte 고정
  			
  		2) 가변형 문자열 : varchar2(크기)
  		 	크기가 가변적인 문자열 데이터 유형으로, 최대 크기:4000바이트
  		 	ex) varchar2(10) : 1byte~10byte 저장
  		3) 숫자형 : number(p,s)
  			정밀도(p)와 스케일s로 표현되는 숫자 데이터 타입	
  			p: 1~38
  			s: -84~127
  		4) 날짜형 : date
  			날짜형식을 저장하기 위한 데이터 타입
 */

 create table MEMBER(
 id varchar2(20) primary key, --중복 및 null방지
 pass varchar2(20) not null, -- 반드시 입력되야함
 name varchar2(50) not null,
 point number,
 grade char(1) --등급 정보로 고정형 A,B,C
  			);
  			
 
 INSERT INTO MEMBER VALUES('himan','7777','홍길동',1000,'A');
 SELECT * FROM MEMBER;

--ex) 물건정보테이블을 만들되 물건의 일련번호(8자리 고정)을 포함하여
-- 	물건명, 가격, 제품소개를 입력할 수 있는 테이블을 만들고, 위
-- insert구문을 활용하여 데이터 3개를 입력 후 조회하세요

-

create TABLE product(
	isbn char(8),
	name varchar2(50),
	price number,
	intro varchar2(500)
);
SELECT *FROM product;


-- 1:다 관계의 연관관계 테이블 생성
-- 특정한 회원이 구매한 물건 :buyproduct
-- 속성 도출 : 구매한 회원 아이디, 구매할 물건 아이디, 구매할 갯수, 구매한 날
/*
 # 테이블의 데이터 입력 형식(DML)
  1. 기본 형식
  	1) 전체 데이터 입력 :  생성된 컬럼순위로 데이터 유형에 맞게 입력
  	insert into 테이블명 values(데이터1, 데이터2...)
  	ex) 사원테이블
  	insert into emp 
  	velues(2000,'홍길동','사원',7000,sysdate,3000,1000,10);
  	컬럼의 고유 순서대로 데이터를 입력 처리한다.
  	
  	2) 부분 특정 컬럼 입력 : 특정한 컬럼을 지정하여 입력한다.
  		insert into emp(empno, job, deptno) values(1001,'대리',20);
  		emp(입력할 컬럼 순서 지정) values(왼쪽에 선언한 컬럼 순서대로 데이터 입력)
  		
  	3) 제약 사항 :
  		primary key 등 무결성 제약사항이 있으면 해당 제약 사항에 벗어나지
  		않게 입력해야한다.
  		ex) insert into emp(empno) values(1001);
  		이전 데이터가 1001데이터가 있으므로 primary key 제약에 걸려 입력하지 못한다.
 */
-- 연습용 복사테이블에 만들기
CREATE TABLE emp10
AS SELECT * FROM emp;
SELECT * FROM emp10; --cntl+테이블 클릭

-- 전체 데이터 입력
INSERT INTO emp10 values(8000,'홍길동','사원',7902,sysdate,3500,100,10);
--ex) 사원 정보를 emp10에 임의로 입력해보세요
INSERT INTO emp10 values(8001,'이정명','대리',7903,to_date('2022-01-01','yyyy-mm-dd'),3600,100,20);

-- 부분컬럼 입력
INSERT INTO emp10(empno,ename, DEPTNO) values(8002,'오길동',20);
-- 삭제명령
DELETE FROM emp10 WHERE EMPNO = 8000;
DELETE FROM emp10 WHERE EMPNO = 8001;
SELECT * FROM EMP10;
--ex) 사원번호,직책, 2000-12-31 부분입력
INSERT INTO emp10(empno,job,hiredate) values(8002,'GOODMAN',TO_DATE('2022-12-31','YYYY-MM-DD'));



/*
 # 테이블 설계 및 구현
 	1. 요구사항 정의서와 entity(개체) 확인 및 도출
 	2. entity타입 결정
 	3. erd모델링
 		1) 개별 entity type생성
 		2) 연관 관계 설정
 			- 식별관계 : 연관 관계 테이블의 key사용할 때
 			- 비식별관계 : 연관 관계 테이블에 key로 사용하지 않을 때.
 		3) 논리설계/물리설계
 		------------------------------
 	4. 테이블 생성
 	5. 데이터 입력 및 확인
 		1)join 관계로 여러가지 sql처리
 */
-- 테이블 삭제 명령어 drop table 테이블명;\
DROP TABLE product;
CREATE TABLE member(
	id varchar2(30),
	pass varchar2(20),
	name varchar2(50),
	auth varchar2(20),
	point NUMBER,
	address varchar2(200) );

CREATE TABLE product (
isbn char(8),
name varchar2(20),
price NUMBER,
intro varchar2(500)
);

CREATE TABLE buyproduct(
id varchar2(30),
isbn char(8),
cnt NUMBER,
buydate date);

INSERT INTO product values('PRD10000','PHONE',2000,'사람들과 통화할 수있습니다.');
INSERT INTO product values('PRD10001','notebook',10000,'휴대용 컴퓨터');
INSERT INTO product values('PRD10002','desktop',100000,'고정형 컴퓨터');

SELECT * FROM MEMBER;
SELECT * FROM PRODUCT;
SELECT * FROM buyproduct;
INSERT INTO MEMBER values('himan','7777','홍길동','슈퍼고객',10000,'서울');
INSERT INTO MEMBER values('higirl','8888','홍리나','일반고객',5000,'부산');
INSERT INTO MEMBER values('goodman','5555','이철희','방문고객',1000,'대전');

--PRD10000 사과
--PRD10001 바나나
--PRD10002 딸기
INSERT INTO buyproduct values('himan','PRD10000',5,sysdate);
INSERT INTO buyproduct values('himan','PRD10001',3,sysdate);
INSERT INTO buyproduct values('himan','PRD10002',3,sysdate);
INSERT INTO buyproduct values('higirl','PRD10002',2,sysdate);
INSERT INTO buyproduct values('goodman','PRD10002',1,sysdate);
SELECT * FROM buyproduct;
SELECT *FROM MEMBER;
SELECT * FROM product;
--ex) join관계에 의해 himan이 구매한 구매자 아이디,물건명, 가격, 갯수를 출력하세요
SELECT m.ID ,m.name,p.name,price,cnt,
price*cnt "총계" --유도 속성이다.
FROM MEMBER m, BUYPRODUCT b,PRODUCT p
WHERE m.ID =b.id --member와 buyproduct연결
AND b.isbn=p.isbn; --buyproduct와 product연결

-- 실습 예제 고객/구매/책
CREATE TABLE person(
id varchar2(50),
name varchar2(50),
point number);

INSERT INTO person values('aoddl56','이정명',200);
SELECT * FROM person

CREATE TABLE buyproduct2(
id varchar2(50),
isbn varchar2(50),
buydate DATE,
payment varchar2(50));

INSERT INTO buyproduct2 values('aoddl56','SS001',
				TO_DATE('2022-10-05','YYYY-MM-DD'),'카드결제');
 
SELECT * FROM buyproduct2 ;
			
CREATE TABLE book(
isbn varchar2(50),
title varchar2(50),
writer varchar2(50),
price number);

INSERT INTO book values('SS001','별 헤는 밤','이정명',30000);
SELECT * FROM BOOK ;

SELECT p.id,p.name,book.title,b.buydate
FROM person p, buyproduct2 b, book
WHERE p.id=b.id
AND b.isbn=book.isbn;

--person은 고객정보 저장
--book은 판매하는 물품정보 저장
--buyproduct2는 고객이 구매한 물품정보를 양쪽 테이블의 key와 추가 속성인
--           날짜, 구매방법등을 기준으로 생성