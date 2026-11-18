package com.tchaikop.sbb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tchaikop.sbb.entity.Question;
import com.tchaikop.sbb.repository.QuestionRepository;


@Controller



public class QuestionController {
	
		@Autowired
		private QuestionRepository questionRepository;
		
	
		@GetMapping("/question/list")  //모든 질문 목록 요청
		public String list(Model model) {
			
			List<Question> questionList = questionRepository.findAll();
			//모델 객체의 질문리스트 list 전송해주기
			model.addAttribute("questionList", questionList);
			
			return "question_list";  //.html은 쓰지 않는다
		}
}
