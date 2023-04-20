package com.kong.king.spring.thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kong.king.spring.thymeleaf.dto.SampleDTO;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {
	
	@GetMapping("/ex1")
	public void ex1() {
		log.info("ex1..........");
	}
	
//	@GetMapping("ex2")
//	public void exModel(Model model) {
//		List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream()
//				.mapToObj(i -> {
//					SampleDTO dto = SampleDTO.builder()
//							.sno(i)
//							.name("홍길동.." + i%3)
//							.dept("컴퓨터.." + i%6)
//							.regTime(LocalDateTime.now())
//							.build();
//					return dto;
//				}).collect(Collectors.toList());
//		
//		model.addAttribute("list", list);
//		log.info("ex2.................");
//	}
	
	@GetMapping({"/exInline"})
	public String exInline(RedirectAttributes redirectAttributes) {
		
		log.info("exInline.........................");
		
			SampleDTO dto = SampleDTO.builder()
							.sno(100L)
							.name("박철수.." + 100)
							.dept("인공지능.." + 100)
							.regTime(LocalDateTime.now())
							.build();
			
			redirectAttributes.addFlashAttribute("result", "success");
			redirectAttributes.addFlashAttribute("dto", dto);
			
			return "redirect:/sample/ex3";
	}
	
	@GetMapping("/ex3")
	public void ex3() {
		log.info("ex3.................................");
	}
	
	@GetMapping({"/ex2", "/exLink"})
	public void exModel(Model model) {
		List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream()
				.mapToObj(i -> {
					SampleDTO dto = SampleDTO.builder()
							.sno(i)
							.name("홍길동.." + i%3)
							.dept("컴퓨터.." + i%6)
							.regTime(LocalDateTime.now())
							.build();
					return dto;
				}).collect(Collectors.toList());
		
		model.addAttribute("list", list);
		log.info("ex2.................................");
	}
	
	@GetMapping("/exView")
	public void exView() {
		log.info("exView................");
	}
	
	@GetMapping("/exView2")
	public void exView2(@RequestParam(value="sno", required=false) String sno, Model m) {
		
		m.addAttribute("sno", sno);
		log.info("exView2 with RequestParam........");
	}
	
	@GetMapping("/exView3/{sno}")
	public String exView3(@PathVariable String sno, Model m) {
		
		m.addAttribute("sno", sno);
		log.info("exView3 with PathVariable...............");
		return "sample/exView3";
	}
	
	@GetMapping({"/exLayout1", "/exLayout2", "/exTemplate", "/exSidebar"})
	public void exLayout1() {
		log.info("exLayout1.....................");
	}
}
