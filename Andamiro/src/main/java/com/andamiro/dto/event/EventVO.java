package com.andamiro.dto.event;



public class EventVO {
    public int getEventno() {
		return eventno;
	}
	public void setEventno(int eventno) {
		this.eventno = eventno;
	}
	public String getImgsum() {
		return imgsum;
	}
	public void setImgsum(String imgsum) {
		this.imgsum = imgsum;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getIng() {
		return ing;
	}
	public void setIng(String ing) {
		this.ing = ing;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getEventkind() {
		return eventkind;
	}
	public void setEventkind(String eventkind) {
		this.eventkind = eventkind;
	}
	private int eventno;
    private String imgsum;
    private String term;
    private String ing;
    private String poster;
    private String eventkind;
}