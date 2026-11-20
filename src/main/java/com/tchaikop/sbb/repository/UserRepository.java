package com.tchaikop.sbb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tchaikop.sbb.entity.SiteUser;

public interface UserRepository extends JpaRepository<SiteUser, Long>{
	
	

}
