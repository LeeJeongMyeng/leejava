--배송하기 테이블 
DROP TABLE ship;
CREATE TABLE ship(
shipno varchar2(20) PRIMARY KEY,
shipdate DATE,
rentalno varchar2(20) CONSTRAINT ship_rentalno_fk REFERENCES rental(rentalno),
userno varchar2(10) CONSTRAINT ship_userno_fk REFERENCES bookuser(userno));

SELECT * FROM ship;

SELECT SHIPNO 배송등록번호, shipdate 배송날짜, RENTALNO 도서대여고유번호, USERNO 회원번호 FROM SHIP s 

DROP SEQUENCE ship_seq;
CREATE SEQUENCE ship_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;

SELECT * FROM ship;

INSERT INTO ship 
SELECT 'Ship-'||ship_seq.nextval,sysdate+2,RENTALNO,USERNO FROM RENTAL
WHERE isbn ='200-31';

FROM RENTAL r 
WHERE isbn = '000-32';

-- 배달하기 확인
SELECT SHIPWHETHER  FROM rental WHERE isbn = '100-41';
										
-- 배달테이블 기입용 쿼리
SELECT rentalno,userno,RENTDATE FROM RENTAL r
WHERE ISBN = '000-32';

-- 배달테이블 기입용 배송날짜 쿼리

SELECT shipno 배송고유번호, shipdate 배송날짜, rentalno 도서대여고유번호, userno 회원고유번호
FROM ship;

--반납하기로 대여테이블 정보 삭제전 배송테이블 내용삭제
DELETE ship
WHERE userno = 'Member-25';



