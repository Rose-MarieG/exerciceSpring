package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Address;
import fr.solutec.entities.User;


public interface AdressRepository extends CrudRepository<Address, Long> {
	
	
}
