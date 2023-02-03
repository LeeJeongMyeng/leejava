/*
 #database에서 함수 (function)
 	1. sql에서 함수(주로 내장함수)
 		1)컬럼의 값이나 데이터 타입을 변경하는 경우를 말한다.
 		2) 숫자 또는 날짜 데이터의 출력형식이 변경하는 경우이다.
 		3) 하나 이상의 행에 대한 집계(aggregation)를 하는 경우이다.
 		
 	2. sql함수의 유형
 		1) 단일 행 함수 :  테이블에 저장되어 있는 개별 행을 대상으로 하는 함수를
 						적용하여 하나의 결과를 반환하는 함수이다.
 				ex) 대문자를 소문자로 변환처리
 		
 		2) 복수행 함수 : 조건에 따라 여러 행을 그룹화하여 그룹별로 결과를 하나씩 변환하는 함수
 					여러행의 데이터를 함수를 적용 했을 때, 단일 또는 줄어든 결과를 리턴하여 처리할 때,사용된다
 				ex) 부서별 최소급여
 	
 	 3. 단일행 함수
 	 	1) 데이터 값을 조작하는데 주로 사용된다.
 	 	2) 행별로 함수를 작용하여 하나의 결과를 반환하는 함수이다.
 	 	3) 단일행 함수의 종류
 	 		문자함수 (upper, lower, initcap)
 	 		숫자함수 (ceil, trunc, round)
 	 		변환함수 (묵시적 데이터 변환/ 명시적 데이터 변환 - 문자 ==> 숫자,
 	 				숫자==>날짜, 날짜==>문자)
 	 		일반함수(nvl,decode)
 	 
 	  4. 단일행 함수의 사용법
 	   select 함수명(컬럼명/데이터, 매개변수, 매개변수2,...)
 	   from 테이블명
 	   where 컬럼명 = 함수명(컬럼명/데이터, 매개변수1, 매개변수2..)
 	     and 함수(컬럼) = 함수(데이터); 
 */

/*
  #문자 함수
  	1. 문자 데이터를 입력하여 문자나 숫자를 결과로 반환하는 함수
  	2. 문자 함수의 종류
  		1) 대소문자 변환 함수
  		2) 문자조작 함수
  		3) 문자열 길이 반환 함수
  		
  	3. initcap:문자열 첫번째 문자만 대문자로 변환처리 함수
  		lower : 문자열 전체를 소문자로
  		upper : 문자열 전체를 대문자로
	   

*/
SELECT * FROM EMP e ;
SELECT ename, INITCAP(ename),LOWER(ename),UPPER(ename) FROM EMP e ;  

--ex) 함수를 이용하여 다음과같은 형태로 출력 이름/직책
-- the job of[Smith]is a [Clerk]!!!

SELECT 'the job of'||INITCAP(ename)||' is a/an '||
INITCAP(JOB)||'!!!' show FROM EMP e  


/*
  #lower(), upper()의 사용
  1. 입력되어 있는 데이터를 대소문자 상관없이 검색을 처리할 때, 활용
  2. 'a' 문자로 입력하거나 'A'를 입력해서 검색하더라도 대소문자 상관없이
  		처리가 필요할 때, 위 함수를 처리한다.
 */
-- o/O 를 입력해서 O문자가 포함된 사원명을 검색하고자할때.
SELECT ename, job
FROM EMP e WHERE ename like'%'||upper('o')||'%';
--이때, 등록된 데이터도 소문자가 있는 경우에는
SELECT ename, job
FROM EMP e 
WHERE UPPER(ename) LIKE '%'||UPPER('o')||'%';
-- 조회조건의 컬럼명도 대분자로 변환후, 검색해야한다.
-- ex)사원정보 테이블에 직책이 'Man'|'MAN'|'man'등 여러 형식으로
-- 		있을지라도 대소문자 관계없이 키워드 검색되게 할려면 사용하는 sql을
-- 		처리하세요.

SELECT ename, job
FROM EMP e 
WHERE UPPER(JOB) LIKE '%'||UPPER('MAN')||'%';

SELECT *
FROM EMP e 
WHERE lower(job) LIKE '%'||lower('man')||'%';
-- 모두다 lower로 사용하면 검색을 할 수 있다.

/*
 	#문자열 길기 반환
 		1. length(데이터/컬럼명) : 입력되는 문자열의 길이(글자수)를 반환하는 함수
 		2. lengthb(데이터/컬럼명) : 입력되는 문자열의 바이트를 반환하는 함수
 			한글이나 특수문자는 1글자가 3byte인 경우가 있다.
 			영어와 한글을 글자수에서 차이가 난다.
 		
 	cf) dual: 오라클에서 지원되는 임시가상 테이블로 테이스용으로 한라인에 
 				데이터와 함수의 적용결과를 확인할 수 있다. 
 */
SELECT * FROM dual;
SELECT 15 num01, 16  num02, 15+16 sum01 FROM dual;
SELECT '안녕' str1, '반가워' str2 FROM dual;
SELECT 'hello' 인사1, length('hello') 인사1크기1, LENGTHB('hello') 인사1크기2,
		'안녕' 인사2, LENGTH ('안녕') 인사2크기1, LENGTHB('안녕') 인사2크기2 FROM dual;
	

SELECT ename, length(ename) 사원명길이
FROM emp;

-- ex) 사원 테이블에서 사원명과 직책의 글자 수를 표현 하되, 직책이 6이상인 데이터만
--      출력하세요

SELECT ename , LENGTH(ename) 사원명길이, job, LENGTH(job)
FROM emp
WHERE length(job)>=6;

/*
   #기타 문자열 조작함수
    1.concat(문자열1, 문자열2) : 두 문자열을 결합처리 한다.
    	문자열1||문자열2 동일
    	concat(concat(문자열1,문자열2),'문자열3')
    	문자열1||문자열2||문자열3
    
    2.substr(문자열데이터,시작위치, 시작위치의 갯수) :
    	문자열 데이터를 시작위치와 마지막위치를 기준으로 절삭처라하여 사용하는 것을 말한다.
    	index:0부터 시작하는 경우와 1부터 시작하는 경우로 나누어 진다.
    		ex) substr('sql*plus',5,4) ==> plus	
    			5번째부터 시작해서 4개의 문자를 추출하여 데이터를 표현
    			
    		ex) 코드성 데이터 - 사번, 주민번호, 학번에는 각각의 위치별로 의미하는 바가 있기때문에 추출하여 활용
    						주민번호의 경우 생년월일을 위치에 따라 추출할 수 있다.   
*/
SELECT empno, ename, job, concat(ename, job) "이름과 직책"
FROM emp;

SELECT SUBSTR('sql*plus',5,4) "데이터" FROM dual; 
--ex) 사원명과 사원번호를 이어서 표현하고, 직책은 2번재부터 3글자를 추출 및 출력하세요
SELECT ename, empno, CONCAT(ename,empno) "사원명및번호",job, SUBSTR(job,2,3) "직책2부터3글자"
FROM emp;
	