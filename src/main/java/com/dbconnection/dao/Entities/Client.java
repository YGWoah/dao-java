package com.dbconnection.dao.Entities;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String address;

    public Client() {
    }

    public Client(int id, String nom, String prenom, String email, String address) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.address = address;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
