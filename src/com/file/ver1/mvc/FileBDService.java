package com.file.ver1.mvc;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.ver1.dto.Domain;
import com.file.ver1.dto.DownloadFile;
import com.file.ver1.dto.EntityFileBoard;
import com.file.ver1.dto.EntityFiles;
import com.file.ver1.dto.FileModel;
import com.file.ver1.dto.FileUtil;

@Service
public class FileBDService {
	
	@Autowired
	private FileBDRepository fileBDRepository;
	
	public int saveFile(Domain domain){
		
		// 변수 선언
		EntityFiles entityFiles = null;
		String[] savedFileName = new String[domain.getUpFile().size()];
		int i = 0;
		int cnt = 0;
		
		//DAO 호출
		EntityFileBoard entityFileBoard = new EntityFileBoard();
		entityFileBoard.setWriter(domain.getWriter());
		entityFileBoard.setTitle(domain.getTitle());
		fileBDRepository.insertBoard(entityFileBoard);
		int id = fileBDRepository.getNewBoardId();
		
		
		//1. 파일 서버에 저장될 유일한 파일 이름 생성
		for(MultipartFile bean:domain.getUpFile()){
			if(bean.getOriginalFilename().equals(null)||bean.getOriginalFilename().isEmpty()){
				
			}else{
				savedFileName[i] = FileUtil.makeSavedFileName(bean.getOriginalFilename());
				
				//2. 파일 서버에 파일 저장
				boolean FileUploadResult = false;
				try {
					FileUploadResult = FileUtil.saveFile(savedFileName[i], bean.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("FileUploadResult : " + FileUploadResult);
				//3. db에 저장할 엔티티 생성
				
				if(FileUploadResult){
					entityFiles = new EntityFiles();
					
					String savedname = savedFileName[i];
					entityFiles.setSavedFileName(savedname);
					entityFiles.setOriginalFileName(bean.getOriginalFilename());
					entityFiles.setFileBoardId(id);
					
					}
				cnt = fileBDRepository.insertFile(entityFiles);
				i++;
			}
		}
		
		return cnt;
	}
	
	public FileModel join(int id){
		return fileBDRepository.join(id);
	}
	
	//파일 다운로드
	/*public List<FileModel> getFiles(){
	 	
		
		List<EntityFiles> entityFiles = fileBDRepository.selectAll();
		
		List<FileModel> fileModel = new ArrayList<FileModel>();
		
		for( EntityFiles bean:entityFiles ){
			FileModel model = new FileModel();
			
			model.setId(bean.getId());
			model.setOriginalfilename(bean.getOriginalFileName());
			model.setTitle(bean.getTitle());
			model.setWriter(bean.getWriter());
			
			fileModel.add(model);
		}
		
		return fileModel;
	}*/
	
	public EntityFileBoard selectById(int id){
		return fileBDRepository.selectById(id);
	}
	
	public int remove(int id){
		EntityFiles entityFiles = fileBDRepository.getEntityFiles(id);
		
		boolean result = FileUtil.deleteSavedFile(entityFiles.getSavedFileName());
		System.out.println("result : "+result +"/" + "savedFileName : " + entityFiles.getSavedFileName());
		
		return fileBDRepository.remove(id);
	}

	public DownloadFile getDownloadFile(int id) {
		EntityFiles entityFiles = fileBDRepository.getEntityFiles(id);
		
		File saveFile = FileUtil.getSavedFile(entityFiles.getSavedFileName());
		
		DownloadFile downloadFile = new DownloadFile();
		downloadFile.setFile(saveFile);
		downloadFile.setOriginalFileName(entityFiles.getOriginalFileName());
		
		return downloadFile;
	}

	public List<EntityFileBoard> getList() {
		return fileBDRepository.getList();
	}
}
