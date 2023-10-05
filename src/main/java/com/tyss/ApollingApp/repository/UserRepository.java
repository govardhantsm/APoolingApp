package com.tyss.ApollingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.ApollingApp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT u FROM User u WHERE u.user_email=?1 AND u.user_password=?2")
	User findByUser_emailAndUser_password(String Email, String Password);
}
