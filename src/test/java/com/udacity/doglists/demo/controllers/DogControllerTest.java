package com.udacity.doglists.demo.controllers;

import com.udacity.doglists.demo.services.DogService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
class DogControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DogService dogService;

    @Test
    @WithMockUser(username = "admin")
    void getAllDogBreeds() throws Exception {
        mockMvc.perform(get("/dogs"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
        verify(dogService, times(1)).retrieveDogBreed();
    }

    @Test
    @WithMockUser(username = "admin")
    void getAllDogBreedById() throws Exception {
        mockMvc.perform(get("/dog/1/breed"))
                .andExpect(status().isOk());
        verify(dogService, times(1)).retrieveDogBreedById(1);
    }

    @Test
    @WithMockUser(username = "admin")
    void getAllDogNames() throws Exception {
        mockMvc.perform(get("/dog/names"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
        verify(dogService, times(1)).retrieveDogNames();
    }
}