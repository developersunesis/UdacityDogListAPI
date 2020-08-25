package com.udacity.doglists.demo.controllers;

import com.udacity.doglists.demo.models.Dog;
import com.udacity.doglists.demo.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {


    @Autowired
    DogService dogService;

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogBreeds(){
        return ResponseEntity.ok(dogService.retrieveDogBreed());
    }

    @GetMapping("/dog/{id}/breed")
    public ResponseEntity<?> getAllDogBreedById(@PathVariable long id){
        try {
            return ResponseEntity.ok(dogService.retrieveDogBreedById(id));
        }catch (NullPointerException nullPointerException){
            return new ResponseEntity<>("Dog with id : " + id + " not found",
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/dog/names")
    public ResponseEntity<?> getAllDogNames(){
        return ResponseEntity.ok(dogService.retrieveDogNames());
    }
}
