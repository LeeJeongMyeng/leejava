SELECT * FROM dept100;

UPDATE DEPT100
SET deptno=13,
	dname ='아이티사업부',
	loc = '제주도'
WHERE deptno = 11;

DELETE FROM DEPT100
WHERE deptno = 13;
SELECT * FROM MEMBER;

--분기 정보와 급여의 범위를 받아서 해당 분기의 최고급여를 리스트 처리
--분기 정보가 없으면, 전체 분기별 급여
--급여의 범위가 없으면 전체 급여
-- pstmt + 동적 query
SELECT empno,ename,qm.qu||'/4',SAL  FROM emp e,(
SELECT to_char(hiredate,'q') qu, max(sal) msal
FROM EMP e 
GROUP BY to_char(hiredate,'q')
) qm
WHERE TO_CHAR(e.hiredate,'q')= qu
AND sal =msal
AND qu = '3'
AND sal BETWEEN 1000 AND 3000;

/*
SELECT empno,ename,qm.qu||'/4',SAL  FROM emp e,(
SELECT to_char(hiredate,'q') qu, max(sal) msal
FROM EMP e 
GROUP BY to_char(hiredate,'q')
) qm
WHERE TO_CHAR(e.hiredate,'q')= qu
AND sal =msal
AND qu = ?
AND sal BETWEEN ? AND ? 
*/

/*
public List<ExpVO> getList(ExpVO sch){}


