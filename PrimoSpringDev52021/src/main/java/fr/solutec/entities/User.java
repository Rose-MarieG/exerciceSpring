package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor @AllArgsConstructor @Data

public class User {
	@Id @GeneratedValue //clé primaire auto générée
	private Long id;
	private String nom;
	private String prenom;
	private int age;
	private String login;
	private String mdp;
	@ManyToOne
	private Address adresse; // si manytomany liste ou collection
}