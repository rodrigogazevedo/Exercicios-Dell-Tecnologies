package br.dell.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * Classe principal que ir� criar os Objetos Hospede e Quarto para armazenamento dos dados
 * do hospede e seu respectivo quarto
 * @author Rodrigo Guimar�es de Azevedo
 * @version 3
 */
public class Principal {

	/**
	 * M�todo Principal
	 * @since 22/12/2019 Cria��o do Mapa para mapear chave (cpf) com o valor (nome) para busca das informa��es do h�spede
	 * 
	 */
	public static void main(String[] args){
		//Declara��o das vari�veis usadas para armazenar as informa��es do H�spede
		String cpfHStr, rgHStr, nomeH, idadeHStr, enderecoH, cpfHStrBuscar;
		Long cpfH = null, rgH;
		int idadeH = 0;
		boolean check = true;
		
		//Cria��o da inst�ncia da classe Hospede
		Hospede hospede = new Hospede();

		//Tratamento de exce��es
		try { 
			//Obten��o das informa��es do hospede atrav�s de janelas
			cpfHStr = JOptionPane.showInputDialog(null, "Informe o CPF do hospede");
			cpfH = Long.parseLong(cpfHStr);
			rgHStr = JOptionPane.showInputDialog(null, "Informe o RG do hospede");
			rgH = Long.parseLong(rgHStr);

			/* La�o de itera��o para a inser��o da informa��o do nome do hospede
			 * Ap�s a inser��o do nome, � acionado o m�todo verificaName que checar� se o nome
			 * inserido � v�lido ou n�o, de acordo com parametros definidos na fun��o.
			 * Se o nome foi inv�lido � gerado uma mensagem de erro e solicitado novamente a 
			 * inser��o do nome do usu�rio.
			 * Se o nome foi v�lido sai da itera��o e continua a execu��o do programa
			 */
			do{
				nomeH = JOptionPane.showInputDialog(null, "Informe o nome do hospede");
				if (verificaNome(nomeH) == false) {
					JOptionPane.showMessageDialog(null,"Nome do hospede est� incorreto");
					check = true; //vari�vel mantida como true para repetir a itera��o - nome informado incorretamente
				}else {
					check = false; //vari�vel alterada para false para sair da itera��o - nome informado corretamente
				}
			}while (check == true);
			
			//Obten��o das outras informa��es do hospede atrav�s de janelas
			idadeHStr = JOptionPane.showInputDialog(null, "Informe a idade do hospede");
			idadeH = Integer.parseInt(idadeHStr);
			enderecoH = JOptionPane.showInputDialog(null, "Informe o endere�o do hospede");

			//Envia as informa��es repassadas para a Classe Hospede
			hospede.setCPF(cpfH);
			hospede.setRG(rgH);
			hospede.setNome(nomeH);
			hospede.setIdade(idadeH);
			hospede.setEndereco(enderecoH);

			//Imprime mensagem de sucesso ao inserir os dados
			JOptionPane.showMessageDialog(null,"Hospede cadastrado com sucesso!!");

			//Obten��o das informa��es do quarto do hospede atrav�s de janelas
			String quartoHospedeStr = JOptionPane.showInputDialog("Informe o n�mero do quarto do hospede");
			int quartoHospede = Integer.parseInt(quartoHospedeStr);
			
			//Envia as informa��es repassadas para a Classe Quarto
			Quarto quarto = new Quarto(quartoHospede, hospede);
			
			/* Eu optei por usar o mapa pois favorece a busca dos dados do hospede passando como par�metro o CPF do mesmo.
			 * Assim, eu mapeei o cpf - chave - com um ARRAYLIST - valor - para facilitar a recupera��o das informa��es do hospede e
			 * do quarto em que ele est� hospedado
			 */
			HashMap<String, ArrayList<String>> mapaHospede = new HashMap<>();
			
			//Cria��o do ARRAYLIST com os dados do h�spede
			ArrayList <String> dadosHospede = new ArrayList<String>();
			//Adi��o das informa��es do hospede no ARRAYLIST
			dadosHospede.add(String.valueOf(cpfH));
			dadosHospede.add(String.valueOf(rgH));
			dadosHospede.add(nomeH);
			dadosHospede.add(String.valueOf(idadeH));
			dadosHospede.add(enderecoH);
			dadosHospede.add(String.valueOf(quarto.getNumero()));
			
			//Adiciona a chave - CPF - com o value - ARRAYLIST - no HashMap
			mapaHospede.put(String.valueOf(cpfH), dadosHospede);
			
			//Solicita um cpf para localizar
			cpfHStrBuscar = JOptionPane.showInputDialog(null, "Informe o CPF do hospede para buscar: ");

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
						//Informa os dados do h�spede numa janel JOptionPane
						JOptionPane.showMessageDialog(null,"Dados do hospede\n"
								+ "\nNome: "+value.get(2)
								+ "\nRG: "+value.get(1)
								+ "\nCPF: "+value.get(0)
								+ "\nIdade: "+value.get(3)
								+ "\nEndereco: "+value.get(4)
								+ "\nQuarto: "+value.get(5));
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
		
		catch(NumberFormatException nfe){
			System.err.println("Erro ao informar os dados. Informe somente n�meros. Erro: "+nfe.getMessage());
		}


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