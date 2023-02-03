
-- [1단계:개념] 1. 명시적 형변환 함수 3가지를 기본 예제와 함께 기술하세요
--1) to_char 3)to_date
SELECT  to_char(1500) 문자열, 1500 숫자 -- 같은 숫자이나 to_char을 통해 '1500'를 가진 문자열이된다.
FROM dual;
--2)to_number
SELECT ename||'는'||to_char(HIREDATE,'yy"년" mm"월" dd"일에"')||'입사함.' show, --날짜를 문자열로 변환
		sal+TO_NUMBER('5000') "sal+5000" -- '5000'이라는 문자열이지만 숫자형으로 변형하여 sal의값과 더함.
FROM emp;
--3)to_date
SELECT TO_DATE('2022-08-28','yy-mm-dd') "날짜로변환" --'2022-08-28'문자열을 날짜데이터로 변환
FROM dual;
--[1단계:코드] 2. 2/4분기에 입사한 사원을 다음 양식으로 표현하세요
--             @@@ -  @/4분기 공채입사자  @@월 @@째주 입사
SELECT ename, hiredate, TO_CHAR(hiredate,'Q') "입사분기",
		ename||'-'||TO_CHAR(hiredate,'Q')||'/4분기 공채입사자'||TO_CHAR(HIREDATE,'mm')||'월'||TO_CHAR(HIREDATE,'dd')||'일'
		||TO_CHAR(HIREDATE ,'w')||'째주 입사' "입사"	
FROM EMP;
--[1단계:코드] 3. 분기별 입사자에게 급여의 30%,60%,90%,120%로 각가 보너스 금액을 산정할 때,
--             입사자 분기 보너스(%) 급여 보너스 급여+보너스 를 출력하세요(decode,case문 사용X)
SELECT ename,hiredate, TO_NUMBER(TO_CHAR(hiredate,'Q'))||'분기' "분기(숫자)",sal,
				nvl2(SAL,sal*(3*TO_NUMBER('0.'||TO_CHAR(hiredate,'Q'))),0) "보너스",
				sal+nvl2(SAL,sal*(3*TO_NUMBER('0.'||TO_CHAR(hiredate,'Q'))),0) "총합"
				--혹은 SAL*(1,2,3,4분기)*0.3으로 계산해도된다.
FROM emp;
--혹은 SAL*(1,2,3,4분기)*0.3으로 계산해도된다.
SELECT ename, 분기,q*30||'%' "보너스(%)", sal*q*0.3 보너스,
		sal+(sal*q*0.3) "합산(급여+보너스)"		
FROM (SELECT ename,sal, TO_CHAR(hiredate,'Q') "분기",
			to_number(TO_CHAR(hiredate,'Q')) q
			FROM emp
);
--[1단계:개념] 4. 숫자 처리 기본형식을 예제와 함께 기술하세요.
SELECT round(23423.277,3) rou1, --소수점n번째짜리까지 표현하고 그아래는 반올림
       round(23423.277,1) rou2,
       round(23423.277,-1) rou3, -- n이 -값일경우 정수쪽자리로 이동
       round(23423.277,-2) rou4,
       trunc(23423.277,1) tuc1, -- 소수점n번자리까지 표현하고 절삭
       trunc(23423.277,-3) tuc2,
       ceil(23423.277) ceil1, --정수표현으로 올림처리
       floor(23423.277) floor1 --정수표현으로 내림처리
       FROM dual;
--[1단계:개념] 5. 명시적 형변환과 묵시적 형변환의 차이점을 기술하세요.
      		-- 묵시적형변환 ==> 오라클시스템 내부적으로 자동타입변환을 해줌
      			select * from emp
  	 			where sal>='2000'; --문자형2000을 숫자형으로 자동변환
  	 		-- 명시적형변환 ==> 변환하고자하는 타입을 입력하여 변환
  	 			SELECT TO_CHAR(sal)||'만원' "월급의 문자형"
  	 			FROM emp;
