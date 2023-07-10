--시퀀스
CREATE SEQUENCE member_seq START WITH 1 INCREMENT BY 1 nocache;
CREATE SEQUENCE recipeid_seq START WITH 1 INCREMENT BY 1 nocache;
CREATE SEQUENCE recipedetailid_seq START WITH 1 INCREMENT BY 1 nocache;
CREATE SEQUENCE ingreid_seq START WITH 1 INCREMENT BY 1 nocache;
CREATE SEQUENCE orderid_seq START WITH 1 INCREMENT BY 1 nocache;
CREATE SEQUENCE picid_seq START WITH 1 INCREMENT BY 1 nocache;
CREATE SEQUENCE reviewnum_seq START WITH 1 INCREMENT BY 1 nocache;
CREATE SEQUENCE  dietNum_seq START WITH 1 INCREMENT BY 1 nocache;
CREATE SEQUENCE   subNum_seq START WITH 1 INCREMENT BY 1 nocache;
CREATE SEQUENCE   dietDetailID_seq START WITH 1 INCREMENT BY 1 nocache;

--인덱스
create index index_recipeid_desc on andamirorecipe(recipeid desc);
