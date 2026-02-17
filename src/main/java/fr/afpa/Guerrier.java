package fr.afpa;

public class Guerrier extends Personnage {

    @Override
    public int calculerDegats(Attaque attaque) {

        return attaque.getPuissance() + 5;
    }
}
