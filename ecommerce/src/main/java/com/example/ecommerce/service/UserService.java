package com.example.ecommerce.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.ecommerce.model.User;
import com.example.ecommerce.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

}
