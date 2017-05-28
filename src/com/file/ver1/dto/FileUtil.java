package com.file.ver1.dto;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;


public class FileUtil {
	//���� ������ ����� ������ ���� �̸��� �����ؼ� ������ �޼ҵ� ����
	public static String makeSavedFileName(String orignalFileName){
		
		//UUID�� ������ ���̵� ����� �ִ� Ŭ����
		UUID uid = UUID.randomUUID();
		
		String savedFile = uid.toString()+"_"+orignalFileName;
		
		return savedFile;
	}
	
	public static boolean saveFile(String saveFileName, byte[] fileData){
		//byte[]�� ���� ������
		String uploadPath="c:\\xyz\\upload";
		File target = new File(uploadPath, saveFileName);
		
		try {
			FileCopyUtils.copy(fileData,  target);
			//������ �����͸� ������ �ִ� �޼ҵ�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
			//���� ������ �ȵ� �� ������ ��ȯ
		}
		
		return true;
		//���� ������ �� �� ���� ��ȯ
	}
	public static File getSavedFile(String savedFileName){
		
		String uploadPath="c:\\xyz\\upload";
		File downloadFile = new File(uploadPath, savedFileName);
		//uploadPath��η� ���� savedFileName �̸��� ��ü�� ������ �Ͷ�
		
		return downloadFile;
	}
	public static boolean deleteSavedFile(String savedFileName){
		
		String uploadPath="c:\\xyz\\upload";
		File a = new File(uploadPath, savedFileName);
		boolean result = a.delete();
		
		return result;
	}
}
