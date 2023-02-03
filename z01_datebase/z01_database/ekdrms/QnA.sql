DROP TABLE qna;

CREATE TABLE QNA(
qnano NUMBER PRIMARY key,
title varchar2(2000),
id varchar2(20),
regitdate DATE,
qnacontent varchar2(2000),
ansercontent varchar2(2000),
Status varchar2(20)
);




DROP SEQUENCE qna_seq;
CREATE SEQUENCE qna_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;
CREATE SEQUENCE qna_seq2
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;

SELECT * FROM QNA;
WHERE QNANO = 120
AND id ='벨르';


SELECT * FROM qna;

SELECT * FROM QNA
WHERE ( id || title ) like '%'||''||'%'
ORDER BY REGITDATE  DESC;

SELECT * FROM  (SELECT rownum AS num,qnano,id,title,regitdate FROM QNA
ORDER BY ROWNUM DESC)
WHERE  num BETWEEN 11 AND 20;

UPDATE QNA 
SET title='',REGITDATE = SYSDATE,qnacontent = 'd',
    ansercontent='ㅇㅇㅇㅇ', Status ='답변완료' WHERE QNANO = 220;


DELETE qna
WHERE qnano=225;


INSERT INTO QNA values(qna_seq.nextval,'제목','찌니',sysdate,'fasdihfa;dfhalksfdhalksjfhaslkjhfsf','-','미답변');