package com.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	 List<User> findByUsernameAndPassword(String username,String password);
}
