/*
	#instr(지정한 문자열데이터|컬럼,'검색문자')
		1.특정한 문자열을 검색해서 해당 무나열의 위치를 index로 반환처리하는 함수
			ex)주로 대용량의 문자열 데이터를 검색해서 해당 문자열의 위치를 첫번째
				위치를 index로 표현해준다.
		2. 추가옵션
			instr(데이터/컬럼,'검색문자',시작위치,검색될 번째수)
				*검색될 번째수 2입력시 = 검색문자가 처음 검색되어도 건너뛰고 두번째로 검색된놈의 위치를 출력한다.
*/
SELECT instr('sql*plus','*')sch1,
	   instr('s*ql*plu*s','*',3,1) sch2,
	   instr('s*ql*plu*s','*',3,2) sch3,
	   instr('s*ql*plu*s','#',3,2) sch4
FROM dual;

--ex) 직책을 검색하되 MAN이 있는 것을 검색하고, 해당 위치를 이름, 직책, 검색위치
--    로 출력하세요

SELECT ename,job,INSTR(job,'MAN',1,1) sch5
FROM EMP e 
WHERE instr(job,'MAN')>0;
--=============================================================================
/*
 #  LPAD(Left Padding), RPAD(Right Padding)
   *Padding = 추가한다는뜻
     1. 전체 문자의 크기를 지저아고, 그 크기보다 못할 때,
       왼쪽 or 오른쪽에 특정한 문자를 추가하게 처리하는 기능을 말한다.
     2.형식
     	LPAD(데이터, 크기, 덧붙힐 문자열)
     	RPAD(데이터, 크기, 덧붙일 문자열)
     ps) 특정한 컬럼을 동일한 자리수를 만들거나, 가변형데이터를 고정형 데이터로 변경 할때 사용된다.
     varchar2(10) ==> char(10)
     최대크기            모든크기
     'himan'==>5byte  'himan     '==> 5byte+공백5byte
 */

SELECT LPAD('sql',5,'*') show1, RPAD('sql',5,'#') show2
FROM DUAL ;
--사원명을 최대크기를 확인한 후, 고정형으로 변환해서 나머지는 *로 추가해서 등록
SELECT max(LENGTH(ename)) FROM emp; --최대 크기6
SELECT ename, rpad(ename,6,'*') "사원명" FROM emp;
--ex) 사원명은 8자리, 직책명을 최대크기 ㅘㄱ인 후 ㅐ당 크기로 설저아여
--    사원명을 왼쪽에#기호로, 직책명을 오른쪽@기호로 덧벝여 처리하세요
SELECT max(LENGTH(JOB)) FROM emp; --9
SELECT ename, LPAD(ename,8,'#') "L8#사원명",JOB, RPAD(JOB,9,'@') "R9@직책" FROM EMP e  

--중첩 함수에 대한 연습
--1. 기본함수 기능 충부니 연습
--2. 이전에 했던 함수를 통해 처리할 수 있는 데이터를 상기 및 의문가지기
--3. 다양한 문제를 통해서 필요로하는 중첨함수처리
--==================================================================================
/*
 # LTRIM/RTRIM
 1. TRIM은 절삭이라는 뜻,
 2. 오른쪽 또는 왼쪽에 있는 특정한 문자열을 삭제처리
 	1) LTRIM(데이터,'제거할문자') : 왼쪽에 제거할 문자를 없애주는데 반복적으로 처리
 	2) RTRIM(데이터,'제거할 문자') : 오른쪽에 제거할 문자를 없애주는데 반복적으로 처리
 	3) TRIM('양쪽에작제할 문자',from 데이터):
 		오른쪽/왼쪽 끝에 제거할 문자가 있을 때, 한번에 제거처리한다.
 cf) char 고정형 데이터를 ==> varchar2 가벼녕데이터로 변환하여 사용할 때,
 	주로 사용된다.
 ex) 웹에서 등로가거나 조회할 때, 자기도 모르게 space를 입력해서 공백이 들어간 경우에
 	 같은 데이터가 있더라도 검색이 안되는 경우가 많다.
 	 이때, 프로그램이나 sql처리시 trim()을 이용하여 등록또는 검색하면 이러한 데이터가
 	 정상적으로 처리된다.
 	 등록된 id = ' himan'
 	 검색 id = 'himan' -- 등록된 아이디에 공백이 있어 검색이 안된다.
 */
SELECT LTRIM('*****sql*****','*') str1, 
       RTRIM('*****sql*****','*') str2,
       TRIM('*'FROM'*****sql****' )str3
       FROM dual;
 SELECT job, ltrim(job,'S') JOB1
 FROM EMP;

SELECT * FROM emp;
-- ex) 직책을 기준으로 왼쪽에 S,오른쪽에 N을 삭제하고 출력하세요
SELECT JOB, LTRIM(JOB,'S') JOB1, RTRIM(JOB,'N') JOB2, LTRIM(RTRIM(JOB,'N'),'S') JOB3
FROM EMP e 