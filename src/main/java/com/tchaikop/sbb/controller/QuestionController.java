package com.tchaikop.sbb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tchaikop.sbb.dto.QuestionDto;
import com.tchaikop.sbb.entity.Question;
import com.tchaikop.sbb.repository.QuestionRepository;
import com.tchaikop.sbb.service.QuestionService;

@RequestMapping("/question")
@Controller



public class QuestionController {
	
		@Autowired
		private QuestionService questionService;
		
		@GetMapping("/")
		public String root() {
			return "index";
		}
		
	
		@GetMapping("/list")  //모든 질문 목록 요청 ->question/list?page=3 초기값을 0으로 첫화면이니까
		public String list(Model model,@RequestParam(value="page",defaultValue = "0")int page) {
			
			Page<Question> pageList = questionService.getQuestionlist(page);
			model.addAttribute("questionList",pageList);
			
			return "question_list";  //.html은 쓰지 않는다
		}
		
		
		
		@GetMapping("/detail/{id}")
		//질문글 번호가 들어올 자리에 {변수이름}을 선언
		public String detail(@PathVariable("id")Integer id,Model model) {
			
			//service에 유저가 클릭한 글의번호에 해당하는 엔터티를 가져오는 호출
			Question question = questionService.getQuestion(id);
			
			if(question != null) {
				model.addAttribute("question", question);
			}else {
				model.addAttribute("errMsg", "선택하신글이 없다");
			}
			return "question_detail";
		}
		
		@GetMapping("/create")  //질문등록 폼 페이지를 보여달라는 요청
		public String questionCreate() {
			return "question_form";
		}
		
		@PostMapping("/create")
		public String questionCreate(@RequestParam (value="subject")String subject,
				@RequestParam (value="content") String content) {
			
			questionService.createQuestion(subject, content);
			
			// Service에서 db에 질문을 저장하는 메소드
			
			return"redirect:/question/list";
			
		}
}
