package com.mycompany.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch02")
@Log4j2
public class Ch02Controller {
	@RequestMapping("/content")
	public String content() {
		log.info("실행");
		return "ch02/content";
	}
	
	@GetMapping("/method")
	public String method1() {
		log.info("실행");
		return "ch02/content";
	}
	
	@PostMapping("/method")
	public String method2() {
		log.info("실행");
		return "ch02/content";
	}
	
	@PutMapping("/method")
	public String method3() {
		log.info("실행");
		return "ch02/content";
	}
	
	@DeleteMapping("/method")
	public String method4() {
		log.info("실행");
		return "ch02/content";
	}
}
