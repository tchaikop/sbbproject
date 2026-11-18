package com.tchaikop.sbb.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Question {
	@Id  //pk 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increment자동증가
	private Integer id;  //int ->Integer (null 값을 가질 수 없기때문에)
	//Entity 클래스에서는 멤버 를 선언할때 int, double 같은 기본 타입으로 선언하지 않는다
	
	@Column(length = 200, nullable = false)  // varcher()기본적으로 255자
	private String subject;
	
	@Column(columnDefinition = "text", nullable = false) //255 이상
	private String content;
	
	// @CreatedDate 자동으로 레코드 생성시 현재 날짜 시간이 삽입. 아프리카 같은 나라에 DB가 있다면 그쪽 시간
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade= CascadeType.REMOVE)  //1대 n 관계
	//질문 글이 사라지면 질문글에 달린 답변글이 사라지는 옵션
	private List<Answer> answerList; // 질문 하나에 답변이 여러개 저장 될 수 있는 자리를 마련

}
