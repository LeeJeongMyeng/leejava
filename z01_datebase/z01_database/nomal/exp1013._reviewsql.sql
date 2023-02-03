--연도별 사원의 수와 최대급여
SELECT to_char(hiredate,'yyyy') year, COUNT(*) count, max(sal) SAL 
FROM EMP e 
GROUP BY to_char(HIREDATE,'yyyy');

--3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
--     조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요
SELECT e.*, DECODE(div,0,'짝','홀') div2,
		decode(div,0,'100%','50%') bonus_per,
		round(decode(div,0,1,0.5)*sal) bonus,
		sal+round(decode(div,0,1,0.5)*sal) totpay
FROM (
SELECT empno, MOD(empno,2) div,
		ename, sal
FROM emp) e
WHERE div in(0,1);
--프로그램상에 0:짝 1:홀, 0,1전체


--4) 사원정보의 특정 근무일(YYYY/MM/DD)기준(조건)으로 근무연한/개월 수를 표현하세요
