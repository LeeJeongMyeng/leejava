/*
 #데이터 타입의 변환 
  1. 오라클에서 사용하는 데이터유형은 함수에 의해서 데이터 타입을 변경할 수 있다.
  2. 형변환 유형
  	1) 묵시적 데이터 타입의 변환
  	 	조건문에서 정확하게 해당 type을 맞게 설정하지 않더라도 결과를 검색해주는
  	 	경우가 있는데 이것은 오라클시스템 내부적으로 타입을 변환했기 때문이다.
  	 	ex) select * from emp
  	 		where sal>='2000';
  	 	문자열로'2000'을 입력하더라도, 시스템에서 연산을 인식하여 숫자로 자동형변환
  	 	시켜 처리된다.
  	2) 명시적 데이터 타입의 변환
  		일반적으로 데이터 베이스는 변환함수를 이용하여 데이터 타입을 변환하여
  		효과적으로 처리한다.
  		ex) 현재 컬럼 데이터 유형을 변환해서 조건에 맞게 처리하는 경우
  			where to_char(hiredate,'yyyy')='2022'
  			==> 날짜형인 데이터를 문자형 날짜만 추출하여 비교하여 검색
  			해당 컬럼에 맞게 데이터 유형을 변환해서 처리하는경우
  			where hiredate=to_date('2022-01-12','yyyy-mm-dd')
  			intsert emp(hiredate) values(to_date('2022-01-12','yyyy-mm-dd'))
  			
  		
  		-to_char(컬럼/데이터, '변환형식') 숫자/날짜 타입을 문자열로
  			변환해주는 함수이다.
  		-to_number(컬럼/데이터) : 날짜/문자 타입을 숫자로 변환해주는 함수
  		-to_date(컬럼/데이터) : 숫자/문자 타입을 날짜로 변환해주는 함수
  		 ex)2022/01/12날짜 등록? '2022/01/12'문자열
  		 	문자열을 날짜형 데이터에 넣을떄, 형식을 지정해서 등록
  		 	to_date('2022-01-12''yyyy-mm-dd')
  	ps)명시적 타입변환을 통해서 서버의 판단에 무리를 주지않고, index나
  		기타 데이터 처리에 효율화를 줄 수 있다.
 */
SELECT * FROM emp WHERE sal>='2000';
SELECT sal+TO_NUMBER('2000')"합",e.*
FROM EMP e
WHERE SAL >=TO_NUMBER('2000'); --명시적 변환 처리

SELECT ename, hiredate, TO_CHAR(hiredate)
FROM emp
WHERE hiredate LIKE '81/12%';
--실제 저장된 데이터는 날짜형이지만, 묵시적 형변환에 의해 문자열로 변환된
-- 형식을 기준으로 검색이 가능해진다.

--ex) 12월에 입사한 사원을 묵시적 형변환에의해 검색하세요
SELECT ename,hiredate, TO_CHAR(HIREDATE)
FROM emp
WHERE  substr(hiredate,4,2)='12';

/*
 # to_char
 	1.날짜/숫자를 원하는 형식으로 데이터를 처리하기 위하여 사용된다.
 	2. 기본형식
 		to-char(데이터, 출력할 형식)
 3. 출력할 형식
 	1)CC: 세기
 	2)YYYY/YYY/YY/Y 년도 표기
 	3)AD/A.D : AD/BC표기
 	4)Q : 1~4분기
 	5)MM/MONTH/MON : 월표기
 	6) WW/W :연을 주간단위로 표기/월을 주단위로 표기
 	7) DDD/DD/D:날짜표기
 	8) DY/DAY : 요일표기
 	위의 형식에 한글등 특수문자를 혼합해서 표기할때에는 
 	'YYYY"년도" MM"월"' 형식으로 "추가문자열을 표현한다. 
 */
SELECT ENAME,HIREDATE, TO_CHAR(HIREDATE,'CC"세기" AD YYYY/MM/DD Q"분기" MM"월 W"째주" DAY') SHOW,
		to_char(hiredate,'cc')"세기",
		to_char(hiredate,'yyyy')"년도",
		to_char(hiredate,'q')"분기",
		to_char(hiredate,'mm')"월",
		to_char(hiredate,'dd')"일"
FROM EMP;

-- ex1) @@@(사원명)는 @@년 @@월에 @@/4분기 입사했습니다.
--SELECT ename,hiredate, to_char(ENAME||"는"||' yy"년" mm"월에" Q"분기입사" ') SHOW
SELECT ENAME||'는'||
      TO_CHAR(HIREDATE,'YY"년" MM"월" Q"분기에"')||'입사했습니다' SHOW
FROM EMP;
--ex2) 1/4분기에 입사한 사원의 이름과 입사년월일출력
SELECT ENAME,TO_CHAR(hiredate, 'yyyy/mm/dd') "입사년월일"
FROM emp
WHERE TO_CHAR(HIREDATE,'Q')='1';

/*
 #data 타입의 시간 표시 형식
 1.AM/PM : 오전/오후 시간표시
 2. A.M/P.M : 오전/오후 시간표시
 3. HH/HH12: 12시간으로 시간표시
 4. HH24 : 24시간으로 시간표시
 5. MI:분
 6. SS:초
 */
SELECT sysdate, to_char(sysdate,'AM HH:MI:SS')"시간" FROM DUAL;
--ex) sysdate를 활용해서 현재시간을 @@시 @@분 @@초 (24시) 표시형태로 출력
SELECT sysdate, to_char(SYSDATE, 'hh24"분" MI"분" SS"초"') FROM DUAL;

/*
 #숫자형 데이터를 문자열 형식으로 변환처리
 1. 기본형식 : to_char(숫자형데이터,'형식)
 2. 주요 형식
 	 해당 자리수 이상의 데이터가 처리될때는 ###으로 표시된다.
 	 9999:기본자리수에 맞게 처리
 	 0000: 해당 자리수이하 일 때는 0으로 채워짐
 	 $ :앞에 $표기
 	 . : 특정한 자리의 소숫점 표기
 	 , : 특정한 위치에 ,를 표기 
 	 ==>DB ----------> JAVA(프로그램 연동)
 	 	문자열(숫자형,날짜형) ==>String
 	 	Date ===> Date
*/
SELECT ename, sal, TO_CHAR(sal,'99999') "형식1",
		TO_CHAR(sal,'00000') "형식2", 
		TO_CHAR(sal,'$99999') "형식3", 
		TO_CHAR(sal,'9,999') "형식4", 
		TO_CHAR(sal,'9,999.999') "형식5", 
		TO_CHAR(sal*10000,'99,999.999') "형식6",
		TO_CHAR(sal*10000,'999999,999.999') "형식7"
FROM emp;
--ex) 사원명, 급여, 급여2(천단위 콤마 앞에$표기, 소숫점1자리표기)
SELECT ename,sal,TO_CHAR(sal,'$9,999.9')
FROM emp;


