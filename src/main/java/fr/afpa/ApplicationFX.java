package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ApplicationFX extends Application {

    private Attaque choixJ1 = null;
    private Attaque choixJ2 = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Personnage joueur1 = new Guerrier("Jacobus", 100);
        Personnage joueur2 = new Mage("Narnia", 80);

        Attaque[] attaqueJ1 = {
                new Attaque("Poing de feu", 1, 8),
                new Attaque("Mach Punch", 2, 17),
                new Attaque("Ultralaser", 3, 25)
        };

        Attaque[] attaquesJ2 = {
                new Attaque("Tempête de vent", 1, 10),
                new Attaque("Laser glace", 2, 15),
                new Attaque("Explosion de feu", 3, 21)
        };

        Label pvJ1 = new Label(joueur1.getNom() + " PV : " + joueur1.getPointsDeVie());
        Label pvJ2 = new Label(joueur2.getNom() + " PV : " + joueur2.getPointsDeVie());

        Label combatMsg = new Label("Choisissez vos attaques !");

        HBox attaquesBoxJ1 = new HBox(10);
        HBox attaquesBoxJ2 = new HBox(10);
        attaquesBoxJ1.setPadding(new Insets(10));
        attaquesBoxJ2.setPadding(new Insets(10));

        for (Attaque a : attaqueJ1) {
            Button b = new Button(a.getNom());
            b.setOnAction(e -> {
                choixJ1 = a;
                checkEtAppliquerRound(joueur1, joueur2, pvJ1, pvJ2, combatMsg, attaquesBoxJ1, attaquesBoxJ2);
            });
            attaquesBoxJ1.getChildren().add(b);
        }

        for (Attaque a : attaquesJ2) {
            Button b = new Button(a.getNom());
            b.setOnAction(e -> {
                choixJ2 = a;
                checkEtAppliquerRound(joueur1, joueur2, pvJ1, pvJ2, combatMsg, attaquesBoxJ1, attaquesBoxJ2);
            });
            attaquesBoxJ2.getChildren().add(b);
        }

        VBox root = new VBox(10, pvJ1, pvJ2, combatMsg, attaquesBoxJ1, attaquesBoxJ2);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jeu de Combat Pierre/Feuille/Ciseaux");
        primaryStage.show();
    }

    private void checkEtAppliquerRound(Personnage joueur1, Personnage joueur2,
            Label pvJ1, Label pvJ2, Label combatMsg,
            HBox boxJ1, HBox boxJ2) {

        if (choixJ1 != null && choixJ2 != null) {
            Combat combat = new Combat(joueur1, joueur2, choixJ1, choixJ2);
            int vainqueurRound = combat.appliquerResultatRound();

            switch (vainqueurRound) {
                case 0 -> combatMsg.setText("Égalité !");
                case 1 -> combatMsg.setText(joueur1.getNom() + " gagne le round !");
                case 2 -> combatMsg.setText(joueur2.getNom() + " gagne le round !");
            }

            pvJ1.setText(joueur1.getNom() + " PV : " + joueur1.getPointsDeVie());
            pvJ2.setText(joueur2.getNom() + " PV : " + joueur2.getPointsDeVie());

            if (!joueur1.estVivant()) {
                combatMsg.setText("Game Over ! Vainqueur : " + joueur2.getNom());
                disableButtons(boxJ1, boxJ2);
            } else if (!joueur2.estVivant()) {
                combatMsg.setText("Game Over ! Vainqueur : " + joueur1.getNom());
                disableButtons(boxJ1, boxJ2);
            }

            choixJ1 = null;
            choixJ2 = null;
        }
    }

    private void disableButtons(HBox boxJ1, HBox boxJ2) {
        boxJ1.getChildren().forEach(node -> node.setDisable(true));
        boxJ2.getChildren().forEach(node -> node.setDisable(true));
    }
}
