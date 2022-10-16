package net.atos.pets.repository;

import org.springframework.data.repository.CrudRepository;

import net.atos.pets.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {

}
