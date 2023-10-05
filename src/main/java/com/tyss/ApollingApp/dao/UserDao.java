package com.tyss.ApollingApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.ApollingApp.entity.User;
import com.tyss.ApollingApp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		userRepository.save(user);
		return user;
	}

	public User findById(int id) {
		return userRepository.findById(id).get();
	}

	public User findByEmailandPassword(String email, String password) {
		return userRepository.findByUser_emailAndUser_password(email, password);
	}

	public List<User> findAll(String email, String password) {
		return userRepository.findAll();
	}

	public void delete(int id) {
		userRepository.deleteById(id);
	}
}
