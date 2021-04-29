package com.dell.lead;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ExemploVBox extends Application{
	public static void main(String[] args){
		launch();
	}
	
	@Override
	public void start(Stage palco) throws Exception{
		VBox caixaVertical = new VBox();
		caixaVertical.setSpacing(5);
		caixaVertical.setAlignment(Pos.CENTER);
				
		caixaVertical.setTranslateX(10);
		caixaVertical.setTranslateY(5);
		
		Rectangle retanguloRosa = new Rectangle(150,20);
		Rectangle retanguloLimao = new Rectangle(150,20);
		Rectangle retanguloChocolate = new Rectangle(150,20);
		
		retanguloRosa.setFill(Color.PINK);
		retanguloLimao.setFill(Color.CHARTREUSE);
		retanguloChocolate.setFill(Color.CHOCOLATE);
		
		caixaVertical.getChildren().addAll(retanguloRosa, retanguloLimao, retanguloChocolate);
		
		Scene cena = new Scene(caixaVertical, 250,150);
		palco.setTitle("ExemploVBox");
		palco.setScene(cena);
		palco.show();
				
	}
}