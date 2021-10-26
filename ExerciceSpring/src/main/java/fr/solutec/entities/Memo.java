package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Memo {
	@Id @GeneratedValue
	private Long id;
	private String msg;
	private String statut;
	@OneToOne
	private User destinataire;
	@ManyToOne
	private User user;
}
