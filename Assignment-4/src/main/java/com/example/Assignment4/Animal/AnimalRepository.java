package com.example.Assignment4.Animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {

    List<AnimalEntity> getAnimalBySpecies(String species);

    @Query(value = "select * from animals a where a.name like %?1%", nativeQuery = true)
    List<AnimalEntity> getAnimalByPartialMatch(String input);


}
