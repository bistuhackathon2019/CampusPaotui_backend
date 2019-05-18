package com.bistu.paotui.dao;

import com.bistu.paotui.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByPhoneAndPassword(String phone, String password);
}
