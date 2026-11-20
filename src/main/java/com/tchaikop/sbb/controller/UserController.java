package com.tchaikop.sbb.controller;

import com.tchaikop.sbb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tchaikop.sbb.dto.signupForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;

	UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup_form";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid signupForm signupForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "signup_form";
		}
		if(!signupForm.getPassword().equals(signupForm.getPassword_check())) {
			bindingResult.rejectValue("password_check","errMsg","비밀번호 아니야");
			return "signup_form";
		}
		
		userService.create(signupForm.getUsername(),signupForm.getPassword(),signupForm.getEmail());
		
		return "redirect:/user/login";
	}

}
