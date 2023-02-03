--[1단계:개념] 1. 그룹함수의 기본형식을 예제를 통해 설명하세요 
	/*select 기준컬럼, 그룹함수(컬럼)
 	 from 테이블명
 	 [where]
 	 group by 그룹 컬럼 */
--[1단계:개념] 2. 그룹함수의 종류를 기술하세요.
/*
 		1) count(): 데이터의 건수, 행의 갯수
 		2) max() : null을 제외한 모든 행의 최대값
 		3) min() :      "  최소값
 		4) sum() : null을 제외한 모든 행의 함
 		5) avg() : null을 제외한 모든 행의 평균 값
 		6) stddev() : null을 제외한 모든 행의 표준편차
 		7) variance() : null을 제외한 모든 행의 분산값  */

--[1단계:코드] 3. 직책별 가장에 최근에 입사한 사원의 입사일을 출력하세요.
SELECT job,MAX(HIREDATE)
FROM EMP e 
GROUP BY job;
--[1단계:코드] 4. 직책별 평균급여가 2000이상인 경우를 출력하세요.
SELECT job, AVG(sal)
FROM EMP e 
GROUP BY job
HAVING avg(SAL)>=2000;
--[1단계:코드] 5. 월별로 가장 급여가 낮은 급여를 출력하세요.
SELECT 	TO_CHAR(hiredate,'mm'), min(SAL) 
FROM EMP e 
GROUP BY TO_CHAR(hiredate,'mm')
ORDER BY TO_CHAR(hiredate,'mm');
--[1단계:코드] 6. 사원번호가 짝수/홀수를 청/홍팀으로 나누고 청/홍팀 평균급여와 사원수를 출력하세요.

SELECT DECODE(MOD(EMPNO,2),0,'청','홍') "team" ,AVG(SAL) 
FROM EMP e 
GROUP BY DECODE(MOD(EMPNO,2),0,'청','홍') ;

--[1단계:코드] 7. 분기별, 입사 사원수의 수가 2명이상인 분기기준으로 분기 별의 최고 급여를 출력하세요.
SELECT HIREDATE,TO_CHAR(hiredate,'Q')
FROM EMP e;

SELECT count(TO_CHAR(hiredate,'Q')) "분기별 입사자", MAX(SAL) 
FROM emp
GROUP BY TO_CHAR(hiredate,'Q')
HAVING count(TO_CHAR(hiredate,'Q'))>=2;

--[1단계:개념] 8. 테이블의 조인의 기본 형식을 기술하세요.
	--select 테이블1.컬럼명, 테이블2.컬럼명, ....
 	--from 테이블1, 테이블2
 	--where 테이블1.공통컬럼 = 테이블2.공통컬럼

--[1단계:코드] 9. 입사일이 2~5월 사이인 사원의 부서명, 사원명, 입사일을 출력하세요
select d.dname,ENAME,hiredate
FROM emp e,DEPT d 
WHERE e.deptno = d.deptno
AND TO_NUMBER(TO_CHAR(HIREDATE,'mm'))>=2
AND TO_NUMBER(TO_CHAR(HIREDATE,'mm'))<=5;

--[1단계:코드] 10. 1/4분기에 입사하고, 연봉이 1000이상인 사원의 사원명, 
--				입사일, 입사분기, 부서명, 부서위치를 출력하세요
SELECT ename,hiredate,TO_CHAR(HIREDATE,'Q') "입사분기",DNAME,D.LOC,SAL
FROM EMP e,DEPT d 
WHERE  e.deptno = d.deptno
AND TO_NUMBER(TO_CHAR(HIREDATE,'mm'))=1
AND SAL>=1000;
--[1단계:코드] 11. 부서위치(LOC)별, 최고 급여가 2000이상인 경우를 출력하세요.
SELECT loc,max(sal)
FROM EMP e,DEPT d
WHERE e.deptno = d.deptno
GROUP BY loc
HAVING max(sal)>=2000;


/*
== 평가대비(데이터베이스) 객관식 문제 ==
1. 어떤 데이터 모델로 데이터를 저장하는지를 나타내는 NoSQL의 종류가 아닌 것은? 3번. 키값,문서기반,컬럼기반,그래프기반이있고.. 인덱스는 아니다.
1) 키-값(key-value) 데이터베이스
2) 문서 기반(document-based) 데이터베이스
3) 인덱스 기반(index-based) 데이터베이스
4) 컬럼 기반(column-based) 데이터베이스

2. NoSQL 데이터의 특징이 아닌 것은?
1) ACID(원자성, 일관성, 격리성, 지속성)를 위한 트랜잭션 기능을 제공 (x) 제공하지않는다..
2) 빠른 속도로 생성되는 대량의 비정형 데이터를 저장하고 처리 (ㅇ)
3) 저렴한 비용으로 여러 대의 컴퓨터에 데이터를 분산∙저장∙처리 (ㅇ)
4) 대부분 오픈 소스로 제공 (o)

3. 해당하는 분석기술이 맞게 매칭된 것은 무엇인가? 2번
1) 텍스트 마이닝(text mining) - SNS, 블로그, 게시판 등에 기록된 사용자들의 의견을 수집 - 오피니언
2) 오피니언 마이닝(opinion mining) - 제품이나 서비스에 대한 긍정, 부정, 중립 등의 선호도를 추출 - 오피니언
3) 소셜 네트워크 분석(social network analysis) - 반정형 또는 비정형 텍스트에서 자연어 처리 기술 - 텍스트마이닝
4) 군집 분석(cluster analysis) - 네트워크에 나타난 영향력, 관심사, 성향, 행동 패턴 등을 추출 - 소셜네트워크분석

4. 빅데이터의 기본 특징가 3V이 아닌 것은? 3번
1) Volume - 데이터량
2) Velocity - 속도
3) Veracity - 정확성(확장된 7V특징)
4) Veriety - 다양성


정답:3,1,2,3 */