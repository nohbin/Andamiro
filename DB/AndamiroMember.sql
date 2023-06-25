-- 시퀀스 생성
CREATE SEQUENCE member_seq START WITH 1 INCREMENT BY 1 nocache;

-- 테이블 생성
CREATE TABLE andamiromember (
  memberNumber NUMBER PRIMARY KEY,
  id VARCHAR2(255) NOT NULL UNIQUE,
  pwd VARCHAR2(255) NOT NULL,
  name VARCHAR2(255) NOT NULL,
  phone VARCHAR2(255) NOT NULL UNIQUE,
  email VARCHAR2(255) NOT NULL UNIQUE,
  joinDate VARCHAR2(255),
  subscribe VARCHAR2(255),
  adminCode NUMBER
);

insert into andamiromember
values(member_seq.nextval,'admin','1234','관리자','9999','9999','','','999');
