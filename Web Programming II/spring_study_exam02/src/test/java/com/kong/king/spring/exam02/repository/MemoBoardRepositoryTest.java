package com.kong.king.spring.exam02.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemoBoardRepositoryTest {
	
	@Autowired
	MemoBoardRepository memoBoardRepository;
	
	@Test
	public void testClass() {
		System.out.println("객체생성 확인 ---- " + memoBoardRepository.getClass().getName());
	}
}
