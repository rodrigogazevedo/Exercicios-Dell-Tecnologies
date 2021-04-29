package com.dell.lead;

import java.util.HashMap;
import java.util.Map;
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
		Long cpfH = null, rgH, cpfHBuscar;
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
			 * Assim, eu mapeei o cpf - chave - com a nome - valor - para facilitar a recupera��o das informa��es do hospede e
			 * do quarto em que ele est� hospedado
			 */
			Map<Long, String> mapaHospede = new HashMap<Long, String>();
			mapaHospede.put(cpfH, nomeH);
			
			cpfHStrBuscar = JOptionPane.showInputDialog(null, "Informe o CPF do hospede para buscar: ");
			cpfHBuscar = Long.parseLong(cpfHStrBuscar);
			
			//Passa a chave - CPF - para localizar o valor - nome - do hospede atrelado a ela
			String nomeClienteBuscado = mapaHospede.get(cpfHBuscar);
			//Testa a condi��o para saber se existe algum hospede com o CPF informado
			if (nomeClienteBuscado != null)
				//Mostra em uma janela as informa��es do hospede armazenadas se encontrar o CPF informado
				JOptionPane.showMessageDialog(null,"Dados do hospede\n"
						+ "\nNome: "+hospede.getNome()
						+ "\nRG: "+hospede.getRG()
						+ "\nCPF: "+hospede.getCPF()
						+ "\nIdade: "+hospede.getIdade()
						+ "\nEndereco: "+hospede.getEndereco()
						+ "\nQuarto: "+quarto.getNumero());
			else
				//Mostra uma mensagem de alerta que n�o encontrou o hospede com o CPF informado
				JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado com o CPF "+cpfHBuscar+" informado", "Alerta", JOptionPane.ERROR_MESSAGE);

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