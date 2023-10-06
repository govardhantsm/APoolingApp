package com.tyss.ApollingApp.repository;

import java.util.List;  
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.ApollingApp.entity.User;
import com.tyss.ApollingApp.util.Role;
import com.tyss.ApollingApp.util.Status;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT u FROM User u WHERE u.userEmail=?1 AND u.userPassword=?2")
	Optional<User> findByUser_emailAndUser_password(String Email, String Password);
	
	public List<User> findUserByRole(Role role);
	@Query(value = "select u from User u where u.role=STUDENT and u.status=ACTIVE")
	public List<User> findAllStudents() ;
	
	public long countByStatus(Status status);
	@Query(value = "SELECT U FROM User U WHERE U.status=ACTIVE and U.role=TRINER or  U.role=STUDENT")
	public List<User> findActiveStudentOrTrinee();
}
