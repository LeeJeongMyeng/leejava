DROP TABLE Product;
CREATE TABLE product(
isbn varchar2(20) PRIMARY key,
fication varchar2(20),
productname varchar2(100) UNIQUE,
price NUMBER,
information varchar2(2000),
company varchar2(50),
regisdate date
);


SELECT * FROM PRODUCT;

-- 물건번호용 시퀀스
DROP SEQUENCE product_seq;
CREATE SEQUENCE product_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;

INSERT INTO product values('pants-'||product_seq.nextval,'야채','배추',900,'배추에용','제조사땅땅',sysdate);

SELECT * FROM PRODUCT WHERE price BETWEEN  900 and 1100;

SELECT * FROM product WHERE FICATION = '야채';

DELETE product WHERE isbn='F-4';

SELECT count(*) FROM product WHERE isbn='V5';

