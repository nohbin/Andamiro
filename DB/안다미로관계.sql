
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




