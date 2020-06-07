package models;

import java.util.List;

public class Patient extends Personne{
private String assurance;
private Medecin medecin;
private  String profession;
private String remarque;
private List<Maladie> maladies;
private List<Vaccin> vaccins;
private List<Image> images;
private List<Allergie> allergies;
}
