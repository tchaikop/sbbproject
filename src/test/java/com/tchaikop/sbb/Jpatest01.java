package com.tchaikop.sbb;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tchaikop.sbb.entity.Answer;
import com.tchaikop.sbb.entity.Question;
import com.tchaikop.sbb.repository.AnswerRepository;
import com.tchaikop.sbb.repository.QuestionRepository;

@SpringBootTest

class Jpatest01 {
	
	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	@DisplayName("답변 저장 테스트")
	void test() {
		
		
		List<Question> questionOp =questionRepository.findById(1);
		if(questionOp.isPresent());
		Question q1 = questionOp.get();
		
	}
	
	Answer answer = new Answer();
	answer.setContent("1번 질문의 글");
	answer.setCreateDate(LocalDateTime.now());
	answer.setQuestion(q1);
	
	answerRepository.save(answer);
	

}
