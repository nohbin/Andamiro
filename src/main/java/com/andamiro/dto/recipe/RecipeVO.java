package com.andamiro.dto.recipe;

import java.sql.Timestamp;

public class RecipeVO {

	private int recipeID;
	private int memberNumber;
	private String userId;
	private String recipeName;
	private String mainPicture;
	private String recipeGrade;
	private String recipetag1;
	private String recipetag2;
	private String recipetag3;
	private int recipeView;
	private int recipeCompetition;
	private int recipeDetailID;
	private Timestamp recipeRegDate;
	private RecipeDetailVO recipeDetailVO;
	private int reviewCount;
	
	
	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getMainPicture() {
		return mainPicture;
	}

	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}

	public String getRecipeGrade() {
		return recipeGrade;
	}

	public void setRecipeGrade(String recipeGrade) {
		this.recipeGrade = recipeGrade;
	}

	public String getRecipetag1() {
		return recipetag1;
	}

	public void setRecipetag1(String recipetag1) {
		this.recipetag1 = recipetag1;
	}

	public String getRecipetag2() {
		return recipetag2;
	}

	public void setRecipetag2(String recipetag2) {
		this.recipetag2 = recipetag2;
	}

	public String getRecipetag3() {
		return recipetag3;
	}

	public void setRecipetag3(String recipetag3) {
		this.recipetag3 = recipetag3;
	}

	public int getRecipeView() {
		return recipeView;
	}

	public void setRecipeView(int recipeView) {
		this.recipeView = recipeView;
	}

	public int getRecipeCompetition() {
		return recipeCompetition;
	}

	public void setRecipeCompetition(int recipeCompetition) {
		this.recipeCompetition = recipeCompetition;
	}

	public int getRecipeDetailID() {
		return recipeDetailID;
	}

	public void setRecipeDetailID(int recipeDetailID) {
		this.recipeDetailID = recipeDetailID;
	}

	public Timestamp getRecipeRegDate() {
		return recipeRegDate;
	}

	public void setRecipeRegDate(Timestamp recipeRegDate) {
		this.recipeRegDate = recipeRegDate;
	}

	public RecipeDetailVO getRecipeDetailVO() {
		return recipeDetailVO;
	}

	public void setRecipeDetailVO(RecipeDetailVO recipeDetailVO) {
		this.recipeDetailVO = recipeDetailVO;
	}
	
	

}
