package com.meetUps.dao;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.meetUps.model.User;
@ComponentScan("com.meetUps")
	@Repository
	public interface UserDao {
		void addUser(User user);
		List<User> viewUsers();	
		void update(User user);
		User viewUserById(int id);
		int validateUser(String username,String password);
		void deleteUser(int id);
	}
