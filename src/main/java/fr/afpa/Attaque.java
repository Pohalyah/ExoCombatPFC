package fr.afpa;

public class Attaque {
    private String nom;
    private int id;
    private int puissance;
    private final String[] attaques = { "Poing de feu", "Laser glace", "Ultralaser" };
    private Personnage attaquant;

    public Attaque(String nom, int id, int puissance, Personnage attaquant) {
        this.nom = nom;
        this.id = id;
        this.puissance = puissance;
        this.attaquant = attaquant;
    }

    public Personnage getAttaquant() {
        return attaquant;
    }

    public String[] getAttaques() {
        return attaques;
    }

    public void setAttaquant(Personnage attaquant) {
        this.attaquant = attaquant;
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

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
