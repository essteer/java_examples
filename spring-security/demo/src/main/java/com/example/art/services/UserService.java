package com.example.art.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.art.repos.UserRepo;
import com.example.art.models.User;


@Service
public class UserService {
	private UserRepo userRepo;
	private PasswordEncoder passwordEncoder;

	public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
		super();
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}


	public void registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		this.userRepo.save(user);
	}
}
