/*
 #to_number : 숫자형으로 변환
 	1.매개변수로 받은 숫자형 문자열을 숫자로 변환하여 연산이 가능하도록 처리한다.
 	2.형식
 		to_number('숫자형문자열')
 	cf) 주로 자동형변환이 일어나서 사용되지 않는 경우도 많으나, 명시적 처리로
 		해당 타입에 대한 구분을 명확히 하기위하여 사용된다.
 */
  SELECT '25'+25 "자동형변환",
  		 TO_NUMBER('25')+25 "명시적형변환"
 FROM dual;
--ex) 입사 분기별 보너스를 1사분기 100%, 2사분기 200% 3사분기#00% 4사분기400%
--    로 처리하기로했다. 사원명,급여, 보너스를 출력하세요
SELECT ename,sal,comm,TO_CHAR(HIREDATE,'Q')*100||'%' "보너스%", --묵시
		SAL*TO_CHAR(HIREDATE,'Q') "보너스+월급", --묵시
		SAL+SAL*TO_NUMBER(TO_CHAR(HIREDATE,'Q')) "급여+보너스+월급" --명시
 FROM EMP;

 /* 
 #to_date :날짜형으로 변환
 	1. 숫자와 문자로 구성된 문자열을 날짜 데이터로 변환시키는 함수
 	2. 기본 형식
 		to_date(문자열데이터,'변환할 형식')
 		해당 문자열이 어떤 데이터를 내포해 있는 형식을 지정하여 문자열 데이터를
 		숫자형으로 전환해서 입력가능하게 한다.
 		주로 숫자형 데이터를 등록, 수정시 많이 사용한다.
 		 ex) 기존 날짜형 데이터와 연산이 필요로 하는 경우
 		 		@@+25, months_between(sysdate,@@)
 		 	  날짜형 데이터를 입력/수정(문자열==>날짜형)
 		 	  
 	3. 변환형식- to_char()에서 날짜형 옵션 처리형식 내용이 사용된다.
 */
SELECT floor(SYSDATE - to_date('2022-09-01','yyyy--mm--dd')) "9/1부터 오늘까지"
FROM dual;

--ex) 2022-12-31 이 현재로부터 남은 날짜수를 to-date함수로 처리하여 출력
SELECT to_date('2022-12-31','yyyy-mm-dd')-SYSDATE  "남은기간"
FROM dual;

--ex) 입사년도만 현재년도로 바꾸어서 날짜데이터를 만든후 사원명, 입사일을 출력하세요
SELECT hiredate, TO_CHAR(hiredate,'mm-dd') "입사월일",
       TO_DATE(TO_CHAR(SYSDATE,'YYYY')||TO_CHAR(hiredate,'mmdd'),'YYYYMMDD') "ㅋㅋ"
FROM emp;
--===================================================================================
/*
 #중첩함수  f3(f2(f1(데이터,매개변수),매개변수),매개변수)
 	1. 가장 내부에 있는 함수 f1의 결과값을 다음함수 f2에 인수로 적용하고,
 		다시 f2의 결과값을 f3에 인수로 사용할때, 활용하는 함수형태를 말한다.
 			-특정한 데이터에서 여러가지 함수의 기능을 처리하고자 할때, 활용된다.
 			- 
 		*/
/*
 #일반함수
 1. nvl(데이터, null값일 때 처리할 데이터)
 	해당 데이터가null일때, 처리할 데이터를 설정함으로 null에 대한 연산 처리를 한다.
 */
SELECT ename,sal,comm,sal+comm, nvl(comm,0), sal+nvl(comm,0)
FROM emp;

/*
 2. nvl2(데이터,null아닐때 처리,null일때 처리)
 - comm 이 null일때 100, null이 아닐때는 comm에서 10%더 추가해서
 결과값처리
 */
SELECT ename, sal, comm, nvl2(comm,comm*1.1,100) "보너스"
FROM emp;
--ex) comm이  null일 때 sal의 15%로 설정,null이 아닐때는 comm+sal의5% 더해서 보너스금액
SELECT ename, sal, comm,comm+(sal*0.05) "null아닐때",sal*0.15 "null일때",
			trunc(nvl2(comm,comm+(sal*0.05),sal*0.15),-1) "보너스"
FROM emp;
--================================================================================
/*
 # nullif(데이터1,데이터2)
 두개의 매개변수로 받는 데이터를 비교하여 동일하면 null을 반환하고,
 동일하지않으면 첫번째 데이터1을 반환하는 함수를 말한다. 
 */
SELECT nullif('a','a') show1,
		nullif('a','b') show2,
		nullif(15,20)show3,
		nvl(nullif('a','a'),'동일')show4,
		nvl(nullif('a','b'),'동일')show5
