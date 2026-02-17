package fr.afpa;

public interface Combattant {

    void subirDegats(int degats);

    boolean estVivant();

    int calculerDegats(Attaque attaque);

}
