package com.kostek.lvp.blog.Spring.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kostek.lvp.blog.Spring.blog.dto.RegisterRequest;
import com.kostek.lvp.blog.Spring.blog.model.User;
import com.kostek.lvp.blog.Spring.blog.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	public void signup(RegisterRequest registerRequest) {
		User user = new User();
		user.setUserName(registerRequest.getUsername());
		user.setPassword(registerRequest.getPassword());
		user.setEmail(registerRequest.getEmail());
		userRepository.save(user);
	}

}