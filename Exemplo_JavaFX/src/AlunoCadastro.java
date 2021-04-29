import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlunoCadastro extends Application {

	@Override
	public void start(Stage palco) throws Exception {
		VBox layoutRaiz = new VBox(10);
		layoutRaiz.setPadding(new Insets(10,10,10,10));
		
		BorderPane layoutNome = new BorderPane();
		Label labelNome = new Label("Nome: ");
		TextField textNome = new TextField();
		layoutNome.setLeft(labelNome);
		layoutNome.setRight(textNome);
		
		BorderPane layoutMatricula = new BorderPane();
		Label labelMatricula = new Label("Matricula: ");
		TextField textMatricula = new TextField();
		layoutMatricula.setLeft(labelMatricula);
		layoutMatricula.setRight(textMatricula);
		
		BorderPane layoutDataDeNascimento = new BorderPane();
		Label labelDataDeNascimento = new Label("Data de Nascimento: ");
		TextField textDataDeNascimento = new TextField();
		layoutDataDeNascimento.setLeft(labelDataDeNascimento);
		layoutDataDeNascimento.setRight(textDataDeNascimento);
		
		HBox layoutBotoes = new HBox(20);
		Button buttonSalvar = new Button("Salvar");
		Button buttonCancelar = new Button("Cancelar");
		
		buttonSalvar.setPrefWidth(100);
		buttonCancelar.setPrefWidth(100);
		
		layoutBotoes.setAlignment(Pos.CENTER);
		
		layoutBotoes.setPadding(new Insets(30,0,0,0));
		
		layoutBotoes.getChildren().addAll(buttonSalvar, buttonCancelar);
		
		layoutRaiz.getChildren().addAll(layoutNome, layoutMatricula, layoutDataDeNascimento, layoutBotoes);

		Scene cena = new Scene(layoutRaiz, 350, 200);
		palco.setScene(cena);
		
		palco.setTitle("Cadastro de Aluno");
		palco.show();
	}

	public static void main(String[] args) {
		launch();

	}

}
