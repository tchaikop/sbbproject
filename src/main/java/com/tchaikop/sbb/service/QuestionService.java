package com.tchaikop.sbb.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tchaikop.sbb.entity.Question;
import com.tchaikop.sbb.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public Page<Question> getQuestionlist(int page) {
	//	List<Question> questionList = questionRepository.findAllByOrderByCreateDateDesc(); 
		//질문 등록일의 내림 차순으로 정렬하여 글목록이 반환
		 List<Sort.Order> sorts = new ArrayList<>();
	        sorts.add(Sort.Order.desc("createDate"));
		
		Pageable pageable = PageRequest.of(page,10,Sort.by(sorts));  
		//앞의 것이 유저가 클릭한 페이지 뒤의 것은 한 페이지에 보일 갯수
		
	Page<Question>	pageList = questionRepository.findAll(pageable);

		
	

		return pageList;
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