--[1단계:코드] 6. 사원정보의 입사일에서 2000-01-01/2010-06-01/2020-12-31까지의 입사연한/개월 수를 표현하세요
  	 		/*
  	 		 1) 문자열을 날짜형으로 변환 to_date('2000-01-01','yyyy-mm-dd') "근무1"
  	 		 2) 개월수 표시 months_between(기준날짜,hiredate) "전체개월수표시"
  	 		 3) 근무연한: floor(전체 개월수/12) _12 즉, 1년으로 나누어서 나머지를 뺸값
  	 		 4) 근무 연한을 뺀 근무 개월수 : mod(전체 개월수,12) 12 즉, 1년으로 나누어서 나머지를 구한값
  	 		 */
 SELECT ename, hiredate, floor(ch01/12) "근무연한1",
 						floor(ch01/12)||'년'||MOD(floor(ch01),12)||'개월' "근무개월수"
FROM(SELECT ename, hiredate,
		MONTHS_BETWEEN(TO_DATE('2000-01-01','yyyy-mm-dd'),hiredate) ch01
		FROM emp);
 
SELECT ename,HIREDATE ,'2000-01-01' "지정날",MONTHS_BETWEEN(to_date('2000-01-01','yyyy-mm-dd'),HIREDATE) "근속총개월수", 
		TRUNC(MONTHS_BETWEEN(to_date('2000-01-01','yyyy-mm-dd'),HIREDATE)/12)||'년'||
		TRUNC(mod(MONTHS_BETWEEN(to_date('2000-01-01','yyyy-mm-dd'),HIREDATE)/12,1)*12)||'월개월'||
		TRUNC(mod(mod(MONTHS_BETWEEN(to_date('2000-01-01','yyyy-mm-dd'),HIREDATE),12)*12,1)*(365/12))||'일째 근무중'
FROM emp;
SELECT ename,HIREDATE ,'2010-06-01' "지정날",MONTHS_BETWEEN(to_date('2010-06-01','yyyy-mm-dd'),HIREDATE) "근속총개월수", 
		TRUNC(MONTHS_BETWEEN(to_date('2010-06-01','yyyy-mm-dd'),HIREDATE)/12)||'년'||
		TRUNC(mod(MONTHS_BETWEEN(to_date('2010-06-01','yyyy-mm-dd'),HIREDATE)/12,1)*12)||'월개월'||
		TRUNC(mod(mod(MONTHS_BETWEEN(to_date('2010-06-01','yyyy-mm-dd'),HIREDATE),12)*12,1)*(365/12))||'일째 근무중'
FROM emp;
SELECT ename,HIREDATE ,'2020-12-31' "지정날",MONTHS_BETWEEN(to_date('2020-12-31','yyyy-mm-dd'),HIREDATE) "근속총개월수", 
		TRUNC(MONTHS_BETWEEN(to_date('2020-12-31','yyyy-mm-dd'),HIREDATE)/12)||'년'||
		TRUNC(mod(MONTHS_BETWEEN(to_date('2020-12-31','yyyy-mm-dd'),HIREDATE)/12,1)*12)||'월개월'||
		TRUNC(mod(mod(MONTHS_BETWEEN(to_date('2020-12-31','yyyy-mm-dd'),HIREDATE),12)*12,1)*(365/12))||'일째 근무중'
FROM emp; 
--[1단계:개념] 7. null관련 함수를 기본 예제와 함께 기능을 기술하세요
	--1)nvl(데이터,null일경우 출력할 내용)
	SELECT nvl(comm,0)
	FROM emp;
	--2) nvl2(데이터,null이아닐경우,null일경우)
 	SELECT comm,nvl2(comm,comm*2,0)
 	FROM emp;
 	-- nullif(데이터1,2) ==>데이터1,2가 같을경우 null 출력, 다를경우 1번데이터 출력
 	SELECT nullif('a','a') show1, --null
		nullif('a','b') show2,-- 'a'
		nullif(15,20)show3, --15
		nvl(nullif('a','a'),'동일')show4, --nullif내용이 동일하므로 null출력 후, nvl에서 null이기에 '동일출력'
		nvl(nullif('a','b'),'동일')show5  --nullif내용이 다르므로 1번데이터 'a'출력, null이아니기에 그대로'a'출력
