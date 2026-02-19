package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

        HBox boutonsBox = new HBox();
        boutonsBox.setSpacing(20);
        boutonsBox.setAlignment(Pos.CENTER);

        Button btnAttaque = new Button("Lancer l'attaque");
        Button btnGameOver = new Button("Game Over");
        btnGameOver.setDisable(true);

        boutonsBox.getChildren().addAll(btnAttaque, btnGameOver);

        root.getChildren().add(boutonsBox);

        TextArea combatLog = new TextArea();
        combatLog.setPrefHeight(150);
        combatLog.setEditable(false);
        combatLog.setWrapText(true);

        root.getChildren().add(combatLog);

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
