/*
 # 데이터 무결성 제약조건
 1. 목적
 	- 데이터의 정확성과 일관성을 보장하기 위함
 	
 2. 데이터의 정확성을 유지하여 다양한 종류의 업무규칙울 고려함
 	1) 학생테이블에 학년 데이터는 1,2,3,4 중의 하나만 입력
 	2) 모든 학번은 유일하게 처리
 	3) 학생테이블의 지도교수 번호는 지도교수테이블의 교수번호중의 하나로만 추가 변경가능
 	
 3. 데이터 무결성 제약조건의 장점
 	1) 테이블 생성시 무결성 제약조건을 정의 가능
 		- 생성후 제약 조건 설정도 테이블 구조변경 명령을 통해 가능
 	2) 테이블에 대한 정의, 데이터 딕션너리에 저장되므로 응용프로그램에서
 		입력된 모든 데이터에 대해 동일하게 적용가능
 	3) 제약조건을 확성화/비활성화 할 수 있는 융통성을 가지고있다.
 
 4. 무결성 제약조건의 종류
 	1) not null: 해당 컬럼이 null을 포함할 수 없음. 즉, 반드시 데이터를 입력해야하는 컬럼 지정
 	2) unique key : 테이블의 모든 행에서 고유한 값을 갖는 열 또는 열조합을 지정해야한다.
 					ex)학번, 주민번호, 사원번호를 중복하지 않아야한다.
 					 -null을 처리가 가능하고, null은 중복이 가능하다.
 	3) primary key : 해당 컬럼 값은 반드시 존재해야하며, 유일해야한다.
 					not null+unique key가 결합된 형태이다.
 					주로 테이블에서 식별해야할 컬럼 즉, key를 지정할 때 사용된다.
 	4) foreign key : 한 열과 참조된 테이블의 열간에 외래 키 관계를 설정하고 시행
 					ex) 사원테이블의 부서번호는 반드시 부서테이블에 있는 부서번호 이어야한다.
 	5) check : 해당 컬럼에 저장 가능한 데이터 값의 범위나 조건을 지정처리
 					ex) 학생 테이블의 학년은 1~4만  데이터로 입력/수정 할 수 있다.

5. 설정형식
	1) 테이블 생성이나 구조 변경시, 추가옵션 설정
		컬럼명 데이터타입 constraint 제약조건명 제약조건
		제약조건명: 일반적으로 제약조건명은 '테이블명_컬럼명_제약조건종류약어'로 선언한다.
			ex) emp_empno_pk : 사원테이블의 사원번호를 primary key로 설정함.
				을 포함하는 내용이다.

6. 제약조건 설정의 내용을 확인하는 메타테이블
	1)sys.all_constraints : db시스템에 있는 제약정보의 메타 테이블
 */
SELECT * FROM sys.ALL_CONSTRAINTS;
SELECT * FROM sys.ALL_CONSTRAINTS ac 
WHERE CONSTRAINT_NAME =upper('student01_name_nn');
--not null
DROP TABLE student01;
CREATE TABLE student01(
name varchar2(30) CONSTRAINT student01_name_nn NOT NULL
);
INSERT INTO student01 values('홍길동');
INSERT INTO student01 values(null); -제약조건에따라 에러발생

--ex) student02테이블에 학생번호,이름,국어, 영어,수학 점수로 컬럼 설정하고, 데이터를 입력해보세요
CREATE TABLE student02(
stunum NUMBER PRIMARY KEY,
name varchar2(20) CONSTRAINT student02_name_nn NOT NULL,
kor NUMBER,
eng NUMBER,
math number);

SELECT * FROM sys.ALL_CONSTRAINTS ac 
WHERE CONSTRAINT_NAME LIKE 'student02%';

INSERT INTO student02 values(020101,'이정명',80,90,70);
INSERT INTO student02(stunum,name) values(020102,'마길동');
INSERT INTO student02(name,kor) values('무길동',80); --에러발생_primary인 number가 빠져잇음
INSERT INTO student02(stunum,kor) values(2,90); --에러발생_not null인 name이 빠져잇음

