package com.kostek.lvp.blog.Spring.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kostek.lvp.blog.Spring.blog.dto.LoginRequest;
import com.kostek.lvp.blog.Spring.blog.dto.RegisterRequest;
import com.kostek.lvp.blog.Spring.blog.model.User;
import com.kostek.lvp.blog.Spring.blog.repository.UserRepository;
import com.kostek.lvp.blog.Spring.blog.security.JwtProvider;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtProvider jwtProvider;

	public void signup(RegisterRequest registerRequest) {
		User user = new User();
		user.setUserName(registerRequest.getUsername());
		user.setPassword(encodePassword(registerRequest.getPassword()));
		user.setEmail(registerRequest.getEmail());
		userRepository.save(user);
	}

	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

	public String login(LoginRequest loginRequest) {
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		return jwtProvider.generateToken(authenticate);
	}

}
