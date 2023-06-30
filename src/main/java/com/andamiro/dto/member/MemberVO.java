package com.andamiro.dto.member;

public class MemberVO {

	private int memberNumber;
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String joinDate; 
	private String subscribe;
	private String adminCode;
	
	@Override
	public String toString() {
		return "MemberVO [memberNumber=" + memberNumber + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone="
				+ phone + ", email=" + email + ", joinDate=" + joinDate + ", subscribe=" + subscribe + ", adminCode="
				+ adminCode + "]";
	}
	
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	
}     
      