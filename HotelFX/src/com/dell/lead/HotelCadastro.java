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
	 * Método que contém os elementos que consta no GUI do JavaFX. Esse método permite a criação do layout de como os elementos vão estar
	 * dispostos no GUI do cadastro do hóspede e quais elementos farão parte dessa GUI.
	 * 
	 */

	@Override
	public void start(Stage palco) throws Exception {
		//Layout VBox que cria a estrutura e disposição (um abaixo do outro) dos elementos no GUI do cadastro do hóspede
		VBox layoutCadHotel = new VBox();
		layoutCadHotel.setPrefSize(500, 400);
		layoutCadHotel.setSpacing(10);
		layoutCadHotel.setPadding(new Insets(10));

		//Layout VBox para criação da descrição do elemento e campo de inserção via texto do nome do hóspede
		VBox layoutNome = new VBox();
		layoutNome.setSpacing(10);
		Label labelNome = new Label("Nome: ");
		TextField textNome = new TextField();
		layoutNome.getChildren().addAll(labelNome, textNome);

		//Layout VBox para criação da descrição do elemento e campo de inserção via texto do endereço do hóspede
		VBox layoutEndereco = new VBox();
		layoutEndereco.setSpacing(10);
		Label labelEndereco = new Label("Endereco: ");
		TextField textEndereco = new TextField();
		layoutEndereco.getChildren().addAll(labelEndereco, textEndereco);

		//Layout VBox para criação da descrição do elemento e campo de inserção via texto do CPF do hóspede
		VBox layoutCPF = new VBox();
		layoutCPF.setSpacing(10);
		Label labelCPF = new Label("CPF: ");
		TextField textCPF = new TextField();
		layoutCPF.getChildren().addAll(labelCPF, textCPF);

		//Layout VBox para criação da descrição do elemento e campo de inserção via texto do RG do hóspede
		VBox layoutRG = new VBox();
		layoutRG.setSpacing(10);
		Label labelRG = new Label("RG: ");
		TextField textRG = new TextField();
		layoutRG.getChildren().addAll(labelRG, textRG);

		//Layout VBox para criação da descrição do elemento e campo de inserção via texto da idade do hóspede
		VBox layoutIdade = new VBox();
		layoutIdade.setSpacing(10);
		Label labelIdade = new Label("Idade: ");
		TextField textIdade = new TextField();
		layoutIdade.getChildren().addAll(labelIdade, textIdade);

		//Layout VBox para criação da descrição do elemento e campo de escolha via botão do sexo do hóspede
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

		//Layout VBox para criação da descrição do elemento e campo de lista suspensa dos quartos existentes no hotel e que será definido ao hóspede
		VBox layoutQuartos = new VBox();
		layoutQuartos.setSpacing(10);
		Label labelQuartos = new Label("Quartos: ");
		ComboBox<Integer> nQuartos = new ComboBox<Integer>();
		for (int i = 1; i <= 100; i++) {
			nQuartos.getItems().addAll(i);
		}
		layoutQuartos.getChildren().addAll(labelQuartos, nQuartos);

		//Layout VBox para criação do campo de seleção (tipo checkbox) do status da hospedagem do hóspede
		VBox layoutSituacao = new VBox();
		layoutSituacao.setSpacing(10);
		HBox layoutChkSituacao = new HBox();
		layoutChkSituacao.setSpacing(25);
		layoutChkSituacao.setAlignment(Pos.CENTER_LEFT);
		CheckBox checkIn = new CheckBox("Check in");
		CheckBox checkOut = new CheckBox("Check out");
		layoutChkSituacao.getChildren().addAll(checkIn, checkOut);
		layoutSituacao.getChildren().addAll(layoutChkSituacao);

		//Layout VBox para criação dos botões "Salvar" - dados do hospede, "Buscar" - as informações do hospede + o nº no quarto, "Cancelar" - cancelar a solicitação de salvar ou buscar
		HBox layoutBotoes = new HBox(20);
		Button buttonSalvar = new Button("Salvar");
		Button buttonBuscar = new Button("Buscar");
		Button buttonRemover = new Button("Remover");
		buttonSalvar.setPrefWidth(100);
		buttonBuscar.setPrefWidth(100);
		buttonRemover.setPrefWidth(100);
		layoutBotoes.setAlignment(Pos.CENTER_LEFT);
		layoutBotoes.getChildren().addAll(buttonSalvar, buttonBuscar, buttonRemover);

		//Criação do HashMap, tendo um tipo "String" como chave e um tipo "ARRAYLIST" como value
		HashMap<String, ArrayList<String>> mapaHospede = new HashMap<>();

		//Evento que será acionado com o botão Salvar for pressionado
		EventHandler<ActionEvent> eventoSalvar = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent evento) {
				/* Após o clique do botão Salvar, é acionado o método verificaName que checará se o nome
				 * inserido é válido ou não, de acordo com parametros definidos na função.
			 	 * Se o nome foi inválido é gerado uma mensagem de erro.
			 	 * Se o nome foi válido, os dados são armazenados corretamente 
			 	 */
				if(verificaNome(textNome.getText())==true) {
					/* Verifica se o campo CheckIn está selecionado. Se estiver, os dados podem ser armazenados.
					 * Senão, é gerado uma mensagem de alerta informando para o usuário clicar no campo CheckIn
					 */
					if (checkIn.isSelected()) {
						salvar(mapaHospede, textNome, textEndereco, textCPF, textRG, textIdade, nQuartos, masculino, feminino);
						limpaCampos(textNome, textEndereco, textCPF, textRG, textIdade, nQuartos, masculino, feminino, checkIn, checkOut);
					}else {
						UIManager.put("swing.boldMetal", Boolean.FALSE);
						String mensagem = "<html>A opção <b>Check in</b> precisa estar marcada";
						JOptionPane.showMessageDialog(null, mensagem, "Alerta", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "O nome do hóspede está num formato incorreto.\nSomente é permitido letras, cedilha (ç), acento agundo (´) e til (~)", "Alerta", JOptionPane.ERROR_MESSAGE);
				}
			}
		};

		//Evento que será acionado com o botão Buscar for pressionado
		EventHandler<ActionEvent> eventoBuscar = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent evento) {
				limpaCampos(textNome, textEndereco, textCPF, textRG, textIdade, nQuartos, masculino, feminino, checkIn, checkOut);
				buscar(mapaHospede, textNome, textEndereco, textCPF, textRG, textIdade, nQuartos, masculino, feminino);
			}
		};

		//Evento que será acionado com o botão Remover for pressionado
		EventHandler<ActionEvent> eventoRemover = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent evento) {
				/* Verifica se pelo menos o campo CPF não está vazio - devido ser o campo usado como chave dentro do HashMap
				 * Se o campo CPF estiver vazio, é informado que primeiro deve ser buscado os dados do hóspede para depois remover
				 * Se o campo estiver preenchido, porém sem informações do hóspede, é gerado uma mensagem de erro
				 */
				if ((textCPF.getText().trim().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Dados do cliente precisam ser buscados para poderem ser removido", "Alerta", JOptionPane.ERROR_MESSAGE);
				}else {
					/* Verifica se o campo CheckOut está selecionado. Se estiver, os dados podem ser armazenados.
					 * Senão, é gerado uma mensagem de alerta informando para o usuário clicar no campo CheckOut
					 */
					if (checkOut.isSelected()) {
						remover(mapaHospede, textCPF);
						limpaCampos(textNome, textEndereco, textCPF, textRG, textIdade, nQuartos, masculino, feminino, checkIn, checkOut);
					}else {
						UIManager.put("swing.boldMetal", Boolean.FALSE);
						String mensagem = "<html>A opção <b>Check out</b> precisa estar marcada";
						JOptionPane.showMessageDialog(null, mensagem, "Alerta", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		};

		//Ações dos botões
		buttonSalvar.setOnAction(eventoSalvar);
		buttonBuscar.setOnAction(eventoBuscar);
		buttonRemover.setOnAction(eventoRemover);

		//Adição de todos os layout individuais no Layout da GUI do cadastro do hóspede
		layoutCadHotel.getChildren().addAll(layoutNome, layoutEndereco, layoutCPF, layoutRG, layoutIdade, layoutSexo, layoutQuartos, layoutSituacao, layoutBotoes);

		//Criação da cena da GUI do cadastro do hóspede
		Scene cena = new Scene(layoutCadHotel);
		palco.setScene(cena);

		//Título da GUI do cadastro do hóspede
		palco.setTitle("Cadastro de Hospede");
		//Execução da Gui do cadastro do hóspede
		palco.show();

	}

	/**
	 * Método Principal que executará o JavaFX
	 * 
	 */
	public static void main(String[] args) {
		launch();

	}


	/**
	 * Método que salvará as informações do hóspede no HashMap
	 * @param mapaHospede Recebe o HashMap para armazenar os dados do hóspede
	 * @param nomeH Recebe o TextField com o nome do hóspede
	 * @param enderecoH Recebe o TextField com o endereço do hóspede
	 * @param cpfH Recebe o TextField com o CPF do hóspede
	 * @param rgH Recebe o TextField com o RG do hóspede
	 * @param idadeH Recebe o TextField com a idade do hóspede
	 * @param nQuarto Recebe o ComboBox com a seleção do quarto do hóspede
	 * @param sexoMH Recebe o RadioButton com a seleção do sexo masculino do hóspede
	 * @param sexoFH Recebe o RadioButton com a seleção do sexo feminino do hóspede
	 */
	public static void salvar(HashMap<String, ArrayList<String>> mapaHospede, TextField nomeH, TextField enderecoH, TextField cpfH, TextField rgH, TextField idadeH, ComboBox<Integer> nQuarto, RadioButton sexoMH, RadioButton sexoFH) {

		//Cria as instâncias das classes Hospede e Quarto
		Hospede hospede = new Hospede();
		Quarto quarto = new Quarto(0, hospede);
		//Cria as variáveis cpfHospede, rgHospede e idadeHospede para serem convertidas nos respectivos tipos que foram definidas na classe Hóspede
		Long cpfHospede = null;
		Long rgHospede;
		int idadeHospede;

		try {
			//Conversão dos valores
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

		//Bloco catch que verifica se os valores convertidos foram somentes números
		}catch(NumberFormatException nfe){
			System.err.println("Erro ao informar os dados. Informe somente números. Erro: "+nfe.getMessage());
		}

		//Criação do ARRAYLIST com os dados do hóspede
		ArrayList <String> dadosHospede = new ArrayList<String>();
		//Adição das informações do hospede no ARRAYLIST
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

		//Informa mensagem que o hóspede foi cadastrado com sucesso
		JOptionPane.showMessageDialog(null,"Hospede cadastrado com sucesso!!");

	}

	/**
	 * Método que busca as informações do cliente inserido no HashMap e coloca os dados do cliente nos respectivos campos
	 * da janela.
	 * @param nomeH Recebe o TextField com o nome do hóspede
	 * @param enderecoH Recebe o TextField com o endereço do hóspede
	 * @param cpfH Recebe o TextField com o CPF do hóspede
	 * @param rgH Recebe o TextField com o RG do hóspede
	 * @param idadeH Recebe o TextField com a idade do hóspede
	 * @param nQuarto Recebe o ComboBox com a seleção do quarto do hóspede
	 * @param sexoMH Recebe o RadioButton com a seleção do sexo masculino do hóspede
	 * @param sexoFH Recebe o RadioButton com a seleção do sexo feminino do hóspede
	 */
	public static void buscar(HashMap<String, ArrayList<String>> mapaHospede, TextField nomeH, TextField enderecoH, TextField cpfH, TextField rgH, TextField idadeH, ComboBox<Integer> nQuarto, RadioButton sexoMH, RadioButton sexoFH) {

		//Solicita o CPF para buscar
		String cpfHStrBuscar = JOptionPane.showInputDialog(null, "Informe o CPF do hospede para buscar: ");

		/* Criação da variável nomeClienteBuscado que servirá como parâmetro para verificar se o CPF informado encontra-se na base
		 * A variável armazenará a informação do nome do hóspede
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
				//Condição que verificará se o valor dentro do ARRAYLIST é igual ao CPF informado
				if (value.get(i).equals(cpfHStrBuscar)) {
					//Seta os campos com os valores armazenados para edição e possivel modificação dos dados
					cpfH.setText(value.get(0));
					cpfH.setEditable(false); //O campo CPF fica inalterável devido ser um campo usado como chave para o HashMap e consequentemente encontrar os dados do hóspede
					rgH.setText(value.get(1));
					nomeH.setText(value.get(2));
					idadeH.setText(value.get(3));
					enderecoH.setText(value.get(4));
					nQuarto.setValue(Integer.valueOf(value.get(5)));
					//Condições que verificação qual dos campos: M ou F estavam marcados na hora do armazenamento e retorna os valores
					if(value.get(6).equals("M")) {
						sexoMH.setSelected(true);
					}else if (value.get(6).equals("F")) {
						sexoFH.setSelected(true);
					}
					//Armazena a informação do nome do cliente na variável nomeClienteBuscado
					nomeClienteBuscado = value.get(2);
				}
			}
		}

		/* Se a variável nomeClienteBuscado continua com valor "null", ou seja, não for encontrado nenhum cliente com o CPF informado, é mostrado uma
		 * mensagem de erro informado que nenhum cliente foi encontrado com CPF informado
		 */
		if (nomeClienteBuscado == null) {
			JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado com o CPF "+cpfHStrBuscar+" informado", "Alerta", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Método que recebe o HashMap e o cpf informado para remoção dos dados do hóspede
	 * @param mapaHospede HashMap com os dados do hóspede
	 * @param cpfH CPF informado para buscar as informações do hóspede e posterior remoção
	 */
	public static void remover(HashMap<String, ArrayList<String>> mapaHospede, TextField cpfH) {

		/* Criação da variável nomeClienteBuscado que servirá como parâmetro para verificar se o CPF informado encontra-se na base
		 * A variável armazenará a informação do nome do hóspede
		 */
		 
		String nomeClienteBuscado = null;

		//O laço for varre o HashMap em busca da chave e armazena na variável "chave"
		for (Map.Entry<String, ArrayList<String>> chave : mapaHospede.entrySet()) {
			//Verifica se a chave é igual ao CPF informado para busca
			if(chave.getKey().equals(cpfH.getText())) {
				//Se a condição do IF acima for verdadeira, cria-se um ARRAYLIST e armazena-se dentro dele os dados do hóspede presente no HashMap
				ArrayList<String> value = mapaHospede.get(cpfH.getText());
				//Verifica se o primeiro valor armazenado no ARRAYLIST do HashMap (onde fica armazenado o cpf do hóspede) é igual ao CPF informado
				if (value.get(0).equals(cpfH.getText())) {
					//Informa ao usuário que foi encontrado o cliente com o CPF informado e que os dados dele serão removidos do HashMap
					JOptionPane.showMessageDialog(null,"O cliente "+value.get(2)+ " portador do CPF "+value.get(0)+" foi removido da base");
					//Armazena a informação do nome do cliente na variável nomeClienteBuscado
					nomeClienteBuscado = value.get(2);
				}
			}

		}

		//Remove os dados do cliente 
		mapaHospede.remove(cpfH.getText());

		/* Se a variável nomeClienteBuscado continua com valor "null", ou seja, não for encontrado nenhum cliente com o CPF informado, é mostrado uma
		 * mensagem de erro informado que nenhum cliente foi encontrado com CPF informado
		 */
		
		if (nomeClienteBuscado == null) {
			JOptionPane.showMessageDialog(null, "Cliente ainda não se encontra cadastrado!", "Alerta", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Método que recebe os campos TextField, ComboBox, RadioButton e CheckBox e limpa os valores que foram preenchidos pelo usuário
	 * @param nomeH Recebe o TextField com o nome do hóspede
	 * @param enderecoH Recebe o TextField com o endereço do hóspede
	 * @param cpfH Recebe o TextField com o CPF do hóspede
	 * @param rgH Recebe o TextField com o RG do hóspede
	 * @param idadeH Recebe o TextField com a idade do hóspede
	 * @param quartoH Recebe o ComboBox com a seleção do quarto do hóspede
	 * @param sexoMH Recebe o RadioButton com a seleção do sexo masculino do hóspede
	 * @param sexoFH Recebe o RadioButton com a seleção do sexo feminino do hóspede
	 * @param checkInH Recebe o CheckBox com a seleção do checkin do hóspede
	 * @param checkOutH Recebe o CheckBox com a seleção do checkout do hóspede
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
	 * Método que verifica se o nome inserido correspende aos padrões definidos: Somente letras (maiusculas e/ou minusculas),
	 * vogais com acentos agudos (´) e/ou tis (~), e também o cedilha (maiusculo ou minusculo)
	 * @since 22/12/2019
	 * @param nome Recebe como parâmetro o nome do hóspede
	 * @return Retorna "true", caso o nome inserido do hóspede está dentro dos padrões estabelecidas; retorna "false", 
	 * caso o nome inserido esteja fora dos padrões estabelecidos
	 */
	public static boolean verificaNome(String nome) {
		//Inicializa a variável "valido" como true
		boolean valido = true;

		/* Usado o método replaceAll para substitui todos os caracteres passados no primeiro parâmetro pelos caracteres 
		 * passados no segundo parâmetro, ou seja, no primeiro parâmetro do replaceAll() estamos dizendo que tudo que for espaço deve 
		 * ser substituído por nada (na verdade, só está retirando os espaços do nome passado para o método)
		 */
		nome = nome.replaceAll(" ", "");

		/* Condição que testará o nome passado para o método: Se o nome não contiver letras maiusculase/ou minusculas, 
		 * vogais com acentos agudos (´) e/ou tis (~), e também o cedilha (maiusculo ou minusculo), então o nome está correto, ou seja, 
		 * exclui caracteres especiais, vírgula, ponto, barra e números como letras válidas para compor o nome do hóspede (devido 
		 * se tratar de uma String e aceitar esses tipos)
		 */
		if(!nome.matches("[a-zA-Z\\á-úÁ-Ú\\ã-õÃ-Õ\\çÇ]*")){
			//Retorna o valor "false" se nome estiver fora das parâmetros corretos
			valido = false;
		}

		//Retorna o valor "true" se nome estiver dentro das parâmetros corretos
		return valido;
	}
}
