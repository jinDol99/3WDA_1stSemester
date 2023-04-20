package com.kong.king.spring.guest04.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kong.king.spring.guest04.dto.GuestbookDTO;
import com.kong.king.spring.guest04.dto.PageRequestDTO;
import com.kong.king.spring.guest04.dto.PageResultDTO;
import com.kong.king.spring.guest04.entity.Guestbook;
import com.kong.king.spring.guest04.repository.GuestbookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {
	
	private final GuestbookRepository repository;
	
	@Override
	public Long register(GuestbookDTO dto) {
		log.info("DTO..............");
		log.info(dto);
		
		Guestbook entity = dtoToEntity(dto);
		
		log.info(entity);
		
		repository.save(entity);
		
		return entity.getGno();
	}
	
	@Override
	public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
		Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());
		
		// 데스크톱 작업 시작 - 4.20 23:24 | 55 슬라이드 - 기존 코드 수정
		// Page<Guestbook> result = repository.findAll(pageable);

		BooleanBuilder booleanBuilder = getSearch(requestDTO); // 검색조건 처리
		
		Page<Guestbook> result = repository.findAll(booleanBuilder, pageable);	// Querydsl 사용

		// 데스크톱 작업 끝
		
		Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));
		
		return new PageResultDTO<>(result, fn);
	}
	
	@Override
	public GuestbookDTO read(Long gno) {
		Optional<Guestbook> result = repository.findById(gno);
		return result.isPresent() ? entityToDto(result.get()) : null;
	}
	
	@Override
	public void remove(Long gno) {
		repository.deleteById(gno);
	}
	
	@Override
	public void modify(GuestbookDTO dto) {
		Optional<Guestbook> result = repository.findById(dto.getGno());
		
		if (result.isPresent()) {
			Guestbook entity = result.get();
			
			entity.changeTitle(dto.getTitle());
			entity.changeContent(dto.getContent());
			
			repository.save(entity);
		}
	}

	// 데스크톱 작업 시작 - 4.20 23:24 | 54 슬라이드
	private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
		String type = requestDTO.getType();
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		QGuestbook qGuestbook = QGuestbook.guestbook;
		String keyword = requestDTO.getKeyword();

		BooleanExpression expression = qGuestbook.gno.gt(0L);

		booleanBuilder.and(expression);

		if(type == null || type.trim().lenth() == 0) {
			return booleanBuilder;
		}

		BooleanBuilder conditionBuiler = new BooleanBuilder();

		if(type.contains("t")) {
			conditionBuiler.or(qGuestbook.title.contains(keyword));
		}
		if(type.contains("c")) {
			conditionBuiler.or(qGuestbook.content.contains(keyword));
		}
		if(type.contains("w")) {
			conditionBuiler.or(qGuestbook.writer.contains(keyword));
		}

		booleanBuilder.and(conditionBuiler);

		return booleanBuilder;
	}
	// 데스크톱 작업 끝

}
