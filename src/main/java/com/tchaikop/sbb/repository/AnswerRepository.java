package com.tchaikop.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tchaikop.sbb.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{
	//기본적을 제공하는 메소드 3가지
	// findby(select), delete(delete), save(insert)
	//update는 없고 대신 findby하고 save
}
