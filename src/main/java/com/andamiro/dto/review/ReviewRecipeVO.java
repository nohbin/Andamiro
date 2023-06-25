package com.andamiro.dto.review;

import java.security.Timestamp;
import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;

public class ReviewRecipeVO {
	private int recipeId;
	private int memberNum;
	private String recipeName;
	private String mainPicture;
	private String recipeFrade;
	private String recipetag1;
	private String recipetag2;
	private String recipetag3;
	private int recipeView;
	private int recipeCompetition;
	private Timestamp reciperegdate;
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
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
	public String getRecipeFrade() {
		return recipeFrade;
	}
	public void setRecipeFrade(String recipeFrade) {
		this.recipeFrade = recipeFrade;
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
	public Timestamp getReciperegdate() {
		return reciperegdate;
	}
	public void setReciperegdate(Timestamp reciperegdate) {
		this.reciperegdate = reciperegdate;
	}
}
