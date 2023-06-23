package com.andamiro.dto.event;



public class EventVO {
	int eventno;
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
	public int getEvstart() {
		return evstart;
	}
	public void setEvstart(int evstart) {
		this.evstart = evstart;
	}
	public int getEvend() {
		return evend;
	}
	public void setEvend(int evend) {
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
	String imgsum;
	int evstart;
	int evend;
	String ing;
	int contestno;
	String conpost;
	String post;
	
}