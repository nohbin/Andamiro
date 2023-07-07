insert into andamiromember
values(member_seq.nextval,'admin','c30a26c19c22a2b14c996cb847f9157c9864f705b20ae3abea8b346113d5f8e0','관리자','9999','9999','','','999');

insert into recipekind values(01 , '한식');
insert into recipekind values(02 , '일식');
insert into recipekind values(03 , '양식');
insert into recipekind values(04 , '중식');
insert into recipekind values(99 , '기타');

insert into recipehow values(1,'볶음');
insert into recipehow values(2,'튀김');
insert into recipehow values(3,'삶기');
insert into recipehow values(4,'끓이기');
insert into recipehow values(5,'굽기');
insert into recipehow values(6,'찜');
insert into recipehow values(99,'기타');

insert into recipemainingre values(1,'돼지고기');
insert into recipemainingre values(2,'소고기');
insert into recipemainingre values(3,'닭고기');
insert into recipemainingre values(4,'육류');
insert into recipemainingre values(5,'해물');
insert into recipemainingre values(99,'기타');


--diet 데이터 추가문
insert into diet values(dietNum_seq.NEXTVAL,'','추천식단','아침','rec1.png'); 
insert into diet values(dietNum_seq.NEXTVAL,'','추천식단','점심','rec2.png');
insert into diet values(dietNum_seq.NEXTVAL,'','추천식단','저녁','rec3.png');
insert into diet values(dietNum_seq.NEXTVAL,'','간단식단','양파계란덮밥','simple1.png'); 
insert into diet values(dietNum_seq.NEXTVAL,'','간단식단','냉라면','simple2.jpg');
insert into diet values(dietNum_seq.NEXTVAL,'','간단식단','단호박에그슬럿','simple3.png');
insert into diet values(dietNum_seq.NEXTVAL,'','저칼로리식단','양배추 오코노미야끼','low1.png'); 
insert into diet values(dietNum_seq.NEXTVAL,'','저칼로리식단','두부유부초밥','low2.png');
insert into diet values(dietNum_seq.NEXTVAL,'','저칼로리식단','곤약떡볶이','low3.png');
insert into diet values(dietNum_seq.NEXTVAL,'','프로틴식단','키토김밥, 등갈비','protein1.png'); 
insert into diet values(dietNum_seq.NEXTVAL,'','프로틴식단','두부동그랑땡, 고등어구이','protein2.png');
insert into diet values(dietNum_seq.NEXTVAL,'','프로틴식단','닭가슴살 샐러드','protein3.png');

--dietDetail 추가문 

