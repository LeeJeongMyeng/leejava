--[1단계:코드] 1. salgrade 테이블 전체를 조회하고, 해당 컬럼을 조회해보세요.
SELECT * FROM SALGRADE;
--[1단계:개념] 2. lpad, rpad의 기본형식과 예제를 기술하세요
				--Padding= 추가의 의미
				--lpad or rpad(데이터,크기,덧붙힐 문자열)
SELECT LPAD('sql',5,'*') show1, -- 해당 크기만큼 빈공간을 왼쪽에 해당문자열 삽입
		RPAD('sql',5,'#') show2 -- 오른쪽에 해당 문자열 삽입
FROM DUAL ;
--[1단계:코드] 3. 사원명을 10자리 기준 '&'는 왼쪽에, 직책명을 10자리기준 '!' 오른쪽으로 덧붙여 설정하여 출력하세요.
SELECT LPAD(ename,10,'&') show1, RPAD(ename,10,'!') show2
FROM emp;
--[1단계:개념] 4. trim 처리 함수 3가지를 기술하고, 해당 옵션에 대하여 기술하세요.
				--trim ==> 절삭의 의미
				--1) LTRIM(데이터,'제거할문자') : 왼쪽에 제거할 문자를 없애주는데 반복적으로 처리
 				--2) RTRIM(데이터,'제거할 문자') : 오른쪽에 제거할 문자를 없애주는데 반복적으로 처리
 				--3) TRIM('양쪽에작제할 문자',from 데이터):
 					--오른쪽/왼쪽 끝에 제거할 문자가 있을 때, 한번에 제거처리한다.

--[1단계:개념] 5. 숫자형 함수에서 소숫점 이하에 대한 처리를 예제와 함께 기술하세요.
SELECT round(23423.277,2) rou1, -- 반올림처리하여 소수점2번쨰자리까지 표시
					   round(23423.274,2) rou2,
					   trunc(23423.274,2) trc1, --내림처리와 같은것으로, 지정한 소숫점이래는 절삭
					   trunc(23423.279,2) trc1					   
FROM emp;
--[1단계:코드] 6. 급여를 부서번호(10==> 10%, 20==> 20%..)기준으로 인상을 하기로 했다.
             --현재 급여와 인상된 급여를 처리하되 100자리 단위로 절삭하여, 사원명과 함께 출력하세요.
SELECT ename,deptno,sal "현재급여", sal*(1+(deptno/100)) "향상된급여",
		trunc(sal*(1+(deptno/100)),-2) "절삭"
FROM emp;
--[1단계:코드] 7. 사번을 기준으로 홀수인 경우 급여기준으로 보너스를 50% 추가하여 급여를 계산하기로 했다.
        		-- 이름, 사번, 구분, 급여, 총급여   를 출력하세요.
SELECT ename, empno, sal,sal*(50/100) "급여의50%",sal+(sal*(50/100)) "총급여"
FROM emp
WHERE mod(empno,2)=1;

--[1단계:개념] 8. 날짜 처리 단위별(초,분,시,일) 정리하고 예제를 dual 테이블로 나타내세요.
SELECT SYSDATE "현재날짜", SYSDATE+1 "1일후",
	   SYSDATE "현재날짜", SYSDATE+1/24 "1시간후",
	   SYSDATE "현재날짜", SYSDATE+1/24/60 "1분후",
	   SYSDATE "현재날짜", SYSDATE+1/24/60/60 "1초후"
FROM dual;
--[1단계:개념] 9. 날짜형 함수의 종류에 대하여 기술하세요.
			-- sysdate : 시스템 기준 현재 날짜/시간 출력
			--months_between(날짜1,날짜2) : 날짜 사이의 개월수를 표시한다.
			--next_day(날짜데이터,'요일') : 날짜데이터 기준 가장빠른 요일의 날짜를 계산
			--last_day(날짜) : 해당날짜가 속해있는달의 마지막날짜계산
			--add_months(날짜데이터+1) : 해당 날짜데이터기준 다음달
			--add_months(날짜데이터-1) : 해당 날짜데이터기준 이전달

--[1단계:코드] 10. 사원명과 함께 근무연한을 @@년 @@개월 @@일이라고 표시하세요. (여러가지 중첩 함수 이용)
/*
 1.전체근무개월수 현재일과 입사일을 차를 통해 도출:months_between(현재일,hiredate)
 2.근무 연도 계산, 위 전체 근무개월수를 /12로 처리
 3. 연도를 제외한 근무 개월수, 위 전체 근무개월수를 mod(전체 근무개월수,12)
 4. 연도/근무개월수를 제외한 날짜 계산
 	전체 근무 개월수: 나머지 날짜를 뺀 순수한 개월수만 처리한 데이터
 					그러므로, 해당 개월수에 날짜는 나머지 일수가 포함되어 있지 않다. 식의 도출과정
 				1) 전체 개월수 산정( 현재일과 입사일) 
 				flool(months_between(sysdate,hiredate))
 				-개월수만 상정하고 일수를 내림처리하여 없앰
 				2) 입사일로 부터 전체 개월수: 남은 날짜를 제외한 개월수에 대한 날짜를 처리
 					==>  add_months(입사일, 전체개월수)
 				3) 현재날짜와 위 남은 날짜가 포함되지 않는 날짜를 뺴주면
 					근무연도/근무월을 뺀 나머지 날짜를 도출할 수있다.
 */
