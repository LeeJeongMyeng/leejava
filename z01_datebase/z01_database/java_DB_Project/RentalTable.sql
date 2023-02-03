DROP TABLE rental;
CREATE TABLE rental(
rentalno varchar2(20) PRIMARY KEY,
userno varchar2(20) CONSTRAINT rental_userno_fk REFERENCES bookuser(userno),
isbn varchar2(20) CONSTRAINT rental_isbn_fk REFERENCES bookinfo(isbn),
shipwhether varchar2(20) CONSTRAINT rental_shipwhether_ck check(shipwhether IN ('배송신청','배송미신청')),
rentDate DATE,
returndate DATE,
returnwhether varchar2(20) 
);
-- rentalno, userno, isbn, shipwhether, rentdate, returndate, returnwhether
SELECT * FROM rental;

SELECT * FROM rental;
SELECT USERNO  FROM BOOKUSER
WHERE USERNAME  = '이정명';

DROP SEQUENCE rental_seq;
CREATE SEQUENCE rental_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;

INSERT INTO rental values('Rent-'||rental_seq.nextval,?,?,?,sysdate,sysdate+?,?); 
INSERT INTO rental values('Rent-'||rental_seq.nextval,
							'MGR-3','000-6','배송신청',
							TO_DATE('2020/09/01','YYYY/MM/DD'),TO_DATE('2020/09/01','YYYY/MM/DD')+7,
							'대여중'); 

-- 대여여부 확인코드
SELECT rentDate,returndate, TO_NUMBER(SYSDATE-returndate) div ren FROM rental;

UPDATE RENTAL
SET RETURNWHETHER = NULL
FROM 



-- 대여확인 테이블
SELECT rentDate,returndate FROM RENTAL r,BOOKUSER b 
WHERE r.userno = b.USERNO
AND username = '이정명';

--대여상태 갱신하기

UPDATE RENTAL
SET RETURNWHETHER =
CASE
WHEN RETURNDATE-SYSDATE  >=0 THEN '대여중'
WHEN RETURNDATE  -SYSDATE  <0 THEN '미반납 및 연체'
END
WHERE RETURNWHETHER != '반납완료'
OR RETURNWHETHER  is NULL
OR RETURNWHETHER != '반납완료(연체)';


UPDATE RENTAL 
SET returndate  = TO_DATE('2022-10-20','yyyy-mm-dd')
WHERE ISBN = '100-82';

SELECT * FROM RENTAL;

SELECT * FROM RENTAL r;

UPDATE RENTAL 
SET RETURNWHETHER = '.'
WHERE ISBN = '100-21';

UPDATE RENTAL
SET RETURNDATE = returndate+7
WHERE ISBN = '900-52'
AND USERNO =''
AND RETURNWHETHER = '대여중';


UPDATE RENTAL
SET RETURNWHETHER =
CASE
WHEN RETURNDATE-SYSDATE  >=0 THEN '반납완료'
WHEN RETURNDATE -SYSDATE  <0 THEN '반납완료(연체)'
END
WHERE ISBN  = '100-24'
AND RETURNWHETHER ='대여중'
OR returnwhether ='미반납 및 연체';


DELETE RENTAL
WHERE isbn = '100-82';

SELECT * FROM RENTAL r ;

UPDATE RENTAL 
SET RETURNWHETHER = '대여중'
WHERE isbn ='200-31';

SELECT RENTALNO 도서대여고유번호, USERNO 회원고유번호, isbn 도서등록번호, SHIPWHETHER 배송신청여부, RENTDATE 대여날짜,
		RETURNDATE 반납날짜, RETURNWHETHER 현재대여상태
FROM RENTAL r ;

--해당도서와 회원이 존재하는지 여부파악
SELECT count(*) FROM BOOKUSER b ,BOOKINFO b2 
WHERE b.USERNO = 'Member-25'
AND b2.ISBN = '200-51';

--대여 테이블에 해당도서가 대여중이며 존재하는지 확인
SELECT COUNT(*) FROM RENTAL r 
WHERE ISBN ='sss'
AND userno='sss'
AND RETURNWHETHER ='대여중';

SELECT count(*) FROM BOOKINFO b
WHERE isbn = '000-49'
AND RENTALWHETHER = '대여가능';

SELECT SHIPWHETHER  FROM rental 
WHERE isbn = ''
AND RETURNWHETHER ='대여중';

SELECT isbn,returndate,returnwhether FROM RENTAL
WHERE RETURNWHETHER ='대여중'
OR  returnwhether = '미반납 및 연체'
AND userno = '900-84';

SELECT isbn,returndate, returnwhether FROM RENTAL r
WHERE userno = '900-84'
AND RETURNWHETHER = '대여중'
OR RETURNWHETHER = '미반납 및 연체';

SELECT COUNT(*) FROM RENTAL 
WHERE ISBN ='900-84'
AND userno='Member-47'
AND RETURNWHETHER ='대여중'
OR returnwhether='미반납 및 연체'

SELECT * FROM RENTAL r ;

UPDATE BOOKUSER 
			SET returnwarning  = returnwarning+ 1
			WHERE USERNO = ''
			AND SYSDATE > (SELECT RETURNDATE FROM rental
			WHERE isbn = ''
			AND returnwhether ='대여중'
			OR returnwhether='미반납 및 연체');
		
		
SELECT * FROM dept100
WHERE deptno=99
AND dname='게임';
