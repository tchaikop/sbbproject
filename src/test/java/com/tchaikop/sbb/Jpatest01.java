package com.tchaikop.sbb;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tchaikop.sbb.entity.Answer;
import com.tchaikop.sbb.entity.Question;
import com.tchaikop.sbb.repository.AnswerRepository;
import com.tchaikop.sbb.repository.QuestionRepository;

@SpringBootTest

class Jpatest01 {
	
	@Autowired  //DI: Dependency Injection
	private AnswerRepository answerRepository;
	@Autowired
	private QuestionRepository questionRepository;

//	@Test
//	@DisplayName("답변 저장 테스트")
//	void test() {
//		
//		//답변이 달릴 질문글이 존재해야만 답변이 저장될 수 있다
//		//1. 답변이 달릴 질문글 레코드를 DB에서 가져와야 한다
//		//2. 해당 질문글에 답변이 달리도록 answer table에 저장
//		
//		Optional<Question> op =questionRepository.findById(5);
//		if(op.isPresent()) {  //질문 글이 존재한다는 확인
//		Question q =op.get();
//		
//	
//	
//	Answer answer = new Answer();
//	answer.setContent("2범째 답변하자면...뭐라고할까? 자동으로 생성된다고할까");
//	answer.setQuestion(q);  // 질문이 달릴 질문글 entity를 setter로 저장
//	answer.setCreateDate(LocalDateTime.now()); //현재 시간 축출하여 답변 등록일로 저장
//	
//	answerRepository.save(answer);
//	
//		}	
//		
//}
//	
//	@Test
//    void testJpa() {
//        Optional<Answer> oa = this.answerRepository.findById(2);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(5, a.getQuestion().getId());
//    }
	
	@Transactional  //springboot 것을 선택해야 한다,아니면 질문만 조회하고 DB랑 조회가 끊긴다
	@Test			// 지금 두개의 sql문을 조회해야 하기때문이야, 한 세트로 묶는거야
	@DisplayName("5번 질문글에 대한 답변들 확인 테스트")
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(5);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        
        List<Answer> answerList = q.getAnswerList();
        
        System.out.println(answerList.get(0).getContent());
        System.out.println(answerList.get(1).getContent());
        
  }
	
	
}
