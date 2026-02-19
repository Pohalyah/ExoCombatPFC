package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFX extends Application {

    @Override
    public void start(Stage stage) {

        Personnage joueurLeft = new Guerrier("Guerrier", 100);
        Personnage joueurRight = new Mage("Mage", 85);

        stage.setTitle("Combat sans pitié");

        VBox root = new VBox();
        root.setSpacing(20);
        root.setPadding(new Insets(15));

        HBox combattantsBox = new HBox();
        combattantsBox.setSpacing(50);
        combattantsBox.setAlignment(Pos.CENTER);

        VBox joueurLeftBox = new VBox();
        joueurLeftBox.setSpacing(15);
        joueurLeftBox.setAlignment(Pos.CENTER);

        Label joueurLeftNom = new Label("Guerrier");
        ImageView joueurLeftImage = new ImageView(new Image(getClass().getResourceAsStream("/images/guerrier.png")));
        joueurLeftImage.setFitWidth(100);
        joueurLeftImage.setFitHeight(100);
        joueurLeftImage.setPreserveRatio(true);
        Label joueurLeftPV = new Label("PV: " + joueurLeft.getPointsDeVie());

        joueurLeftBox.getChildren().addAll(joueurLeftNom, joueurLeftImage, joueurLeftPV);

        VBox joueurRightBox = new VBox();
        joueurRightBox.setSpacing(15);
        joueurRightBox.setAlignment(Pos.CENTER);

        Label joueurRightNom = new Label("Mage");
        ImageView joueurRightImage = new ImageView(new Image(getClass().getResourceAsStream("/images/mage.png")));
        joueurRightImage.setFitWidth(100);
        joueurRightImage.setFitHeight(100);
        joueurRightImage.setPreserveRatio(true);
        Label joueurRightPV = new Label("PV: " + joueurRight.getPointsDeVie());

        joueurRightBox.getChildren().addAll(joueurRightNom, joueurRightImage, joueurRightPV);

        combattantsBox.getChildren().addAll(joueurLeftBox, joueurRightBox);
        root.getChildren().add(combattantsBox);

        TextArea combatLog = new TextArea();
        combatLog.setPrefHeight(150);
        combatLog.setEditable(false);
        combatLog.setWrapText(true);

        HBox boutonsBox = new HBox();
        boutonsBox.setSpacing(20);
        boutonsBox.setAlignment(Pos.CENTER);

        Button btnAttaque = new Button("Lancer l'attaque");
        Button btnGameOver = new Button("Game Over");
        btnGameOver.setDisable(true);

        btnAttaque.setOnAction(e -> {

            int id1 = demanderAttaque("Joueur 1 - Choisis ton attaque");
            if (id1 == -1)
                return;

            int id2 = demanderAttaque("Joueur 2 - Choisis ton attaque");
            if (id2 == -1)
                return;

            Attaque attaque1 = creerAttaque(id1, joueurLeft);
            Attaque attaque2 = creerAttaque(id2, joueurRight);

            Combat combat = new Combat(joueurLeft, joueurRight, attaque1, attaque2);

            int resultat = combat.appliquerResultatRound();

            if (resultat == 0) {
                combatLog.appendText("Égalité !\n");
            } else if (resultat == 1) {
                combatLog.appendText("Joueur 1 gagne le round avec " + attaque1.getNom() + "\n");
            } else {
                combatLog.appendText("Joueur 2 gagne le round avec " + attaque2.getNom() + "\n");
            }

            joueurLeftPV.setText("PV: " + joueurLeft.getPointsDeVie());
            joueurRightPV.setText("PV: " + joueurRight.getPointsDeVie());

            Personnage vainqueur = combat.determinerVainqueur();
            if (vainqueur != null) {
                combatLog.appendText("Le vainqueur est : " + vainqueur.getNom() + "\n");
                btnAttaque.setDisable(true);
                btnGameOver.setDisable(false);
            }
        });

        btnGameOver.setOnAction(e -> {

            joueurLeft.setPointsDeVie(100);
            joueurRight.setPointsDeVie(85);

            joueurLeftPV.setText("PV: " + joueurLeft.getPointsDeVie());
            joueurRightPV.setText("PV: " + joueurRight.getPointsDeVie());

            combatLog.clear();

            btnAttaque.setDisable(false);
            btnGameOver.setDisable(true);
        });

        boutonsBox.getChildren().addAll(btnAttaque, btnGameOver);
        root.getChildren().addAll(boutonsBox, combatLog);

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    private Attaque creerAttaque(int id, Personnage attaquant) {

        String[] attaques = { "Poing de feu", "Laser glace", "Ultralaser" };

        String nom = attaques[id - 1];

        int puissance;

        switch (id) {
            case 1:
                puissance = 8;
                break;
            case 2:
                puissance = 15;
                break;
            case 3:
                puissance = 25;
                break;
            default:
                puissance = 0;
        }

        return new Attaque(nom, id, puissance, attaquant);
    }

    private int demanderAttaque(String titre) {
        final int[] resultat = { -1, 0 };

        Stage dialog = new Stage();
        dialog.setTitle("Choix attaque");

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(15));
        vbox.setAlignment(Pos.CENTER);

        Label label = new Label(titre + "\nEntrez 1, 2 ou 3 :");
        TextField input = new TextField();
        input.setPromptText("1, 2 ou 3");
        input.setMaxWidth(100);

        HBox buttonsBox = new HBox();
        buttonsBox.setSpacing(10);
        buttonsBox.setAlignment(Pos.CENTER);

        Button okButton = new Button("OK");
        Button cancelButton = new Button("Annuler");

        buttonsBox.getChildren().addAll(okButton, cancelButton);
        vbox.getChildren().addAll(label, input, buttonsBox);

        Scene scene = new Scene(vbox);
        dialog.setScene(scene);

        okButton.setOnAction(e -> {
            try {
                int valeur = Integer.parseInt(input.getText());
                if (valeur >= 1 && valeur <= 3) {
                    resultat[0] = valeur;
                    dialog.close();
                }
            } catch (NumberFormatException ex) {

            }
        });

        input.setOnAction(e -> okButton.fire());

        cancelButton.setOnAction(e -> {
            resultat[0] = -1;
            dialog.close();
        });

        dialog.setOnCloseRequest(e -> resultat[0] = -1);

        dialog.showAndWait();

        return resultat[0];
    }

    public static void main(String[] args) {
        launch(args);
    }
}
