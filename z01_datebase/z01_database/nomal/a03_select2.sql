/*
 #null 데이터 처리
	1. 데이터가 할당되지 않는 경우를 의미한다.
		'', 공백으로 들어간 데이터와 숫자형인 경우 0으로 들어간 데이터와
		차이가 있다는 것을 반드시 확인하여야 한다.
	
	2. 처리내용
		1)조건문 처리where
			컬럼명 is null : 해당 컬럼에 데이터가 할당되지 않는 경우
			컬럼명 is not null : 해당 컬럼에 데이터가 할당된 경우
		
		2) 함수처리 nvl
			nvl(컬럼명, null 일때 나올 데이터)
			숫자형 nvl(comm,0)
			문자형 nvl(ename, '')
		      ps)주의
		      	1. null은 연산 처리가 되지 않기에, 연산 처리나 조건문에 활용할 때 nvl을 활용한다.
		      	2. nvl을 활용해서 null데이터에 대한 처리를 할때, 해당 유형에 맞게 ''(문자열),
		      		0(숫자형)으로 처리해야한다.
		      	  ex) nvl(ename, 0) (X)
		      	      nvl(comm, '') (X)
		      	      nvl(''||comm, '') (O) 굳이 쓰고자한다면 형변환으로 하여 처리한다.
 */
SELECT SAL, COMM, SAL+COMM "합산1", sal+nvl(comm,0) "합산2"
FROM EMP e ;
-- 프로그래으로 처리하여 나타날 0과 null을 동일시하여 처리할 경우도 있다.
-- ex) 보너스가 0인 경우와 null인경우를 제외한 경우 사원명과 급여, 보너스, 급여+보너스
--     를 출력하세요

SELECT ename, sal,comm, sal+comm 합산
FROM emp
WHERE comm IS NOT NULL and comm != 0;

SELECT ename, sal,comm, sal+comm 합산
FROM emp
WHERE nvl(comm,0)!=0;

/*
 # distinct
 1. 기본적으로 데이터는 전체 다른 컬럼과 함께 연관 관계해서 데이터를 출력해준다.
 	- 한 열의 데이터를 다른 컬럼과의 관계 속에서 해당 열의 데이터를 출력
 2. 이럴때, 해당 컬럼의 데이터가 중복되는 경우가 많다.
 3. 이러한 중복을 제거해주는 명령어가 distinct이다.
 4. 이것은 하나의 컬럼뿐만 아니라 여러컬럼에서도 사용된다.
 */
SELECT * FROM emp;
SELECT deptno FROM emp;

SELECT DISTINCT deptno FROM EMP e ;
SELECT deptno, job
FROM EMP e 
ORDER BY deptno;
-- 위 내용으로 보면 두개의 컬럼을 기준으로 중복되는 컬럼이 보인다.
SELECT DISTINCT deptno, job
FROM EMP e 
ORDER BY deptno;
-- distinct를 사용하면 두개 모두다 비교하여 다른것을 filtering한다.

/*
  #in 구문
  	1. 데이터는 or조건에 관련된 내용은 해당 조건중에 참이 하나라도 있으면
  		조건에 맞기때문에 로딩해주는 것을 말한다.
  	2. 이때, 하나의 컬럼을 기준으로 많은 or조건을 효과적으로 처리하기 위해
  		in()이라는 구문을 oracle sql에서는 지원한다.
  	3. 기본형식	
  		where 컬럼 in(데이터1,데이터2,데이터3)
  		: 해당 데이터들이 or조건으로 데이터가 있을 때, 검색해준다.
 */
SELECT ename, deptno
FROM EMP e 
WHERE deptno = 10 OR deptno = 20 OR deptno =30;
-- 부서번호가 10이거나 2이거나 30인경우 출력
SELECT ename, deptno
FROM EMP e 
WHERE deptno in(10,20,30);
-- in()을 사용한 10이거나 20이거나 30인경우 출력

--ex_ 직책이 'SALESMAN'이거나 MANAGER인경우에 사원 정보를 출력하세요
SELECT *
FROM EMP e 
WHERE job in('SALESMAN','MANAGER');

/*
  # LIKE 연산자를 이용한 KEYWORD검색
  	1.컬럼에 저장된 문자열 중에 like연산자에서 지정한 문자패턴과 부분적으로 일치하면 참이 되어,
  		조건문에서 검색되게하는 것을 말한다.
  ex)사원명에 'A'라는 문자열을 포함하면 조회되게한다.
 		1)'A'라는 문자가 위치에 상관없이 있기만하면 검색: 컬럼명 like '%A%'
 		2)'A'가 첫자에 시작되면 검색 : 컬럼명 like'A%'
 		3)'A'로 끝나는 검색 : 컬럼명 like'%A'
 		4) 자리수를 정확히 맞추어 검색
 			-3번째자리에 'A'가 포함되면 검색 컬럼명 like '__A%' --언더바 하나당 한자리
 */

SELECT *
FROM EMP e 
WHERE ENAME LIKE '&A&';

SELECT *
FROM EMP e 
WHERE ENAME LIKE 'A%';

SELECT *
FROM EMP e 
WHERE ENAME LIKE '%N'; --N으로끝나면 검색

SELECT *
FROM EMP e 
WHERE ENAME LIKE '__A%'-- 3번째 자리가A이면 검색

--ex1) 직책에 'MAN'이라는 글자가 포함되어있으면 조회되게하세요
--ex2) 사원명에 'S'로 끝나는 글자와
--ex3) 사원명에 'S'를 포함하는 글자가 있는 데이터 출력
SELECT *
FROM EMP e 
WHERE JOB  LIKE '%MAN%';

SELECT *
FROM EMP e 
WHERE ename  LIKE '%S';

SELECT *
FROM EMP e 
WHERE ename  LIKE '%S%';

SELECT *
FROM EMP e 
WHERE ename  LIKE '%E_' OR JOB LIKE '%E_';

/*
#정렬처리
	1. sql명령문에서 검색된 결과는 테이블에 데이터가 입력된 순서대로 출력
	2. 데이터의 출력 순서를 특정 컬럼을 기준으로 오름차순/내림차순으로 정렬하는 경우가 발생한다.
	3. 여러개의 컬럼에 대해 정렬 순서를 지정해서 처리해야할 경우가 생긴다.
	   - 입사일은 오름차순, 금여기준으로 내림차순
	4. 기본적인 정렬 방법
		- 문자값을 알파켓순으로 출력되고, 한글은 가나다라 순으로 출력된다.
		- 숫자값은 가장 작은 값으로 부터 출력
		- 날짜는 과정의 날짜에 최신 날짜순으로 출력된다.
	5. 기본 형식
		select * from 테이블 where조건
		order by 컬럼명 [asc/desc]
		asc: default 오름차순 정렬(생략 가능)
		desc: 역순/내림차순 정렬
*/

-- 사원 번호를 기준으로 사원번호와 이름을 조회
SELECT  empno, ename FROM EMP e 
ORDER BY empno DESC;
--ex) 입사일을 기준으로 최근에 입사한 사람으로 제일 위로 가장 먼저 입사한사람을 뒤로정렬
SELECT hiredate ,ename FROM EMP e 
ORDER BY HIREDATE DESC;

--ex2) 연봉이 가장 높은 사람부터 가장 낮은 사람으로 정렬
SELECT sal*12 , ename FROM EMP e 
ORDER BY sal DESC;

--ex3) 부서번호는 오름차순 연봉은 내림차순으로 출력되게하라
SELECT deptno ,sal,ENAME  FROM EMP e 
ORDER BY deptno ASC,sal DESC;