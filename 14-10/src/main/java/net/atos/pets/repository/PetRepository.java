package net.atos.pets.repository;

import org.springframework.data.repository.CrudRepository;

import net.atos.pets.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
