package com.andamiro.dto.review;

import java.sql.Timestamp;

import com.andamiro.dto.member.MemberVO;

public class ReviewVO {
	private int recipeId;
	private int memberNumber;
	private String review;
	private int recipegrade;
	private Timestamp regdate;
	private String reviewPicture;
	private String recipeName;
	private int reviewNum;
	private MemberVO memberVO;
	
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getRecipegrade() {
		return recipegrade;
	}
	public void setRecipegrade(int recipegrade) {
		this.recipegrade = recipegrade;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	public String getReviewPicture() {
		return reviewPicture;
	}
	public void setReviewPicture(String reviewPicture) {
		this.reviewPicture = reviewPicture;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	
	
	
	
	
	
}
