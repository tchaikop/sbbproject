package com.tchaikop.sbb.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tchaikop.sbb.entity.Answer;
import com.tchaikop.sbb.entity.Question;
import com.tchaikop.sbb.repository.AnswerRepository;

@Service

public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	public void createAnswer(String content, Question question) {
		
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		
		answerRepository.save(answer);
	}

}
