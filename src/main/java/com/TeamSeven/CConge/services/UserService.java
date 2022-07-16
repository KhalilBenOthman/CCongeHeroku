package com.TeamSeven.CConge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.TeamSeven.CConge.domain.User;
import com.TeamSeven.CConge.exceptions.UsernameExistException;
import com.TeamSeven.CConge.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	public User saveUser(User newUser) {
		
		try {
			newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));	
			newUser.setConfirmPassword(null);
			return userRepository.save(newUser);
		} catch (Exception e) {
			throw new UsernameExistException("Username "+newUser.getUsername()+" déja exist");
		}
		
		
	}
	
	
	
	
	
}
