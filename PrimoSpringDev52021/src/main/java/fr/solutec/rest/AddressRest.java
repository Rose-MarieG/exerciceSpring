package fr.solutec.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Address;
import fr.solutec.entities.User;
import fr.solutec.repository.AdressRepository;
import fr.solutec.repository.UserRepository;


@RestController @CrossOrigin("*")
public class AddressRest {
	@Autowired
	private AdressRepository addressRepos;
	@PostMapping("adress")
	public Address saveAdresse(@RequestBody Address a) {
		return addressRepos.save(a);
	}

	}

