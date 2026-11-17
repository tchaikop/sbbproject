package com.tchaikop.sbb.entity;

import java.time.LocalDateTime;

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
	
	@OneToMany
	private Answer answer;

}
