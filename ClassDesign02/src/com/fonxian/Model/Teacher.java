package com.fonxian.Model;

public class Teacher {
	private int tid;
	private String tname;
	private int ttel;
	private String password;
	private int status;
	public int getTid() {
		return tid;
	}
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
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTtel() {
		return ttel;
	}
	public void setTtel(int ttel) {
		this.ttel = ttel;
	}
	
}
