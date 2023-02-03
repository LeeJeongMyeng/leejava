DROP TABLE olddealuser ;
CREATE TABLE olddealuser(
id varchar2(20) PRIMARY key,
password varchar2(20),
div varchar2(20),
username varchar2(20),
nickname varchar2(30),
rrn varchar2(14),
phonenumber varchar2(13),
zipcode varchar2(20),
address varchar2(100),
detailaddress varchar2(100),
email varchar2(50),
point NUMBER,
salecount NUMBER,
buycount NUMBER,
declarationcount NUMBER
);
SELECT * FROM olddealuser;
WHERE id='aoddl56'
AND PASSWORD ='!dnflwlq12';

INSERT INTO olddealuser VALUES(
'dbwls', /*아이디*/
'2222', /*패스워드*/
'회원',/*구분자*/
'정유진', /*이름*/
'유지니', /*닉네임*/
'950528-1861529', /*주민*/
'010-5293-0247', /*폰번*/
'07952', /*우편번호*/
'인천광역시 남동구 예술로 206(구월동)', /*주소*/
'201호', /*상세주소*/
'aoddl56@naver.com', /*이메일*/
0,
0,
0,
0
);

INSERT INTO JGUser VALUES(?,?,?,?,?,?,?,?,?,?,?,1000,0,0,0);

UPDATE olddealuser
SET PASSWORD =?,
	NICKNAME =?,
	PHONENUMBER =?,
	ZIPCODE =?,
	ADDRESS =?,
	DETAILADDRESS =?,
	EMAIL =?
WHERE id=?


	





/*탑3코드 buycount,salecount */ 
SELECT nickname, buycount
FROM (
   SELECT nickname, buycount
   FROM olddealuser
   ORDER BY buycount DESC
)
WHERE ROWNUM <= 3;

SELECT nickname, buycount,salecount
  FROM (SELECT nickname,salecount,BUYCOUNT, buycount+salecount AS bs
   FROM olddealuser
   ORDER BY bs DESC) WHERE ROWNUM <= 3;
  
SELECT i.*, p.IMGNO,p.IMGNAME
FROM olderproduct i, proimg p
WHERE i.productno= p.productno;

SELECT i.imgname
FROM proimg i, olderproduct p
WHERE i.productno = p.productno
AND i.productno = 19
ORDER BY imgno


SELECT * FROM dept100;