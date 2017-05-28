package com.file.ver1.dto;

public class EntityFileBoard {
	private int id;
	private String writer;
	private String title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "EntityFileBoard [id=" + id + ", writer=" + writer + ", title="
				+ title + "]";
	}
}
