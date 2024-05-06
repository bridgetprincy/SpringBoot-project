package com.example.ecommerce.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	
	@Autowired 
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= repo.findByEmail(username);
		
		  if (user == null) {
	            throw new UsernameNotFoundException("No user found with the given email");
	        }
	         
	        return new CustomUserDetails(user);
	    }
	 
	}


