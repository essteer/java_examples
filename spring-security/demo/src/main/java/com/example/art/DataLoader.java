package com.example.art;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.stereotype.Service;

import com.example.art.models.*;
import com.example.art.services.*;

@Service
public class DataLoader implements ApplicationRunner{

	private SeedService seedService;
	private UserService userService;

	public DataLoader(SeedService seedService, UserService userService) {
		super();
		this.seedService = seedService;
		this.userService = userService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Seed> seeds = new ArrayList<Seed>();
		seeds.add(new Seed("Sunflower", 2.99, "A tall annual flower with large, yellow blooms."));
		seeds.add(new Seed("Basil", 1.49, "An aromatic herb commonly used in cooking."));
		seeds.add(new Seed("Lavender", 3.99, "A fragrant plant known for its purple flowers."));
		seeds.add(new Seed("Tomato", 0.99, "A juicy, red fruit commonly used in salads and sauces."));
		seeds.add(new Seed("Marigold", 1.29, "A bright, cheerful flower often used as a natural pest repellent."));
		seeds.add(new Seed("Cucumber", 1.79, "A refreshing vegetable often enjoyed in salads and pickles."));
		seeds.add(new Seed("Rosemary", 2.49, "An aromatic herb used in cooking and for its medicinal properties."));
		seeds.add(new Seed("Zinnia", 0.99, "A colorful flower that blooms in various shades."));
		seeds.add(new Seed("Pepper", 1.49, "A spicy vegetable available in different varieties."));
		seeds.add(new Seed("Mint", 1.99, "A cooling herb used in teas, cocktails, and desserts."));
		seeds.add(new Seed("Daisy", 0.79, "A simple yet charming flower that comes in many colors."));
		seeds.add(new Seed("Carrot", 1.29, "A root vegetable known for its bright orange color."));
		seeds.add(new Seed("Cherry", 2.99, "A small, sweet fruit often enjoyed fresh or in desserts."));
		seeds.add(new Seed("Thyme", 2.49, "An herb with a pleasant aroma used in cooking and aromatherapy."));
		seeds.add(new Seed("Pansy", 0.99, "A delicate flower with velvety petals in various hues."));
		seeds.add(new Seed("Radish", 1.09, "A crisp and peppery root vegetable often used in salads."));
		seeds.add(new Seed("Lily", 3.49, "A fragrant flower available in different colors and varieties."));
		seeds.add(new Seed("Spinach", 1.49, "A nutrient-rich leafy green vegetable."));
		seeds.add(new Seed("Daffodil", 0.99, "A bright yellow flower that heralds the arrival of spring."));
		seeds.add(new Seed("Watermelon", 2.99, "A juicy fruit with a refreshing taste, perfect for hot summer days."));
		seeds.add(new Seed("Sage", 2.49, "An herb with grayish-green leaves used in cooking and for its medicinal properties."));
		seeds.add(new Seed("Petunia", 0.99, "A popular flower known for its trumpet-shaped blooms."));
		seeds.add(new Seed("Broccoli", 1.79, "A nutritious vegetable with green, tightly packed florets."));
		seeds.add(new Seed("Lemon", 0.69, "A tart and citrusy fruit used in cooking, beverages, and as a natural cleaner."));
		seeds.add(new Seed("Hyacinth", 2.99, "A fragrant flower that blooms in clusters of various colors."));
		seeds.add(new Seed("Lettuce", 1.49, "A leafy vegetable enjoyed in salads and sandwiches."));
		seeds.add(new Seed("Tulip", 1.29, "A classic flower available in a wide range of colors."));
		seeds.add(new Seed("Pumpkin", 2.99, "A large, orange fruit often associated with autumn and Halloween."));
		seeds.add(new Seed("Coriander", 1.99, "An herb with aromatic leaves and seeds used in cooking."));
		seeds.add(new Seed("Snapdragon", 0.99, "A colorful flower with vibrant, dragon-like blooms."));
		seeds.add(new Seed("Cauliflower", 1.79, "A versatile vegetable with a mild flavor and a dense, compact head."));
		seeds.add(new Seed("Gardenia", 3.49, "A fragrant flower known for its creamy white blooms."));
		seeds.add(new Seed("Celery", 1.29, "A crunchy vegetable often used in salads, soups, and snacks."));
		seeds.add(new Seed("Dandelion", 0.79, "A resilient flower with yellow blooms that turn into fluffy seed heads."));
		seeds.add(new Seed("Chili", 1.99, "A spicy pepper used to add heat and flavor to various dishes."));
		seeds.add(new Seed("Geranium", 0.99, "A popular flower often grown for its colorful blossoms and scented leaves."));
		seeds.add(new Seed("Beetroot", 1.49, "A root vegetable known for its vibrant purple-red color."));
		seeds.add(new Seed("Carnation", 2.99, "A fragrant flower with ruffled petals available in many colors."));
		seeds.add(new Seed("Cabbage", 1.79, "A leafy vegetable often used in salads, stir-fries, and fermented dishes."));
		seeds.add(new Seed("Orchid", 4.99, "An elegant flower that comes in a wide variety of shapes, sizes, and colors."));
		seeds.add(new Seed("Cilantro", 1.49, "An herb with fresh and citrusy leaves used in various cuisines."));
		seeds.add(new Seed("Aloe Vera", 2.99, "A succulent plant known for its soothing gel and medicinal properties."));
		seeds.add(new Seed("Hibiscus", 1.99, "A vibrant flower with large, showy blooms often used in herbal teas."));
		seeds.add(new Seed("Potato", 0.89, "A starchy vegetable enjoyed in a wide range of culinary preparations."));
		seeds.add(new Seed("Foxglove", 2.99, "A tall flower with tubular blossoms in various colors."));
		seeds.add(new Seed("Onion", 1.09, "A pungent vegetable used as a flavoring ingredient in numerous dishes."));
		seeds.add(new Seed("Daisy", 0.99, "A charming flower with a central disk surrounded by petals in different colors."));
		seeds.add(new Seed("Parsley", 1.49, "An herb with curly or flat leaves used as a garnish and flavor enhancer."));
		seeds.add(new Seed("Iris", 2.49, "A graceful flower with striking, sword-like leaves and beautiful blooms."));
		seeds.add(new Seed("Eggplant", 1.79, "A versatile vegetable with a glossy, purple skin and a creamy flesh."));
		seeds.add(new Seed("Fuchsia", 1.99, "A decorative flower known for its elegant, pendulous blossoms."));
		seeds.add(new Seed("Kale", 1.49, "A nutrient-packed leafy green vegetable with a slightly bitter taste."));
		this.seedService.saveAll(seeds);
		
		User user = new User("ryan","password");
		User admin = new User("admin","adminPassword",ROLE.ADMIN);
		this.userService.registerUser(admin);
		this.userService.registerUser(user);
		
	}
	
}
