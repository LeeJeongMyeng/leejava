
DROP TABLE MARKETCART;

CREATE TABLE marketCart(
id varchar2(100),
imgname varchar2(100),
brand varchar2(100),
prodname varchar2(100),
cnt NUMBER,
price NUMBER,
discount number
);

INSERT INTO MARKETCART values('z','z','z',1,2);


INSERT INTO MARKETCART 
SELECT ?,imgname,brand,prodname,?,price,discount FROM MARKETPROD
WHERE prodname ='간장 새우장 800g(냉장)';

SELECT * FROM MARKETCART;

SELECT * FROM MARKETCART
WHERE id = 'aoddl56'
AND prodname = '간장 새우장 800g(냉장)';