package com.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aop.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
