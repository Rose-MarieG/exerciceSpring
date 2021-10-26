package fr.solutec;

import java.util.Optional;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Address;
import fr.solutec.entities.User;
import fr.solutec.repository.AdressRepository;
import fr.solutec.repository.UserRepository;

@SpringBootApplication
public class PrimoSpringDev52021Application implements CommandLineRunner{
	@Autowired //permet de manipuler les éléments de l'interface
	private UserRepository userRepos;
	@Autowired
	private AdressRepository adressRepos;
	
	public static void main(String[] args) {
		SpringApplication.run(PrimoSpringDev52021Application.class, args);// lancement du projet
		System.out.println("lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {// executer en meme temps que le main
		//optimise le code
		Address a1= new Address(null,"Paris","jardin",3,74000);
		Address a2= new Address(null,"Bordeaux","Parc",6,67000);
		Address a3= new Address(null,"Paris","Champs",8,68000);
		Stream.of(a1,a2,a3).forEach(a->{
			adressRepos.save(a);
		});
		User u1 = new User(null,"cornet","arthur",14,"azerty","rose",a1);
		User u2 = new User(null,"gallon","rosemarie",15,"exploit","nom",a2);
		User u3 = new User(null,"rose","rose",15,"rose","rose",a3);//id long on peut mettre null
		userRepos.save(u1);
		userRepos.save(u2);
		userRepos.save(u3);

		
		/*userRepos.findAll().forEach(u->{System.out.println(u.toString());
	});
Optional<User> uP=userRepos.findByLoginAndMdp("azerty","ros");
if (uP.isPresent()) {
System.out.println("connexion ok");
System.out.println(uP.get().toString());//Optional peut recevoir un retour ou pas donc on ne peut
// pas l'utiliser comme un user on doit aller le chercher 
}
else {
	System.out.println("user not found");
	 
}*/
}}
