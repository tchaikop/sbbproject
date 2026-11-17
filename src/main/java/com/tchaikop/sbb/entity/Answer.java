package com.tchaikop.sbb.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;  //int ->Integer (null 값을 가질 수 없기때문에)
	//Entity 클래스에서는 멤버 를 선언할때 int, double 같은 기본 타입으로 선언하지 않는다
	
	
	@Column(columnDefinition = "text", nullable = false) //255 이상
	private String content;
	
	
	private LocalDateTime createDate;
	
	//답변이 달릴 질문(부모)글의 정보가 명시
	// 부모가 한명이니까 one인것이고 답변은 여러개 있을 수 있으니가 many
	
	@ManyToOne
	private Question question;  //답변이 달릴 부모 질문글의 모든 정보가 담긴 질문글  1개 객체가 저장

}
