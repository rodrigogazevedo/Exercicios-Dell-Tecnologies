package com.dell.lead;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExemploJavaFx extends Application{
	public void start(Stage palco) throws Exception{
		VBox layoutTela = new VBox();
		HBox layoutLogin = new HBox();
		Label rotuloLogin = new Label("Login:");
		TextField campoLogin = new TextField();
		layoutLogin.getChildren().addAll(rotuloLogin, campoLogin);
		HBox layoutSenha = new HBox();
		Label rotuloSenha = new Label("Senha:");
		TextField campoSenha = new TextField();
		layoutSenha.getChildren().addAll(rotuloSenha, campoSenha);
		Button botaoEntrar = new Button("Entrar");
		layoutTela.getChildren().addAll(layoutLogin, layoutSenha, botaoEntrar);
		Scene cena = new Scene(layoutTela);
		palco.setScene(cena);
		palco.show();
	}
	public static void main(String[] args) {
		launch();
	}
}
