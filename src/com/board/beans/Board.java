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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userid) {
		this.user_id = userid;
	}

	public String getReg_dttm() {
		return reg_dttm;
	}

	public void setReg_dttm(String regdttm) {
		this.reg_dttm = regdttm;
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

	public String getRegip() {
		return regip;
	}

	public void setRegip(String regip) {
		this.regip = regip;
	}

	public String getFilename() { return filename; }

	public void setFilename(String filename) { this.filename = filename; }

	private int idx;
	private String title;
	private String user_id;
	private String reg_dttm;
	private String content;
	private int count;
	private String regip;
	private String filename;

}
