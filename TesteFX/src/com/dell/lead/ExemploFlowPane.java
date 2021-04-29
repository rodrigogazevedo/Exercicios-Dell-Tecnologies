package com.dell.lead;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ExemploFlowPane extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage palco) throws Exception {
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);

        flowPane.getChildren().add(new Label("Elemento 1"));
        flowPane.getChildren().add(new Label("Elemento 2"));
        flowPane.getChildren().add(new Label("Elemento 3"));
        flowPane.getChildren().add(new Label("Elemento 4"));
        flowPane.getChildren().add(new Label("Elemento 5"));
        flowPane.getChildren().add(new Label("Elemento 6"));
        flowPane.getChildren().add(new Label("Elemento 7"));
        flowPane.getChildren().add(new Label("Elemento 8"));

        Scene cena = new Scene(flowPane, 250, 150);
        palco.setTitle("Exemplo StackPane");
        palco.setScene(cena);
       palco.show();
    }
}