DROP TABLE program;
CREATE TABLE program(
prono varchar2(20) PRIMARY key,
proname varchar2(100),
prodate DATE,
userno varchar2(20) CONSTRAINT program_userno_fk REFERENCES bookuser(userno),
proexplan varchar2(4000)
);
-- prono, proname, prodate , userno, proexplan
DROP SEQUENCE program_seq;
CREATE SEQUENCE program_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;

SELECT * FROM PROGRAM p ;
SELECT proname FROM PROGRAM p WHERE PRONO ='P3';

INSERT INTO PROGRAM VALUES ('P'||program_seq.nextval,'프로그램명',to_date('2022-10-01','yyyy-mm-dd'),'MGR-26','프로그램설명');

DELETE PROGRAM WHERE PRONO ='P3';

-- 경고5회 이하 회원중, 대여횟수가 가장높은 순으로 정렬
SELECT USERNO ,USERNAME ,RENTALCNT,RETURNWARNING  FROM BOOKUSER 
WHERE RETURNWARNING < 5
AND div = '회원'
ORDER BY RENTALCNT DESC;

-- 회원중 경고횟수 5회이하, 대여횟수가 가장높은 순으로 3개 출력
SELECT USERNO ,USERNAME ,RENTALCNT,RETURNWARNING
FROM (
SELECT USERNO ,USERNAME ,RENTALCNT,RETURNWARNING  FROM BOOKUSER 
WHERE RETURNWARNING < 5
AND div = '회원'
ORDER BY RENTALCNT DESC)
WHERE rownum<=3;





