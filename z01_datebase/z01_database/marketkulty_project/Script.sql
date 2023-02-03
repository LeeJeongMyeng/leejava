DROP TABLE PRODINFO;
CREATE TABLE prodinfo(
pinfonum varchar2(20) PRIMARY KEY,
prodname varchar2(100), --물품이름
ship0 varchar2(40),
SHIP varchar2(500), -- 배송정보
packagingtype varchar2(100), --유형포장
packagingbundle varchar2(100), --판매단위
volume varchar2(100), --용량
allergy varchar2(4000), --알러지 정보
warring varchar2(4000) --유의사항
);

DROP SEQUENCE prodinfo_seq;
CREATE SEQUENCE prodinfo_seq
START WITH 1
INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9999;

DELETE PRODINFO
WHERE PINFONUM = 'pi11';

SELECT * FROM PRODINFO p;
WHERE p.prodname=m.PRODNAME 
AND p.prodname LIKE '%'||'간장 새우장 800g(냉장)'||'%';

pinfonum,prodname,ship0,ship,packagingtype,packagingbundle,volume,allergy,warring,isbn,imgname,prodname,brand,div,price,discount,information,registdate

INSERT INTO PRODINFO values('pi'||prodinfo_seq.nextval,'간장 새우장 800g(냉장)','샛별배송',
							'<br>23시 전 주문 시 내일 아침 7시 전 도착(대구·부산·울산 샛별배송 운영시간 별도 확인)',
							'냉장포장','1팩','800g','이 제품은 오징어, 게, 조개류(굴, 전복, 홍합 포함), 돼지고기, 쇠고기를 사용한 제품과 같은 시설에서 제조',
							'반드시 냉장보관하세요.');
INSERT INTO PRODINFO values('pi'||prodinfo_seq.nextval,'베이비 비트 250g','샛별배송',
							'<br>23시 전 주문 시 내일 아침 7시 전 도착(대구·부산·울산 샛별배송 운영시간 별도 확인)',
							'상온(종이포장)','1개(팩)','250g(4~6개)','리더브밴드 베이비비트는  삶은 제품으로  순무처럼 큰 비트가 아닌 알감자 크기의 작고 무른 제형의 비트로  무른 제형은 정상제품이오니 안심하고 드셔도 괜찮습니다.  (바로 섭취가능)<br>
								식품 특성상 중량은 3% 내외의 차이가 발생할 수 있습니다.',
							'식품 특성상 중량은 3% 내외의 차이가 발생할 수 있습니다.');

INSERT INTO PRODINFO values('pi'||prodinfo_seq.nextval,'와사비맛 아몬드(210g)','샛별배송',
							'<br>23시 전 주문 시 내일 아침 7시 전 도착(대구·부산·울산 샛별배송 운영시간 별도 확인)',
							'냉장(종이포장)','1봉','210g','우유, 대두함유<br>본 제품은 땅콩, 계란, 밀, 복숭아, 토마토, 호두, 쇠고기를 사용한 제품과 같은 포장시설에서 생산하였습니다.',
							'유통기한(별도 표기일까지)');
						
INSERT INTO PRODINFO values('pi'||prodinfo_seq.nextval,'하카타 차슈 돈코츠라멘','샛별배송',
							'<br>23시 전 주문 시 내일 아침 7시 전 도착(대구·부산·울산 샛별배송 운영시간 별도 확인)',
							'냉동(종이포장)','1팩','452g','-돼지고기, 닭고기, 밀, 대두, 우유, 쇠고기, 오징어, 계란, 고등어 함유<br>-본 제품은 메밀, 땅콩, 게, 새우, 복숭아, 토마토, 아황산류, 호두, 잣, 조개류(굴, 전복, 홍합 포함)를 사용한 제품과 같은 제조시설에서 제조하고 있습니다. ',
							'유통기한(후면 표기일까지)');
						
INSERT INTO PRODINFO values('pi'||prodinfo_seq.nextval,'원픽스360 프리미엄 카시트 ISOFIX 다크크레이','샛별배송',
							'<br>23시 전 주문 시 내일 아침 7시 전 도착(대구·부산·울산 샛별배송 운영시간 별도 확인)','상온(종이포장)','1개','-','-해당없음-','-해당없음-');
							

							
							
							
							
