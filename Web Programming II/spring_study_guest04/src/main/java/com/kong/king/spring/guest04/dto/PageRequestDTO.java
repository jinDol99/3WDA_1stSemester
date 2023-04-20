package com.kong.king.spring.guest04.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

		private int page;
		private int size;
		
		public PageRequestDTO() {
			this.page = 1;
			this.size = 10;
		}
		
		public Pageable getPageable(Sort sor) {
			return PageRequest.of(page-1, size, sor);
		}
}