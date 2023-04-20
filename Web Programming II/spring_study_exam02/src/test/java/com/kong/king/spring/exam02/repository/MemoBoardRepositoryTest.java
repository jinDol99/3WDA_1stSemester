package com.kong.king.spring.exam02.repository;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.*;

import com.kong.king.spring.exam02.entity.MemoBoard;

@SpringBootTest
public class MemoBoardRepositoryTest {
	
	@Autowired
	MemoBoardRepository memoBoardRepository;
	
//	@Test
//	public void testClass() {
//		System.out.println("객체생성 확인 ---- " + memoBoardRepository.getClass().getName());
//	}
//	
//	@Test
//	public void testInsertDummies() {
//		IntStream.rangeClosed(1, 100).forEach( i -> {
//			MemoBoard memo = MemoBoard.builder().content("메모..." + i).build();
//			memoBoardRepository.save(memo);
//		});
//	}
	
//	@Test
//	public void testInsertDummies2() {
//		MemoBoard memo;
//		
//		for(int i = 200; i <= 250; i++) {
//			memo = new MemoBoard();
//			memo.setContent("메모x테스트..." + i);
//			memoBoardRepository.save(memo);
//		}
//	}
	
//	@Test
//	public void testSelectById() {
//		Long mid = 103L;
//		Optional<MemoBoard> result = memoBoardRepository.findById(mid);
//		
//		System.out.println("------------------------------");
//		
//		if (result.isPresent()) {
//			MemoBoard memo = result.get();
//			System.out.println(memo);
//		}
//	}
	
//	@Transactional
//	@Test
//	public void testSelect2ById() {
//		Long mid = 230L;
//		
//		MemoBoard memo = memoBoardRepository.getOne(mid);
//		System.out.println("--------------------------------");
//		System.out.println(memo);
//	}
	
//	@Test
//	public void testSelectAll() {
//		List<MemoBoard> list = new ArrayList<MemoBoard>();
//		
//		list = memoBoardRepository.findAll();
//		
//		System.out.println(list);
//	}
	
//	@Test
//	public void testUpdate() {
//		MemoBoard memo = MemoBoard.builder().mid(200L).content("100번 데이터 수정...").build();
//		System.out.println(memoBoardRepository.save(memo));
//	}
	
//	@Test
//	public void testDelete() {
//		Long mid = 201L;
//		
//		memoBoardRepository.deleteById(mid);
//	}
	
//	@Test
//	public void testPageDefault() {
//		Pageable pageable = PageRequest.of(0, 10);
//		Page<MemoBoard> result = memoBoardRepository.findAll(pageable);
//		
//		System.out.println(result);
//		System.out.println("--------------------------------");
//		
//		System.out.println("Total Pages : " + result.getTotalPages());
//		System.out.println("Total count : " + result.getTotalElements());
//		System.out.println("Page Number : " + result.getNumber());
//		System.out.println("Page Size : " + result.getSize());
//		System.out.println("has next page? : " + result.hasNext());
//		System.out.println("first page? : " + result.isFirst());
//		
//		System.out.println("---------------------------------");
//		
//		for(MemoBoard memo : result.getContent()) {
//			System.out.println(memo);
//		}
//	}
	
//	@Test
//	public void testSort() {
//		Sort sort1 = Sort.by("mid").descending();
//		
//		Pageable pageable = PageRequest.of(0, 10, sort1);
//		Page<MemoBoard> result = memoBoardRepository.findAll(pageable);
//		
//		result.get().forEach(memo -> {
//			System.out.println(memo);
//		});
//	}
	
//	@Test
//	public void testSort2() {
//		Sort sort1 = Sort.by("content").ascending();
//		Sort sort2 = Sort.by("mid").descending();
//		Sort sortAll = sort1.and(sort2);
//		
//		Pageable pageable = PageRequest.of(0, 10, sortAll);
//		Page<MemoBoard> result = memoBoardRepository.findAll(pageable);
//		
//		result.get().forEach(memo -> {
//			System.out.println(memo);
//		});
//	}
	
//	@Test
//	public void testQueryMethods() {
//		List<MemoBoard> list = memoBoardRepository.findByMidBetweenOrderByMidDesc(170L,  180L);
//		
//		for(MemoBoard memo : list) {
//			System.out.println(memo);
//		}
//	}
	
//	@Test
//	public void testQueryMethodWithPageable() {
//		Pageable pageale = PageRequest.of(0, 10, Sort.by("mid").descending());
//		
//		Page<MemoBoard> result = memoBoardRepository.findByMidBetween(110L, 150L, pageale);
//		
//		result.get().forEach(memo -> System.out.println(memo));
//	}
	
//	@Test
//	public void testAtQueryGetAllData() {
//		List<MemoBoard> list = memoBoardRepository.getMemoBoardListAllDesc();
//		
//		for(MemoBoard memo : list ) {
//			System.out.println(memo);
//		}
//	}
	
//	@Test
//	public void testAtQueryUpdateById() {
//		int result = memoBoardRepository.updateMemoBoardContentWithMid(102L, "@Query를 활용한 수정 실습");
//		
//		System.out.println("수정 결과 : " + result);
//	}
	
//	@Test
//	public void testAtQueryUpdateByObj() {
//		MemoBoard memo = new MemoBoard();
//		memo.setMid(103L);
//		memo.setContent("@Query를 이용한 수정 - Object 전달 방식");
//		int result = memoBoardRepository.updateMemoBoardContentWithObj(memo);
//		
//		System.out.println("수정 결과 : " + result);
//	}
	
//	@Test
//	public void testAtQueryWithPageable() {
//		Pageable pageable = PageRequest.of(0, 10, Sort.by("mid").descending());
//		
//		Page<MemoBoard> result = memoBoardRepository.getListWithQueryandPaging(101L, pageable);
//		System.out.println("-----------------------------------------");
//		System.out.println("result = " + result);
//		result.get().forEach(memo -> System.out.println(memo));
//	}
	
//	@Test
//	public void testAtQueryObjectWithPageable() {
//		
//		Pageable pageable = PageRequest.of(0, 10, Sort.by("mid").descending());
//		
//		Page<Object[]> result = memoBoardRepository.getListWithQueryObject(101L, pageable);
//		System.out.println("-----------------------------------");
//		System.out.println("result = " + result);
//		result.get().forEach( memo -> System.out.println(Arrays.toString(memo)));
//	}
	
	@Test
	public void testNativeQuery() {
		List<MemoBoard> list = memoBoardRepository.getNativeResult();
		
		for(MemoBoard memo : list) {
			System.out.println(memo);
		}
	}
	
}
