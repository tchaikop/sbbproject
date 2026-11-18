package com.tchaikop.sbb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tchaikop.sbb.dto.QuestionDto;
import com.tchaikop.sbb.entity.Question;
import com.tchaikop.sbb.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public List<QuestionDto> getQuestionlist() {
		List<Question> questionList = questionRepository.findAll();
		
		List questionDtoList = new ArrayList<>();
		
		for(Question question:questionList){
			QuestionDto qDto = new QuestionDto();
			
			qDto.setId(question.getId());
			qDto.setSubject(question.getSubject());
			qDto.setContent(question.getContent());
			qDto.setCreateDate(question.getCreateDate());
			
			questionDtoList.add(qDto);
			
	
}
		return questionDtoList;
	}

}
