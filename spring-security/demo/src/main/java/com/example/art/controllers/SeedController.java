package com.example.art.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.art.models.Seed;
import com.example.art.services.SeedService;

@RestController
@RequestMapping("seed")
public class SeedController {
	private SeedService seedService;

	public SeedController(SeedService seedService) {
		super();
		this.seedService = seedService;
	}
	
	@GetMapping
	public List<Seed> getSeeds(){
		return this.seedService.findAll();
	}
	
}

