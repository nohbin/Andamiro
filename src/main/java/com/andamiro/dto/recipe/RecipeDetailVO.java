package com.andamiro.dto.recipe;



public class RecipeDetailVO {
	private int recipeDetailID;
	private int recipeID;
	private int recipeHow;
	private int recipeKind;
	private int recipeMainIngre;
	private RecipePicVO recipePicId;
	private RecipeOrderVO OrderId;
	private RecipeIngreVO recipeingreId;
	private String recipeDiscription;
	private String recipeforperson;
	private String recipefortime;
	private String recipeforlevel;
	
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
	public RecipePicVO getRecipePicId() {
		return recipePicId;
	}
	public void setRecipePicId(RecipePicVO recipePicId) {
		this.recipePicId = recipePicId;
	}
	public RecipeOrderVO getOrderId() {
		return OrderId;
	}
	public void setOrderId(RecipeOrderVO orderId) {
		OrderId = orderId;
	}
	public RecipeIngreVO getRecipeingreId() {
		return recipeingreId;
	}
	public void setRecipeingreId(RecipeIngreVO recipeingreId) {
		this.recipeingreId = recipeingreId;
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
