package com.udacity.doglists.demo;

import com.udacity.doglists.demo.repository.DogRepository;
import com.udacity.doglists.demo.services.DogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UdacityDogListsApplicationTests {

	@Autowired
	DogRepository dogRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void dogList(){
		dogRepository.findAll().forEach(dog -> {
			System.out.println(dog.getName());
			assertNotNull(dog);
		});
	}

}
