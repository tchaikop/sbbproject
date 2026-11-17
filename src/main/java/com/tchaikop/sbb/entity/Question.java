package com.tchaikop.sbb.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;  //int ->Integer (null 값을 가질 수 없기때문에)
	//Entity 클래스에서는 멤버 를 선언할때 int, double 같은 기본 타입으로 선언하지 않는다
	
	@Column(length = 200, nullable = false)
	private String subject;
	
	@Column(columnDefinition = "text", nullable = false) //255 이상
	private String content;
	
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)  //1대 n 관계
	//질문 글이 사라지면 질문글에 달린 답변글이 사라지는 옵션
	private ArrayList<Answer> answerList; // 질문 하나에 답변이 여러개 저장 될 수 있는 자리를 마련

}
