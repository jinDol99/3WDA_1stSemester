package com.kong.king.spring.guest04.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kong.king.spring.guest04.dto.GuestbookDTO;
import com.kong.king.spring.guest04.dto.PageRequestDTO;
import com.kong.king.spring.guest04.dto.PageResultDTO;
import com.kong.king.spring.guest04.entity.Guestbook;
import com.kong.king.spring.guest04.service.GuestbookService;

@SpringBootTest
public class GuestbookServiceTests {

	@Autowired
	private GuestbookService service;
	
//	@Test
//	public void testRegister() {
//		
//		GuestbookDTO guestbookDTO = GuestbookDTO.builder()
//				.title("샘플 제목...")
//				.content("샘플 내용....")
//				.writer("user0")
//				.build();
//		
//		System.out.println(service.register(guestbookDTO));
//	}
	
	@Test
	public void testList() {
		
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
		
		PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);
		
		System.out.println("PREV: " + resultDTO.isPrev());
		System.out.println("NEXT: " + resultDTO.isNext());
		System.out.println("TOTAL: " + resultDTO.getTotalPage());
		
		System.out.println("------------------------------------");
		for(GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
			System.out.println(guestbookDTO);
		}
		
		System.out.println("-------------------------------------");
		resultDTO.getPageList().forEach(i -> System.out.println(i));
	}
}
