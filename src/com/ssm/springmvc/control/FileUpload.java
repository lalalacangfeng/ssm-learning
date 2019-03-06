package com.ssm.springmvc.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUpload {

	@RequestMapping("/oneFileUpload")
	public void oneFileUpload(MultipartHttpServletRequest request,HttpServletResponse response){
		try {
			System.out.println("方法1");
			System.out.println("username="+request.getParameter("username"));
			MultipartFile file = request.getFile("uploadFile");
			String uploadFileName = file.getOriginalFilename();
			
			InputStream isRef = file.getInputStream();
			
			String targetDir = request.getSession().getServletContext().getRealPath("/upload");
			File targetFile = new File(targetDir,uploadFileName);
			FileOutputStream fosRef = new FileOutputStream(targetFile);
			IOUtils.copy(isRef, fosRef);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//需要与前台file文件域name名称一样，还需要再MulitpartFile前加上@RequestParam注解，否则出现异常
	@RequestMapping("/oneFileUpload2")
	public void oneFileUpload2(@RequestParam String username,@RequestParam MultipartFile uploadFile,HttpServletRequest request,HttpServletResponse response){
		try {
			System.out.println("方法2");
			System.out.println("username="+request.getParameter("username"));
			MultipartFile file = uploadFile;
			String uploadFileName = file.getOriginalFilename();
			
			InputStream isRef = file.getInputStream();
			
			String targetDir = request.getSession().getServletContext().getRealPath("/upload");
			File targetFile = new File(targetDir,uploadFileName);
			FileOutputStream fosRef = new FileOutputStream(targetFile);
			IOUtils.copy(isRef, fosRef);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/moreFileUpload")
	public String MoreFileUpload(MultipartHttpServletRequest request,HttpServletResponse response){
		try {
			System.out.println("多文件");
			Map<String, MultipartFile> fileMap = request.getFileMap();
			System.out.println("文件个数："+fileMap.size());
			Set<String> fileSet = fileMap.keySet();
			Iterator<String> fileNameIterator = fileSet.iterator();
			while (fileNameIterator.hasNext()) {
				String uploadFileName = fileNameIterator.next();
				System.out.println(uploadFileName);
				MultipartFile file = fileMap.get(uploadFileName);
				uploadFileName = file.getOriginalFilename();
				InputStream input = file.getInputStream();
				String targetDir =  request.getSession().getServletContext().getRealPath("/upload");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
				String getDateString = sdf.format(new Date());
				File targetFile = new File(targetDir,""+getDateString+"_"+System.nanoTime()+uploadFileName);
				FileOutputStream output = new FileOutputStream(targetFile);
				IOUtils.copy(input, output);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
