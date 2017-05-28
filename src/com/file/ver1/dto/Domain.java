package com.file.ver1.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Domain {
	
	private String writer;
	private String title;
	private List<MultipartFile> upFile;
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
	
	public List<MultipartFile> getUpFile() {
		return upFile;
	}
	public void setUpFile(List<MultipartFile> upFile) {
		this.upFile = upFile;
	}
	@Override
	public String toString() {
		return "FileDomain [writer=" + writer + ", title=" + title
				+ ", upFile=" + upFile + "]";
	}
}

