package com.andamiro.dto.event;



public class EventVO {
	int eventno;
	String imgsum;
	String evstart;
	String evend;
	String ing;
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
	public String getEvstart() {
		return evstart;
	}
	public void setEvstart(String evstart) {
		this.evstart = evstart;
	}
	public String getEvend() {
		return evend;
	}
	public void setEvend(String evend) {
		this.evend = evend;
	}
	public String getIng() {
		return ing;
	}
	public void setIng(String ing) {
		this.ing = ing;
	}
	public int getContestno() {
		return contestno;
	}
	public void setContestno(int contestno) {
		this.contestno = contestno;
	}
	public String getConpost() {
		return conpost;
	}
	public void setConpost(String conpost) {
		this.conpost = conpost;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	int contestno;
	String conpost;
	String post;
	
}