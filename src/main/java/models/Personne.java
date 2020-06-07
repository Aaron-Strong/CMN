package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Personne {

	private String adresse;
	private Boolean civilite;
	private Date dateNaissance;
	private String email;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String passWord;
	private String prenom;
	private String numTelephone;
	private String userName;


	public Personne() {

	}


}
