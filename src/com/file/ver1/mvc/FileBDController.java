package com.file.ver1.mvc;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.file.ver1.dto.DownloadFile;
import com.file.ver1.dto.Domain;
import com.file.ver1.dto.EntityFileBoard;
import com.file.ver1.dto.FileModel;

@Controller
public class FileBDController {
	
	@Autowired
	private FileBDService fileBDService;
	
	@RequestMapping(value="/fileUpload", method=RequestMethod.GET)
	public String uploadReady(){
		return "upload";
	}
	
	@RequestMapping(value="/fileUpload", method=RequestMethod.POST)
	public String uploadFile(@ModelAttribute Domain domain){
		
		fileBDService.saveFile(domain);
		
		return "upload";
	}
	//redirect:
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	//produces=MediaType.APPLICATION_OCTET_STREAM_VALUE = 브라우저가 스트림 값을 받을 수 있도록 준비할 수 있게 하는 신호같은 의미
	public List<EntityFileBoard> list(Model model){
			List<EntityFileBoard> lists = fileBDService.getList();
			
			model.addAttribute("lists", lists);
		return lists;
	}
	
	@RequestMapping(value="/showContent", method=RequestMethod.GET)
	public FileModel showContent(@RequestParam int id, Model model){
		FileModel fileModel = fileBDService.join(id);
		return fileModel;
	}
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	@ResponseBody
	//컨트롤러에서 클라이언트에 직접 보내주는 것(다운로드!)
	public FileSystemResource download(@RequestParam int id, HttpServletResponse response, HttpServletRequest request){
		//클라이언트에게 보낼 File, 오리지널 파일 이름이 필요
		DownloadFile downloadFile = fileBDService.getDownloadFile(id);
		System.out.println(downloadFile.getOriginalFileName());
		System.out.println(downloadFile.getFile());
		//다운로드 파일이름 한글 안깨지게 하기!
		String downName = null;
		String browser = request.getHeader("User-Agent");
		
		if(browser.contains("Chrome") || browser.contains("MISE") || browser.contains("Trident")){
			try {
				downName = URLEncoder.encode(downloadFile.getOriginalFileName(), "UTF-8").replaceAll("\\\\", "%20");
				response.setHeader("Content-Disposition", "attachment; filename="+downName+";");
				System.out.println("chrome : "+downName);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else{
			try {
				downName = new String(downloadFile.getOriginalFileName().getBytes("UTF-8"), "ISO-8859-1").replaceAll("\\\\", "_");
				response.setHeader("Content-Disposition", "attachment; filename="+downName+";");
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		//response.setHeader("content-Disposition", "attachment; filename="+downloadFile.getOriginalFileName()+";");
		
		//브라우저가 이 파일을 읽고 해석하서 받아들임(?)
		return new FileSystemResource(downloadFile.getFile());
		//FileSystemResource : 클라이언트로 바로 가겠다라는 의미
	}
	
	@RequestMapping(value="/deleteFile", method=RequestMethod.GET)
	public String deleteFile(@RequestParam int Did){
		
		int cnt = fileBDService.remove(Did);
		
		
		return "redirect:list"; 
	}
}
