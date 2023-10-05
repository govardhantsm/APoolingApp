package com.tyss.ApollingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.ApollingApp.entity.Presentation;
import com.tyss.ApollingApp.entity.User;

public interface PresentationRepository extends JpaRepository<Presentation, Integer> {

	
   
}
