package com.dell.lead;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ExemploHBox extends Application{
	public static void main(String[] args){
		launch();
	}
	
	@Override
	public void start(Stage palco) throws Exception{
		HBox caixaHorizontal = new HBox();
		caixaHorizontal.setSpacing(5);
		caixaHorizontal.setAlignment(Pos.CENTER);
		
		caixaHorizontal.setTranslateX(10);
		caixaHorizontal.setTranslateY(0);
		
		Rectangle retanguloRosa = new Rectangle(60,40);
		Rectangle retanguloLimao = new Rectangle(60,40);
		Rectangle retanguloChocolate = new Rectangle(60,40);
		
		retanguloRosa.setFill(Color.PINK);
		retanguloLimao.setFill(Color.CHARTREUSE);
		retanguloChocolate.setFill(Color.CHOCOLATE);
		
		caixaHorizontal.getChildren().addAll(retanguloRosa, retanguloLimao, retanguloChocolate);
		
		Scene cena = new Scene(caixaHorizontal, 250,150);
		palco.setTitle("ExemploHBox");
		palco.setScene(cena);
		palco.show();
	}
}