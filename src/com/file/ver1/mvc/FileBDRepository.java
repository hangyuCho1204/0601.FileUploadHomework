package com.file.ver1.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.file.ver1.dto.Domain;
import com.file.ver1.dto.EntityFileBoard;
import com.file.ver1.dto.EntityFiles;
import com.file.ver1.dto.FileModel;
import com.file.ver1.mapper.FileMapper;

@Repository
public class FileBDRepository {
	
	@Autowired
	private FileMapper mapper;
	
	public int insertBoard(EntityFileBoard entityFileBoard){
		return mapper.saveDomain(entityFileBoard);
	}
	
	public int insertFile(EntityFiles entityFiles){
		return mapper.saveFile(entityFiles);
	}
	
	public int getNewBoardId(){
		return mapper.getNewBoardId();
	}
	
	
	public int remove(int id){
		return mapper.remove(id);
	}

	
	
	public FileModel join(int id){
		return mapper.join(id);
	}

	public EntityFiles getEntityFiles(int id) {
		return mapper.getEntityFiles(id);
	}
	
	public EntityFileBoard selectById(int id){
	
	return mapper.findById(id);
	}
	
	public List<EntityFileBoard> getList() {
	return mapper.findAllBoardList();
	}
}
