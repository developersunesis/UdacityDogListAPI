package com.udacity.doglists.demo.services;

import com.udacity.doglists.demo.models.Dog;
import com.udacity.doglists.demo.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogService {

    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogBreed(){
        return (List<Dog>) dogRepository.findAll();
    }

    public Dog retrieveDogBreedById(long id){
        return dogRepository.findById(id)
                .orElseThrow(NullPointerException::new);
    }

    public List<String> retrieveDogNames(){
        List<String> names = new ArrayList<>();
        dogRepository.findAll().forEach(dog -> names.add(dog.getName()));
        return names;
    }
}
