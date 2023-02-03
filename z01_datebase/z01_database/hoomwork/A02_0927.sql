--1단계:개념] 1. select의 sql의 전체형식의 내용을 예제와 함께 기술하세요.
		--select * | 컬럼명: 열단위로 나타날 데이터를 선택
		--from 테이블명 테이블별칭 : 대상 테이블명과 alias명
		--where 조건 문 : 행단위로 나타날 데이터 filtering 처리
		--group by 그룹할 컬럼지정: 특정컬럼 기준으로 합산,갯수,최대 최소값
		--having : 그룹의 조건을 지정 : 크룹의 컬럼의 조건
		--order by : 정렬할 우선 순위 컬럼 지정
SELECT * FROM EMP e ;

SELECT ename, sal --[열단위 선택] 컬럼 단위로 행을 선택 
FROM emp
WHERE sal>= 3000; -- [단행위 filterring]sal가 3000이상인 경우만 검색

SELECT sal, ename
FROM emp
ORDER by sal desc; --sal 기준으로 데이터를 정렬 처리
-- desc는 높은순부터 정렬/ 빼면 낮은순부터
SELECT * FROM emp;



--[1단계:코드] 2. 급여가 3000이상이거나 2000미만이고  부서명이 30이 아닌 데이터를 검색하세요.
SELECT ename,deptno,sal
FROM emp
WHERE  sal>=3000 or SAL <2000 AND  DEPTNO!=30;
[1단계:개념] 3. 비교연산자 중에 부정연산자인 경우 3가지를 기술하세요.
SELECT *
FROM EMP e 
WHERE DEPTNO !=30;

SELECT *
FROM EMP e 
WHERE DEPTNO <>30; -- <>도 같지않다 일때 사용한다.

SELECT *
FROM EMP e
WHERE NOT (DEPTNO=30); -- not(조건문)으로 반대 조건
--[1단계:코드] 4. 사원명과 관리자번호(mgr)- null인 경우 0으로 출력
SELECT ename,nvl(mgr,0) 
FROM emp ;


--[1단계:코드] 5. null이 아닌 경우만 중복되지 않는 관리자번호를 출력하세요 
			SELECT DISTINCT mgr
			FROM EMP e 
			WHERE mgr IS NOT NULL;

--[1단계:개념] 6. IN 구문과 OR 구문의 차이점을 예제를 통해서 기술하세요
			SELECT ename, deptno
FROM EMP e 
WHERE deptno = 10 OR deptno = 20 OR deptno =30;
-- 부서번호가 10이거나 2이거나 30인경우 출력
SELECT ename, deptno
FROM EMP e 
WHERE deptno in(10,20,30);
-- in()을 사용한 10이거나 20이거나 30인경우 출력

--[1단계:개념] 7. keyword 검색의 형식을 예제를 통해서 기술하세요.
SELECT *
FROM EMP e 
WHERE ENAME LIKE '&A&'; 
-- 사원명에서 위치상관없이 A가 들어간 것만 검색

SELECT *
FROM EMP e 
WHERE ENAME LIKE 'A%';
-- A로 시작하는 사원명만 검색

SELECT *
FROM EMP e 
WHERE ENAME LIKE '%A';
--A으로끝나는 사원명만 검색 검색
SELECT *
FROM EMP e 
WHERE ENAME LIKE '__A%';
--3번째자리에 A가 들어있는 사원명만 검색
SELECT *
FROM EMP e 
WHERE ENAME LIKE '%A__';
--끝에서 3번째 자리에 A가 들어있는 사원명만 검색

--[1단계:코드] 8. [키워드검색]사원명이 두번째 글짜가 A이거나 직책이 MAN을 끝나는 데이터를 조회하세요.
			SELECT *
FROM EMP e 
WHERE ename LIKE '_A%' OR JOB LIKE '%MAN';	
--[1단계:개념] 9. 대소문자 상관없이 조건을 입력했을 때, 검색 처리되는 여러가지 형식을 함수를 통해 기술하세요
			
