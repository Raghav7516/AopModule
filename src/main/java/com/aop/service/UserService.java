package com.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aop.dto.UserDto;
import com.aop.dto.UserRegDto;
import com.aop.model.User;
import com.aop.repository.UserRepo;
import com.aop.response.Response;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Transactional
	public Response<UserRegDto> createUser(UserDto user, Integer userId) {
		Response<UserRegDto> response=new Response<>();
		User newUser=new User();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setAge(user.getAge());
		userRepo.save(newUser);
		response.setData(new UserRegDto(newUser.getUserId(), newUser.getFirstName(), newUser.getLastName()));
		response.setMessage("user "+newUser.getFirstName()+" "+newUser.getLastName()+" created successfully");
		return response;
	}
}
