package com.bistu.paotui.service;

import com.bistu.paotui.dao.UserRepository;
import com.bistu.paotui.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public int addUser(User user) {
		return userRepository.save(user).getUserId();
	}

	public User login(User user) {
		user = userRepository.findByPhoneAndPassword(user.getPhone(), user.getPassword());
		user.setPassword("");
		return user;
	}
}