insert into dietDetail values (dietDetailID_seq.nextval,'1','흑미밥','348.7kcal','탄수화물(80.14g), 단백질(6.53g), 지방(0.22g), 당류(0.04g), 나트륨(3.51mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'1','잡채','355kcal','탄수화물(61g), 단백질(10g), 지방(8g), 당류(12g), 나트륨(1405mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'1','청국장','272kcal','탄수화물(21g), 단백질(20g), 지방(12.8g), 당류(8g), 나트륨(1529mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'1','낙지젓갈','15kcal','탄수화물(1.73g), 단백질(1.16g), 지방(0.34g), 당류(0.06g), 나트륨(84mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'1','상추겉절이','33kcal','탄수화물(4.8g), 단백질(1.72g), 지방(1.27g), 당류(1.22g), 나트륨(159mg)');

insert into dietDetail values (dietDetailID_seq.nextval,'2','쌀밥','270kcal','탄수화물(65.15g), 단백질(5.71g), 지방(1g), 당류(0g), 나트륨(5mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'2','LA갈비','676kcal','탄수화물(4.24g), 단백질(45.08g), 지방(52.3g), 당류(0.88g), 나트륨(919mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'2','콩나물국','41kcal','탄수화물(5.87g), 단백질(2.17g), 지방(1.54g), 당류(1.74g), 나트륨(672mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'2','김','9kcal','탄수화물(1.33g), 단백질(1.51g), 지방(0.07g), 당류(0.13g), 나트륨(12mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'2','파절이무침','41kcal','탄수화물(6.99g), 단백질(1.95g), 지방(1.3g), 당류(1.97g), 나트륨(154mg)');

insert into dietDetail values (dietDetailID_seq.nextval,'3','흑미밥','348.7kcal','탄수화물(80.14g), 단백질(6.53g), 지방(0.22g), 당류(0.04g), 나트륨(3.51mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'3','제육볶음','572kcal','탄수화물(31.12g), 단백질(39.64g), 지방(33.08g), 당류(20.94g), 나트륨(832mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'3','된장찌개','171kcal','탄수화물(16.77g), 단백질(15.01g), 지방(5.6)g), 당류(3.8g), 나트륨(682mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'3','콩나물무침','38kcal','탄수화물(5.99g), 단백질(2.31g), 지방(1.13g), 당류(1.97g), 나트륨(401mg))');
insert into dietDetail values (dietDetailID_seq.nextval,'3','무생채','80kcal','탄수화물(14.34g), 단백질(2.3g), 지방(2.28g), 당류(8.06g), 나트륨(450mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'3','시금치나물','57kcal','탄수화물(6.16g), 단백질(2.74g), 지방(3.08g), 당류(0.81g), 나트륨(497mg)');

insert into dietDetail values (dietDetailID_seq.nextval,'4','쌀밥','270kcal','탄수화물(65.15g), 단백질(5.71g), 지방(1g), 당류(0g), 나트륨(5mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'4','달걀','74kcal','탄수화물(0.38g), 단백질(6.29g), 지방(4.97g), 당류(0.38g), 나트륨(70mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'4','양파','42kcal','탄수화물(10.11g), 단백질(0.92g), 지방(0.08g), 당류(4.28g), 나트륨(3mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'4','대파','34kcal','탄수화물(6.5g), 단백질(1.9g), 지방(0.4g), 당류(3.2g), 나트륨(17mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'4','간장','16kcal','탄수화물(3.5g), 단백질(2g), 지방(0.03g), 당류(0.7g), 나트륨(902mg)');

insert into dietDetail values (dietDetailID_seq.nextval,'5','라면','385kcal','탄수화물(55.68g), 단백질(7.9g), 지방(14.54g), 당류(0.62g), 나트륨(986mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'5','달걀','74kcal','탄수화물(0.38g), 단백질(6.29g), 지방(4.97g), 당류(0.38g), 나트륨(70mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'5','콩나물','16kcal','탄수화물(2.63g), 단백질(2.01g), 지방(0.27g), 당류(1.03g), 나트륨(3mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'5','식초','3kcal','탄수화물(0.01g), 단백질(0g), 지방(0g), 당류(0.01g), 나트륨(0mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'5','간장','16kcal','탄수화물(3.5g), 단백질(2g), 지방(0.03g), 당류(0.7g), 나트륨(902mg)');

insert into dietDetail values (dietDetailID_seq.nextval,'6','단호박','49kcal','탄수화물(11.67g), 단백질(1.37g), 지방(0.34g), 당류(3.95g), 나트륨(7mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'6','베이컨','51kcal','탄수화물(0.07g), 단백질(2.75g), 지방(4.9g), 당류(0g), 나트륨(145mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'6','양파','42kcal','탄수화물(10.11g), 단백질(0.92g), 지방(0.08g), 당류(4.28g), 나트륨(3mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'6','달걀','74kcal','탄수화물(0.38g), 단백질(6.29g), 지방(4.97g), 당류(0.38g), 나트륨(70mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'6','모짜렐라치즈','254kcal','탄수화물(3.5g), 단백질(24.26g), 지방(15.92g), 당류(1.13g), 나트륨(619mg)');

insert into dietDetail values (dietDetailID_seq.nextval,'7','양배추','24kcal','탄수화물(5.58g), 단백질(1.44g), 지방(0.12g), 당류(3.58g), 나트륨(18mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'7','달걀','74kcal','탄수화물(0.38g), 단백질(6.29g), 지방(4.97g), 당류(0.38g), 나트륨(70mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'7','닭가슴살','109kcal','탄수화물(0g), 단백질(22.98g), 지방(1.23g), 당류(0g), 나트륨(65mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'7','올리브유','119kcal','탄수화물(0g), 단백질(0g), 지방(13.5g), 당류(0g), 나트륨(0mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'7','스리라차 소스','5kcal','탄수화물(1g), 단백질(0g), 지방(0g), 당류(1g), 나트륨(70mg)');

insert into dietDetail values (dietDetailID_seq.nextval,'8','두부','99kcal','탄수화물(3.51g), 단백질(10.12g), 지방(5.26g), 당류(1.26g), 나트륨(37mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'8','유부','220kcal','탄수화물(11g), 단백질(14g), 지방(18g), 당류(9g), 나트륨(150mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'8','파프리카','15kcal','탄수화물(3.43g), 단백질(0.64g), 지방(0.13g), 당류(1.78g), 나트륨(2mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'8','오이','21kcal','탄수화물(10.93g), 단백질(1.96g), 지방(0.33g), 당류(2.02g), 나트륨(3mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'8','당근','31kcal','탄수화물(9.58g), 단백질(0.93g), 지방(0.24g), 당류(4.54g), 나트륨(69mg)');

insert into dietDetail values (dietDetailID_seq.nextval,'9','곤약','15kcal','탄수화물(6.2g), 단백질(0.14g), 지방(0.02g), 당류(0.04g), 나트륨(4mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'9','양배추','24kcal','탄수화물(5.58g), 단백질(1.44g), 지방(0.12g), 당류(3.58g), 나트륨(18mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'9','달걀','74kcal','탄수화물(0.38g), 단백질(6.29g), 지방(4.97g), 당류(0.38g), 나트륨(70mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'9','고추장','33kcal','탄수화물(7.42g), 단백질(0.66g), 지방(0.33g), 당류(3.6g), 나트륨(251mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'9','올리고당','24kcal','탄수화물(7.5g), 단백질(0g), 지방(0g), 당류(3.5g), 나트륨(0mg)');

insert into dietDetail values (dietDetailID_seq.nextval,'10','달걀','74kcal','탄수화물(0.38g), 단백질(6.29g), 지방(4.97g), 당류(0.38g), 나트륨(70mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'10','김','9kcal','탄수화물(1.33g), 단백질(1.51g), 지방(0.07g), 당류(0.13g), 나트륨(12mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'10','당근','31kcal','탄수화물(9.58g), 단백질(0.93g), 지방(0.24g), 당류(4.54g), 나트륨(69mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'10','부추','30kcal','탄수화물(4.35g), 단백질(3.27g), 지방(0.73g), 당류(1.85g), 나트륨(3mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'10','등갈비','282kcal','탄수화물(5g), 단백질(16.12g), 지방(23.58g), 당류(1.3g), 나트륨(324mg)');

insert into dietDetail values (dietDetailID_seq.nextval,'11','두부','99kcal','탄수화물(3.51g), 단백질(10.12g), 지방(5.26g), 당류(1.26g), 나트륨(37mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'11','돼지고기','263kcal','탄수화물(0g), 단백질(16.88g), 지방(21.19g), 당류(0g), 나트륨(56mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'11','부추','30kcal','탄수화물(4.35g), 단백질(3.27g), 지방(0.73g), 당류(1.85g), 나트륨(3mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'11','고등어','379kcal','탄수화물(0.7g), 단백질(35.18g), 지방(25.19g), 당류(0.18g), 나트륨(735mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'11','올리브유','119kcal','탄수화물(0g), 단백질(0g), 지방(13.5g), 당류(0g), 나트륨(0mg)');

insert into dietDetail values (dietDetailID_seq.nextval,'12','닭가슴살','109kcal','탄수화물(0g), 단백질(22.98g), 지방(1.23g), 당류(0g), 나트륨(65mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'12','파프리카','15kcal','탄수화물(3.43g), 단백질(0.64g), 지방(0.13g), 당류(1.78g), 나트륨(2mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'12','양상추','11kcal','탄수화물(2.28g), 단백질(0.89g), 지방(0.11g), 당류(1g), 나트륨(15mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'12','적양배추','31kcal','탄수화물(7.37g), 단백질(1.43g), 지방(0.16g), 당류(3.91g), 나트륨(27mg)');
insert into dietDetail values (dietDetailID_seq.nextval,'12','오리엔탈 소스','65kcal','탄수화물(9.1g), 단백질(0.5g), 지방(0.53g), 당류(4.5g), 나트륨(710mg)');
