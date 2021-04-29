package com.dell.lead;

import com.dell.lead.Quarto;
import com.dell.lead.Hospede;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HotelCadastro<dadosHospede> extends Application {

	/**
	 * M�todo que cont�m os elementos que consta no GUI do JavaFX. Esse m�todo permite a cria��o do layout de como os elementos v�o estar
	 * dispostos no GUI do cadastro do h�spede e quais elementos far�o parte dessa GUI.
	 * 
	 */

	@Override
	public void start(Stage palco) throws Exception {
		//Layout VBox que cria a estrutura e disposi��o (um abaixo do outro) dos elementos no GUI do cadastro do h�spede
		VBox layoutCadHotel = new VBox();
		layoutCadHotel.setPrefSize(500, 400);
		layoutCadHotel.setSpacing(10);
		layoutCadHotel.setPadding(new Insets(10));

		//Layout VBox para cria��o da descri��o do elemento e campo de inser��o via texto do nome do h�spede
		VBox layoutNome = new VBox();
		layoutNome.setSpacing(10);
		Label labelNome = new Label("Nome: ");
		TextField textNome = new TextField();
		layoutNome.getChildren().addAll(labelNome, textNome);

		//Layout VBox para cria��o da descri��o do elemento e campo de inser��o via texto do endere�o do h�spede
		VBox layoutEndereco = new VBox();
		layoutEndereco.setSpacing(10);
		Label labelEndereco = new Label("Endereco: ");
		TextField textEndereco = new TextField();
		layoutEndereco.getChildren().addAll(labelEndereco, textEndereco);

		//Layout VBox para cria��o da descri��o do elemento e campo de inser��o via texto do CPF do h�spede
		VBox layoutCPF = new VBox();
		layoutCPF.setSpacing(10);
		Label labelCPF = new Label("CPF: ");
		TextField textCPF = new TextField();
		layoutCPF.getChildren().addAll(labelCPF, textCPF);

		//Layout VBox para cria��o da descri��o do elemento e campo de inser��o via texto do RG do h�spede
		VBox layoutRG = new VBox();
		layoutRG.setSpacing(10);
		Label labelRG = new Label("RG: ");
		TextField textRG = new TextField();
		layoutRG.getChildren().addAll(labelRG, textRG);

		//Layout VBox para cria��o da descri��o do elemento e campo de inser��o via texto da idade do h�spede
		VBox layoutIdade = new VBox();
		layoutIdade.setSpacing(10);
		Label labelIdade = new Label("Idade: ");
		TextField textIdade = new TextField();
		layoutIdade.getChildren().addAll(labelIdade, textIdade);

		//Layout VBox para cria��o da descri��o do elemento e campo de escolha via bot�o do sexo do h�spede
		VBox layoutSexo = new VBox();
		layoutSexo.setSpacing(10);
		Label labelSexo = new Label("Sexo: ");
		HBox layoutBotoesSexo = new HBox();
		layoutBotoesSexo.setSpacing(25);
		layoutBotoesSexo.setAlignment(Pos.CENTER_LEFT);
		RadioButton masculino = new RadioButton("M");
		RadioButton feminino = new RadioButton("F");
		layoutBotoesSexo.getChildren().addAll(masculino, feminino);
		layoutSexo.getChildren().addAll(labelSexo, layoutBotoesSexo);

		//Layout VBox para cria��o da descri��o do elemento e campo de lista suspensa dos quartos existentes no hotel e que ser� definido ao h�spede
		VBox layoutQuartos = new VBox();
		layoutQuartos.setSpacing(10);
		Label labelQuartos = new Label("Quartos: ");
		ComboBox<Integer> nQuartos = new ComboBox<Integer>();
		for (int i = 1; i <= 100; i++) {
			nQuartos.getItems().addAll(i);
		}
		layoutQuartos.getChildren().addAll(labelQuartos, nQuartos);

		//Layout VBox para cria��o do campo de sele��o (tipo checkbox) do status da hospedagem do h�spede
		VBox layoutSituacao = new VBox();
		layoutSituacao.setSpacing(10);
		HBox layoutChkSituacao = new HBox();
		layoutChkSituacao.setSpacing(25);
		layoutChkSituacao.setAlignment(Pos.CENTER_LEFT);
		CheckBox checkIn = new CheckBox("Check in");
		CheckBox checkOut = new CheckBox("Check out");
		layoutChkSituacao.getChildren().addAll(checkIn, checkOut);
		layoutSituacao.getChildren().addAll(layoutChkSituacao);

		//Layout VBox para cria��o dos bot�es "Salvar" - dados do hospede, "Buscar" - as informa��es do hospede + o n� no quarto, "Cancelar" - cancelar a solicita��o de salvar ou buscar
		HBox layoutBotoes = new HBox(20);
		Button buttonSalvar = new Button("Salvar");
		Button buttonBuscar = new Button("Buscar");
		Button buttonRemover = new Button("Remover");
		buttonSalvar.setPrefWidth(100);
		buttonBuscar.setPrefWidth(100);
		buttonRemover.setPrefWidth(100);
		layoutBotoes.setAlignment(Pos.CENTER_LEFT);
		layoutBotoes.getChildren().addAll(buttonSalvar, buttonBuscar, buttonRemover);

		//Cria��o do HashMap, tendo um tipo "String" como chave e um tipo "ARRAYLIST" como value
		HashMap<String, ArrayList<String>> mapaHospede = new HashMap<>();

		//Evento que ser� acionado com o bot�o Salvar for pressionado
		EventHandler<ActionEvent> eventoSalvar = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent evento) {
				/* Ap�s o clique do bot�o Salvar, � acionado o m�todo verificaName que checar� se o nome
				 * inserido � v�lido ou n�o, de acordo com parametros definidos na fun��o.
			 	 * Se o nome foi inv�lido � gerado uma mensagem de erro.
			 	 * Se o nome foi v�lido, os dados s�o armazenados corretamente 
			 	 */
				if(verificaNome(textNome.getText())==true) {
					/* Verifica se o campo CheckIn est� selecionado. Se estiver, os dados podem ser armazenados.
					 * Sen�o, � gerado uma mensagem de alerta informando para o usu�rio clicar no campo CheckIn
					 */
					if (checkIn.isSelected()) {
						salvar(mapaHospede, textNome, textEndereco, textCPF, textRG, textIdade, nQuartos, masculino, feminino);
						limpaCampos(textNome, textEndereco, textCPF, textRG, textIdade, nQuartos, masculino, feminino, checkIn, checkOut);
					}else {
						UIManager.put("swing.boldMetal", Boolean.FALSE);
						String mensagem = "<html>A op��o <b>Check in</b> precisa estar marcada";
						JOptionPane.showMessageDialog(null, mensagem, "Alerta", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "O nome do h�spede est� num formato incorreto.\nSomente � permitido letras, cedilha (�), acento agundo (�) e til (~)", "Alerta", JOptionPane.ERROR_MESSAGE);
				}
			}
		};

		//Evento que ser� acionado com o bot�o Buscar for pressionado
		EventHandler<ActionEvent> eventoBuscar = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent evento) {
				limpaCampos(textNome, textEndereco, textCPF, textRG, textIdade, nQuartos, masculino, feminino, checkIn, checkOut);
				buscar(mapaHospede, textNome, textEndereco, textCPF, textRG, textIdade, nQuartos, masculino, feminino);
			}
		};

		//Evento que ser� acionado com o bot�o Remover for pressionado
		EventHandler<ActionEvent> eventoRemover = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent evento) {
				/* Verifica se pelo menos o campo CPF n�o est� vazio - devido ser o campo usado como chave dentro do HashMap
				 * Se o campo CPF estiver vazio, � informado que primeiro deve ser buscado os dados do h�spede para depois remover
				 * Se o campo estiver preenchido, por�m sem informa��es do h�spede, � gerado uma mensagem de erro
				 */
				if ((textCPF.getText().trim().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Dados do cliente precisam ser buscados para poderem ser removido", "Alerta", JOptionPane.ERROR_MESSAGE);
				}else {
					/* Verifica se o campo CheckOut est� selecionado. Se estiver, os dados podem ser armazenados.
					 * Sen�o, � gerado uma mensagem de alerta informando para o usu�rio clicar no campo CheckOut
					 */
					if (checkOut.isSelected()) {
						remover(mapaHospede, textCPF);
						limpaCampos(textNome, textEndereco, textCPF, textRG, textIdade, nQuartos, masculino, feminino, checkIn, checkOut);
					}else {
						UIManager.put("swing.boldMetal", Boolean.FALSE);
						String mensagem = "<html>A op��o <b>Check out</b> precisa estar marcada";
						JOptionPane.showMessageDialog(null, mensagem, "Alerta", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		};

		//A��es dos bot�es
		buttonSalvar.setOnAction(eventoSalvar);
		buttonBuscar.setOnAction(eventoBuscar);
		buttonRemover.setOnAction(eventoRemover);

		//Adi��o de todos os layout individuais no Layout da GUI do cadastro do h�spede
		layoutCadHotel.getChildren().addAll(layoutNome, layoutEndereco, layoutCPF, layoutRG, layoutIdade, layoutSexo, layoutQuartos, layoutSituacao, layoutBotoes);

		//Cria��o da cena da GUI do cadastro do h�spede
		Scene cena = new Scene(layoutCadHotel);
		palco.setScene(cena);

		//T�tulo da GUI do cadastro do h�spede
		palco.setTitle("Cadastro de Hospede");
		//Execu��o da Gui do cadastro do h�spede
		palco.show();

	}

	/**
	 * M�todo Principal que executar� o JavaFX
	 * 
	 */
	public static void main(String[] args) {
		launch();

	}


	/**
	 * M�todo que salvar� as informa��es do h�spede no HashMap
	 * @param mapaHospede Recebe o HashMap para armazenar os dados do h�spede
	 * @param nomeH Recebe o TextField com o nome do h�spede
	 * @param enderecoH Recebe o TextField com o endere�o do h�spede
	 * @param cpfH Recebe o TextField com o CPF do h�spede
	 * @param rgH Recebe o TextField com o RG do h�spede
	 * @param idadeH Recebe o TextField com a idade do h�spede
	 * @param nQuarto Recebe o ComboBox com a sele��o do quarto do h�spede
	 * @param sexoMH Recebe o RadioButton com a sele��o do sexo masculino do h�spede
	 * @param sexoFH Recebe o RadioButton com a sele��o do sexo feminino do h�spede
	 */
	public static void salvar(HashMap<String, ArrayList<String>> mapaHospede, TextField nomeH, TextField enderecoH, TextField cpfH, TextField rgH, TextField idadeH, ComboBox<Integer> nQuarto, RadioButton sexoMH, RadioButton sexoFH) {

		//Cria as inst�ncias das classes Hospede e Quarto
		Hospede hospede = new Hospede();
		Quarto quarto = new Quarto(0, hospede);
		//Cria as vari�veis cpfHospede, rgHospede e idadeHospede para serem convertidas nos respectivos tipos que foram definidas na classe H�spede
		Long cpfHospede = null;
		Long rgHospede;
		int idadeHospede;

		try {
			//Convers�o dos valores
			cpfHospede = Long.valueOf(cpfH.getText());
			rgHospede = Long.valueOf(rgH.getText());
			idadeHospede = Integer.valueOf(idadeH.getText());

			//Seta os valores para as classes Hospede e Quarto
			hospede.setCPF(cpfHospede);
			hospede.setRG(rgHospede);
			hospede.setNome(nomeH.getText());
			hospede.setIdade(idadeHospede);
			hospede.setEndereco(enderecoH.getText());
			quarto.setNumero(nQuarto.getValue());

		//Bloco catch que verifica se os valores convertidos foram somentes n�meros
		}catch(NumberFormatException nfe){
			System.err.println("Erro ao informar os dados. Informe somente n�meros. Erro: "+nfe.getMessage());
		}

		//Cria��o do ARRAYLIST com os dados do h�spede
		ArrayList <String> dadosHospede = new ArrayList<String>();
		//Adi��o das informa��es do hospede no ARRAYLIST
		dadosHospede.add(cpfH.getText());
		dadosHospede.add(rgH.getText());
		dadosHospede.add(nomeH.getText());
		dadosHospede.add(idadeH.getText());
		dadosHospede.add(enderecoH.getText());
		dadosHospede.add(String.valueOf(nQuarto.getValue()));
		if(sexoMH.isSelected()) {
			dadosHospede.add(sexoMH.getText());
		} else if(sexoFH.isSelected()) {
			dadosHospede.add(sexoFH.getText());
		}

		//Adiciona a chave - CPF - e o value - ARRAYLIST - no HashMap 
		mapaHospede.put(cpfH.getText(), dadosHospede);

		//Informa mensagem que o h�spede foi cadastrado com sucesso
		JOptionPane.showMessageDialog(null,"Hospede cadastrado com sucesso!!");

	}

	/**
	 * M�todo que busca as informa��es do cliente inserido no HashMap e coloca os dados do cliente nos respectivos campos
	 * da janela.
	 * @param nomeH Recebe o TextField com o nome do h�spede
	 * @param enderecoH Recebe o TextField com o endere�o do h�spede
	 * @param cpfH Recebe o TextField com o CPF do h�spede
	 * @param rgH Recebe o TextField com o RG do h�spede
	 * @param idadeH Recebe o TextField com a idade do h�spede
	 * @param nQuarto Recebe o ComboBox com a sele��o do quarto do h�spede
	 * @param sexoMH Recebe o RadioButton com a sele��o do sexo masculino do h�spede
	 * @param sexoFH Recebe o RadioButton com a sele��o do sexo feminino do h�spede
	 */
	public static void buscar(HashMap<String, ArrayList<String>> mapaHospede, TextField nomeH, TextField enderecoH, TextField cpfH, TextField rgH, TextField idadeH, ComboBox<Integer> nQuarto, RadioButton sexoMH, RadioButton sexoFH) {

		//Solicita o CPF para buscar
		String cpfHStrBuscar = JOptionPane.showInputDialog(null, "Informe o CPF do hospede para buscar: ");

		/* Cria��o da vari�vel nomeClienteBuscado que servir� como par�metro para verificar se o CPF informado encontra-se na base
		 * A vari�vel armazenar� a informa��o do nome do h�spede
		 */
		String nomeClienteBuscado = null;

		//Seta as chaves e armazena dentro de uma estrutura SET e cria um ITERATOR para percorrer esse ARRAYLIST dentro do HashMap
		Set<String> setofKeys = mapaHospede.keySet();
		Iterator<String> itr = setofKeys.iterator();

		while(itr.hasNext()) {
			String chave = itr.next();
			ArrayList<String> value = mapaHospede.get(chave);
			//Percorre todos os valores do ARRAYLIST
			for (int i = 0; i < value.size();i++) {
				//Condi��o que verificar� se o valor dentro do ARRAYLIST � igual ao CPF informado
				if (value.get(i).equals(cpfHStrBuscar)) {
					//Seta os campos com os valores armazenados para edi��o e possivel modifica��o dos dados
					cpfH.setText(value.get(0));
					cpfH.setEditable(false); //O campo CPF fica inalter�vel devido ser um campo usado como chave para o HashMap e consequentemente encontrar os dados do h�spede
					rgH.setText(value.get(1));
					nomeH.setText(value.get(2));
					idadeH.setText(value.get(3));
					enderecoH.setText(value.get(4));
					nQuarto.setValue(Integer.valueOf(value.get(5)));
					//Condi��es que verifica��o qual dos campos: M ou F estavam marcados na hora do armazenamento e retorna os valores
					if(value.get(6).equals("M")) {
						sexoMH.setSelected(true);
					}else if (value.get(6).equals("F")) {
						sexoFH.setSelected(true);
					}
					//Armazena a informa��o do nome do cliente na vari�vel nomeClienteBuscado
					nomeClienteBuscado = value.get(2);
				}
			}
		}

		/* Se a vari�vel nomeClienteBuscado continua com valor "null", ou seja, n�o for encontrado nenhum cliente com o CPF informado, � mostrado uma
		 * mensagem de erro informado que nenhum cliente foi encontrado com CPF informado
		 */
		if (nomeClienteBuscado == null) {
			JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado com o CPF "+cpfHStrBuscar+" informado", "Alerta", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * M�todo que recebe o HashMap e o cpf informado para remo��o dos dados do h�spede
	 * @param mapaHospede HashMap com os dados do h�spede
	 * @param cpfH CPF informado para buscar as informa��es do h�spede e posterior remo��o
	 */
	public static void remover(HashMap<String, ArrayList<String>> mapaHospede, TextField cpfH) {

		/* Cria��o da vari�vel nomeClienteBuscado que servir� como par�metro para verificar se o CPF informado encontra-se na base
		 * A vari�vel armazenar� a informa��o do nome do h�spede
		 */
		 
		String nomeClienteBuscado = null;

		//O la�o for varre o HashMap em busca da chave e armazena na vari�vel "chave"
		for (Map.Entry<String, ArrayList<String>> chave : mapaHospede.entrySet()) {
			//Verifica se a chave � igual ao CPF informado para busca
			if(chave.getKey().equals(cpfH.getText())) {
				//Se a condi��o do IF acima for verdadeira, cria-se um ARRAYLIST e armazena-se dentro dele os dados do h�spede presente no HashMap
				ArrayList<String> value = mapaHospede.get(cpfH.getText());
				//Verifica se o primeiro valor armazenado no ARRAYLIST do HashMap (onde fica armazenado o cpf do h�spede) � igual ao CPF informado
				if (value.get(0).equals(cpfH.getText())) {
					//Informa ao usu�rio que foi encontrado o cliente com o CPF informado e que os dados dele ser�o removidos do HashMap
					JOptionPane.showMessageDialog(null,"O cliente "+value.get(2)+ " portador do CPF "+value.get(0)+" foi removido da base");
					//Armazena a informa��o do nome do cliente na vari�vel nomeClienteBuscado
					nomeClienteBuscado = value.get(2);
				}
			}

		}

		//Remove os dados do cliente 
		mapaHospede.remove(cpfH.getText());

		/* Se a vari�vel nomeClienteBuscado continua com valor "null", ou seja, n�o for encontrado nenhum cliente com o CPF informado, � mostrado uma
		 * mensagem de erro informado que nenhum cliente foi encontrado com CPF informado
		 */
		
		if (nomeClienteBuscado == null) {
			JOptionPane.showMessageDialog(null, "Cliente ainda n�o se encontra cadastrado!", "Alerta", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * M�todo que recebe os campos TextField, ComboBox, RadioButton e CheckBox e limpa os valores que foram preenchidos pelo usu�rio
	 * @param nomeH Recebe o TextField com o nome do h�spede
	 * @param enderecoH Recebe o TextField com o endere�o do h�spede
	 * @param cpfH Recebe o TextField com o CPF do h�spede
	 * @param rgH Recebe o TextField com o RG do h�spede
	 * @param idadeH Recebe o TextField com a idade do h�spede
	 * @param quartoH Recebe o ComboBox com a sele��o do quarto do h�spede
	 * @param sexoMH Recebe o RadioButton com a sele��o do sexo masculino do h�spede
	 * @param sexoFH Recebe o RadioButton com a sele��o do sexo feminino do h�spede
	 * @param checkInH Recebe o CheckBox com a sele��o do checkin do h�spede
	 * @param checkOutH Recebe o CheckBox com a sele��o do checkout do h�spede
	 */
	public static void limpaCampos(TextField nomeH, TextField enderecoH, TextField cpfH, TextField rgH, TextField idadeH, ComboBox<Integer> quartoH, RadioButton sexoMH, RadioButton sexoFH, CheckBox checkInH, CheckBox checkOutH) {
		nomeH.setText("");
		enderecoH.setText("");
		cpfH.setText("");
		rgH.setText("");
		idadeH.setText("");
		quartoH.setValue(null);
		sexoMH.setSelected(false);
		sexoFH.setSelected(false);
		checkInH.setSelected(false);
		checkOutH.setSelected(false);
	}
	
	/**
	 * M�todo que verifica se o nome inserido correspende aos padr�es definidos: Somente letras (maiusculas e/ou minusculas),
	 * vogais com acentos agudos (�) e/ou tis (~), e tamb�m o cedilha (maiusculo ou minusculo)
	 * @since 22/12/2019
	 * @param nome Recebe como par�metro o nome do h�spede
	 * @return Retorna "true", caso o nome inserido do h�spede est� dentro dos padr�es estabelecidas; retorna "false", 
	 * caso o nome inserido esteja fora dos padr�es estabelecidos
	 */
	public static boolean verificaNome(String nome) {
		//Inicializa a vari�vel "valido" como true
		boolean valido = true;

		/* Usado o m�todo replaceAll para substitui todos os caracteres passados no primeiro par�metro pelos caracteres 
		 * passados no segundo par�metro, ou seja, no primeiro par�metro do replaceAll() estamos dizendo que tudo que for espa�o deve 
		 * ser substitu�do por nada (na verdade, s� est� retirando os espa�os do nome passado para o m�todo)
		 */
		nome = nome.replaceAll(" ", "");

		/* Condi��o que testar� o nome passado para o m�todo: Se o nome n�o contiver letras maiusculase/ou minusculas, 
		 * vogais com acentos agudos (�) e/ou tis (~), e tamb�m o cedilha (maiusculo ou minusculo), ent�o o nome est� correto, ou seja, 
		 * exclui caracteres especiais, v�rgula, ponto, barra e n�meros como letras v�lidas para compor o nome do h�spede (devido 
		 * se tratar de uma String e aceitar esses tipos)
		 */
		if(!nome.matches("[a-zA-Z\\�-��-�\\�-��-�\\��]*")){
			//Retorna o valor "false" se nome estiver fora das par�metros corretos
			valido = false;
		}

		//Retorna o valor "true" se nome estiver dentro das par�metros corretos
		return valido;
	}
}
