package com.kong.king.spring.exam01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exam01")
public class Exam01Controller {

	@GetMapping("/hello")
	public String helllo() {
		return "hello";
	}
	
	@GetMapping("/hello2")
	public String goodMorning() {
		return "hi";
	}
	
	@GetMapping("/hello3")
	public String hello3() {
		return "board/hello3";
	}
	
	@GetMapping({"/olleh", "/olleh2"})
	public void olleh(Model model) {
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < 10; i++) {
			list.add("Olleh...");
		}
		
		model.addAttribute("olleh", list);
	}
	
	@GetMapping("/hello4")
	@ResponseBody
	public String hello4(@RequestParam(value="msg", required=false) String msg) {
		return msg;
	}
	
	@GetMapping("/hello5/{msg}")
	public String hello5(@PathVariable String msg, Model m) {
		m.addAttribute("msg" ,msg);
		return "hello5";
	}
}