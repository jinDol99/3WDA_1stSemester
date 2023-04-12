package com.kong.king.spring.thymeleaf.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class SampleDTO {
	private Long sno;
	private String name;
	private String dept;
	private LocalDateTime regTime;
}
