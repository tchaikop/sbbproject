package com.tchaikop.sbb.dto;

import java.time.LocalDateTime;

public class AnswerDto {
	
	private Integer id;
	private String content;
	private LocalDateTime createDate;
	private Integer question_id;  //부모 질문글의 번호

}
