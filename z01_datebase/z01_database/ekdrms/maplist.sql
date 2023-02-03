CREATE TABLE maplist(
bigmap varchar2(50),
midmap varchar2(50),
smollmap varchar2(50),
div varchar2(20)
);

DROP TABLE maplist;


SELECT  * FROM maplist;

SELECT DISTINCT bigmap FROM maplist;

SELECT DISTINCT bigmap, MIDMAP  FROM maplist
WHERE bigmap LIKE '%'||'서울특별시'||'%';




SELECT DISTINCT midmap FROM maplist
WHERE bigmap LIKE '%'||'서울특별시'||'%';

SELECT DISTINCT SMOLLMAP  FROM maplist
WHERE MIDMAP  LIKE '%'||'양천'||'%';
AND smollmap LIKE '%'||'목'||'%';

ALTER TABLE maplist RENAME COLUMN smollmap TO smallmap;



emp100_seq
