package com.tchaikop.sbb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tchaikop.sbb.entity.Question;
import com.tchaikop.sbb.repository.QuestionRepository;
import com.tchaikop.sbb.service.QuestionService;


@Controller



public class QuestionController {
	
		@Autowired
		private QuestionService questionService;
		
		@GetMapping("/")
		public String root() {
			return "index";
		}
		
	
		@GetMapping("/question/list")  //모든 질문 목록 요청
		public String list(Model model) {
			
			List<Question> questionList = QuestionRepository.getQuestionlist();
			//모델 객체의 질문리스트 list 전송해주기
			model.addAttribute("questionList", questionList);
			
			return "question_list";  //.html은 쓰지 않는다
		}
		
		@GetMapping("/test")
		public String test(Model model) {
			
			model.addAttribute("name", "홍길동");
			model.addAttribute("age", 25);
			model.addAttribute("loginId", "tiger");
			
			
			ArrayList<String> strs = new ArrayList<>();
			strs.add("이순신");
			strs.add("김유신");
			strs.add("강감찬");
			
			model.addAttribute("strs", strs);
			return "test";
		}
		
		@GetMapping("/question/detail/{id}")
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
}
