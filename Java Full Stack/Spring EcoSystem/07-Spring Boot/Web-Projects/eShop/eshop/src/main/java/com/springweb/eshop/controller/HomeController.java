package com.springweb.eshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	public String welcome() {
		return "Welcome to EShop";
	}
	
	@GetMapping("about")
	public String about() {
		return "Hello this is about us page";
	}
}
