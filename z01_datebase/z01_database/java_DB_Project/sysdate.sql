DROP TABLE exp1000;
CREATE TABLE exp1000(
rent DATE,
returnday date,
div number);

INSERT INTO exp1000 values(sysdate,to_date(sysdate,'yyyy/mm/dd')+7,
			TO_NUMBER(trunc(sysdate)-trunc(to_date('2022-10-20','yyyy/mm/dd'))));

SELECT * FROM exp1000;
SELECT to_date('2022/09/09','yyyy/mm/dd')+7 FROM dual;


SELECT   날짜계산 FROM dual; --날짜 계산

