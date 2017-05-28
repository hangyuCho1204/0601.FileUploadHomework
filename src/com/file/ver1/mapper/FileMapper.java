package com.file.ver1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.file.ver1.dto.Domain;
import com.file.ver1.dto.EntityFileBoard;
import com.file.ver1.dto.EntityFiles;
import com.file.ver1.dto.FileModel;


public interface FileMapper {
	@Insert("insert into fileboard(id, writer, title) values( #{id}, #{writer}, #{title})")
	@SelectKey(statement="select fileBoard_seq.nextval from dual", keyProperty="id", before=true, resultType=int.class)
	public int saveDomain(EntityFileBoard entityFileBoard);
	
	@Insert("insert into files(id, savedFileName, originalFileName, fileBoardId) values(#{id}, #{savedFileName}, #{originalFileName}, #{fileBoardId})")
	@SelectKey(statement="select files_seq.nextval from dual", keyProperty="id", before=true, resultType=int.class)
	public int saveFile(EntityFiles entityFiles);
	
	@Select("select max(id) as id from fileboard")
	public int getNewBoardId();
	
	@Select("select * from files where id = #{id}")
	public EntityFiles getEntityFiles(int id);
	
	@Delete("delete from files where id = #{id}")
	public int remove(int id);
	
	public FileModel join(int id);
	
	@Select("select * from fileboard")
	public List<EntityFileBoard> findAllBoardList();
	//디비에 데이터 넣기 전에 실제 업로드 한 파일 갯수와 DB에 들어가 있는 정보와 일치시켜야 함.
	
	@Select("select * from fileboard where id = #{id}")
	public EntityFileBoard findById(int id);
	
	
}
