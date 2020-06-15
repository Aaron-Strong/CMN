package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
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

	public Personne(String adresse, Boolean civilite, Date dateNaissance, String email, String nom, String passWord, String prenom, String numTelephone, String userName) {
		this.adresse = adresse;
		this.civilite = civilite;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.nom = nom;
		this.passWord = passWord;
		this.prenom = prenom;
		this.numTelephone = numTelephone;
		this.userName = userName;
	}

	public Personne() {

	}


}
