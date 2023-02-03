DROP TABLE olderproduct;
CREATE TABLE olderproduct(
   productno NUMBER PRIMARY key, /*상품번호*/
   productname varchar2(100),   /*제목*/
   kind varchar2(20),   /*분류*/
   dealmethod varchar2(40), /*거래방식*/
   price NUMBER, /*가격*/
   sharewhether varchar2(50), /*나눔여부*/   
   priceoffer varchar2(50), /*가격제안*/
   information varchar2(2000),   /*설명*/
   registdate DATE, /*등록날짜*/
   dealstat varchar2(20), /*거래상태*/
   faddressval varchar2(20), /*대분류(서울특별시,경상남도,대구광역시 등)*/
   saddressval varchar2(20), /*중분류(영등포구 등, 및 창원시 진주시 등)*/
   caddressval varchar2(20), /*읍,면,동*/
   daddressval varchar2(300), /*상세거래위치*/
   writerid varchar2(20),
   viewcount NUMBER,
   likecount number
);
 ALTER TABLE olderproduct MODIFY (faddressval VARCHAR2(30));
CREATE TABLE proimg(
   imgno varchar2(20) PRIMARY KEY,   -- 이미지구분번호
   productno NUMBER CONSTRAINT olderproduct_productno_fk REFERENCES olderproduct(productno),   -- 상품번호
   imgname varchar2(4000)   -- 파일이름
);
CREATE TABLE cartlist(
 productno NUMBER,
 id varchar2(20)
);

CREATE SEQUENCE productno_seq
      increment by 1
      start with 1
      MINVALUE 0
      MAXVALUE 100000;
CREATE SEQUENCE proimg_seq
      increment by 1
      start with 1
      MINVALUE 0
      MAXVALUE 100000;


INSERT INTO proimg VALUES('img-'||proimg_seq.nextval,'상품번호','파일이름');

INSERT INTO olderproduct values(productno_seq.nextval,'zzz','전자제품','직접거래',100000,'O','O','ㅋㅋㅋㅋㅋㅋ개꿀',SYSDATE,
				'판매중','서울특별시','양천구','목동','CU앞','aoddl56')
INSERT INTO olderproduct values(productno_seq.nextval,?,?,?,?,?,?,?,SYSDATE,'판매중',?,?,?,?,?)

SELECT * FROM olderproduct;
SELECT * FROM proimg;
SELECT * FROM cartlist;

   
DROP SEQUENCE productno_seq;
SELECT LENGTH(FADDRESSVAL),LENGTHB(FADDRESSVAL)  FROM olderproduct;
SELECT * FROM proimg;

SELECT i.*, p.IMGNO,p.IMGNAME
FROM olderproduct i, proimg p
WHERE i.productno= p.productno;

DELETE olderproduct
WHERE productno = 29;


UPDATE olderproduct
SET PRICEOFFER  = 'O'
WHERE PRODUCTNO = 28;

INSERT INTO cartlist value(?,?)
DELETE cartlist
WHERE productno=?
AND id=?

SELECT * FROM cartlist
WHERE productno = 8
AND id='Wlsl';

DELETE olderproduct o WHERE EXISTS 
(SELECT 1 FROM proimg p WHERE o.PRODUCTNO=p.PRODUCTNO)
AND productno = 14;

SELECT i.*, p.IMGNO,p.IMGNAME
FROM olderproduct i, proimg p
WHERE i.productno= p.productno
and (productname || kind || information || FADDRESSVAL || SADDRESSVAL
	|| CADDRESSVAL || DADDRESSVAL) like '%'||'목동'||'%'

	UPDATE olderproduct
	SET viewcount = viewcount+1
	WHERE PRODUCTNO =

	
SELECT * FROM olderproduct;
WHERE PRODUCTNO =28;

UPDATE olderproduct
SET productname=?,
kind=?,
dealmethod=?,
price=?,
sharewhether=?,
priceoffer=?,
information=?,
faddressval=?,
saddressval=?,
caddressval=?,
daddressval=?
WHERE productno=?

ALTER TABLE olderproduct MODIFY (addressval VARCHAR2(2000));

SELECT * FROM emp100;