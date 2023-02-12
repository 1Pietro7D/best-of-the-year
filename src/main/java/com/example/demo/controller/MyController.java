package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home") // localhost:8080/home grestisce le CRUD
public class MyController {
	String name = "Pietro";
	String test = "Test";
	
	@GetMapping()
	@ResponseBody
	public String index() {
		return "home";
	} 	
	
	@GetMapping("/index") // su questa rotta localhost:8080/home/index che va specificato INVECE su http://localhost:8080/ compare come statico
	public String view(Model modelIndex) {
		modelIndex.addAttribute("name", name);
		return "index"; //questo pesca index.html su template
	}
	@GetMapping("/test") // su questa rotta
	public String test(Model modelTest) {
		modelTest.addAttribute("name", test);
		return "test"; //questo pesca test.html su template
	}
	
	@GetMapping("/benvenuto")
	@ResponseBody
	public String titleBest() {
		return "Best of the year by " + name;
	}
	@GetMapping("/arrivederci")
	@ResponseBody
	public String saluti() {
		return "ciao ciao " + name;
	}


}
