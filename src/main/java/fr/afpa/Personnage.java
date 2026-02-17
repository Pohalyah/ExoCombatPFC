package fr.afpa;

public abstract class Personnage implements Combattant {
    private String nom;
    private int pointsDeVie;

    public Personnage(String nom, int pointsDeVie) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public void subirDegats(int degats) {
        this.pointsDeVie = this.pointsDeVie - degats;
        if (this.pointsDeVie < 0) {
            this.pointsDeVie = 0;
        }
    }

    public boolean estVivant() {
        boolean isAlive = true;
        if (pointsDeVie <= 0) {
            isAlive = false;
        }
        return isAlive;
    }

    public abstract int calculerDegats(Attaque attaque);
}