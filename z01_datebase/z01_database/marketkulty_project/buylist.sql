DROP TABLE buy;
CREATE TABLE buy(
buynum varchar2(20) PRIMARY KEY,
userno varchar2(20) CONSTRAINT buy_userno_fk REFERENCES marketuser(userno),
paymentdate DATE,
payment_status varchar2(30) CONSTRAINT buy_payment_status_ck check(payment_status IN ('결제대기','결제완료(카드)','결제완료(계좌이체)'))
);

DROP TABLE buylist;
CREATE TABLE buylist(
buylistnum varchar2(20) PRIMARY KEY,
buynum varchar2(20) CONSTRAINT buylist_buynum_fk REFERENCES buy(buynum),
isbn varchar2(20) CONSTRAINT buy_isbn_fk REFERENCES product(isbn),
buycount number,
price varchar(20)
);
-- buylistnum,buynum,isbn,buycount,price

SELECT * FROM buylist;
DELETE buy
WHERE userno='Member-23';
SELECT * FROM BUYLIST ;
INSERT INTO buy values('buy-userno-'||buy_seq.nextval,'Mgr-22',sysdate,'결제대기');



INSERT INTO buylist
SELECT b.buynum||'-'||buylist_seq.nextval,b.buynum,b2.ISBN,b2.BUYCOUNT,b2.TOTPRICE 
FROM buy b,BUYCART b2,PRODUCT p
WHERE b.userno=b2.USERNO
AND p.ISBN = b2.ISBN 
AND b.payment_status ='결제대기';

SELECT sum(b.price) FROM buylist b,buy b2
WHERE b.buynum=b2.buynum
AND b2.payment_status='결제대기';

SELECT count(*) FROM buy
WHERE userno = 'Member-23'
AND payment_status='결제대기';

UPDATE buy
SET payment_status ='결제완료(카드)'
WHERE userno ='Member-23'
AND payment_status='결제대기';

DELETE buy
WHERE buynum='buy-Mgr-223';

SELECT * FROM buy;
SELECT * FROM BUYCART;
SELECT * FROM BUYLIST;


SELECT p.PRODUCTNAME,b.BUYCOUNT,p.PRICE  FROM BUYLIST b,PRODUCT p 
WHERE b.ISBN = p.ISBN 
AND buynum =(
SELECT BUYNUM
FROM BUY b2
WHERE b2.USERNO='Member-23'
AND b2.PAYMENT_STATUS='결제대기');

DELETE buylist
WHERE buynum=(
SELECT buynum FROM BUY b
WHERE b.USERNO='Member-23'
AND b.PAYMENT_STATUS='결제대기');

DELETE buy
WHERE userno ='Member-23'
AND payment_status='결제대기';

SELECT count(*) FROM BUY b 
WHERE userno=''
AND PAYMENT_STATUS ='결제대기';

-- 결제 시퀀스
DROP SEQUENCE buy_seq;
CREATE SEQUENCE buy_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;
-- 상세결제 시퀀스
DROP SEQUENCE buylist_seq;
CREATE SEQUENCE buylist_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;



