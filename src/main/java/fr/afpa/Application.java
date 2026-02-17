// package fr.afpa;

// import java.util.Scanner;

// public class Application {

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);

// Personnage joueur1 = new Guerrier("Jacobus", 100);
// Personnage joueur2 = new Mage("Narnia", 80);

// Attaque[] attaqueJ1 = {
// new Attaque("Poing de feu", 1, 8),
// new Attaque("Mach Punch", 2, 17),
// new Attaque("Ultralaser", 3, 25)
// };

// Attaque[] attaquesJ2 = {
// new Attaque("Tempête de vent", 1, 10),
// new Attaque("Laser glace", 2, 15),
// new Attaque("Explosion de feu", 3, 21)
// };

// while (joueur1.estVivant() && joueur2.estVivant()) {
// System.out.println(joueur1.getNom() + " PV : " + joueur1.getPointsDeVie());
// System.out.println(joueur2.getNom() + " PV : " + joueur2.getPointsDeVie());

// System.out.println("Joueur 1, choisissez une attaque (1-3) :");
// for (int i = 0; i < attaqueJ1.length; i++) {
// System.out.println((i + 1) + " : " + attaqueJ1[i].getNom() + " (" +
// attaqueJ1[i].getPuissance() + ")");
// }
// int choix1 = sc.nextInt();
// Attaque attaque1 = attaqueJ1[choix1 - 1];

// System.out.println("Joueur 2, choisissez une attaque (1-3) :");
// for (int i = 0; i < attaquesJ2.length; i++) {
// System.out
// .println((i + 1) + " : " + attaquesJ2[i].getNom() + " (" +
// attaquesJ2[i].getPuissance() + ")");
// }
// int choix2 = sc.nextInt();
// Attaque attaque2 = attaquesJ2[choix2 - 1];

// Combat combat = new Combat(joueur1, joueur2, attaque1, attaque2);
// int vainqueurRound = combat.appliquerResultatRound();

// switch (vainqueurRound) {
// case 0 -> System.out.println("Égalité !");
// case 1 -> System.out.println(joueur1.getNom() + " gagne le round !");
// case 2 -> System.out.println(joueur2.getNom() + " gagne le round !");
// }
// }

// Personnage vainqueur = joueur1.estVivant() ? joueur1 : joueur2;
// System.out.println("Le vainqueur de la partie est : " + vainqueur.getNom());

// sc.close();
// }
// }
