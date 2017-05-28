package com.file.ver1.dto;

import java.util.List;

public class FileModel {
	private int id;
	private String writer;
	private String title;
	private List<EntityFiles> files;
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
	public List<EntityFiles> getFiles() {
		return files;
	}
	public void setFiles(List<EntityFiles> files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "FileModel [id=" + id + ", writer=" + writer + ", title="
				+ title + ", files=" + files + "]";
	}
}
