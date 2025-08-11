package com.telusko.SpringSecurityExap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.SpringSecurityExap.model.User;
import com.telusko.SpringSecurityExap.service.UserService;

@RestController
public class UserController {

    private final AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService service;


    UserController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
	
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return service.register(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return service.verify(user);
	}

}
