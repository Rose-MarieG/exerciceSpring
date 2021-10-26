package fr.solutec;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.User;
import fr.solutec.repository.UserRepository;

@SpringBootApplication
public class ExerciceSpringApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepos;

	public static void main(String[] args) {
		SpringApplication.run(ExerciceSpringApplication.class, args);
		System.out.println("lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u1 = new User(null, "CORNET", "Arthur", "arthurc", "1234");
		User u2 = new User(null, "MSAIDIE", "Zaher", "exploit", "abcd");
		User u3 = new User (null, "EUSTACHE", "Juliette", "juliettee", "rose");
		User u4 = new User (null, "GALLON", "Rose-Marie", "rosemarieg", "arbre");
		Stream.of(u1, u2, u3, u4).forEach(u -> {
			userRepos.save(u);
		});
	}

}
