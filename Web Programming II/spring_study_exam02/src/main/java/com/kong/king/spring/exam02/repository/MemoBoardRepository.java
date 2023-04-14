package com.kong.king.spring.exam02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kong.king.spring.exam02.entity.MemoBoard;

public interface MemoBoardRepository extends JpaRepository<MemoBoard, Long> {
	
}