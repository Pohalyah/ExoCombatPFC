package fr.afpa;

public class Guerrier extends Personnage {

    public Guerrier(String nom, int pv){
        super(nom, pv);
    }

    @Override
    public int calculerDegats(Attaque attaque) {

        return attaque.getPuissance() + 5;
    }
}
