package com.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aop.dto.UserDto;
import com.aop.dto.UserRegDto;
import com.aop.model.User;
import com.aop.response.Response;
import com.aop.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping(value= {"/reg","/user/{userId}"})
	public Response<UserRegDto> createUser(@RequestBody UserDto user,@PathVariable(required=false) Integer userId) {
		return userService.createUser(user,userId);
	}
}
