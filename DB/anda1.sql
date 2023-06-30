
--회원테이블
CREATE TABLE andamiromember (
  memberNumber NUMBER PRIMARY KEY,
  id VARCHAR2(255) NOT NULL UNIQUE,
  pwd VARCHAR2(255) NOT NULL,
  name VARCHAR2(255) NOT NULL,
  phone VARCHAR2(255) NOT NULL UNIQUE,
  email VARCHAR2(255) NOT NULL UNIQUE,
  joinDate date      default sysdate,
  subscribe VARCHAR2(255),
  adminCode NUMBER
);

--레시피 관련 테이블
CREATE TABLE andamiroRecipe (
	recipeID            NUMBER	        PRIMARY KEY,
	memberNumber        NUMBER          NOT NULL,
    userID              VARCHAR(255),
	recipeName	        VARCHAR(255)	NOT NULL,
	mainPicture	        VARCHAR(255)	NOT NULL,
	recipeGrade	        VARCHAR(255)	NULL,
	recipetag1	        VARCHAR(255)	NULL,
	recipetag2	        VARCHAR(255)	NULL,
	recipetag3	        VARCHAR(255)	NULL,
	recipeView	        NUMBER	        default 0,
	recipeCompetition   NUMBER		    NULL,
    recipeDetailID      NUMBER          NOT NULL,
    recipeRegDate       date            default sysdate
);

create table andamiroRecipe_detail(
    recipeDetailID      NUMBER          PRIMARY KEY,
    recipeID            NUMBER          NOT NULL,
    recipeHow           NUMBER          NOT NULL,
    recipeKind          NUMBER          NOT NULL,
    recipeMainIngre     NUMBER          NOT NULL,
    recipePicId         NUMBER          NOT NULL,
    OrderId             NUMBER          NOT NULL,
    recipeingreId       NUMBER          NOT NULL,
    recipeDiscription   VARCHAR(255)    NOT NULL,
    recipeforperson     VARCHAR(255)    NOT NULL,
    recipefortime       VARCHAR(255)    NOT NULL,
    recipeforlevel      VARCHAR(255)    NOT NULL
);

create table recipekind (
    recipeKindId number primary key,
    recipeKind VARCHAR(255)
);

create table recipeMainIngre(
    recipeIngreId number PRIMARY KEy,
    recipeIngre varchar(255)
);

create table recipeHow(
    recipeHowId number Primary Key,
    recipeHow VARCHAR(255)
);
create table recipeingre (
    ingreid number PRIMARY key,
    recipeId number not null,
    ingre01 varchar(255),
    ingre02 varchar(255),
    ingre03 varchar(255),
    ingre04 varchar(255),
    ingre05 varchar(255),
    ingre06 varchar(255),
    ingre07 varchar(255),
    ingre08 varchar(255),
    ingre09 varchar(255),
    ingre10 varchar(255),
    ingre11 varchar(255),
    ingre12 varchar(255)
);
CREATE TABLE recipePicture (
	recipePicid	NUMBER	PRIMARY key ,
    recipeId number not null,
	pic01	VARCHAR(255)		NULL,
	pic02	VARCHAR(255)		NULL,
	pic03	VARCHAR(255)		NULL,
	pic04	VARCHAR(255)		NULL,
	pic05	VARCHAR(255)		NULL
);
CREATE TABLE recipeOrder (
  recipeOrderId NUMBER PRIMARY KEY,
  recipeId number not null,
  order01 VARCHAR(255),
  order02 VARCHAR(255),
  order03 VARCHAR(255),
  order04 VARCHAR(255),
  order05 VARCHAR(255)
);

--리뷰 테이블
CREATE TABLE andamiroreview (
  reviewnum NUMBER(20) PRIMARY KEY,
  recipeid number NOT NULL,
  id VARCHAR2(255) NOT NULL,
  reviewpicture VARCHAR2(255),
  review VARCHAR2(255),
  recipegrade VARCHAR2(255),
  regdate DATE DEFAULT SYSDATE
);

--구독 테이블
CREATE TABLE subscribeMember (
    	subNumber          NUMBER(5)    PRIMARY KEY,
    	membernumber    NUMBER(5),
    	sub_start             DATE  DEFAULT  SYSDATE,
        sub_end 		DATE  DEFAULT  (SYSDATE + INTERVAL '30' DAY),
        userid varchar2(255)
);
--식단 테이블
CREATE TABLE diet (
	dietNumber	    number(5)		    PRIMARY KEY,
	subNumber	    number(5)		    NULL,
	diet_kind	    	    varchar(255)		    NOT NULL,
	diet_menu	    varchar(255)		    NOT NULL,
	diet_picture             varchar(255)		    NOT NULL
);

CREATE TABLE dietDetail (
	dietDetailID	number(5)		    PRIMARY KEY,
	dietNumber	number(5)		    NOT NULL,
	foodName	varchar(255)		    NOT NULL,
	kcal	            varchar(255)		    NOT NULL,
	component	varchar(1000)		    NOT NULL
); 

CREATE TABLE subMemberRecipe (
	recipeID	number		NOT NULL unique,
	subNumber	number		NOT NULL unique
);
