ALTER TABLE andamiroRecipe ADD CONSTRAINT FK_memberNumber
FOREIGN KEY (memberNumber) REFERENCES andamiromember (memberNumber);

ALTER TABLE andamiroRecipe_detail
ADD CONSTRAINT FK_RecipeID
FOREIGN KEY (recipeID) REFERENCES andamiroRecipe (recipeID)
ON DELETE CASCADE;

ALTER TABLE andamiroRecipe_detail
ADD CONSTRAINT FK_recipeOrder_detail
FOREIGN KEY (OrderId) REFERENCES recipeOrder (recipeOrderId)
ON DELETE CASCADE;


ALTER TABLE andamiroRecipe_detail
ADD CONSTRAINT FK_recipepic_detail
FOREIGN KEY (recipePicId) REFERENCES recipePicture (recipePicid)
ON DELETE CASCADE;


ALTER TABLE andamiroRecipe_detail
ADD CONSTRAINT FK_recipeingre_detail
FOREIGN KEY (recipeingreId) REFERENCES recipeingre (ingreid)
ON DELETE CASCADE;

ALTER TABLE andamiroRecipe_detail
ADD CONSTRAINT FK_recipeingre_detail
FOREIGN KEY (recipeingreId) REFERENCES recipeingre (ingreid)
ON DELETE CASCADE;

ALTER TABLE andamiroRecipe_detail ADD CONSTRAINT FK_recipeKindNumber
FOREIGN KEY (recipeKind) REFERENCES recipekind (recipeKindId);

ALTER TABLE andamiroRecipe_detail ADD CONSTRAINT FK_recipeMainIngre
FOREIGN KEY (recipeMainIngre) REFERENCES recipeMainIngre (recipeIngreId);

ALTER TABLE andamiroRecipe_detail ADD CONSTRAINT FK_recipeHow
FOREIGN KEY (recipeHow) REFERENCES recipeHow (recipeHowId);

ALTER TABLE recipeingre
ADD CONSTRAINT FK_recipeid_recipeingre
FOREIGN KEY (recipeId) REFERENCES andamiroRecipe (recipeId)
ON DELETE CASCADE;

ALTER TABLE recipePicture
ADD CONSTRAINT FK_recipepid_recipePic
FOREIGN KEY (recipeId) REFERENCES andamiroRecipe (recipeId)
ON DELETE CASCADE;

ALTER TABLE recipeOrder
ADD CONSTRAINT FK_recipepid_recipeOrder
FOREIGN KEY (recipeId) REFERENCES andamiroRecipe (recipeId)
ON DELETE CASCADE;

ALTER TABLE andamiroreview
ADD CONSTRAINT FK_member_review
FOREIGN KEY (id) REFERENCES andamiromember (id);

ALTER TABLE andamiroreview
ADD CONSTRAINT FK_recipe_review
FOREIGN KEY (recipeId) REFERENCES andamiroRecipe (recipeId)
ON DELETE CASCADE;

ALTER TABLE subscribeMember 
ADD CONSTRAINT fk_SubmemberNumber 
FOREIGN KEY (memberNumber) REFERENCES andamiroMember(memberNumber);

ALTER TABLE diet 
ADD CONSTRAINT fk_subNumber 
FOREIGN KEY (subNumber) REFERENCES subscribeMember(subNumber);

ALTER TABLE dietDetail 
ADD CONSTRAINT fk_dietNumber 
FOREIGN KEY (dietNumber) REFERENCES diet(dietNumber);

ALTER TABLE subMemberRecipe 
ADD CONSTRAINT FK_submember_recipeid 
FOREIGN KEY (recipeID) REFERENCES ANDAMIRORECIPE (recipeID);

ALTER TABLE subMemberRecipe 
ADD CONSTRAINT FK_subMember 
FOREIGN KEY (subNumber) REFERENCES subscribeMember (subNumber);
