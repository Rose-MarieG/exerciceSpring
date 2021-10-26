package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.User;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin("*")//api qui peuvent conssommer par tout le monde
public class UserRest {
	@Autowired
	private UserRepository userRepos;
	
	@GetMapping("user")
	public Iterable<User> getAllUser(){ //Iterable comme une liste 
		return userRepos.findAll();//renvoie un iterable préciser le lien qui declenche la méthode
	}
	@Autowired
	private UserRepository userRepo;
	
	
	@GetMapping("address/{ville}")
	public Iterable<User> getUserParis(@PathVariable String ville){

		return userRepo.findByAdresseVille(ville);
	}
	@PostMapping("user")
	public User saveUser(@RequestBody User u) { // post à un body on spécifie le body user dans insomina
		return userRepos.save(u); // on spécifie dans insomia le user que l'on veut ajouter en json
	}
	@PutMapping("user/{id}")
	public User modifUser(@PathVariable Long id,@RequestBody User u) { 
		u.setId(id);
		return userRepos.save(u); //permet de trouver user avec iduser=id et ensuite on change la valeur souhaité en gardant tout
	}
	@DeleteMapping("user/{id}")
	public void deleteUser(@PathVariable Long id,User u) {
		u.setId(id);
		userRepos.delete(u);
	}
	
	/*@DeleteMapping("user/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		if (userRepos.findById(id).isPresent()){
			userRepos.deleteById(id);
			return true;}
		else{
			return false;
		}
	}*/
		
}
