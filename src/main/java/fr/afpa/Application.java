package fr.afpa;

import java.util.Scanner;

public class Application {

    // public static void main(String[] args) {

    // Scanner scanner = new Scanner(System.in);

    // // Création des personnages
    // Personnage joueur1 = new Guerrier("Guerrier", 100);
    // Personnage joueur2 = new Mage("Mage", 100);

    // while (joueur1.estVivant() && joueur2.estVivant()) {

    // System.out.println("\n--- Nouveau Round ---");

    // // Choix attaque joueur 1
    // System.out.println("Joueur 1 - Choisissez une attaque (1, 2 ou 3) : ");
    // int id1 = scanner.nextInt();

    // // Choix attaque joueur 2
    // System.out.println("Joueur 2 - Choisissez une attaque (1, 2 ou 3) : ");
    // int id2 = scanner.nextInt();

    // // Définition des puissances de base
    // int puissance1 = 10;
    // int puissance2 = 10;

    // if (id1 == 2)
    // puissance1 = 15;
    // if (id1 == 3)
    // puissance1 = 20;

    // if (id2 == 2)
    // puissance2 = 15;
    // if (id2 == 3)
    // puissance2 = 20;

    // // Création des attaques
    // Attaque attaque1 = new Attaque("Attaque J1", id1, puissance1, joueur1);
    // Attaque attaque2 = new Attaque("Attaque J2", id2, puissance2, joueur2);

    // // Calcul des dégâts via polymorphisme
    // int degats1 = joueur1.calculerDegats(attaque1);
    // int degats2 = joueur2.calculerDegats(attaque2);

    // // Logique pierre-feuille-ciseaux
    // if (id1 == id2) {
    // System.out.println("Egalité !");
    // } else if ((id1 == 1 && id2 == 3) ||
    // (id1 == 2 && id2 == 1) ||
    // (id1 == 3 && id2 == 2)) {

    // System.out.println("Joueur 1 gagne le round !");
    // joueur2.subirDegats(degats1);
    // } else {
    // System.out.println("Joueur 2 gagne le round !");
    // joueur1.subirDegats(degats2);
    // }

    // System.out.println("PV Joueur 1 : " + joueur1.getPointsDeVie());
    // System.out.println("PV Joueur 2 : " + joueur2.getPointsDeVie());
    // }

    // if (joueur1.estVivant()) {
    // System.out.println("Joueur 1 remporte la partie !");
    // } else {
    // System.out.println("Joueur 2 remporte la partie !");
    // }
    // }
}
