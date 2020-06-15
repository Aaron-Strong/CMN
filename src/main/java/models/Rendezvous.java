package models;

import java.util.Date;

public class Rendezvous {
    public Rendezvous() {
    }

    public Rendezvous(int id, String nom, String description, Date date, boolean critique, int patientid) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.critique = critique;
        this.patientid = patientid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCritique() {
        return critique;
    }

    public void setCritique(boolean critique) {
        this.critique = critique;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    private  int id;
    private String nom;
    private String description;
    private Date date;
    private boolean critique;
    private int patientid;
}
