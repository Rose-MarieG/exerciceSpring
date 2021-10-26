package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Address;
import fr.solutec.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	//on ne peut pas créer de méthode
	public Optional<User> findByLoginAndMdp(String login,String password); // bien écrire le nom de l'attribut sinon ne marche pas 
	public List<User> findByAdresseVille(String ville);//peut transformer sensibilité pour prendre en compte majuscules
	
}

