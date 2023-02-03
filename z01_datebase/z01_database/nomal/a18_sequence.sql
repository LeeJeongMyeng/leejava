/*# SEQUENCE
 * Sequence의 목적
  	1) 테이블에 고정형 데이터형식의 primary key를 사용할때, 가장 많이 활용된다.
  		ex) 게시판1(남자게시판), 게시판2(여자게시판)
  			1                2,3,4
  			5,6,7			 8,9,10
  			borad01			board02
  위 내용에 sequence를 만들고
  create sequence seq_01
  	insert into board01 values(seq_01.nextval,'내용'..);			
  	insert into board02 values(seq_01.nextval,'내용'..);			
  	insert into board01 values(seq_01.nextval,'내용'..);			
  	insert into board01 values(seq_01.nextval,'내용'..);			

	2) 사원 번호등 합성적인 코드에 sequence를 사용할때
  	단과코드+입학년도+학과코드+일련번호
  	H01P040 1000~ (마지막 4자리를 시퀸스 적용)
  		stud_seq
  		insert into student('H01P040'||stud_seq.nextval,
  		
  	3) create sequence 시퀸스명
  	  	increment by 증감
  	  	start with n
  	  	minvalue  n
  	  	maxvalue n
  	  	cycle
  	  	cache 2~
  	  	시퀸스명.nextval
  	  	시퀀스명.currval
  	
  	4) drop sequence 시퀀스명;
  	5) alter sequence 시퀀스명
  		start with n외에 수정이 가능. -start with를 바꾸려면 drop시키고 다시 생성
  				
  			
  			
1.유일한 식별자 데이터를 만들기위한 객체
2.기본키 값을 자동으로 생성하기 위해 일련번호를 생선한다.
	ex) 웹 게시판에 key 글 번호를 순서대로 등록할 때, seuence를 활용하면 편리하다.
3. 여러 테이블에서 공유가능
4. 기본형식
	create sequence 시퀸스명
		increment by 증가단위
		start with 시작번호
		maxvalue 최대값|nomaxvalue
		minvalue 최소값|nominvalue
		cycle|nocycle - 반복여부 설정
		cache n |nocache --속도 개선을 위해 메모리 캐시 시퀸스 수
5. 삭제
	drop sequence 시퀸스명
6. 선언된 sequence사용
	1) 시퀸스명.nextval : 현재 시퀸스 번호 출력 다음 시퀸스 넘버링
	2) 시퀸스명.curval : 현재 시퀸스 번호출력 
*/
DROP SEQUENCE seq_01;
CREATE SEQUENCE seq_01
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 20
	CYCLE
	cache 10;

SELECT seq_01.nextval 현재번호,seq_01.currval FROM dual;

--ex1) 시작번호가 1001이고, 마지막번호가 9999인 시퀸스
CREATE SEQUENCE seq_02
START WITH 1001
INCREMENT BY 1
MINVALUE 1001
MAXVALUE 9999
CYCLE cache 10;
CREATE SEQUENCE seq_03
START WITH 8888
INCREMENT BY -1
MINVALUE 1000
MAXVALUE 8888
CYCLE cache 10;
CREATE SEQUENCE seq_04
START WITH 1
INCREMENT BY 5
MINVALUE 1
MAXVALUE 50
CYCLE cache 5;

SELECT seq_02.nextval 현재번호, seq_02.currval FROM dual;
SELECT seq_03.nextval 현재번호, seq_03.currval FROM dual;
SELECT seq_04.nextval 현재번호, seq_04.currval FROM dual;

SELECT * FROM emp01;
INSERT INTO emp0(empno) VALUES (sep_02.)