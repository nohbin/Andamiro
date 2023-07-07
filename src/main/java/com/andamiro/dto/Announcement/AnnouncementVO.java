package com.andamiro.dto.Announcement;

import java.sql.Timestamp;

public class AnnouncementVO {
	private int annNum;
	private String annTitle;
	private int viewCount;
	private Timestamp joindate;
	private String id;
	private String announcement;
	public String getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAnnNum() {
		return annNum;
	}
	public void setAnnNum(int annNum) {
		this.annNum = annNum;
	}
	public String getAnnTitle() {
		return annTitle;
	}
	public void setAnnTitle(String annTitle) {
		this.annTitle = annTitle;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public Timestamp getJoindate() {
		return joindate;
	}
	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}
}
