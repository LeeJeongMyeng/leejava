DROP TABLE marketUSER;
CREATE TABLE marketUSER(
userno varchar2(20) PRIMARY key,
div varchar2(20) CONSTRAINT marketUSER_div_ck check(div IN ('관리자','회원')),
username varchar2(20),
rrn varchar2(14),
address varchar2(100),
phonenumber varchar2(13),
id varchar2(20),
password varchar2(20),
point number
);
--userno,div,username,rrn,address,phonenumber,id,pass,point--
SELECT * FROM MARKETUSER WHERE USERNAME LIKE '%르%';

SELECT * FROM MARKETUSER;


-- 마켓회원 번호용 시퀀스
DROP SEQUENCE marketuser_seq;
CREATE SEQUENCE marketuser_seq;
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;

--마켓 회원가입용 쿼리
INSERT INTO MARKETUSER values(to_char(?||marketuser_seq.nextval),?,?,?,?,?,?,?,?);
INSERT INTO MARKETUSER values(to_char('Mgr-'||marketuser_seq.nextval),'관리자','이정명','950828-1861529','창원시 성산구','010-5293-0247','aoddl56','!dnfwlq12',1000);

SELECT * FROM MARKETUSER;

SELECT * FROM MARKETUSER
WHERE id='aoddl56'
AND PASSWORD ='!dnfwlq12';

--이름 주민 중복조회용 메서드
SELECT COUNT(*) FROM  MARKETUSER WHERE username='이정명' AND rrn='950828-1861529';
--아이디 중복조회
SELECT count(*) FROM MARKETUSER WHERE id='aoddl56';

SELECT password FROM MARKETUSER WHERE USERNAME = '이정명' AND rrn = '950828-1861529';

DELETE marketuser
WHERE username = '이정명'
AND rrn = '950828-1861529'
AND id = 'aoddl56';

