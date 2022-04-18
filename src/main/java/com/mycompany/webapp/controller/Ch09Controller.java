package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch09")
@Log4j2
public class Ch09Controller {
	@RequestMapping("/content")
	public String content() {
		log.info("실행");
		return "ch09/content";
	}

	@GetMapping("/filedownload")
	public void filedownload(int fileNo, HttpServletResponse response,
			@RequestHeader("User-Agent") String userAgent) throws FileNotFoundException, IOException {
		// 1. 파일정보 3가지(원본파일명, 저장된파일명, content-type)
		// 우선 하드코딩으로 실습하자.
		String contentType = "image/jpeg";
		String originalFilename = "photo5.jpg";
		String savedFilename = "1650009261878-photo5.jpg";
		// 2. 브라우저 정보에 맞춰 파일명을 ASCII문자로 인코딩하기.
		if(userAgent.contains("Trident") || userAgent.contains("MSIE")) {
			originalFilename = URLEncoder.encode(originalFilename, "UTF-8");
		} else {
			originalFilename = new String(originalFilename.getBytes("UTF-8"), "ISO-8859-1");
		}
		
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition",
				"attachment; filename=\"" + originalFilename + "\"");
		
		// 스트림 생성 및 출력하기(다운로드받기 구현하기)
		File file = new File("C:/Temp/uploadedfiles/" + savedFilename);
		if(file.exists()) {
			FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());			
		}
	}
}
