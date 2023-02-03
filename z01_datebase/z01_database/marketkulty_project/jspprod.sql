DROP TABLE MARKETPROD ;
CREATE TABLE MarketProd(
isbn varchar2(20) PRIMARY KEY,
imgname varchar2(100),
prodname varchar2(100),
brand varchar2(20),
div varchar2(100),
price NUMBER,
discount NUMBER,
information varchar2(2000),
registdate date
);

-- 물건번호용 시퀀스
DROP SEQUENCE marketprod_seq;
CREATE SEQUENCE marketprod_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;

SELECT * FROM (
SELECT rownum AS num,isbn 품번,imgname 파일이름, prodname 품명, brand 브랜드, div 분류,price 가격, discount 할인율,
		information 설명, registdate 등록일자 FROM MARKETPROD
		ORDER BY ROWNUM)
		WHERE num BETWEEN 5 AND 8;  
	

SELECT * FROM MARKETPROD m ;

SELECT DIV ,count(*) FROM MARKETPROD m 
GROUP BY DIV ;

SELECT * FROM MARKETPROD m ;

SELECT * FROM MARKETPROD m
WHERE id='';
AND pass=''

UPDATE MARKETPROD 
SET div= '과일·견과·쌀'
WHERE DIV ='과일';
	

		
isbn,imgname,prodname,brand,div,price, discount,information,registdate
	
--웹페이지에 보여줄 것들만 출력
SELECT imgname,brand,prodname,price,discount,information FROM MARKETPROD; 
--알뜰상품
SELECT imgname,brand,prodname,price,discount,information FROM MARKETPROD 
ORDER BY DISCOUNT DESC;
--신상품
SELECT imgname,brand,prodname,price,discount,information FROM MARKETPROD 
ORDER BY REGISTDATE  DESC;
--검색상품
SELECT imgname,brand,prodname,price,discount,information FROM MARKETPROD 
where ( BRAND || PRODNAME || DIV ||INFORMATION ) like '%'||' '||'%';
--검색상품 갯수
SELECT count(*) FROM MARKETPROD 
where ( BRAND || PRODNAME || DIV ||INFORMATION ) like '%'||'간장'||'%';

DELETE marketprod
WHERE isbn='prod12';

INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'kywie.avif', '국산레드키위350g(4~5입)','Kurly',
			'과일',5800,0,'상큼한 키위속 불은빛 터치',SYSDATE);

DELETE 	MARKETPROD
WHERE PRODNAME ='와사비맛 아몬드(210g)';
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'와사비맛과자.avif', '와사비맛 아몬드(210g)','HBFA',
			'견과류',7500,0,'톡! 쏘는 와사비맛 아몬드',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'멘하코야_돈코츠라멘.avif', '하카타 차슈 돈코츠라멘','하코야',
			'국·반찬·메인요리',9520,20,'맛있는 차슈가 들어간 일식라면',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'다이치_원픽스360다크크레이.avif', '원픽스360 프리미엄 카시트 ISOFIX 다크크레이','다이치',
			'가전제품',499000,20,'아이의 안전한 여행길을 위한 필수품',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'삼성전자_z폴드2종_자급제.avif', 'Z폴드 2종 (자급제)','삼성전자',
			'가전제품',1892000,10,'펼치면 마주하는 더 큰 세상',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'농협_맛있는어린이깍두기.avif', '맛있는 어린이 깍두기','농협풍산김치',
			'국·반찬·메인요리',3800,0,'앙증맞은 크기의 아삭한 깍두기',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'은하수산_간장새우장.avif', '간장 새우장 800g(냉장)','은하수산',
			'수산·해산·건어물',18900,7,'탱글탱글 진한 감칠맛',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'미트클레버_소갈비찜.avif', '소갈비찜','미트클레버',
			'정육·계란',35000,14,'식탁을 빛내는 간편한 메인 요리',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'가농바이오_특란10구.avif', '비타플러스에그 무항생제 1+등급 특란 10구','가농바이오',
			'정육·계란',4200,0,'1구 당 판매가:420원',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'리더브랜드_베이비비트.avif', '베이비 비트 250g','리더브랜드',
			'야채',6400,0,'적지만 강력함으로 똘똘뭉친 수퍼푸드 베이비 비트',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'컬리_무농약연근.webp', '무농약 연근 2종','컬리',
			'야채',6490,0,'용도에 맞게 골라쓰는 무농약 연근(통연근400g,연근채300g)',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'컬리_단호밤 고구마.avif', '무농약 GAP 단호밤 고구마 1.5Kg','컬리',
			'야채',8990,0,'두가지 매력을 품은 고구마',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'양포어장_과메기세트.avif', '과메기 야채세트 807g(냉장)','양포어장',
			'수산·해산·건어물',39900,30,'간편하게 즐기는 겨울 별미',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'풀무원_생소면.avif', '생소면 600g','풀무원',
			'면·양념·오일',3980,0,'생면의 부드럽고 쫄깃한 식감',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'자이카오_현미유1L.avif', '현미유1L','자이카오',
			'면·양념·오일',13000,10,'감마오리자놀 7000mg 함유',SYSDATE);
		
INSERT INTO marketprod values('prod'||marketprod_seq.nextval,'컬리_진미쌀10kg.avif', '밥상의 진미 쌀 10kg','컬리',
			'과일·견과·쌀',29900,0,'매일 부담없이 먹는 쌀(22년산)',SYSDATE);
		


		
SELECT * FROM MARKETPROD
WHERE PRODNAME = '원픽스360 프리미엄 카시트 ISOFIX 다크크레이';


		
			