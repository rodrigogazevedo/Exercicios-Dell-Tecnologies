package com.dell.lead;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ExemploGridPane extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage palco) throws Exception {
        GridPane gridPane = new GridPane();

        gridPane.add(new Label("0 X 0"), 0, 0);
        gridPane.add(new Label("0 X 1"), 0, 1);
        gridPane.add(new Label("0 X 2"), 0, 2);
        gridPane.add(new Label("1 X 0"), 1, 0);
        gridPane.add(new Label("1 X 1"), 1, 1);
        gridPane.add(new Label("1 X 2"), 1, 2);
        gridPane.add(new Label("2 X 0"), 2, 0);
        gridPane.add(new Label("2 X 1"), 2, 1);
        gridPane.add(new Label("2 X 2"), 2, 2);

        gridPane.setVgap(20);
        gridPane.setHgap(20);

        gridPane.setAlignment(Pos.CENTER);

        Scene cena = new Scene(gridPane, 250, 150);
        palco.setTitle("Exemplo GridPane");
        palco.setScene(cena);
        palco.show();
    }
}