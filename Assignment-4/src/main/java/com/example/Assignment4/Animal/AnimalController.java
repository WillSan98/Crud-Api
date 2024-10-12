package com.example.Assignment4.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping("/all")
    public List<AnimalEntity> getAllAnimals() {
        return service.getAllAnimals();
    }

    @GetMapping("/{animalId}")
    public AnimalEntity getAnAnimalViaId(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }

    @GetMapping("/match/{entry}")
    public List<AnimalEntity> getAnAnimalViaId(@PathVariable String entry) {
        return service.getMatching(entry);
    }

    @GetMapping("")
    public List<AnimalEntity> getBySpecies(@RequestParam(name = "species", defaultValue = "null") String species) {
        return service.getSpecies(species);
    }

    @PostMapping("/new")
    public List<AnimalEntity> addNewAnimal(@RequestBody AnimalEntity animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }

    @PutMapping("/update/{animalId}")
    public AnimalEntity updateAnimal(@PathVariable int animalId, @RequestBody AnimalEntity animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }

    @DeleteMapping("/delete/{animalId}")
    public List<AnimalEntity> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }
}
