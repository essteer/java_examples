package com.example.art.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.art.models.Seed;

public interface SeedRepo extends JpaRepository<Seed, Integer>{

}
