package com.telusko.SpringSecurityExap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.SpringSecurityExap.model.User;
import com.telusko.SpringSecurityExap.model.UserPrincipal;
import com.telusko.SpringSecurityExap.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		
		if(user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("User NOt Found");
		}
		return new UserPrincipal(user);
		
	}

}
