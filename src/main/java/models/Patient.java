package models;

import java.util.Date;
import java.util.List;

public class Patient extends Personne{
    public Patient() {
    }

    public Patient(String adresse, Boolean civilite, Date dateNaissance, String email, String nom, String passWord, String prenom, String numTelephone, String userName, String assurance, Medecin medecin, String profession, String remarque, List<Maladie> maladies, List<Vaccin> vaccins, List<Image> images, List<Allergie> allergies) {
        super(adresse, civilite, dateNaissance, email, nom, passWord, prenom, numTelephone, userName);
        this.assurance = assurance;
        this.medecin = medecin;
        this.profession = profession;
        this.remarque = remarque;
        this.maladies = maladies;
        this.vaccins = vaccins;
        this.images = images;
        this.allergies = allergies;
    }

    private String assurance;
private Medecin medecin;
private  String profession;
private String remarque;
private List<Maladie> maladies;
private List<Vaccin> vaccins;
private List<Image> images;
private List<Allergie> allergies;
}
