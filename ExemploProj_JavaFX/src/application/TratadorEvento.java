package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TratadorEvento implements Initializable {   
	@FXML 
	private void btn_OnAction(ActionEvent event) {
		System.out.println("O botão foi pressionado.");
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}