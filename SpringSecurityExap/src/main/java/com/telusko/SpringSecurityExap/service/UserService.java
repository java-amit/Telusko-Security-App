package com.telusko.SpringSecurityExap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.telusko.SpringSecurityExap.model.User;
import com.telusko.SpringSecurityExap.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	AuthenticationManager authManager;
	
	public User register(User user) {
		return  repo.save(user);
	}


	public String verify(User user) {
		Authentication authentication = 
				authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),  user.getPassword()));
		
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		}
		
		return "fail";	
	}

}
