package com.tchaikop.sbb.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class QuestionDto {
	
	private Integer id;
	private String subject;
	private String content;
	private LocalDateTime createDate;

	
	
}
