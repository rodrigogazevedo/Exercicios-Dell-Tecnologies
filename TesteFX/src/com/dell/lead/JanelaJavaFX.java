package com.dell.lead;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class JanelaJavaFX extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.show();

	}

	public static void main(String[] args) {
		launch();

		Label rotulo = new Label("TEXTO TESTE");
		TextField campoDeTexto =  new TextField("Digite algo");
	}

}
