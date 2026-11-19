package com.tchaikop.sbb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AnswerForm {
	
	@NotBlank(message="답변은 필수 항목 입니다")
	@Size(min=5, max=100,message = "답변은 5자 이상 100자 이하야")
	private String content;

}