SELECT ENAME,HIREDATE,SYSDATE,
trunc(MONTHS_BETWEEN(SYSDATE,HIREDATE)/12)||'년' "근속년",
trunc(MOD (MONTHS_BETWEEN(SYSDATE,HIREDATE)/12,1)*12)||'개월' "근속월",
trunc(mod(MOD(MONTHS_BETWEEN(SYSDATE,HIREDATE)/12,1)*12,1)*(365/12))||'일' "근속일"
FROM emp;

SELECT ename,
		FLOOR(MONTHS_BETWEEN(SYSDATE,hiredate)) "전체 개월수",
		FLOOR(MONTHS_BETWEEN(SYSDATE,hiredate)/12) "근무년",
		MOD(FLOOR(MONTHS_BETWEEN(SYSDATE,hiredate)),12) "근무월",
		ADD_MONTHS(hiredate,FLOOR(MONTHS_BETWEEN(SYSDATE,hiredate))) "근속월",
		floor(SYSDATE-ADD_MONTHS(hiredate,FLOOR(MONTHS_BETWEEN(SYSDATE,hiredate)))) "근속일"
FROM emp;
-- 위와같이 연산된 내용이 중복적인 복잡한 내용은 inlineView라는 개념으로 효과적으로 처리가능하다.
/*
 select * from (sql을 통해 가상의 테이블 데이터 생성);
 */
SELECT ENAME, 
	floor(MM/12)||'년'||MOD(MM,12))'개월'||FLOOR(SYSDATE-ADD_MONTHS(hiredate,MM))||'일' "근무기간" 
FROM (SELECT ename, hiredate, FLOOR(MONTHS_BETWEEN(SYSDATE,hiredate)) MM
FROM EMP e);
--[1단계:코드] 11. @@월 @@째 수요일 등을 미국에서 쓰이는 공휴일 처리 방식인, 한국의 선거일의
                  -- 경우 임기종료 @@주째 전 수요일같이 날짜를 요일에 대한 날짜를 계산할 때 사용된다.
                  --오늘로 부터 3개월 후 해당월의 3번째 수요일을 출력하세요.
SELECT SYSDATE, LAST_DAY(ADD_MONTHS(sysdate,2))+1 "3개월후의 첫째날",
				NEXT_day(LAST_DAY(ADD_MONTHS(sysdate,2))+1,'수') "3개월후의 첫수요일",
				NEXT_day(NEXT_day(NEXT_day(LAST_DAY(ADD_MONTHS(sysdate,2))+1,'수'),'수'),'수') "3개월후의 3번쨰수요일"
FROM dual;
--[1단계:코드] 12. 사원의 첫급여일이 다음달 첫 날로 지정하였다. 급여일과 입사월의 근무일수를 출력하세요..        
SELECT ename, hiredate, LAST_DAY(hiredate)+1 "첫급여일",
	           LAST_DAY(hiredate)+1-HIREDATE  "근무일수"
FROM emp;
/*
== 평가대비(데이터베이스) 객관식 문제 ==
1. 데이터베이스에 저장되는 데이터 구조와 제약조건을 정의한 것을 무엇이라고 하는가 ? 1번
1) 스키마
2) 레코드
3) 시스템 카타로그
4) 인스턴스 // 스키마에 따라 데이터베이스에 실제로 저장된값


2. 데이터베이스를 쉽게 이해하고 이용할 수 있도록 하나의 데이터베이스를 관점에 따라 세 단계가 아닌 것은? 3번
1) 외부 단계
2) 논리 단계
3) 개발 사용자 관점 // 외부단계설명
4) 내부 단계

3. 개념 스키마에 해당하는 내용을 나타내는 것은? 2번
1) 각 사용자가 생각하는 데이터베이스의 모습, 즉 논리적 구조로 사용자마다 다름 //외부단계
2) 조직 전체의 관점에서 생각하는 데이터베이스의 모습
3) 서브 스키마(sub schema)라고도 함 // 외부단계
4) 전체 데이터베이스가 저장 장치에 실제로 저장되는 방법을 정의한 것 // 내부단계

정답:1,2,2 */