SELECT * FROM student02;

-- nuique
DROP TABLE student03;
CREATE TABLE student03(
sno NUMBER CONSTRAINT student03_sno_uq UNIQUE,
name varchar2(50)
);
INSERT INTO student03 values(1,'홍길동');
INSERT INTO student03 values(2,'김길동');
INSERT INTO student03 values(NULL,'마길동');
INSERT INTO student03 values(NULL,'오길동');
INSERT INTO student03 values(2,'신길동'); --에러발생
SELECT * FROM student03;
SELECT *
FROM sys.ALL_CONSTRAINTS ac 
WHERE CONSTRAINT_NAME LIKE 'student03%';
--ex) employee01에 사원번호, 사원명, 급여 설정 ==> 사원번호는 unique/ 사원명 nou null제약조건
CREATE TABLE employee01(
empno NUMBER CONSTRAINT employee01_empno_uq UNIQUE,
name varchar2(50) CONSTRAINT employee01_name_nn NOT NULL,
sal number);

INSERT INTO employee01 values(0001,'홍길동',100);
INSERT INTO employee01 (empno,name) values(null,'마길동');
INSERT INTO employee01 (empno,name) values(null,'홍길동');
INSERT INTO employee01 (empno,name) values(0001,'홍길동'); --에러
INSERT INTO employee01 (name,sa) values('김길동',200); --에러
INSERT INTO employee01  values(0002,null,200); --에러
SELECT * FROM employee01;

-- primary key : not null + unique
CREATE TABLE employee02(
	empno number(4) PRIMARY KEY --제약조건 이름을 지정하지않음.
	);

CREATE TABLE employee03(
	empno number(4) CONSTRAINT employee03_empno_pk PRIMARY KEY
	); --제약조건 이름 지정
INSERT INTO employee02 values(1000);
INSERT INTO employee02 values(null); --에러발생
INSERT INTO employee02 values(1000); --에러발생
SELECT *
FROM sys.all_constraints
WHERE TABLE_name in('employee02','employee03');

--ex) 
CREATE TABLE student04(
stunum NUMBER(6) CONSTRAINT student04_stunum_pk PRIMARY KEY,
name varchar2(50) CONSTRAINT student04_name_nn NOT NULL,
pnum varchar2(14) CONSTRAINT student04_pnum_uq UNIQUE,
kor NUMBER,
eng NUMBER,
math number
);

INSERT INTO student04 values(030101,'홍길동','950828-1111111',90,100,20);
SELECT * FROM student04;

--컬럼두개를 기준으로 프라이머리키를 설정하는 경우
--하단에 constraint 제약조건명 조약조건유형(컬럼1,2..)
CREATE TABLE buybook(
id varchar2(30),
isbn char(10),
buydate DATE,
paycheck varchar2(20),
CONSTRAINT buybook_id_isbn_pk PRIMARY key(id,isbn)
);
--참조컬럼을 키로 사용하는 경우 ==> 식별관계로 설정하는 것을 말한다.
SELECT *
FROM sys.ALL_CONSTRAINTS
WHERE table_name = 'buybook';
SELECT * FROM buybook;

/*
 *#check
 *1.컬럼명 데이터 유형 constrint 제약명
  	check( where조건문 형식 동일)
  	* 주의) check는 null입력이 가능하다.
  	* 
  	ex) 'A','B','C'라는 3가지 문자열로된 등급만 입력가능하게 CHECK처리
  	grade char(1) constrint emp_grade_ck check(grade in('A','B','C'))
  	
  	ex) 0~100
  	point number(3) check check(point between 0 and 100)
  	
  	ex) 과목(subject)을 국어,영어,수학만 입력하게 정의
  	subject char(6) check(subject in('국어','영어','수학'))
  	
 */
*/