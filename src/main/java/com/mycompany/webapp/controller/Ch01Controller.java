package com.mycompany.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch01")
@Log4j2
public class Ch01Controller {
	
	@RequestMapping("/content")
	public String content() {
		log.info("실행");
		return "ch01/content";
	}
}
