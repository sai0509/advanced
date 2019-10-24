package com.mortgage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User userAuthentication(String user) {
		return userRepository.getUserByUsername(user);
	}
	
}
