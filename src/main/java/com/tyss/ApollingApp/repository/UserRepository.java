package com.tyss.ApollingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.ApollingApp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
                
}
