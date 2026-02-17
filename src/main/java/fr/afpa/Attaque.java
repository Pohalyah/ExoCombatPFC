package fr.afpa;

public class Attaque {
    private String nom;
    private int id;
    private int puissance;

    public Attaque(String nom, int id, int degats) {
        this.nom = nom;
        this.id = id;
        this.puissance = degats;
    }

    public int getPuissance() {
        return puissance;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setPuissance(int degats) {
        this.puissance = degats;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