SELECT ename, job
FROM EMP e 
WHERE UPPER(JOB) LIKE '%'||UPPER('MAN')||'%';
-- 사원명 직책 출력시 직책을 대문자로 출력하고 동시에 MAN이라는 키워드또한 대문자로 설정하여 필터링
SELECT *
FROM EMP e 
WHERE lower(job) LIKE '%'||lower('man')||'%';
-- 사원명 직책 출력시 직책을 대문자로 출력하고 동시에 MAN이라는 키워드또한 대문자로 설정하여 필터링

--[1단계:개념] 10. 한글과 영문의 길이의 차이를 검색하는 함수의 기능을 기술하세요
		SELECT 'Str' "영문자열",LENGTH('Str') "영문자길이", '스트링' "한문자열",LENGTH('스트링') "한문자길이" FROM emp;
		--해당은 글자수를 나타내기에 다르지않다.
		SELECT 'Str' "영문자열",LENGTHB('Str') "영문자길이", '스트링' "한문자열",LENGTHB('스트링') "한문자길이" FROM emp;
		-- LENGTHB는 BYTE수로 출력하기에 다르다.
	
--[1단계:개념] 11. substr() 함수의 기본 기능을 기술하세요.
	SELECT SUBSTR('IamHelloBye',4,5) "데이터" FROM dual; 
			--4번째 H부터 5개문자열(o)까지 추출하여 출력

--[1단계:코드] 12. dual 함수를 이용하여 임의의 주민번호를 substr()처리하여 @@년@@월@@일생이라고 출력하세요.
	SELECT SUBSTR('950828',1,2)||'년 '|| SUBSTR('950828',3,2)||'월 '||SUBSTR('950828',5,2)||'일생' "주민번호" FROM dual;
--[1단계:코드] 13. [함수검색]사원명에 A가 포함되어 있는 데이터의 함수와 검색위치를 출력하세요
		SELECT ename,instr(ename,'A',1,1) schA
		FROM EMP e 
		WHERE INSTR(ENAME,'A')>0;


/*
== 평가대비(오라클) 객관식 문제 ==
1.  데이터베이스 관리 시스템의 단점이 아닌 것은?
1) 비용이 많이 든다
2) 백업과 회복 방법이 복잡하다.
3) 데이터에 대한 동시 공유, 보안, 회복 기능이 부족하다. -- 기능이 좋다
4) 중앙 집중 관리로 인한 취약점이 존재한다.

2. 파일 시스템의 내용이 아닌 것은?
1) 데이터를 파일로 관리
2) 파일을 생성·삭제·수정·검색하는 기능을 제공하는 소프트웨어
3) 응용 프로그램에 필요한 데이터를 공유해서 파일로 관리함 -- 별도로 관리한다.
4) 같은 내용의 데이터가 여러 파일에 중복 저장된다.

3. 데이터베이스 관리시스템의 주요 기능이 아닌 것은?
1) 보안 기능 : 권한이 없는 사용자의 접근, 허용되지 않는 데이터와 연산에 대한 요청 차단 --주요기능이아닌 장점이다.
2) 정의 기능 : 데이터베이스 구조를 정의하거나 수정할 수 있다.
3) 조작 기능 : 데이터를 삽입,삭제,수정 검색하는 연산을 할 수 있다.
4) 제어 기능 : 데이터를 항상 정확하고 안전하게 유지할 수 있다.

4. 아래 내용에 해당 하는 데이터 유형은 무엇인가?
    - 비정형 데이터를 처리하는데 적합하고 확장성이 뛰어남
1) Oracle //2세대 관계DBMS
2) HBase 
3) Myria DB //2세대 관계DBMS
4) Volt DB // 4세대 정형 및 비정형데이터를 안정저긍로 빠르게 처리가능

5. NewSQL DBMS에 해당하는 설명이나 예제 DB가 아닌 것은?
1) 관계 DBMS의 장점 + NoSQL의 확장성 및 유연성
2) Cassandra //NoSQL DBMS이다.
3) 정형 및 비정형 데이터를 안정적이고 빠르게 처리 가능
4) Spanner

정답 : 3 3 1 2 2
*/