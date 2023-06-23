package com.andamiro.dto.review;

import java.sql.Timestamp;

public class ReviewVO {
	private int num;
	private String title;
	private String review;
	private int recipegrade;
	private Timestamp joindate;
	private String img;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Timestamp getJoindate() {
		return joindate;
	}
	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}
}
