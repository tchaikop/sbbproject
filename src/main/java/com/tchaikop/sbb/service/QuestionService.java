package com.tchaikop.sbb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tchaikop.sbb.entity.Question;
import com.tchaikop.sbb.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Question> getQuestionlist() {
		List<Question> questionList = questionRepository.findAll();
		
		return questionList;
	}

}
