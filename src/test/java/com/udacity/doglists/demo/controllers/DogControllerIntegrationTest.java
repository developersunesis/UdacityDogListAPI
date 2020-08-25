package com.udacity.doglists.demo.controllers;

import com.udacity.doglists.demo.models.Dog;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class DogControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    void getAllDogBreeds() {
        TestRestTemplate testRestTemplate
                = new TestRestTemplate("admin", "password");
        ResponseEntity<?> responseEntity =
                testRestTemplate.getForEntity("http://localhost:" + port + "/dogs", List.class);
        assertEquals(responseEntity.getStatusCode().value(), HttpStatus.OK.value());
    }

    @Test
    void getAllDogBreedById() {
        TestRestTemplate testRestTemplate
                = new TestRestTemplate("admin", "password");
        ResponseEntity<?> responseEntity =
                testRestTemplate.getForEntity("http://localhost:" + port + "/dog/1/breed", Dog.class);
        assertEquals(responseEntity.getStatusCode().value(), HttpStatus.OK.value());
    }

    @Test
    void getAllDogNames() {
        TestRestTemplate testRestTemplate
                = new TestRestTemplate("admin", "password");
        ResponseEntity<?> responseEntity =
                testRestTemplate.getForEntity("http://localhost:" + port + "/dog/names", String.class);
        assertEquals(responseEntity.getStatusCode().value(), HttpStatus.OK.value());
    }
}