CREATE TABLE reserve(
   rno varchar2(20) PRIMARY key, -- 예약번호
   resdate varchar2(100) NOT NULL,   -- 예약날짜
   sugprice NUMBER,   -- 제안가격
   reservation char(1) CONSTRAINT reserve_reservation_ck check(reservation IN('O','X')),   -- 예약여부
   id varchar2(20) CONSTRAINT reserve_id_fk REFERENCES olddealuser(id),   -- 아이디
   productno NUMBER CONSTRAINT reserve_productno_fk REFERENCES olderproduct(productno)   -- 상품번호
);
DROP TABLE reserve;
CREATE SEQUENCE rno_seq
      increment by 1
      start with 1
      MINVALUE 0
      MAXVALUE 100000;
      
     SELECT * FROM reserve;
    
    DELETE reserve
    WHERE NOT id = 'Wlsl';
     
    ALTER TABLE ALERT  drop column resdate;
    
   INSERT INTO reserve values('r'||rno_seq.nextval,
  REPLACE('2023-01-03T19:21','T',' '),
 null,'X','ㅇㅇ',123);

	DELETE reserve WHERE rno='r21';
   SELECT TO_CHAR(TO_DATE('2022-02-01 12:31','yyyy/mm/dd HH24:MI:SS'),'YYYY"년"MM"월"DD"일" HH24"시"MI"분"') FROM  DUAL ;
 