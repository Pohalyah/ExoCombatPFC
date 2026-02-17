package fr.afpa;

public class Combat {

    private Personnage joueur1;
    private Personnage joueur2;
    private Attaque attaque1;
    private Attaque attaque2;

    public Combat(Personnage joueur1, Personnage joueur2, Attaque attaque1, Attaque attaque2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.attaque1 = attaque1;
        this.attaque2 = attaque2;
    }

    public Personnage determinerVainqueur() {
        if (joueur1.getPointsDeVie() <= 0) {
            return joueur2;
        } else if (joueur2.getPointsDeVie() <= 0) {

            return joueur1;
        } else {
            return null;
        }
    }

    public int determinerVainqueurRound() {
        if (attaque1.getId() == attaque2.getId()) {
            // Aucun joueur gagne, égalite
            return 0;
        } else if (attaque1.getId() == 1 && attaque2.getId() == 3 ||
                attaque1.getId() == 2 && attaque2.getId() == 1 ||
                attaque1.getId() == 3 && attaque2.getId() == 2) {
            // Joueur 1 gagne
            return 1;
        } else {
            // Joueur 2 gagne
            return 2;
        }

    }

    public int appliquerResultatRound() {
        if (determinerVainqueurRound() == 0) {
            return 0;
        } else if (determinerVainqueurRound() == 1) {
            int degats = joueur1.calculerDegats(attaque1);
            joueur2.subirDegats(degats);
            return 1;
        } else {
            int degats = joueur2.calculerDegats(attaque2);
            joueur1.subirDegats(degats);
            return 2;
        }
    }

    public Attaque getAttaque1() {
        return attaque1;
    }

    public Attaque getAttaque2() {
        return attaque2;
    }

    public Personnage getJoueur1() {
        return joueur1;
    }

    public Personnage getJoueur2() {
        return joueur2;
    }

    public void setAttaque1(Attaque attaque1) {
        this.attaque1 = attaque1;
    }

    public void setAttaque2(Attaque attaque2) {
        this.attaque2 = attaque2;
    }

    public void setJoueur1(Personnage joueur1) {
        this.joueur1 = joueur1;
    }

    public void setJoueur2(Personnage joueur2) {
        this.joueur2 = joueur2;
    }

}