FROM dual;
-- nvl(nullif()) : 중첩함수로 동일할 때, 처리한 데이터를nvl로 처리한다.


-- ex) 보너스를 600으로 일괄 지급하기로했는데 급여의 50%로 100단위 절삭과 동일하면
--     600그대로 지급, 그렇지 않으면 comm지급처리
SELECT ename, sal,comm, trunc(sal*0.5,-2) "기준",
nvl2(NULLIF(trunc(sal*0.5,-2),600),comm,600) "보너스"
FROM emp;
--=============================================================================================
/*
 #decode함수
 	1. 프로그래밍 언어의 if문이나 case문으로 표현되는 내용을 하나의 함수로 처리할 수 있게 해준다.
 	2. 기본 형식
 		decode(데이터,케이스1,처리1,
 				    케이스2,처리2,
 				    ...
 				    그외처리)
 */
SELECT ename, deptno, decode(deptno,10,'인사',
                                    20,'총무',
                                    30,'회계',
                                    '부서없음') "part"
FROM emp;
--ex) 사원번호기준으로 짝수이면 홍팀, 홀수이면 청팀으로 출력하세요
SELECT ename,empno, mod(empno,2)"구분자",
-- MOD(m,n) m을n으로 나누었을때, 나머지값 반환
DECODE(MOD(empno,2),0,'홍','청') "team"
FROM emp;
--실무예졔 decode(mod()) : 숫자형 데이터에서 특정단위로 구분하여 데이터를 처리할때,
--                       둘중에 하나 혹은 셋중에 하나일때는 나머지 값을 기준으로 처리


-- ex) 직책을 기준으로 보너스를 50%,80%,100%,120%,150%를 주기로했다.
--     이름,급여,보너스% job CLERK,SALESMAN,MANAGER,PRESIDENT,ANALYST
--   *조건 처리시 일단, 항목에 대해 규칙성이있는지 여부를 판단(/,mod)
SELECT ENAME, SAL, JOB,
--리스트해서 JOB의 중복 제거를 원할땐, DISTINCT JOB을 해주면 중복처리하여 값이 보여진다
DECODE(JOB,'CLERK','50%','SALESMAN','80%','MANAGER','100%','PRESIDENT','120%','ANALYST','150%','보너스없음') "보너스%",  
sal*DECODE(JOB,'CLERK',0.5,'SALESMAN',0.8,'MANAGER',1,'PRESIDENT',1.2,'ANALYST',1.5,'보너스없음') "보너스값",  
DECODE(JOB,'CLERK',SAL*1.5,'SALESMAN',SAL*1.8,'MANAGER',SAL*2,'PRESIDENT',SAL*2.2,'ANALYST',SAL*2.5,'보너스없음')
"보너스"
FROM emp;

SELECT DISTINCT JOB 
FROM EMP e;

/*
 	#일반 함수 case
 		1. decode의 확장된 함수 형식을 표현식 또는 컬럼값'=' 비교를 통해
 			조건이 일치하는 경우에만 다른값을 대치하지만, 
 			case함수에서는 산술연산, 관계연산, 논리연상을 통해서  boolean
 			으로 범위를 지정하여 다양한 비교가 가능하게 해준다.
 		2. 기본형식
 			1) 조건문 형태의 활용
 				case when 논리|산술|관계 then 처리한데이터
 				case when 논리|산술|관계 then 처리한데이터 :상단에 when조건을 제외하고,..
 				...
 					else 위의 나열된 경우가 아닌 경우 
 				end
 				주의 case when구문의 앞에 선언 조건식을 제외한 조건을 처리한다.
 				ex) 자바의 if문처럼
 				if(point>=90){
 				}else if(point <80){
 				}
					 				
 				
 				
 			2) switch case 문형태
 				case 컬럼/데이터
 					when 데이터1 then 처리할 데이터
 					when 데이터2 then 처리할 데이터
 					..
 					else 그외 처리데이터
 					end
 */
-- 부서에 따라 보너스를 다르게 처리
SELECT ename, deptno,
		CASE  WHEN deptno = 10 THEN sal*0.2
		  		WHEN deptno = 20 THEN sal*0.5
		 	    WHEN deptno = 30 THEN sal*0.7
		 	    ELSE sal*1.2
		 	    END "보너스"
FROM emp;

SELECT ename, sal,
	CASE WHEN sal>=5000 THEN 'A등급'
		WHEN SAL>=4000 THEN 'B등급' -- sal<5000 AND가 포함되어 있기에 필요X
		WHEN SAL>=3000 THEN 'C등급'
		WHEN SAL>=2000 THEN 'D등급'
		WHEN SAL>=1000 THEN 'F등급'
		ELSE 'G등급'
		END "등급표"
FROM EMP;


select * from emp100 where sal=(SELECT MAX(SAL) FROM EMP100 WHERE JOB ='MANAGER');