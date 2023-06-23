

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

insert into recipekind values(
    01 , '한식'
);
insert into recipekind values(
    02 , '일식'
);
insert into recipekind values(
    03 , '양식'
);
insert into recipekind values(
    04 , '중식'
);
insert into recipekind values(
    99 , '기타'
);

insert into recipehow values(
    1,'볶음'
);
insert into recipehow values(
    2,'튀김'
);
insert into recipehow values(
    3,'삶기'
);
insert into recipehow values(
    4,'끓이기'
);
insert into recipehow values(
    5,'굽기'
);
insert into recipehow values(
    6,'찜'
);
insert into recipehow values(
    99,'기타'
);

insert into recipemainingre values(
    1,'돼지고기'
);
insert into recipemainingre values(
    2,'소고기'
);
insert into recipemainingre values(
    3,'닭고기'
);
insert into recipemainingre values(
    4,'육류'
);
insert into recipemainingre values(
    5,'해물'
);
insert into recipemainingre values(
    99,'기타'
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
  
  
  
ALTER TABLE andamiroRecipe ADD CONSTRAINT FK_memberNumber
FOREIGN KEY (memberNumber) REFERENCES andamiromember (memberNumber);
  
ALTER TABLE andamiroRecipe_detail ADD CONSTRAINT FK_RecipeID
FOREIGN KEY (recipeID) REFERENCES andamiroRecipe (recipeID);
  
ALTER TABLE andamiroRecipe_detail ADD CONSTRAINT FK_recipeOrder_detail
FOREIGN KEY (OrderId) REFERENCES recipeOrder (recipeOrderId);

ALTER TABLE andamiroRecipe_detail ADD CONSTRAINT FK_recipepic_detail
FOREIGN KEY (recipePicId) REFERENCES recipePicture (recipePicid);

ALTER TABLE andamiroRecipe_detail ADD CONSTRAINT FK_recipeingre_detail
FOREIGN KEY (recipeingreId) REFERENCES recipeingre (ingreid);

ALTER TABLE andamiroRecipe_detail ADD CONSTRAINT FK_recipeKindNumber
FOREIGN KEY (recipeKind) REFERENCES recipekind (recipeKindId);

ALTER TABLE andamiroRecipe_detail ADD CONSTRAINT FK_recipeMainIngre
FOREIGN KEY (recipeMainIngre) REFERENCES recipeMainIngre (recipeIngreId);

ALTER TABLE andamiroRecipe_detail ADD CONSTRAINT FK_recipeHow
FOREIGN KEY (recipeHow) REFERENCES recipeHow (recipeHowId);

ALTER TABLE recipeingre ADD CONSTRAINT FK_recipeid_recipeingre
FOREIGN KEY (recipeId) REFERENCES andamiroRecipe (recipeId);

ALTER TABLE recipePicture ADD CONSTRAINT FK_recipepid_recipePic
FOREIGN KEY (recipeId) REFERENCES andamiroRecipe (recipeId);

ALTER TABLE recipeOrder ADD CONSTRAINT FK_recipepid_recipeOrder
FOREIGN KEY (recipeId) REFERENCES andamiroRecipe (recipeId);

CREATE SEQUENCE recipeid_seq START WITH 1 INCREMENT BY 1 nocache;
CREATE SEQUENCE recipedetailid_seq START WITH 1 INCREMENT BY 1 nocache;
CREATE SEQUENCE ingreid_seq START WITH 1 INCREMENT BY 1 nocache;
CREATE SEQUENCE orderid_seq START WITH 1 INCREMENT BY 1 nocache;
CREATE SEQUENCE picid_seq START WITH 1 INCREMENT BY 1 nocache;





  
