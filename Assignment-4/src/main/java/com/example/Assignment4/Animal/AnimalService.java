package com.example.Assignment4.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<AnimalEntity> getAllAnimals() {
        return animalRepository.findAll();
    }

    public AnimalEntity getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    public List<AnimalEntity> getSpecies(String species) {
        return animalRepository.getAnimalBySpecies(species);
    }
    public List<AnimalEntity> getMatching(String input) {
        return animalRepository.getAnimalByPartialMatch(input);
    }

    public void addNewAnimal( AnimalEntity animal) {
        animalRepository.save(animal);
    }

    public void updateAnimal(int animalId, AnimalEntity animal) {
        AnimalEntity exists = getAnimalById(animalId);
        exists.setName(animal.getName());
        exists.setScientificName(animal.getScientificName());
        exists.setSpecies(animal.getSpecies());
        exists.setHabitat(animal.getHabitat());
        exists.setDescription(animal.getDescription());

        animalRepository.save(exists);
    }

    public void deleteAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }
}
