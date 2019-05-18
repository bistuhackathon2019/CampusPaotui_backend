package com.bistu.paotui.controller;

import com.alibaba.fastjson.JSONObject;
import com.bistu.paotui.entity.User;
import com.bistu.paotui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	private UserService userService;

	@Autowired
	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public String userRegister(@RequestBody User user) {
		JSONObject json = new JSONObject();
		json.put("user_id", userService.addUser(user));
		return json.toJSONString();
	}

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public User userLogin(@RequestBody User user) {
		return userService.login(user);
	}

}
