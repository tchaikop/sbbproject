package com.tchaikop.sbb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class signupForm {
	
	@NotBlank(message = "아이디는 꼭")
	@Size(min =4, message= " 4자 이상이야")
	private String username;
	
	
	@NotBlank(message = "비번은 꼭")
	@Size(min =4, message= " 4자 이상이야")
	private String password;
	
	
	@NotBlank(message = "비번 확인을 한다 꼭")
	@Size(min =4, message= " 4자 이상이야")
	private String password_check;
	
	
	@NotBlank(message = "이멜은 꼭")
	private String email;

}
