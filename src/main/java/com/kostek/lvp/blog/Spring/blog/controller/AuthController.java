package com.kostek.lvp.blog.Spring.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kostek.lvp.blog.Spring.blog.dto.LoginRequest;
import com.kostek.lvp.blog.Spring.blog.dto.RegisterRequest;
import com.kostek.lvp.blog.Spring.blog.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
		authService.signup(registerRequest);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}
}
