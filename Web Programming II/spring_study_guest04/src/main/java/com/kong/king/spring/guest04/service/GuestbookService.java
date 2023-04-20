package com.kong.king.spring.guest04.service;

import com.kong.king.spring.guest04.dto.GuestbookDTO;
import com.kong.king.spring.guest04.dto.PageRequestDTO;
import com.kong.king.spring.guest04.dto.PageResultDTO;
import com.kong.king.spring.guest04.entity.Guestbook;

public interface GuestbookService {
	Long register(GuestbookDTO dto);
	
	PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);
	
	void remove(Long gno);
	
	void modify(GuestbookDTO dto);
	
	GuestbookDTO read(Long gno);
	
	default Guestbook dtoToEntity(GuestbookDTO dto) {
		Guestbook entity = Guestbook.builder()
				.gno(dto.getGno())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(dto.getWriter())
				.build();
		return entity;
	}
	
	default GuestbookDTO entityToDto(Guestbook entity) {
		GuestbookDTO dto = GuestbookDTO.builder()
				.gno(entity.getGno())
				.title(entity.getTitle())
				.content(entity.getContent())
				.writer(entity.getWriter())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();
		
		return dto;
	}
}
