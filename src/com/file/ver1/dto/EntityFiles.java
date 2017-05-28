package com.file.ver1.dto;

public class EntityFiles {
	private int id;
	private String savedFileName;
	private String originalFileName;
	private int fileBoardId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSavedFileName() {
		return savedFileName;
	}
	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public int getFileBoardId() {
		return fileBoardId;
	}
	public void setFileBoardId(int fileBoardId) {
		this.fileBoardId = fileBoardId;
	}
	@Override
	public String toString() {
		return "EntityFiles [id=" + id + ", savedFileName=" + savedFileName
				+ ", originalFileName=" + originalFileName + ", fileBoardId="
				+ fileBoardId + "]";
	}
}
