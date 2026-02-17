package fr.afpa;

public class Mage extends Personnage {

    public Mage(String nom, int pv) {
        super(nom, pv);
    }

    @Override
    public int calculerDegats(Attaque attaque) {
        if (attaque.getId() == 3) {
            return attaque.getPuissance() + 10;
        }
        if (Math.random() < 0.2) {
            return attaque.getPuissance() * 2;
        }
        return attaque.getPuissance();
    }
}
