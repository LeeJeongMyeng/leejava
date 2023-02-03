DROP TABLE BookUser;

CREATE TABLE BookUser(
USERno varchar2(20) PRIMARY KEY, --회원 번호
div varchar2(20) CONSTRAINT BookUser_div_ck check(div IN ('관리자','회원')), -- 구분(관리자/회원)
username varchar2(20), -- 회원이름
rrn char(14), --주민등로번호
address varchar2(100), -- 주소
Phone_Number char(13), --전화번번호/ -까지 포함하여 15자리할지 고민
id varchar2(20), --회원 아이디
password varchar2(20), -- 회원 패스워드
rentalcnt NUMBER, -- 대여 횟수
returnwarning number
);



SELECT * FROM BookUser;
SELECT userno 회원번호, div 사용자구분, USERNAME 회원이름, rrn 주민번호, address 주소, PHONE_NUMBER 전화번호, id,PASSWORD , RENTALCNT 대여횟수, RETURNWARNING 연체경고횟수
FROM BOOKUSER ;

SELECT userno 회원번호 FROM BOOKUSER b ;

-- 회원 번호용 시퀀스
DROP SEQUENCE Muser_seq;
CREATE SEQUENCE Muser_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;


INSERT INTO BOOKUSER values(to_char(?||Muser_seq.nextval),?,?,?,?,?,?,?,?);
INSERT INTO BOOKUSER values(Muser_seq.nextval,?,?,?,?,?,?,?,?);

-- 이름 중복조회쿼리 
SELECT count(*) FROM BOOKUSER
WHERE id = 'aoddl56';


-- 아이디 중복조회 쿼리
SELECT count(*)  FROM BOOKUSER 
WHERE USERNO  = 'Member-4';
AND rrn = '950828-1111111';


SELECT * FROM BOOKUSER 
WHERE id = 'aoddl56'
AND password = '1111';

INSERT INTO BOOKUSER values('m'||Muser_seq.nextval,
							'회원',
							'이지은',
							'950828-111111',
							'서울 양천구 목동',
							01052930247,
							'aoddl25',
							'1111',0);
						
						
-- 로그인 기능 처리
SELECT DIV  FROM BOOKUSER
WHERE id='aoddl56'
AND PASSWORD ='!dnfwlq12';

--회원정보 전체 조회
SELECT * FROM BOOKUSER b 
WHERE username LIKE '%'||'길동'||'%';
--회원정보 이름으로 검색
SELECT userno,div,username,ADDRESS,PHONE_NUMBER,ID,RENTALCNT,RETURNWARNING FROM BOOKUSER b 
WHERE username = '이정명';
--회원이름으로 회원번호검색
SELECT USERNO FROM BOOKUSER b2 
WHERE USERNAME='';
--비밀번호 찾기
SELECT password FROM BOOKUSER b 
WHERE username = '이지은'
AND rrn = '950828-1111111';

--회원 탈퇴
DELETE bookuser
WHERE username = '룰루'
AND rrn = '950828-1861529'
AND id = 'fnffn';

SELECT count(*) FROM BOOKUSER
WHERE username = '이지은';

-- 회원 대여횟수 조회
SELECT rentalcnt FROM BOOKUSER
where username = '이지은';

UPDATE BOOKUSER 
SET returnwarning  = returnwarning+ 1
WHERE USERNO = 'Member-27'
AND SYSDATE > (SELECT RETURNDATE FROM rental
WHERE isbn = '600-61'
AND returnwhether ='대여중');

SELECT * FROM BOOKUSER b ;
SELECT userno 회원번호, div 구분자, USERNAME 회원이름, rrn 주민번호, ADDRESS 주소, PHONE_NUMBER ,
FROM BOOKUSER b 

UPDATE BOOKUSER
SET RENTALCNT  = 0
WHERE username = '이지은';



SELECT username,rentalcnt FROM BOOKUSER;

UPDATE BOOKUSER 
SET RENTALCNT  = 0
WHERE username = '이지은';

--연체자 조회기능
SELECT userno,div,username,phone_number,rentalcnt,returnwarning
FROM BOOKUSER b
WHERE RETURNWARNING >=1;

SELECT returnwarning FROM BOOKUSER
WHERE userno ='Member-25';

UPDATE BOOKUSER 
SET RENTALCNT =0,
	RETURNWARNING =0;
-- 회원 정보 변경
UPDATE BOOKUSER 
SET ADDRESS ='마산',
	PHONE_NUMBER ='010-9636-6225'
WHERE USERNAME  ='찌니'
AND RRN ='941212-2222222';

UPDATE BOOKUSER 
SET PASSWORD  ='마산'
WHERE USERNAME  ='찌니'
AND RRN ='941212-2222222';

SELECT COUNT(*) FROM BOOKUSER b 
WHERE USERNAME =''
AND RRN ='';

UPDATE BOOKUSER 
SET RENTALCNT = 89
WHERE username = '벨르'