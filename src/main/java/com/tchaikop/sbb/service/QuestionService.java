package com.tchaikop.sbb.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		List<Question> questionList = questionRepository.findAllByOrderByCreateDateDesc(); 
		//질문 등록일의 내림 차순으로 정렬하여 글목록이 반환
		
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
	
	public Question getQuestion(Integer id) {
		Optional<Question> op = questionRepository.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
		
	}
	
	public void createQuestion(String subject, String content) {
		
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		questionRepository.save(q);
		
	}

}
