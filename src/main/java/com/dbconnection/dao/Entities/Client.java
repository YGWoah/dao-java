package com.dbconnection.dao.Entities;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String address;
    private String password;

    public Client(int i, String string, String string2, String string3, String string4, String string5,
            String string6) {
    }

    public Client(int id, String nom, String prenom, String email, String address, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.address = address;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", address=" + address
                + "]";
    }

}
