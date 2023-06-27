package com.andamiro.dto.recipe;



public class RecipeDetailVO {
	private int recipeDetailID;
	private int recipeID;
	private int recipeHow;
	private int recipeKind;
	private int recipeMainIngre;
	private RecipePicVO recipePicVO;
	private RecipeOrderVO recipeOrderVO;
	private RecipeIngreVO recipeingreVO;
	private String recipeDiscription;
	private String recipeforperson;
	private String recipefortime;
	private String recipeforlevel;
	
	public RecipePicVO getRecipePicVO() {
		return recipePicVO;
	}
	public void setRecipePicVO(RecipePicVO recipePicVO) {
		this.recipePicVO = recipePicVO;
	}
	public RecipeOrderVO getRecipeOrderVO() {
		return recipeOrderVO;
	}
	public void setRecipeOrderVO(RecipeOrderVO recipeOrderVO) {
		this.recipeOrderVO = recipeOrderVO;
	}
	public RecipeIngreVO getRecipeingreVO() {
		return recipeingreVO;
	}
	public void setRecipeingreVO(RecipeIngreVO recipeingreVO) {
		this.recipeingreVO = recipeingreVO;
	}
	public int getRecipeDetailID() {
		return recipeDetailID;
	}
	public void setRecipeDetailID(int recipeDetailID) {
		this.recipeDetailID = recipeDetailID;
	}
	public int getRecipeID() {
		return recipeID;
	}
	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}
	public int getRecipeHow() {
		return recipeHow;
	}
	public void setRecipeHow(int recipeHow) {
		this.recipeHow = recipeHow;
	}
	public int getRecipeKind() {
		return recipeKind;
	}
	public void setRecipeKind(int recipeKind) {
		this.recipeKind = recipeKind;
	}
	public int getRecipeMainIngre() {
		return recipeMainIngre;
	}
	public void setRecipeMainIngre(int recipeMainIngre) {
		this.recipeMainIngre = recipeMainIngre;
	}

	public String getRecipeDiscription() {
		return recipeDiscription;
	}
	public void setRecipeDiscription(String recipeDiscription) {
		this.recipeDiscription = recipeDiscription;
	}
	public String getRecipeforperson() {
		return recipeforperson;
	}
	public void setRecipeforperson(String recipeforperson) {
		this.recipeforperson = recipeforperson;
	}
	public String getRecipefortime() {
		return recipefortime;
	}
	public void setRecipefortime(String recipefortime) {
		this.recipefortime = recipefortime;
	}
	public String getRecipeforlevel() {
		return recipeforlevel;
	}
	public void setRecipeforlevel(String recipeforlevel) {
		this.recipeforlevel = recipeforlevel;
	}
	
	
	
}
