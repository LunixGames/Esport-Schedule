package com.project.EsportSchedule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtilityController {
	
	@RequestMapping(value = "/{path:^(?!.*api)[^.]*$}")
	public String redirect() {
		System.out.println("REDIRECTION");
		return "forward:/";
	}
}
