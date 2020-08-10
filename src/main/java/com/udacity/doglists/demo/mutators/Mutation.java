package com.udacity.doglists.demo.mutators;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.doglists.demo.exceptions.DogNotFound;
import com.udacity.doglists.demo.models.Dog;
import com.udacity.doglists.demo.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class Mutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed){
        AtomicBoolean deleted = new AtomicBoolean(false);
        dogRepository.findAll().forEach(dog -> {
            if(dog.getBreed().equals(breed)){
                dogRepository.delete(dog);
                deleted.set(true);
            }
        });

        if(!deleted.get()) throw new DogNotFound("Dog breed not found", breed);

        return deleted.get();
    }

    public Dog updateDogName(String name, long id){
        Dog dog = dogRepository.findById(id)
                .orElseThrow(() -> new DogNotFound("Dog not found", id));
        dog.setName(name);
        return dogRepository.save(dog);
    }
}
