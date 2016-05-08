package com.board.beans;

public class Board {
	public int getIdx() {
		return idx;
	}
	
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getRegdttm() {
		return regdttm;
	}
	
	public void setRegdttm(String regdttm) {
		this.regdttm = regdttm;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	private int idx;
	private String title;
	private String userid;
	private String regdttm;
	private int count;
	private String content;
	
}
