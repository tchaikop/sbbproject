package com.tchaikop.sbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tchaikop.sbb.entity.Question;
import com.tchaikop.sbb.repository.AnswerRepository;
import com.tchaikop.sbb.service.AnswerService;
import com.tchaikop.sbb.service.QuestionService;

@RequestMapping("/answer")
@Controller

public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/create/{id}")
	
	// 답변이 달릴 부모 질문글의번호
	public String createAnswer(@PathVariable("id") Integer id,
			@RequestParam(value = "content") String content) {
		
		Question question = questionService.getQuestion(id);
		  answerService.createAnswer(content, question);
		  
		 
		  
		  return "redirect:/question_detail"+id;  //redirect는 갱신해서 내가 방금 쓴글이 갱신되어서 나온다
	}
}
