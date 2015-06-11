package com.fonxian.Model;

public class Student {
	private int sid;
	private String sname;
	private int stel;
	private int classid;//°à¼¶±àºÅ
	private String password;
	private int status;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getStel() {
		return stel;
	}
	public void setStel(int stel) {
		this.stel = stel;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	
}
