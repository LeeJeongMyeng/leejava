/*
  #날짜함수
  	1. 날짜형 데이터 처리 process
  		+1: 1일후를 의미한다.
  		1/24:1시간을 의미한다.
  		1) 날짜데이터 단위
  		1/1000(초) ==> 1초 ==> 60(1분) ==>(60)1시간
  		==> (24)1일 ==> (28,29,30,31) 1월 ==> (12) 1년 
  		
  	2. 기본연산
  		날짜+1 : 해당 날짜의 1일이후(시간을 포함해서 24시간 이후)
  		날짜-1 : 해당 날짜의 1일 전
  		날짜+1/24 : 해당 날짜와 시간의 1시간 이후
  		날짜+200/24/60 : 해당날짜와 시간의 200분 이후
  		ex)1일을 기준으로 하기에 0.5 ==> 12시간
  	3. 기본 함수
  		1)sysdate : 현재 날짜와 시간을 나타낸다.
  		
 */
SELECT sysdate FROM dual;
SELECT sysdate 현재, sysdate+1 "1일후",
	   sysdate-1 "1일전",
	   sysdate+(10/24) "10시간 후",
FROM dual;

SELECT ename,hiredate,sysdate-7 "입사 7일전",sysdate+100 "입사 100일 후"
FROM emp;

--ex) 사원명과 함께 인턴기간(입사후,120일), 입사8일전, 현재일 기준으로 근무일수(정수로 절삭)출력하세요
SELECT ename, hiredate, hiredate+120 "인턴기간", hiredate-8 "입사8일전",
		TRUNC((sysdate-hiredate),0) "근무일수t", floor(sysdate-hiredate) "근무일수f"
FROM emp;

/*
  #월처리
  1. 날짜형 데이터는 월단위가 유동적(28,29,30,31)이기 때문에
  	  해당 월에 따라 함수로 이러한 월계산 처리를 해주고 있다.
  2. 기본형식
  		months_between(날짜1,날짜2) : 날짜 사이의 개월수를 표시한다.
  		5/19,6/19 ==> 1개월  15==>0.5개월
  		- 소수점 이하의 데이터가 나오는 이유는 1이 개월단위이기 때문에 
  		일계산은 1/30, 시간은 1/30/24등으로 연산을 한다.
  		주의) 월30일, 31,29일 등 월단위개월수 처리시, 데이터 처리에 변수가 있는 이것때문에 기능함수를
  			이용해야지 정확히 계산된다.
 */
SELECT ename, hiredate,SYSDATE , MONTHS_BETWEEN(sysdate,hiredate) "근무 개월수1",
		floor(MONTHS_BETWEEN(sysdate,hiredate)) "근무개월수2",
		ceil(MONTHS_BETWEEN(sysdate,hiredate)) "근무개월수3"
FROM emp;

--ex) 오늘로 100이후의 개월수, 1000일 이후 개월수를 출력하세요
SELECT MONTHS_BETWEEN(sysdate+100,sysdate) "100일후 개월수",
 MONTHS_BETWEEN(sysdate+1000,sysdate) "1000일후 개월수",
trunc(MONTHS_BETWEEN(sysdate+1000,sysdate)/12)||'년' "근속년",
trunc(MOD (MONTHS_BETWEEN(sysdate+1000,sysdate)/12,1)*12)||'개월' "근속월",
trunc(mod(MOD(MONTHS_BETWEEN(sysdate+1000,sysdate)/12,1)*12,1)*(365/12))||'일' "근속일"
FROM emp;
/*
 #개월 수 추가 add_months
  	1.특정한 날짜를 기준으로 개월수를 추가하여, 해당 이후 날짜는 해당 이전 개월수에
  		날짜를 처리할 때, 사용된다.
  	2. 형식
  		add_months(날짜, 추가또는 이전개월수)
*/	
SELECT SYSDATE 오늘, ADD_MONTHS(sysdate,4) "4개월 후",
		ADD_MONTHS(sysdate,-1) "1개월 전" 
FROM dual;
--ex) 사원 정보 기준, 사원명, 입사일, 인턴기간(3개월), 입사10년, 입사20년
SELECT ename,hiredate, ADD_MONTHS(hiredate,3) "인턴종료",
       MONTHS_BETWEEN(ADD_MONTHS(hiredate,3),hiredate) "인턴기간(월)",
       ADD_MONTHS(hiredate,12*10) "입사10년", ADD_MONTHS(hiredate,12*20) "입사20년"
 FROM emp;
 
/*
 # 다가올 가장빠른 요일의 날짜: next_day
 	1. 해당 기준일로 명시된 요일에 가장빠른 날짜
 	2. 기본 형식
 	 	next_day(날짜데이터,'요일')
 */
SELECT NEXT_DAY(sysdate,'일') "가장 빠른 일요일"
FROM dual;
--ex) 입사 후, 토요일
SELECT ename,hiredate, NEXT_DAY(hiredate,'토')||'토요일에 여행' "여행날",
		next_day(NEXT_DAY(hiredate,'토'),'토') "그 다음주 토요일"
FROM EMP e ;

/*
  #월의 마지막 날짜 :last_day(날짜)
   
  1. 해당날짜가 속한 달의 마지막날짜
  2. 형식: last_day(기준일) : 마지막 날짜
  		  add_months(last_day(기준일)+1,-1) : 해당월의 마지막날짜
 */
SELECT LAST_DAY(SYSDATE) "이번달 마지막날", 
	   LAST_DAY(SYSDATE)+1 "다음달 첫날", 
       ADD_MONTHS(LAST_DAY(sysdate)+1,-1) "이번달 첫날"
       --ADD_MONTHS() 해당 월에서 개월수 +,- 
 FROM dual;
 /* 
  1. 급여일 : 근무 다음달 10일,20일
  2. 급여일(30) : 20일급여
  */
--ex) 사원명과 급여일1(종료일 -10전), 보너스일(다음달 10일)출력하세요
SELECT ename, hiredate,LAST_DAY(SYSDATE)-10 "급여일",  LAST_DAY(hiredate)+10 "다음달10일"
FROM emp;

SELECT sysdate,TO_DATE('2000-01-01','yyyy-mm-dd') "지정날",
		MONTHS_BETWEEN(sysdate,TO_DATE('2000-01-01','yyyy-mm-dd')) ,
		to_char(TO_DATE('2000-01-01','yyyy-mm-dd')) "char"
FROM dual;

