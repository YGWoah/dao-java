package com.dbconnection.dao.Entities;

public class Product {
    // Attributes
    private int id;
    private String nom;
    private String description;
    private int prix;
    private int quantite;

    // Constructors
    public Product() {
    }

    public Product(int id, String nom, String description, int prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrix() {
        return this.prix;
    }

    public int getQuantite() {
        return this.quantite;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", quantite="
                + quantite + "]";
    }

}
