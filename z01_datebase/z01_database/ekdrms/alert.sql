CREATE TABLE alert(
alertno varchar2(20),
id varchar2(20),
sendid varchar2(20),
alertcontent varchar2(2000),
alertdate DATE,
moveurl varchar2(2000),
qnano NUMBER,
productno NUMBER,
alerttype varchar2(20)
);

INSERT INTO alert VALUES('alert-'||alert_seq.nextval,'aoddl56','alfl','약속',sysdate,'ddd',0,28,'약속신청');

DROP TABLE alert;
CREATE SEQUENCE alert_seq
      increment by 1
      start with 1
      MINVALUE 0
      MAXVALUE 100000;

SELECT * FROM alert;

DELETE alert
WHERE productno = 34 AND alerttype='약속신청';

INSERT INTO alert values(alert_seq,'id','alertcontent',sysdate,'url',qnano,productno);

SELECT TO_CHAR(TO_DATE(resdate,'yyyy/mm/dd HH24:MI:SS'),'YYYY"년"MM"월"DD"일" HH24"시"MI"분"') FROM  DUAL ;


SELECT a.*,TO_CHAR(TO_DATE(r.RESDATE,'yyyy/mm/dd HH24:MI:SS'),
'YYYY/MM/DD - HH24"시"MI"분"') AS resdate
FROM ALERT a 
LEFT OUTER JOIN RESERVE r
ON a.sendid  =r.ID
WHERE a.id='aoddl56' OR a.id='이정명';

SELECT a.*,TO_CHAR(TO_DATE(r.RESDATE,'yyyy/mm/dd HH24:MI:SS'),
'YYYY/MM/DD - HH24"시"MI"분"') AS resdate,r.RNO
FROM ALERT a 
LEFT OUTER JOIN RESERVE r
ON a.sendid  =r.ID
WHERE a.ALERTNO='alert-45';

SELECT * FROM alert,RESERVE r
WHERE ALERTNO =?;
