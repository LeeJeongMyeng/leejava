DROP TABLE BOOKINFO ;
CREATE TABLE BookInfo(
isbn varchar2(20) PRIMARY KEY, --도서등록번호1
bname varchar2(100), --책이름2
genre varchar2(20), --장르3
publisher varchar2(20), --출판사4
writer varchar2(20), --저자5
price number, --가격6
registdate date, -- 등록일자7
rentalwhether varchar2(20) CONSTRAINT BookInfo_rentalwhether_ck check(rentalwhether IN ('대여가능','대여중')) -- 대여여부9
);

DROP SEQUENCE Books_seq;
CREATE SEQUENCE Books_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;

DROP TABLE BOOKINFO ;
--책분류
--총류 000	철학 100		종료 200		사회과학 300 		자연과학400
-- 기술과학 500 	예술 600		언어700  문학800 		역사900

-- 시퀀스
--책 등록
INSERT INTO bookinfo values('100-'||to_char(Books_seq.nextval),'까까까까까'
,'소설','우리집'
,'낄낄',20000
,SYSDATE,'대여가능');

SELECT isbn 도서등록번호, bname 도서이름, GENRE 도서분류, PUBLISHER 출판사, WRITER 저자, PRICE 가격, REGISTDATE 도서등록일자, RENTALWHETHER 대여상태
FROM BOOKINFO b ;

SELECT * FROM BOOKINFO;
WHERE bname LIKE '%'||'하'||'%';

--도서수정
UPDATE BOOKINFO 
SET BNAME ='dd',
	publisher='dd',
	writer='dd',
	price=10000,
	registdate=SYSDATE  
WHERE isbn='100-2';
	
--대여상태 수정
	UPDATE BOOKINFO 
	SET RENTALWHETHER ='';

-- 도서등록번호로 조회
SELECT * FROM BOOKINFO b ;
WHERE ISBN ='100-2';
SELECT count(*) FROM BOOKINFO b
WHERE isbn = '000-49';
--도서삭제(isbn)
DELETE BOOKINFO
WHERE isbn = '200-31';

SELECT bname FROM BOOKINFO
WHERE isbn = '100-5';

SELECT  * FROM BOOKINFO;
WHERE ISBN = '000-6';

--대여중인지 확인
SELECT rentalwhether FROM BOOKINFO b 
WHERE isbn = '100-41';

--대여중으로 변경 
UPDATE BOOKINFO SET RENTALWHETHER ='대여가능'
WHERE ISBN='100-50';

SELECT * FROM BOOKinfo;



-- 확인증용 쿼리
SELECT b.USERNAME , b2.BNAME ,r.RETURNDATE,r.SHIPWHETHER,b.ADDRESS,SYSDATE+2 s2,b2.PRICE 
FROM BOOKUSER b , BOOKINFO b2 ,RENTAL r 
WHERE b.USERNO = r.USERNO 
AND b2.ISBN = r.ISBN 
AND b.USERNO = 'Member-27'
AND b2.ISBN ='200-57'
AND r.RETURNWHETHER = '대여중';

--업데이트문 다시
UPDATE BOOKINFO 
SET bname = '수정샘플',
    PUBLISHER ='샘플나라',
    WRITER ='이정명',
    PRICE ='12345',
    REGISTDATE = SYSDATE
 WHERE isbn = '100-50';
 
SELECT * FROM BOOKINFO b ;

--
SELECT * FROM BOOKINFO b 
WHERE GENRE = '역사';

SELECT * FROM MEMBER;
