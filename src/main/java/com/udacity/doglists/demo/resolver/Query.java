package com.udacity.doglists.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.doglists.demo.exceptions.DogNotFound;
import com.udacity.doglists.demo.models.Dog;
import com.udacity.doglists.demo.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private DogRepository dogRepository;

    public Query(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    public String findDogBreedById(long id){
        return dogRepository.findById(id)
                .orElseThrow(() -> new DogNotFound("Dog not found", id)).getBreed();
    }

    public List<String> findAllDogNames(){
        List<String> names = new ArrayList<>();
        dogRepository.findAll().forEach(dog -> {
            names.add(dog.getName());
        });
        return names;
    }
}
