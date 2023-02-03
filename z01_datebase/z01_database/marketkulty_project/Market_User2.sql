CREATE TABLE MARKETUSER2(
userno varchar2(20) primary KEY,
id varchar2(20),
password varchar2(20),
username varchar2(20),
email varchar2(20),
phonenumber varchar2(20),
address varchar2(200),
gender varchar2(10),
rrn_yyyy varchar2(10),
rrn_mm varchar2(10),
rrn_dd varchar2(10),
point number
);

DROP TABLE MARKETUSER2 ;

DELETE marketuser2
WHERE userno = 'mem-6';

SELECT * FROM marketuser2;

DROP SEQUENCE MARKETUSER2_seq;
CREATE SEQUENCE MARKETUSER2_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;


INSERT INTO MARKETUSER2 VALUES ('mem-'||MARKETUSER2_seq.nextval,?,?,?,?,?,?,?,?,?,?,1000);
