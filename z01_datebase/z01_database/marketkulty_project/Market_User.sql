CREATE TABLE BookUser(
USERno varchar2(20) PRIMARY KEY, --회원 번호
div varchar2(20) CONSTRAINT BookUser_div_ck check(div IN ('관리자','회원')), -- 구분(관리자/회원)
username varchar2(20), -- 회원이름
rrn char(14), --주민등로번호
address varchar2(100), -- 주소
Phone_Number char(13), --전화번번호/ -까지 포함하여 15자리할지 고민
id varchar2(20), --회원 아이디
password varchar2(20), -- 회원 패스워드
rentalcnt NUMBER, -- 대여 횟수
returnwarning number
);

