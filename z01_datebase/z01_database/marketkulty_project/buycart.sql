DROP TABLE buycart;
CREATE TABLE buycart(
buyno varchar2(25) PRIMARY KEY,
userno varchar2(20) CONSTRAINT buycart_userno_fk REFERENCES marketuser(userno),
isbn varchar(20) CONSTRAINT buycart_isbn_fk REFERENCES product(isbn),
buycount NUMBER,
totprice NUMBER
);
-- buyno,userno,isbn,buycount,totprice
-- 장바구니용 시퀀스
DROP SEQUENCE buycart_seq;
CREATE SEQUENCE buycart_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;

INSERT INTO ship 
SELECT 'Ship-'||ship_seq.nextval,sysdate+2,RENTALNO,USERNO FROM RENTAL
WHERE isbn ='200-31';

INSERT INTO buycart
SELECT 'cart-'||buycart_seq.nextval,'Mgr-22',p.ISBN ,2,p.PRICE*2
FROM PRODUCT p WHERE p.isbn ='pants-10';

SELECT p.PRODUCTNAME, b.BUYCOUNT, b.TOTPRICE  FROM buycart b,PRODUCT p 
WHERE b.ISBN =p.ISBN 
AND USERNO ='Member-23';

SELECT m.USERNAME ,  FROM BUYCART b , PRODUCT p , MARKETUSER m 

SELECT * FROM BUYCART b ;

DELETE buycart
WHERE userno='Member-23'
AND isbn=(SELECT isbn
			FROM PRODUCT p
			WHERE PRODUCTNAME ='배추');




SELECT * FROM emp100;

DELETE buycart
WHERE userno='Member-23';



