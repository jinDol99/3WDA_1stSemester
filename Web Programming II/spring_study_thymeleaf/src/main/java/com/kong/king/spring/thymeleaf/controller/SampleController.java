package com.kong.king.spring.thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kong.king.spring.thymeleaf.dto.SampleDTO;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {
	
	@GetMapping("/ex1")
	public void ex1() {
		Log.info("ex1..........");
	}
	
	@GetMapping("ex2")
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
		Log.info("ex2.................")
	}
}
