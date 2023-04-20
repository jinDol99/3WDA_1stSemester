package com.kong.king.spring.guest04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kong.king.spring.guest04.dto.GuestbookDTO;
import com.kong.king.spring.guest04.dto.PageRequestDTO;
import com.kong.king.spring.guest04.service.GuestbookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

//@Controller
//@RequestMapping("/guestbook")
//@Log4j2
//public class GuestbookController {
//	
//	@GetMapping({"/","/list"})
//	public String list() {
//		log.info("list....................");
//		return "/guestbook/list";
//	}
//}

@Controller
@RequestMapping("/guestbook")
@Log4j2
@RequiredArgsConstructor
public class GuestbookController {
	
	private final GuestbookService service;
	
	@GetMapping("/")
	public String list() {
		log.info("list root....................");
		
		return "redirect:/guestbook/list";
	}
	
	@GetMapping("/list")
	public void list(PageRequestDTO pageRequestDTO, Model model) {
		
		log.info("list................" + pageRequestDTO);
		
		model.addAttribute("result", service.getList(pageRequestDTO));
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("register get.............");
	}
	
	@PostMapping("/register")
	public String registerPost(GuestbookDTO dto, RedirectAttributes redirectAttributes) {
		log.info("dto.........." + dto);
		
		Long gno = service.register(dto);
		
		redirectAttributes.addFlashAttribute("msg", gno);
		
		return "redirect:/guestbook/list";
	}

	// 데스크톱 작업 시작 - 4.21 0:09 | 63 슬라이드
	// 건들일게 없는데??? 모?지
	@GetMapping({"/read", "/modify"})
	public void read(long gno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model) {
		log.info("gno" + gno);
		System.out.println("[GuestbookController.java] /read GetMapping - gno: " + gno);
		GuestbookDTO dto = service.read(gno);
		model.addAttribute("dto", dto);
	}
	// 데스크톱 작업 끝

	@PostMapping("/remove")
	public String remove(long gno, RedirectAttributes redirectAttributes) {
		log.info("gno" + gno);
		
		service.remove(gno);
		
		redirectAttributes.addFlashAttribute("msg", gno);
		
		return "redirect:/guestbook/list";
	}
	
	@PostMapping("/modify")
	public String modify(GuestbookDTO dto,
			@ModelAttribute("requestDTO") PageRequestDTO requestDTO,
			RedirectAttributes redirectAttributes) {
		
		log.info("post modify.............");
		log.info("dto" + dto);
		
		service.modify(dto);
		
		redirectAttributes.addAttribute("page", requestDTO.getPage());
		// 데스크톱 작업 시작 - 4.21 0:10 | 63 슬라이드
		redirectAttributes.addAttribute("type", requestDTO.getType());
		redirectAttributes.addAttribute("keyword", requestDTO.getKeyword());
		// 데스크톱 작업 끝
		redirectAttributes.addAttribute("gno", dto.getGno());
		
		return "redirect:/guestbook/read";
	}
}