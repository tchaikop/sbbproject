package com.tchaikop.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tchaikop.sbb.entity.Question;
import com.tchaikop.sbb.repository.QuestionRepository;

@SpringBootTest
class SbbprojectApplicationTests {
	
	@Autowired  //DI 의존성 주입
	private QuestionRepository questionRepository;

	//질문 저장 테스트
//	@Test
//	@DisplayName("question테이블insert 얀습")
//	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("안녕하세요 질문3번 테스트 입니다");
//		q1.setContent("질문3번의 내용입니다, 자로디고 싶어요");
//		q1.setCreateDate(LocalDateTime.now());
////		QuestionRepository questionRepository=null;
//		questionRepository.save(q1);
//	}
//	
	@Test
	@DisplayName("question테이블 select test")
	void testJpa2() {
		List<Question> questionList =questionRepository.findAll();
		
		assertEquals(3, questionList.size());
		
}
	
	@Test
	@DisplayName("번호로 질문글 찾기")
	void testJpa3() {
		Optional<Question> questionOptional = questionRepository.findById(2); //기본키인 질문글 찾기
		if(questionOptional.isPresent()) {
			Question question = questionOptional.get();
			System.out.println(question.getSubject());
			
	}
	}
	
	@Test
	@DisplayName("제목으로 찾기")
	void testJpa4() {
		//select * from question where subject = ?
		List<Question> subjectList = questionRepository.findBySubject("안녕하세요 질문3번 테스트 입니다");
		System.out.println(subjectList.get(0).getId());
		assertEquals(3, subjectList.get(0).getId());
	}
	
	@Test
	@DisplayName("제목에 포함된 글 찾기")
	void testJpa5() {
		//select * from question where subject = ?
		List<Question> subjectList1 = questionRepository.findBySubjectLike("%안녕% ");
		// 안녕 부터 시작하는거라면 안녕%, 중간에 안녕이라면 %안녕%
		
		assertEquals(3, subjectList1.size());
		
		
		List<Question> subjectList2 = questionRepository.findBySubjectContaining("안녕 ");
		
		assertEquals(3, subjectList2.size());
		
		List<Question> subjectList3 = questionRepository.findBySubjectLikeOrContentLike("%안녕% ","%안녕%");
		assertEquals(3, subjectList3.size());
	}
//	@Test
//	@DisplayName("질문 글 삭제")
//	void testJpa6() {
//		
//		Optional<Question> qOptional = questionRepository.findById(2); //기본키인 질문글 찾기
//		if(qOptional.isPresent()) {
//		
//		questionRepository.deleteById(2);//2번글 삭제, 번호 글이 없으면 에러
//		
//		}
	
	
//	}
	
	@Test
	@DisplayName("질문 글 제목 또는 내용 수정하기")
	void testJpa7() {
		//update question set subject= ?, content = ? where id = ?;
		//메소드 존재하니 않음-> 해당 글 가져오기(FindById)->글 수정 후 save로 다시 넣기
		Optional<Question> questionOp =	questionRepository.findById(2);
		if(questionOp.isPresent()) {
			Question question = questionOp.get();
			question.setSubject("반갑습니다");
			question.setContent("오늘 비가 옵니다");
			questionRepository.save(question);
		}
	
	
	}
	
}
