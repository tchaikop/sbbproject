package com.tchaikop.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tchaikop.sbb.entity.Question;
import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
	List<Question> findBySubject(String subject);//제목으로 질문글 찾기 메소드
	// list 빠지면 첫번찌 글만 온다
	List<Question> findBySubjectLike(String subject);
	//select * from question where like ?
	
	List<Question> findBySubjectContaining(String subject);
	
	//select * from question where subject like ? or content like ?
	List<Question> findBySubjectLikeOrContentLike(String subject,String Content);
	
	List<Question> findBySubjectLikeOrContentLikeOrderByCreateDateAsc(String subject,String Content);
	
	// delete from question where subject like ?;
	void deleteBySubjectLike(String keyword);
	
	
	

}
