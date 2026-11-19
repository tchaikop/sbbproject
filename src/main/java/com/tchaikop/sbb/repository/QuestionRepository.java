package com.tchaikop.sbb.repository;


import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tchaikop.sbb.entity.Question;
import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
	List<Question> findBySubject(String subject);//제목으로 질문글 찾기 메소드
	// list 빠지면 첫번찌 글만 온다
	
	//모든 질문글을 등록일의 내림차순으로 정렬하여 반환하는 메서드
	List<Question> findAllByOrderByCreateDateDesc();
	
	
	
	
	List<Question> findBySubjectLike(String subject);
	//select * from question where like ?
	
	List<Question> findBySubjectContaining(String subject);
	
	//select * from question where subject like ? or content like ?
	List<Question> findBySubjectLikeOrContentLike(String subject,String Content);
	
	List<Question> findBySubjectLikeOrContentLikeOrderByCreateDateAsc(String subject,String Content);
	
	// delete from question where subject like ?;
	void deleteBySubjectLike(String keyword);
	
	//페이징 처리 후 질문글 목록 부러오기 메소드
	Page<Question> findAll(Pageable pageable);
	// pageable  사용자가 클릭한 펭지 바ㅓㄴ호, 한 페이지 당 보여질 질무글의 갯수
	

}
