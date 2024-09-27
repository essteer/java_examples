package com.example.art.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.art.repos.SeedRepo;
import com.example.art.models.Seed;


@Service
public class SeedService {

	private SeedRepo seedRepo;

	public SeedService(SeedRepo seedRepo) {
		super();
		this.seedRepo = seedRepo;
	}
	
	public void saveAll(Iterable<Seed> seeds) {
		this.seedRepo.saveAll(seeds);
	}

	public List<Seed> findAll() {
		// TODO Auto-generated method stub
		return this.seedRepo.findAll();
	}
	
}