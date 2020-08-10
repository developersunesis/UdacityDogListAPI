package com.udacity.doglists.demo.repository;

import com.udacity.doglists.demo.models.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
