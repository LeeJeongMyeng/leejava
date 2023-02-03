DROP TABLE qna;
CREATE TABLE QNA(
qnano varchar2(20) PRIMARY KEY,
userno_Member varchar2(20) CONSTRAINT QNA_userno_Member_fk REFERENCES bookuser(userno), 
Question varchar2(4000),
answer varchar2(4000))
;
DROP SEQUENCE qna_seq;
CREATE SEQUENCE qna_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;

-- 문의하기
INSERT INTO qna values('qna-'||qna_seq.nextval,?,?,?);

-- 문의하기 전체 목록
SELECT * FROM qna;


-- 문의하기 답변달리지 않은 목록
SELECT * FROM QNA WHERE USERNO_MEMBER  = 'Member-25';

-- 답변하기
UPDATE QNA SET answer = 'gd' WHERE qnano='qnd-21';

SELECT * FROM MEMBER ;