FROM dual;
--[1단계:코드] 8. 회사에서 일괄보너스 지급 금액이 60이라고 정하는데, 연봉의 5%(10단위로 절삭)와 같으면 60, 다르면 연봉의 5%로 처리하는 sql을 작성하세요.
	/*
	 1.연봉의 5%를 10단위처리 : trunc(sal*0.05,-1)
	 2.기준금액 60과 비교처리 : nullif(연봉50%,60) 같으면 null,다르면 연봉50% 출력
	 3. 같으면 60, 다르면 연봉의 5%로 : nvl(데이터,null일때 처리) ==> null이나오면 60,아니면 5%처리
	 							 nvl2(데이터,null아닐떄,null일때)
	 */
SELECT ename, sal, trunc(sal*0.05,-1) "연봉의5퍼",
						60 "일괄보너스 기준액",
	nvl2(NULLIF(trunc(sal*0.05,-1),60),sal*0.05,60) "보너스"
FROM emp;
--[1단계:코드] 9. 입사일의 분기(1~4)를 기준으로 출장으로 가기로 했다. 1: 부산,  2: 광주, 3:제주  4: 하와이 
--               사원명, 입사일, 분기, 출장지 를 출력하세요
SELECT ename,TO_NUMBER(TO_CHAR(hiredate,'Q')) "분기(숫자)",
			decode(TO_NUMBER(TO_CHAR(hiredate,'Q')),1,'부산',
                                    				2,'광주',
                                    				3,'제주',
                                    				4,'하와이',
                                    '부서없음') "출장지"
FROM emp;
--[1단계:코드] 10. 급여의 구간별로 등급을 만들어, 사원번호, 이름, 급여, 등급을 출력하세요
--                ex) 0~999 'A', 1000~2999 'B'...
/*
                1) decode문 처리
 등급구간별로 데이터 처리에 대한 규칙성 확인(사칙연산,mod),floor
 			sal/1000
 			1000단위로 나누고 floor처리하면, 0~999==>0
 규칙성이 파악되면 해당 규칙성에 따라 decode처리
*/
SELECT ename, sal,sal/1000,FLOOR(sal/1000),
			decode(FLOOR(sal/1000),0,'A등급',
									1,'B등급',
									2,'C등급',
									3,'D등급',
									4,'E등급',
									5,'F등급',
									'등급없음') "등급"
FROM emp;

--                2) case문 처리
SELECT  ename, sal,
	CASE WHEN sal<=999 THEN 'A등급'
		WHEN SAL<=1999 THEN 'B등급'
		WHEN SAL<=2999 THEN 'C등급'
		WHEN SAL<=3999 THEN 'D등급'
		WHEN SAL<=4999 THEN 'F등급'
		ELSE 'G등급'
		END "등급표"
FROM EMP;




/*
== 평가대비(오라클) 객관식 문제 ==
1. 오라클의 to_char()이용하여 데이터 변환 타입이 아닌 것은? 3번 불형은없음
1) 문자열 2) 숫자형 3) 불형 4) 날짜형

2. 문자열 형변환 형식이 적절하지 않는 것은? 2번 M,MM이있음
1) 세기 - CC
2) 월 - MMM
3) 날짜 - D
4) 분기 - Q

3. 빅데이터 처리 대상이 아닌 것은? 4번 실용기술없음
1) 저장기술
2) 분석기술
3) 표현기술
4) 실용기술 

4. DIKW 계층 구조에 해당하는 것이 아닌 것은? 1번 문서는 없음, 데이터 정보 지식 지혜 계층단게 총 5개있음
1) 문서
2) 데이터
3) 정보
4) 지혜

5. 오라클에서 to_char(데이터,'옵션')으로 시간을 표현하는 옵션은 무엇인가? 3번 MI분인데... H/HH12/HH24 아닌가요..?
1) YYYY --년도
2) DAY -- 요일
3) MI --분
4) Q --분기

정답 : 3,2,4,1,3 
 */
