package com.example.art.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.art.models.User;


public interface UserRepo extends JpaRepository<User, Integer>{

	public Optional<User> findByUsername(String username);

}
