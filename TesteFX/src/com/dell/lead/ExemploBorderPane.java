package com.dell.lead;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ExemploBorderPane extends Application {

   public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage palco) throws Exception {
        BorderPane borderPane = new BorderPane();
        Label norte, sul, leste, oeste, centro;

        norte = new Label("Norte");
        sul = new Label("Sul");
        leste = new Label("Leste");
        oeste = new Label("Oeste");
        centro = new Label("Centro");

        borderPane.setTop(norte);
        borderPane.setBottom(sul);
        borderPane.setRight(leste);
        borderPane.setLeft(oeste);
        borderPane.setCenter(centro);

        BorderPane.setAlignment(norte, Pos.CENTER);
        BorderPane.setAlignment(sul, Pos.CENTER);
        BorderPane.setAlignment(leste, Pos.CENTER);
        BorderPane.setAlignment(oeste, Pos.CENTER);

        Scene cena = new Scene(borderPane, 250, 150);
        palco.setTitle("Exemplo BorderPane");
        palco.setScene(cena);
        palco.show();
    }
}
